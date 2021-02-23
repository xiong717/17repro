import java.util.Scanner;

public class hk {
    //有一组数据，只有一个数字是出现一次，其他是两次，请找出这个数字。
   /* 运用异或运算，任何一个数字异或它自己都等于0。
如果我们从头到尾依次异或数组中的每一个数，那么最终的结果就是那个只出现一次的数字，
因为其他出现两次的数字全部在异或中被抵消为0了（异或运算遵循交换分配率）
   2  3  4  2  3
所有数字依次异或运算：2 xor 3 xor 4 xor 2 xor 3 = (2 xor 2) xor (3 xor 3) xor 4= 0 xor 0 xor 4 = 4
    */
    public static int find(int []arr) {
        int result = arr[0];
       for (int i=1;i<=arr.length-1;i++) {
           result ^=arr[i];
       }
       return  result;
    }

    public static void main1(String[] args) {
        int []arr={11,22,55,33,55,33,22,11,88};
        System.out.println(find(arr));
    }
    //求斐波那契数列的第n项。(迭代实现)
    public static int fib(int n ) {
        int first = 1;
        int second = 1;
        int ret = 0;
        if (n  == 1 || n == 2) {
            return 1;
        }else {
            for (int i = 3; i <= n; i++) {
                ret = first + second;
                first = second;
                second = ret;
            }
            return ret;
        }
    }

    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(fib(n));
    }

    //求1！+2！+3！+4！+........+n!的和
    public static void main3(String[] args) {
        //求1！+2！+3！+4！+........+n!的和
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ret = Fact(n);
        System.out.println(ret);
    }

    public static int Fact (int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            int ret = 1;
            for (int j=1; j<=i; j++) {
                ret *= j;
            }
            sum += ret;
        }
        return sum;
    }

    public static int fac(int n) {
        int ret = 1;
        if(n == 1) {
            return 1;
        }
        return n*fac(n-1);
    }

    public static void main4(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int sum = 0;
        for (int i = 1; i<=num; i++) {
            sum += fac(i);
        }
        System.out.println(sum);
    }

    //求 N 的阶乘
    public static void main5(String[] args) {

        System.out.println(fac(5));
    }

    //调整数组顺序使得奇数位于偶数之前。调整之后，不关心大小顺序。
    public static void main6(String[] args) {
        int []arr1={1,5,2,4,7,8,9};
        int []arr2=new int[arr1.length];
        int left = 0;
        int right = arr1.length-1;
         for (int i = 0; i <arr1.length;i++) {
             System.out.print(arr1[i]+" ");
         }
        System.out.println();
         for (int i = 0; i< arr1.length;i++) {
             if (arr1[i]%2 != 0) {
                 arr2[left]=arr1[i];
                 left++;
             }else{
                 arr2[right] = arr1[i];
                 right--;
             }
         }
         for (int i = 0; i<arr2.length;i++) {
             System.out.print(arr2[i]+" ");
         }
    }

}



