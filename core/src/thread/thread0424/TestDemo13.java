package thread.thread0424;
/*
* 守护线程 和 用户线程
* 用户线程：默认创建的线程就是用户线程
* 守护线程：（后台线程）
*   **守护线程就是为用户线程 服务，当用户线程执行完成后，
*   守护线程就会跟随用户线程一起结束
* 守护线程的经典使用场景:垃圾回收器
* */
public class TestDemo13 {
    public static void main(String[] args) {
        Thread t = new Thread(()->{
            for (int i=0;i<10;i++) {
                System.out.println("i:"+i);
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });
        t.setDaemon(true);
        t.start();
        System.out.println("线程类型 "+t.isDaemon());
    }


}
