package database;

import java.sql.ResultSet;
import java.sql.SQLException;

import pessoal.Usuario;
import academico.Curso;
import academico.Disciplina;
import controle.ControleDisciplina;

public class ControleDisciplinaBD {
	
	
	
	
	public static void criarDisciplinaBD(Curso curso, Disciplina disciplina){
		String sql = "insert into disciplina (curso_idcurso,sala,nome,horario,professor)values ('"
			+ curso.getId_curso()
			+ "','"
			+ disciplina.getSala()
			+ "','"
			+ disciplina.getNome()
			+ "','"
			+ disciplina.getHorario()
			+ "','"
			+ disciplina.getProfessor()+"')";
	acessoBanco.AdicionarComandoNoBanco(sql);
	}
	
	public static void removerDisciplinaBD(Usuario usuario, Curso curso, String id){
		String sql =  "delete from disciplina where iddisciplina ='"+ id +"'";
		
		acessoBanco.AdicionarComandoNoBanco(sql);
	}
	
	public static void alterarDisciplinaBD(Usuario usuario, Curso curso, Disciplina disciplina){
		String sql = "update disciplina set nome = '" + disciplina.getNome()
		+ "',sala = '" + disciplina.getSala()
		+ "',horario = '" + disciplina.getHorario()
		+ "',professor = '" + disciplina.getProfessor()
		+ "' where iddisciplina = '" + disciplina.getIdDisciplina()
		+ "'";
		
		acessoBanco.AdicionarComandoNoBanco(sql);
	}
	
	public static Disciplina obterDisciplinaBD(Usuario usuario, Curso curso, String id) throws SQLException{
		String sql = "Select * from disciplina where curso_idcurso = '" + curso.getId_curso() + "' and iddisciplina = '" + id + "'";
		ResultSet resultSet = acessoBanco.ListarBanco(sql);
		
		
		while(resultSet.next()){
			Disciplina disciplina = ControleDisciplina.criarDisciplina(resultSet.getObject(4).toString(), resultSet.getObject(5).toString(), resultSet.getObject(3).toString(), resultSet.getObject(6).toString());
			disciplina.setIdDisciplina(resultSet.getObject(1).toString());
			return disciplina;
		}
		
		return null;
	}
}
