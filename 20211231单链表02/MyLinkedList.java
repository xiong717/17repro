
class Node{
    public int val;
    public Node next;

    //构造方法
    public Node(int val ){
        this.val = val;
    }

    public Node () {

    }
}

public class MyLinkedList {
 public Node head;//当前链表的头
    public void display(Node head) {
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    //头插法
    public  void addfirst(int data) {
        Node node = new Node();
        if (this.head == null) {
            this.head = node;
        }else {
            node.next = this.head;
            this.head = node;
        }
    }

    //尾插法
    public  void addList(int data) {
        Node node = new Node(data);
        if(this.head == null) {
            this.head = node;
        }else{
            Node cur = this.head;
            while(cur.next != null) {
                cur = cur.next;
            }
            cur.next = node;
        }
    }

    public Node reviseList(Node head) {
        Node prev = null;
        Node cur = head;
        Node newhead = null;
        while (cur != null) {
            Node curNext = cur.next;
            if (curNext == null) {
                newhead = cur;
            }
                cur.next = prev;
                prev = cur;
                cur = curNext;
            }
        return newhead;
    }

    

}
