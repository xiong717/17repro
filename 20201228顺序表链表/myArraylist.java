import java.util.Arrays;

public class myArraylist{
    private int[] elem;
    private int usedsize;

    //构造函数初始化
    public myArraylist() {
        this.elem = new int[5];
    }

    public myArraylist(int capacity) {
        this.elem = new int[capacity];
    }

    //打印顺序表
    public void display() {
        for (int i =0; i< this.usedsize; i++) {
            System.out.print(this.elem[i]+" ");
        }
        System.out.println();
    }
    //顺序表扩容
    public void reize() {
        this.elem =
                Arrays.copyOf(this.elem,this.elem.length*2);
    }
    //在pos位置新增元素
    //思路 1.顺序表是否为full 2.POS位置是否合法 3.插入数据的时候，这个位置前一定要有数据
    public boolean isFull() {
        if (this.usedsize == this.elem.length) {
            return true;
        }
        return false;
    }
    public void add(int pos,int data) {
        //顺序表是否满
          if (isFull()) {
              /*System.out.println("顺序表为满！");
              return;
               */
              reize();
          }
          //POS位置是否合法
          if (pos<0 || pos>this.usedsize) {
              System.out.println("pos位置不合法！");
              return;
          }
          //移动元素
        for (int i = this.usedsize-1; i>=pos;i--) {
            this.elem[i+1] = this.elem[i];
        }
        this.elem[pos] = data;
        this.usedsize++;
    }
    //默认插到数组的最后
    public void add2(int data) {
        //顺序表是否满
        if (isFull()) {
           /* System.out.println("顺序表为满！");
            return;
            */
            reize();
        }
        this.elem[this.usedsize] = data;
        this.usedsize++;
    }

    //判断是否包含某个元素
    public boolean contains(int tofind) {
        for (int i=0; i<this.usedsize; i++) {
            if (this.elem[i] == tofind) {
                return true;
            }
        }
        return false;
    }

    //获取顺序表长度
    public int size() {
        return this.usedsize;
    }
    //清空顺序表
    public void clear() {
        this.usedsize = 0;
        //因为 放元素就是在usedsize位置
    }

    //查找某个元素的位置
    public int research(int tofind) {
        for (int i =0;i< this.usedsize;i++) {
            if (this.elem[i] == tofind) {
                return i;
            }
        }
        return -1;
    }

    //获得POS位置的元素
    public int getpos(int pos) {
        if (pos<0||pos >= this.usedsize) {
            return -1;
        }
        for (int i =0; i< this.usedsize-1;i++) {
            System.out.println(this.elem[pos]);
        }
        return -1;
    }
    //给POS位置的元素设为vaule
    public void setpos(int pos,int vaule) {
        if (pos<0||pos >= this.usedsize) {
            System.out.println("pos位置不合法");
            return;
        }
            this.elem[pos] = vaule;
    }

    //删除第一次出现的关键字key
    //思路 查找是否有key index  赋值 this.usedsize--
    public void remove(int key) {
        int index = research(key);
        if (index == -1) {
            System.out.println("没有");
            return;
        }
        for (int i = index;i < usedsize-1;i++) {
           this.elem[i] = this.elem[i+1];
        }
        this.usedsize--;
    }






}
