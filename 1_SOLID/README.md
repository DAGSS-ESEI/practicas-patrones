# 1. SOLID

## Objetivos

Comprender y saber aplicar los principios SOLID sobre una aplicación existente.

## La aplicación

Sea una aplicación que hace lo siguiente:

1. Pide dos nombres de ficheros al usuario: uno de entrada y otro de salida.
2. Transforma el fichero de entrada a un XML escribiéndolo en el fichero de salida.

Se dispone de su código fuente:

```java
package converterapp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class ConverterApp {

	public static void main(String args[]) {
		File input = getInputFile();
		File output = getOutputFile();

		try {
			transform(input, output);
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
			System.exit(1);
		}
	}

	public static void transform(File input, File output)
			throws FileNotFoundException {
		Scanner scanner;
		try {
			scanner = new Scanner(input);
		} catch (FileNotFoundException e) {
			throw new FileNotFoundException("the file "
					+ input.getAbsolutePath() + " does not exist: "
					+ e.getMessage());
		}

		PrintStream out;
		try {
			out = new PrintStream(new FileOutputStream(output));
		} catch (FileNotFoundException e) {
			throw new FileNotFoundException("the file "
					+ output.getAbsolutePath() + " cannot be created: "
					+ e.getMessage());
		}

		out.println("<products>");
		while (scanner.hasNextLine()) {			
			String xmlString = toXML(scanner.nextLine());
			out.println(xmlString);
		}
		out.println("</products>");

		scanner.close();
		out.close();
	}

	private static String toXML(String line) {
		String[] tokens = line.split("\t");
		if (tokens.length != 2) {
			throw new IllegalArgumentException(
					"the line does not contain 2 tokens");
		}

		return "<product>\n\t<name>" + tokens[0] + "</name>\n\t<price>"
				+ tokens[1] + "</price>\n</product>";

	}

	private static File getInputFile() {
		System.out.println("input filename: ");
		return getFile();
	}

	private static File getOutputFile() {
		System.out.println("output filename: ");
		return getFile();
	}

	private static File getFile() {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		String name = in.nextLine();

		return new File(name);
	}
}
```

Un ejemplo del fichero de entrada podría ser (separado por tabuladores):

```
motherboard	100
cpu	80
ram memory	70
hard disk	150
```

El código fuente de un proyecto Maven (importable en netbeans, eclipse, vscode...) conteniendo el programa se puede descargar de aquí.

## Tareas.

Antes de empezar descarga el código fuente asociado a esta tarea e impórtalo en el IDE.

1. Identifica las diferentes responsabilidades que existen en este programa. Haz una lista con ellas.
2. Refactoriza la aplicación para cumplir estos **objetivos**:
    1. El origen de datos (ahora ficheros) pueda ser distinto **y/o** el destino de los datos también.
    2. La transformación que se hace de la entrada pueda ser otra representación basada en texto cualquiera (no a XML).

Una vez refactorizada,

1. Responde a estas cuestiones:
    - ¿**Qué** principio o principios SOLID has empleado para cada uno de los dos objetivos anteriores, **cómo** los has empleado y **por qué**?
2. Elabora una tabla para documentar las responsabilidades de las clases

    | Clase | Responsabilidad |
    | ----- | --------------- |
    | ...   | ...             |

3. Elabora una tabla para documentar el principio OCP (Open Closed Principle) en tu código. Una clase que respeta el principio OCP, está cerrada para modificación pero abierta para extensión, siempre centrándonos en una modificación futura concreta. Por lo tanto, la tabla debe contener estas columnas.

    | Clase | Modificación posible | Punto de extensión |
    | ----- | -------------------- | ------------------ |
    | nombre de clase | descripción de la modificación | clase/interfaz que se debe extender o implementar |

4. Modifica la aplicación para que la salida se produzca por pantalla y no a fichero. ¿Tuviste que cambiar código existente a mayores que el método *main*? Describe brevemente la modificación.

#### Código base

[ejercicio-solid-src.zip](https://moovi.uvigo.gal/pluginfile.php/186091/mod_page/content/4/ejercicio-solid-src.zip?time=1726770620864)
