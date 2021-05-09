package thread.thread0424;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 创建方式三 ：Callable + FutureTask 接收线程后执行之后的返回值
 * 创建一个有返回值的线程（唯一一个可以接收线程返回值的方式）
 */
public class TestDemo8 {
    //创建线程
    static  class MyCallable implements Callable<Integer>{

        @Override
        public Integer call() throws Exception {
            //产生随机数 0-9
             int num = new Random().nextInt(10);
            System.out.println(String.format("线程：%s,产生了随机数%d",Thread.currentThread().getName(),num));
             return num;
        }
    }

    public static void main(String[] args) throws ExecutionException,InterruptedException {
        //1.创建callable对象
        MyCallable callable = new MyCallable();
        //使用FutureTask 接收 callable
        FutureTask<Integer> futureTask = new FutureTask<>(callable);
        //3.创建线程并设置任务
        Thread thread = new Thread(futureTask);
        //执行线程
        thread.start();
        //得到线程执行的结果
        int num = futureTask.get();
        System.out.println(num);
    }

}
