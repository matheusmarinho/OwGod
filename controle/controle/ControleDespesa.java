package controle;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import financeiro.Despesa;

public class ControleDespesa {

	public static Despesa criarDespesa(String nome, String valor,
			String descricao, String tipo, String dataVencimento,
			String dataPagamento, boolean status) throws ParseException {

		SimpleDateFormat formata = new SimpleDateFormat("dd/MM/yyyy");  
		Calendar dateVencimento = Calendar.getInstance();
		Calendar datePagamento = Calendar.getInstance();
		
		dateVencimento.setTime(formata.parse(dataVencimento));
		datePagamento.setTime(formata.parse(dataPagamento));		
		
		Double d_valor = Double.parseDouble(valor);

		Despesa despesa = new Despesa(nome, d_valor);
		despesa.setDescricao(descricao);
		despesa.setTipo(tipo);
		despesa.setDataVencimento(dateVencimento);
		despesa.setDataPagamento(datePagamento);
		despesa.setStatus(status);

		return despesa;
	}
	public static void addDespesa(String nome, String valor,
			String descricao, String tipo, String dataVencimento,
			String dataPagamento, boolean status) throws ParseException{
		
		ControleUsuario.getUsuarioAtual().getContabilidade()
		.addDespesa(criarDespesa(nome, valor, descricao, tipo, dataVencimento, dataPagamento, status));
	}

	public static void removerDespesa(String nome) {
		ControleUsuario.getUsuarioAtual().getContabilidade()
				.removerDespesa(nome);
	}

	public static void alterarDespesa(Despesa despesa, String nome,
			String valor, String descricao, String tipo, String dataVencimento,
			String dataPagamento, boolean status) throws ParseException {
		
		SimpleDateFormat formata = new SimpleDateFormat("dd/MM/yyyy");  
		Calendar dateVencimento = Calendar.getInstance();
		Calendar datePagamento = Calendar.getInstance();
		
		dateVencimento.setTime(formata.parse(dataVencimento));
		datePagamento.setTime(formata.parse(dataPagamento));		

		Double d_valor = Double.parseDouble(valor);
		
		despesa.setNome(nome);
		despesa.setValor(d_valor);
		despesa.setDescricao(descricao);
		despesa.setTipo(tipo);
		despesa.setDataVencimento(dateVencimento);
		despesa.setDataPagamento(datePagamento);
		despesa.setStatus(status);
		
		ControleUsuario.getUsuarioAtual().getContabilidade().alterarDespesa(despesa);
	}
	
	public static Despesa obterDespesa(String id) throws ParseException, SQLException{
		return ControleUsuario.getUsuarioAtual().getContabilidade().obterDespesa(id);
	}
	
	public static ArrayList<Despesa> notificarDespesa(String hoje) throws ParseException, SQLException{
		SimpleDateFormat formata = new SimpleDateFormat("dd/MM/yyyy");  
		Calendar dataHoje = Calendar.getInstance();
		dataHoje.setTime(formata.parse(hoje));
		
		return ControleUsuario.getUsuarioAtual().getContabilidade().notificarVencimentos(dataHoje);
	}

}
