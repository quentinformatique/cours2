package src.tp1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.*;
import java.net.Socket;

public class Client extends Application {
    private TextField ipField, portField, messageField;
    private TextArea messagesArea;
    private Button connectButton, sendButton, disconnectButton;
    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;

    @Override
    public void start(Stage primaryStage) {
        ipField = new TextField();
        portField = new TextField();
        messageField = new TextField();
        messagesArea = new TextArea();
        connectButton = new Button("Connect");
        sendButton = new Button("Send");
        disconnectButton = new Button("Disconnect");

        Label ipLabel = new Label("Server IP:");
        Label portLabel = new Label("Server Port:");
        Label messageLabel = new Label("Message to send:");

        connectButton.setOnAction(e -> connect());
        sendButton.setOnAction(e -> send());
        disconnectButton.setOnAction(e -> disconnect());

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(ipLabel, ipField, portLabel, portField, connectButton, messageLabel, messageField, sendButton, messagesArea, disconnectButton);

        Scene scene = new Scene(layout, 300, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void connect() {
        try {
            System.out.println("Connecting to " + ipField.getText() + ":" + portField.getText());
            socket = new Socket(ipField.getText(), Integer.parseInt(portField.getText()));
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            new Thread(() -> {
                try {
                    String inputLine;
                    while ((inputLine = in.readLine()) != null) {
                        messagesArea.appendText(inputLine + "\n");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void send() {
        String message = messageField.getText();
        out.println(message);
        messageField.clear();
    }

    private void disconnect() {
        try {
            out.println("FIN");
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}