package thread.thread0424;

public class TestDemo2 {
    private static final Long count = 10_0000_0000L;

    public static void main(String[] args) throws InterruptedException {
        concurrency();
        serial();
    }

    private static void concurrency() throws InterruptedException {
        long begin = System.currentTimeMillis();
        int a=0;
        for ( int i=0;i<count;i++) {
            a++;
        }
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                int b=0;
                for (int i =0;i<count;i++) {
                    b++;
                }
            }
        });
        t1.start();
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

        t1.join();
        t2.join();
        Long end = System.currentTimeMillis();
        System.out.println("多线程的执行时间是："+(end-begin));
    }

    private static void serial() {
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
        Long end = System.currentTimeMillis();
        System.out.println("单线程的执行时间 "+(end-begin));
    }

    /*private static final Long count = 10_0000_0000L;

    public static void main(String[] args) throws InterruptedException {
        // 调用多线程的方法
        concurrentcy();

        // 调用单线程
        serirl();
    }

    // 单线程方法
    private static void serirl() {
        // 当前的开始时间
        Long stime = System.currentTimeMillis();
        int a = 0;
        for (int i = 0; i < count; i++) {
            a++;
        }
        int b = 0;
        for (int i = 0; i < count; i++) {
            b++;
        }
        int c = 0;
        for (int i = 0; i < count; i++) {
            c++;
        }
        // 记录结束时间
        Long etime = System.currentTimeMillis(); // 得到当前毫秒时间戳
        System.out.println("单线程执行的时间是：" + (etime - stime));
    }

    // 多线程的方法
    private static void concurrentcy() throws InterruptedException {
        // 记录开始时间
        Long stime = System.currentTimeMillis();
        // 张三办理业务
        int a = 0;
        for (int i = 0; i < count; i++) {
            a++;
        }
        // 李四同时执行业务
        // 创建线程
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                int b = 0;
                for (int i = 0; i < count; i++) {
                    b++;
                }
            }
        });
        // 执行线程
        t1.start();
        // 王五执行业务
        // 创建新线程
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                int c = 0;
                for (int i = 0; i < count; i++) {
                    c++;
                }
            }
        });
        // 执行线程
        t2.start();

        // 需要等待子线程全部执行完
        t1.join(); // 等待 t1 线程执行完
        t2.join();  // 等待 t2 线程执行完

        // 记录执行时间
        Long etime = System.currentTimeMillis();
        System.out.println("多线程的执行时间是：" + (etime - stime));
    }*/
}
