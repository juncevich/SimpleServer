

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.Date;
import com.sun.deploy.net.HttpUtils;
public class Main {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(8081);

        while (true) {
            System.out.println("Wait for TCP connection.");
            Socket socket = serverSocket.accept(); //hang on in method (операция блокирующая)
            System.out.println("Get 1 connection.");

            InputStream in = socket.getInputStream();
            OutputStream out = socket.getOutputStream();


            System.out.println("------------------------");
            System.out.println("------------------------");

            byte[] response = new Date().toString().getBytes(Charset.forName("US-ASCII")); //convert in case to put to byte[]
            out.write(response);
            socket.shutdownOutput();
            //socket.close();
        }


    }
}
