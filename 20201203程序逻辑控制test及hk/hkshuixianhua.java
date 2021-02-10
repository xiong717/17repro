import java.util.Scanner;

public class hkshuixianhua {
    
    public static void main1(String[] args) {
        //求出0～999之间的所有“水仙花数”并输出。“水仙花数”是指一个三位数，其各位数字的立方和确好等于该数本身
        for(int i = 0;i < 1000;i++){
           int ge = i%10;
           int shi = (i/10)%10;
           int bai = i / 100;
           if(Math.pow(ge,3)+Math.pow(shi,3)+Math.pow(bai,3) == i){
               System.out.println(i + "是水仙花数");
           }
        }
    }

    public static void main2(String[] args) {
        //计算1/1-1/2+1/3-1/4+1/5 …… + 1/99 - 1/100 的值
        int flag = 1;
        double sum = 0;
        for (int i=1; i <= 100; i++){
            sum += flag*1.0/i;
            flag=-flag;
        }
        System.out.println(sum);
    }

    public static void main3(String[] args) {
        //求两个正整数的最大公约数
        int a = 100;
        int b = 16;
        int c =1;
        while (a%b!=0){
            c=a%b;
            a=b;
            b=c;
        }
        System.out.println(b+"是最大公约数");
    }

    public static void main4(String[] args) {
        //求一个整数，在内存当中存储时，二进制1的个数。
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int count = 0;
        while (num != 0){
            if ((num & 1 )== 1){
                count++;
            }
            num = num>>1;
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        //获取一个数二进制序列中所有的偶数位和奇数位， 分别输出二进制序列
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        System.out.println("偶数数列");
        for (int i = 31; i>= 0; i=i-2){
            System.out.print((num>>i)&1);
        }
        System.out.println();
        System.out.println("奇数数列");
        for (int j =30;j>=0;j=j-2){
            System.out.print((num>>j)&1);
        }
    }
    }




