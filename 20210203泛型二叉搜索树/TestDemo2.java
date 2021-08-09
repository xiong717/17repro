
/*
* 内部类：比较简单
* 实例内部类：定义在类的内部的一个类
*    1.如何实例化内部类对象？
        Outerclass out = new Outerclass();
        Outerclass.Innerclass innerclass1 = out.new Innerclass();
*       外部类名.内部类名 变量 = 外部类对象的引用.new 内部类()
*    2.只要是内部类 其生产的字节码文件格式：外部类$内部类.class
*    3. 在实例内部类当中，不能定义静态的成员变量
*       如果非要定义，那么一定要在编译时期确定的值 public static final
*    4，this实际上是一个静态的成员变量
*       System.out.println(Outerclass.this.data1);
*    5.实例内部类实际上拥有两个this 一个是实例内部类自己的 一个是外部类的
*    面试题 实例内部类，是否有额外的内存开销？
*
* 静态内部类:定义在类的内部的一个类 但是有static修饰
*   1,静态内部类对象如何拿到？
*
*   2.字节码文件 与上面一样
*   3,在静态内部类当中，是不可以访问外部类的非静态数据成员
*     因为，外部类的非静态数据成员 是依赖与外部类对象的
*     那如果非要访问呢？
*
* 匿名内部类
*    在匿名内部类当中，使用的变量，或者是常量 或者是在整个过程中，没有发生改变的量
* 本地内部类
*    方法里面定义的类 意义不大
*
*

 */
 /*class Outerclass{
    public int data1 = 1;
    public static int data2 =2;
    class Innerclass{

        public int data3 = 3;
        //public static int data4 = 4;
        public static final int data4  = 4;
        public int data1 = 11;
        public Innerclass(){

        }
        public void test(){
            System.out.println("Innerclass::test()");
            System.out.println(data3);
            System.out.println(data4);
            System.out.println(data1);//11
            System.out.println(Outerclass.this.data1);//1

        }
    }
}
  */

/*class Outerclass{
    public int data1 = 1;
    public static int data2 =2;

    //静态内部类
    static class Innerclass {
        public int data3 = 3;
        public static int data4 = 4;
        public Outerclass out;
        public Innerclass(Outerclass out) {
            this.out = out;
        }
        public void test(){
            System.out.println("Innerclass::test()");
            System.out.println(data3);
            System.out.println(data4);
            System.out.println(data2);
            //System.out.println(Outerclass.this.data1);错误
            System.out.println(out.data1);
        }

    }

}*/
//匿名内部类
class OuterClass{
    public  void  hello(){
        System.out.println("hello");
    }

}

public class TestDemo2 {
    //实例内部类
    /*public static void main1(String[] args) {
        //Innerclass innerclass = new Innerclass();

        Outerclass out = new Outerclass();
        Outerclass.Innerclass innerclass1 = out.new Innerclass();
        innerclass1.test();
    }
     */

    /*静态内部类*/
    /*public static void main2(String[] args) {
        Outerclass out = new Outerclass();
        Outerclass.Innerclass inn = new Outerclass.Innerclass(out);
        inn.test();
    }*/

    public static void main(String[] args) {
    //匿名内部类
        final int data = 10;
        int data2 = 99;
        new OuterClass(){
            @Override
            public void hello() {
                //super.hello();
                System.out.println("hhhhh.匿名内部类");
                System.out.println(data);
                System.out.println(data2);
            }
        }.hello();
        //多线程会用到
    }

    public void func(){
        class A{
            //本地内部类
        }
    }

}
