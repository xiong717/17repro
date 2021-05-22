package thread.thread0424;

/*
* 实现AABBCCDD打印
* */
public class HK {
    public static final char[] str = {'A','B','C','D'};

    public static void main1(String[] args){
        Thread t1 = new Thread(()->{
            for (int i = 0; i <str.length ; i++) {
                System.out.print(str[i]);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();

        Thread t2 = new Thread(()->{
            for (int i = 0; i <str.length ; i++) {
                System.out.print(str[i]);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t2.start();
    }

    public static final String str1 = "ABCD";
    static class  MyRunnable implements Runnable{
        @Override
        public void run() {
            for (char item :str1.toCharArray()) {
                System.out.print(item);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyRunnable myRunnable = new MyRunnable();
        Thread t1 = new Thread(myRunnable);
        t1.start();
        Thread t2 = new Thread(myRunnable);
        t2.start();

        t1.join();
        t2.join();

    }

}
