import java.util.Scanner;

public class TestDemo5 {
    public static void main1(String[] args) {
        int x ,y;
        x= 5>>2;//右移 最右侧位不要了，最左测补符号位(正数补0 负数补1) 相当于除以2^n 5/4
        y = x>>>2;//无符号右移 最右侧不要了 最左侧补0
        System.out.println(y);
    }

    public static void main2(String[] args) {
        StringBuffer a = new StringBuffer("A");
        StringBuffer b = new StringBuffer("B");
        operate(a,b);

        System.out.println(a+"."+b);//AB.B
    }

    private static void operate(StringBuffer a, StringBuffer b) {
    a.append(b);
    b = a;
    }

   /* public static void main(String[] args) {
        String s ;//Error:(24, 33) java: 可能尚未初始化变量s
        System.out.println("s="+s);
    }*/

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String str1 = scan.nextLine();
        String str2 = scan.nextLine();
        int len = str1.length();
        int n =0;
        for(int i=0;i<len;i++){
            StringBuffer s1 = new StringBuffer(str1);
            s1.insert(i,str2);
            StringBuffer tmp = new StringBuffer(s1);
            StringBuffer s2 = tmp.reverse();
            if(s1.toString().equals(s2.toString())){
                n++;
            }
        }
        System.out.println(n);
    }

}






