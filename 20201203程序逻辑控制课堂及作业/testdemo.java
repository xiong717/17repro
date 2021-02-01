import java.util.Scanner;

public class testdemo {
    public static void main1(String[] args) {
        int a = 10;
        String str = a + "";
        System.out.println(str);
        String ret = String.valueOf(a);//int转化为string
        System.out.println(ret);
        String str1 = "199";
        int c = Integer.valueOf(str1);//string转化为int
        System.out.println(c);
        int b = c + 1;
        System.out.println(b);
    }

    public static void main2(String[] args) {
        System.out.println(4 / 8.0);
        System.out.println(10 % 3);//1
        System.out.println(11.5 % 2.0);//可以算小数的余数
        //% 可以对int求模，也可对double求模
        //System.out.println(8/0);
        System.out.println("fsdafihasfhsdlifhsal");
        int a = 10;
        System.out.println(++a);//返回值是11
        System.out.println(a++);//返回值是10
        //如果不取自增运算表达式的返回值 则前置自增和后置自增无区别
        //如果取自增运算表达式的返回值，则前置返回值是自增之后的值，后置是自增之前的值
        int b = 10;
        b = b++;// java的反汇编
        System.out.println(b);//10
    }

    public static void main3(String[] args) {
        //关系运算符 表达式的返回值都是Boolean类型
        int a = 10;
        int b = 20;
        System.out.println(a <= b);
        System.out.println(!(a <= b));
        int c = 30;
        System.out.println(a < b && b < c);//逻辑与
        System.out.println(a < b || b < c);//逻辑或
        //System.out.println(!a<b);
        System.out.println(10 > 20 && 10 / 0 == 0);//&&和||遵守短路求值
        System.out.println(10 < 20 || 10 / 0 == 0);
    }

    public static void main4(String[] args) {
        //位运算符 &（按位与） |（按位或） ~按位取反 ^按位异或
        int a = 10;//1010
        int b = 20;//10100
        System.out.println(a & b);
        System.out.println(a | b);
        System.out.printf("%x\n", ~a);
        System.out.println(a ^ b);
    }

    public static void main5(String[] args) {
        //移位运算符 左移<< 右移>> 符号位为正补0 为负补1 无符号右移>>> 最右位不要了 最左补
        int a = 10;//0000 1010
        System.out.println(a << 1);//0001 0100 乘2^n
        System.out.println(a << 2);//0010 1000 *2^2
        System.out.println(a >> 1);//0000 0101 除2^n
        System.out.println(a >>> 1);
        //面试题如何将一个数快速的扩大8位--> 给这个数左移3位

        //条件运算符 求两个数最大值
        int b = 10;
        int c = 20;
        int max = b > c ? b : c;
        System.out.println(max);
    }

    public static void main6(String[] args) {
        //if语句 判断是否是闰年
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        if (year % 100 != 0 && year % 4 == 0 || year % 400 == 0) {
            System.out.println(year + " 是闰年");
        } else {
            System.out.println(year + " 不是闰年");
        }
    }

    public static void main7(String[] args) {
        //面试问题：不能做switch的参数的数据类型 有哪些?
        //1、long   float    double    boolean
        //JDK1.5引入了枚举   switch的参数也可以是枚举
        int a = 1;
        switch (a) {
            case 1:
                System.out.println("1");
                break;
            case 2:
                System.out.println("2");
                break;
            case 3:
                System.out.println("3");
                break;
            default:
                System.out.println("输入有误");
                break;
        }
    }

    public static void main8(String[] args) {
        //计算1-10所有奇数的和
        int sum = 0;
        int i = 1;
        while (i <= 10){
            sum += i;
            i += 2;
        }
        System.out.println(sum);
        //计算1-10所有偶数的和
        int sumEve = 0;
        int j = 0;
        while (j <= 10){
            sumEve += j;
            j += 2;
        }
        System.out.println(sumEve);
    }

    public static void main9(String[] args) {
        //计算5的阶乘
        int n = 1;
        int result = 1;
        while (n <= 5) {
            result *= n;
            n++;
        }
        System.out.println(result);
        //计算3!+2!+1!阶乘之和
        int j = 1;
        int sumFac = 0;
        while (j <= 3){
             int i1 = 1;
             int ret = 1;
         while (i1 <= j){
             ret *= i1;
             i1++;
         }
             sumFac += ret;
             j++;
        }
        System.out.println(sumFac);
    }

    public static void main10(String[] args) {
        //找到100-200之间第一个3的倍数 break continue
        int i = 100;
        int num = 200;
        while (i <= num){
            if (i % 3 == 0){
                System.out.println(i);
                break;
                //continue;出错了会死循环
            }
            i++;
        }
    }

    public static void main(String[] args) {
        //for循环
        for(int i = 1;i <= 10; i++){
            System.out.println(i);
        }
    }
}
