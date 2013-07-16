package academico;

import java.sql.SQLException;
import java.text.ParseException;

import controle.ControleCurso;
import controle.ControleUsuario;
import database.ControleAvaliacaoBD;


public class Disciplina {
 
	private String nome;
	 
	private String horario;
	 
	private String sala;
	
	private String professor;
	
	private String idDisciplina;
	 
	private Curso curso;
	
	public Disciplina(String nome, String horario){
		this.nome = nome;
		this.horario = horario;
		this.curso = ControleCurso.getCursoAtual();
	}
	 
	
	public void addAvaliacao(Avaliacao avaliacao){
		ControleAvaliacaoBD.criarAvaliacaoBD(ControleUsuario.getUsuarioAtual(), curso, this, avaliacao);
	}
	
	public void removerAvaliacao(String nome){
		ControleAvaliacaoBD.removerAvaliacaoBD(ControleUsuario.getUsuarioAtual(), curso, this, nome);
	}
	
	public void alterarAvaliacao(Avaliacao avaliacao){
		ControleAvaliacaoBD.alterarAvaliacaiBD(ControleUsuario.getUsuarioAtual(), curso, this, avaliacao);
	}
	
	public Avaliacao obterAvaliacao(String nome) throws ParseException, SQLException{
		return ControleAvaliacaoBD.obterAvaliacao(ControleUsuario.getUsuarioAtual(), curso, this, nome);
	}
	
	public String getNome() {
		return nome;
	}

	public String getHorario() {
		return horario;
	}

	public String getSala() {
		return sala;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public void setSala(String sala) {
		this.sala = sala;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public void setIdDisciplina(String idDisciplina) {
		this.idDisciplina = idDisciplina;
	}

	public String getIdDisciplina() {
		return idDisciplina;
	}

	public void setProfessor(String professor) {
		this.professor = professor;
	}

	public String getProfessor() {
		return professor;
	}
	
	
	 
}
 
