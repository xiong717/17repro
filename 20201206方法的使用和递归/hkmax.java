import com.sun.deploy.security.SelectableSecurityManager;

import java.util.Scanner;

public class hkmax {
    //创建方法求两个数的最大值max2，随后再写一个求3个数的最大值的函数max3。
    //​ 要求：在max3这个函数中，调用max2函数，来实现3个数的最大值计算
    public static int max2(int a,int b) {
        if (a>=b){
            return a;
        }
            return b;
    }

    public static int max3(int a,int b,int c) {
        int ret=max2(a,b);
        if (ret>= c){
            return ret;
        }
        return c;
    }

    public static void main1(String[] args) {
        System.out.println(max2(20,79));
        System.out.println(max3(28,34,22));
    }

    //在同一个类中定义多个方法：要求不仅可以求两个整数的最大值，还可以求两个小数的最大值，以及两个小数和一个整数的大小关系

    public static int max(int a,int b) {
        if (a >= b){
            return a;
        }
        return b;
    }
    public static double max(double a,double b) {
        if (a >= b){
            return a;
        }
        return b;
    }
    public static double max(double a,double b,int c) {
        int ret = 0;
        if (a >= b){
            ret = (int)a;
        }
        ret = (int) b;
         if (ret >= c) {
             return ret;
         }
         return c;
    }

    public static void main2(String[] args) {
        System.out.println(max(2,4));
        System.out.println(max(2.356,7.567));
        System.out.println(max(2.3456,2.345,3));
    }

    //在同一个类中,分别定义求两个整数的方法 和 三个小数之和的方法。 并执行代码，求出结果
    public static int sum(int a,int b) {
        return a+b;
    }
    public static double sum(double a,double b,double c) {
        return a+b+c;
    }

    public static void main3(String[] args) {
        System.out.println(sum(2,4));
        System.out.println(sum(4.5,6.7,2.4));
    }

    //写一个递归方法，输入一个非负整数，返回组成它的数字之和
    public static int sumOr(int n) {
        if (n <= 9) {
            return n;
        }
        return sumOr(n/10)+(n%10);
    }

    public static void main4(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        System.out.println(sumOr(num));
    }

    //按顺序打印一个数字的每一位(例如 1234 打印出 1 2 3 4) （递归）
    public static void print(int n) {
        if (n > 9){
            print(n/10);
        }
        System.out.print(n%10+" ");
    }

    public static void main5(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        print(num);
    }
    //递归求 1 + 2 + 3 + ... + 10
    public static int sumShu (int num) {
        if (num ==1 ) {
            return 1;
        }
        return num+sumShu(num-1);
    }

    public static void main6(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        System.out.println(sumShu(num));
    }

    //递归求 N 的阶乘
    public static int facon(int n) {
        if (n == 1) {
            return 1;
        }
        return n*facon(n-1);
    }

    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        int num = scanner.nextInt();
        System.out.println(facon(num));
    }
}
