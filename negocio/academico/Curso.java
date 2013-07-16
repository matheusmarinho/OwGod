package academico;

import java.sql.SQLException;

import controle.ControleUsuario;
import database.ControleDisciplinaBD;

public class Curso {
 
	private String nome;
	private String id_curso;
	private String descricao;
	private String local;
	private Academico academico;
	 
	public Academico getAcademico() {
		return academico;
	}

	public void setAcademico(Academico academico) {
		this.academico = academico;
	}

	public Curso(String nome, String local) {
		this.nome = nome;
		this.local = local;
		this.academico = ControleUsuario.getUsuarioAtual().getAcademico();
	}

	public boolean addDisciplina(Disciplina disciplina) {
		ControleDisciplinaBD.criarDisciplinaBD(this, disciplina);
		return true;
	}
	 
	public boolean removerDisciplina(String nome) {
		ControleDisciplinaBD.removerDisciplinaBD(this.academico.getUsuario(), this, nome);
		return true;
	}
	 
	public void alterarDisciplina(Disciplina disciplina) {
		ControleDisciplinaBD.alterarDisciplinaBD(this.academico.getUsuario(), this, disciplina);
	}
	 
	public Disciplina obterDisciplina(String id) throws SQLException {
		return ControleDisciplinaBD.obterDisciplinaBD(ControleUsuario.getUsuarioAtual(), this, id);
	}

	
	
	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getLocal() {
		return local;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public void setId_curso(String id_curso) {
		this.id_curso = id_curso;
	}

	public String getId_curso() {
		return id_curso;
	}

	
	
	
	 
}
 
