package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;

import pessoal.Usuario;
import academico.Avaliacao;
import academico.Curso;
import academico.Disciplina;
import controle.ControleAvaliacao;

public class ControleAvaliacaoBD {
	
	
	
	
	
	public static void criarAvaliacaoBD(Usuario usuario, Curso curso, Disciplina disciplina, Avaliacao avaliacao){
		String sql = "insert into avaliacao (disciplina_iddisciplina,pessoa_login,tipo,descricao,nota,data,horario)values ('"
			+ disciplina.getIdDisciplina()
			+ "','"
			+ usuario.getLogin()
			+ "','"
			+ avaliacao.getTipo()
			+ "','"
			+ avaliacao.getDescricao()
			+ "','"
			+ avaliacao.getNota()
			+ "','"
			+  avaliacao.getDataRealizacao().getTime()
			+"','"
			+ avaliacao.getHora()+"')";
	acessoBanco.AdicionarComandoNoBanco(sql);
	}

	public static void removerAvaliacaoBD(Usuario usuarioAtual, Curso curso, Disciplina disciplina, String id) {
		String sql =  "delete from avaliacao where idavaliacao ='"+ id +"'";
		
		acessoBanco.AdicionarComandoNoBanco(sql);
	}

	public static void alterarAvaliacaiBD(Usuario usuarioAtual, Curso curso, Disciplina disciplina, Avaliacao avaliacao) {
		String sql = "update avaliacao set descricao = '" + avaliacao.getDescricao()
		+ "',tipo = '" + avaliacao.getTipo()
		+ "',horario = '" + avaliacao.getHora()
		+ "',nota = '" + avaliacao.getNota()
		+ "',data = '" + avaliacao.getDataRealizacao().getTime()
		+ "' where idavaliacao = '" + avaliacao.getIdAvaliacao()
		+ "'";
		
		acessoBanco.AdicionarComandoNoBanco(sql);
	}

	public static Avaliacao obterAvaliacao(Usuario usuarioAtual, Curso curso, Disciplina disciplina, String nome) throws ParseException, SQLException {
		
		
		String sql = "Select * from avaliacao where disciplina_iddisciplina = '" + disciplina.getIdDisciplina() + "' and idavaliacao = '" + nome + "'";
		ResultSet resultSet = acessoBanco.ListarBanco(sql);
		
		
		while(resultSet.next()){
			
			String data = resultSet.getObject(7).toString().replace('-', '/');
			
			Avaliacao avaliacao = ControleAvaliacao.criarAvaliacao(resultSet.getObject(4).toString(), data, resultSet.getObject(5).toString(), resultSet.getObject(6).toString(), resultSet.getObject(8).toString(), resultSet.getObject(3).toString());
			avaliacao.setIdAvaliacao(resultSet.getObject(1).toString());
			return avaliacao;
		}
		
		
		return null;
	}
	
	public static ArrayList<Avaliacao> notificarAvaliacao(Usuario usuario, Calendar hoje) throws ParseException, SQLException{
		ArrayList<Avaliacao> avaliacoes = new ArrayList<Avaliacao>();
		String sql = "Select * from avaliacao where pessoa_login = '"
				+ usuario.getLogin()
				+ "' and data = '" + hoje.getTime() + "'";
		ResultSet resultSet = acessoBanco.ListarBanco(sql);

		while (resultSet.next()) {
			String data = resultSet.getObject(7).toString().replace('-', '/');
			
			Avaliacao avaliacao = ControleAvaliacao.criarAvaliacao(resultSet.getObject(4).toString(), data, resultSet.getObject(5).toString(), resultSet.getObject(6).toString(), resultSet.getObject(8).toString(), resultSet.getObject(3).toString());
			avaliacao.setIdAvaliacao(resultSet.getObject(1).toString());

			avaliacoes.add(avaliacao);
			
		}
		return avaliacoes;
	}
	

}
