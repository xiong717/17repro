class Node{
    public int val;
    public Node next;
    //构造方法
    public Node(int val) {
        this.val=val;
    }
    public Node() {

    }

}

public class MyLinkList {

    public Node head;//表示当前链表的头

    public void createLinked() {
        this.head= new Node(12);
        Node node2 = new Node(22);
        Node node3 = new Node(32);
        Node node4 = new Node(42);
        this.head.next = node2;
        node2.next = node3;
        node3.next = node4;

    }
    public void display() {
        Node cur = this.head;
        while(cur != null) {
            System.out.print(cur.val+" ");
            cur = cur.next;
        }
        System.out.println();
    }

    
    public Node findLastNode() {
        Node cur = this.head;
        while (cur.next != null) {
            cur = cur.next;
        }
        return cur;
    }

    public Node findLastTwoNode() {
        if (this.head == null) {
            System.out.println("没有节点");
            return null;
        }
        if (this.head.next == null) {
            System.out.println("只有一个节点");
            return null;
        }
        Node cur = this.head;
        while (cur.next.next != null) {
            cur = cur.next;
        }
        return cur;
    }



}
