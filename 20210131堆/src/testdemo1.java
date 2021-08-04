import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class testdemo1 {

    //找前K个最大的元素
    public static void topkmax(int[] array,int k){
        //1. 建立大小为k的 小堆
        PriorityQueue<Integer> minheap = new PriorityQueue<>(k,
                new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {

                        return o1-o2;//小堆
                    }
                });
        //2. 遍历数组
        for (int i = 0; i < array.length ; i++) {
            if (minheap.size() <k){
                minheap.offer(array[i]);
            }else {
                int top = minheap.peek();
                //小堆的堆顶top 是前k个最大元素中 最小的 元素
                if (top < array[i]){
                    minheap.poll();//弹出堆顶
                    minheap.offer(array[i]);
                }
            }
        }
        for (int i = 0; i < k ; i++) {
            System.out.print(minheap.poll()+" ");
        }
    }
    // 找前k个最小的元素
    public static void topkmin(int[] array,int k){
        //建立大小为 k 的大堆
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        //遍历数组
        for (int i = 0; i < array.length; i++) {
            if (maxheap.size()<k){
                maxheap.offer(array[i]);
            }else {
                int top = maxheap.peek();
                if (top > array[i]){
                    maxheap.poll();
                    maxheap.offer(array[i]);
                }
            }
        }
        for (int i = 0;i < k;i++){
            System.out.print(maxheap.poll()+" ");
        }
    }

    //找第k小的元素， 思路： 建立大小为k的 大堆 等数组遍历完成后，堆顶的元素就是第k小的元素


    //堆排序 从小到大排序，建立大堆
    private static void createbigheap(int[] array) {
        for (int i =( array.length-1-1)/2; i >=0; i--) {
            adjustdown(array,i,array.length);
        }
    }

    private static void adjustdown(int[] array, int parent, int length) {
        int child = 2*parent+1;
        while (child>length){
            if (child+1<length&& array[child]<array[child+1]){
                child++;
            }
            if (array[child] >array[parent]){
                int tmp = array[child];
                array[child] = array[parent];
                array[parent] = tmp;
                parent = child;
                child = 2*parent+1;
            }else {
                break;
            }
        }
    }
    public static void heapsort2(int[] array){
        createbigheap(array);
        int end = array.length-1;
        while (end>0){
            int tmp = array[0];
            array[0]= array[end];
            array[end] = tmp;
            adjustdown(array,0,end);
            end--;
        }
    }





    public static void main(String[] args) {
        int[] array ={27,15,19,18,28,34,65,49,25,37};
        Arrays.sort(array);
        for (int i = 0; i <array.length ; i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println();
        topkmin(array,3);
        System.out.println();
        topkmax(array,3);
        System.out.println();
        heapsort2(array);//堆排序
        System.out.print(Arrays.toString(array));
    }
}
