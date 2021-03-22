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
    
    public static void main(String[] args) {
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
}
