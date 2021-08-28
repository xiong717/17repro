import java.util.Scanner;

public class TestDemo10 {
  //2
   /* byte b1=1,b2=2,b3,b6;
    final byte b4=4,b5=6;
    b6=b4+b5;
    b3=(b1+b2);*/

    //3
    public static void main1(String[] args) {
        StringBuffer a = new StringBuffer("A");
        StringBuffer b = new StringBuffer("B");
        operator(a,b);
        System.out.println(a+" "+b);
    }

    private static void operator(StringBuffer x,StringBuffer y) {
        x.append(y);
        y=x;
    }

    //4
    public static void main4(String[] args) {
        Object o = new Object(){
            public boolean equals(Object obj){
                return true;
            }
        };
        System.out.println(o.equals("Fred"));
    }

    public static void main5(String[] args) {
    int Array_a[] = new int[10];
        System.out.println(Array_a[10]);
    }

        public int add(int a,int b){
            try {
                return a+b;
            }
            catch (Exception e) {
                System.out.println("catch语句块");
            }
            finally{
                System.out.println("finally语句块");
            }
            return 0;
        }
        public static void main6(String argv[]){
            TestDemo10 test =new TestDemo10();
            System.out.println("和是："+test.add(9, 34));
        }


    public static void main7(String[] args) {
        try{
            int i = 100 / 0;
            System.out.print(i);
        }catch(Exception e){
            System.out.print(1);
            throw new RuntimeException();
        }finally{
            System.out.print(2);
        }
        System.out.print(3);
    }

    /*
    * 给你一个N，你想让其变为一个Fibonacci数，
    * 每一步你可以把当前数字X变为X-1或者X+1，现在给你一个数N
    * 求最少需要多少步可以变为Fibonacci数。
    * */
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        int ret = fabnic(num);
        System.out.print(ret);
    }
    public static int fabnic(int num){
        int f1=0;
        int f2 = 1;
        while(num>f2){
            int f3 = f1+f2;
            f1 = f2;
            f2 = f3;
        }
        return (f2-num)>(num-f1)?num-f1:f2-num;
    }


    /*
    * 机器人走方格
    *
    * */

    public class Robot {
        public int countWays(int x, int y) {
            // write code here
            if(x==1 || y==1){
                return 1;
            }
            return countWays(x-1,y)+countWays(x,y-1);

        }
    }

}
