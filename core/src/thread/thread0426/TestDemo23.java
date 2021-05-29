package thread.thread0426;
/*
* 演示线程的状态
* */
public class TestDemo23 {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println("执行之前 "+t1.getState());
        t1.start();
        System.out.println("start之后"+t1.getState());
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("休眠之后 "+t1.getState());

        t1.join();
        System.out.println("线程最终状态"+t1.getState());
    }
}
