public class TestDemo {

    public static void main1(String[] args) {
        Node node = new Node();
        System.out.println(node.val);//0
        System.out.println(node.next);//null

        Node node1 = new Node(67);
        System.out.println(node1.val);//67
        System.out.println(node1.next);//null
    }

    public static void main(String[] args) {
        MyLinkList myLinkList = new MyLinkList();
        ////这个函数结束之后，我们拿到了当前链表的头节点
        myLinkList.createLinked();
        myLinkList.display();
        Node ret = myLinkList.findLastNode();
        System.out.println(ret.val);
        Node ret1 = myLinkList.findLastTwoNode();
        System.out.println(ret1.val);
    }
}
