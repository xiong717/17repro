package thread.thread0522;
/*
* 不可继承的解决方案：InheritableThreadLocal
*
* */
public class ThreadLocalDemo77 {
    private static ThreadLocal threadLocal = new InheritableThreadLocal();

    public static void main(String[] args) {

        threadLocal.set("java");

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("获取值 "+threadLocal.get());
            }
        });
        t1.start();
    }
}
