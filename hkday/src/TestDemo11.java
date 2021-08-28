import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.util.AbstractSet;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.WeakHashMap;

public class TestDemo11 {

    public static void main1(String[] args) {
        java.util.HashMap map = new java.util.HashMap();
        map.put("name",null);
        map.put("name","Jack");
        System.out.println(map.size());

    }

    public static void main2(String[] args) {
        Thread t = new Thread(){
            public void run() {
                pong();
            }
        };
        t.run();
        System.out.print("ping");
    }

     static void pong() {
         System.out.print("pong");
    }

    public static int getValue(int i) {
        int result=0;
        switch (i) {
            case 1:
                result = result + i;
            case 2:
                result = result + i * 2;
            case 3:
                result = result + i * 3;
        }
        return result;
        }

    public static void main3(String[] args) {
        int i=2;
        int j = getValue(2);
        System.out.println(j);

        
    }

    public static void main(String[] args) {
        WeakHashMap
    }



}
