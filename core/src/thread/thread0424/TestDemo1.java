package thread.thread0424;

import java.util.concurrent.TimeUnit;

/*
演示电影字幕效果
 */
public class TestDemo1 {
    public static void main(String[] args) throws InterruptedException {
        String content = "一是婴儿哭啼　二是学游戏 三是青春物语　四是碰巧遇见你\n" +
                "了解这个你　沉迷这个你";
        for(char item:content.toCharArray()) {

            System.out.print(item);
            //线程休眠 方式一
            Thread.sleep(1000);//休眠1秒钟

            //线程休眠 方式二
            TimeUnit.SECONDS.sleep(1);//休眠1秒
            TimeUnit.HOURS.sleep(1);//休眠1小时

            //线程休眠 方式三
            /*TimeUnit.SECONDS.toMillis(1);//1秒钟转换为1000毫秒数
            TimeUnit.HOURS.toMillis(1);//1小时转换为1000毫秒数
            System.out.println(TimeUnit.SECONDS.toMillis(1));*/
            Thread.sleep(TimeUnit.SECONDS.toMillis(1));

        }
    }
}
