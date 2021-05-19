package thread.thread0506;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


/*
死锁的示例 
* */
public class TestDemo36 {
    public static void main(String[] args) throws InterruptedException {
        //声明 加锁的资源
        Object lockA = new Object();
        Object lockB = new Object();

        //创建线程1 
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                //获取当前线程名称
                String threadname = Thread.currentThread().getName();
                //1.获取资源A(lockA)
                synchronized (lockA) {
                    //已经获取到lockA
                    System.out.println(threadname + " Get lockA");
                    try {
                        //休眠一秒
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(threadname + " waiting lockB");
                    synchronized (lockB) {
                        System.out.println(threadname+" get lockB");
                    }
                }
            }
        },"t1");


        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                //获取当前线程名称
                String threadname2 = Thread.currentThread().getName();
                //1.获取资源B(lock B)
                synchronized (lockB) {
                    System.out.println(threadname2+" get lockB");
                    // 2.休眠 1s（为了等待让 t1 先得到 lockA）
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //3.获取资源A
                    System.out.println(threadname2+" waiting lockA");
                    synchronized (lockA){
                        System.out.println(threadname2+" get lockA");
                }
                }
            }
        },"t2");

       
        t1.start();
        t2.start();
    }
}





/**
 * 死锁的示例
 */
/*public class TestDemo36 {
    public static void main(String[] args) {
        // 声明（加锁的）资源
        Object lockA = new Object();
        Object lockB = new Object();
        // 创建线程 1
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                // 获取当前线程名称
                String threadName = Thread.currentThread().getName();
                synchronized (lockA) {
                    // 已经获取到 lockA
                    System.out.println(threadName + " Get lockA.");
                    try {
                        // 休眠一秒
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(threadName + " Waiting lockB.");
                    synchronized (lockB) {
                        System.out.println(threadName + " Get lockB.");
                    }
                }
            }
        }, "t1");
        // 启动线程
        t1.start();

        // 创建线程 2
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                String threadName = Thread.currentThread().getName();
                // 1.获取资源 B（lockB）
                synchronized (lockB) {
                    System.out.println(threadName + " Get lockB.");
                    try {
                        // 2.休眠 1s（为了等待让 t1 先得到 lockA）
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(threadName + " Waiting lockA.");
                    // 3.获取资源 A（lockA）
                    synchronized (lockA) {
                        System.out.println(threadName + " Get lockA.");
                    }
                }
            }
        }, "t2");
        // 启动线程 t2
        t2.start();
    }
}*/

