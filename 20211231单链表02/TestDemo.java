public class TestDemo {
    public static void main(String[] args) {
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
}
