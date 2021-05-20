package thread.thread0520;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/*
* 第七种方式 : 原始的线程池创建方式 ThreadPoolExecutor
*
* 1.  new ThreadPoolExecutor() 里面
* 参数1 核心线程的数量(线程池正常情况下数量)--正式员工的数量
  参数2 最大线程的数量(当有大量的任务时候 可以创建的最多的线程数)--临时工的数量
* 参数3 最大线程存活时间--临时工的存活时间
* 参数4 配合参数3一起使用的 时间单位
* 参数5 任务队列
* 参数6 线程工厂
* 参数7 拒绝策略
*
* 2. 注意事项 ： 最大线程数 必须大于或等于 核心线程数
* 3.线程池的五种拒绝策略:
* ThreadPoolExecutor.AbortPolicy() 默认拒绝策略，不执行任务抛出异常
* ThreadPoolExecutor.CallerRunsPolicy() 把当前任务交给主线程执行
* ThreadPoolExecutor.DiscardOldestPolicy() 丢弃最老的任务
* ThreadPoolExecutor.DiscardPolicy() 丢弃最新的任务 以上两个舍弃 使用LinkedBlockingQueue 可以按顺序执行任务
* 自定义拒绝策略 可以写到日志里，也可写到数据库，也可什么都不做
* 4. ThreadPoolExecutor执行流程 ： 核心线程数 最大线程数 任务队列
*  (1)
*  (2)当任务量大于线程数时候，并没有空闲线程时候，且当线程池的线程数
*  (3)当前任务量比较大时候，此时没有空闲的线程，并且任务队列已经满了，此时会判断 当前线程池的任务数量是否 大于等于 最大线程数
*     如果当前线程池的线程数量 小于 最大线程数，会创建线程来执行任务
*     如果当前线程池的线程数量 等于 最大线程数，并且任务队列已经满了，此时会执行拒绝策略
* 5.线程终止：
*   threadPoolExecutor.shutdown();//结束线程池
    threadPoolExecutor.shutdownNow();//立即终止线程池(线程池任务不会执行完)
  6.线程池状态 (线程状态不等于线程池状态)
*   private static final int RUNNING    = -1 << COUNT_BITS; 默认状态
    private static final int SHUTDOWN   =  0 << COUNT_BITS;
    private static final int STOP       =  1 << COUNT_BITS;
    private static final int TIDYING    =  2 << COUNT_BITS;消耗的前置状态，表示任务已经清空
    private static final int TERMINATED =  3 << COUNT_BITS;
  7.线程池执行的两种方式：
  * 1.执行任务 无 返回值
  * 2.执行任务有返回值 submit(Runnable 无返回值 / Callable 有返回值)
*
* */
public class ThreadPoolDemo55 {
    public    static int count = 0;
    public static void main(String[] args) {
        //创建线程工厂
        ThreadFactory threadFactory = new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                thread.setName("mythredpool- "+ count++);
                return null;
            }
        };
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10,10,
                60, TimeUnit.SECONDS,new LinkedBlockingDeque<>(100)
                ,threadFactory,new ThreadPoolExecutor.DiscardPolicy());
        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程名" + Thread.currentThread().getName());
            }
        });
        threadPoolExecutor.shutdown();//结束线程池
        threadPoolExecutor.shutdownNow();//立即终止线程池(线程池任务不会执行完)
    }

}
