package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExibeHora extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Verifica a data do servidor
		Date hoje = new Date();

		// Captura a refer�ncia ao objeto PrintWriter que existe em response
		PrintWriter gravador = response.getWriter();

		// Escreve o c�digo HTML
		gravador.println("<html>");
		gravador.println("<head><title>Primeiro Servlet</title><head>");
		gravador.println("<head><link rel=\"stylesheet\" href=\"CSS/estilo.css\"></head>");
		gravador.println("<body>");
		gravador.println("<h1>Hora do Servidor</h1><br/><br/>");
		gravador.println(hoje);
		gravador.println("<a href = 'http://localhost:8080/testaWeb'>Voltar</a>");
		gravador.println("</body>");
		gravador.println("</html>");
	}
}
