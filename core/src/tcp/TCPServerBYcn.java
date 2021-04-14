package tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TCPServerBYcn {
    private static final int prot = 9004;

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(prot);
        System.out.println("服务器已启动");

        Socket socket = serverSocket.accept();

        try(BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()))
        ) {
            while (true) {
                Scanner scanner = new Scanner(System.in);
                String msg = bufferedReader.readLine();
                String en = scanner.nextLine();
                String cn = process(en);
            }
        }
    }

    private static String process(String en) {
        switch () {

        }
    }
}
