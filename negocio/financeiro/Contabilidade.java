package financeiro;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;

import controle.ControleUsuario;
import database.ControleDespesaBD;
import database.ControleReceitaBD;


import pessoal.Usuario;

public class Contabilidade {
 
	private Usuario usuario;
	
	public Contabilidade(){
		this.usuario = ControleUsuario.getUsuarioAtual();
	}
	
	public void addReceita(Receita receita){
		ControleReceitaBD.criarReceitaBD(ControleUsuario.getUsuarioAtual(), receita);
	}
	
	public void removerReceita(String id){
		ControleReceitaBD.removerReceitaBD(id);
	}
	
	public void alterarReceita(Receita receita){
		ControleReceitaBD.alterarReceitaBD(ControleUsuario.getUsuarioAtual(), receita);
	}
	
	public Receita obterReceita(String id) throws SQLException, ParseException{
		return ControleReceitaBD.obterReceitaBD(ControleUsuario.getUsuarioAtual(), id);
	}
	
	public void addDespesa(Despesa despesa){
		ControleDespesaBD.addDespesaBD(ControleUsuario.getUsuarioAtual(), despesa);
	}
	
	public void removerDespesa(String id){
		ControleDespesaBD.removerDespesaBD(id);
	}
	
	public void alterarDespesa(Despesa despesa){
		ControleDespesaBD.alterarDespesaBD(ControleUsuario.getUsuarioAtual(), despesa);
	}
	
	public Despesa obterDespesa(String id) throws ParseException, SQLException{
		return ControleDespesaBD.obterDespesaBD(ControleUsuario.getUsuarioAtual(), id);
	}
	
	public void imprimirRelatorio() {
	 
	}
	 
	public void gerarRelatorio() {
	 
	}
	 
	public ArrayList<Despesa> notificarVencimentos(Calendar hoje) throws ParseException, SQLException {
		return ControleDespesaBD.notificarDespesas(hoje);
	}
	 
	public void calcularOrcamento() {
	 
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	 
}
 
