import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        System.out.println("Servidor, esperant conexions");
        int port = 1234;
        try {
            ServerSocket ss = new ServerSocket(port);
            Socket s = ss.accept();
            InputStream is = s.getInputStream();
            DataInputStream dis = new DataInputStream(is);
            System.out.println(dis.readInt());
            dis.close();
            s.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}