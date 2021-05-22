package thread.thread0522;

import java.util.function.Supplier;

/*
* threadLocal中set方法
*
* 面试题： ThreadLocal 的初始化方法 在什么状况下不执行？
* ThreadLocal 在get方法时候 才进行调用初始化
*
* */
public class ThreadLocalDemo73 {

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
                threadLocal.set(Thread.currentThread().getName()+"mysql");
                String ret = threadLocal.get();
                System.out.println("线程1 获取到的内容 "+ret);
            }
        },"线程1");
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                threadLocal.set(Thread.currentThread().getName()+"mysql");
                String ret = threadLocal.get();
                System.out.println("线程2 获取到的内容 "+ret);
            }
        },"线程2");
        t2.start();
    }
}
