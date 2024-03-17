package but2.s4.tp7.engine;

import java.util.ArrayList;
import java.util.List;

public class ChatRoom {

    private static List<String> messages;

    public static List<String> getMessages() {
        return messages;
    }

    public static void addMessage(String message) {
        messages.add(message);
    }

    @Override
    public String toString() {
        StringBuilder display;
        display = new StringBuilder();

        for (String message : messages) {
            display.append(message)
                   .append("\n");
        }

        return display.toString();
    }

}
