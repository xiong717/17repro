package thread.thread0424;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/*
* 显示线程常见的属性
* */
public class TestDemo11 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程ID "+ Thread.currentThread().getId());
                System.out.println("线程名称 "+ Thread.currentThread().getName());
                System.out.println("线程状态 "+ Thread.currentThread().getState());
                try {
                    Thread.sleep(1000);//注意休眠时间的把握 影响state
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"t1");
        t1.start();
        //打印线程状态
        Thread.sleep(100);
        System.out.println("t1线程状态 "+t1.getState());
        System.out.println("优先级 "+t1.getPriority());
        System.out.println("是否是后台线程 "+t1.isDaemon());
        System.out.println("是否存活 "+t1.isAlive());
        System.out.println("是否被中断 "+t1.isInterrupted());

        //等待线程执行完
        t1.join();//方式一
        while (!t1.isAlive()) {
        }//方式二
    }

    /**
     * 演示线程的常见属性
     */
        public static void main1(String[] args) throws InterruptedException {
            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    Thread t = Thread.currentThread();
                    System.out.println("线程ID：" + t.getId());
                    System.out.println("线程名称：" + t.getName());
                    System.out.println("线程状态：" + t.getState());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, "t1");
            // 启动线程
            t1.start();
            // 打印线程状态
            Thread.sleep(100);
            System.out.println("t1 线程状态：" + t1.getState());
            System.out.println("优先级：" + t1.getPriority());
            System.out.println("是否为守护线程：" + t1.isDaemon());
            System.out.println("是否存活：" + t1.isAlive());
            System.out.println("是否被中断：" + t1.isInterrupted());

            // 等待线程执行完
            t1.join(); // 方式一
            while (!t1.isAlive()) { // 方式二
            }

        }
}

