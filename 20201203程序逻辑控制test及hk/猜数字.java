import java.util.Random;
import java.util.Scanner;

public class 猜数字 {
   // 完成猜数字游戏 ，用户输入数字，判断该数字是大于，小于，还是等于随机生成的数字，等于的时候退出程序。
    public static void main(String[] args) {
        Random random = new Random();//默认随机种子是系统时间
        Scanner scanner = new Scanner(System.in);
        int toGuess = random.nextInt(100);
        while(true){
            System.out.println("请输入要输入数字（1-100）");
            int num = scanner.nextInt();
            if (num < toGuess){
                System.out.println("低了");
            }else if(num > toGuess){
                System.out.println("高了");
            }else{
                System.out.println("猜对了");
                break;
            }
        }
        scanner.close();
    }
}
