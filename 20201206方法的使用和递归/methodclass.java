public class methodclass {
    //计算1！+2！+3！+4！+5！
    public static int fac(int n) {
        int ret = 1;
        for (int i = 1; i <= n; i++) {
            ret *= i;
        }
        return ret;
    }

    public static int facNum(int num) {
        int sum = 0;
        for (int i = 1; i <= num; i++) {
            sum += fac(i);
        }
        return sum;
    }

    public static void main1(String[] args) {
        System.out.println(facNum(5));
    }
    /*返回值的重要性：为了支持链式表达式：可以将当前函数的返回值 作为另一个参数的参数
    或者 在另一个函数当中进行运算
     */

     //用方法实现两个整数相加
    public static int add(int i, int j) {
        return i+j;
    }
    public static void main2(String[] args) {
        int a = 20;
        int b = 30;
        int result = add(a,b);
        System.out.println(result);
    }

    //交换两个整型变量
    public static void swap(int a,int b) {
        int tmp = a;
        a = b;
        b = tmp;
        //只交换了形参值 未交换实参值 在Java中 形参在栈上 栈上的地址不可能拿到
    }

    public static void main3(String[] args) {
        int a = 10;
        int b = 20;
        swap(a,b);
        System.out.println("a="+a +" b="+b);
    }
    /*
    解决方法 ：传引用类型参数（例如数组）
     */

    public  static void swap1(int[] arr) {
        int tmp = arr[0];
        arr[0] = arr[1];
        arr[1] = tmp;
    }

    public static void main4(String[] args) {
        //引用类型  引用:指针:引用实际上就是一个变量 用来存储地址
        int arr[]={10,20};
        System.out.println("a= "+arr[0]+" b="+arr[1]);
        swap1(arr);
        System.out.println("a= "+arr[0]+" b="+arr[1]);
    }
    //重载
    /*
    重载 需满足 3个要求：一 方法名相同 二 参数列表不同（类型和个数）三 返回值不做要求
     */
    public static void main5(String[] args) {
       /* System.out.println(sum(1,2));
        System.out.println(sum(1.4567,2.5678));
        System.out.println(sum(1,2,3));
        System.out.println(sum(1.0,2.3));
        */
        System.out.println(sum(1,2,3,4,5,6));
        System.out.println(sum(1,2,5));
    }
    public static int sum(int a,int b) {
        return a+b;
    }
    public static int sum(int a,int b,int c) {
        return a+b+c;
    }
    public static double sum(double a,double b) {
        return a+b;
    }
    public static float sum(float a,float b) {
        return a+b;
    }
    public static int sum(int...array) {
        int ret = 0;
        for (int x:array) {
            ret += x;
        }
        return ret;
    }
    /**
      可变参数编程
      传过来的数据  可以看做是一个数组。
      局限性：int... array  传过来的一组数据  一定都是相同的数据类型
     */


    //
    public static void main6(String[] args) {
      int n = 5;
      int ret = fac1(n);
        System.out.println(ret);
    }
    public static int fac1(int n) {
        if (n == 1) {
            return 1;
        }
        int tmp = n*fac1(n-1);
        return tmp;
    }
    //按顺序打印数字每一位
    public static void main7(String[] args) {
        print(1234);
    }
    public static void print(int n) {
        if (n > 9) {
            print(n/10);
        }
        System.out.print(n%10+" ");
    }
 //递归求1+2+3+  +10
    public static int sumOr(int num) {
        if (num == 1) {
            return 1;
        }
        return num+sumOr(num-1);
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println(sumOr(n));
    }


}



