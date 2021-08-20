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
    public static void main2(String[] args) {
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

    public static void main3(String[] args) {
        String x = "fmn";
        x.toUpperCase();
        String y = x.replace('f','F');
        y = y+"wxy";
        System.out.println(y);
    }
    static class Person {
        String name = "No name";
        public Person(String nm) {
            name = nm;
        }

    }
    static class Employee extends Person {
        String empID = "0000";
        public Employee(String id) {
            super(id);//注意要有super
            empID = id;
        }
    }

    public static void main4(String args[]) {
            Employee e = new Employee("123");
            System.out.println(e.empID);
    }



        private static void testMethod(){
            System.out.println("testMethod");
        }
        public static void main5(String[] args) {
            TestDemo9.testMethod();
        }

        //末尾0 的个数
    public static void main6(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        int count =0;
        for( int i=1; i<=num;i++){
            int m =i;
            while(m%5 == 0){
                count++;
                m=m/5;
            }
        }
        System.out.println(count);
    }

        public static void main7(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int num = scanner.nextInt();
            int count=0;
            while (num>0) {
                count+=num/5;
                num/=5;
            }
            System.out.println(count);
        }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        String s = revers(num);
        System.out.print(s);
    }
    public static String revers(int num){
        String s = String.valueOf(num);
        StringBuffer sb = new StringBuffer();
        for(int i = s.length()-1;i>=0;i--){
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

}

