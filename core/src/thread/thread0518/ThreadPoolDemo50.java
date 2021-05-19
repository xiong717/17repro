package thread.thread0518;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/*
* 创建可以执行定时业务的线程池
*
* */
public class ThreadPoolDemo50 {
    public static void main(String[] args) {
        //创建执行定时任务的线程池
       ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
        System.out.println("设置任务" + new Date());
       //执行定时任务
        /*scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("执行任务 " + new Date());
            }
        },1,3, TimeUnit.SECONDS);*/
        //scheduleAtFixedRate 以上次任务的开始时间，作为下一次任务的开始时间的

        /*scheduledExecutorService.schedule(new Runnable() {
            @Override
            public void run() {

            }
        },1,TimeUnit.SECONDS);*/


        scheduledExecutorService.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("执行任务" + new Date());
            }
        },1,3,TimeUnit.SECONDS);
        //scheduleWithFixedDelay 以上次任务 的 结束时间 作为下一次任务的开始时间的
    }
}
