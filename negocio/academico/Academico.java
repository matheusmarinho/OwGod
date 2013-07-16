package academico;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;

import pessoal.Usuario;
import controle.ControleUsuario;
import database.ControleAvaliacaoBD;
import database.ControleCursoBD;

public class Academico {
	
	private Usuario usuario;
	
	
	public Academico(Usuario usuario) {
		this.usuario = usuario;
		
	}
	
	public void addCurso(Curso curso){
		ControleCursoBD.criarCursoBD(this.usuario, curso);
	}
	
	public void removerCurso(String nome){
		ControleCursoBD.removerCurso(this.usuario, nome);
	}
	
	public void alterarCurso(Curso curso){
		ControleCursoBD.alterarCurso(this.usuario, curso);
	}
	
	public Curso obterCurso(String id) throws SQLException{
		return ControleCursoBD.obterCurso(this.usuario, id);
	}

	public ArrayList<Avaliacao> notificarAvaliacao(Calendar hoje) throws ParseException, SQLException{
		return ControleAvaliacaoBD.notificarAvaliacao(ControleUsuario.getUsuarioAtual(), hoje);
	}
	

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	

}
