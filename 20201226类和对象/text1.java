class TestDemo{
    public int a;
    public static int count;

    public static void change() {
        count=100;
        //a=100; 报错 不可访问非静态数据成员
    }
}
  /*
  static 关键字
  1，修饰属性时
  访问形式：类名.静态成员变量 不用new 存储在方法区
    特点 静态的只有一份，而且不依赖对象（可直接通过类名. 访问）
  2. 修饰方法时
   任何方法上应用static关键字，此方法称为静态方法
   静态方法属于类，不属于类的对象
   可以直接调用，无需创建类的实例（new）
   可以访问静态数据成员，并更改静态数据成员值
   */
public class text1{
    public static void main1(String[] args) {
      TestDemo t1 = new TestDemo();
       t1.a++;
       TestDemo.count++;
       System.out.println(t1.a);
       System.out.println(TestDemo.count);
       System.out.println("============");
       TestDemo t2 = new TestDemo();
       t2.a++;
       TestDemo.count++;
       System.out.println(t2.a);
       System.out.println(TestDemo.count);
       TestDemo.count++;
       System.out.println(TestDemo.count);
   }

      public static void main(String[] args) {
          TestDemo.change();
          System.out.println(TestDemo.count);
      }
}


