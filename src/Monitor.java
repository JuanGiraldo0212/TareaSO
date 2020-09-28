import java.util.Random;
import java.util.concurrent.Semaphore;

public class Monitor extends Thread{
	
	private Semaphore turno;
	private Espera esp;
	private boolean dormido;
	
	public Monitor( Espera esp,Semaphore turno) {
		this.turno = turno;
		this.esp=esp;
		this.dormido=true;
	}
	
	public void despertar(Estudiante e) {
			System.out.println(e.getNombre()+" despertó al monitor");
			dormido=false;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		while(true) {
			if(!dormido) {
				try {
					turno.acquire();
					if(esp.getSillas().size()>0) {
						try {
							Random rand= new Random();
							sleep((long)rand.nextInt(2000));
							Estudiante e = esp.extraerEstudiante();
							System.out.println("Se antendió a "+e.getNombre());
							e.setEsperando(false);
							turno.release();
							
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
					else {
						System.out.println("El monitor se duerme");
						dormido=true;
						turno.release();
					}
					
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		}
	}

}
