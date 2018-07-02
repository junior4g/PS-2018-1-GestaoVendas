package bancodados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BancoDados {
	public static void main(String[] args) throws SQLException {

		// Obter uma conex�o com o banco de dados.
		// URL de conex�o com o banco de dados Derby local.
		String url = "jdbc:derby:C:\\banco-de-teste;create=true";
		Connection conn = DriverManager.getConnection(url);

		conn.close();
	}

	private static void consultar(Connection conn) throws SQLException {
		String sql = "select * from produto order by id_produto";
		// Obt�m refer�ncia para uma senten�a SQL.
		PreparedStatement prepareStatement = conn.prepareStatement(sql);
		// Executa a instru��o SQL.
		ResultSet rs = prepareStatement.executeQuery();
		while (rs.next()) {
			int id_produto = rs.getInt("id produto");
			String nome_produto = rs.getString("nome");
			String fornecedor_produto = rs.getString("fornecedor");
			double preco_compra = rs.getDouble("preco de compra");
			double preco_venda = rs.getDouble("preco de venda");

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

	private static void excluir(Connection conn) throws SQLException {
		String sql = "delete from produto where id_produto=?";
		// Obt�m refer�ncia para uma senten�a SQL.
		PreparedStatement prepareStatement = conn.prepareStatement(sql);
		prepareStatement.setInt(1, 1);
		// Executa a instru��o SQL.
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}

	private static void alterar(Connection conn) throws SQLException {
		String sql = "update produto set nome_produto=? where id_produto=?";
		// Obt�m refer�ncia para uma senten�a SQL.
		PreparedStatement prepareStatement = conn.prepareStatement(sql);
		prepareStatement.setString(1, "Nome produto");
		prepareStatement.setInt(2, 1);
		// Executa a instru��o SQL.
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}

	private static void cadastrar(Connection conn) throws SQLException {
		String sql = "insert into produto (id_produto, nome_produto) values (?, ?)";
		// Obt�m refer�ncia para uma senten�a SQL.
		PreparedStatement prepareStatement = conn.prepareStatement(sql);
		prepareStatement.setInt(1, 2);
		prepareStatement.setString(2, "Nome produto");
		// Executa a instru��o SQL.
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

		// Obt�m refer�ncia para uma senten�a SQL.
		PreparedStatement prepareStatement = conn.prepareStatement(sql);
		// Executa a instru��o SQL.
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}
}