package ejercicio1;

public class JugadorMaquina extends Jugador {
	
	public JugadorMaquina(String tipo) {
		super(tipo);
	}

	@Override
	public void jugar() {
		//disparamos!
		for (Artillero artillero : artilleros){
			artillero.disparar();
		}
		
		//ponemos bombas!
		for (Zapador zapador: zapadores){
			zapador.ponerBomba();
		}

	}

}
