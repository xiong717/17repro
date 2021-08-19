import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

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

    public static void main(String[] args){
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
}
