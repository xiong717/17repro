package demo1;

import java.util.Random;
import java.util.concurrent.Callable;

 class Shape {
    public void draw() {

    }
}

class Rect extends Shape{
    @Override
    public void draw() {
        System.out.println("♦");
    }
}
class Circle extends Shape{
    @Override
    public void draw() {
        System.out.println("○");
    }

}

public class TestDemo1 {

    //多态：一个引用能表现出多种不同的形态
    public static void drawMap(Shape shape) {
     shape.draw();
    }

    public static void main1(String[] args) {
        Rect rect = new Rect();
        drawMap(rect);

       Circle circle = new Circle();
       drawMap(circle);
       /*
    类的调用者在编写 drawMap 这个方法的时候, 参数类型为 Shape (父类), 此时在该方法内部并不知道, 也不关注当
前的 shape 引用指向的是哪个类型(哪个子类)的实例. 此时 shape 这个引用调用 draw 方法可能会有多种不同的表现
(和 shape 对应的实例相关), 这种行为就称为 多态.
     */
        /**
         * 好处：1.类的调用者对类的使用成本降低了
         * 2.能降低代码的圈复杂度 避免使用大量的if-else
         * 3.可扩展能力能力更强
         */
    }

    public static void main(String[] args) {
        Rect rect = new Rect();
        Circle cycle = new Circle();
        String[] shapes = {"cycle", "rect", "cycle", "rect"};

        for (String shape : shapes) {
            if (shape.equals("cycle")) {
                cycle.draw();
            } else if (shape.equals("rect")) {
                rect.draw();
            }
        }
        System.out.println("=========");

        Shape[] shapes1 = {new Circle(),new Rect(),new Circle()};
        for (Shape shape : shapes1) {
            shape.draw();
        }
    }

}
