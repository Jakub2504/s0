import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Client {
    public static void main(String[] args) {
        System.out.println("Client, intent de connexió");
        String host = "127.0.0.1";
        int port = 1234;
        try{
            Socket s = new Socket(host, port);
            OutputStream os = s.getOutputStream();
            InputStreamReader isr = new InputStreamReader();
            isr.read();
            DataOutputStream dos = new DataOutputStream(os);
            dos.writeInt(99);
            dos.flush();
            dos.close();
            s.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}