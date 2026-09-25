package ejercicio4;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class LectorEmpleados {

	public List<Empleado> leer(File fichero) throws IOException {
		List<Empleado> empleados = new ArrayList<>();

		for (String linea : Files.readAllLines(fichero.toPath())) {
			if (linea.isBlank()) {
				continue;
			}

			String[] campos = linea.split("\t");
			empleados.add(new Empleado(
					campos[0],
					Escala.valueOf(campos[1].trim()),
					Integer.parseInt(campos[2].trim()),
					campos[3].trim().equalsIgnoreCase("SI")));
		}

		return empleados;
	}
}
