


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class sqlite {


		final String db_protocol = "jdbc:sqlite:/Users/Murdix/Dropbox/BD - centro terapia/Entrega3/SQLite/db_complete.sqlite";
		
		Connection conn = null;
		
		public sqlite() {
			try{
				Class.forName("org.sqlite.JDBC");
				conn = DriverManager.getConnection(db_protocol);
			} catch (SQLException e){
				System.out.println(e.getMessage());
				e.printStackTrace();
			} catch (ClassNotFoundException e){
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
		
		public Connection getConnection(){
				return conn;
		}
		
		public void desconectar(){
			conn = null;
		}
		
		public ResultSet getData(String strSQL){
			Statement s = null;
			try {
				s = getConnection().createStatement();
			} catch(SQLException se){
				System.out.println("Error creating the statement, probably we're no longer connected.");
				se.printStackTrace();
				System.exit(1);
			}
			ResultSet rs = null;
			try {
				rs = s.executeQuery(strSQL);
			} catch (SQLException se){
				System.out.println("SQL invalid");
				se.printStackTrace();
				System.exit(1);
			}
			return rs;
		}
		
		
	}
