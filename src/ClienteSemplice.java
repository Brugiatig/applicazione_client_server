import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClienteSemplice {
    public static void main(String[] args){
        final String hostname = "127.0.0.1";
        final int port = 12345;
        try(Socket socket =new Socket(hostname, port)){
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            Scanner scanner = new Scanner(System.in);

            System.out.println("connesso al server, scrivi qualcosa");
            String userInput;
            while((userInput = scanner.nextLine()) != null) {
                out.println(userInput);
                System.out.println("Risposta:" + in.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
