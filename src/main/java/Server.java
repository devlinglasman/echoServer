import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Server {

    public void go() {

        try {
            ServerSocket serverSock = new ServerSocket(6666);

            while (true) {

                Socket sock = serverSock.accept();
                InputStreamReader inputStreamReader = new InputStreamReader(sock.getInputStream());
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                String whatever = bufferedReader.readLine();
                System.out.println(whatever);

                PrintWriter writer = new PrintWriter(sock.getOutputStream());

                try {
                    writer.println("bonjour");
                    writer.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            }

        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }

}
