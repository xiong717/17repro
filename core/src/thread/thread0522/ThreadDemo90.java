package thread.thread0522;

import java.util.Random;

public class ThreadDemo90 {

    static class MyBlockingQueue{
        //存放数据的数组
        private int[] values ;
        //两个指针 队头 队尾
        private int first;//队首下标
        private int last;//队尾下标
        private int size;//实际队列大小

        public MyBlockingQueue(int maxsize) {
            //初始化队列
            values = new int[maxsize];
            first=0;
            last=0;
            size=0;
        }

        //添加元素 （将队尾添加至队尾）
        public void offer(int val) throws InterruptedException {
            synchronized (this) {
                //判断容量是否达到最大值
                if (size == values.length) {
                   //阻塞等待，消费者先消费
                    this.wait();
                }
                values[last++] = val;
                size++;

                //判断是否是最后一个元素
                if (last == values.length) {
                    last = 0;
                }
                //唤醒消费者取队列中的信息
                this.notify();
            }
        }
        //取元素
        public int poll() throws InterruptedException {
            int ret =0;
            synchronized (this) {
                //判断队列是否有元素
                //阻塞等待
                if (size==0) {
                    this.wait();
                }
                ret = values[first++];
                size--;

                if (first == values.length){
                    first = 0;
                }
            }
            return ret;
        }

    }
    public static void main(String[] args) {

        //生产者
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
               MyBlockingQueue myBlockingQueue = new MyBlockingQueue();
               //生产数据
                while (true) {
                    int num = new Random().nextInt(10);
                    try {
                        myBlockingQueue.offer(num);
                    } catch (InterruptedException e) {
                         
                    }

                    Thread.sleep(500);
                }

            }
        });
    }
}
