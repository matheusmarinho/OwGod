package testesv1;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import academico.Curso;
import academico.Disciplina;
import controle.ControleAvaliacao;
import controle.ControleCurso;
import controle.ControleDisciplina;
import controle.ControleUsuario;

public class TestesAcademico {
	
	
	public static ArrayList<Curso> cursos = new ArrayList<Curso>();
	public static ArrayList<Disciplina> disciplinas = new ArrayList<Disciplina>();
	
	public static void criarCursos(){
		ControleCurso.addCurso(ControleUsuario.getUsuarioAtual(), "Eng. SW", "sclerol", "UNIPAMPA");
		ControleCurso.addCurso(ControleUsuario.getUsuarioAtual(), "CNH", "sclerol", "CFC-Alegrete");
	}
	
	public static void atualizarCurso() throws SQLException{
		ControleCurso.atualizarCurso(ControleCurso.obterCurso("1"));
	}
	
	public static void criarDisciplinas() throws SQLException{
		
		ControleDisciplina.addDisciplina("RPIII", "18:30", "lab 3", "Welfer / Sam");
		ControleDisciplina.addDisciplina("aulas teoricas", "tarde", "sala 2", "professor");
	}
	
	public static void atualizarDisciplina() throws SQLException{
		
		ControleDisciplina.atualizarDisciplina(ControleDisciplina.obterDisciplina("3"));
	}
	
	public static void criarAvaliacao() throws SQLException, ParseException{
		//System.out.println(ControleDisciplina.obterDisciplina("RPIII").getNome());
		
		
		ControleAvaliacao.addAvaliacao("prova", "10/09/2012", "prova do capeta", "0.0", "18:30", "miguel");
		
	}
	
	public static void alterarCurso() throws SQLException{
		ControleCurso.alterarCurso(ControleCurso.obterCurso("1"), "Eng. Software", "nova desc", "unipampa");
	}
	
	public static void alterarDisciplina() throws SQLException{
		ControleDisciplina.alterarDisciplina(ControleDisciplina.obterDisciplina("1"), "RP3", "00:00", "Lab3", "prof de RP");
	}
	
	public static void alterarAvaliacao() throws ParseException, SQLException{
		ControleAvaliacao.alterarDisciplina(ControleAvaliacao.obterAvaliacao("2"), "trabalho", "21/09/2012", "trabalho", "10");
	}
	
	public static void removerCurso(){
		ControleCurso.removerCurso("2");
	}
	
	public static void removerDisciplina() throws SQLException{
		ControleDisciplina.removerDisciplina("1");
	}
	
	public static void removerAaliacao() throws SQLException{
		ControleAvaliacao.removerAvaliacao("1");
	}
	
	public static void notificarAvaliacao() throws ParseException, SQLException{
		System.out.println(ControleAvaliacao.notificarAvaliacao("10/09/2012").size());
	}
	
	public static void print() throws SQLException, ParseException{
		System.out.println();
		System.out.println("---------testes cursos-----------");
		System.out.println(ControleCurso.obterCurso("13").getNome());
		System.out.println("----------testes disciplinas------------");
		System.out.println(ControleDisciplina.obterDisciplina("23").getNome());
		System.out.println("--------------testes avaliacao--------------");
		System.out.println(ControleAvaliacao.obterAvaliacao("4").getDescricao());
		
		
		System.out.println();
	}
}
