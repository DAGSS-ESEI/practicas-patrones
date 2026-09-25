package ejercicio4;

public enum Escala {
	C(900), B(1100), A(1300);

	private final int salarioBase;

	Escala(int salarioBase) {
		this.salarioBase = salarioBase;
	}

	public int getSalarioBase() {
		return salarioBase;
	}
}
