package thread.thread0522;

/*
* 饿汉方式
*  优点：实现简单，不存在线程安全的问题(因为饿汉的方式 随着程序的启动而初始化的，因为类加载是线程安全的，所以他是线程安全的)
*  缺点：随着程序的启动而启动，有可能在整个程序的运行周期里面都没有用到，这样就带来了不必要的开销。
* */
public class ThreadDemo84 {
    //单例类
    static class Singleton{
        //1.将构造函数设置为私有的（不让外部常见）
        private Singleton() {

        }
        //2，创建一个静态的类变量（让底下第三步方法返回的）
        private static Singleton singleton = new Singleton();
        //3.给外部提供的获取单例的方法
        public static Singleton getInstance(){
            return singleton;
        }
    }
    public static void main(String[] args) {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });
    }
}
