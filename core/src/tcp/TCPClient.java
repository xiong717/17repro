package tcp;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class TCPClient {
    private static final String ip ="127.0.0.1";
    private static final int prot = 9003;

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket(ip,prot);

        try( BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
             Scanner scanner = new Scanner(System.in))
        {
            while (true) {
                System.out.println("->");
                String msg = scanner.nextLine();
                //2.发送消息给服务器端
                writer.write(msg+"\n");
                writer.flush();
                //3.接收服务器响应的内容
                String sermsg = reader.readLine();
                System.out.println("服务器反馈"+sermsg);
            }
        }
    }
}
