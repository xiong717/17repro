package thread.thread0518;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
* 线程创建方式六 ： JDK 8 以上才可以使用
*  根据当前的硬件CPU 生成对应个数的线程池，并且是异步执行的。
*  同步执行方式：1.发请求 2.等待执行完成 3.有结果返回
*  异步执行方式: 1.发请求 2.执行完成 3.另一个程序异步处理 4.处理完成之后进行回调返回结果
*
*
*/
public class ThreadPoolDemo53 {

    public static void main(String[] args) {
        //创建一个异步根据当前CPU生成的线程池
        ExecutorService executorService = Executors.newWorkStealingPool();
        for (int i = 0; i < 10; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("线程名 "+ Thread.currentThread().getName());
                }
            });
        }

        //等待线程池执行完成 就可以打印上面的内容了
        while (!executorService.isTerminated()) {

        }




    }
}
