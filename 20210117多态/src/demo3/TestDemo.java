package demo3;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 * 接口：使用关键字interface修饰
 * 1.接口当中的方法，不能有具体实现
 * 接口当中的方法，默认是public abstract
 * 2.接口当中的成员变量，默认是 public static final 成员定义必须初始化
 * 3.JDK1.8引入的新特性。default修饰的方法，默认方法，
 *    可以有具体的实现
 * 4、接口不可以进行实例化：IShape iShape = new IShape();
 * 5、类和接口之间的关系是，implements
 * 6、一个类可以实现多个接口class Test implements A,B,C{
 * 7、一个类可以继承类，同时实现多个接口
 *   class Test extends TestAbstract implements A,B,C{
 * 8、接口可以扩展多个接口：interface D extends A,B,C {
 *   所以 接口的出现 就是为了解决java多继承的问题
 */

interface IShape{
    /*int age1 = 10;
    public static final int age = 10;
    default void func() {
        System.out.println("fafaaf");
    }

     */
    void draw();
    //public abstract void draw();
}

class Rect implements IShape{

    @Override
    public void draw() {
        System.out.println("○");
    }
}

class Circle implements IShape{
    @Override
    public void draw() {
        System.out.println("♦");
    }
}

interface A{
    void funcA();
}
interface B {
    void funcB();
}
interface C {
    void funcC();
}
//extends: 扩展
interface D extends A,B{
    void funcD();
}

class F implements D{
    @Override
    public void funcA() {

    }
    @Override
    public void funcB() {

    }
    @Override
    public void funcD() {
    }
}

abstract class TestAbstract{
    public abstract void funcAbstract();
}
class Test extends TestAbstract implements A,B{

    @Override
    public void funcA() {

    }

    @Override
    public void funcB() {

    }

    @Override
    public void funcAbstract() {

    }
}

public class TestDemo {
    public static void drawMap(IShape iShape) {
        iShape.draw();
    }
    public static void main(String[] args) {
        //IShape iShape = new Shape();
        /*IShape iShape1 = new Rect();
        IShape iShape2 = new Circle();
        drawMap(iShape1);
        drawMap(iShape2);
         */
        drawMap(new Rect());
        drawMap(new Circle());
    }


}
