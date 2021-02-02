import java.util.Scanner;

public class hk {
    public static void main1(String[] args) {
        //编写代码模拟三次密码输入的场景。
        // 最多能输入三次密码，密码正确，提示“登录成功”,密码错误，可以重新输 入，最多输入三次。三次均错，则提示退出程序
        int time = 3;
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()){
            String passWord = scanner.nextLine();
            if(passWord.equals("123456")){
                System.out.println("登录成功");
            }else{
                time--;
                System.out.println("密码错误");
            }
            if (time <= 0){
                System.out.println("登录失败");
                break;
            }
        }
    }

    public static void main2(String[] args) {
        //输出一个整数的每一位，如：123的每一位是1 ， 2 ， 3
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        while(num!=0){
            System.out.print(num%10+" ");
            num = num/10;
        }
    }

    public static void main(String[] args) {
        //输出n*n的乘法口诀表，n由用户输入
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i<=n; i++){
            for(int j =0; j<=i;j++){
                System.out.print(i+"*"+j+"="+i*j+" ");
            }
            System.out.println();
        }
    }


}

