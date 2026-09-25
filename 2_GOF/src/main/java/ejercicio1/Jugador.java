package ejercicio1;

import java.util.LinkedList;
import java.util.List;

public abstract class Jugador {

	protected List<Artillero> artilleros = new LinkedList<Artillero>();
	protected List<Zapador> zapadores = new LinkedList<Zapador>();
	protected String tipo;
	public Jugador(String tipo){
		this.tipo = tipo;
		
		//creamos el ejercito inicial (todos de la misma raza, no se pueden mezclar!)
		
		//[PUNTO DE REFACTORIZACION]
		if (tipo.equals("Harkonen")){
			artilleros.add(new ArtilleroHarkonen());
			artilleros.add(new ArtilleroHarkonen());
			zapadores.add(new ZapadorHarkonen());
			zapadores.add(new ZapadorHarkonen());
			
		}else if (tipo.equals("Atreides")){
			artilleros.add(new ArtilleroAtreides());
			artilleros.add(new ArtilleroAtreides());
			zapadores.add(new ZapadorAtreides());
			zapadores.add(new ZapadorAtreides());
			
		}
	}
	public abstract void jugar();
}
