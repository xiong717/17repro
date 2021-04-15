package tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.Buffer;
/*
* TCP服务器端
*/
public class TCPServer {
    //先定义一个端口号
    private static final int prot = 9003;
    public static void main(String[] args) throws IOException {
        //1.创建TCP服务器端
        ServerSocket serverSocket = new ServerSocket(prot);
        System.out.println("服务器启动成功！");

        //2.登录客户端的连接
        Socket client = serverSocket.accept();
        System.out.println(String.format("有客户端连接了，客户端ip:%s,端口：%d",
                client.getInetAddress().getHostAddress(),client.getPort()));

       /* BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        try{
            while (true){
                //拿到读取对象
                bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
                //接收服务器端的信息 readline是按行读取
                String msg = bufferedReader.readLine();
                //拿到写入对象 写入结果给客户端
                bufferedWriter = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
                String sermsg = "我收到了";  //服务器端给客户端的信息
                bufferedWriter.write( sermsg+"\n");//一定要加入\n 因为客户端需要按行读取信息
                //刷新缓冲区  如果不写 信息就会一直在缓冲区放着
                bufferedWriter.flush();
            }
        }finally {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }
            //害怕try里面语句出现问题 导致缓冲区的数据流未关闭 所以用trycatch包裹
        }*/

        try(//拿到读取对象
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()))
         ) {

            while (true) {
                //3.接收客户端信息
                String msg = bufferedReader.readLine();
                if (msg != null && !msg.equals("")) {
                    System.out.println("收到客户端信息"+msg);
                    //4.返回给客户端响应信息
                    String sermsg = "我收到了";
                    bufferedWriter.write(sermsg+"\n");
                    //5.缓冲区刷新
                    bufferedWriter.flush();
                }
            }
        }
    }
}
