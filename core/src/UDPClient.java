import java.io.IOException;
import java.net.*;
import java.util.Scanner;

/*
udp客户端
 */
public class UDPClient {
    //服务器端IP
    //public static final String ip = "127.0.0.1";
    public static final String ip = "152.136.255.32";
    //服务器端端口号
    public static final int prot = 9002;
    //数据包大小
    public static final int bleng = 1024;
    public static void main(String[] args) throws IOException {
        //1.创建客户端 客户端是连接别人的 所以是不需要固定端口号的。一个动态IP就行 不输入端空号就是动态IP口更好
        DatagramSocket socket = new DatagramSocket();
        //让用户来输入发送信息
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("用户请输入信息：");
            //接收用户输入信息
            String msg = scanner.nextLine();
            //2.构建发送数据包
            DatagramPacket datagramPacket = new DatagramPacket(
                    msg.getBytes(),
                    msg.getBytes().length,
                    InetAddress.getByName(ip),//发送的目标地址
                    prot //发送的目标端口号
                    );
            //3.发送信息
            socket.send(datagramPacket);
            //接收服务器端信息
            DatagramPacket serPackrt = new DatagramPacket(new byte[bleng],bleng);
            //接收服务器端的请求 也需要DatagramPacket 所以创建
            socket.receive(serPackrt);
            //打印接收到的信息
            System.out.println("接收服务器端的信息：" + new String(serPackrt.getData()));
        }
    }
}
