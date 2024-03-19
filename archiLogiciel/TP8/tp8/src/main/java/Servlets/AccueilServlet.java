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
		String type = request.getParameter("type");

		if (type.equals("admin")) {
			response.sendRedirect(
					request.getContextPath() + "/connexions/connexion_admin.jsp");
		} else if (type.equals("client")) {
			response.sendRedirect(
					request.getContextPath() + "/connexions/connexion_client.jsp");
		}
	}

	public void destroy() {
	}
}
