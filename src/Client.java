import java.net.*;
import java.io.*;
import java.util.Scanner;
public class Client {
    private static final String SERVEUR = "localhost";
    private static final int PORT = 1234;
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez votre nom: ");
        String nom = scanner.nextLine();
        System.out.println("Connecté au serveur, Tapez vos messages");
        while (true) {
            System.out.print("> ");
            String message = scanner.nextLine();
            if ("quit".equalsIgnoreCase(message)) {
                break;
            }
            String messageComplet = "[" + nom + "]: " + message;
            byte[] data = messageComplet.getBytes();
            DatagramPacket paquet = new DatagramPacket(
                data, 
                data.length, 
                InetAddress.getByName(SERVEUR), 
                PORT
            );
            socket.send(paquet);
            System.out.println("Message envoye");
        }
        scanner.close();
        socket.close();
        System.out.println("Deconnexion");
    }
}