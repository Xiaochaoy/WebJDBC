import java.io.IOException;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class MatchController {
    private Connection connection;
    Scanner sc;

    public MatchController(Connection connection) {
        this.connection = connection;
        this.sc = new Scanner(System.in);
    }

    public void createMatch() throws SQLException {
        try {
            System.out.println("----------------------");
            System.out.println("Crea Match");
            System.out.println("----------------------");

            System.out.println("Home Team:");
            String homeTeam = sc.nextLine();

            System.out.println("Visitor Team:");
            String visitorTeam = sc.nextLine();

            System.out.println("Match date (YYYY-MM-DD):");
            String matchdate = sc.nextLine();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date bDate = format.parse(matchdate);

            System.out.println("Attendance:");
            String attendance = sc.nextLine();

            System.out.println("MVP Player:");
            String mvpPlayer = sc.nextLine();

            String sql = "INSERT INTO match " +
                    "(home_team, visitor_team, match_date, attendance, mvp_player) VALUES (?,?,?,?,?)";

            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, homeTeam);
            pst.setString(2, visitorTeam);
            pst.setDate(3, new java.sql.Date(bDate.getTime()));
            pst.setInt(4, Integer.parseInt(attendance));
            pst.setString(5, mvpPlayer);

            pst.executeUpdate();

            pst.close();

        }catch (ParseException e){
            e.printStackTrace();
        }
    }
}
