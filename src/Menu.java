import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu {
	private int option;

	public Menu() {
		super();
	}

	public int mainMenu() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		do {

			System.out.println(" \nMENU PRINCIPAL \n");

			System.out.println("1. Borrar Tablas");
			System.out.println("2. Craer Tablas");
			System.out.println("3. Rellenar Tablas");
			System.out.println("4. Mostrar los que sean Asesino");
			System.out.println("5. Mostrar los que tengan un ?");
			System.out.println("6. Mostrar todos los campeon que empiezan por ?");
			System.out.println("7. Modificar un campeon");
			System.out.println("8. Modificar campeones que empiezan por ?");
			System.out.println("9. Eliminar un campeon");
			System.out.println("10. Eliminar campeones con el rol ?");
			System.out.println("11. Añadir un rol");
			System.out.println("12. Exit");
			System.out.println("Esculli opció: ");
			try {
				option = Integer.parseInt(br.readLine());
			} catch (NumberFormatException | IOException e) {
				System.out.println("valor no vàlid");
				e.printStackTrace();

			}

		} while (option != 1 && option != 2 && option != 3 && option != 4 && option != 5 && option != 6 && option != 7
				&& option != 8 && option != 9 && option != 10 && option != 11 && option != 12);


		return option;
	}

	public Identity authenticate(int tries) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("============================ACB=============================");
		System.out.println("============================================================");
		System.out.println("Avís: tens " + (3 - tries) + " intents per loginarte");
		System.out.println("============================================================");
		System.out.println("Inserta nom del usuari: ");
		String user = br.readLine();
		System.out.println("Inserta contrasenya: ");
		String password = br.readLine();

		Identity identity = new Identity(user, password);
		return identity;

	}

}
