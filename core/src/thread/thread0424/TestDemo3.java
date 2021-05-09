package thread.thread0424;

import java.util.concurrent.TimeUnit;

/*
* 线程的创建方式
* */
public class TestDemo3 {
    //方式一 继承Thread类 (缺点：因为java语言设计是 单继承的，当继承了Thread类后，不能继承其他类）
    static  class  MyThread extends Thread{
        @Override
        public void run() {
            //写具体的业务代码
            //打印当前线程的名称
            System.out.println("子线程名称"+Thread.currentThread().getName());
        }
    }

    public static void main1(String[] args) {
       //写法1
        MyThread myThread = new MyThread();
        myThread.start();//启动线程
        System.out.println("主线程名称"+Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        //写法2
        Thread thread = new Thread(){
            @Override
            public void run() {
                System.out.println("当前线程名称"+ Thread.currentThread().getName());
            }
        };
        thread.start();
    }
}
