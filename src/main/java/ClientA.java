import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientA {

    private PrintWriter writer;
    private Socket sock;
    private String hello = "hello";

    public void go() {
        setUpNetworking();
    }

    public void setUpNetworking() {
        try {
            sock = new Socket("127.0.0.1", 6666);
            writer = new PrintWriter(sock.getOutputStream());
            System.out.println("networking established");
            writeMessage();

            InputStreamReader inputStreamReader = new InputStreamReader(sock.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            System.out.println(bufferedReader.readLine());

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void writeMessage() {

        try {
            writer.println(new Scanner(System.in).next());
            writer.flush();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
