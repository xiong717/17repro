import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/*
封装 private实现封装
被 public 修饰的成员变量或者成员方法, 可以直接被类的调用者使用.
被 private 修饰的成员变量或者成员方法，不能被类的调用者使用
 */
class Person2{
    private  String name="张三";
    private int age=18;
    private String sex ;
    public  void show() {
        System.out.println("我叫"+name+" 年龄"+age+" sex "+sex);
    }

    //如果需要获取或者修改这个 private 属性 就用getter和setter方法
    public void setName (String name) {
        this.name = name;//this 表示对当前对象的引用
    }
    public String getName() {
        return name;
    }
    //在 IDEA 中可以使用 alt + insert (或者 alt + F12) 快速生成 setter / getter 方法.
    //在 VSCode 中可以使用鼠标右键菜单 -> 源代码操作 中自动生成 setter / getter 方法.

    /*
    构造方法
    是一种特殊的方法，使用关键字new实例化新对象时 会被自动调用
    new是、执行过程：为对象分配内存空间 调用合适的构造方法（合适意味着不止一个构造方法）
    语法规则： 方法名称与类名称相同 构造方法没有返回值 每一个类一定有一个构造方法（没有定义 则系统自动生成一个无参数构造）
     */
    //默认的无参构造函数
    public Person2(){
        //this关键字 调用构造函数 必须在第一行显示
        this("bit",12,"man");
        /*this.name = "gaobo";
        this.age = 28;
        this.sex = "男";
         */
    }
    //自己写的 带三个参数构造函数
    public Person2(String name,int age,String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }
}
/*public class text3 {
    public static void main1(String[] args) {
        Person2 person = new Person2();
        //person.name error 不能访问
        person.setName("gaobo");
        System.out.println(person.getName());
        person.show();
    }

    public static void main(String[] args) {
        Person2 p1 = new Person2();
        //调用不带参数的构造函数 如果程序没有提供会调用不带参数的构造函数
        p1.show();
        Person2 p2 = new Person2("张",23,"女");
        //调用带3个参数的构造函数
        p2.show();
    }
}

 */

/*
代码块 普通代码块 构造块 静态块
普通代码块 定义在方法中的代码块
构造块也叫实例代码块 定义在类中的代码块
静态代码块 使用static定义的代码块 一般用于初始化静态成员属性

&& 静态代码块 不管生成多少对象 其只会执行一次 且是最先执行的
静态代码块执行完毕后，实例代码块执行 再然后是构造函数执行
 */
class Person3{
    private String name;
    private int age;
    public int size;
    public static int count = 19;

    {
        size = 1000;
        System.out.println("实例代码块");
    }

    static{
        count = 999;
        //size = 999; 报错
        System.out.println("静态代码块");
    }

    public Person3() {
        System.out.println("不带参数的构造方法");
    }

    public Person3(String name) {
        System.out.println("带有1个String类型的参数的构造方法！");
    }

    public Person3(String name,int age) {
        System.out.println("带有2个参数，String，int的构造方法！");
        this.name = name;
        this.age = age;
    }

    public  void show() {
        System.out.println("我叫"+name+" 年龄"+age+" size "+size);
    }

    @Override
    public String toString() {
        return "Person3{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", size=" + size +
                '}';
    }
    //可以使用toString这样的方法 将对象自动转化为字符串
    //快键键是alt+f12 或者是鼠标右键 ->gener->tostring
    //如果没有这个方法的话 soutp1 打印出来就是一个地址的哈希值
}
 public class text3{
     public static void main1(String[] args) {

      Person3 p1 = new Person3();
      p1.show();
         System.out.println(Person3.count++);
         System.out.println("==================");

      Person3 p2 = new Person3("yjl");
      p2.show();
         System.out.println(Person3.count);
         System.out.println("==================");

      Person3 P3 = new Person3("YJL",32);
      P3.show();

      System.out.println("=====================");
      System.out.println(p1);
     }

     public static void main(String[] args) {
         //匿名对象的调用方法、
         new Person3().show();
         /*匿名只是表示没有名字的对象.  没有引用的对象称为匿名对象.
         匿名对象只能在创建对象时使用.
         适用于只用一次的情形
          */
     }



 }
