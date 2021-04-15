package tcp;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/*
* 客户端
*/
public class TCPClient {
    //服务器端ip
    private static final String ip ="152.136.255.32";
    //服务器端口号
    private static final int prot = 9004;

    public static void main(String[] args) throws IOException {
        //1.创建 tcp 客户端
        Socket socket = new Socket(ip,prot);

        try( BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
             Scanner scanner = new Scanner(System.in))
        {
            //不停地写入信息
            while (true) {
                System.out.print("英文： ");
                String msg = scanner.nextLine();//发送消息给服务器端的内容
                //2.发送消息给服务器端
                writer.write(msg+"\n");//不要忘记写\n
                writer.flush();
                //3.接收服务器响应的内容
                String sermsg = reader.readLine();
                System.out.println("中文： "+ sermsg);
            }
        }
    }
}
