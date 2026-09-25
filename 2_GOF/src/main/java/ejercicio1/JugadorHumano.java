package ejercicio1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JugadorHumano extends Jugador {

	
	public JugadorHumano(String tipo) {
		super(tipo);
		
	}

	private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	@Override
	public void jugar() {
		System.out.println("Qué hago? [d=disparar, b=poner bombas, a=crear_artillero, z=crear_zapador");
		String line;
		try {
			line = in.readLine();
			if (line.startsWith("d")){
				for (Artillero a : artilleros){
					a.disparar();
				}
			}
			if (line.startsWith("b")){
				for (Zapador z : zapadores){
					z.ponerBomba();
				}
			}
			
			//[PUNTO DE REFACTORIZACION]
			if (line.startsWith("a")){
				if (this.tipo.equals("Atreides")){
					this.artilleros.add(new ArtilleroAtreides());
					
				}else if (this.tipo.equals("Harkonen")){
					this.artilleros.add(new ArtilleroHarkonen());
				}
			}
			
			if (line.startsWith("z")){
				if (this.tipo.equals("Atreides")){
					this.zapadores.add(new ZapadorAtreides());
					
				}else if (this.tipo.equals("Harkonen")){
					this.zapadores.add(new ZapadorHarkonen());
				}
			}
			
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		

	}

}
