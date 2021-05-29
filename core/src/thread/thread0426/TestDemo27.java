package thread.thread0426;
/*
* 线程不安全问题
*  解决方法1： 不操作共同的一个私有变量
* */
 class Counter2 {

    // 执行循环次数
    private final int maxSize = 10000000;

    // 执行加法
    public int incrment() {
        int num1 = 0;
        for (int i = 0; i < maxSize; i++) {
            num1++;
        }
        return num1;
    }
    // 执行减法
    public int decrment() {
        int num2 = 0;
        for (int i = 0; i < maxSize; i++) {
            num2--;
        }
        return num2;
    }
}
public class TestDemo27 {
    public static void main(String[] args) throws InterruptedException {
        Counter2 counter2 = new Counter2();
        final int[] ret = new int[2];
        Thread t1 = new Thread(()->{
             ret[0] = counter2.incrment();
        });
        t1.start();


        Thread t2 = new Thread(()->{
            ret[1]=counter2.decrment();
        });
        t2.start();


        t1.join();
        t2.join();
        System.out.println("t1结果"+ret[0]);
        System.out.println("t2结果"+ret[1]);
        System.out.println("最终结果"+(ret[1]+ret[0]));

    }


}
