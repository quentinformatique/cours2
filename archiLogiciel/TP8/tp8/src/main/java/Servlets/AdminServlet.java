package Servlets;


import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "admin-servlet",
		value = "/admin-servlet")

public class AdminServlet extends HttpServlet {

	public void init() {
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException {

	}

	public void destroy() {
	}
}
