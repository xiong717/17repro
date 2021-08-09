/*
* 泛型：
* 1.class MyStack<T> 此时<T>代表的是一个占位符，表示当前类是一个泛型类
* 2.this.elem = (T[])new Object[10];
*   this.elem = new T[10];不能实例化泛型类型的数组对象
* 3.MyStack<Integer> myStack = new MyStack<>();
*   指定了当前类可以放的数据类型
* 4.泛型的意义：
*   a:可以自动进行类型检查
*   b:可以自动进行类型转换
* */

import org.omg.CORBA.Object;

import java.util.Objects;

class MyStack<T>{
    public T[] elem;
    public int top;
    public MyStack(){
        this.elem = (T[])new Object[10];
    }
    public void push(T val){
        this.elem[top] = val;
        top++;
    }

    public T gettop(){
        return  this.elem[top-1];
    }
}

/*
* 写一个泛型类 找到数组当中的最大值
* */
class Algorithm<T extends Comparable<T>>{
    public T findmaxval(T[] array){
        T max = array[0];
        for (int i = 1; i < array.length ; i++) {
            if (array[i].compareTo(max) >= 0){
                max = array[i];
            }
        }
        return max;
    }
}
public class TestDemo1 {

    public static void main1(String[] args) {
        MyStack<Integer> myStack = new MyStack<>();
        myStack.push(6);
        myStack.push(1);

        int a = myStack.gettop();
        System.out.println(a);

    }

    public static void main(String[] args) {
        Algorithm<Integer> algorithm = new Algorithm<>();
        Integer[] array = {1,2,3,4,5,6,7};
        System.out.println(algorithm.findmaxval(array));
    }
}