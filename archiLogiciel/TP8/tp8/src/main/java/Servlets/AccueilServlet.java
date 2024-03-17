package Servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "accueil-servlet",
            value = "/accueil-servlet")
public class AccueilServlet extends HttpServlet {

	public void init() {
    }

	public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws IOException {
		String nickname = request.getParameter("nickname");



		
            response.sendRedirect(
                request.getContextPath() + "/accueil.html");

            response.sendRedirect(
                request.getContextPath() + "/chatPage.jsp");
    }

	public void destroy() {
	}
}
