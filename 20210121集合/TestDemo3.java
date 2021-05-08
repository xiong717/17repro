import java.util.*;

/*
* LIST
* */
class Student{
    public String name;
    public String classes;
    public double score;

    public Student(String name, String classes, double score) {
        this.name = name;
        this.classes = classes;
        this.score = score;
    }

    @Override
    public String toString() {
        return "student{" +
                "name='" + name + '\'' +
                ", classes='" + classes + '\'' +
                ", score=" + score +
                '}';
    }
}
public class TestDemo3 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(9);
        Collections.sort(list);
        System.out.println(list);
    }

    public static void main3(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        list.add(new Student("张三","大一",99.99));
        list.add(new Student("李四","大二",77.23));
      /*  for (int i=0;i<list.size();i++) {
            System.out.println(list.get(i));
        }
        for (student stu:list) {
            System.out.println(stu);
        }*/
        /*//也可利用迭代打印遍历
        Iterator<Student> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }*/
        System.out.println(list);
    }


    public static void main1(String[] args) {
        List<Integer> list = new ArrayList<>();
        /*
        ArrayList 底层是一个数组，每次放元素时候，放在了数组的最后。
        public boolean add(E e){}
        public void add(int index,E element){} 这个方法时放在index位置

        问题 ArrayList底层是数组 那么他是多大？
        1.new ArrayList<>() 调用的是不带有参数的构造方法 那么大小默认是0
        2.当调用了不带参数默认的构造方法之后，当你添加了第一个元素时候，会进行扩容，
        第一次扩容时候，大小为10
        3.当后续进行扩容时候，是进行了1.5倍的方式进行扩容。
         */
        list.add(1);
        //list.add(3,99);//运行会出错
        System.out.println(list);

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(10);
        arrayList.add(20);
        arrayList.add(30);

        list.addAll(arrayList);//尾插arrayList中的元素
        System.out.println(list);
        list.remove(1);
    }

    public static void main2(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println(list);//1 2 3 4 5
        List<Integer> list1 = new ArrayList<>();
        list1 =  list.subList(1,3);
        System.out.println(list1);//2 3

        list1.set(0,88);
        System.out.println(list1);//88 3

        System.out.println(list);//1 88 3 4 5

        //迭代器 Iterator接口
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        //慎用 iterator.remove
        iterator.remove();
        iterator.remove();//会报错了
        System.out.println(list);

    }


}
