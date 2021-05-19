package thread.thread0518;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
* 创建线程有七种写法 两种方式
* 第一种写法
* */
public class ThreadPoolDemo47 {
    public static void main(String[] args) {
        //创建一个固定个数的线程池
       ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 2 ; i++) {
            //执行任务
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("线程名：" + Thread.currentThread().getName());
                }
            });
        }
    }
}
