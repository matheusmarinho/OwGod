package testesv1;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import pessoal.Usuario;
import controle.ControleUsuario;

public class TestesCriarUsuario {
	
	
	public static ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	
	
	
	public static void criarUsuario(){
		
		ControleUsuario.addUsuario("Miguel Ecar", "miguel", "senha1", null);
		ControleUsuario.addUsuario("Fulano de tal", "fulano", "senha2", null);
	}
	
	
	public static void logIn() throws SQLException, ParseException{
		ControleUsuario.logIn("miguel", "senha1");
	}
	
	public static void print(){
		for(Usuario usuario : usuarios){
			System.out.println(usuario.getNome());
		}
		System.out.println("-usuario atual-");
		System.out.println(ControleUsuario.getUsuarioAtual().getNome());
	}
}
