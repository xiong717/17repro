package thread.thread0522;

/*
* 懒汉方式：不见兔子不撒鹰 他不会随着程序的启动而初始化 而是等到有人调用他时，才会初始化。
* 懒汉方式实现版本3
* */
public class ThreadDemo88 {

    static class Singleton{
        //1.设置私有的构造函数
        private Singleton(){
        }
        //2.提供一个私有的静态变量
        private static volatile Singleton singleton = null;
        //3.提供给外部调用
        public static  Singleton getInstance(){
            //双层效验锁
            if (singleton == null) {
                synchronized (Singleton.class) {
                    if (singleton == null) {
                        //第一次访问，进行实例化
                        singleton = new Singleton();
                    }
                }
            }
            return singleton;
        }
    }
    static Singleton s1 =null;
    static Singleton s2 =null;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                //获取单例对象
                s1= Singleton.getInstance();
            }
        });
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                //获取单例对象
                s2 = Singleton.getInstance();
            }
        });
        t2.start();

        t1.join();
        t2.join();
        System.out.println(s1==s2 );
    }
}
