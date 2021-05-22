package thread.thread0522;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadLocalDemo79 {
     static  ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1,1,0, TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(1000));
        for (int i = 0; i <2 ; i++) {
            executor.submit(new Runnable() {
                @Override
                public void run() {
                    MyThreadLocal myThreadLocal = new MyThreadLocal();
                    myThreadLocal.show();
                }
            });
        }

    }

    static class MyThreadLocal{
        private static boolean flag = false;
        public void show() {
            String tname = Thread.currentThread().getName();
            if (!flag){
                //第一次执行
                threadLocal.set("java");
                System.out.println(tname+" 设置了 "+tname);
                flag=true;
            }
            System.out.println(tname+" 得到了 "+threadLocal.get());
        }
    }
}
