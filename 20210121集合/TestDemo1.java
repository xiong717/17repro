import sun.rmi.transport.Connection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/*
 （1.2）集合 接口
 3.泛型：只存在于编译时期  只是编译时期
 *    意义：
 *    1、自动进行类型的检查
 *    2、自动进行类型转换
 *
 *  泛型 在 编译的时候  并不会进行指定类型的替换 而是拿着指定的类型进行检查
 *     也就是说 在编译的时候 ，拿着你指定的类型 进行 类型检查 ，记住我 并没有说是替换
 *
 *  编译的时候 会进行类型擦除，编译的时候 编译都会把泛型擦除为Object，不是替换为Object
 *
 *  题目：写一个通用的顺序表？
 *     Object是所有类的父类，哪怕这个类没有继承Object
 *
 * 1、class MyArrayList<T> {  <T>：代表占位符  表示当前这个类是一个泛型类
 * 2、简单类型不能做泛型类型的参数
 *       MyArrayList<int> myArrayList1 = new MyArrayList<>();
 * 3.不能new 泛型类型的数组  this.elem = new T[10];
 * 4. 泛型类型的参数 不参与类型的组成-》 泛型就是在编译时期的一种机制
 */
class MyArrayList<T>  {
    public T[] elem;
    public int usedsize;

    public MyArrayList() {
        this.elem = (T[])new Object[10];//定义了数组大小
    }
    public void add(T data) {
        this.elem[this.usedsize] = data;
        this.usedsize++;
    }
    public T get(int pos) {
        return this.elem[pos];
    }


}
public class TestDemo1 {
    public static void main(String[] args) {
        MyArrayList<String> myArrayList1  = new MyArrayList<>();
        //myArrayList1.add(1);报错 应该是String类
        myArrayList1.add("abc");
        myArrayList1.add("xyz");
        String str = myArrayList1.get(0);//编译时候已经擦除为String
        System.out.println(str);
        MyArrayList<Integer> myArrayList2  = new MyArrayList<>();
        myArrayList2.add(1);
        myArrayList2.add(2);
        MyArrayList<Double> myArrayList3  = new MyArrayList<>();
        myArrayList3.add(99.99);
    }
   /* //泛型引入
    public static void main(String[] args) {
     MyArrayList myArrayList = new MyArrayList();
     myArrayList.add(1);
     myArrayList.add(99.99);
     myArrayList.add("abc");
     double a = (double) myArrayList.get(1);
        System.out.println(a);
     String str = (String) myArrayList.get(2);
        System.out.println(str);
      *//*MyArrayList里面的元素是Object类 意味着add时候可以添加任何类型的对象，
     但get取时候 要类型转换（发生了向下转型）才能取 很麻烦。
      * */





    //collection接口
    public static void main1(String[] args){
        Collection<String> connection = new ArrayList<String>();
        connection.add("abc");
        connection.add("qwer");
        System.out.println(connection);
        System.out.println("============");
        connection.clear();
        System.out.println(connection);
    }

    //map接口
    public static void main2(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("玄奘","唐僧");
        map.put("及时雨","宋江");
        map.put("女神","高圆圆");
        map.put("一秒钟","张译");
        map.put("及时雨","宋江2");
        System.out.println(map);
        System.out.println(map.get("一秒钟"));
        System.out.println(map.getOrDefault("yi","默认"));//根据key 找value 没有则用value代替
        System.out.println(map.size());
        System.out.println(map.containsKey("玄奘"));//判断是否包含key
        System.out.println(map.containsValue("唐僧"));//判断是否包含value
    }



}
