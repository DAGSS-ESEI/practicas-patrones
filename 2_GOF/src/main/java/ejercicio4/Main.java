package ejercicio4;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		List<Empleado> empleados = new LectorEmpleados().leer(new File("empleados.txt"));

		for (Empleado empleado : empleados) {
			// TODO: calcular la nómina del empleado y mostrar su orden de pago
		}
	}
}
