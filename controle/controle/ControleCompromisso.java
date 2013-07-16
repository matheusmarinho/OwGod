package controle;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import agenda.Compromisso;

public class ControleCompromisso {
	
	
	
	
	public static Compromisso criarCompromisso(String nome, String dataRealizacao, String descricao) throws ParseException{
		SimpleDateFormat formata = new SimpleDateFormat("dd/MM/yyyy");  
		Calendar dateRealizacao = Calendar.getInstance();
		dateRealizacao.setTime(formata.parse(dataRealizacao));
		Compromisso compromisso = new Compromisso(nome, dateRealizacao, descricao, ControleUsuario.getUsuarioAtual().getAgenda());
		
		return compromisso;
	}
	
	public static void addCompromisso(String nome, String dataRealizacao, String descricao) throws ParseException{
		
		ControleUsuario.getUsuarioAtual().getAgenda().addCompromisso(criarCompromisso(nome, dataRealizacao, descricao));
	}
	
	public static void removerCompromisso(String nome){
		ControleUsuario.getUsuarioAtual().getAgenda().removerCompromisso(nome);
	}
	
	public static void alterarCompromimsso(Compromisso compromisso, String nome, String dataRealizacao, String descricao) throws ParseException{
		SimpleDateFormat formata = new SimpleDateFormat("dd/MM/yyyy");  
		Calendar dateRealizacao = Calendar.getInstance();
		dateRealizacao.setTime(formata.parse(dataRealizacao));
		
		compromisso.setNome(nome);
		compromisso.setDataRealizacao(dateRealizacao);
		compromisso.setDescricao(descricao);
		
		ControleUsuario.getUsuarioAtual().getAgenda().alterarCompromisso(compromisso);
	}
	
	public static Compromisso obterCompromisso(String id) throws ParseException, SQLException{
		return ControleUsuario.getUsuarioAtual().getAgenda().getCompromisso(id);
	}

	
	
	public static ArrayList<Compromisso> notificarCompromissos(String hoje) throws ParseException, SQLException{
		SimpleDateFormat formata = new SimpleDateFormat("dd/MM/yyyy");  
		Calendar dataHoje = Calendar.getInstance();
		dataHoje.setTime(formata.parse(hoje));
		
		return ControleUsuario.getUsuarioAtual().getAgenda().notificarCompromissos(dataHoje);
	}
	
}
