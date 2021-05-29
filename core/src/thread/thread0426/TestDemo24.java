package thread.thread0426;
/*
* yield()方法   [用来出让CPU的执行权]
* yield()分配执行权不一定成功，要看CPU的最终选择，但总体来说是符合预期的
* */
public class TestDemo24 {
    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            for (int i = 0; i < 100; i++) {
                //出让CPU的执行权
                Thread.yield();
                //源码public static native void yield(); native表示是调用c/c++代码
                System.out.println("我是线程1");
            }
        });
        t1.start();

        Thread t2 = new Thread(()->{
            for (int i = 0; i < 100; i++) {
                System.out.println("我是线程2");
            }
        });


        t2.start();
    }
}
