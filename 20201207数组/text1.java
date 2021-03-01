import javax.swing.*;
import java.util.Arrays;

public class text1 {
    //查找数组中指定元素（顺序查找）
    //给定一个数组, 再给定一个元素, 找出该元素在数组中的位置.
    public static void main1(String[] args) {
        int[] arr = {2,4,7,8,9,5};
        System.out.println(find(arr,4));
    }
    public static int find(int[] arr,int tofind) {
        for (int i = 0; i< arr.length; i++) {
            if (arr[i]== tofind) {
                return  i;
            }
        }
        return  -1;
    }

    //二分查找
    static int count = 0;
    public static void main2(String[] args) {
        /*int[] arr ={1,2,3,5,6,7,8,9,10};
        System.out.println(binartSearch(arr,9));
        System.out.println(count);
         */
        int[] arr = new int[10000];
        for (int i = 0; i<arr.length;i++) {
            arr[i] = i;
        }
        System.out.println(binartSearch(arr,9999));
        System.out.println("count :"+count);
    }

    public static int binartSearch(int[] arr,int tofind) {
        int left = 0;
        int right = arr.length-1;
        while (left<=right) {
            count++;
            int mid = (left+right)/2;
            if (tofind>arr[mid]) {
                left=mid+1;
            }else if (tofind<arr[mid]) {
                right = mid - 1;
            }else {
                return mid;
            }
        }
        return  -1;
    }

    //给定一个整型数组, 判断是否该数组是有序的(升序)
    public static void main3(String[] args) {
        int[] arr = {1,2,3,5,7,6};
        System.out.println(isSort(arr));
    }
    public static boolean isSort(int[] arr) {
     for (int i =0; i<arr.length;i++) {
         if (arr[i]>arr[i+1]) {
             return false;
         }
     }
     return true;
    }

    //冒泡排序 升序

    public static void main4(String[] args) {
        int[] arr = {7,6,5,4,1,2,3};
         bubbleSort(arr);
        System.out.println(Arrays.toString(arr));

        /*bubble(arr);
        System.out.println(Arrays.toString(arr));
         */
    }
    public static void bubbleSort(int[] arr) {
        for (int i = 0;i<arr.length;i++) {//外圈 循环的趟数

            for (int j =0; j<arr.length-1-i;j++) {

                if (arr[j]>arr[j+1]) {
                    int tmp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }

    //优化代码
    public static void bubble(int[] arr) {
        boolean flg = false;
        for (int i = 0;i<arr.length;i++) {
            flg = false;
            for (int j = 0; j < arr.length-1-i;j++) {
                if (arr[j]>arr[j+1]) {
                    int tmp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j]= tmp;
                    flg = true;
                }
            }
            if (flg == false) {
                return;
            }
        }
    }

    //数组逆序
    /*设定两个下标, 分别指向第一个元素和最后一个元素. 交换两个位置的元素.
            然后让前一个下标自增, 后一个下标自减, 循环继续即可.

     */
    public static void main5(String[] args) {
        int [] arr = {1,2,3,4,5,6,7};
        reverse(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void reverse(int[] arr) {
        int left = 0;
        int right = arr.length-1;
       while (left<right){
            int tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            left++;
            right--;
        }
    }

    //给定一个整型数组, 将所有的偶数放在前半部分, 将所有的奇数放在数组后半部分
    /*思路 设定两个下标分别指向第一个元素和最后一个元素.
            用前一个下标从左往右找到第一个奇数, 用后一个下标从右往左找到第一个偶数, 然后交换两个位置的元素.
            依次循环即可.

     */
    public static void main6(String[] args) {
        int[] arr = {1,3,5,2,6,4};
        change(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void change(int[] arr) {
        int left = 0;
        int right = arr.length-1;
        while (left<right) {
            while (left < right && arr[left] % 2 == 0) {
                left++;
            }
            while (left < right && arr[right] % 2 != 0) {
                right--;
            }
            int tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
        }
    }

    //二维数组
    //定义
    public static void main(String[] args) {

        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}};
        int[][] array = new int[4][3];//默认 二维数组是0
        //定义时 列可以省略，行不能省略
        int[][] array1 = new int[4][];
        //也可以行列均不写
        int[][] array2 = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}};

        //二维数组打印
        for (int row = 0; row<arr.length;row++) {
            for (int col = 0; col< arr[row].length;col++) {
                System.out.print(arr[row][col]+" ");
            }
            System.out.println();
        }
        System.out.println("=======================");
        //for-each打印
        for (int[]arr1:arr) {
          for (int x : arr1) {
              System.out.print(x+" ");
          }
            System.out.println();
        }
        System.out.println("=======================");
        String ret = Arrays.deepToString(arr);
        System.out.println(ret);

    }
}
