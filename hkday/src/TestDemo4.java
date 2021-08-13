import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TestDemo4 {
    public static void main1(String[] args){
        Scanner scan = new Scanner(System.in);
        int[] arr = new int[4];
        for(int i = 0 ; i<4;i++){
            arr[i] = scan.nextInt();
        }
        int a = arr[0];
        int b = arr[1];
        int c = arr[2];
        int d = arr[3];

        int A = (a+c)/2;
        if(2*A != a+c ){
            System.out.println("No");
            return;
        }
        int B = (b+d)/2;
        if(2*B != b+d ){
            System.out.println("No");
            return;
        }
        int C = d-B;
        if (A-B == A&& B-C== b && A+B==c && B+C == d){
            System.out.print(A+" "+B+" "+C);
        }else {
            System.out.println("No");
            return;
        }
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();
        int n = scan.nextInt();

        StringBuilder s = new StringBuilder();
        String table = "0123456789ABCDEF";

        while(m!=0){
            int a = m%n;
            table.charAt(a);
            s.append(a);
            m = m/n;
        }
        s.reverse();
        System.out.print(s);
    }
}
