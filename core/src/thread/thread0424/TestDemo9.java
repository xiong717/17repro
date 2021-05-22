package thread.thread0424;
/*
* 线程构造函数：
* 1.设置线程名称
* 2.设置线程任务
* 3.设置线程分组
* 线程名字
* */
public class TestDemo9 {
    public static void main(String[] args) {
        Thread thread =new Thread(()-> {
            System.out.println("线程名:"+Thread.currentThread().getName());
            try {
                Thread.sleep(10000000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"张三");
        thread.start();
    }

}
