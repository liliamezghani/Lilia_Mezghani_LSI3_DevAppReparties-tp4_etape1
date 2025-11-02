import java.net.*;
import java.io.*;
public class Serveur {
    private static final int PORT = 1234;
    private static byte[] buffer = new byte[1024];
    public static void main(String[] args) throws IOException {
        // Création du serveur sur le port 1234 avec InetSocketAddress
        InetSocketAddress adresse = new InetSocketAddress(PORT);
        DatagramSocket socket = new DatagramSocket(adresse);
        System.out.println("Serveur demarre sur le port " + PORT);
        System.out.println("attente de messages");
        while (true) {
            DatagramPacket paquet = new DatagramPacket(buffer, buffer.length);
            socket.receive(paquet);
            String message = new String(paquet.getData(), 0, paquet.getLength());
            InetAddress adresseClient = paquet.getAddress();
            int portClient = paquet.getPort();
            System.out.println("Message reçu de " + adresseClient.getHostAddress() + ":" + portClient);
            System.out.println("Contenu: " + message);
            System.out.println("----------------------");
        }
    }
}