package thread.thread0426;

import java.util.Scanner;
/*
* 内存不可见 (t1里面的打印信息没打印出来 说明线路里面内存不可见)
* */
public class TestDemo28 {
    public static boolean flag = false;
    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
           while (!flag){

           }
            System.out.println("线程执行结束");
        });
        t1.start();

        Thread t2 = new Thread(()->{
            Scanner scanner = new Scanner(System.in);
            System.out.print("->");
            scanner.nextInt();
            flag= true;
        });
        t2.start();
    }
}
