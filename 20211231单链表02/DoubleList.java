//先定义一个节点
class ListNode {
    public int val;
    public ListNode next;
    public ListNode prev;//private属性 用下面方法访问
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

    //求链表长度
    public int size() {
        ListNode cur = this.head;
        int count = 0;
        while(cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
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

    //任意位置插入一个节点 （第一个数据节点为0号下标）
    public void addIindex(int index,int data) {
        //先判断index的合法性
        if (index < 0 || index > size()) {
            return;
        }
        if (index == 0) {
            addFirst(data);
            return;
        }
        if (index == size()) {
            addLast(data);
            return;
        }
        ListNode cur = this.head;
        while (index != 0) {
            cur = cur.next;
            index--;
        }
        ListNode node = new ListNode(data);
        node.next = cur;
        node.prev = cur.prev;
        node.prev.next = node;
        cur.prev = node;
    }

    //查找是否包含关键字key 在链表中
    public boolean contains(int key) {
        ListNode cur = this.head;
        while (cur != null) {
            if (cur.val == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public ListNode findnode(int key) {
        ListNode cur = this.head;
        while (cur != null) {
            if (cur.val == key) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }
    //删除第一次出现关键字为key的节点
    public void remove(int key) {
        ListNode cur = this.findnode(key);
        if(cur ==null) {
         return;
        }
        if (cur == this.head) {
            this.head = head.next;
            this.head.prev = null;
            return;
        }
        if (cur == this.last) {
            cur.prev.next = null;
            this.last = this.last.prev;
            return;
        }
        cur.prev.next=cur.next;
        cur.next.prev = cur.prev;
    }
}
