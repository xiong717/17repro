package thread.thread0426;
/*
* 一辆出租车 张三和李四轮流开 张三上班时 李四下班
* */
public class TestDemo21 {
    public static void main(String[] args) throws InterruptedException {
        //定义统一的任务
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                String threadname = Thread.currentThread().getName();
                System.out.println(threadname+"上班");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(threadname+"下班");
            }
        };
        Thread t1 = new Thread(runnable,"张三");
        t1.start();

        //等待线程 t1执行完后 在执行t2 参数最大等待时间
        t1.join(1200);

        Thread t2 = new Thread(runnable,"李四");
        t2.start();
    }
}
