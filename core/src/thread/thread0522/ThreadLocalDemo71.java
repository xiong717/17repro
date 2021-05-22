package thread.thread0522;

import java.util.function.Supplier;
/*
* threadLocal 的 withInitial方法  在Thread线程中 使用
* withinitial 随着线程 里面的调用 调用threadLocal几次 withinitial方法执行几次
* threadLocal 的 withInitial方法  在线程池中 使用
* withinitial 在线程池中 只执行了一次 线程池中 两个线程执行的结果一致
*
* */
public class ThreadLocalDemo71 {

    private static ThreadLocal<String> threadLocal = ThreadLocal.withInitial(new Supplier<String>() {
        @Override
        public String get() {
            System.out.println("执行了 withInitial 方法");
            return Thread.currentThread().getName()+"java";
        }
    });
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                String ret = threadLocal.get();
                System.out.println("线程1 获取到的内容 "+ret);
            }
        },"线程1");
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                String ret = threadLocal.get();
                System.out.println("线程2 获取到的内容 "+ret);
            }
        },"线程2");
        t2.start();
    }
}
