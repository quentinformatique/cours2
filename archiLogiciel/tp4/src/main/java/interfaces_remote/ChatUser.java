package interfaces_remote;

import java.rmi.*;

public interface ChatUser extends Remote {
    public void afficher(String message) 
            throws RemoteException;
}