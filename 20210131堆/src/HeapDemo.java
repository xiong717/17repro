import com.sun.xml.internal.stream.buffer.AttributesHolder;

import java.util.Arrays;

public class HeapDemo {
    public int[] elem;
    public int usedsize;
    public HeapDemo(){
        this.elem = new int[10];
    }
    //创建一个大堆 向下调整 从当前树的每一个子树开始向下调整
    //时间复杂度 log2n
    public void adjustDown(int parent,int len){
        int child = 2*parent+1;
        //child < len 说明有左孩子
        while (child<len){
            //child+1<len 判断是否有右孩子 防止越界
            if (child+1 < len && this.elem[child]<this.elem[child+1]){
                child++;
            }//child下标 一定是左右孩子的最大值
            if (this.elem[child] > this.elem[parent]){
                int tmp = this.elem[child];
                this.elem[child] = this.elem[parent];
                this.elem[parent] = tmp;
                parent = child;
                child = 2*parent+1;
            }else {
                //因为是从最后一棵树开始调整的  只要我们 找到了这个
                // this.elem[child] <= this.elem[parent]   后续就不需要循环了
                //后面的都已经是大根堆了
                break;
            }
        }
    }

    public void shiftDown(int parent, int len){
        int child = 2*parent+1;
        while (child <len){
            if (child+1<len && this.elem[child] > this.elem[child+1]){
                child++;
            }
            if (this.elem[child]<this.elem[parent]){
                int tmp = this.elem[child];
                this.elem[child] = this.elem[parent];
                this.elem[parent] = tmp;
                parent = child;
                child = 2*parent+1;
            }else {
                break;
            }
        }
    }

    //建立大根堆 时间复杂度是O(n*log2 n) 实际复杂度是O(n)
    public void creatBigHeap(int[] array){
        for (int i = 0; i <array.length ; i++) {
            this.elem[i] = array[i];
            this.usedsize++;
        }
        //elem中已经存放了元素 parent = (child -1)/2
        for (int i = (this.usedsize-1-1)/2; i >=0 ; i--) {
            adjustDown(i,this.usedsize);
        }
    }

    public void createSmallHeap(int[] array){
        for (int i = 0; i < array.length ; i++) {
            this.elem[i] = array[i];
            this.usedsize++;
        }
        for (int i = (this.usedsize-1-1)/2; i >=0 ; i--) {
            shiftDown(i,this.usedsize);
        }
    }

    //向上调整
    public  void adjustUP(int child){
        int parent =(child-1)/2;
        while (child>0){
            if (this.elem[child] > this.elem[parent]){
                int tmp = this.elem[child];
                this.elem[child] = this.elem[parent];
                this.elem[parent] = tmp;
                child = parent;
                parent = (child-1)/2;
            }else {
                break;
            }
        }
    }
    /**
     * 逻辑：放到数组的最后一个位置
     * 然后向上调整
     */
    public void push(int val) {
        if(isFull()) {
            this.elem =
                    Arrays.copyOf(this.elem,2*this.elem.length);
        }
        this.elem[this.usedsize] = val;
        this.usedsize++;//11

        adjustUP(this.usedsize-1);

    }

    public int poll(){
        if (isEmpty()){
            throw  new RuntimeException("队列为空");

        }
        int ret = this.elem[0];
        int tmp = this.elem[0];
        this.elem[0] = this.elem[this.usedsize-1];
        this.elem[this.usedsize-1] = tmp;
        this.usedsize--;
        adjustDown(0,this.usedsize);
        return ret;
    }

    public  int peek(){
        if (isEmpty()){
            throw new RuntimeException("队列为空！");

        }
        return this.elem[0];
    }

    public boolean isEmpty(){
        return  this.usedsize == 0;
    }

    public boolean isFull(){
        return this.usedsize == this.elem.length;
    }

    public void show(){
        for (int i = 0; i < this.usedsize; i++) {
            System.out.print(this.elem[i]+" ");
        }
        System.out.println();
    }
}
