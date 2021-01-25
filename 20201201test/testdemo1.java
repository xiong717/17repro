import sun.util.resources.ga.LocaleNames_ga;

public class testdemo1 {
    public static void main1(String[] args) {
        System.out.println("hello java");
        int a = -1;
        System.out.println(a);
        //在Java中，int既可以表示正数，也可以表示负数
        //int b=2147483648;报错了 int范围-2^31至2^31-1
        int maxValue = Integer.MAX_VALUE;
        int minValue = Integer.MIN_VALUE;
        System.out.println(Integer.MAX_VALUE);//int最大值
        System.out.println(Integer.MIN_VALUE);//int最小值
        System.out.println(maxValue + 1);
        System.out.println(minValue - 1);
    }

    public static void main2(String[] args) {
        //long占8个字节 表示范围-2^63至2^63-1
        long a = 10l;
        System.out.println(a);
        System.out.println(Long.MAX_VALUE);
        System.out.println(Long.MIN_VALUE);
        //DOUBLE占8个字节
        double b=9.9;
        double c=3.3;
        System.out.println("b="+b);
        System.out.println("b / c ="+b/c);//在程序中，小数是没有精确数字的
        System.out.println(b*c);
        //float 4
        float d = 12.5f;
        //char  2
        char e = 'A';
        char f = '喝';
        char g = 1397;//c中用ASCII表示字符，Java中用Unicode表示字符
        System.out.println("e="+e);
        System.out.println("f="+f);
        System.out.println("g="+g);
        //byte 字节类型 1个字节 8bit -128至127
        byte a1 = 1;
        byte a2 = 2;
        //byte a3 = a1+a2;报错 对于short byte这种比4个字节小的类型，会先提升为4个字节的int 在运算
        int a3 =a1+a2;
        System.out.println("a3="+a3);
        //short 短整型 2个字节
        short s =19;
        System.out.println("s="+s);
        /*布尔类型
        JVM标准 并未规定占几个字节 1字节 1比特
        在Java中 只有2个值 true false
         */
        int t=1;
        boolean flg = true;
        System.out.println(flg);
    }
    public static void main3(String[] args){
        /*
        字符串类型变量 string 引用类型
        +  拼接  任何类型的数据  和 字符串使用+进行拼接  其结果就是一个字符串
         */
        String str1="hello";
        String str2="bit";
        String str3=str1+str2;
        System.out.println(str3);
        int a=10;
        int b=20;
        System.out.println("a= "+a+" b= "+b);
        String str4="\\hello\\";
        System.out.println(str4);
        System.out.println("\"bit\"");
    }
    public static void main4(String[] args) {
        final int a=10;
        //a=18;
        //报错了 final关键字修饰的常量 不可改变的量 只能初始化一次
    }

    public static void main5(String[] args) {
        int a=10;
        long b=20;
        a=(int)b;//强制类型转换
        System.out.println(a);
        b=a;
        System.out.println(b);
        double c=18.3;
        c=a;
        System.out.println(c);
        //boolean类型不能强转
    }
    public static void main6(String[] args) {
        int a = 10;
        long b = 19;
        int c = (int)(a+b);
        System.out.println(c);
        byte b1 = 10;
        byte b2 = 20;
        byte b3 = (byte) (b1+b2);
        System.out.println(b3);
        //对于short byte这种比4个字节小的类型，cpu会先提升为4个字节的int 在运算
    }

    public static void main(String[] args) {
        int num=10;
        String str1=String.valueOf(num);
        System.out.println(str1);
        String str2="100";
        int a=Integer.valueOf(str2);
        //int string之间的相互类型转换
        System.out.println(a);
    }
}
