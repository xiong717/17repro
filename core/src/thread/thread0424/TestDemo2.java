package thread.thread0424;
/*
* 对比单线程和多线程之间的执行时间
* */
public class TestDemo2 {
    //定义循环次数
    private static final Long count = 10_0000_0000L;//十亿次

    public static void main(String[] args) throws InterruptedException {
        //调用单线程方法
        serial();
        //调用多线程的方法
        concurrency();
    }
    private static void serial() {
        //记录当前 开始时间   时间戳
        Long begin = System.currentTimeMillis();
        int a=0;
        for (int i=0;i<count;i++){
            a++;
        }
        int b=0;
        for (int i=0;i<count;i++){
            b++;
        }
        int c=0;
        for (int i=0;i<count;i++){
            c++;
        }
        //记录结束时间
        Long end = System.currentTimeMillis();
        System.out.println("单线程的执行时间 "+(end-begin));
    }

    private static void concurrency() throws InterruptedException {
        //记录当前开始时间 时间戳
        long begin = System.currentTimeMillis();
        //张三办理业务 （主线程）
        int a=0;
        for ( int i=0;i<count;i++) {
            a++;
        }
        //李四同时执行业务
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                int b=0;
                for (int i =0;i<count;i++) {
                    b++;
                }
            }
        });
        t1.start();//执行线程

        //王五执行业务
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                int c=0;
                for (int i=0;i<count;i++) {
                    c++;
                }
            }
        });
        t2.start();
        //需要等待子线程全部执行完
        t1.join();
        t2.join();
        //记录结束时间
        Long end = System.currentTimeMillis();
        System.out.println("多线程的执行时间是："+(end-begin));
    }


}
