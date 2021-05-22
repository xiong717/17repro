package thread.thread0522;

public class TestDemo89 {
    static class Singleton{
        private  Singleton(){

        }

        private static Singleton singleton = null;

        public static Singleton getinstance() {
            if (singleton == null) {
                synchronized (Singleton.class) {
                    if (singleton==null){
                        singleton = new Singleton();
                    }
                }
            }
            return singleton;
        }
    }

    static Singleton s1 = null;
    static Singleton s2 = null;

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                s1= Singleton.getinstance();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                s2= Singleton.getinstance();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println(s1==s2);


    }
}
