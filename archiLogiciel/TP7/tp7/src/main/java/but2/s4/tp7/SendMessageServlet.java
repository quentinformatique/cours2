package but2.s4.tp7;

import but2.s4.tp7.engine.ChatRoom;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "sendMessageServlet",
            value = "/send-message-servlet")
public class SendMessageServlet extends HttpServlet {

    private String message;

    public void init() {
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws IOException {
        String message;
        message = request.getParameter("message");

        this.message = message;

        if (this.isMessageValid()) {
            ChatRoom.addMessage(this.message);
        }

        response.sendRedirect(
            request.getContextPath() + "/chatPage.jsp");
    }

    public void destroy() {
    }

    private boolean isMessageValid() {
        return !this.message.isBlank();
    }

}
