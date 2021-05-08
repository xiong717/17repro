/*
 * 装包/装箱：把简单类型 包装成 对应的包装类
 *   自动装包：
 *   显示装包：
 * 拆包/拆箱：
 *   自动拆箱：
 *   显示拆箱：
 * */

public class TestDemo2 {
    /*
    * 选择题
    * */
    public static void main(String[] args) {
        Integer a = 139;
        Integer b = 139;
        System.out.println(a == b);
        Integer c = 100;
        Integer d = 100;
        System.out.println(c==d);

        /*源码 IntegerCache.low(-128) IntegerCache.high(127)
        * public static Integer valueOf(int i) {
        if (i >= IntegerCache.low && i <= IntegerCache.high)
            return IntegerCache.cache[i + (-IntegerCache.low)];
        return new Integer(i);
    }*/
    }

    public static void main3 (String[] args) {
        Integer i = 10;
        int a = i;//自动拆箱 -> i.intValue()
        System.out.println(a);
        int a2 =i.intValue();//显示拆箱int
        System.out.println(a2);
        double d = i.doubleValue();//double
        System.out.println(d);
    }
    public static void main1(String[] args) {
        int a =19;
        Integer integer1 = new Integer(a);//显示装包
        System.out.println(integer1);
        Integer integer2=Integer.valueOf(a);//显示装包
        System.out.println(integer2);
        Integer integer3 = a;//自动装包 其实也是调用了 Integer.valueOf
    }

}
