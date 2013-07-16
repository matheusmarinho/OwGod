package financeiro;



public abstract class Custo {
 
	private String nome;
	 
	private Double valor;
	 
	private String descricao;
	
	private String tipo;
	
	private String id;
	 
	private Contabilidade contabilidade;

	public Custo(String nome, Double valor) {
		this.nome = nome;
		this.valor = valor;
	}
	
	

	public String getNome() {
		return nome;
	}

	public Double getValor() {
		return valor;
	}

	public String getDescricao() {
		return descricao;
	}


	public Contabilidade getContabilidade() {
		return contabilidade;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setContabilidade(Contabilidade contabilidade) {
		this.contabilidade = contabilidade;
	}



	public void setTipo(String tipo) {
		this.tipo = tipo;
	}



	public String getTipo() {
		return tipo;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getId() {
		return id;
	}
	
	
	 
}
 
