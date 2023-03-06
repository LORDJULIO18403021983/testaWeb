package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Produto;

public class ProdutoDao {
	private final Connection conn;

	public ProdutoDao(Connection conn) {
		this.conn = conn;
	}

	// INSERIR
	public void inserir(Produto produto) throws SQLException {
		String sql = "insert into produto(descricao, valorCusto, valorVenda, "
				+ "garantia, estoque, codigoDeBarras, nomeDoVendedor)values(?,?,?,?,?,?,?)";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setString(1, produto.getDescricao());
		pstm.setDouble(2, produto.getValorCusto());
		pstm.setDouble(3, produto.getValorVenda());
		pstm.setInt(4, produto.getGarantia());
		pstm.setInt(5, produto.getEstoque());
		pstm.setInt(6, produto.getCodigoDeBarras());
		pstm.setString(7, produto.getNomeDoVendedor());

		pstm.execute();
	}

	// CONSULTAR
	public List<Produto> buscarTodosDao() throws SQLException {

		String sql = "select * from produto";
		PreparedStatement pstm = conn.prepareStatement(sql);
		ResultSet cursor = pstm.executeQuery();

		List<Produto> produtos = new ArrayList<Produto>();

		while (cursor.next()) {
			Produto produto = new Produto();
			produto.setDescricao(cursor.getString("descricao"));
			produto.setValorCusto(cursor.getDouble("valorCusto"));
			produto.setValorVenda(cursor.getDouble("valorVenda"));
			produto.setGarantia(cursor.getInt("garantia"));
			produto.setEstoque(cursor.getInt("estoque"));
			produto.setCodigoDeBarras(cursor.getInt("codigoDeBarras"));
			produto.setNomeDoVendedor(cursor.getString("nomeDoVendedor"));
			produtos.add(produto);
		}
		return produtos;
	}
}



