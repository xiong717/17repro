import java.util.Arrays;
import java.util.jar.JarOutputStream;

class Test{
    public String toString() {
        System.out.print("aaa");
        return "bbb";
    }
}

public class hk {
        static int cnt = 6;
        static{
            cnt += 9;
        }
        public static void main1(String[] args){
            System.out.println("cnt= " + cnt);
        }
        static{
            cnt /=3;
        };

    public static void main2(String[] args) {
        System.out.println(new Test());
    }
    //给定整型数组, 把所有的偶数放到数组前面, 把所有奇数放到数组后面.

    public static void change1(int[] arr) {
        for (int i = 0; i<arr.length;i++){
            int left = 0;
            int right = arr.length-1;
            while (left<right){

                if (arr[left]%2 == 0&&left<right) {
                    left++;
                }
                if (arr[right]%2 != 0&& left<right) {
                    right--;
                }
                int tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr ={1,3,6,8,5};
        change1(arr);
        for (int i =0; i<arr.length;i++) {
            System.out.print(arr[i]+" ");
        }
    }

    //给定两个整型数组, 交换两个数组的内容.
    public static void change(int[] arr1,int[] arr2) {
        for (int i = 0; i<arr1.length;i++) {
            int tmp = arr1[i];
            arr1[i] = arr2[i];
            arr2[i] = tmp;
        }
    }

    public static void main3(String[] args) {
        int[] arr1 = {1,2,3,4};
        int[] arr2 = {2,4,6,8};
        change(arr1,arr2);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }
}




