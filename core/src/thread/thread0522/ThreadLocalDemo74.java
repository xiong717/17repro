package thread.thread0522;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/*
* ThreadLocal 使用场景
*  1.解决线程安全问题
*  2.实现线程级别的数据传递
* ThreadLocal 的问题
*  1.不可继承性
*  2.
*  3.脏读问题
* */
public class ThreadLocalDemo74 {
    private static ThreadLocal<SimpleDateFormat> threadLocal = new ThreadLocal(){
        @Override
        protected SimpleDateFormat initialValue() {
            System.out.println(" 执行了初识化方法 ");
            return new SimpleDateFormat("mm:ss");
        }
    };
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(10,10,0, TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(1000));
        for (int i = 0; i < 1001; i++) {
            int fianli = i;
            executor.submit(new Runnable() {
                @Override
                public void run() {
                    Date date = new Date(1000*fianli);
                    myformitime(date);
                }
            });
        }
    }

    private static void myformitime(Date date) {
        String ret = threadLocal.get().format(date);
        System.out.println(" 时间 "+ ret);
    }
}
