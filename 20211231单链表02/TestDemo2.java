public class TestDemo2 {
    public static void main1(String[] args) {
        DoubleList doubleList = new DoubleList();
        doubleList.addFirst(1);
        doubleList.addFirst(2);
        doubleList.addFirst(3);
        doubleList.addFirst(4);
        doubleList.addFirst(6);
        doubleList.display();
    }

    public static void main2(String[] args) {
        DoubleList doubleList = new DoubleList();
        doubleList.addLast(1);
        doubleList.addLast(2);
        doubleList.addLast(3);
        doubleList.addLast(4);
        doubleList.addLast(5);
        doubleList.display();
    }

    public static void main(String[] args) {
        DoubleList doubleList = new DoubleList();
        doubleList.addLast(1);
        doubleList.addLast(2);
        doubleList.addLast(3);
        doubleList.addLast(4);
        doubleList.addLast(5);
        doubleList.display();
        doubleList.addIindex(0,99);
        doubleList.addIindex(6,88);
        doubleList.addIindex(3,66);
        doubleList.display();
        System.out.println(doubleList.contains(88));
        doubleList.remove(3);
        doubleList.display();
    }
}
