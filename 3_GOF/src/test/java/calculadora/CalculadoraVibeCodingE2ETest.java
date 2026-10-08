package calculadora;

import java.util.function.Consumer;

class CalculadoraVibeCodingE2ETest extends AbstractCalculadoraE2ETest {

	@Override
	protected Consumer<String[]> main() {
		return CalculadoraVibeCoding::main;
	}
}
