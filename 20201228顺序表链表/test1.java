public class test1 {
    public static void main(String[] args) {
        myArraylist p1 = new myArraylist();
        p1.add(0,6);
        p1.add(1,66);
        p1.add(2,666);
        p1.add(3,888);
        p1.add2(999);
        p1.display();
        System.out.println(p1.size());
        System.out.println(p1.contains(666));
        System.out.println(p1.research(666));

        System.out.println(p1.getpos(3));

        p1.setpos(2,444);
        p1.display();
        p1.remove(444);
        p1.display();
        p1.clear();
        p1.display();
    }
}
