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

    //字符串中找出连续最长的字符串
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();

        String cur = "";
        String ret = "";
        int i=0;
        for(;i<str.length();i++)
        if (i == str.length() && cur.length()>ret.length() ){
            ret = cur;
        }
        System.out.print(ret);
    }

    //数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
    //思路一 ：先给数组排序，找到中间的数字x 遍历数组看x出现了多少次 超过数组长度的一半 则是
    public int MoreThanHalfNum_Solution(int [] array) {
        if(array.length == 0||array == null){
            return 0;
        }
        Arrays.sort(array);
        int mid = array.length/2;
        int count=0;
        for(int j= 0;j< array.length;j++){
            if(array[j]==array[mid]){
                count++;
            }
        }
        if(count>mid){
            return array[mid];
        }else{
            return 0;
        }
    }

    //思路二：找 众数
    //先设置一个 result和times 然后比较两个数是否相等， 不相等就消去这两个数 最坏情况下，每消去一个众数和非众数，那么如果存在众数的情况下，最后留下的数 就是众数
    //最后验证一下 遍历数组 看最后的result出现了几次
    public int MoreThanHalfNum_Solution2(int [] array) {
        if(array == null || array.length == 0){
            return 0;
        }
        int result = array[0];
        int times = 1;
        int len = array.length;
        for(int i =1; i<len;i++){
            if(times != 0){
                if(result != array[i]){
                    --times;
                }else{
                    ++times;
                }
            }else{
                times = 1;
                result = array[i];
            }
        }
        int count =0;
        for(int i =0;i<len;i++){
            if(result == array[i]){
                count++;
            }
        }
        if(count > len/2){
            return result;
        }
        return 0;
    }
}