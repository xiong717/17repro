package thread.thread0424;

public class HK {
    public static final char[] str = {'A','B','C','D'};

    public static void main(String[] args){
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
}
