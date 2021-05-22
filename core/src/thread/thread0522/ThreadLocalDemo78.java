package thread.thread0522;
/*
* 不可继承的解决方案：InheritableThreadLocal
* 即使使用了InheritableThreadLocal 也不能实现 并列线程 之间的数据传递（数据设置和获取）
* */
public class ThreadLocalDemo78 {
    private static ThreadLocal threadLocal = new InheritableThreadLocal();

    public static void main(String[] args) throws InterruptedException{

        threadLocal.set("java");

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                threadLocal.set("java");
                System.out.println("线程1 设置值 "+threadLocal.get());
            }
        });
        t1.start();
        t1.join();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程2 获取值 "+threadLocal.get());
            }
        });
        t2.start();

    }
}
