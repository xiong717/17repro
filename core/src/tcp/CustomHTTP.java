package tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/*
自定义 简易版HTTP
 */
public class CustomHTTP {
    private static final int prot = 9005;

    public static void main(String[] args) throws IOException {
        //1.创建一个 TCP 服务器
        ServerSocket serverSocket = new ServerSocket(prot);
        System.out.println("服务器已启动");
        //2.等待客户端连接
        Socket socket = serverSocket.accept();
        //3.得到读写对象 进行读写操作
        try(BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream())))
        {
            //读取首行信息 readLine
            String fistline = reader.readLine();
            if (fistline != null && !fistline.equals(" ")) {
                //用空格分割首行
                String[] fline = fistline.split(" ");
                //读取到请求方法的类型
                String method = fline[0];
                //读取到URL
                String url = fline[1];
                //读取到HTTP 版本号
                String httpVer = fline[2];
                /*System.out.println(String.format("读取到了客户端请求信息，方法类型：%s,URL：%s,版本号：%s",
                        method,url,httpVer));*/
                System.out.println(String.format("读取到客户端请求，方法类型：%s,URL：%s,版本：%s",
                        method, url, httpVer));
                //4.业务逻辑处理
                String content = "<h1>未知</h1>";
                if (url.contains("404")) {
                    content= "<h1>没有找到此页面</h1>";
                }else if (url.contains("200")) {
                    content = "<h1>你好，世界！</h1>";
                }else if(url.contains("500")) {
                    content = "<h1>服务器内部错误</h1>";
                }
                //5.将结果打印到浏览器上
                //写入首行信息
                writer.write(httpVer +" 200 ok\n");
                //写入head（返回的类型Content-Type/charset/Content-length 这个是字节码的长度）
                writer.write("Content-Type:text/html;charset=utf-8\n");
                writer.write("Content-Length:"+content.getBytes().length+"\n");
                //写入空行
                writer.write("\n");
                //写入body （content)
                writer.write(content);
                writer.flush();
            }
        }

    }
}
