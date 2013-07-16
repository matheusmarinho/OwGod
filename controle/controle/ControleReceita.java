package controle;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import financeiro.Receita;

public class ControleReceita {

	public static Receita criarReceita(String nome, String valor,
			String descricao, String dataEntrada, String tipo) throws ParseException {
		
		SimpleDateFormat formata = new SimpleDateFormat("dd/MM/yyyy");  
		Calendar dateEntrada = Calendar.getInstance();
		
		dateEntrada.setTime(formata.parse(dataEntrada));
		
		Double d_valor = Double.parseDouble(valor);

		Receita receita = new Receita(nome, d_valor, dateEntrada);
		receita.setDescricao(descricao);
		receita.setTipo(tipo);

		return receita;
	}
	
	public static void addReceita(String nome, String valor, String descricao, String dataEntrada, String tipo) throws ParseException{
		ControleUsuario.getUsuarioAtual().getContabilidade().addReceita(criarReceita(nome, valor, descricao, dataEntrada, tipo));
	}

	public static void removerReceita(String nome) {
		ControleUsuario.getUsuarioAtual().getContabilidade()
				.removerReceita(nome);
	}

	public static void alterarReceita(Receita receita, String nome,
			String valor, String descricao, String tipo, String dataEntrada) throws ParseException {
		
		SimpleDateFormat formata = new SimpleDateFormat("dd/MM/yyyy");  
		Calendar dateEntrada = Calendar.getInstance();
		
		dateEntrada.setTime(formata.parse(dataEntrada));
		
		Double d_valor = Double.parseDouble(valor);
		
		receita.setNome(nome);
		receita.setValor(d_valor);
		receita.setDescricao(descricao);
		receita.setTipo(tipo);
		receita.setDataEntrada(dateEntrada);
		
		ControleUsuario.getUsuarioAtual().getContabilidade().alterarReceita(receita);
	}
	
	public static Receita obterReceita(String id) throws SQLException, ParseException{
		return ControleUsuario.getUsuarioAtual().getContabilidade().obterReceita(id);
	}

}
