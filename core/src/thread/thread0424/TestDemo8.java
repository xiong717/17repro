package thread.thread0424;

import java.util.concurrent.Callable;

/**
 * 创建一个有返回值的线程
 */
public class TestDemo8 {
    //创建线程
    static  class MyCallable implements Callable<Integer>{

        @Override
        public Integer call() throws Exception {
            return null;
        }
    }
}
