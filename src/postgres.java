

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class postgres {		
		final String db = "eira";
		final String login = "mcornejo";
		final String password = "mario.13";
		final String host = "redes.niclabs.cl";
		final String port = "5432";
		final String db_protocol = "jdbc:postgresql://";
		
		String url = db_protocol + host + ":" + port + "/" + db;
		Connection conn = null;
		
		public postgres() {
			try{
				Class.forName("org.postgresql.Driver");
				conn = DriverManager.getConnection(url,login,password);
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
		
		public void insertPersona(String run, String ap, String am, String nom, String ec, String email, String fec_nac, String tel, String dire){
			PreparedStatement s = null;
			try {
				String str = "insert into \"public\".\"Persona\" VALUES ('"+run+"','"+ap+"','"+am+"','"+nom+"','"+ec+"','"+email+"','"+fec_nac+"','"+tel+"','"+dire+"');";
				System.out.println(str);
				s = getConnection().prepareStatement(str);
			} catch(SQLException se){
				System.out.println("Error creating the statement, probably we're no longer connected.");
				se.printStackTrace();
				System.exit(1);
			}
			try {
				s.executeUpdate();
			} catch (SQLException se){
				System.out.println("SQL invalid");
				se.printStackTrace();
				System.exit(1);
			}
		}
		
		public void insertEmpleado(String run, String fec_cont, String Hor_ses, String Titulo, String Grad, String Desc){
			PreparedStatement s = null;
			try {
				String str = "insert into \"public\".\"Empleado\" VALUES ('"+run+"','"+fec_cont+"','"+Hor_ses+"','"+Titulo+"','"+Grad+"','"+Desc+"');";
				//System.out.println(str);
				s = getConnection().prepareStatement(str);
			} catch(SQLException se){
				System.out.println("Error creating the statement, probably we're no longer connected.");
				se.printStackTrace();
				System.exit(1);
			}
			try {
				s.executeUpdate();
			} catch (SQLException se){
				System.out.println("SQL invalid");
				se.printStackTrace();
				System.exit(1);
			}
		}
		
		public void insertPaciente(String run, String codigo, String ocupacion, String estudios, String tipo_ficha, String tipo_medica,String Nombre_empresa, String profesor, String apoderado, String terapeuta, String desc){
			PreparedStatement s = null;
			try {
				String str = "insert into \"public\".\"Paciente\" VALUES ('"+run+"','"+codigo+"','"+ocupacion+"','"+estudios+"','"+tipo_ficha+"','"+tipo_medica+"','"+Nombre_empresa+"','"+profesor+"','"+apoderado+"','"+terapeuta+"','"+desc+"');";
				//System.out.println(str);
				s = getConnection().prepareStatement(str);
			} catch(SQLException se){
				System.out.println("Error creating the statement, probably we're no longer connected.");
				se.printStackTrace();
				System.exit(1);
			}
			try {
				s.executeUpdate();
			} catch (SQLException se){
				System.out.println("SQL invalid");
				se.printStackTrace();
				System.exit(1);
			}
		}
		
		public void insertSesion(String codigo, String hora_ll, String hora_ent, String Hora_sa, String Esta, String Box_n, String Prec, String duracion, String Reem, String serv, String Boleta){
			PreparedStatement s = null;
			try {
				String str = "insert into \"public\".\"Sesion\" VALUES ('"+codigo+"','"+hora_ll+"','"+hora_ent+"','"+Hora_sa+"','"+Esta+"','"+Box_n+"','"+Prec+"','"+duracion+"','"+Reem+"','"+serv+"','"+Boleta+"');";
				//System.out.println(str);
				s = getConnection().prepareStatement(str);
			} catch(SQLException se){
				System.out.println("Error creating the statement, probably we're no longer connected.");
				se.printStackTrace();
				System.exit(1);
			}
			try {
				s.executeUpdate();
			} catch (SQLException se){
				System.out.println("SQL invalid");
				se.printStackTrace();
				System.exit(1);
			}
		}
		
		public void insertBoleta(String numero,String fecha, String monto, String path){
			PreparedStatement s = null;
			try {
				String str = "insert into \"public\".\"Boleta\" VALUES ('"+numero+"','"+fecha+"','"+monto+"','"+path+"');";
				//System.out.println(str);
				s = getConnection().prepareStatement(str);
			} catch(SQLException se){
				System.out.println("Error creating the statement, probably we're no longer connected.");
				se.printStackTrace();
				System.exit(1);
			}
			try {
				s.executeUpdate();
			} catch (SQLException se){
				System.out.println("SQL invalid");
				se.printStackTrace();
				System.exit(1);
			}
		}
		
		public void insertPacienteAsiste(String run, String id, String id2){
			PreparedStatement s = null;
			try {
				String str = "insert into \"public\".\"Paciente_Asiste\" VALUES ('"+run+"','"+id+"','"+id2+"');";
				//System.out.println(str);
				s = getConnection().prepareStatement(str);
			} catch(SQLException se){
				System.out.println("Error creating the statement, probably we're no longer connected.");
				se.printStackTrace();
				System.exit(1);
			}
			try {
				s.executeUpdate();
			} catch (SQLException se){
				System.out.println("SQL invalid");
				se.printStackTrace();
				System.exit(1);
			}
		}
		
		public void insertEmpleadoRealiza(String run, String cod){
			PreparedStatement s = null;
			try {
				String str = "insert into \"public\".\"Empleado_Realiza_Una\" VALUES ('"+run+"','"+cod+"');";
				//System.out.println(str);
				s = getConnection().prepareStatement(str);
			} catch(SQLException se){
				System.out.println("Error creating the statement, probably we're no longer connected.");
				se.printStackTrace();
				System.exit(1);
			}
			try {
				s.executeUpdate();
			} catch (SQLException se){
				System.out.println("SQL invalid");
				se.printStackTrace();
				System.exit(1);
			}
		}
		
		
		
	}
