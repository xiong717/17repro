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
    public static void main(String[] args) {
          int[] array ={27,15,19,18,28,34,65,49,25,37};
          topkmax(array,3);
        System.out.println();
          topkmin(array,3);
    }


}
