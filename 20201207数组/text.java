import java.util.Arrays;

public class text {
    public static void main1(String[] args) {
        //创建数组
        int[] arr = new int[]{1,2,3}; //动态初始化
        int[] arr1= {1,2,3}; //静态初始化
        //数组的使用
        int[] arr2 = {1,2,3,4,5,6,7};
        System.out.println("length:"+ arr2.length);//数组长度
        //访问数组中的元素
        System.out.println(arr2[1]);//下标访问操作的范围[0,length-1]
        System.out.println(arr2[0]);
        arr2[5]=200;
        System.out.println(arr2[5]);
        //遍历数组
        for (int i = 0; i < arr2.length;i++) {
            System.out.print(arr2[i]+" ");
        }
        System.out.println();
        //使用for-each遍历数组 只能拿到值
        for (int x : arr2) {
            System.out.print(x+"  ");
        }
        System.out.println();
        //Arrays是一个工具类，专门操作数组的工具类 将数组转化为字符串输出
        String str = Arrays.toString(arr2);
        System.out.print(str+"   ");
    }
    //数组作为方法的参数 引用本质上只是存了一个地址.
    public static void print(int [] array){
        for (int i = 0; i <array.length;i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }
    public static void func(int []array) {
       array[0] = 20;//函数内部修改数组内容，外部也发生变化
        System.out.println("array[0] = "+array[0]);
    }

    public static void main2(String[] args) {
        int []arr = {1,2,3,4,5,6};
        print(arr);
        func(arr);//arr是引用 传参
        System.out.println("arr[0] = "+arr[0]);
        //null空引用 意思是 无效的引用
        /*int[] arr1 = null;
        System.out.println(arr1[0]);
         */
    }
    /*局部变量和引用保存在栈上, new 出的对象保存在堆上.
      堆的空间非常大, 栈的空间比较小.
      堆是整个 JVM 共享一个, 而栈每个线程具有一份(一个 Java 程序中可能存在多个栈).
     */
    public static void main3(String[] args) {
        //数组作为方法的返回值
        //写一个方法，将数组的每个元素*2
        int[] array = {1, 2, 3, 4};
        print(array);
        int[] ret = trandform(array);
        System.out.println(Arrays.toString(ret));
        int[] re = trandform2(array) ;
        System.out.println(re);//打印出来的是re数组的首地址
        System.out.println(Arrays.toString(array));
    }
    public static int[] trandform(int[] arr) {
        for (int i = 0; i<arr.length;i++) {
            arr[i] = arr[i]*2;
            //System.out.print(arr[i]+" ");
        }
        return arr;
    }
    public static int[] trandform2(int[] arr) {
        for (int i=0;i<arr.length;i++) {
            arr[i] = arr[i]*3;
        }
        return arr;
    }
    //数组拷贝
    public static void main4(String[] args) {
     int[] arr = {1,2,3,4,5,6,7,8,9};
     int[] newArr = Arrays.copyOf(arr,arr.length);
        System.out.print("newArr: "+Arrays.toString(arr));
        System.out.println();
        arr[0]=100;
        System.out.println("arr: "+Arrays.toString(arr));
        System.out.println("newArr; "+Arrays.toString(arr));
        //拷贝某个范围
        int[] newArr1 = Arrays.copyOfRange(arr,3,7);
        System.out.println("newArr1 "+Arrays.toString(newArr1));
        int [] arr1 = copyof(arr);
        System.out.println(Arrays.toString(arr1));
    }
    //自己实现拷贝
     public static int[] copyof(int[] arr) {
        int [] ret = new int[arr.length];
         for (int i =0;i<arr.length;i++) {
             ret[i] = arr[i];
         }
         return ret;
     }

     //找数组中最大的元素
    public static void main5(String[] args) {
        int[] arr = {4,5,7,8,2};
        System.out.println(max(arr));
    }
    public static int max(int[] arr) {
        int max = arr[0];
        for (int i = 1; i<arr.length;i++) {
            if (max<arr[i]) {
                max=arr[i];
            }
        }
        return max;
    }

    //找数组中元素的平均值
    public static double avg(int[] arr) {
        int sum =0;
        for (int i = 0;i < arr.length;i++) {
            sum += arr[i];
        }
        return (double)sum/(double)arr.length;
    }

    public static void main6(String[] args) {
        int [] arr = {3,4,5,6,7};
        System.out.println(avg(arr));
    }
    //创建一个 int 类型的数组, 元素个数为 100, 并把每个元素依次设置为 1 - 100

    public static void main(String[] args) {
        int[] arr = new int[100] ;
        System.out.print(Arrays.toString(func1(arr)));
    }
    public static int[] func1(int[] arr) {
        for (int i = 0;i<arr.length;i++) {
            arr[i]=i+1;
        }
        return arr;
    }
}
