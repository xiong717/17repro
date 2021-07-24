public class TestDemo18 {
    public static void main1(String[] args) {
        
        
      Integer i1 = 59;
      int i2 = 59;
      Integer i3 = Integer.valueOf(59);
      Integer i4 = new Integer(59);
        System.out.println(i1 == i2);
        System.out.println(i3 == i4);
        System.out.println(i1 == i3);
        System.out.println(i2 == i4);
    }


    public String str ="6";



    public static void main(String[] args) {
        
        TestDemo18 t = new TestDemo18();
        t.change(t.str);
        System.out.println(t.str);

    }
    public void change(String str ) {
          str="10";
    }
}
