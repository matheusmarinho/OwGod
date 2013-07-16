package academico;

import java.util.Calendar;


public class Avaliacao {
 
	private String tipo;
	 
	private Calendar dataRealizacao;
	 
	private String descricao;
	
	private String id_Disciplina;
	
	private String usuario_login;
	
	private String idAvaliacao;
	
	private String hora;
	
	private Double nota;
	 
	private Disciplina disciplina;
	 
	
	public Avaliacao(String tipo, Calendar dataRealizacao, String hora) {
		this.tipo = tipo;
		this.dataRealizacao = dataRealizacao;
		this.hora = hora;
		this.nota = 0.0;
	}

	public void inserirNota() {
	 
	}

	public String getTipo() {
		return tipo;
	}

	public Calendar getDataRealizacao() {
		return dataRealizacao;
	}

	public String getDescricao() {
		return descricao;
	}

	public Double getNota() {
		return nota;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setDataRealizacao(Calendar dataRealizacao) {
		this.dataRealizacao = dataRealizacao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setNota(Double nota) {
		this.nota = nota;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public void setId_Disciplina(String id_Disciplina) {
		this.id_Disciplina = id_Disciplina;
	}

	public String getId_Disciplina() {
		return id_Disciplina;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getHora() {
		return hora;
	}

	public void setIdAvaliacao(String idAvaliacao) {
		this.idAvaliacao = idAvaliacao;
	}

	public String getIdAvaliacao() {
		return idAvaliacao;
	}

	public void setUsuario_login(String usuario_login) {
		this.usuario_login = usuario_login;
	}

	public String getUsuario_login() {
		return usuario_login;
	}


}
 
