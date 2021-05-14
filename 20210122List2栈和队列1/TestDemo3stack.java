import java.util.ArrayList;
import java.util.Stack;

/*
* 栈和队列
*
* */

class MyStack<T>{
    private int[] arr ;
    private int size ;

    public MyStack() {
        this.arr = new int[100];
        this.size = size;
    }

    public int push(int v) {
        if (isFull()) {
            throw new RuntimeException("栈为满");
        }
        this.arr[this.size] = v;
        this.size++;
        return this.arr[this.size-1];
    }

    private boolean isFull() {
        return this.size == this.arr.length;
    }

    /*
    * 弹出栈顶元素，并删除
    * */
    public int pop( ) {
       if (empty()) {
           throw new RuntimeException("栈为空");
       }
       this.size--;
       return this.arr[this.size];
    }

    public boolean empty() {
        return size==0;
    }

    /*
    * 拿到栈顶元素 不删除
    * */
    public int peek() {
        if (empty()) {
            throw new RuntimeException("栈为空");
        }
        return this.arr[this.size-1];
    }

    public int size() {
        return this.size;
    }
}
public class TestDemo3stack {
    public static void main1(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack);
        //拿到栈顶元素
        System.out.println(stack.peek());
        //弹出栈顶元素
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.empty());
        System.out.println(stack.peek());
        System.out.println(stack.isEmpty());
        System.out.println(stack.pop());
    }

    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack);
        //拿到栈顶元素
        System.out.println(stack.peek());
        //弹出栈顶元素
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.empty());
        System.out.println(stack.peek());
        System.out.println(stack.pop());
    }
}
