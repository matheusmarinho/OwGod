package agenda;

import java.util.Calendar;


public class Compromisso {
 
	private String nome;
	 
	private Calendar dataRealizacao;
	 
	private String descricao;
	
	private String id_compromisso;
	 
	private Agenda agenda;

	public Compromisso(String nome, Calendar dataRealizacao, String descricao, Agenda agenda) {
		this.nome = nome;
		this.dataRealizacao = dataRealizacao;
		this.descricao = descricao;
		this.agenda = agenda;
	}

	public String getNome() {
		return nome;
	}

	public Calendar getDataRealizacao() {
		return dataRealizacao;
	}

	public String getDescricao() {
		return descricao;
	}

	public Agenda getAgenda() {
		return agenda;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setDataRealizacao(Calendar dataRealizacao) {
		this.dataRealizacao = dataRealizacao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}

	public void setId_compromisso(String id_compromisso) {
		this.id_compromisso = id_compromisso;
	}

	public String getId_compromisso() {
		return id_compromisso;
	}
	
	
	
	 
}
 
