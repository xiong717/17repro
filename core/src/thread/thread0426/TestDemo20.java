package thread.thread0426;
/*
*
*
* */
public class TestDemo20 {
    public static void main(String[] args) {
        Thread thread = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.interrupted());
                //System.out.println(Thread.currentThread().isInterrupted());
            }
        });
        thread.start();
        thread.interrupt();//默认是false 打断后 为true
    }
}

/*
* 答案 true false false false 。。。
* 静态方法：Thread.interrupted()第一次接收到终止状态是true，之后就会将状态复位(恢复为false)
* 静态方法是全局的 为了谨防别的调用 所以复位为false
*
*普通方法 Thread.currentThread().isInterrupted()
* 答案十次全为true 这个只是用来得到线程状态，并不会进行复位。
*
* */
