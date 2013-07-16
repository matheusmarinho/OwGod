package database;

import java.sql.ResultSet;
import java.sql.SQLException;

import pessoal.Usuario;
import controle.ControleUsuario;

public class ControleUsuarioBD {

	public static void addUsuarioBD(Usuario usuario) {
		String sql = "insert into pessoa (login,senha,nome) values ('"
				+ usuario.getLogin() + "','" + usuario.getSenha() + "','"
				+ usuario.getNome() + "')";
		acessoBanco.AdicionarComandoNoBanco(sql);
	}

	public static void removerUsuarioBD(String nome) {

	}

	public static Usuario realizarLogIn(String login, String senha) throws SQLException {
		 String sql = "Select * from Pessoa where login = '" + login + "' and senha = '" + senha + "'";
		 ResultSet resultSet = acessoBanco.ListarBanco(sql);
		
		 while (resultSet.next()){
		 Usuario usuarioAtual =  ControleUsuario.criarUsuario(resultSet.getObject(4).toString(), resultSet.getObject(2).toString(), resultSet.getObject(3).toString(), null);
		 ControleUsuario.setUsuarioAtual(usuarioAtual);
		 return	usuarioAtual;
		 }
		 return	null;
		 /*
		
		for (Usuario usuario : TestesCriarUsuario.usuarios) {
			if (usuario.getLogin().equals(login)
					&& usuario.getSenha().equals(senha)) {
				// ControleUsuario.setUsuarioAtual(usuario);
				return usuario;
			} else {
				return null;
			}
		}

		return null;
		*/
	}

}
