public class TestDemo {
    public static void main1(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addList(19);
        myLinkedList.addList(29);
        myLinkedList.addList(39);
        myLinkedList.addList(49);
        myLinkedList.addList(59);
        System.out.println(myLinkedList.head.val);
        myLinkedList.display(myLinkedList.head);
        System.out.println("==================");
        System.out.println(myLinkedList.head.val);
        Node newhead = myLinkedList.reviseList(myLinkedList.head);
        myLinkedList.display(newhead);
    }

    public static void main2(String[] args) {
        Node node1 = new Node(12);
        Node node2 = new Node(22);
        Node node3 = new Node(27);
        node1.next = node2;
        node2.next = node3;

        Node nodel1 = new Node(14);
        Node nodel2 = new Node(20);
        Node nodel3 = new Node(25);
        Node nodel4 = new Node(30);
        Node nodel5 = new Node(39);
        nodel1.next = nodel2;
        nodel2.next = nodel3;
        nodel3.next = nodel4;
        nodel4.next = nodel5;

        MyLinkedList myLinkedList = new MyLinkedList();

        Node w = myLinkedList.addtwoLists(node1,nodel1);
        myLinkedList.display(w);
    }
    public Node getIntersectionNode(Node headA, Node headB) {
        if (headA == null || headB == null) {
            return null;
        }
        Node pl = headA;//pl 永远指向最长的链表
        Node ps = headB;//ps 永远指向最短的链表
        int lenA = 0;
        int lenB = 0;
        while (pl != null) {
            headA = headA.next;
            lenA++;
        }
        while (headB != null) {
            headB = headB.next;
            lenB++;
        }
        //计算完链表长度 一定要把头结点指回去
        pl = headA;
        ps = headB;
        int len = lenA - lenB;
        if (len < 0) {
            pl = headB;
            ps = headA;
            len = lenB - lenA;
        }
        while (len != 0) {
            pl = pl.next;
            len--;
        }
        while (pl != ps) {
            pl = pl.next;
            ps = ps.next;
        }
        return pl;
    }
}
