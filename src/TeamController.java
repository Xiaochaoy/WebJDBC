
import java.io.IOException;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class TeamController {

	private Connection connection;
	Scanner sc;

	public TeamController(Connection connection) {
		this.connection = connection;
		this.sc = new Scanner(System.in);
	}

	public void showTeams() throws SQLException, IOException {

		Statement st = connection.createStatement();
		ResultSet rs;

		rs = st.executeQuery("SELECT * FROM team");
		while (rs.next()) {
			System.out.println("Name: " + rs.getString("name") + " " +
							   "Type: " + rs.getString("type") + " " +
							   "Country: " + rs.getString("country") + " " +
							   "City: " + rs.getString("city") + " " +
							   "Court name: " + rs.getString("court_name"));
		}

		rs.close();
		st.close();
	}

	public void createTeam() throws SQLException {
		System.out.println("----------------------");
		System.out.println("Crea Team");
		System.out.println("----------------------");


		System.out.println("Name:");
		String name = sc.nextLine();

		System.out.println("Type:");
		String type = sc.nextLine();

		System.out.println("Country:");
		String country = sc.nextLine();

		System.out.println("City:");
		String city = sc.nextLine();

		System.out.println("Court Name:");
		String courtName = sc.nextLine();

		String sql = "INSERT INTO team " +
				"(name, type, country, city, court_name) VALUES (?,?,?,?,?)";

		PreparedStatement pst = connection.prepareStatement(sql);
		pst.setString(1,name);
		pst.setString(2,type);
		pst.setString(3,country);
		pst.setString(4, city);
		pst.setString(5,courtName);

		pst.executeUpdate();

		pst.close();

	}
}
