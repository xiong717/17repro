package thread.thread0522;

public class ThreadLocalDemo68 {
    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        //定义公共任务
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                //得到线程名称
                String tname = Thread.currentThread().getName();
                System.out.println(Thread.currentThread().getName()+" 设置值 "+tname);
                //设置 Threadlocal
                threadLocal.set(tname);
                printLocal();
            }
        };

        Thread t1 = new Thread(runnable,"t1");
        t1.start();
        Thread t2 = new Thread(runnable,"t2");
        t2.start();
    }

    private static void printLocal() {
        //
        String result = threadLocal.get();
        System.out.println(Thread.currentThread().getName()+" 得到值 "+result);
    }
}
