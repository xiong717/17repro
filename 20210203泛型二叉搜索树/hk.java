import java.util.*;

public class hk {
    public static int singleNumber(int[] nums) {

        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i <nums.length ; i++) {
            Integer key = nums[i];
            if (map.get(key) == null){
                map.put(key,1);
            }else {
                Integer num = map.get(key);
                map.put(key,num+1);
            }
        }
        int ret = 0;
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) == 1){
                 ret = nums[i];
            }
        }
        return ret;
    }

    public static void main1(String[] args) {
        int[] nums = {2,2,1,3,3,1,5};
        /*Scanner scan = new Scanner(System.in);
        for (int i = 0; i <nums.length; i++) {
            nums[i] = scan.nextInt();
        }*/
        int ret = singleNumber(nums);
        System.out.println(ret);
    }

    public static List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> map = new HashMap<>();
        String[] ret = new String[k];
        for(int i =0;i<words.length;i++){
            String str= words[i];
            if(map.get(str) == null){
                map.put(str,1);
            }else{
                Integer num = map.get(str);
                map.put(str,num+1);
            }
        }
        //建立一个小根堆
        PriorityQueue<String> queue = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
               if (map.get(o1) == map.get(o2)){
                   return o2.compareTo(o1);
               }else {
                   return map.get(o1)-map.get(o2);
               }
            }
        });

        //依次向堆加入元素
        for (String s:map.keySet()
             ) {
            queue.offer(s);
            if (queue.size()>k){
                queue.poll();
            }
        }

        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i <k ; i++) {
            list.add(queue.poll());
        }
        Collections.reverse(list);
        return list;
    }

    public static void main(String[] args) {
      String[] words={"i","love","leetcode","i","love","coding"};
      int k = 2;
      List<String> ret = topKFrequent(words,k);
        System.out.println(ret);
    }

}
