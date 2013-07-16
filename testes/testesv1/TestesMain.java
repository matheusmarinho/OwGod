package testesv1;

import java.sql.SQLException;
import java.text.ParseException;

public class TestesMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//TestesCriarUsuario.criarUsuario();
		
		try {
		TestesCriarUsuario.logIn();
		TestesCriarUsuario.print();
		
		//TestesAgenda.criarCompromissos();
		
		//TestesAgenda.obterCompromissos();
		//TestesAgenda.alterarCompromissos();
		//TestesAgenda.removerCompromisso();
		//TestesAgenda.print();
		
		//TestesAcademico.criarCursos();
		//TestesAcademico.alterarCurso();
		TestesAcademico.atualizarCurso();
		//TestesAcademico.criarDisciplinas();
		//TestesAcademico.alterarDisciplina();		
		TestesAcademico.atualizarDisciplina();
		//TestesAcademico.criarAvaliacao();
		//TestesAcademico.alterarAvaliacao();
		//TestesAcademico.print();
		//TestesAcademico.notificarAvaliacao();
		//TestesAcademico.removerCurso();
		//TestesAcademico.removerDisciplina();
		
		
		
		//TestesContabilidade.criarReceita();
		//TestesContabilidade.obterReceita();
		//TestesContabilidade.alterarReceita();
		//TestesContabilidade.removerReceita();
		
		//TestesContabilidade.criarDespesa();
		//TestesContabilidade.obterDespesa();
		//TestesContabilidade.alterarDespesa();
		//TestesContabilidade.removerDespesa();
		//TestesContabilidade.notificarDespesas();
		
		
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//
		
		//TestesAcademico.print();
		
	}

}
