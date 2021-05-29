package thread.thread0426;
/*
* 观察线程的状态
* */
public class TestDemo22 {
    public static void main(String[] args) {
        for (Thread.State state:Thread.State.values()
             ) {
            System.out.println(state);
        }
    }
}

/*
* NEW 线程已创建好了 但还没开始工作
RUNNABLE 运行
BLOCKED  阻塞
WAITING  等待
TIMED_WAITING 超时等待(有具体时间的等待)
TERMINATED 终止

* */
