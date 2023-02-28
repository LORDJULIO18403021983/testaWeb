package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FilmeDao;
import model.Filme;
import util.ConnectionFactory;

public class ListarFilme extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println(request.getParameter("nomeDoFilme"));
		System.out.println(request.getParameter("valorDoFilme"));
		System.out.println(request.getParameter("generoDoFilme"));
		System.out.println(request.getParameter("disponivel") + "\n");

		PrintWriter gravador = response.getWriter();

		gravador.println("<html>");
		gravador.println("<style>");
		gravador.println("table, th, td { border:1px solid black; }");
		gravador.println("</style>");
		gravador.println("<head><title>..::Lista de Filmes::..</title></head>");

		gravador.println("<body>");
		gravador.println("<h1> Lista de filmes</h1><br>");
		gravador.println("<table style = 'width:100%' >");
		gravador.println("<tr>");
		gravador.println("<th>Nome do Filme</th>");
		gravador.println("<th>Valor do Filme</th>");
		gravador.println("<th>Genero do Filme</th>");
		gravador.println("<th>Disponivel</th>");
		gravador.println("</tr>");

		gravador.println("<tr>");
		gravador.println("</tr>");
		gravador.println("<a href = http://localhost:8080/testaWeb>Voltar</a>");
		gravador.println("</body>");
		gravador.println("</html>");

		Connection conn = ConnectionFactory.getConnection();
		FilmeDao filmeDao = new FilmeDao(conn);
		Filme filme = new Filme();

	}
}
