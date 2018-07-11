import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    public void start() {

        ServerSocket serverSocket = null;
        int port = 6666;
        Socket clientSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;

        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e1) {
            System.out.println("Could not listen on port: " + port);
        }

        System.out.println("Waiting for connection...");

        try {
            clientSocket = serverSocket.accept();
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        } catch (Exception e2) {
            e2.printStackTrace();
        }

        System.out.println("Connection successful. Waiting for input...");

        String inputLine;
        try {
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Server: " + inputLine);
                out.println(inputLine);

                if (inputLine.equals("Bye.")) {
                    break;
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
