public class text2 {
    //数组转字符串
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        System.out.println(mytoString(arr));
    }
    public static String mytoString(int[] arr) {
        if (arr== null) {
            return "[]";
        }
        String ret = "[";
        int i =0;
        for (; i< arr.length;i++) {
            ret += arr[i];
            if (i != arr.length-1) {
                ret = ret+",";
            }
        }
        ret += "]";
        return ret;
    }

}
