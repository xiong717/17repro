/**
 * String 和 StringBuilder StringBuffer 的区别
 * 1.后两者包含了一些String没有的方法，比如reverse方法
 * 2.后两者是可变的，String是不可变得。String的每次拼接，都会产生新的对象
 *   后两者每次拼接都返回的是this
 * 3.StringBuilder StringBuffer 的区别:
 *   StringBuilder和String 适用在单线程情况下
 *   StringBuffer因为有 synchronized关键字 所以一般出现在多线程情况下
 * 4.StringBuilder 和 String之间有啥区别？？
 *   1.String的拼接 + 会被优化 优化为StringBuilder.append了
 *   2.在循环中 不可以 使用String直接进行拼接 这样会产生大量的临时对象
 *   包括优化之后的StringBuilder对象
 *   */
public class TestDemo3 {
    public static void main1(String[] args) {
        //以下三个都可以表示字符串
        String str = "abcdf";
        str=str+"hello";//str是不可变的

        StringBuilder sb = new StringBuilder("ABCD");
        System.out.println(sb.append("hello"));
        System.out.println(sb.reverse());


        StringBuffer sb2 = new StringBuffer();
        System.out.println(sb2.append("hello"));
    }

    public static void main2(String[] args) {
        String str = "abcedf";
        str = str+"hello";
        System.out.println(str);
    }
    //上面汇编中 实质是下面这种 实现方式 4.1
    public static void main3(String[] args) {
        String str ="abcdef";
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("hello");
        str = sb.toString();
        System.out.println(str);
    }

    public static void main(String[] args) {
        String str = "abc";
        for (int i = 0; i <10 ; i++) {
           // str+=i;
            StringBuilder sb = new StringBuilder();
            str = sb.append(str).append(i).toString();
        }
        System.out.println(str);
        /*
         在循环中 不可以 使用String直接进行拼接 这样会产生大量的临时对象
         包括优化之后的StringBuilder对象
         * */
    }
    //针对上面的优化
    public static void main5(String[] args) {
        String str = "abc";
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        for (int i = 0; i <10 ; i++) {
          str = sb.append(i).toString();
        }
        System.out.println(str);
    }
}
