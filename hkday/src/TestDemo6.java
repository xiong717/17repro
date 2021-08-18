import java.io.UnsupportedEncodingException;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReadWriteLock;

public class TestDemo6 {
    public static void main1(String[] args) throws UnsupportedEncodingException {
        byte[] src = new byte[0],dst;
        dst = new String(src,"GBK").getBytes("UTF-8");
    }

    public static void main(String[] args) {
                int num = 10;
                int ret = test(num);
        System.out.println(ret);
    }

    public static int test(int b){
        try
        {
            int a = b/0;
            return b;
        }
        catch(RuntimeException e)
        {
            return 0;
        }
        finally
        {
           b+=10;
        }
    }

}
