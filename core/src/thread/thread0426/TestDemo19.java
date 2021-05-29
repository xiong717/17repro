package thread.thread0426;


public class TestDemo19 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            //while (!Thread.currentThread().isInterrupted())
            //两种用来判断 线程终止的方式
            while (!Thread.interrupted()) {
                System.out.println("正在转账");
            }
            System.out.println("终止转账");
        });
        t1.start();
        Thread.sleep(1);
        System.out.println("有内鬼");
        t1.interrupt();//将t1 interrupt状态改为true
    }
}
