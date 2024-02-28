package chatuser;

import interfaces_remote.ChatUser;
import java.rmi.*; 
import java.rmi.server.*;

public class ChatUserImpl extends UnicastRemoteObject 
            implements ChatUser {
   
    private IHMChatUser ihm;

    public ChatUserImpl(IHMChatUser ihm) throws RemoteException {
        this.ihm = ihm;
    }

    
    public void afficher(String message) throws RemoteException {
        ihm.afficher(message);
    }
}