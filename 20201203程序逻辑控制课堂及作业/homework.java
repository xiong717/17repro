import java.util.Scanner;

public class homework {
    public static void main1(String[] args) {
        //编写程序数一下 1到 100 的所有整数中出现多少个数字9
        for (int i = 1;i <= 100;i++){
            if(i%10 == 9){
                System.out.println(i);
            }
        }
    }

    public static void main2(String[] args) {
        //输出 1000 - 2000 之间所有的闰年
        for(int i = 1000;i <= 2000;i++){
            if(i % 4 == 0 && i % 100 != 0 || i % 400 == 0 ){
                System.out.println("闰年 "+i);
            }
        }
    }

    public static void main3(String[] args) {
        //打印 1 - 100 之间所有的素数
        for(int i = 1;i <= 100; i++){
            boolean flag = true;
            for(int j = 2; j < i;j++){
               if (i % j == 0){
                   flag = false;
                   break;
               }
            }
            if(flag){
                System.out.print(i+" ");
            }
        }
    }

    public static void main4(String[] args) {
       // 给定一个数字，判定一个数字是否是素数
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int i = 2;
        for (i = 2; i < num; i++) {
            if (num % i == 0) {
                System.out.println(num+" 不是素数");
                break;
            }
            if(i == num) {
                System.out.println(num + " 是素数");
            }
        }
    }


        public static void main5(String[] args) {
            // 给定一个数字，判定一个数字是否是素数
            Scanner s=new Scanner(System.in);
            System.out.print("请输入一个数：");
            int data=s.nextInt();
            s.close();
            boolean isPrime=true;
            for( int i=2;i<Math.sqrt(data);i++) {
                if(data%i==0) {
                    isPrime=false;
                    break;
                }
            }
            if(isPrime==true) {
                System.out.println(data+"是素数");
            }else {
                System.out.println(data+"不是素数");
            }
        }

    public static void main6(String[] args) {
        // 根据输入的年龄, 来打印出当前年龄的人是少年(低于18), 青年(19-28), 中年(29-55), 老年(56以上)
        Scanner scanner = new Scanner(System.in);
        int age = scanner.nextInt();
        if (age < 0) {
            System.out.println("输入有误");
        }else if(age > 0 && age <= 18){
            System.out.println("是少年");
        }else if(age > 18 && age <= 28){
            System.out.println("是青年");
        }else if(age > 29 && age <= 55){
            System.out.println("是中年");
        }else if (age > 56){
            System.out.println("是老年");
        }
    }

    public static void main7(String[] args) {
        //打印X图形
        Scanner s = new Scanner(System.in);
        int num = s.nextInt();
        int n = 1;
        int m = 1;
        for(n=1;n <= num; n++){
            for (m = 1; m <= num; m++){
                if(n==m ){
                    System.out.printf("*");
                }else if(n + m == num+1){
                    System.out.printf("*");
                }
                else{
                    System.out.printf(" ");
                }
            }
            System.out.printf("\n");
        }
    }
}


