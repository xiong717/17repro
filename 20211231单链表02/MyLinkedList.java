
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
    //翻转链表
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
    public Node addtwoLists(Node l1,Node l2) {
        Node newhead = new Node(1);
        Node tmp = newhead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                tmp.next = l1;
                l1 = l1.next;
                tmp = tmp.next;
            }else {
                tmp.next = l2;
                l2 = l2.next;
                tmp = tmp.next;
            }
            if (l1 == null) {
                tmp.next = l2;
            }
            if (l2 == null) {
                tmp.next = l1;
            }
        }
        return newhead.next;
    }

    public boolean findhuiwen() {
        if (this.head == null) {
            return false;
        }
        //找到链表的之间位置
        Node fast = this.head;
        Node slow = this.head;
        Node cur = this.head;
        while (fast != null && fast.next != null) {
            //自己写的错误 未 考虑到 fast.next != null
            fast = fast.next.next;
            slow = slow.next;
        }
        cur = slow.next;
        while (cur != null ) {
            Node curNext = cur.next;
            cur.next = slow;
            slow = cur;
            cur = curNext;
        }
        while (head != slow) {
            if (head.val == slow.val && head.next != slow) {
                //偶数情况 是 head.next = slow
                head = head.next;
                slow = slow.next;
            } else {
                return false;
            }
        }
        return true;
    }
    

}
