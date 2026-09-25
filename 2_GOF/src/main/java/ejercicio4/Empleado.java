package ejercicio4;

public class Empleado {
	private final String nombre;
	private final Escala escala;
	private final int anyosTrabajados;
	private final boolean cargoGestion;

	public Empleado(String nombre, Escala escala, int anyosTrabajados, boolean cargoGestion) {
		this.nombre = nombre;
		this.escala = escala;
		this.anyosTrabajados = anyosTrabajados;
		this.cargoGestion = cargoGestion;
	}

	public String getNombre() {
		return nombre;
	}

	public Escala getEscala() {
		return escala;
	}

	public int getAnyosTrabajados() {
		return anyosTrabajados;
	}

	public boolean hasCargoGestion() {
		return cargoGestion;
	}
}
