import java.util.Arrays;
import java.util.Scanner;

class Person {
    private String name = "Person";
    int age = 0;
}
class Base{
    public Base(String s){
        System.out.print("B");
    }

}
public class TestDemo3 extends Person{
    public static class child extends Person{
        public String grade;
        public static void main1(String[] args) {
            Person p = new TestDemo3();
            //System.out.println(p.name); 错误 name是private修饰的

        }
    }
    public static class Derived extends Base{

        public Derived(String s) {
            super(s);
            System.out.print("D");
        }
        public static void main2(String[] args) {
            new Derived("C");
        }
    }
    public static void reverse(char[] ch,int start,int end){
        while(start < end){
            char tmp = ch[start];
            ch[start] = ch[end];
            ch[end] = tmp;
            start++;
            end--;
        }
    }
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        char[] ch = str.toCharArray();
        int len = ch.length;
        //1.逆置整体
        reverse(ch,0,len-1);
        int i =0;//遍历字符数组
        while(i < len){
            int j = i;
            while(j<len && ch[j] != ' '){
                j++;
            }
            if(j < len){
                reverse(ch,i,j-1);
                i = j+1;
            }else{
                reverse(ch,i,j-1);
                i = j;
            }
        }
        String s = new String(ch);
        System.out.println(s);
    }
}