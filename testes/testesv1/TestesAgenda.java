package testesv1;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import agenda.Compromisso;
import controle.ControleCompromisso;

public class TestesAgenda {
	
	public static ArrayList<Compromisso> compromissos = new ArrayList<Compromisso>();
	
	
	public static void criarCompromissos() throws ParseException{
		
		for (int i = 0; i < 1; i++){	
			ControleCompromisso.addCompromisso("compromisso", "20/09/2012", "meu niver");
			ControleCompromisso.addCompromisso("compromisso2", "06/09/2012", "Sclerol");
		}		
	}
	
	public static void removerCompromisso(){
		ControleCompromisso.removerCompromisso("2");
	}
	
	public static void obterCompromissos() throws ParseException, SQLException{
		System.out.println(ControleCompromisso.obterCompromisso("1").getNome());
	}
	
	public static void alterarCompromissos() throws ParseException, SQLException{
		ControleCompromisso.alterarCompromimsso(ControleCompromisso.obterCompromisso("1"), "comp up", "11/09/2012", "teste update");
	}
	
	
	public static void print() throws ParseException, SQLException{
		System.out.println("-------teste notificações---------");
		for (Compromisso compromisso : ControleCompromisso.notificarCompromissos("11/09/2012")){
			System.out.println(compromisso.getAgenda().getUsuario().getNome() + "--" + compromisso.getNome() + "--" + compromisso.getDescricao());
		}
	}
}
