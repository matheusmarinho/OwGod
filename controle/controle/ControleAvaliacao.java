package controle;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import academico.Avaliacao;

public class ControleAvaliacao {
	
	
	
	public static Avaliacao criarAvaliacao(String tipo, String dataRealizacao, String descricao, String nota, String hora, String usuario_login) throws ParseException, SQLException{
		SimpleDateFormat formata = new SimpleDateFormat("dd/MM/yyyy");  
		Calendar dateRealizacao = Calendar.getInstance();
		dateRealizacao.setTime(formata.parse(dataRealizacao));	
		Avaliacao avaliacao = new Avaliacao(tipo, dateRealizacao, hora);
		avaliacao.setDescricao(descricao);
		Double d_nota = Double.parseDouble(nota);
		avaliacao.setNota(d_nota);
		avaliacao.setUsuario_login(usuario_login);
		
		return avaliacao;
	}
	
	public static void addAvaliacao(String tipo, String dataRealizacao, String descricao, String nota, String hora, String usuario_login) throws SQLException, ParseException{
		ControleUsuario.getUsuarioAtual().getAcademico().obterCurso(ControleCurso.getCursoAtual().getId_curso()).obterDisciplina(ControleDisciplina.getDisciplinaAtual().getIdDisciplina()).addAvaliacao(criarAvaliacao(tipo, dataRealizacao, descricao, nota, hora, usuario_login));

	}
	
	public static void removerAvaliacao(String nome) throws SQLException{
		ControleUsuario.getUsuarioAtual().getAcademico().obterCurso(ControleCurso.getCursoAtual().getNome()).obterDisciplina(ControleDisciplina.getDisciplinaAtual().getNome()).removerAvaliacao(nome);
	}
	
	public static void alterarDisciplina(Avaliacao avaliacao, String tipo, String dataRealizacao, String descricao, String nota) throws ParseException, SQLException{
		SimpleDateFormat formata = new SimpleDateFormat("dd/MM/yyyy");  
		Calendar dateRealizacao = Calendar.getInstance();
		dateRealizacao.setTime(formata.parse(dataRealizacao));
		avaliacao.setTipo(tipo);
		avaliacao.setDataRealizacao(dateRealizacao);
		avaliacao.setDescricao(descricao);
		Double d_nota = Double.parseDouble(nota);
		avaliacao.setNota(d_nota);
		
		ControleUsuario.getUsuarioAtual().getAcademico().obterCurso(ControleCurso.getCursoAtual().getId_curso()).obterDisciplina(ControleDisciplina.getDisciplinaAtual().getIdDisciplina()).alterarAvaliacao(avaliacao);
	}
	
	public static Avaliacao obterAvaliacao(String id) throws SQLException, ParseException{
		return ControleUsuario.getUsuarioAtual().getAcademico().obterCurso(ControleCurso.getCursoAtual().getId_curso()).obterDisciplina(ControleDisciplina.getDisciplinaAtual().getIdDisciplina()).obterAvaliacao(id);
	}
	
	public static ArrayList<Avaliacao> notificarAvaliacao(String hoje) throws ParseException, SQLException{
		SimpleDateFormat formata = new SimpleDateFormat("dd/MM/yyyy");  
		Calendar dataHoje = Calendar.getInstance();
		dataHoje.setTime(formata.parse(hoje));
		
		return ControleUsuario.getUsuarioAtual().getAcademico().notificarAvaliacao(dataHoje);
	}
}
