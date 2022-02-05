import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class PlayerController {

	private Connection connection;
	Scanner sc;
	
	public PlayerController(Connection c) {
		this.connection = c;
		this.sc = new Scanner(System.in);
	}

	public void createPlayer() throws SQLException {
		try{
			System.out.println("----------------------");
			System.out.println("Crea jugador");
			System.out.println("----------------------");

			System.out.println("FLC - Federation license code:");
			String flc = sc.nextLine();

			System.out.println("First name:");
			String firstName = sc.nextLine();

			System.out.println("Last name:");
			String lastName = sc.nextLine();


			System.out.println("Birth date (YYYY-MM-DD):");
			String birthdate = sc.nextLine();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date bDate = format.parse(birthdate);


			System.out.println("Gender:");
			String gender = sc.nextLine();

			System.out.println("Height:");
			String height = sc.nextLine();

			System.out.println("Team name:");
			String teamName = sc.nextLine();

			System.out.println("MVP total:");
			String mvpTotal = sc.nextLine();

			String sql = "INSERT INTO player " +
					"(federation_license_code, first_name, last_name, " +
					"birth_date, gender, height," +
					"team_name, mvp_total) VALUES (?,?,?,?,?,?,?,?)";

			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1,flc);
			pst.setString(2,firstName);
			pst.setString(3,lastName);
			pst.setDate(4, new java.sql.Date(bDate.getTime()));
			pst.setString(5,gender);
			pst.setInt(6,Integer.parseInt(height));
			pst.setString(7,teamName);
			pst.setInt(8,Integer.parseInt(mvpTotal));

			pst.executeUpdate();

			pst.close();

		}catch (ParseException e){
			e.printStackTrace();
		}
	}
}
