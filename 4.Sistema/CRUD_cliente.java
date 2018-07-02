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

	private static void consultar(Connection conn) throws SQLException {
		String sql = "select * from cliente order by id_cliente";
		// Obtém referência para uma sentença SQL.
		PreparedStatement prepareStatement = conn.prepareStatement(sql);
		// Executa a instrução SQL.
		ResultSet rs = prepareStatement.executeQuery();
		while (rs.next()) {
			int id_cliente = rs.getInt("id cliente");
			String nome_cliente = rs.getString("nome");
			String cpf_cliente = rs.getString("cpf");
			String endereco = rs.getInt("endereco");

			System.out.println("Id cliente: " + id_cliente);
			System.out.println("Nome cliente: " + nome_cliente);
			System.out.println("Cpf cliente: " + cpf_cliente);
			System.out.println("Endereco: " + endereco);
			System.out.println();
		}
		rs.close();
		prepareStatement.close();
	}

	private static void excluir(Connection conn) throws SQLException {
		String sql = "delete from cliente where id_cliente=?";
		// Obtém referência para uma sentença SQL.
		PreparedStatement prepareStatement = conn.prepareStatement(sql);
		prepareStatement.setInt(1, 1);
		// Executa a instrução SQL.
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}

	private static void alterar(Connection conn) throws SQLException {
		String sql = "update cliente set nome_cliente=? where id_cliente=?";
		// Obtém referência para uma sentença SQL.
		PreparedStatement prepareStatement = conn.prepareStatement(sql);
		prepareStatement.setString(1, "Nome cliente");
		prepareStatement.setInt(2, 1);
		// Executa a instrução SQL.
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}

	private static void cadastrar(Connection conn) throws SQLException {
		String sql = "insert into cliente (id_cliente, nome_cliente) values (?, ?)";
		// Obtém referência para uma sentença SQL.
		PreparedStatement prepareStatement = conn.prepareStatement(sql);
		prepareStatement.setInt(1, 2);
		prepareStatement.setString(2, "Nome Cliente");
		// Executa a instrução SQL.
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}

	private static void criarTabelaCliente(Connection conn) throws SQLException {
		String sql = "create table cliente (";
		sql += "id_cliente int, ";
		sql += "nome_cliente varchar(255) ";
		sql += "cpf_cliente varchar(255) ";
		sql += "endereco varchar(255), ";
		sql += ")";

		// Obtém referência para uma sentença SQL.
		PreparedStatement prepareStatement = conn.prepareStatement(sql);
		// Executa a instrução SQL.
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}
}