package thread.thread0526;

import java.util.concurrent.atomic.AtomicReference;

/*
* 使用代码的方式演示ABA
* */
public class ThreadDemo92 {

    private static AtomicReference money = new AtomicReference();
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });
    }
}
