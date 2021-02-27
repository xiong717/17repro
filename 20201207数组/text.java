import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

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
    //数组作为方法的参数
    public static void print(int [] array){
        for (int i = 0; i <array.length;i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }
    public static void func(int []array) {
       array[0] = 10;
        System.out.println("array[0] = "+array[0]);
    }

    public static void main(String[] args) {
        int []arr = {1,2,3,4,5,6};
        print(arr);
        func(arr);
        System.out.println("arr[0] = "+arr[0]);
    }


}
