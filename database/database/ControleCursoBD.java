package database;

import java.sql.ResultSet;
import java.sql.SQLException;

import pessoal.Usuario;
import academico.Curso;
import controle.ControleCurso;
import controle.ControleUsuario;

public class ControleCursoBD {
	
	
	
	
	public static void criarCursoBD(Usuario usuario, Curso curso){
		String sql = "insert into curso (pessoa_login,cursonome,cursolocal,cursodescricao)values ('"
			+ usuario.getLogin()
			+ "','"
			+ curso.getNome()
			+ "','"
			+ curso.getLocal()
			+ "','"
			+ curso.getDescricao()+"')";
	acessoBanco.AdicionarComandoNoBanco(sql);
	}
	
	public static void removerCurso(Usuario usuario, String id){
		String sql =  "delete from curso where idcurso ='"+ id +"'";
		
		acessoBanco.AdicionarComandoNoBanco(sql);
	}
	
	public static void alterarCurso(Usuario usuario, Curso curso){
		String sql = "update curso set cursonome = '" + curso.getNome()
		+ "',cursolocal = '" + curso.getLocal()
		+ "',cursodescricao = '" + curso.getDescricao()
		+ "' where idcurso = '" + curso.getId_curso()
		+ "'";
		
		acessoBanco.AdicionarComandoNoBanco(sql);
	}
	
	public static Curso obterCurso(Usuario usuario, String id) throws SQLException{
		String sql = "Select * from curso where pessoa_login = '" + ControleUsuario.getUsuarioAtual().getLogin() + "' and idcurso = '" + id + "'";
		ResultSet resultSet = acessoBanco.ListarBanco(sql);
		
		while(resultSet.next()){
			
			Curso curso = ControleCurso.criarCurso(resultSet.getObject(5).toString(), resultSet.getObject(4).toString(), resultSet.getObject(3).toString());
			curso.setId_curso(resultSet.getObject(1).toString());
			return curso;
		}
		
		return null;
	}
	
	
}
