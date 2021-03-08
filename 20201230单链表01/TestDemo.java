public class TestDemo {

    public static void main1(String[] args) {
        Node node = new Node();
        System.out.println(node.val);//0
        System.out.println(node.next);//null

        Node node1 = new Node(67);
        System.out.println(node1.val);//67
        System.out.println(node1.next);//null
    }

    public static void main2(String[] args) {
        MyLinkList myLinkList = new MyLinkList();
        ////这个函数结束之后，我们拿到了当前链表的头节点
        myLinkList.createLinked();
        myLinkList.display();
        System.out.println("====================");
        Node ret = myLinkList.findLastNode();
        System.out.println(ret.val);
        System.out.println("====================");
        Node ret1 = myLinkList.findLastTwoNode();
        System.out.println(ret1.val);
        System.out.println("====================");
        Node ret2 = myLinkList.findn(1);
        System.out.println(ret2.val);
        System.out.println("=====================");
        System.out.println(myLinkList.contains(422));
    }

    public static void main3(String[] args) {
        MyLinkList myLinkList = new MyLinkList();
        myLinkList.createLinked();
        myLinkList.display();
        myLinkList.addFirst(99);
        myLinkList.addFirst(88);
        myLinkList.display();
        myLinkList.addLast(1);
        myLinkList.addLast(2);
        myLinkList.display();
    }

    public static void main4(String[] args) {
        MyLinkList myLinkList = new MyLinkList();
        myLinkList.addFirst(11);
        myLinkList.addFirst(22);
        myLinkList.addFirst(33);
        myLinkList.display();
        System.out.println("==================");
        myLinkList.addLast(1);
        myLinkList.addLast(2);
        myLinkList.addLast(3);
        myLinkList.display();
        System.out.println("====================");
        myLinkList.addindex(2,67);
        myLinkList.display();
        System.out.println("=====================");
        myLinkList.addindex(0,100);
        myLinkList.display();
        System.out.println("====================");
        myLinkList.addindex(8,999);
        myLinkList.display();
        System.out.println("====================");
        myLinkList.remove(999);
        myLinkList.display();
        myLinkList.remove(100);
        myLinkList.display();
        myLinkList.remove(11);
        myLinkList.display();
        myLinkList.remove(5);
    }

    public static void main(String[] args) {
        MyLinkList myLinkList = new MyLinkList();
        myLinkList.addFirst(18);
        myLinkList.addFirst(24);
        myLinkList.addLast(26);
        myLinkList.addLast(24);
        myLinkList.addindex(2,24);
        myLinkList.display();
        myLinkList.removeAllKey(24);
        myLinkList.display();
        myLinkList.clear();
        myLinkList.display();
    }
}
