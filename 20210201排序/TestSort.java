import java.util.Arrays;
import java.util.Random;
import java.util.Stack;
import java.util.jar.JarOutputStream;

public class TestSort {

    /*
    *  直接插入排序(插入排序)
    * 思想：
    * 时间复杂度：最坏情况下 数据全无序的情况下 o(n^2)
    *           最好情况下 当数组有序的时候 可以达到O(n)
    * 所以 对于直接插入排序来说 越有序越快
    * 题目： 当前有一组待排序序列，但是这组待排序序列大部分是有序的
    *       请问 下面哪种排序更适合    答案直接插入排序
    * 另外： 直接插入排序一般也会用在一些排序的优化上 快速排序
    * 空间复杂度：o(1)
    * 稳定性 ： 稳定的
    * */
    public  static  void  insertsort(int[] array){
        for (int i = 1; i <array.length ; i++) {
            int tmp = array[i];
            int j = i-1;
            for (; j >=0 ; j--) {
                //如果是大于等于号 这个排序就不稳定了
                if (array[j] > tmp){
                    array[j+1]= array[j];
                }else {
                    //array[j+1] = tmp;
                    break;
                }
            }
            //有这样一种情况 j=-1 j+1 = 0 或者是 array[j] <= tmp
            array[j+1] = tmp;
        }
    }
    public static void main1(String[] args) {
        int[] array ={3,5,6,8,1,2};
        System.out.println(Arrays.toString(array));
        insertsort(array);
        System.out.println(Arrays.toString(array));
    }

    /*
     *  希尔排序
     * 时间复杂度：最坏情况下O(n^2) 最好情况下O(1.5)
     * 空间复杂度：O(1)
     * 稳定性： 不稳定
     * */

    public static void shellsort(int[] array){
        int[] drr = {5,3,1};//增量数组 是素数
        for (int i = 0; i < drr.length; i++) {
            shell(array,drr[i]);
        }
    }

    public static void shell(int[] array,int gap){
        for (int i = gap; i <array.length ; i++) {
            int tmp = array[i];
            int j = i-gap;
            for (; j >=0 ; j=j-gap) {
                if (array[j] > tmp) {
                    array[j + gap] = array[j];
                } else {
                    array[j + gap] = tmp;
                    break;
                }
            }
            array[j+gap] = tmp;
        }
    }

    public static void main2(String[] args) {
        int[] array={12,5,9,16,6,8,27,58,80,0,7,4,33,55,77};
        System.out.println(Arrays.toString(array));
        shellsort(array);
        System.out.println(Arrays.toString(array));
    }

    /*
    * 选择排序
    * 时间复杂度：O(n^2)
    * 空间复杂度：O(1)
    * 稳定性： 不稳定
    * */

