package thread.thread0426;
/*
* 出现了线程不安全问题
* 线程不安全的因素：
* 1,CPU是抢占式执行的
* 2，共同操作了一个变量
* 3，内存不可见
* 4，非原子性(++操作 不是一步完成的 要执行三步1.load 2.calc 3.save)、
* 5，编译器优化(在多线程中会出现混乱，从而导致线程不安全)
* */
public class TestDemo26 {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Thread t1 = new Thread(()->{
            counter.incrent();
        });
        t1.start();
        Thread t2 = new Thread(()->{
            counter.decrent();
        });
        t2.start();

        t1.join();
        t2.join();

        System.out.println("最终结果"+counter.getCount());
    }
}
