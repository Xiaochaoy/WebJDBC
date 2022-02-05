import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class RolController {
    private Connection connection;
    Scanner sc;

    public RolController(java.sql.Connection connection) {
        this.connection = connection;
        this.sc = new Scanner(System.in);
    }

    public void createCampeon() {
        try {
            System.out.println("----------------------");
            System.out.println("Crear Campeon");
            System.out.println("----------------------");

            System.out.println("Nombre:");
            String nom = sc.nextLine();

            System.out.println("Rol");
            String rol = sc.nextLine();
            //falta un menu de rols.

            System.out.println("Historia:");
            String historia = sc.nextLine();

            String sql = "INSERT INTO campeon " +
                    "(nom, rol, historia) VALUES (?,?,?)";

            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, nom);
            pst.setString(2, rol);
            pst.setString(3, historia);

            pst.executeUpdate();

            pst.close();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
