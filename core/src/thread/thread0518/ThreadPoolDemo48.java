package thread.thread0518;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/*
* 线程创建写法二：创建带缓存的线程池
* 使用场景；短期内有大量
* */
public class ThreadPoolDemo48 {
    public static void main(String[] args) {
        //创建带缓存的线程池
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 100 ; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("线程名 " + Thread.currentThread().getName());
                }
            });
        }
    }


}
