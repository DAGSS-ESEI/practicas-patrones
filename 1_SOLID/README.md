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

### Antes de empezar

1. Descarga el código fuente asociado a esta tarea e impórtalo en el IDE.
2. **Escribe un test e2e básico** que verifique que el programa transforma la entrada en XML. Concretamente:
   - Crea el test en `src/test/java/converterapp/ConverterAppTest.java`.
   - Llama directamente a `ConverterApp.transform(input, output)` con un fichero de entrada y uno de salida temporales.
   - Comprueba que el fichero de salida contiene el XML esperado.
   - Ejecuta los tests con `mvn test`.

   Si nunca has usado JUnit 5, consulta antes el apartado [JUnit 5](#junit-5).

### Tareas

1. Identifica las diferentes responsabilidades que existen en este programa. Haz una lista con ellas.
2. Refactoriza la aplicación para cumplir estos **objetivos**:
    1. El origen de datos (ahora ficheros) pueda ser distinto **y/o** el destino de los datos también.
    2. La transformación que se hace de la entrada pueda ser otra representación basada en texto cualquiera (no a XML).

> **Importante**: cuando refactorices, adapta tu test e2e al nuevo código para que siga pasando. Así comprobarás que la refactorización conserva el comportamiento.

### Una vez refactorizada

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
5. **Añade una nueva transformación**: implementa un `JsonTransformer` que genere la salida en formato JSON (por ejemplo, `[{"name":"motherboard","price":"100"}]`) y amplía tu test e2e para que cubra esta nueva transformación. Comprueba que para añadirla no has tenido que modificar las clases existentes: esa es la demostración práctica del principio OCP.

### JUnit 5

JUnit 5 es el framework de testing de Java que usa este proyecto. Un test es una clase Java que ejecuta un método anotado con `@Test` y comprueba resultados con *assertions*.

**Estructura de un test:**

```java
package converterapp;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.nio.file.Files;

import org.junit.jupiter.api.Test;

class ExampleTest {

	@Test
	void writesAndReadsATempFile() throws Exception {
		File file = File.createTempFile("example", ".txt");
		Files.writeString(file.toPath(), "hello");

		assertEquals("hello", Files.readString(file.toPath()));
	}
}
```

**Cómo funciona:**

- Los tests se colocan en `src/test/java`, en el mismo paquete que la clase que prueban.
- El método de prueba se anota con `@Test`. Los métodos pueden declarar `throws Exception` porque el framework no lo prohíbe.
- `File.createTempFile(...)` crea un fichero temporal único; `Files.writeString` escribe texto en él y `Files.readString` lo lee.
- `assertEquals(expected, actual)` falla el test si los dos valores no coinciden.
- Para ejecutar los tests escribe `mvn test` en la raíz del proyecto. Al final verás un resumen como `Tests run: 1, Failures: 0`.

**Text blocks para comparar XML:**

Para comparar contenido de varias líneas resulta cómodo usar un *text block* (Java 15+, disponible desde Java 17):

```java
String expected = """
		<product>
		\t<name>motherboard</name>
		</product>
		""";
```

Un text block empieza y termina con `"""`, incluye el salto de línea final y respeta la indentación. Cuidado con los espacios y con los tabuladores (`\t`): un cambio involuntario hace que el test falle.

**Consejos:**

- Un test fallido no se arregla "de memoria": mira primero el mensaje de error que imprime JUnit (te dice qué valores no coincidieron y en qué línea).
- En el test del conversor, compara el contenido completo del fichero de salida y fíjate en los saltos de línea del XML esperado, incluido el último: el programa escribe una línea nueva tras cada elemento.

#### Código base

[ejercicio-solid-src.zip](https://moovi.uvigo.gal/pluginfile.php/186091/mod_page/content/4/ejercicio-solid-src.zip?time=1726770620864)
