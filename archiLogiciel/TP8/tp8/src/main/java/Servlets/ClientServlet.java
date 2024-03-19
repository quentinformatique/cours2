package Servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import javabeans.Boutique;

import java.io.IOException;

public class ClientServlet extends HttpServlet {

	public void init() {
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		String action = request.getParameter("action");
		// Retrieve the Boutique instance from the application scope
		Boutique boutique = (Boutique) getServletContext().getAttribute("boutique");
		String identifiant = request.getParameter("login");
		String motDePasse = request.getParameter("password");

		if ("Se connecter".equals(action)) {
			try {
				boutique.getClient(identifiant, motDePasse);
				response.sendRedirect(
						request.getContextPath() + "/achats.jsp");
			} catch (Exception e) {
				response.sendRedirect(
						request.getContextPath() + "/connexions/connexion_client.jsp");
			}
		} else if ("S'inscrire".equals(action)) {
			try {
				boutique.enregistrerClient(identifiant, motDePasse);
				response.sendRedirect(
						request.getContextPath() + "/clients/achats.jsp");
			} catch (Exception e) {
				response.sendRedirect(
						request.getContextPath() + "/connexions/connexion_client.jsp");
			}
		}
	}

	public void destroy() {
	}

}
