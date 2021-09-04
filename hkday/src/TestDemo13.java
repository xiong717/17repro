import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestDemo13 {


        static boolean out(char c){

            System.out.print(c);
            return true;
        }
        public static void main1(String[] argv){
            int i = 0;
            for(out('A');out('B') && (i<2);out('C')){
                i++;
                out('D');
            }
        }

    public static void main2(String args[]) {
        Thread t=new Thread(){
            public void run(){
                dianping();
            }
        };
        t.run();
        System.out.print("dazhong");
    }

    static void dianping(){
        System.out.print("dianping");
    }


    public static void main3(String[] args){
        Scanner scan = new Scanner(System.in);
        String s  = scan.nextLine();
        //先计算count
        int count = 1;
        for(int i=0;i<s.length();i++){
            //遇到引号 i++ 直到遇到下一个引号
            if(s.charAt(i) == '"'){
                i++;
                while (s.charAt(i) !='"'){
                    i++;
                }
            }
            //遇到空格
            if(s.charAt(i)==' '){
                count++;
            }
        }
        System.out.println(count);
        boolean flg = true;//双引号
        for(int i=0; i< s.length();i++){
            //遇到第一个引号 flag为false 遇到第二个引号后 flag= true
            if (s.charAt(i)=='"'){
                flg = !flg;
            }
            //打印除了 空格和“ 的字母
            if(s.charAt(i) !=' ' && s.charAt(i)!='"'){
                System.out.print(s.charAt(i));
            }
            //打印 两""号中的空格
            if (flg == false && s.charAt(i) == ' '){
                System.out.print(s.charAt(i));
            }
            //没有引号 遇到空格换行打印
            if (flg && s.charAt(i) == ' '){
                System.out.println();
            }
        }
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n= scan.nextInt();
        int m = scan.nextInt();
        int[] step = new int[m+1];
        for(int i=0;i< m+1;i++){
            step[i] = Integer.MAX_VALUE;
        }
        step[n] = 0;
        //遍历
        for(int i=n;i< m;i++){
            List<Integer> list = find(i);
            if(step[i] == Integer.MAX_VALUE){
                continue;
            }
            for(int j : list){
                if(i+j <=m && step[i+j] != Integer.MAX_VALUE){
                    step[i+j] = Math.min(step[i+j],step[i]+1);
                }else if(i+j<=m){
                    step[i+j] = step[i]+1;
                }
            }
        }
        if(step[m] == Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(step[m]);
        }
    }

    //找约数
    public static List<Integer> find(int num) {
        List<Integer>  list = new ArrayList<>();
        for(int i = 2;i< num;i++){
            if(num%i == 0) {
                list.add(i);
            }
        }
        return list;
    }
}
