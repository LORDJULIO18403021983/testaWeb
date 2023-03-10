package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Tabuada {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Captura a referência ao objeto PrintWriter que existe em response
		PrintWriter gravador = response.getWriter();

		// Escreve o código HTML
		gravador.println("<html>");
		gravador.println("<head><title>Tabuada</title></head>");
		gravador.println("<body>");
		gravador.println("<a href=http://localhost:8080/testaWeb/index.html>Página Principal</a>");
		gravador.println("<h1>Tabuada</h1>");
		for (int i = 0; i <= 10; i++) {
			gravador.println(i + "x 7 =" + (i * 7) + "<br/>");
		}
		gravador.println("</body>");
		gravador.println("</html>");
	}
}
