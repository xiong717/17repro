package thread.thread0424;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
/*
* 线程创建方式二 实现Runnable接口
* */
public class TestDemo5 {
    //创建方法二 实现Runnable接口

    //写法一
    static class MyRunnable implements Runnable{
        @Override
        public void run() {
            System.out.println("线程名称"+Thread.currentThread().getName());
        }
    }

    public static void main1(String[] args) {
       /* MyRunnable myRunnable = new MyRunnable();
        myRunnable.run();//线程名称main 结果不对 没新创建成功*/
        //创建Runnable 子对象
        MyRunnable myRunnable = new MyRunnable();
        //创建线程
        Thread thread = new Thread(myRunnable);
        //启动线程
        thread.start();
    }

    //写法二
    public static void main2(String[] args) {
        //创建一个 匿名Runnable类
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("当前线程"+Thread.currentThread().getName());
            }
        });
        thread.start();
    }

    //写法三
    public static void main(String[] args) {
        //lambda + runnable 注意只有JDK1.8+才支持
        Thread thread = new Thread(()->{
            System.out.println("线程名称"+Thread.currentThread().getName());
        });
        thread.start();
    }
}
