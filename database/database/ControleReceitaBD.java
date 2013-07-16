package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import pessoal.Usuario;
import controle.ControleReceita;
import financeiro.Receita;

public class ControleReceitaBD {
	
	
	
	
	

	public static void criarReceitaBD(Usuario usuario, Receita receita) {
		String sql = "insert into receita (pessoa_login, descricao, valor, nome, tipo, dataentrada)values ('"
			+ usuario.getLogin()
			+ "','"
			+ receita.getDescricao()
			+ "','"
			+ receita.getValor()
			+ "','"
			+ receita.getNome()
			+ "','"
			+ receita.getTipo()
			+ "','"
			+ receita.getDataEntrada().getTime() + "')";
		
	acessoBanco.AdicionarComandoNoBanco(sql);
		
	}

	public static void removerReceitaBD(String id) {
		String sql =  "delete from receita where id_receita ='"+ id +"'";
		acessoBanco.AdicionarComandoNoBanco(sql);
	}

	public static void alterarReceitaBD(Usuario usuario, Receita receita) {
		String sql = "update receita set nome = '" + receita.getNome()
		+ "',dataentrada = '" + receita.getDataEntrada().getTime()
		+ "',descricao = '" + receita.getDescricao()
		+ "',valor = '" + receita.getValor()
		+ "',tipo = '" + receita.getTipo()
		+ "' where id_receita = '" + receita.getId()
		+ "'";
		acessoBanco.AdicionarComandoNoBanco(sql);
		
	}

	public static Receita obterReceitaBD(Usuario usuario, String id) throws SQLException, ParseException {
		String sql = "Select * from receita where pessoa_login = '"
			+ usuario.getLogin() + "' and id_receita = '" + id + "'";
	ResultSet resultSet = acessoBanco.ListarBanco(sql);

	while (resultSet.next()) {
		String data = resultSet.getObject(7).toString().replace('-', '/');

		Receita receita = ControleReceita.criarReceita(resultSet.getObject(5).toString(), resultSet.getObject(4).toString(), resultSet.getObject(3).toString(), data, resultSet.getObject(6).toString());
		receita.setId(resultSet.getObject(1).toString());
		return receita;
		
	}
	return null;
	}

}
	



