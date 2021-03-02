class Person {
    public int age=18;
    public String name="za";//默认初始化
    public String sex;
    public void eat(){
        System.out.println("吃饭");
    }
    public void drink() {
        System.out.println("喝水");
    }
    public void show() {
        System.out.println("我叫"+name+"年龄"+age);
    }
    /*
    //就地初始化
    public int age=18;
    public String name="张三";
     */
}
//类的创建
        /*class <class_name> {
            field;//成员属性
            method；//成员方法
        }
        //实例化对象
        <class_name> <对象名> = new <class_name> ();
        //成员变量初始化  默认初始化 就地初始化

         */

public class text {

    public static void main(String[] args) {
        Person person = new Person();
        System.out.println(person.age);//0
        System.out.println(person.name);//null
        /*对于一个对象的字段如果没有显式设置初始值，则为默认值
        对于数字类型 默认值为0 byte short int long 0
        float 0.0f double 0.0 char '\u0000' 打印出来是空白
        对于boolean类型 默认值 flase
        对于引用类型 （string array）默认值为null
         */
        person.eat();
        person.drink();
        person.show();
        //可以实例化多个对象
        Person person1 = new Person();
        Person person2 = new Person();

        Person person3 = null;//person3 这个引用 不引用任何对象
        Person person4 = new Person();
        person3 = person4;//person4 引用 person3 引用的对象


    }



}
