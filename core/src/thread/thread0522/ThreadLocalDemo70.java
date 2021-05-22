package thread.thread0522;

import java.util.Random;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/*
* threadLocal 的 initialValue 方法 在线程池中的 使用
*  initialvalue 方法 在线程池中只执行了一次 线程池中 两个线程执行的结果一致
 *
* */
public class ThreadLocalDemo70 {
    private static ThreadLocal<Integer> threadLocal = new ThreadLocal(){
        @Override
        protected Integer initialValue() {
            int num = new Random().nextInt(10);
            System.out.println(" 执行了 initialValue 方法 生成了 "+ num);
            return num ;
        }
    };

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1,1,0, TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(1000));
        executor.submit(new Runnable() {
            @Override
            public void run() {
               int ret = threadLocal.get();
                System.out.println(Thread.currentThread().getName()+" 得到结果1 "+ret);
            }
        });

        executor.submit(new Runnable() {
            @Override
            public void run() {
                int ret = threadLocal.get();
                System.out.println(Thread.currentThread().getName()+" 得到结果2 "+ret);
            }
        });
    }
}
