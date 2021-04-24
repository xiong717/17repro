package thread.thread0424;

public class TestDemo9 {
    Thread thread =new Thread(()-> {
        System.out.println("线程名"+Thread.currentThread().getName());
        try {
            Thread.sleep(10000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    },"张三");
}
