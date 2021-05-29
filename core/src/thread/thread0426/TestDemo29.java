package thread.thread0426;

import java.util.Scanner;
/*
* 解决线程内存不可见问题： volatile关键字可以解决内存不可见 和 指令重排序(编译器优化)问题
* */
public class TestDemo29 {
    public static volatile boolean flag = false;
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
