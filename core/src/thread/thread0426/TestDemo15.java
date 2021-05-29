package thread.thread0426;
/*
  守护线程中注意事项：
* 1.设置守护线程的代码 thread.setDaemon(true)必须放在线程启动start之前
* 2.在守护线程中创建的线程 默认就是守护线程
  守护线程经典使用场景：
  1，java垃圾回收器 2.监控检测任务(当服务器关闭后 监控任务就可以直接关闭 因为没意义了)
* */
public class TestDemo15{
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            //新创建一个线程
            Thread t1 = new Thread(() -> {
            }, "t1");

            System.out.println("t1 守护线程" + t1.isDaemon());//true
            //t1 守护线程true
            System.out.println("线程名： " + Thread.currentThread().getName());

        },"Thread");
        System.out.println(Thread.currentThread().getName()+"守护线程 " + thread.isDaemon());//mian false
        //设置守护线程
        thread.setDaemon(true);
        thread.start();
        System.out.println(Thread.currentThread().getName()+"守护线程 " + thread.isDaemon());//main true
    }

}
