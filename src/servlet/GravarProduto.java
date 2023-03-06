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

import dao.ProdutoDao;
import model.Produto;
import util.ConnectionFactory;

public class GravarProduto extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(request.getParameter("descricao"));
		System.out.println(request.getParameter("valorCusto"));
		System.out.println(request.getParameter("valorVenda"));
		System.out.println(request.getParameter("garantia"));
		System.out.println(request.getParameter("estoque"));
		System.out.println(request.getParameter("codigoDeBarras"));
		System.out.println(request.getParameter("nomeDoVendedor") + "\n");

		// Captura a referência ao objeto PrintWriter que existe em response.
		PrintWriter gravador = response.getWriter();

		// Escreve o c�digo HTML.
		gravador.println("<html>");
		gravador.println("<head><title>Produto Gravado</title></head>");
		gravador.println("<body>");
		gravador.println("<h1>Produto Gravado com sucesso</h1><br/><br/>");
		gravador.println("<a href = http://localhost:8080/testaWeb>Voltar</a>");
		gravador.println("</body>");
		gravador.println("</html>");

		Connection conn = ConnectionFactory.getConnection();
		ProdutoDao produtoDao = new ProdutoDao(conn);
		Produto produto = new Produto();

		produto.setDescricao(request.getParameter("descricao").trim());

		produto.setValorCusto(Double.parseDouble(request.getParameter("valorCusto").trim()));

		produto.setValorVenda(Double.parseDouble(request.getParameter("valorVenda").trim()));

		produto.setGarantia(Integer.parseInt(request.getParameter("garantia")));

		produto.setEstoque(Integer.parseInt(request.getParameter("estoque")));

		produto.setCodigoDeBarras(Integer.parseInt(request.getParameter("codigoDeBarras")));

		produto.setNomeDoVendedor(request.getParameter("nomeDoVendedor"));

		try {
			produtoDao.inserir(produto);
			System.out.println("Produto inserido com sucesso!");
		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, erro.getStackTrace(), null, JOptionPane.ERROR_MESSAGE);
		}
	}
}
