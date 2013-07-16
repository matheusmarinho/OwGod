package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;

import pessoal.Usuario;
import agenda.Compromisso;
import controle.ControleCompromisso;
import controle.ControleUsuario;

public class ControleCompromissoBD {

	public static void addCompromissoBD(Usuario usuario, Compromisso compromisso) {
		String sql = "insert into compromisso (pessoa_login,nome,data_2,descricao)values ('"
				+ usuario.getLogin()
				+ "','"
				+ compromisso.getNome()
				+ "','"
				+ compromisso.getDataRealizacao().getTime()
				+ "','"
				+ compromisso.getDescricao() + "')";
		acessoBanco.AdicionarComandoNoBanco(sql);

	}

	public static void removerCompromissoBD(Usuario usuario, String id) {
		String sql =  "delete from compromisso where idcompromisso ='"+ id +"'";
		
		acessoBanco.AdicionarComandoNoBanco(sql);
	}

	public static void alterarCompromissoBD(Usuario usuario,
			Compromisso compromisso) {
		String sql = "update compromisso set nome = '" + compromisso.getNome()
				+ "',data_2 = '" + compromisso.getDataRealizacao().getTime()
				+ "',descricao = '" + compromisso.getDescricao()
				+ "' where idcompromisso = '" + compromisso.getId_compromisso()
				+ "'";
		acessoBanco.AdicionarComandoNoBanco(sql);

	}

	public static Compromisso obterCompromissoBD(Usuario usuario, String id)
			throws ParseException, SQLException {
		String sql = "Select * from compromisso where pessoa_login = '"
				+ usuario.getLogin() + "' and idcompromisso = '" + id + "'";
		ResultSet resultSet = acessoBanco.ListarBanco(sql);

		while (resultSet.next()) {
			String data = resultSet.getObject(4).toString().replace('-', '/');

			Compromisso compromisso = ControleCompromisso.criarCompromisso(
					resultSet.getObject(3).toString(), data, resultSet
							.getObject(5).toString());
			compromisso.setId_compromisso(resultSet.getObject(1).toString());
			return compromisso;
		}

		return null;
	}

	public static ArrayList<Compromisso> notificarCompromissosBD(Calendar date)
			throws SQLException, ParseException {
		ArrayList<Compromisso> compromissos = new ArrayList<Compromisso>();
		String sql = "Select * from Compromisso where pessoa_login = '"
				+ ControleUsuario.getUsuarioAtual().getLogin()
				+ "' and data_2 = '" + date.getTime() + "'";
		ResultSet resultSet = acessoBanco.ListarBanco(sql);

		while (resultSet.next()) {
			String data = resultSet.getObject(4).toString().replace('-', '/');

			compromissos.add(ControleCompromisso.criarCompromisso(resultSet
					.getObject(3).toString(), data, resultSet.getObject(5)
					.toString()));

		}
		return compromissos;

	}
}
