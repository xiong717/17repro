package thread.thread0426;
/*
* 当有大量的共同任务时 可以用这个方法
* run()和start()区别
* 1.run()方法是一个对象的普通方法，它使用的是主线程来执行任务的
* 2.start()方法是线程的开启方法，它使用新的线程来执行任务的
* 3.start()方法只能执行一次，而run()可以调用n次
* * */
public class TestDemo16 {
    public static void main(String[] args) {
        //写法⑦
        //定义了线程任务
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("线程名 "+Thread.currentThread().getName());

            }
        };
    Thread t1 = new Thread(runnable,"张三");
    t1.run();
    t1.run();
    t1.start();
    }
}
