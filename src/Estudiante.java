import java.util.Random;
import java.util.concurrent.Semaphore;

public class Estudiante extends Thread{
	
	private String nombre;
	
	private Espera espera;
	
	private boolean esperando;
	
	private Monitor monitor;
	
	private Semaphore turno;
	
	public Estudiante(String nombre, Espera espera,Monitor monitor,Semaphore turno) {
		this.nombre=nombre;
		this.espera=espera;
		this.esperando=false;
		this.monitor=monitor;
		this.turno = turno;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		while(true) {
			if(!esperando) {
				try {
					turno.acquire();
					if(espera.getSillas().size()==0) {
						espera.agregarEstudiante(this);
						monitor.despertar(this);
						esperando=true;
						turno.release();
					}
					else if(espera.getSillas().size()<3){
						esperando=true;
						espera.agregarEstudiante(this);
						turno.release();
					}
					else if(espera.getSillas().size()>=3){
						try {
							System.out.println(nombre+ " se va a programar");
							turno.release();
							Random rand= new Random();
							sleep((long)rand.nextInt(2000));
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Espera getEspera() {
		return espera;
	}

	public void setEspera(Espera espera) {
		this.espera = espera;
	}

	public boolean isEsperando() {
		return esperando;
	}

	public void setEsperando(boolean esperando) {
		this.esperando = esperando;
	}
	
	
	

}
