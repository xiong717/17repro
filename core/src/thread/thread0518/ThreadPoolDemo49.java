package thread.thread0518;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
/*
* 自定义线程池规则
*
*
* */
public class ThreadPoolDemo49 {
    public static void main(String[] args) {
        MyThreadFactory threadFactory = new MyThreadFactory();
       ExecutorService executorService =  Executors.newFixedThreadPool(10,threadFactory);
        for (int i = 0; i < 10; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    Thread thread = new Thread();
                    System.out.println("线程名：" + thread.getName()+"优先级" + thread.getPriority());
                }
            });
        }
    }

    private static int count = 1;
    static class MyThreadFactory implements ThreadFactory{

        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(r);
            //自定义线程的名称规则
            thread.setName("mythreadpool" + count++);
            thread.setPriority(10);
            return thread;
        }
    }
}
