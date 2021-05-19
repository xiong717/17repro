package thread.thread0426;
/*
* 中断线程 ： 第二种
* */
public class TestDemo18 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            while (!Thread.interrupted()){
                try {
                    //休眠线程
                    Thread.sleep(100);
                    System.out.println("正在转账");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
            }
            System.out.println("啊！差点误了大事");
        });
        t1.start();
        //休眠主线程一段时间
        Thread.sleep(310);
        System.out.println("有内鬼，停止交易");

        t1.interrupt();
    }


        public static void main2(String[] args) throws InterruptedException {

            Thread t1 = new Thread(() -> {
                while (!Thread.interrupted()) {
                    try {
                        // 休眠线程
                        Thread.sleep(100);
                        System.out.println("我正在转账...");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }
                }
                System.out.println("啊？差点误了大事。");
            }, "张三");
            // 开启任务
            t1.start();

            // 休眠主线程一段时间
            Thread.sleep(310);

            // 终止线程
            System.out.println("停止交易，有内鬼.");
            t1.interrupt();

        }


}
