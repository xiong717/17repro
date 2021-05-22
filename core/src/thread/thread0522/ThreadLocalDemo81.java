package thread.thread0522;

import javax.naming.ldap.PagedResultsControl;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadLocalDemo81 {

    private static ThreadLocal<MyThreadLocal> threadLocal = new ThreadLocal<>();
    static class MyThreadLocal{
        //创建一个大对象
        private byte[] bytes = new byte[1*1024*1024];
    }
    public static void main(String[] args) throws InterruptedException {
        //创建线程池
       /*ThreadPoolExecutor executor  = new ThreadPoolExecutor(10,10,0,
               TimeUnit.SECONDS,new LinkedBlockingDeque<>(1000));
        for (int i = 0; i <10 ; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                 threadLocal.set(new MyThreadLocal());
                    System.out.println(Thread.currentThread().getName() + "设置了值");
                }
            });
        }*/

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                threadLocal.set(new MyThreadLocal());
                System.out.println(Thread.currentThread().getName() + "设置了值");
            }
        };
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(runnable);
            t.start();
            Thread.sleep(100);
        }
    }
}
