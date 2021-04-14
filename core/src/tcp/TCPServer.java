package tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.Buffer;

public class TCPServer {
    private static final int prot = 9003;
    public static void main(String[] args) throws IOException {
        //1.创建TCP服务器端
        ServerSocket serverSocket = new ServerSocket(prot);
        System.out.println("服务器启动成功！");

        //登录客户端的连接
        Socket client = serverSocket.accept();
        System.out.println(String.format("有客户端连接了，客户端ip:%s,端口：%d",
                client.getInetAddress().getHostAddress(),client.getPort()));

        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        try{
            while (true){
                //拿到读取对象
                bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
                //接收服务器端的信息
                String msg = bufferedReader.readLine();
                //拿到写入对象
                bufferedWriter = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
                String sermsg = "我收到了";
                bufferedWriter.write( sermsg+"\n");
                //刷新缓冲区
                bufferedWriter.flush();
            }
        }finally {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }
        }
    }
}
