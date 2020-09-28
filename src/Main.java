import java.util.concurrent.Semaphore;

public class Main {

/**
 * Grupo 5
 * @author Juan Fernando Giraldo
 * @author Juan Martin Garcia
 * @author Mateo Gallego
 */
	public static void main(String[] args) {
		Espera esp = new Espera();
		Semaphore turno = new Semaphore(1);
		Monitor monitor = new Monitor(esp,turno);
		monitor.start();
		Estudiante e1 = new Estudiante("Juan",esp,monitor,turno);
		Estudiante e2 = new Estudiante("Pedro",esp,monitor,turno);
		Estudiante e3 = new Estudiante("Pablo",esp,monitor,turno);
		Estudiante e4 = new Estudiante("Martin",esp,monitor,turno);
		Estudiante e5 = new Estudiante("Hugo",esp,monitor,turno);
		e1.start();
		e2.start();
		e3.start();
		e4.start();
		e5.start();
		
	}

}
