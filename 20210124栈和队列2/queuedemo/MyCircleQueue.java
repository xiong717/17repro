package queuedemo;

public class MyCircleQueue {
    private int front;//头
    private int rear;//尾
    private int[] elem;

        public MyCircleQueue(int k) {
            this.elem = new int[k+1];
            this.front = 0;
            this.rear = 0;

            //注意这个k+1 若放k 则数组是可以放 k-1个元素 所以要放k个元素 就是要k+1
        }

        //入队
        public boolean enQueue(int value) {
           if (isFull()) {
               return false;
           }
           //放到数组的rear下标 rear往后走
            this.elem[this.rear] = value;
           this.rear = (this.rear+1)%this.elem.length;
           return true;
        }

        //出队
        public boolean deQueue() {
           if (isEmpty()) {
               return false;
           }
           //挪动front下标
            this.front = (this.front+1)%this.elem.length;
           return true;
        }

        //得到队头元素
        public int Front() {
            if (isEmpty()) {
                return  -1;
            }
            //只需返回front下标
            return  this.elem[this.front];
        }

        //得到队尾元素 rear下标是没有元素的 减 1 才能拿到队尾元素
    //如果 rear =0 返回的是数组长度-1
        public int Rear() {
            if (isEmpty()) {
                return -1;
            }
            int index= 0;
            if (this.rear == 0) {
                index = this.elem.length-1;
            }else {
                index = this.rear-1;
            }
            return this.elem[index];
        }

        //队列是否为空
        public boolean isEmpty() {
           return this.rear == this.front;
        }

        //队列是否为满 rear的下一个 是 front 则是满
        public boolean isFull() {
            return (this.rear+1)%elem.length == this.front ;
        }


}
