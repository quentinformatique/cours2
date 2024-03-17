package but2.s4.tp7;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "loginServlet",
            value = "/login-servlet")
public class LoginServlet extends HttpServlet {

    private String nickname;

    public void init() {
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws IOException {
        String nickname;
        nickname = request.getParameter("nickname");

        this.nickname = nickname;

        if (!this.isNicknameValid()) {
            response.sendRedirect(
                request.getContextPath() + "/accueil.html");
        } else {
            request.getSession().setAttribute("nickname", nickname);

            response.sendRedirect(
                request.getContextPath() + "/chatPage.jsp");
        }
    }

    public void destroy() {
    }

    private boolean isNicknameValid() {
        return !this.nickname.isBlank();
    }

}
