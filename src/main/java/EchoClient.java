import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class EchoClient {

    public void start() {

        String serverHostName = "127.0.0.1";

        System.out.println("Attempting to connect to host.");

        Socket echoSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;

        try {
            echoSocket = new Socket(serverHostName, 6666);
            out = new PrintWriter(echoSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

        String userInput;

        System.out.println("input: ");

        try {
            while ((userInput = stdIn.readLine()) != null) {
                out.println(userInput);
                System.out.println("echo: " + in.readLine());
                System.out.println("input: ");

                if (userInput.equals("Bye.")) {
                    break;
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
