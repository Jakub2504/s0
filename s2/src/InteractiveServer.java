import java.io.*;
import java.net.*;

public class InteractiveServer {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private BufferedReader in;
    private PrintWriter out;

    public InteractiveServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public void start() throws IOException {
        System.out.println("Servidor en espera de connexions al port " + serverSocket.getLocalPort());
        clientSocket = serverSocket.accept();
        System.out.println("Connexió acceptada des de: " + clientSocket.getInetAddress());

        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        out = new PrintWriter(clientSocket.getOutputStream(), true);

        String inputLine;
        while (!(inputLine = in.readLine()).equalsIgnoreCase("FI")) {
            System.out.println("Received: " + inputLine);
            out.println(inputLine.toUpperCase());
        }

        System.out.println("Connexió tancada des de: " + clientSocket.getInetAddress());
        in.close();
        out.close();
        clientSocket.close();
        serverSocket.close();
    }

    public static void main(String[] args) {
        try {
            InteractiveServer server = new InteractiveServer(1234);
            server.start();
        } catch (IOException e) {
            System.err.println("Error al iniciar el servidor: " + e.getMessage());
        }
    }
}