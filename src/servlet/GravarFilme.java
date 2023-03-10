package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import dao.FilmeDao;
import model.Filme;
import util.ConnectionFactory;

public class GravarFilme extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(request.getParameter("nomeDoFilme"));
		System.out.println(request.getParameter("valorDoFilme"));
		System.out.println(request.getParameter("generoDoFilme"));
		System.out.println(request.getParameter("disponivel") + "\n");

		// Captura a referência ao objeto PrintWriter que existe em response.
		PrintWriter gravador = response.getWriter();

		// Escreve o código HTML.
		gravador.println("<html>");
		gravador.println("<head><title>Filme Gravado</title></head>");
		gravador.println("<body>");
		gravador.println("<h1>Filme Gravado com sucesso</h1><br/><br/>");
		gravador.println("<a href = http://localhost:8080/testaWeb>Voltar</a>");
		gravador.println("</body>");
		gravador.println("</html>");

		Connection conn = ConnectionFactory.getConnection();
		FilmeDao filmeDao = new FilmeDao(conn);
		Filme filme = new Filme();

		if (request.getParameter("nomeDoFilme").isEmpty()) {
		} else {
			filme.setNome(request.getParameter("nomeDoFilme").trim());
		}
		if (request.getParameter("valorDoFilme").isEmpty()) {
		} else {
			try {
				filme.setValor(Double.parseDouble(request.getParameter("valorDoFilme").trim()));
			} catch (NumberFormatException erro) {
				erro.printStackTrace();
			}
			if (request.getParameter("generoDoFilme").isEmpty()) {
			} else {
				filme.setGenero(request.getParameter("generoDoFilme"));
			}
			if (request.getParameter("disponivel").isEmpty()) {
			} else {
				filme.setDisponivel(request.getParameter("disponivel"));
			}
			try {
				filmeDao.inserir(filme);
				System.out.println("Filme inserido com sucesso!");
			} catch (SQLException erro) {
				JOptionPane.showMessageDialog(null, erro.getStackTrace(), null, JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
