package database;



import java.sql.*;
/** 
 * 
 * @author Matheus
 */  
public class acessoBanco {

	static String JBDC_DRIVER = "org.postgresql.Driver";
	static String DATABASE_URL = "jdbc:postgresql://localhost:5432/projeto";
	static String usuario = "postgres";
	static String senha = "postgres";  
	int cont=0;
	
	public acessoBanco(){
		//this.usuario = "postgres";
		//this.senha = "postgres";
	}
	
	public void setSenha(String sSenha) {
		senha = sSenha;
	}
	public String getSenha() {
		return senha;
	}
	public void setUsuario(String sUsuario) {
		usuario = sUsuario;
	}
	public String getUsuario() {
		return usuario;
	}
	
	@SuppressWarnings("unused")
	public boolean achaValores(String sql, String codigo) {
		try {
			Class.forName("org.postgresql.Driver").newInstance();
		} catch (Exception e) {
			System.out.println("Driver não carregado!");
		}

		Connection connection = null;
		Statement statement = null;

		try {
			Class.forName(JBDC_DRIVER);
			usuario = getUsuario();
			senha   = getSenha();
			connection = DriverManager.getConnection(DATABASE_URL, usuario,senha);
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);

			ResultSetMetaData data = resultSet.getMetaData();
			int numeroDeColunas = data.getColumnCount();
			for (int i = 1; i <= numeroDeColunas; i++) {
				
				System.out.printf("", data.getColumnName(i));
			}
			while (resultSet.next()) {
				
				for (int i = 1; i <= numeroDeColunas; i++) {
					String consulta = resultSet.getObject(i).toString();
					return consulta != null;
				}
			}
		} catch (SQLException s) {
			System.out.println("sql:" + s);
		} catch (ClassNotFoundException e) {
			System.out.println("classe not found: " + e);
		}
	return false;
	}

	public static void AdicionarComandoNoBanco(String sql) {

		try {
			Class.forName("org.postgresql.Driver").newInstance();
		} catch (Exception e) {
			System.out.println("Driver não carregado!");
		}

		Connection connection = null;
		Statement statement = null;

		try {
			Class.forName(JBDC_DRIVER);
			connection = DriverManager.getConnection(DATABASE_URL, usuario,
					senha);
			statement = connection.createStatement();
			statement.executeUpdate(sql);

		} catch (SQLException s) {
			System.out.println("sql:" + s);
		} catch (ClassNotFoundException e) {
			System.out.println("classe not found: " + e);
		}
	}

	public static ResultSet ListarBanco(String sql) {

		try {
			Class.forName("org.postgresql.Driver").newInstance();
		} catch (Exception e) {
			System.out.println("Driver não carregado!");
		}

		Connection connection = null;
		Statement statement = null;

		try {
			Class.forName(JBDC_DRIVER);
			connection = DriverManager.getConnection(DATABASE_URL, usuario,senha);
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);

			return resultSet;
			
		} catch (SQLException s) {
			System.out.println("sql:" + s);
			return null;
		} catch (ClassNotFoundException e) {
			System.out.println("classe not found: " + e);
			return null;
		}

	}
}