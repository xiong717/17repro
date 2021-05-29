package thread.thread0426;
/*
* 线程安全问题
*
* */
public class TestDemo25 {
    public static void main(String[] args) {
        Counter counter = new Counter();
        //执行加法
        counter.incrent();
        //执行减法
        counter.decrent();

        //再打印结果
        System.out.println("最终结果"+counter.getCount());
    }
}
