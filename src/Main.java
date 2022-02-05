import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;

/**
 * Esta clase es la principal donde inicializas tu programa y muestra un menu
 */
public class Main {
	public static void main(String[] args) throws IOException, SQLException, ParseException {
		Menu menu = new Menu();
		
		ConnectionFactory connectionFactory = ConnectionFactory.getInstance();
		Connection c = connectionFactory.connect();

		CampeonController campeonController = new CampeonController(c);
		RolController rolController = new RolController(c);
		TodoController todoController = new TodoController(c);


		int option = menu.mainMenu();
		while (option > 0 && option < 16) {
			switch (option) {
				case 1:
					campeonController.borrarTabla();
					rolController.borrarTabla();
					break;

				case 2:
					rolController.crearTabla();
					campeonController.crearTabla();
					break;

				case 3:
					todoController.rellenar();
					break;

				case 4:
					campeonController.showCampeonPorRol();
					break;

				case 5:
					campeonController.showCampeonCon();
					break;

				case 6:
					campeonController.showCampeonPor();
					break;

				case 7:
					campeonController.modificarCampeon();
					break;

				case 8:
					rolController.modificarRol();
					break;

				case 9:
					campeonController.borrarCampeon();
					break;

				case 10:
					campeonController.borrarCampeonPorRol();
					break;

				case 11:
					rolController.createRol();
					break;

				case 12:
					campeonController.createCampeon();
					break;

				case 13:
					campeonController.showCampeones();
					break;

				case 14:
					rolController.showRols();
					break;

				case 15:
					System.exit(0);
					break;

				default:
					System.out.println("Introdueixi una de les opcions anteriors");
					break;
				}
			option = menu.mainMenu();
		}
	}
}
