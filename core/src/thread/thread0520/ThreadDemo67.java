package thread.thread0520;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ThreadDemo67 {
    private static ThreadLocal<SimpleDateFormat> threadLocal = new ThreadLocal<>();
    public static void main(String[] args) {
        //设置私有变量
        threadLocal.set(new SimpleDateFormat("MM:SS"));
        SimpleDateFormat  simpleDateFormat = new SimpleDateFormat();
        Date date =new Date();
        String result = simpleDateFormat.format(date);
        System.out.println("时间： " + result);
    }
}
