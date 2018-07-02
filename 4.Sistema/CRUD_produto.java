package bancodados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BancoDados {
	public static void main(String[] args) throws SQLException {

		// Obter uma conexão com o banco de dados.
		// URL de conexão com o banco de dados Derby local.
		String url = "jdbc:derby:C:\\banco-de-teste;create=true";
		Connection conn = DriverManager.getConnection(url);

		conn.close();
	}

	private static void pesquisarProduto(Connection conn) throws SQLException {
		String sql = "select * from produto order by id_produto";
		// Obtém referência para uma sentença SQL.
		PreparedStatement prepareStatement = conn.prepareStatement(sql);
		// Executa a instrução SQL.
		ResultSet rs = prepareStatement.executeQuery();
		while (rs.next()) {
			int id_produto = rs.getInt("id produto");
			String nome_produto = rs.getString("nome");
			String fornecedor_produto = rs.getString("fornecedor");
			double preco_compra = rs.getInt("preco de compra");
			double preco_venda = rs.getInt("preco de venda");

			System.out.println("Id produto: " + id_produto);
			System.out.println("Nome produto: " + nome_produto);
			System.out.println("Fornecedor produto: " + fornecedor_produto);
			System.out.println("Preco de compra: " + preco_compra);
			System.out.println("Preco de venda: " + preco_venda);
			System.out.println();
		}
		rs.close();
		prepareStatement.close();
	}

	private static void excluirProduto(Connection conn) throws SQLException {
		String sql = "delete from produto where id_produto=?";
		// Obtém referência para uma sentença SQL.
		PreparedStatement prepareStatement = conn.prepareStatement(sql);
		prepareStatement.setInt(1, 1);
		// Executa a instrução SQL.
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}

	private static void alterarProduto(Connection conn) throws SQLException {
		String sql = "update produto set nome_produto=? where id_produto=?";
		// Obtém referência para uma sentença SQL.
		PreparedStatement prepareStatement = conn.prepareStatement(sql);
		prepareStatement.setString(1, "ARROZ CRISTAL");
		prepareStatement.setInt(2, 1);
		// Executa a instrução SQL.
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}

	private static void cadastrarProduto(Connection conn) throws SQLException {
		String sql = "insert into produto (id_produto, nome_produto) values (?, ?)";
		// Obtém referência para uma sentença SQL.
		PreparedStatement prepareStatement = conn.prepareStatement(sql);
		prepareStatement.setInt(1, 2);
		prepareStatement.setString(2, "ARROZ CRISTAL");
		// Executa a instrução SQL.
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}

	private static void criarTabelaProduto(Connection conn) throws SQLException {
		String sql = "create table produto (";
		sql += "id_produto int, ";
		sql += "nome_produto varchar(255) ";
		sql += "fornecedor_produto varchar(255) ";
		sql += "preco_compra double, ";
		sql += "preco_venda double, ";
		sql += ")";

		// Obtém referência para uma sentença SQL.
		PreparedStatement prepareStatement = conn.prepareStatement(sql);
		// Executa a instrução SQL.
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}
}