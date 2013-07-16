package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;

import pessoal.Usuario;
import controle.ControleDespesa;
import controle.ControleUsuario;
import financeiro.Despesa;

public class ControleDespesaBD {

	public static void addDespesaBD(Usuario usuario, Despesa despesa) {
		String sql = "insert into despesas (pessoa_login, descricao, valor, nome, tipo, dataentrada, datapagamento, atrasado)values ('"
			+ usuario.getLogin()
			+ "','"
			+ despesa.getDescricao()
			+ "','"
			+ despesa.getValor()
			+ "','"
			+ despesa.getNome()
			+ "','"
			+ despesa.getTipo()
			+ "','"
			+ despesa.getDataVencimento().getTime()
			+ "','"
			+ despesa.getDataPagamento().getTime()
			+"','"
			+despesa.getStatus()+ "')";
		
	acessoBanco.AdicionarComandoNoBanco(sql);
		
	}

	public static void removerDespesaBD(String id) {
		String sql =  "delete from despesas where iddespesas ='"+ id +"'";
		acessoBanco.AdicionarComandoNoBanco(sql);
		
	}

	public static void alterarDespesaBD(Usuario usuario, Despesa despesa) {
		String sql = "update despesas set nome = '" + despesa.getNome()
		+ "',dataentrada = '" + despesa.getDataPagamento().getTime()
		+ "',datapagamento = '" + despesa.getDataPagamento().getTime()
		+ "',descricao = '" + despesa.getDescricao()
		+ "',valor = '" + despesa.getValor()
		+ "',tipo = '" + despesa.getTipo()
		+ "',atrasado = '" + despesa.getStatus()
		+ "' where iddespesas = '" + despesa.getId()
		+ "'";
		acessoBanco.AdicionarComandoNoBanco(sql);
		
	}

	public static Despesa obterDespesaBD(Usuario usuario, String id) throws ParseException, SQLException {
		String sql = "Select * from despesas where pessoa_login = '"
			+ usuario.getLogin() + "' and iddespesas = '" + id + "'";
	ResultSet resultSet = acessoBanco.ListarBanco(sql);

	while (resultSet.next()) {
		String dataVencimento = resultSet.getObject(7).toString().replace('-', '/');
		String dataPagamento = resultSet.getObject(8).toString().replace('-', '/');
		
		Despesa despesa = ControleDespesa.criarDespesa(resultSet.getObject(5).toString(), resultSet.getObject(4).toString(), resultSet.getObject(3).toString(), resultSet.getObject(6).toString(), dataVencimento, dataPagamento, Boolean.parseBoolean(resultSet.getObject(5).toString()));
		despesa.setId(resultSet.getObject(1).toString());
		return despesa;
		
		
	}
	return null;
	}
	
	public static ArrayList<Despesa> notificarDespesas(Calendar hoje) throws ParseException, SQLException{
		ArrayList<Despesa> despesas = new ArrayList<Despesa>();
		String sql = "Select * from despesas where pessoa_login = '"
				+ ControleUsuario.getUsuarioAtual().getLogin()
				+ "' and dataentrada = '" + hoje.getTime() + "'";
		ResultSet resultSet = acessoBanco.ListarBanco(sql);

		while (resultSet.next()) {
			String dataVencimento = resultSet.getObject(7).toString().replace('-', '/');
			String dataPagamento = resultSet.getObject(8).toString().replace('-', '/');

			despesas.add(ControleDespesa.criarDespesa(resultSet.getObject(5).toString(), resultSet.getObject(4).toString(), resultSet.getObject(3).toString(), resultSet.getObject(6).toString(), dataVencimento, dataPagamento, Boolean.parseBoolean(resultSet.getObject(9).toString())));

		}
		return despesas;

	}

}
