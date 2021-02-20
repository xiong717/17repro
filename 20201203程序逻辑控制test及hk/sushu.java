import java.util.Scanner;

public class sushu {
       //判断一个数字是否是素数 三种方法
       public static void main1(String[] args) {
           Scanner scanner = new Scanner(System.in);
           while (scanner.hasNextInt()) {//循环读入
               int num = scanner.nextInt();
               int i = 2;
               for (i = 2; i < num; i++) {
                   if (num % i == 0) {
                       System.out.println("不是素数");
                       break;
                   }
               }
               if (i >= num) {
                   System.out.println("是素数");
               }
           }
       }

    public static void main2(String[] args) {
           //第二种方法 开根号 因为一个数字都是a*b这形式 所以肯定有一个数字<=k开根号
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int num = scanner.nextInt();
            int i = 2;
            for (i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    System.out.println("不是素数");
                    break;
                }
            }
            if (i > Math.sqrt(num)) {
                System.out.println("是素数");
            }
        }
    }
   //筛选法

    //求0-100数字9出现的次数
    public static void main3(String[] args) {
        int count = 0;
        for (int i = 1; i<= 100; i++){
            if (i % 10 == 9){//个位数是9
                count++;
            }else  if (i / 10 == 9){ //十位数是9
                count++;
            }
        }
        System.out.println(count);
    }
    //求 0-999999 的自幂数 先计算每个数字有几位数，然后各个位数的几次方  是否等于 原数
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();//999999
        for (int i = 1; i <= n ; i++) {
            int count = 0;//每个数字有几位数
            int tmp = i ;
            while (tmp != 0) {
                count++;
                tmp = tmp/10;
            }
            //count
            tmp = i;
            int sum = 0;
            while (tmp != 0) {
                sum += Math.pow(tmp%10,count);
                tmp = tmp/10;
            }
            if(sum == i) {
                System.out.println(i);
            }
        }
    }
}

