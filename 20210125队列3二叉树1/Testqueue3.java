/*
* 面试题：最小栈问题
* 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
push(x) —— 将元素 x 推入栈中。
pop() —— 删除栈顶的元素。
top() —— 获取栈顶元素。
getMin() —— 检索栈中的最小元素。
*  思路： 有一个普通栈和一个最小栈minstack
1.  入栈时候 ：普通栈直接入， minstack若为空直接入栈 不为空 则比较大小，小于或等于minstack的栈顶元素，才能入栈
2.  出栈时：普通栈直接出，然后出的元素与minstack栈 的栈顶元素比较 ，相同 则两者同时出栈。

* */

import java.util.Stack;

class MinStack {
    private Stack<Integer> stack = new Stack();
    private Stack<Integer> minS = new Stack();
    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int val) {
        stack.push(val);
        if(minS.isEmpty()) {
            minS.push(val);
        }else{
            if(val <= minS.peek()){
                minS.push(val);
            }
        }

    }

    public void pop() {
        int x = stack.pop();
        if(x == minS.peek()) {
            minS.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minS.peek();
    }
}

public class Testqueue3 {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(1);
        minStack.push(2);
        minStack.push(-1);
        minStack.push(0);
        System.out.println(minStack.getMin());
        System.out.println(minStack.top());
        minStack.pop();
        minStack.pop();
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}
