package serveur;


import java.net.ServerSocket;
import java.net.Socket;

/* Fonctionnement du Serveur :
1. Initialisation :
    - Choix d’un numéro de port local (port)
    - Création d’un ServerSocket sur ce port
2. Traitement (boucle arrêtée de l'extérieur)
    - Se mettre à l’écoute des demandes de connexion des clients
    - Créer un Socket de communication si une demande de connexion est
    acceptée
    - Créer un thread instance de Service en lui passant le socket et lancer ce thread.
*/

public class Serveur {
    public static void main(String [] args) {
      int port = 432; 
      try {
        ServerSocket ecoute = new ServerSocket(port);
        System.out.println("Serveur lancé !");
        while(true) {
          // Acceptation connexion, création d'un socket de communication
          Socket service = ecoute.accept();
          // Communication avec le client
          new serveur.Service(service).start();
      } 
    } catch (Exception e) {System.out.println(e);} // traitement d'erreur
  }
}

