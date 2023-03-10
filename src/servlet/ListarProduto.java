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

import dao.ProdutoDao;
import model.Produto;
import util.ConnectionFactory;

public class ListarProduto extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Connection conn = ConnectionFactory.getConnection();
		ProdutoDao produtoDao = new ProdutoDao(conn);
		List<Produto> produtos = new ArrayList<Produto>();

		try {
			produtos = produtoDao.buscarTodosDao();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		PrintWriter gravador = response.getWriter();

		gravador.println("<html>");
		gravador.println("<style>");
		gravador.println("table, th, td { border:1px solid black; }");
		gravador.println("</style>");
		gravador.println("<head><title>Lista de Produtos</title></head>");

		gravador.println("<body>");
		gravador.println("<h1> ..::Lista de produtos::..</h1><br>");
		gravador.println("<table style = 'width:100%' >");
		gravador.println("<tr>");
		gravador.println("<th>Descrição</th>");
		gravador.println("<th>Valor do Custo</th>");
		gravador.println("<th>Valor de Venda</th>");
		gravador.println("<th>Garantia</th>");
		gravador.println("<th>Estoque</th>");
		gravador.println("<th>Codigo de Barras</th>");
		gravador.println("<th>Nome do Vendedor</th>");
		gravador.println("</tr>");

		for (Produto p : produtos) {
			gravador.println("<tr>");
			gravador.println("<td>" + p.getDescricao() + "</td>");
			gravador.println("<td>" + p.getValorCusto() + " </td>");
			gravador.println("<td>" + p.getValorVenda() + " </td>");
			gravador.println("<td>" + p.getGarantia() + "</td>");
			gravador.println("<td>" + p.getEstoque() + "</td>");
			gravador.println("<td>" + p.getCodigoDeBarras() + "</td>");
			gravador.println("<td>" + p.getNomeDoVendedor() + "</td>");
			gravador.println("</tr>");
		}

		gravador.println("<a href = http://localhost:8080/testaWeb>Voltar</a>");
		gravador.println("</body>");
		gravador.println("</html>");
	}
}
