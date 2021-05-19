package thread.thread0518;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
* 线程池有两个主要对象： 1. 线程 2.工作队列(Integer最大值)
*
* 如果使用前
*
*
*
* */
public class ThreadPoolDemo54 {
    //内存溢出
    static class MyoomClass{
        private  static byte[] bytes = new byte[1*1024*1024];//1M空间(M-KB-B)

    }
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i <15 ; i++) {
            final  int finali = i;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("执行任务 " + finali );
                }
            });
        }
    }
}
