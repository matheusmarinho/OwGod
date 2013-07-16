package pessoal;

import java.sql.SQLException;
import java.text.ParseException;

//import Pacote de Teste.testesv1.TestesAgenda;
import controle.ControleUsuario;
import database.ControleUsuarioBD;


public class Registro {
 

	public static void addUsuario(Usuario usuario) {
		ControleUsuarioBD.addUsuarioBD(usuario);
	}
	 
	public static void removerUsuario(String nome) {
		ControleUsuarioBD.removerUsuarioBD(nome);
	}
	 
	public void alterarUsuario(String nome) {
		
	}
	 
	public void getUsuario(String nome) {
		
	}
	
	public static void logIn(String login, String senha) throws SQLException, ParseException{
		Usuario usuarioLogado = ControleUsuarioBD.realizarLogIn(login, senha);
		if (usuarioLogado != null){
			ControleUsuario.setUsuarioAtual(usuarioLogado);
			//ControleUsuario.getUsuarioAtual().getAgenda().notificarCompromissos(Calendar.getInstance());
			//TestesAgenda.print();
		}
	}
	
	public static void logOut(){
		ControleUsuario.setUsuarioAtual(null);
	}

	
	
	 
}
 
