package thread.thread0424;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 演示线程分组
 */
public class TestDemo10 {
    public static void main1(String[] args) {
        ThreadGroup threadGroup = new ThreadGroup("跑步比赛");
        Thread t1 = new Thread(threadGroup, new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    System.out.println("选手1 到达了终点！");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();

        Thread t2 = new Thread(threadGroup, new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1200);
                    System.out.println("选手2 到达了终点！");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t2.start();

        //等待所有线程执行完
        while (threadGroup.activeCount()!=0) {

        }
        System.out.println("比赛结束");


    }

    //例子不是很恰当
    //执行次数
    private static final int count=1000;

    //线程公共任务 执行了1000次循环
    static class Mycallable2 implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            int a = 0;
            for (int i = 0; i < count ; i++) {
                a++;
            }
         return a;
        }

    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //创建一个线程分组
        ThreadGroup threadGroup = new ThreadGroup("计算线程");
        Mycallable2 mycallable2 = new Mycallable2();

        //创建线程1,并把线程设置到分组中
        FutureTask<Integer> futureTask1 = new FutureTask<>(mycallable2);
        Thread t1 = new Thread(threadGroup,futureTask1,"任务一");
        t1.start();

        //创建线程2,并把线程设置到分组中
        FutureTask<Integer> futureTask2 = new FutureTask<>(mycallable2);
        Thread t2 = new Thread(threadGroup,futureTask2);
        t2.setName("任务二");
        t2.start();

        //打印线程的所有信息
        threadGroup.list();

        //等待线程分组中所有线程执行完  activeCount活跃的线程数
        while (threadGroup.activeCount()!=0) {
        }
        int total = futureTask1.get()+futureTask2.get();//1000+1000=2000
        System.out.println("执行结果："+total);
    }

}
