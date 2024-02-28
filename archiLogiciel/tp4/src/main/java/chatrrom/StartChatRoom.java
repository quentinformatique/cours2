package chatrrom;

import java.net.InetAddress;
import java.rmi.Naming; 
import java.rmi.registry.LocateRegistry;

public class StartChatRoom {    
    public static void main(String [] args){
        try {
            LocateRegistry.createRegistry(1099);        
            ChatRoomImpl chatroom = new ChatRoomImpl();
            Naming.rebind("chatroom", chatroom);
            System.out.println("Chat room lancé. Url = "
                    +"rmi://"+InetAddress.getLocalHost()
                            .getHostAddress()+":1099/chatroom");
        } catch(Exception e) { 
            System.out.println("Chat room non lance : Erreur "+e);
        }
    }
}

