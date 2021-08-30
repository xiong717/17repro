import java.util.Scanner;

public class TestDemo12 {
    public static void main1(String[] args) {
        String str1 = "hello";
        String str2 = "he" + new String("llo");
        System.err.println(str1 == str2);
        int a=1;
        System.out.println(a++);
        System.out.println(++a);
    }

    //二进制插入
    public class BinInsert {
        public int binInsert(int n, int m, int j, int i) {
            // write code here
            m = m<<j;//先把m 左移j位
            return m|n;
        }
    }
    
    //查找组成一个偶数最接近的两个素数
        public static void main(String[] args){
            Scanner scan = new Scanner(System.in);
            int num = scan.nextInt();
            int n = num/2;
            for(int i=n;i>=1;i--){
                if(isframe(i)&&isframe(num-i)){
                    System.out.println(i);
                    System.out.println(num-i);
                    break;
                }

            }

        }
        public static boolean isframe(int num){
            for(int i = 2;i<num;i++){
                if(num%i==0){
                    return false;
                }
            }
            return true;
        }



}
