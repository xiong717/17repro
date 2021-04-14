import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/*
* UDP服务器
*/
public class UDPServer {
    //端口号 千位以上
    private static final int port = 9002;
    //接收数据容器大小
    private static final int bleng = 1024;
    public static void main(String[] args) throws IOException {

        //1.创建一个UDP服务器 有目标IP和目标端口号
        DatagramSocket socket = new DatagramSocket(port);
        while (true) {
        //先声明一个数据包
            DatagramPacket clientPacket = new DatagramPacket(new byte[bleng],bleng);
        //2.等待客户端连接
            socket.receive(clientPacket);
        //执行此代码表示已经有客户端连接
        //3.拿到客户端的请求信息
            String msg = new String(clientPacket.getData());
            System.out.println("接收到客户端信息："+msg);
         //到这其实已经完了 后面可以不写
         //给客户端反馈一个信息
            //String serMsg = "我收到了";
            String serMsg = msg.replace("吗","。").replace("你","我");
            //”智能“机器人聊天
         //构建客户端发送数据包
            DatagramPacket serPacket = new DatagramPacket(serMsg.getBytes(),
                 serMsg.getBytes().length, //注意是字节数组的长度
                  clientPacket.getAddress(),//发送给客户端的地址
                 clientPacket.getPort());
         //给客户端发送信息
            socket.send(serPacket);
        }
    }
}
