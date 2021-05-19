package thread.thread0426;

public class TestDemo16 {
    public static void main(String[] args) {
        //写法⑦
        //定义了线程任务
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("线程名 "+Thread.currentThread().getName());

            }
        };
    Thread t1 = new Thread(runnable,"张三");
    t1.run();
    t1.run();
    t1.start();
    }
}
