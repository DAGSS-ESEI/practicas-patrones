package calculadora;

import java.util.Scanner;

public class CalculadoraVibeCoding {

	public static void main(String[] args) {
		LicenseManager licenseManager = new LicenseManager();
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("1. Suma");
			System.out.println("2. Divide");
			System.out.println("3. Raíz");
			System.out.println("0. Salir");

			int opcion = Integer.parseInt(scanner.nextLine());

			if (opcion == 0) {
				break;
			} else if (opcion == 1) {
				System.out.print("sumando A: ");
				double a = Double.parseDouble(scanner.nextLine());
				System.out.print("sumando B: ");
				double b = Double.parseDouble(scanner.nextLine());
				System.out.println(a + b);
			} else if (opcion == 2) {
				System.out.print("dividendo: ");
				double a = Double.parseDouble(scanner.nextLine());
				System.out.print("divisor: ");
				double b = Double.parseDouble(scanner.nextLine());
				System.out.println(a / b);
			} else if (opcion == 3) {
				if (licenseManager.checkIsFullVersion()) {
					System.out.print("radicando: ");
					double a = Double.parseDouble(scanner.nextLine());
					System.out.println(Math.sqrt(a));
				} else {
					System.out.println("operación no disponible en la versión de evaluación");
				}
			} else {
				System.out.println("opción no válida");
			}
		}

		scanner.close();
	}
}
