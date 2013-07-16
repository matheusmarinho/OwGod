package financeiro;

import java.util.Calendar;


public class Receita extends Custo {
 
	private Calendar dataEntrada;
	 
	private Contabilidade contabilidade;

	public Receita(String nome, Double valor, Calendar dateEntrada) {
		super(nome, valor);
		this.dataEntrada = dateEntrada;
	}
	

	public Calendar getDataEntrada() {
		return dataEntrada;
	}

	public Contabilidade getContabilidade() {
		return contabilidade;
	}

	public void setDataEntrada(Calendar dataEntrada) {
		this.dataEntrada = dataEntrada;
	}


	public void setContabilidade(Contabilidade contabilidade) {
		this.contabilidade = contabilidade;
	}
	
	
	
}
 
