package controle;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import pessoal.Informacao;
import pessoal.Registro;
import pessoal.Usuario;

public class ControleUsuario {
	
	private static Usuario usuarioAtual;
	
	
	public static Usuario criarUsuario(String nome, String login, String senha, ArrayList<Informacao> informacoes){
		Usuario usuario = new Usuario(nome, login, senha);
		usuario.setInformacoes(informacoes);
		
		return usuario;
		
	}
	
	public static void addUsuario(String nome, String login, String senha, ArrayList<Informacao> informacoes){
		Registro.addUsuario(criarUsuario(nome, login, senha, informacoes));
	}
	
	public static void removerUsuario(String nome){
		Registro.removerUsuario(nome);
	}

	public static void setUsuarioAtual(Usuario usuarioAtual) {
		ControleUsuario.usuarioAtual = usuarioAtual;
	}

	public static Usuario getUsuarioAtual() {
		return usuarioAtual;
	}
	
	public static void logIn(String login, String senha) throws SQLException, ParseException{
		Registro.logIn(login, senha);
	}

}
