package thread.thread0424;

/*
* 优先级
* */
public class TestDemo12 {
    public static void main(String[] args) {
        for (int i = 0; i <100 ; i++) {
            //权重最低的线程
            Thread t1 = new Thread(()->{
                System.out.println("t1");
            });
            t1.setPriority(1);
            t1.start();

            //权重最高的线程
            Thread t3 =new Thread(()->{
                System.out.println("t3");
            });
            t3.setPriority(10);
            t3.start();

            //权重中间的线程
            Thread t2 =new Thread(()->{
                System.out.println("t2");
            });
            t2.setPriority(5);
            t2.start();
        }
    }
}
