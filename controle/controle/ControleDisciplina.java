package controle;

import java.sql.SQLException;

import academico.Disciplina;

public class ControleDisciplina {
	
	private static Disciplina disciplinaAtual;
	
	public static void atualizarDisciplina(Disciplina disciplina){
		disciplinaAtual = disciplina;
	}
	
	
	public static Disciplina criarDisciplina(String nome, String horario, String sala, String professor) throws SQLException{
		Disciplina disciplina = new Disciplina(nome, horario);
		disciplina.setSala(sala);
		disciplina.setProfessor(professor);
		
		return disciplina;
	}
	
	public static void addDisciplina(String nome, String horario, String sala, String professor) throws SQLException{
		ControleUsuario.getUsuarioAtual().getAcademico().obterCurso(ControleCurso.getCursoAtual().getId_curso()).addDisciplina(criarDisciplina(nome, horario, sala, professor));
	}
	
	public static void removerDisciplina(String id) throws SQLException{
		ControleUsuario.getUsuarioAtual().getAcademico().obterCurso(ControleCurso.getCursoAtual().getId_curso()).removerDisciplina(id);
	}
	
	public static void alterarDisciplina( Disciplina disciplina, String nome, String horario, String sala, String professor) throws SQLException{
		disciplina.setNome(nome);
		disciplina.setHorario(horario);
		disciplina.setSala(sala);
		disciplina.setProfessor(professor);
		ControleUsuario.getUsuarioAtual().getAcademico().obterCurso(ControleCurso.getCursoAtual().getId_curso()).alterarDisciplina(disciplina);
	}
	
	public static Disciplina obterDisciplina(String id) throws SQLException{
		return ControleUsuario.getUsuarioAtual().getAcademico().obterCurso(ControleCurso.getCursoAtual().getId_curso()).obterDisciplina(id);
	}

	public static Disciplina getDisciplinaAtual() {
		return disciplinaAtual;
	}

	
	
}
