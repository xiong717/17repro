import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class TestDemo {
    //建立了大根堆 向下调整
    public static void main(String[] args) {
        HeapDemo heapDemo = new HeapDemo();
        int[] array ={27,15,19,18,28,34,65,49,25,37};
        heapDemo.creatBigHeap(array);
        heapDemo.show();
        heapDemo.push(100);
        heapDemo.show();
    }
    //建立了小根堆 向下调整
    public static void main2(String[] args) {
        HeapDemo heapDemo = new HeapDemo();
        int[] array ={27,15,19,18,28,34,65,49,25,37};
        heapDemo.createSmallHeap(array);
        heapDemo.show();
    }

    public static void main3(String[] args) {
        /**
         * PriorityQueue  堆   优先级队列
         * PriorityQueue 底层 默认是一个小根堆
         * 每次存元素的时候  一定要保证 数据进入堆中后  依然可以维持为一个小堆
         * 每次取出一个元素的时候，一定要保证 剩下的元素 也要调整为一个小堆
         */
        PriorityQueue<Integer> qu = new PriorityQueue<>();
        qu.offer(100);
        qu.offer(2);
        qu.offer(3);
        qu.offer(40);

        System.out.println(qu.peek());
        System.out.println(qu.poll());
        System.out.println(qu.poll());
    }
   //自定义比较器 PriorityQueue默认是小堆 如果我就要是大堆呢
    public static void main5(String[] args) {
       PriorityQueue<Integer> qu = new  PriorityQueue<>(new Comparator<Integer>() {
           @Override
           public int compare(Integer o1, Integer o2) {
               return o2-o1;//大堆
           }
       });
        qu.offer(3);
        qu.offer(1);
        qu.offer(4);
        qu.offer(2);
        qu.offer(5);
        System.out.println(qu.poll());//1
        System.out.println(qu.poll());//2
        System.out.println(qu.poll());//3

    }
}
