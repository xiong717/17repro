package thread.thread0520;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

/*问题：
* 两个线程的时间格式化
* 实现十个线程的时间格式化
* 实现1000个线程的时间格式化
*
* */
public class ThreadDemo62 {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                Date date = new Date(1000);
                myFormatTime(date);
            }
        });
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                Date date = new Date(1000);
                myFormatTime(date);
            }
        });
        t2.start();

    }


    /*
    * 自定义时间格式化方法 date 待格式化时间
    * */
    private static void myFormatTime(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("mm:ss");
        String result = format.format(date);
        System.out.println();
    }
}
