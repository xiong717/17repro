import java.util.LinkedList;
import java.util.Queue;

/*
* 队列
* */
public class TestDemoqueue1 {
    public static void main(String[] args) {
        //queue 是一个普通队列
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        /* queue源码 调用linkedlist的add方法 是尾插法 因为queue.方法没有addfirs和addLast
        * public boolean add(E e) {
        linkLast(e);
        return true;
    }
        * */

        queue.offer(12);
        queue.offer(13);
        queue.offer(90);
        System.out.println(queue);
        System.out.println(queue.poll());//删除
        System.out.println(queue.peek());
        /*
        queue中的offer方法  调用linkedlist的 offer方法
        如果队列已满 add方法会抛出异常，offer只是返回true或false
        public boolean offer(E e) {
        return add(e);
        }
    */
       /* LinkedList<String> linkedList = new LinkedList<>();
        linkedList.addFirst("a");
        linkedList.addLast("q");*/

    }
}
