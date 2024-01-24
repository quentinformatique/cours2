package src.tp1;

import java.io.*;
import java.net.*;

public class Server {
    private ServerSocket serverSocket;

    public Server(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public void start() throws IOException {
        while (true) {
            new ServerThread(serverSocket.accept()).start();
        }
    }

    private static class ServerThread extends Thread {
        private Socket socket;

        public ServerThread(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                String inputLine;
                while (!(inputLine = in.readLine()).equals("FIN")) {
                    System.out.println("Reçu: " + inputLine);
                    out.println("Reçu: " + inputLine);
                }

                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new Server(1234).start();
    }
}