import com.sun.deploy.net.proxy.ProxyUnavailableException;

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

    public int size() {
        int count = 0;
        Node cur = this.head;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    //通过遍历 找到倒数第一个节点
    public Node findLastNode() {
        Node cur = this.head;
        while (cur.next != null) {
            cur = cur.next;
        }
        return cur;
    }

    //通过遍历 找到倒数第二个节点
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

    //通过遍历 找到第n个节点
    public Node findn(int n) {
        if (this.head == null) {
            System.out.println("单链表为空");
            return null;
        }
        if (n <= 0) {
            System.out.println("n太小了");
            return null;
        }
        if (n > size()) {
            System.out.println("n太大了");
            return null;
        }
        Node cur = this.head;
        int count = 1;
        while (count != n) {
            count++;
            cur = cur.next;
        }
        return cur;
    }

    //通过遍历 查找是否包含关键字key 是否在链表中
    public boolean contains(int key) {
        Node cur = this.head;
        while (cur != null) {
            if (cur.val != key) {
                cur = cur.next;
            }else {
                return true;
            }
        }
        return false;
    }

    //头插法
    public void addFirst (int data) {
        //1.先定义一个节点
        Node node = new Node(data);
        //判断链表是否为空
        if (this.head == null) {
            this.head = node;
        } else {
            //插入
            node.next = this.head;
            this.head = node;
        }
    }

    //尾插法
    public void addLast (int data) {
        //先定义一个节点
        Node node = new Node(data);
        //判断链表是否为空
        if (this.head == null) {
            this.head = node;
        }else {
            //定义一个 cur 找到链表尾巴 插入
            Node cur = this.head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = node;
        }
    }

    //遍历找到index-1 位置
    public Node moveindex(int index) {
        int count = 0;
        Node cur = this.head;
        while (count != index -1) {
            cur = cur.next;
            count++;
        }
        return cur;
    }
    //第一个数据节点为 0 任意一个位置插入一个数据节点
    public void addindex(int index,int data) {
        //先定义一个节点
        Node node = new Node(data);
        //判断链表是否为空
        if (this.head == null) {
            this.head = node;
        }else {
            if (index < 0 || index >size()) {
                System.out.println("index位置不合法");
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
            //找到index-1位置 插入
            Node cur = moveindex(index);
            node.next = cur.next;
            cur.next = node;
        }
    }

    //找到要删除节点的前驱
    public Node searchPrev(int key) {
        Node cur = this.head;
        while (cur.next != null) {
            if (cur.next.val == key) {
                return cur;
            }
            cur = cur.next;
        }
        return null;

    }

     //删除第一次出现关键字为key的节点
        public void remove(int key) {
        if (this.head == null) {
            return;
        }
         if(this.head.val==key) {
             this.head = head.next;
             return;
         }
         Node prev = searchPrev(key);
         if (prev == null) {
             System.out.println("没有找到该节点的前驱");
         } else {
             prev.next = prev.next.next;
         }
        }



        //删除所有值为key的节点
         public void removeAllKey(int key) {
          if (this.head == null) {
              System.out.println("没有链表");
              return;
          }
           Node prev = this.head;
           Node cur = this.head.next;
           while (cur != null) {
               if (cur.val == key) {
                   prev.next = cur.next;
                   cur = cur.next;
               }else {
                   prev = cur;
                   cur = cur.next;
               }
           }
           if (this.head.val == key) {
               this.head = this.head.next;
           }
         }

         //清除单链表 只要一个节点 没有引用（为null） 就会被jvm回收
     public void clear() {
        this.head = null;
     }

}
