package src.tp1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Dialogue avec le serveur : boucle arrêtée par la réception du
 * message "FIN" :
 *  o Lecture du message à partir du socket de communication
 *  o Renvoyer au client un accusé réception. 
 */
public class Service extends Thread {
    private Socket socket;
    
    public Service(Socket socket) {
        this.socket = socket;
    }
    
    @Override
    public void run() {
        try {
            PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String message;
            boolean fin = false;
            while (!fin) {
                message = in.readLine(); // lecture message
                System.out.println("RECU: " + message);// trace locale
                out.println("RECU: " + message); // renvoi d'un reçu
                if (message.equals("FIN")) fin = true;
            }
            socket.close();
        }catch (Exception e) {System.out.println("Erreur : "+e);}
        
    }
}
