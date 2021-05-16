package javajichu;

import java.util.Scanner;

public class test {
        public static boolean isAdmin(String userId) {
            return userId.toLowerCase() == "admin";
        }

    public static void main1(String[] args) {
        System.out.println(isAdmin("Admin"));

        boolean b=true?false:true==true?false:true;
        System.out.println(b);
    }

    public static void main2(String[] args) {
        Object o = new Object(){
          public boolean equals(Object obj) {
              return true;
          }
        };

        boolean t = o.equals(1);
        System.out.println(t);
    }

    public static void main3(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                char tmp = str.charAt(i);
                if (!sb.toString().contains(tmp + "")) {
                    sb.append(tmp);
                }
            }
            System.out.println(sb.toString());
        }
    }
    public ListNode Merge(ListNode list1,ListNode list2) {
            if (list1 == null) {
                return list2;
            }
            if (list2 == null) {
                return  list1;
            }
            ListNode head = new ListNode(-1);
            ListNode p1 = list1;
            ListNode p2 = list2;
            ListNode p3 = head;
            while (p1 != null && p2 != null) {
                if (p1.val < p2.val){
                    p3.next = p1;
                    p1 = p1.next;
                    p3 = p3.next;
                }else {
                    p3.next = p2;
                    p1 = p1.next;
                    p3= p3.next;
                }
            }
            while (p1 != null) {
                p3.next = p1;
                p1=p1.next;
                p3=p3.next;
            }
            while (p2 != null) {
                p3.next = p2;
                p2=p2.next;
                p3=p3.next;
            }
        return head.next;
    }
}
 class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}


