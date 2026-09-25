package ejercicio3;

public class ProgramaB implements Runnable {

	public void run() {
		try {
			System.out.println("[INICIO] ProgramaB");
			Thread.sleep(10);
			System.out.println("[FIN] ProgramaB");
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
}