    public static void selectsort(int[] array){
        for (int i = 0; i <array.length-1 ; i++) {
            for (int j = i+1; j < array.length; j++) {
                if (array[i] > array[j]){
                    int tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }
    }
    public static void main3(String[] args) {
        int[] array = {12,5,9,16,6};
        System.out.println(Arrays.toString(array));
        shellsort(array);
        System.out.println(Arrays.toString(array));
    }
    /*
    * 堆排序
    * 时间复杂度：O(n*l0g2 n)
    * 空间复杂度:O(1)
    * 稳定性：不稳定
    * 从小到大排序 建立大堆 top end--
    * 从大到小排序 建立小堆 top end--
    * */

    /*
     * 冒泡排序
     * 时间复杂度：O(n^2)
     * 空间复杂度:O(1)
     * 稳定性：稳定
     * */

    /*
     * 快速排序
     * 时间复杂度：最好情况下O(n*log2(n)) 最坏情况(有序)下 O(n^2)
     * 空间复杂度:O(log2(n)) 树的高度log2(n)
     * 稳定性：不稳定
     *
     * 分治思想：什么时间效率最高  就是把待排序的序列 均匀的划分时
     *
     * 优化快速排序：
     * (1)选取基准的优化
     * 以前用的方法 固定基准法
     * 1.随机选取基准法
     *   方法 随机找到一个下标 和low下标的数据交换，最后 以low下标交换后的值 作为基准
     * 2.三数取中
     *   方法： 三个数据中选取中间的那个数
     *(2) 当快速排序在一直执行的过程中，数据肯定会趋于有序，我们就可以使用插入排序对 快速排序进行优化
     * 插入排序越有序，越快。甚至会趋于O(n)
     * */
    //固定选取基准法  优化后的代码 找基准的时间复杂度 是要遍历数值 O(n)
    private static int pivot(int[] array,int start,int end) {
        int tmp = array[start];
        while (start<end){
            while (start<end &&array[end] >= tmp  ){
                end--;
            }
            //走到这 把数据赋值给start
            array[start] = array[end];
            while (start<end && array[start] <= tmp){
                start++;
            }
            //走到这说明 start下标的值 大于tmp 把他赋值给end
            array[end] = array[start];
        }
        array[start] = tmp;
        return start;
    }
    //递归实现
    public static void quick(int[] array,int low,int high){
        if(low >= high){
            return;
        }//low <high
        if (high-low+1 <=50){
            //直接插入排序  在区间50之内 使用直接插入排序方法
            insertsortBount(array,low,high);
            return;//此处一定要加return 表示在这个区间范围内 用直接插入px
        }
            //三数取中
            medianofthree(array,low,high);
            //此时 low下标的数据 就是三个数中间值
            int piv = pivot(array,low,high);
            quick(array,low,piv-1);
            quick(array,piv+1,high);

    }

    private static void insertsortBount(int[] array, int low, int high) {
        for (int i = low+1; i <=high ; i++) {
            int tmp = array[i];
            int j = i-1;
            for (; j>=low ; j--) {
                if (array[j] >tmp) {
                    array[j+1]=array[j];
                }else {
                    break;
                }
            }
            array[j+1] = tmp;
        }
    }

    public static void medianofthree(int[] array,int low,int high){
        int mid = (low+high)/2;
        //array[mid] <= array[low] <= array[end]
        if (array[low] < array[mid]){
            swap(array,low,mid);
        }//array[low] >= array[mid]
        if (array[low] > array[high]){
            swap(array,low,high);
        }//array[low] <= array[high]
        if (array[mid] > array[high]){
            swap(array,mid,high);
        }//array[mid] <= array[high]
    }

    private static void swap(int[] array,int i,int k) {
        int tmp = array[i];
        array[i]= array[k];
        array[k]= tmp;
    }


    public static void main4(String[] args) {
        int[] array = {12,5,9,16,6,8,27,58,80,0,7,4,33,55,77};
        System.out.println(Arrays.toString(array));
        quick(array,0,array.length-1);
        System.out.println(Arrays.toString(array));
    }

    public static void main5(String[] args) {
        int[] array = new int[1_0000];
        for (int i = 0; i <array.length ; i++) {
            array[i] = i;
        }
        long starttime = System.currentTimeMillis();
        quick(array,0,array.length-1);
        long endtime = System.currentTimeMillis();
        System.out.println(endtime-starttime);
        /*
        * 加上 三数取中的优化 执行时间 是3秒
        * 不加 是29秒
        * */
    }

    public static void main6(String[] args) {
        int[] array = new int[1_0000];
        Random random = new Random();
        for (int i = 0; i <array.length ; i++) {
            array[i] = random.nextInt(1_0000);
        }
        long starttime = System.currentTimeMillis();
        quick(array,0,array.length-1);
        long endtime = System.currentTimeMillis();
        System.out.println(endtime-starttime);

    }





    private static int pivot2(int[] array,int start,int end) {
         int tmp = array[start];
         while (start<end){
             while (start<end &&array[end] >= tmp  ){
                 end--;
             }
             if (start >= end){
                 array[start] = tmp;
                 break;
             }else {
                 //走到这 把数据赋值给start
                 array[start] = array[end];
             }
             while (start<end && array[start] <= tmp){
                 start++;
             }
             if (start>=end){
                array[start] = tmp;
                break;
             }else {
                 //走到这说明 start下标的值 大于tmp 把他赋值给end
                 array[end] = array[start];
             }
         }
         array[start] = tmp;
         return start;
     }

     /*
     * 非递归实现快速排序 ---用栈实现
     * 时间复杂度：O(n* log2(n))
     * 空间复杂度: 最好 O(log2(n)) 最坏情况下O(n)
     *
     * */
    public static void quicksort(int[] array){
        Stack<Integer> stack = new Stack();
        int low =0;
        int high = array.length-1;
        int piv = pivot(array,low,high);
        if (piv > low+1){
            //左边
            stack.push(low);
            stack.push(piv-1);
        }
        if (piv < high-1){
            //右边
            stack.push(piv+1);
            stack.push(high);
        }

        while (!stack.isEmpty()){
            high = stack.pop();
            low = stack.pop();
            piv = pivot(array,low,high);
            if (piv > low+1){
                //左边
                stack.push(low);
                stack.push(piv-1);
            }
            if (piv < high-1){
                //右边
                stack.push(piv+1);
                stack.push(high);
            }
        }
    }

    public static void main7(String[] args) {
        int[] array = new int[10_0000];//十万个数据也可执行
        Random random = new Random();
        for (int i = 0; i <array.length ; i++) {
            array[i] = random.nextInt(1_0000);
        }
        long starttime = System.currentTimeMillis();
        quicksort(array);
        long endtime = System.currentTimeMillis();
        System.out.println(endtime-starttime);
    }

    /* 归并排序
    * 时间复杂度：O(n*log(n))
    * 空间复杂度：O(n)
    * 稳定性： 稳定
    *
    * */

    //递归
    public static void mergesort(int[] array,int low,int high){
        if (low >=high) return;
        int mid = (low +high)/2;
        mergesort(array,low,mid);
        mergesort(array,mid+1,high);
        merge(array,low,mid,high);
    }

    private static void merge(int[] array, int start,int mid, int end) {
        int s1 = start;
        int e1 = mid;
        int s2 = mid+1;
        int e2 = end;
        int[] tmp = new int[end-start+1];
        int k=0;
        while (s1 <= e1 && s2<=e2){
            if (array[s1] <= array[s2]){
                //大于等于 就是稳定排序
                tmp[k++] = array[s1++];
            }else {
                tmp[k++] = array[s2++];
            }
        }
        //走到这 可能是s1 或者 s2内的 数字走完了
        while (s1 <= e1){
            tmp[k++] = array[s1++];
        }
        while (s2 <= e2){
            tmp[k++] = array[s2++];
        }
        for (int i = 0; i <tmp.length ; i++) {
            //需要把 tmp中的 搬移到原数组中
            array[i+start] = tmp[i];
        }
    }

    public static void main(String[] args) {
        int[] array = {10,6,7,1,3,9,4,2};
        System.out.println(Arrays.toString(array));
        mergesort(array,0,array.length-1);
        System.out.println(Arrays.toString(array));
    }

    //非递归
    
}
