package controle;

import java.sql.SQLException;

import pessoal.Usuario;
import academico.Curso;

public class ControleCurso {
	
private static Curso cursoAtual;
	
	public static void atualizarCurso(Curso curso){
		cursoAtual = curso;
	}
	
	public static Curso criarCurso(String nome, String descricao, String local){
		Curso curso = new Curso(nome, local);
		curso.setDescricao(descricao);
		
		return curso;
	}
	
	public static void addCurso(Usuario usuario, String nome, String descricao, String local){
		usuario.getAcademico().addCurso(criarCurso(nome, descricao, local));
	}
	
	public static void removerCurso(String nome){
		ControleUsuario.getUsuarioAtual().getAcademico().removerCurso(nome);
	}
	
	public static void alterarCurso(Curso curso, String nome, String descricao, String local){
		curso.setNome(nome);
		curso.setDescricao(descricao);
		curso.setLocal(local);
		
		ControleUsuario.getUsuarioAtual().getAcademico().alterarCurso(curso);		
	}
	
	public static Curso obterCurso(String id) throws SQLException{
		return ControleUsuario.getUsuarioAtual().getAcademico().obterCurso(id);
	}
	public static Curso getCursoAtual() {
		return cursoAtual;
	}
	
	
}
