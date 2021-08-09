import java.util.*;

public class TestDemo4 {

    public static void main1(String[] args) {
        //HashMap 时间复杂度O(1)
        HashMap<String,Integer> map = new HashMap<>();

        Map<String,Integer> map2 = new HashMap<>();
        map2.put("gaobo",20);//注意 put是根据一个函数存放的
        map2.put("白宇",18);
        map2.put("gaobo",33);
        map2.put(null,null);
        map2.put(null,null);

        int val = map2.getOrDefault("gaobo3",8888);
        System.out.println(map2.get("gaobo"));
        System.out.println(val);
        System.out.println(map2);
        System.out.println("==============");

        //集合 不能存放相同元素 返回key的不重复集合
        Set<String> set = map2.keySet();
        System.out.println(set);
        //返回values的可重复集合
        Collection<Integer> values = map2.values();
        System.out.println(values);
        System.out.println("============= ");
        Set<Map.Entry<String,Integer>> set1 = map2.entrySet();
        for (Map.Entry<String,Integer> entry:set1) {
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
    }

    public static void main2(String[] args) {
        //set 最重要的功能是去重 HashSet插入查找删除的时间复杂度是O(1)
        Set<Integer> set = new HashSet<>();//无序的集合
        set.add(10);
        set.add(2);
        set.add(22);
        set.add(222);
        set.add(null);
        set.add(2);//set 不能存储相同的元素


        System.out.println(set);
        System.out.println(set.size());
    }

    public static void main(String[] args) {

        int ret = findfirstrepetnumber();
        System.out.println(ret);

        Set<Integer> set = deputil();
        System.out.println(set);
    }
    public static int findfirstrepetnumber(){
        ArrayList<Integer> arrayList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i <10_0000 ; i++) {
            arrayList.add(random.nextInt(1_0000));
        }
        HashSet<Integer> set = new HashSet<>();
        int ret = 0;
        for (int i = 0; i <10_000 ; i++) {
            ret = arrayList.get(i);
            if (set.contains(ret)){
                break;
            }else {
                set.add(ret);
            }
        }
        return ret;
    }

    public static Set<Integer> deputil(){
        Random random = new Random();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(random.nextInt(8));
        }
        System.out.println(list);
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            set.add(list.get(i));
        }
        return set;
    }
}
