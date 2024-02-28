package chatrrom;

import exceptions.PseudoDejaUtiliseException;
import exceptions.PseudoInconnuException;
import interfaces_remote.ChatRoom;
import interfaces_remote.ChatUser;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;



public class ChatRoomImpl extends UnicastRemoteObject 
        implements ChatRoom {
    
    private HashMap<String, ChatUser> users = new HashMap();

    public ChatRoomImpl() throws RemoteException {
    }  
    
    /**
     * Enregistrer un chat user sous un pseudo.
     * Lève PseudoDejaUtiliseException si pseudo déjà utilisé.
     */
    public void connecter(ChatUser user, String pseudo) 
            throws RemoteException, PseudoDejaUtiliseException {
        if (users.containsKey(pseudo)) throw new PseudoDejaUtiliseException();
        else {
            // Inscrire le nouvel utilisateur 
            this.users.put(pseudo, user);
            // En informer les autres utilisateurs
            String message = "Connexion de " + pseudo;
            this.poster(message, "ChatRoom");
        }
    }

    /**
     * Supprimer un chat user en indiquant son pseudo.
     * Lève PseudoInconnuException si pseudo inconnu.
     */
    public void deconnecter(String pseudo) 
            throws RemoteException, PseudoInconnuException {	
        if (!users.containsKey(pseudo)) throw new PseudoInconnuException();
        else {
            // Supprimer l'utilisateur 
            this.users.remove(pseudo);
            // En informer les autres utilisateurs 
            String message = "Déconnexion de " + pseudo;
            this.poster(message, "ChatRoom"); 
        }
    }
    
    /**
     * Dispatcher le message posté à tous les chat users enregistrés.
     */
    public void poster(String message, String pseudo) 
            throws RemoteException {
        String fullMessage = pseudo + " >> " + message;
        System.out.println(fullMessage);
        for(ChatUser user: users.values()) {
            user.afficher(fullMessage);
        }
    }
}