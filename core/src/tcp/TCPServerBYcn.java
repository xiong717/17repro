package tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Scanner;
/*
英译汉服务器端
 */
public class TCPServerBYcn {
    //定义一个端口号
    private static final int prot = 9004;

    //定义翻译字典
    static HashMap<String,String> dirMap = new HashMap<>();
    static {
        dirMap.put("hello","你好");
        dirMap.put("bye","再见");
        dirMap.put("cat","猫");
    }

    public static void main(String[] args) throws IOException {
        //1.创建tcp 服务器
        ServerSocket serverSocket = new ServerSocket(prot);
        System.out.println("英译汉服务器已启动");
        //2.等待客户端连接
        Socket client = serverSocket.accept();

        //执行到此行说明已经有客户端连接
        System.out.println(String.format("已经有客户端连接了，客户端ip:%s,端口号：%d",client.getInetAddress().getHostAddress(),client.getPort()));

        try(BufferedWriter Writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
            BufferedReader Reader = new BufferedReader(new InputStreamReader(client.getInputStream()))
        ) {
            while (true) {
                //3. 得到客户端的英文单词
                String en = Reader.readLine();
                if (en != null && !en.equals("")) {
                    //4.英译汉的处理方法
                    String cn = process2(en);
                    //5.将结果返回给客户端
                    Writer.write(cn+"\n");
                    Writer.flush();
                }
            }
        }
    }

    /*
    * 英译汉 方式一
    * */
    private static String process(String en) {
        String cn = "未知";
        switch (en) {
            case "hello":
                cn = "你好";
                break;
            case "bye":
                cn = "再见";
                break;
            case "cat":
                cn = "猫";
                break;
            case "dog":
                cn = "狗";
                break;
            case "pig":
                cn = "猪";
                break;
            case "fox":
                cn = "狐狸";
                break;
        }
        return cn;
    }

    /*
    * 英译汉方式2
    * */
    private static String process2(String en) {
        String cn = "未知";
        cn = dirMap.get(en);
        return cn;

    }

}
