package thread.thread0426;

public class Counter {
    //私有变量count
    private  int count = 0;
    //执行循环次数
    private  final  int max = 10000000;
    //提供count变量的查询
    public int getCount(){
        return  count;
    }
    //加法
    public void incrent(){
        for (int i = 0; i <max ; i++) {
            count++;
        }
    }
    //减法
    public void  decrent(){
        for (int i = 0; i <max ; i++) {
            count--;
        }
    }
}
