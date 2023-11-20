package fourteen;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ChatClient {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input your nickname: ");
        String nickname = scanner.nextLine();

        try (Socket socket = new Socket("127.0.0.1", 8000);
             PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
             Scanner serverScanner = new Scanner(socket.getInputStream())) {

            System.out.println("connected");

            Thread serverThread = new Thread(() -> {
                while (serverScanner.hasNextLine()) {
                    String serverMessage = serverScanner.nextLine();
                    System.out.println(serverMessage);
                }
            });
            serverThread.start();

            while (true) {
                LocalDateTime time = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm dd.MM.yyyy");
                String formattedTime = time.format(formatter);
                String message = scanner.nextLine();
                writer.println("[" + nickname + "]: " + message + " " + formattedTime);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
