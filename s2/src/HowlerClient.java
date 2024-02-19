import java.io.*;
import java.net.*;

public class HowlerClient {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public HowlerClient(String ip, int port) throws IOException {
        socket = new Socket(ip, port);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);
    }

    public void start() throws IOException {
        String inputLine;
        while (!(inputLine = readFromConsole()).equalsIgnoreCase("FI")) {
            System.out.println("Enviant: " + inputLine);
            out.println(inputLine);
            System.out.println("Rebuda: " + in.readLine());
        }

        System.out.println("Connexió tancada");
        in.close();
        out.close();
        socket.close();
    }

    private String readFromConsole() {
        System.out.print("> ");
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            return consoleReader.readLine();
        } catch (IOException e) {
            System.err.println("Error al llegir de la consola: " + e.getMessage());
            return "";
        }
    }

    public static void main(String[] args) {
        try {
            HowlerClient client = new HowlerClient("127.0.0.1", 1234);
            client.start();
        } catch (IOException e) {
            System.err.println("Error al iniciar el client: " + e.getMessage());
        }
    }
}