public class TestDemo17 {
    /*//1
    static boolean Paddy;
    public static void main1(String[] args) {
        System.out.println(Paddy);
    }

    //2
    public String name = "abc";
    public static void main2(String[] args) {

        TestDemo17 test = new TestDemo17();
        TestDemo17 testb = new TestDemo17();
        System.out.println(test.name);
        System.out.println(testb.name);
        System.out.println(test.equals(testb));
        System.out.println(test.name.equals(testb.name));
    }*/

    //8
    private int count;

    public TestDemo17(int a) {
    count = a;
    }

    public static void main(String[] args) {
        TestDemo17 test = new TestDemo17(88);
        System.out.println(test.count);

    }
}

/*
//4
class X{
    Y y = new Y();//1

    public X( ) {
        System.out.println("X");//2
    }
}
class Y {
    public Y() {
        System.out.println("Y");
    }
}
public class TestDemo17 extends X{
    Y y = new Y();//3

    public TestDemo17() {
        System.out.println("Z");//4
    }

    public static void main(String[] args) {
        TestDemo17 testDemo17 = new TestDemo17();
    }
//执行顺序 父类静态->子类静态->父类实例、构造方法->子类实例、构造方法
}
*/

//9
 class Super {

    private void method1() {
        method2(); // 实例方法可以调用类方法
        meth();
        System.out.println("这是父类的实例方法");
    }
    public void meth(){

    }

    public static void method2() {
        //method1();// 类方法不可以调用实例方法
        System.out.println("这是父类的类方法");
    }

}

 class Son {

    public void method3() {
        //method1();// 实例方法不可以调用超类的实例方法，除非是public修饰
        //method2();// 实例方法不可以调用超类的类方法
        System.out.println("这是子类的实例方法");
    }



     public static void main(String[] args) {
        Son son = new Son();
        son.method3();
    }
}
/*类方法
也可以称为静态方法，使用static修饰的类中方法；
属于整个类的，不是属于某个实例的，只能处理static域或者调用static方法；
不能访问实例变量，只能访问类变量，类方法由类名或者实例对象调用；
类方法中不能出现this或者super关键字；

实例方法:非静态方法，没有用static修饰的方法；属于对象的方法，由对象来调用。可以对类变量进行操作*/