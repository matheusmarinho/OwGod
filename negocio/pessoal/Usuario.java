package pessoal;

import java.util.ArrayList;

import academico.Academico;
import agenda.Agenda;
import financeiro.Contabilidade;


/**
 * @author Mk
 *
 */
public class Usuario {
	
	
 
	private String nome;
	 
	private ArrayList<Informacao> informacoes;
	 
	private Contabilidade contabilidade;
	 
	private Agenda agenda;
	 
	private Registro registro;
	
	private Academico academico;
	
	private String senha;
	
	private String login;
	
	public Usuario(String nome, String login, String senha){
		this.nome = nome;
		this.senha = senha;
		this.login = login;
		this.informacoes = new ArrayList<Informacao>();
		this.agenda = new Agenda(this);
		this.academico = new Academico(this);
		this.contabilidade = new Contabilidade();
	}
	
	
	
	
	
	public String getNome() {
		return nome;
	}

	public ArrayList<Informacao> getInformacoes() {
		return informacoes;
	}

	public Contabilidade getContabilidade() {
		return contabilidade;
	}

	public Agenda getAgenda() {
		return agenda;
	}

	public Registro getRegistro() {
		return registro;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setInformacoes(ArrayList<Informacao> informacoes) {
		this.informacoes = informacoes;
	}

	public void setContabilidade(Contabilidade contabilidade) {
		this.contabilidade = contabilidade;
	}

	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}

	
	public void setRegistro(Registro registro) {
		this.registro = registro;
	}




	public void setFaculdade(Academico faculdade) {
		this.academico = faculdade;
	}





	public Academico getAcademico() {
		return academico;
	}





	public void setSenha(String senha) {
		this.senha = senha;
	}





	public String getSenha() {
		return senha;
	}





	public void setLogin(String login) {
		this.login = login;
	}





	public String getLogin() {
		return login;
	}
	
	
	 
}
 
