package ejercicio3;

public class ProgramaD implements Runnable {

	public void run() {
		try {
			System.out.println("[INICIO] ProgramaD");
			Thread.sleep(10);
			System.out.println("[FIN] ProgramaD");
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
}
