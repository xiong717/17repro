package thread.thread0520;

import java.util.Random;
import java.util.RandomAccess;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolDemo61 {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10,10,60, TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(100));
        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {

            }
        });

        threadPoolExecutor.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int num = new Random().nextInt(10);
                System.out.println("");
                return num;
            }
        });
        System.out.println("得到线程池的执行结果： " );
    }
}
