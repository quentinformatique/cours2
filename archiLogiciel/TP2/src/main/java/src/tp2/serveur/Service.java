package serveur;

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
                if (message == "SOLDE") {
                    out.println("Votre solde est de 1000 euros");
                }
            }
            socket.close();
        }catch (Exception e) {System.out.println("Erreur : "+e);}
        
    }
}
