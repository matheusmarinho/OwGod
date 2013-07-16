package financeiro;

import java.util.Calendar;


public class Despesa extends Custo {
 
	public Despesa(String nome, Double valor) {
		super(nome, valor);
		
	}
	
	
	private Calendar dataVencimento;
	 
	private Calendar dataPagamento;
	
	private boolean status;
	 
	private Contabilidade contabilidade;

	public Calendar getDataVencimento() {
		return dataVencimento;
	}

	public Calendar getDataPagamento() {
		return dataPagamento;
	}

	public boolean getStatus() {
		return status;
	}

	public Contabilidade getContabilidade() {
		return contabilidade;
	}

	public void setDataVencimento(Calendar dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public void setDataPagamento(Calendar dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public void setContabilidade(Contabilidade contabilidade) {
		this.contabilidade = contabilidade;
	}

		 
	
	
}
 
