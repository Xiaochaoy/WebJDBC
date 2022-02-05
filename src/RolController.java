import java.io.*;
import java.sql.*;
import java.util.Locale;
import java.util.Scanner;

public class RolController {
    private Connection connection;
    Scanner sc;
    Menu menu = new Menu();

    public RolController(Connection connection) {
        this.connection = connection;
        this.sc = new Scanner(System.in);
    }

    public void createRol() {
        try {
            System.out.println("----------------------");
            System.out.println("Crear Rol");
            System.out.println("----------------------");

            System.out.println("Rol:");
            String rol = sc.nextLine().toUpperCase(Locale.ROOT);

            String sql = "INSERT INTO rol " +
                    "(rol) VALUES (?)";

            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, rol);

            pst.executeUpdate();

            pst.close();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void showRols(){
        System.out.println("\n" + "Roles: ");

        ResultSet rs = null;
        String sql = "SELECT * FROM rol";
        try{
            Statement st = connection.createStatement();

            rs = st.executeQuery(sql);

            while (rs.next()) {
                System.out.println("- " + rs.getString("rol"));
            }

            rs.close();
            st.close();

        }catch (SQLException e){
            System.out.println("Error: tabla rol no existe");
        }
    }
    public void borrarTabla() {
        try {
            Statement st = connection.createStatement();
            st.executeUpdate("DROP table rol");
            st.close();

        } catch (SQLException e) {
            System.out.println("Error: tabla rol no existe");
        }
    }
    public void crearTabla(){
        try {
            Statement st = connection.createStatement();
            st.executeUpdate("CREATE TABLE rol(rol varchar(20) primary key)");
            st.close();

        } catch (SQLException e) {
            System.out.println("Error: tabla rol ya existe");

        }
    }
    public void modificarRol(){
        try {
            Statement st = connection.createStatement();
            String rol = menu.RolMenu(connection).toUpperCase(Locale.ROOT);
            System.out.println("Escribe la primera letra del campeon que quieras modificar ?");
            String nom = sc.nextLine().toUpperCase(Locale.ROOT);

            st.executeUpdate("update campeon set rol='" + rol + "' where nom like '" + nom + "%'");
            st.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
