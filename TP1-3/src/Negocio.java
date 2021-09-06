
/**
 * @author Tobias
 *
 *clase que se encarga de ser la intermediaria entre la UI y el certificado
 */
public class Negocio {

	private Certificado certificado;
	
	/**
	 * @param legajo: numero de legajo que se esta buscando
	 * @return respuesta de si se encontro o no el legajo
	 */
	public boolean pedirCertificado(int legajo) {
		boolean rta=false;
		
		this.certificado=new Certificado();
		rta=this.certificado.pedirCertificado(legajo);
		return rta;
	}
	
	/**
	 * @return String con nombre y apellido del alumno con el legajo que se pidio anteriormente, en caso de no existir devuelve el estado.
	 */
	public String traerApellidoyNombre() {
		String aux="";
		
		aux=this.certificado.traerApellidoyNombre();
		if(aux==null) {
			aux="no existe el legajo";
		}
		return aux;
	}
	
	/**
	 * @param materia: nombre de la materia que se quiere la nota
	 * @return 
	 */
	public String traerEstados(String materia) {
		String aux="";
		
		aux=this.certificado.traerEstado(materia);
		if(aux==null) {
			aux="no existe el legajo";
		}
		return aux;
	}
	
	/**
	 * @param materia: nombre de la materia que se quiere la nota
	 * @return String con la nota de la materia o el estado por el cual la nota no esta disponible
	 */
	public String traerNota(String materia) {
		String aux="";
		
		aux=this.certificado.traerNota(materia);
		return aux;
	}
	
	/**
	 * @return String con la condicion del alumno que se pidio el ultimo certificado, sino devuelve mensaje de que no existe el legajo.
	 */
	public String traerCondicion() {
		String aux="";
		
		aux=this.certificado.traerCondicion();
		if(aux==null) {
			aux="legajo no existe";
		}
		return aux;
	}

	public Certificado getCertificado() {
		return certificado;
	}
	
	
}
