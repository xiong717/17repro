package queuedemo;

/*
* 自己实现队列 （单向链表实现）
*
* */
class Node{
    public int val;
    public Node next;

    public Node(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        /*return "Node{" +
                "val=" + val +
                ", next=" + next +
                '}';*/
        return val+" ";
    }
}

public class MyQueue {
    public Node first;
    public Node last;

    public boolean offer(int v) {
        Node node = new Node(v);
        if (this.first == null) {
            this.first = node;
            this.last = node;
        }else {
            this.last.next = node;
            this.last = node;
        }
        return true;
    }
    //得到队头元素，并删除
    public int poll() throws RuntimeException {
        if(isEmpty()) {
            throw  new RuntimeException("栈为空");
        }
        int ret = this.first.val;
        this.first = this.first.next;
        return ret;
    }

    public boolean isEmpty() {
        if (this.first== null && this.last == null) {
            return true;
        }
        return false;
    }

    public int peek() throws RuntimeException{
        if (isEmpty()) {
            throw new RuntimeException("栈为空");
        }
        int ret = this.first.val;
        return ret;
    }

}
