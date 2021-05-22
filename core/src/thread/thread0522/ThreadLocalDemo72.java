package thread.thread0522;

import sun.nio.ch.ThreadPool;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/*
* withinitial方法 的简单使用 JDK8以上可以使用
* */
public class ThreadLocalDemo72 {
    //withInitial 简单初始化ThreadLocal版本 JDK8以上可以使用
    private static ThreadLocal<String> threadLocal = ThreadLocal.withInitial(()->"java");
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1,1,0, TimeUnit.SECONDS
        ,new LinkedBlockingDeque<>(1000));

        executor.submit(new Runnable() {
            @Override
            public void run() {
                String ret = threadLocal.get();
                System.out.println("得到结果 " + ret );
            }
        });

        executor.submit(new Runnable() {
            @Override
            public void run() {
                String ret = threadLocal.get();
                System.out.println("得到结果 " + ret );
            }
        });
    }
}
