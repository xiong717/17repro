import com.sun.org.apache.xml.internal.utils.StringToIntTable;

public class TestDemo7 {
    public static void main1(String[] args) {
        System.out.println("小数点后第一位=5");
        System.out.println("正数：Math.round(11.5)=" + Math.round(11.5));//12
        System.out.println("负数：Math.round(-11.5)=" + Math.round(-11.5));//-11
        System.out.println("小数点后第一位<5");
        System.out.println("正数：Math.round(11.46)=" + Math.round(11.46));//11
        System.out.println("负数：Math.round(-11.46)=" + Math.round(-11.46));//-11
        System.out.println("小数点后第一位>5");
        System.out.println("正数：Math.round(11.68)=" + Math.round(11.68));//12
        System.out.println("负数：Math.round(-11.68)=" + Math.round(-11.68));//-12
    }

    public static void main2(String[] args) {
        System.out.println(Math.ceil(11.3));
        System.out.println(Math.floor(11.3));
        System.out.println(Math.round(11.3));

        System.out.println(Math.ceil(-11.6));
        System.out.println(Math.floor(-11.6));
        System.out.println(Math.round(-11.6));

        System.out.println(Math.ceil(11.6));
        System.out.println(Math.floor(11.6));
        System.out.println(Math.round(11.6));

    }

    public static int StrToInt(String str) {
        if(str == null || str.isEmpty()){
            return 0;
        }
        int n=1;
        int num =0;
        char[] s = str.toCharArray();
        if (s[0] == '+'){
            n=1;
        }else if (s[0] == '-'){
            n=-1;
        }
        for (int i = 0; i < s.length; i++) {
            if (s[i] <'0'|| s[i] >'9'){
                break;
            }
            num = num*10+s[i]-'0';
        }
        return num*n;
    }
    public static void main(String[] args) {
        String str = "123";
        int num= StrToInt(str);
        System.out.println(num);
    }
}
