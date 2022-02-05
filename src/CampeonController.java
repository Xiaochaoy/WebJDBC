import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;

public class CampeonController {
    private Connection connection;
    Scanner sc;
    Menu menu = new Menu();

    public CampeonController(Connection connection) {
        this.connection = connection;
        this.sc = new Scanner(System.in);
    }

    public void createCampeon() {
        try {
            System.out.println("----------------------");
            System.out.println("Crear Campeon");
            System.out.println("----------------------");

            System.out.println("Nombre:");
            String nom = sc.nextLine().toUpperCase(Locale.ROOT);

            System.out.println("Elige un rol:");
            String rol = menu.RolMenu(connection).toUpperCase(Locale.ROOT);
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
    public void borrarTabla() {
        try {
            Statement st = connection.createStatement();
            st.executeUpdate("DROP table campeon");
            st.close();

        } catch (SQLException e) {
            System.out.println("Error: tabla campeon no existe");
        }
    }
    public void crearTabla(){
        try {
            Statement st = connection.createStatement();
            st.executeUpdate("CREATE TABLE campeon(id smallint primary key GENERATED ALWAYS AS IDENTITY, nom varchar(20), rol varchar(20) references rol(rol), historia text)");
            st.close();

        } catch (SQLException e) {
            System.out.println("Error: tabla campeon ya existe");
        }
    }
    public void showCampeonPorRol(){
        ResultSet rs = null;
        String rol = menu.RolMenu(connection).toUpperCase(Locale.ROOT);
        String sql = "SELECT * FROM campeon where rol='" + rol + "'";

        try{
            Statement st = connection.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                System.out.println("\n" + "Nom: " + rs.getString("nom") + "\n" +
                        "Rol: " + rs.getString("rol") + "\n" +
                        "Historia: " + rs.getString("historia"));
            }

            rs.close();
            st.close();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void showCampeonCon(){
        ResultSet rs = null;
        System.out.println("Escribe el texto a contener: ");
        String letra = sc.nextLine().toUpperCase(Locale.ROOT);
        String sql = "select * from campeon where nom like '%" + letra + "%'";

        try{
            Statement st = connection.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                System.out.println("\n" + "Nom: " + rs.getString("nom") + "\n" +
                        "Rol: " + rs.getString("rol") + "\n" +
                        "Historia: " + rs.getString("historia") + "\n");
            }

            rs.close();
            st.close();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void showCampeonPor(){
        ResultSet rs = null;
        System.out.println("Escribe el texto de inicio: ");
        String letra = sc.nextLine().toUpperCase(Locale.ROOT);
        String sql = "select * from campeon where nom like '" + letra + "%'";

        try{
            Statement st = connection.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                System.out.println("\n" + "Nom: " + rs.getString("nom") + "\n" +
                        "Rol: " + rs.getString("rol") + "\n" +
                        "Historia: " + rs.getString("historia"));
            }


            rs.close();
            st.close();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void showCampeonNom(){
        ResultSet rs = null;
        String sql = "SELECT nom FROM campeon";
        try{
            Statement st = connection.createStatement();

            rs = st.executeQuery(sql);

            while (rs.next()) {
                System.out.println("- " + rs.getString("nom"));
            }


            rs.close();
            st.close();

        }catch (SQLException e){
            e.printStackTrace();
        }
        System.out.println("Elige el campeon: ");
    }
    public void showCampeones(){
        System.out.println("\n" + "Campeones: ");
        ResultSet rs = null;
        String sql = "SELECT * FROM campeon";
        try{
            Statement st = connection.createStatement();

            rs = st.executeQuery(sql);

            while (rs.next()) {
                System.out.println("Nom: " + rs.getString("nom") + "\n" +
                        "Rol: " + rs.getString("rol") + "\n" +
                        "Historia: " + rs.getString("historia") + "\n");
            }

            rs.close();
            st.close();

        }catch (SQLException e){
            System.out.println("Error: tabla campeon no existe");
        }
    }
    public void modificarCampeon(){
        try {
            Statement st = connection.createStatement();
            String nom = menu.NomMenu(connection).toUpperCase(Locale.ROOT);
            System.out.println("Escribe el nuevo nombre: ");
            String newNom = sc.nextLine().toUpperCase(Locale.ROOT);

            st.executeUpdate("update campeon set nom='" + newNom + "' where nom='" + nom + "'");
            st.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void borrarCampeon(){
        try {
            Statement st = connection.createStatement();
            System.out.println("A quien quieres eliminar: ");
            String nom = menu.NomMenu(connection).toUpperCase(Locale.ROOT);
            st.executeUpdate("delete from campeon where nom='" + nom + "'");
            st.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void borrarCampeonPorRol(){
        try {
            Statement st = connection.createStatement();
            System.out.println("Que rol quieres eliminar: ");
            String rol = menu.RolMenu(connection).toUpperCase(Locale.ROOT);
            st.executeUpdate("delete from campeon where rol='" + rol + "'");
            st.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
