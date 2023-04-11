package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

		Connection conn = ConnectionFactory.getConnection();
		FilmeDao filmeDao = new FilmeDao(conn);
		List<Filme> filmes = new ArrayList<Filme>();

		try {
			filmes = filmeDao.buscarTodosDao();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		PrintWriter gravador = response.getWriter();

		gravador.println("<html>");
		gravador.println("<style>");
		gravador.println("table, th, td { border:1px solid black; }");
		gravador.println("</style>");
		gravador.println("<head><title>..::Lista de Filmes::..</title><head>");
		gravador.println("<head><link rel=\"stylesheet\" href=\"CSS/estilo.css\"></head>");

		gravador.println("<body>");
		gravador.println("<h1> Lista de filmes</h1><br>");
		gravador.println("<table style = 'width:100%' >");
		gravador.println("<tr>");
		gravador.println("<th>Nome do Filme</th>");
		gravador.println("<th>Valor do Filme</th>");
		gravador.println("<th>Genero do Filme</th>");
		gravador.println("<th>Disponivel</th>");
		gravador.println("</tr>");

		for (Filme f : filmes) {
			gravador.println("<tr>");
			gravador.println("<td>" + f.getNome() + "</td>");
			gravador.println("<td>" + f.getValor() + " </td>");
			gravador.println("<td>" + f.getGenero() + "</td>");
			gravador.println("<td>" + f.getStatus() + "</td>");
			gravador.println("</tr>");
		}

		gravador.println("<a href = http://localhost:8080/testaWeb>Voltar</a>");
		gravador.println("</body>");
		gravador.println("</html>");
	}
}
