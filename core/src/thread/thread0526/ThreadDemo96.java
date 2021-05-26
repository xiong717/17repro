package thread.thread0526;
/*
* 可重入锁演示
* */
public class ThreadDemo96 {
    private static Object object = new Object();
    public static void main(String[] args) {
        synchronized (object) {
            System.out.println("进入了主方法");
            synchronized (object) {
                System.out.println("重复进入了方法");
            }
        }
    }

}
