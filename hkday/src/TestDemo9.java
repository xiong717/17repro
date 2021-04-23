import java.util.ArrayList;
import java.util.Scanner;

public class TestDemo9 {
    //数字颠倒
    public static void main1(String[] args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        String st = "" + a;
        char[] ch = st.toCharArray();
        ArrayList al = new ArrayList<>();
        for(int i = ch.length - 1; i >= 0; i--){
            al.add(ch[i]);
        }
        for(int i = 0; i < al.size(); i++){
            System.out.print(al.get(i));
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(reverse(n));
    }
    private static String reverse(int n) {
        // String.valueOf(Object obj)返回字符串形式 -- 该方法允许null
        String str = String.valueOf(n);
        StringBuffer sb = new StringBuffer();
        for (int i = str.length() - 1; i >= 0; i--) {
            // append(String s) -- 将指定的字符串追加到此字符序列
            // charAt(i) -- 返回指定索引处的字符
            sb.append(str.charAt(i));
        }
        // toString() -- 返回此序列中数据的字符串表示形式。
        return sb.toString();
    }
}
