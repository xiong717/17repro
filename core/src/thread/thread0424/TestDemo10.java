package thread.thread0424;

/**
 * 演示线程分组
 */
public class TestDemo10 {
    private static final int count=1000;

    ThreadGroup threadGroup = new ThreadGroup("计算线程");
     Thread t1 = new Thread(threadGroup,()->{

     });
}
