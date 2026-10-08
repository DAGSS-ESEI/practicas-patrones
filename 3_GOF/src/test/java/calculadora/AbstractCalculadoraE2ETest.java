package calculadora;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.function.Consumer;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import uk.org.webcompere.systemstubs.jupiter.SystemStub;
import uk.org.webcompere.systemstubs.jupiter.SystemStubsExtension;
import uk.org.webcompere.systemstubs.stream.SystemIn;
import uk.org.webcompere.systemstubs.stream.SystemOut;
import uk.org.webcompere.systemstubs.stream.input.LinesAltStream;

/**
 * Test end-to-end genérico para una calculadora de consola. Ejecuta el
 * {@code main} con una entrada de teclado simulada y comprueba la salida
 * por pantalla, así que sirve igual para {@link CalculadoraVibeCoding} que
 * para la futura {@code Calculadora}.
 */
@ExtendWith(SystemStubsExtension.class)
public abstract class AbstractCalculadoraE2ETest {

	@SystemStub
	private SystemIn systemIn = new SystemIn();

	@SystemStub
	private SystemOut systemOut = new SystemOut();

	/**
	 * Factory Method: la clase base (creator) no conoce las implementaciones
	 * concretas; cada subclase (concrete creator) decide el "producto", es
	 * decir, qué main se va a probar. El producto es un Consumer&lt;String[]&gt;,
	 * la interfaz funcional que representa ese main. Así, este mismo e2e
	 * sirve tanto para CalculadoraVibeCoding como para cualquier Calculadora.
	 */
	protected abstract Consumer<String[]> main();

	private void ejecutar(String... lineas) {
		systemIn.setInputStream(new LinesAltStream(lineas));
		main().accept(new String[0]);
	}

	@Test
	void muestraElMenu() {
		ejecutar("0");
		String salida = systemOut.getText();

		assertTrue(salida.contains("1. Suma"), salida);
		assertTrue(salida.contains("2. Divide"), salida);
		assertTrue(salida.contains("3. Raíz"), salida);
		assertTrue(salida.contains("0. Salir"), salida);
		assertTrue(salida.indexOf("0. Salir") > salida.indexOf("3. Raíz"), salida);
	}

	@Test
	void suma() {
		ejecutar("1", "2", "3", "0");
		assertTrue(systemOut.getText().contains("5.0"), systemOut.getText());
	}

	@Test
	void divide() {
		ejecutar("2", "10", "4", "0");
		assertTrue(systemOut.getText().contains("2.5"), systemOut.getText());
	}

	@Test
	void raiz() {
		ejecutar("3", "9", "0");
		assertTrue(systemOut.getText().contains("3.0"), systemOut.getText());
	}
}
