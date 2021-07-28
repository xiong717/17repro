import java.util.Scanner;

class Test{
    static int i = 0;
    public static void hello(){
        System.out.println("hello");
    }
    public int amethmod(){
       // static int i = 0; 报错 static是不允许用来修饰局部变量
        i++;
        return i;
    }

}
public class TestDemo2 {

        public static boolean isAdmin(String userId){
            String str = userId.toLowerCase() ;
            return str =="admin";
        }
        public static void main1(String[] args){
            System.out.println(isAdmin("Admin"));
            //false == 比较的是对象的地址

        }
        public static void main2(String[] args){
            Test test = null;
            test.hello(); //编译通过 并能正常运行
        }

    public static void main3(String[] args) {
        Test test = new Test();
        test.amethmod();
        int j = test.amethmod();
        System.out.println(j);
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] arr = new int[num+1];
        for(int i = 0; i<num;i++){
            arr[i] = scanner.nextInt();
        }
        int j=0;
        int count = 0;
        while(j<num){
            if(j<num && arr[j]<arr[j+1]){
                while(arr[j]<arr[j+1]){
                    j++;
                }
                count++;
                j++;
            }else if(arr[j] == arr[j+1]){
                j++;
            }else{
                while(j<num && arr[j] > arr[j+1]){
                    j++;
                }
                count++;
                j++;
            }
        }
        System.out.println(count);
    }
}
