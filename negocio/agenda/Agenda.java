package agenda;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;

import pessoal.Usuario;
import database.ControleCompromissoBD;

public class Agenda {
 
	 
	private Usuario usuario;
	
	public Agenda(Usuario usuario){
		this.usuario = usuario;
	}
	 
	public boolean addCompromisso(Compromisso compromisso) {
		
		ControleCompromissoBD.addCompromissoBD(usuario, compromisso);
		return true;
	}
	 
	public boolean removerCompromisso(String nome) {
		ControleCompromissoBD.removerCompromissoBD(usuario, nome);
		return true;
	}
	 
	public boolean alterarCompromisso(Compromisso compromisso) {
		ControleCompromissoBD.alterarCompromissoBD(usuario, compromisso);
		return true;
	}
	 
	public Compromisso getCompromisso(String id) throws ParseException, SQLException {
		return ControleCompromissoBD.obterCompromissoBD(usuario, id);
	}
	
	 
	public ArrayList<Compromisso> notificarCompromissos(Calendar date) throws SQLException, ParseException {
		return ControleCompromissoBD.notificarCompromissosBD(date);
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	 
}
 
