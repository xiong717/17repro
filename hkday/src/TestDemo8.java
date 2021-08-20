import java.util.*;

public class TestDemo8 {
    public static void main1(String[] args) {
        B b = new B();
        int a =b.getValue();
        System.out.println(a);
    }
    static class A{
        protected int value;

        public A(int v) {
            setValue(v);
        }
        public void setValue(int value) {
            this.value = value;
        }
        public int getValue() {
            try{
                value++;
                return value;
            }catch (Exception e) {
                System.out.println(e.toString());
            }finally {
                this.setValue(value);
                System.out.println(value);
            }
            return value;
        }
    }
    static class B extends A{

        public B() {
            super(5);
            setValue(getValue()-3);
        }
        @Override
        public void setValue(int value) {
            super.setValue(2*value);
        }
    }

    //求n个数总最小的k个
    public static void main2(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String tmp = in.nextLine();
            String[] str = tmp.split(" ");
            int[] arr = new int[str.length - 1];
            int k = 0;
            for (int i = 0; i < str.length; i++) {
                if (i < str.length - 1) {
                    arr[i] = Integer.parseInt(str[i]);
                } else {
                    k = Integer.parseInt(str[i]);
                }
            }
            if (k <= 0 || k > str.length - 1) {
                return;
            }
            Arrays.sort(arr);
            for (int j = 0; j < k; j++) {
                if (j == k - 1) {
                    System.out.print(arr[j]);
                } else {
                    System.out.print(arr[j] + " ");
                }
            }
        }
    }

    public static void main3(String[] args){
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        String[] tmp = str.split(" ");
        int[] arr = new int[tmp.length-1];
        int j = 0;
        for (; j < tmp.length-1; j++) {
            arr[j] = Integer.parseInt(tmp[j]);
        }
        int k = Integer.parseInt(tmp[tmp.length-1]);
        PriorityQueue<Integer> qu = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for (int i = 0; i < k; i++) {
            qu.offer(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            if (qu.peek() >arr[i]){
                qu.poll();
                qu.offer(arr[i]);
            }
        }
        int[] ret = new int[k];
        for (int i = 0; i<k;i++) {
            ret[i] = qu.poll();
        }
        for (int i = k-1; i >=0 ; i--) {
            System.out.print(ret[i]+" ");
        }

    }


    //删数
        public static void main4(String[] args) {
            Scanner sc = new Scanner(System.in);
            while (sc.hasNext()) {
                int n = sc.nextInt();
                if (n > 1000) {
                    n = 999;
                }
                List<Integer> list = new ArrayList<Integer>();
                for (int i = 0; i < n; i++) {
                    list.add(i); }
                int i = 0;
                while (list.size() > 1) {
                    i = (i + 2) % list.size();
                    list.remove(i);
                }
                System.out.println(list.get(0));
            }
        }

        //删数
    public static void main5(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        Queue<Integer> qu1 = new LinkedList<>();
        Queue<Integer> qu2 = new LinkedList<>();
        int count = 0;
        for (int i = 0; i <num ; i++) {
            qu1.offer(i);
        }
        while (qu1.size()+qu2.size() != 1){
            while (!qu1.isEmpty()){
                if (count==2){
                    //删数
                    qu1.poll();
                    count=0;
                }else {
                    qu2.offer(qu1.poll());
                    count++;
                }
            }
            while (!qu2.isEmpty()){
                if (count ==2){
                    //删数
                    qu2.poll();
                    count=0;
                }else {
                    qu1.offer(qu2.poll());
                    count++;
                }
            }
        }
        if (qu1.size() == 1){
            System.out.println(qu1.poll());
        }
        if (qu2.size() == 1){
            System.out.println(qu2.poll());
        }
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s1 = scan.nextLine();
        String[] s2 = s1.split(" ");
        int[] arr = new int[s2.length-1];
        for (int i = 0; i <s2.length-1 ; i++) {
            arr[i] = Integer.parseInt(s2[i]);
        }
        int k = Integer.parseInt(s2[s2.length-1]);
        int start = 0;
        int end = arr.length-1;
        int index = pivot(start,end,arr);
        //快排

        while (index != k){
            if (index > k){
                end = index-1;
                index = pivot(start,end,arr);
            }else {
                start = index+1;
                index = pivot(start,end,arr);
            }
        }
        Arrays.sort(arr,0,k);
        for (int i = 0; i < k; i++) {
            System.out.print(arr[i]+" ");
        }
    }

    public static  int pivot(int start,int end, int[] arr){
        int tmp = arr[start];
        while (start<end){
            while (start<end && arr[end]>=tmp){
                end--;
            }
            arr[start] =arr[end];
            while (start<end && arr[start] <=tmp){
                start++;
            }
            arr[end] = arr[start];
        }
        arr[start] = tmp;
        return start;
    }
}
