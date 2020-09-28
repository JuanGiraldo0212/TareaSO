import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Espera {
	
	//private Semaphore sem;
	
	private Queue<Estudiante> sillas;
	
	public Espera() {
		//sem= new Semaphore(1);
		sillas = new LinkedList<Estudiante>();
	}
	
	public void agregarEstudiante(Estudiante e) {
		
		
			//sem.acquire();
			sillas.add(e);
			System.out.println(e.getNombre()+" esta esperando");
			//sem.release();
		
		
	}
	
	
	public Estudiante extraerEstudiante() {
		
			//sem.acquire();
			Estudiante e = sillas.poll();
			System.out.println(e.getNombre()+" va a ser atendido");
			//sem.release();
			return e;
		
		
	}


	public Queue<Estudiante> getSillas() {
		return sillas;
	}

	public void setSillas(Queue<Estudiante> sillas) {
		this.sillas = sillas;
	}
	
	
}
