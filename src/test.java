import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;


public class test {


	public static void main(String[] argv){

		postgres con_postgres = new postgres();
		sqlite con_sqlite = new sqlite();
		
		
		String sql1 = "select * from fdff57ff;";
		ResultSet rs = con_sqlite.getData(sql1);

		String estado_civi[] = {"Soltero","Casado","Separado","Viudo"};
		String estudio[] = {"Superior", "Media", "Basica", "Posgrado"};
		String ficha[] = {"Individual","Pareja","Sicopedagoga", "Otro"};
		String reem[] = {"FONASA", "CRUZ BLANCA", "VIDA TRES", "COLMENA", "CONSALUD", "BANMEDICA", "MAS VIDA", "FERROSALUD"};
		String serv[] = {"MEDIACION", "SICOPEDAGOGIA", "SICOTERAPIA INDIVIDUAL", "SICOTERAPIA FAMILIAR", "SICOTERAPIA PAREJA"};
		String empl[] = {"8372858-3","11134016-2","9336533-4","15267074-3","8806776-3","11807175-5","21779118-6","3900554-8","13551682-8","19148113-0","18893040-2","19852026-4","23637686-8","12116621-4","8373052-5","10552839-0","21571282-7"};

		int i = 0;
		ResultSet rs1 = null;
		String run = null;
		String sql2 = null;
		int run_x = 0;
		try {
			while(rs.next()){
				
				
				do{
					int RUN_n = (new Random().nextInt(90000000-1000000)+1000000);
					int dv_n = (new Random().nextInt(9));
					run = RUN_n+"-"+ dv_n;

					sql2 = "select count(\"Persona\".\"RUN\") as count from \"public\".\"Persona\" where \"Persona\".\"RUN\" = '"+run+"';";
					rs1 = con_postgres.getData(sql2);
					rs1.next();
					run_x =rs1.getInt("count");
				}while(run_x > 0);

				
				
				String ap = (rs.getString("Surname")).replace('\'', ' ');
				String am = rs.getString("MothersMaiden").replace('\'', ' ');
				String nom = rs.getString("GivenName").replace('\'', ' ');
				String ec = estado_civi[(new Random().nextInt(4))];
				String email = rs.getString("EmailAddress");
				String fec_nac = rs.getString("Birthday");
				String tel = rs.getString("TelephoneNumber");
				String dire = rs.getString("StreetAddress");
				String id = rs.getString("Number");
				String ocupacion = rs.getString("Occupation").replace('\'', ' ');
				String empresa = rs.getString("Domain");
				String cm = rs.getString("Centimeters");
				String profesor = "";
				String apoderado = "";
				String terapeuta = "";
				String desc = "0";
				if(cm.contains("0")){
					profesor = am;
					apoderado = nom;
					terapeuta = am;
					desc = "1";
				}
				String dia = new Random().nextInt(28)+1+"";
				String mes = new Random().nextInt(12)+1+"";
				String hora_ll = "2011-"+mes+"-"+dia+" "+new Random().nextInt(13)+":"+new Random().nextInt(60);
				String Hora_sa = "2011-"+mes+"-"+dia+" "+new Random().nextInt(13)+":"+new Random().nextInt(60);
				String Hora_ent = "2011-"+mes+"-"+dia+" "+new Random().nextInt(13)+":"+new Random().nextInt(60);

				con_postgres.insertPersona(run, ap, am, nom, ec, email, fec_nac, tel, dire);
				con_postgres.insertPaciente(run, id, ocupacion, estudio[new Random().nextInt(4)], ficha[new Random().nextInt(4)], id, empresa, profesor, apoderado, terapeuta, desc);
				con_postgres.insertBoleta(id, "2011-"+mes+"-"+dia, "25000","/"+id+".jpg");
				con_postgres.insertSesion(id, hora_ll, Hora_ent, Hora_sa, "Realizado", new Random().nextInt(10)+1+"", "25000", "60", reem[new Random().nextInt(8)], serv[new Random().nextInt(5)], id);
				con_postgres.insertPacienteAsiste(run, id, id);
				con_postgres.insertEmpleadoRealiza(empl[new Random().nextInt(17)], id);
				System.out.println(i++);
			}
		} catch (SQLException se){
			System.out.println("Error trying get results");
			se.printStackTrace();
		}

		
		
		
		
		
	}
}
