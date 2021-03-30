//先定义一个节点
class ListNode {
    private int val;
    private ListNode next;
    private ListNode prev;//private属性 用下面方法访问
    //alt+insert 选择 Constructor 按住ctrl 可选择几个变量
    public ListNode(int val) {
            this.val = val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public void setPrev(ListNode prev) {
        this.prev = prev;
    }

    public int getVal() {
        return val;
    }

    public ListNode getNext() {
        return next;
    }

    public ListNode getPrev() {
        return prev;
    }
}


public class DoubleList {
    public ListNode head;//头
    public ListNode last;//尾

    //打印
    public void display() {
        ListNode cur = this.head;
        while (cur != null) {
            System.out.print(cur.getVal()+" ");
            cur = cur.getNext();
        }
        System.out.println();
    }
    //头插法
    public void addFirst (int data) {
        //先有一个节点
        ListNode Node = new ListNode(data);
        if (this.head == null) {
            //第一次插入
            this.head = Node;
            this.last = Node;
        }else {
            //表明你不是第一次插入
            Node.setNext(this.head);//Node.next = this.head;
            this.head.setPrev(Node);//this.head.prev = Node;
            this.head = Node;
        }
    }

    //尾插法
    public void addLast( int data) {
        ListNode node = new ListNode(data);
        if (this.head == null) {
            this.head = node;
            this.last = node;
        } else {
            this.last.setNext(node);//last.next= node;
            node.setPrev(this.last);//node.prev = last;
            this.last = node;
        }
    }
}
