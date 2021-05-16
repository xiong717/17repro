/*
* 用栈实现队列 两个栈 s1 s2才能实现队列功能
*  s1 当做 入队
*  s2 当做 出队  当 s2 为空时 导入s1 全部的元素  并弹出 s2栈顶元素 当s2 不为空， 直接弹出s2栈顶元素
*
* */

import java.util.Stack;

class MyQueue{
    private Stack<Integer> s1 = new Stack<>();//入队
    private Stack<Integer> s2 = new Stack<>();//出队

    public MyQueue() {
    }

    public void push(int x) {
        s1.push(x);
    }

    public int pop() {
        if (!s2.isEmpty()) {
            return s2.pop();
        }else {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            return s2.pop();
        }
    }

    public int peek() {
        if (!s2.isEmpty()) {
            return s2.peek();
        }else {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            return s2.peek();
        }
    }

    public boolean empty() {
        return  s1.isEmpty() && s2.isEmpty();
    }
}
public class Testqueue2 {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1); // queue is: [1]
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        System.out.println(myQueue.peek());// return 1
        System.out.println(myQueue.pop());// return 1, queue is [2]
        System.out.println(myQueue.empty());// return false


    }

}
