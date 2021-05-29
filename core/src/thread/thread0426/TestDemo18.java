package thread.thread0426;
/*
* 中断线程 ： 第二种
* 使用系统的interrupt()可以及时的终止线程，而使用自定义全局变量终止线程的方式，
* 比较温柔不能立即终止
* */
public class TestDemo18 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            while (!Thread.interrupted()){
                try {
                    //休眠线程
                    Thread.sleep(100);
                    System.out.println("正在转账");
                } catch (InterruptedException e) {
                   e.printStackTrace();
                    break;
                }
            }
            System.out.println("啊！差点误了大事");
        });
        t1.start();
        //休眠主线程一段时间
        Thread.sleep(310);
        System.out.println("有内鬼，停止交易");
        t1.interrupt();
    }
}
