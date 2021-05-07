public class TestDemo10 {
  //2
   /* byte b1=1,b2=2,b3,b6;
    final byte b4=4,b5=6;
    b6=b4+b5;
    b3=(b1+b2);*/

  
    //3
    public static void main3(String[] args) {
        StringBuffer a = new StringBuffer("A");
        StringBuffer b = new StringBuffer("B");
        operator(a,b);
        System.out.println(a+" "+b);
    }

    private static void operator(StringBuffer x,StringBuffer y) {
        x.append(y);
        y=x;
    }

    //4
    public static void main4(String[] args) {
        Object o = new Object(){
            public boolean equals(Object obj){
                return true;
            }
        };
        System.out.println(o.equals("Fred"));
    }

    public static void main(String[] args) {
    int Array_a[] = new int[10];
        System.out.println(Array_a[10]);
    }

}
