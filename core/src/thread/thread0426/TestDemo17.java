package thread.thread0426;
/*
* 中断线程 两种方式：
* 1.自定义全局标识来实现中断
* 2.使用Thread.interrupted来中断
* */
public class TestDemo17 {
    //方法一
    //先定义一个全局变量
    public   static boolean flag = false;
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() ->{
        while(!flag) {
            try {
                Thread.sleep(100);
                System.out.println("我正在转账...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
            System.out.println("啊！差点误了大事");
        },"张三");
        t1.start();
        Thread.sleep(310);
        System.out.println("有内鬼，终止交易");
        flag = true;
    }
}
