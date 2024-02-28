package interfaces_remote;


import exceptions.PseudoDejaUtiliseException;
import exceptions.PseudoInconnuException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ChatRoom extends Remote {
    public void connecter(ChatUser user, String pseudo) 
            throws RemoteException, PseudoDejaUtiliseException;
    public void deconnecter(String pseudo) 
            throws RemoteException, PseudoInconnuException;

    public void poster(String message, String pseudo) 
            throws RemoteException;
}

