import java.util.ArrayList;
import java.util.Iterator;

import Excepciones.NotaNoExistenteException;

public class Registro {

	private ArrayList<Alumno> alumnos = new ArrayList();
	private int legajoActual;
	private Alumno alumnoActual;
	private static Registro instance=null;
	
	
	private Registro() {
		super();
	}
	
	public static Registro getInstance() {
		if(instance == null) {
			instance = new Registro();
		}
		return instance;
	}

	public boolean buscaLegajo(int legajo) {
		boolean rta=false;
		
		Iterator<Alumno> it = alumnos.iterator();
		
		while(it.hasNext() && rta == false) {
			Alumno aux = it.next();
			if(aux.getLegajo() == legajo) {
				this.legajoActual= legajo;
				this.alumnoActual = aux;
				rta= true;
			}
		}
		return rta;
	}
	
	public String apellidoYNombre() {
		String rta="";
		
		rta=this.alumnoActual.getApellido()+ " "+this.alumnoActual.getNombre();
		return rta;
	}
	
	public String traerEstado(String materia) {
		String rta="";
		
		if(materia.equals("matematica")) {
			rta=this.alumnoActual.getEstadoMatematica();
		}else if(materia.equals("historia")) {
			rta=this.alumnoActual.getEstadoHistoria();
		}else if (materia.equals("literatura")) {
			rta=this.alumnoActual.getEstadoLiteratura();
		}else {
			rta=this.alumnoActual.getEstadoFisica();
		}
		return rta;
	}
	
	public String traerNota(String materia) throws NotaNoExistenteException {
		String aux;
		if(materia.equals("fisica")) {
			aux=this.alumnoActual.getNotaFisica();
		}else if(materia.equals("matematica")) {
			aux=this.alumnoActual.getNotaMatematica();
		}else if(materia.equals("historia")) {
			aux=this.alumnoActual.getNotaHistoria();
		}else {
			aux= this.alumnoActual.getNotaLiteratura();
		}
		return aux;
		
	}
}
