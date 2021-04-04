package demo2;

/**
 * 抽象类：包含抽象方法的类 抽象类
 * 1.抽象类不能进行实例化 不可以Shape shape = new Shape();
 * 2.
 * 3.抽象类是可以被继承的 也可以发生向上转型
 * 4.当一个普通类继承了一个抽象类，那么 当前这个普通类一定要重写抽象类中的抽象方法。
 * 5.当一个普通类继承了抽象类，且不想实现抽象类当中的抽象方法时候
 * 那么这个普通类也可改为抽象类A，此时就不需要实现了
 * 如果这个普通类B 继承了抽象类A，此时就要实现这个抽象方法了
 * 总结： 出来混 要还的
 * 6.抽象方法不能是 private的 因为抽象方法就是用来被重写的
 * 7.抽象类 最大意义就是被继承的
 * 抽象类本身不能被实例化, 要想使用, 只能创建该抽象类的子类.
 * 然后让子类重写抽象类中的抽象方法.
 */
abstract class Shape{
    public int age;
    public static int count;
    public void func (){

    }
    public abstract void draw();
    //一个方法被abstract关键字修饰 就叫做抽象方法 它就不能有具体实现方法
}
class Rect extends Shape {
    @Override
    public void draw() {
        System.out.println("♦");
    }
}
/* 第五点
abstract class A extends Shape{

}
class B extends  A {
    @Override
    public void draw() {

    }
}

 */

public class TestDemo {

    public static void main(String[] args) {
        //Shape shape = new Shape();
    }
}
