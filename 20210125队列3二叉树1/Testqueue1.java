/*
* 面试题：用队列实现栈
*
* 思路 ： 准备两个队列 qu1,qu2。
* 入栈：谁不为空，就入栈到那个队列。两者都为空 指定放在了que1
* 出栈：每次出不为空的队列，出size-1个，到另外一个为空的队列，最后弹出剩余的那一个元素
*
* */

import java.util.LinkedList;
import java.util.Queue;

class MyStack {

    private Queue<Integer> que1 = new LinkedList<>();
    private  Queue<Integer>  que2 = new LinkedList<>();
    /** Initialize your data structure here. */
    public MyStack() {

    }

    /** Push element x onto stack. */
    public void push(int x) {
        //谁不为空，就放到哪个队列里面
        if(!que1.isEmpty()) {
            que1.offer(x);
        }else if(!que2.isEmpty()) {
            que2.offer(x);
        }else {
            que1.offer(x);//两者都为空 指定放在了que1
        }

    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        //每次出不为空的队列，出size-1个，到另外一个为空的队列，最后弹出剩余的那一个元素。
        if(empty()) {
            return -1;
        }
        if (!que1.isEmpty()) {
            int size = que1.size();
            for (int i = 0;i<size-1;i++) {
                que2.offer(que1.poll());
            }
            return que1.poll();
        }else {
            int size = que2.size();
            for (int i = 0; i < size -1; i++) {
                que1.offer(que2.poll());
            }
            return que2.poll();
        }
    }

    /** Get the top element. */
    public int top() {
        if (empty()) {
            return -1;
        }
        if (!que1.isEmpty()) {
            int cur = -1;
            int size = que1.size();
            for (int i = 0; i < size; i++) {
                cur = que1.poll();
                que2.offer(cur);
            }
            return cur;
        }else {
            int cur = -1;
            int size = que2.size();
            for (int i = 0; i < size  ; i++) {
                cur = que2.poll();
                que1.offer(cur);
            }
            return cur;
        }

    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return que1.isEmpty() && que2.isEmpty();
    }
}

public class Testqueue1 {

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top());
        System.out.println(myStack.pop());
        System.out.println(myStack.empty());

    }

}
