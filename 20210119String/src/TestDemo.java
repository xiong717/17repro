import java.lang.reflect.Field;
import java.util.Arrays;

public class TestDemo {
    public static void main1(String[] args) {
        //创建字符串
        String str = "hello";
        System.out.println(str);

        String str2 = new String("hello");
        System.out.println(str2);

        char[] array = {'h','e','l','l','0'};
        String str3 = new String(array);
        System.out.println(str3);
    }

    public static void main2(String[] args) {
        String str = "hello";
        String str2 = new String("hello");
        char[] array = {'h','e','l','l','0'};
        String str3 = new String(array);

        //String 使用 == 比较并不是在比较字符串内容, 而是比较两个引用是否是指向同一个对象.
        //== 比较的是str 和 str2里面的内荣 str 和 str2里面的内容是地址
        System.out.println(str==str2);//false
        System.out.println(str==str3);//false
        System.out.println(str2==str3);//false
    }

    public static void main3(String[] args) {
        String str1 = "abcde";
        String str2 = new String("abcde");
        System.out.println(str1==str2); //false

        String str3 = "abc"+"de";//字符常量在编译时候就进行了编译
        System.out.println(str3 == str1);//true

        String str4 = new String("abc")+new String("de");
        System.out.println(str4 == str1);//false

        String str5 = new String("abc")+"de";
        System.out.println(str1 == str5);//false

        System.out.println(str4 == str5);//false
    }

    public static void main4(String[] args) {
        String str2 = new String("abcde").intern();
        String str1 = "abcde";
        System.out.println(str1==str2);//true
        //使用 String 的 intern 方法来手动把 String 对象加入到字符串常量池中
    }

    public static void main5(String[] args) {
        String str1 = "abcde";
        String str2 = new String("abcde");
        System.out.println(str1==str2);
        System.out.println(str1.equals(str2));
    }

    public static void main6(String[] args) throws IllegalAccessException {
        //字符串是不可变的
        String str1 = "ABC";
        str1 = str1+"DE";
        str1 = str1+"FG";
        System.out.println(str1);
        //String 类的内部实现也是基于 private final char value[]来实现的 是不可变的
        //+= 之后 str1 打印的结果却是变了, 但是不是 String 对象本身发生改变, 而是 str 引用到了其他的对象

        //要是实在想修改字符串 就可以用反射
        Class c1 = String.class;//拿到class对象
        // 获取 String 类中的 value 字段. 这个 value 和 String 源码中的 value 是匹配的.
        Field valueField = null;
        try {
            valueField = c1.getDeclaredField("value");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        // 将这个字段的访问属性设为 true
        valueField.setAccessible(true);
        // 把 str 中的 value 属性获取到.
        char[] value = (char[]) valueField.get(str1);
         // 修改 value 的值
        value[0] = 'h';
        System.out.println(str1);
    }

    /**
     * 字符与字符串
     * @param args
     */
    public static void main7(String[] args) {

        char value[] = {'h','e','l','l','o'};
        String str1 = new String(value);//将字符数组变为字符串
        String str2 = new String(value,1,3);//将部分字符数组变为字符串
        System.out.println(str1);
        System.out.println(str2);

        String str3 = "hello";
        char ch = str3.charAt(4);//获取指定位置的字符
        System.out.println(ch);

        //将字符串变为字符数组
        char[] chars = str3.toCharArray();
        System.out.println(Arrays.toString(chars));
    }

    public static void main8(String[] args) {
        //逆置字符串 先可以转化为字符数组 再逆置
        String str = "abcde";
        System.out.println(str);
        String str1 = reverse(str);
        System.out.println(str1);
    }
    public static String reverse(String str){
        char[] chars = str.toCharArray();
        int i = 0;
        int j = chars.length-1;
        while (i < j){
            char tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;
            i++;
            j--;
        }
        //将数组转化为字符串
        //return new String(chars);
        //return String.copyValueOf(chars);
        return String.valueOf(chars);
    }


}
