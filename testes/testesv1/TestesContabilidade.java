package testesv1;

import java.sql.SQLException;
import java.text.ParseException;

import controle.ControleDespesa;
import controle.ControleReceita;


public class TestesContabilidade {
	
	
	public static void criarReceita() throws ParseException{
		ControleReceita.addReceita("Mesada", "500.0", "descricao", "19/09/2012", "1");
	}
	
	public static void removerReceita(){
		ControleReceita.removerReceita("1");
	}
	
	public static void obterReceita() throws SQLException, ParseException{
		System.out.println(ControleReceita.obterReceita("1").getNome());
	}
	
	public static void alterarReceita() throws ParseException, SQLException{
		ControleReceita.alterarReceita(ControleReceita.obterReceita("1"), "mesada up", "500.1", "update", "2", "19/09/2012");
	}
	
	
	public static void criarDespesa() throws ParseException{
		ControleDespesa.addDespesa("conta de luz", "50.0", "descricao", "1", "01/10/2012", "00/00/0000", false);
	}
	
	public static void removerDespesa(){
		ControleDespesa.removerDespesa("1");
	}
	
	public static void obterDespesa() throws ParseException, SQLException{
		System.out.println(ControleDespesa.obterDespesa("1").getNome());
	}
	
	public static void alterarDespesa() throws ParseException, SQLException{
		ControleDespesa.alterarDespesa(ControleDespesa.obterDespesa("1"), "conta de agua", "50.0", "descricao", "1", "30/09/2012", "00/00/0000", true);
	}
	
	public static void notificarDespesas() throws ParseException, SQLException{
		System.out.println(ControleDespesa.notificarDespesa("01/10/2012").size());
	}
	
}
