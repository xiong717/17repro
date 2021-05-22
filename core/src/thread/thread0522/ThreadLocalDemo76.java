package thread.thread0522;

public class ThreadLocalDemo76 {
    private static ThreadLocal threadLocal = new ThreadLocal();

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
