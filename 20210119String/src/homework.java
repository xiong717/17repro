public class homework {

    public static class Example{
        String str = new String("good");
        char[ ] ch = { 'a' , 'b' , 'c' };
        public static void main8(String args[]){
            Example ex = new Example();
            ex.change(ex.str,ex.ch);
            System.out.print(ex.str + " and ");
            System.out.print(ex.ch);
        }
        public void change(String str,char ch[ ]){
            str = "test ok";
            ch[0] = 'g';
        }

    }
    public static class SystemUtil{
        public static boolean isAdmin(String userId){
            return userId.toLowerCase() == "admin";
            // toLowerCase() 方法用于将大写字符转换为小写 ==号比较的是 useID的内容是地址 所以不一样
        }
        public static void main9(String[] args){
            System.out.println(isAdmin("Admin"));
            String str = "Admin";
            String str1 = str.toLowerCase();
            System.out.println(str1);
        }
    }

    public static void main10(String[] args) {
        String s1="abc"+"def";//1
        String s2=new String(s1);//2
        if(s1.equals(s2))//3
            System.out.println(".equals succeeded");//4
        if(s1 == s2)//5
            System.out.println("==succeeded");//6
        System.out.println(s1.contains(s2));
        System.out.println(s1.substring(1, 4));
    }
}
