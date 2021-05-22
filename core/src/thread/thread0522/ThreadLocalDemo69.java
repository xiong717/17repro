package thread.thread0522;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.text.SimpleDateFormat;
import java.util.Date;
/*
* threadLocal 的 initialValue 方法 在线程中的 使用
* initialvalue 随着线程 里面的调用 调用threadLocal几次 initialvalue方法执行几次
*
* */
public class ThreadLocalDemo69 {
    private static ThreadLocal<SimpleDateFormat> threadLocal = new ThreadLocal(){
        @Override
        protected SimpleDateFormat initialValue() {
            System.out.println("执行initialValue 方法");
            return new SimpleDateFormat("mm:ss");
        }
    };

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                Date date = new Date(1000);
                //从threadLocal 获取 DateFormat对象 并格式化时间
                String ret = threadLocal.get().format(date);
                System.out.println("线程1 时间格式化"+ret);
            }
        });
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                Date date = new Date(1000);
                //从threadLocal 获取 DateFormat对象 并格式化时间
                String ret = threadLocal.get().format(date);
                System.out.println("线程2 时间格式化"+ret);
            }
        });

        t2.start();
    }
}
