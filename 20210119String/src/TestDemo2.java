public class TestDemo2 {

    //字符串的比较
    public static void main1(String[] args) {
        String str1 = "abcd";
        String str2 = "abcd";
        String str3 = new String("abcd");
        String str4 = "ABcd";
        String str5 = "adcd";

        System.out.println(str1 == str3);
        System.out.println(str1.equals(str2));//区分大小写的比较
        System.out.println(str1.equalsIgnoreCase(str4));//不区分大小写的比较
        System.out.println(str1.compareTo(str5));//比较两字符串的大小
        System.out.println("=====================");
        System.out.println("A".compareTo("a")); // -32
        System.out.println("a".compareTo("A")); // 32
        System.out.println("A".compareTo("A")); // 0
        System.out.println("AB".compareTo("AC")); // -1
        System.out.println("刘".compareTo("杨"));


        System.out.println("=================");

        String s1 = "hello";
        String s2 = "world";
        String s3 = "hello"+"world";
        String s4 = s1+"world";//s4不一样 因为s1是变量 编译时不知道 运行时才知道变量存储的内容
        String s5 = s1+s2;

        System.out.println(s3 == s4);
        System.out.println(s3 == s5);
        System.out.println(s4 == s5);
    }

    //字符串的查找
    public static void main2(String[] args) {
        String s1 = "abcddedgf";
        System.out.println(s1.contains("ed"));
        System.out.println(s1.indexOf("ddeg"));//-1 没有找到 找到的话 就返回的是坐标值
        System.out.println(s1.indexOf("dde", 1));// 从1开始找

        System.out.println("===========================");
        String s2 = "ababcabcd";
        System.out.println(s2.lastIndexOf("ab"));//从后向前 查找子字符串位置
        System.out.println(s2.lastIndexOf("ab", 4));//从fromindex开始往前找

        System.out.println(s2.startsWith("ba"));//判断是否以指定字符串开头
        System.out.println(s2.startsWith("ab"));
        System.out.println(s2.startsWith("ab",5));
        //从指定位置开始判断是否以指定字符串开头
        System.out.println(s2.endsWith("abcd"));//判断是否以指定字符串结尾
    }

    //字符串替换
    public static void main3(String[] args) {
      String str = "ababcabcdabcde";
        System.out.println(str.replaceAll("ab", "xx"));//替换所有的指定内容
        System.out.println(str.replaceFirst("ab", "xx"));//替换首个内容
        System.out.println(str.replace("ab","xx"));
    }

    //字符串拆分
    public static void main4(String[] args) {
       String string = "username=zhangsan&passsword=123";
       String[] strings = string.split("&");//拆分成两个数组
       for (int i = 0;i < strings.length;i++) {
           String[] strings1 = strings[i].split("=");
          /* for (int j = 0; j<strings1.length;j++) {
               System.out.println(strings1[j]);//拆分成四个数组
           }*/
           System.out.println(strings1[1]);//获取名字密码
       }
    }

    public static void main5(String[] args) {
        String string = "username=zhangsan&passsword=123";
        String[] strings = string.split("=",2);
        //limit表示最多将字符数组切分为几组
        for (int i = 0; i < strings.length; i++) {
            System.out.println(strings[i]);
        }
    }

    /*1. 字符"|","*","+"都得加上转义字符，前面加上"\".
      2. 而如果是""，那么就得写成"\\".
      3. 如果一个字符串中有多个分隔符，可以用"|"作为连字符
*/
    public static void main6(String[] args) {
        String str= "192.168.1.1";
        //System.out.println(str.split("\\."));不能这么写
        String[] strings = str.split("\\.");
        // 第一个 \ 表示\\ -> \转义字符  第二个\ 则是表示 \. -> . 转义
        for (int i = 0;i < strings.length;i++) {
            System.out.println(strings[i]);
        }
    }

    public static void main7(String[] args) {
        String str = "Java 30-split#bit";
        String[] strings  = str.split(" |-|#");
        for (int i = 0; i < strings.length; i++) {
            System.out.println(strings[i]);
        }
    }

    //字符串截取
    public static void main(String[] args) {
        String string = "abcdefg";
        System.out.println(string.substring(5));//表示从5开始到结尾
        System.out.println(string.substring(2, 5));//截取部分内容 前闭后开区间 包含2号下标的字符, 不包含5号下标
    }


}
