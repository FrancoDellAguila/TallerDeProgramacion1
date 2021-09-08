import Excepciones.NotaNoExistenteException;

/**
 * @author Tobias
 * 
 * clase encargada de armar el certificado
 * 
 * inv: si existe el legajo, siempre tiene que tener un apellido y nombre asociado.
 *
 */
public class Certificado {

	private int Legajo;
	private String condicion,apellidoNombre=null, notaHistoria, notaMatematica, notaLiteratura, notaFisica;
	private String estadoHistoria, estadoMatematica, estadoLiteratura, estadoFisica;
	private boolean existeLegajo=false;
	
	/**
	 * <b>PRE:<\b> el legajo debe ser un numero de 4 digitos. .....
	 * @param legajo: numero entero de 4 digitos
	 * @return true si se encontro el legajo o false en caso contrario
	 */
	public boolean pedirCertificado (int legajo) {
		boolean rta=false, existe=false;
		int cont=0;
		
		existe=Registro.getInstance().buscaLegajo(legajo);
		this.existeLegajo= existe;
		if(existe) {
			this.apellidoNombre= Registro.getInstance().apellidoYNombre();
			this.estadoFisica=Registro.getInstance().traerEstado("fisica");
			this.estadoMatematica=Registro.getInstance().traerEstado("matematica");
			this.estadoLiteratura=Registro.getInstance().traerEstado("literatura");
			this.estadoHistoria=Registro.getInstance().traerEstado("historia");
			try {
				this.notaFisica= Registro.getInstance().traerNota("fisica");
				
			} catch (NotaNoExistenteException e) {
				this.notaFisica= e.getMessage();
			}
			try {
				this.notaHistoria= Registro.getInstance().traerNota("historia");
				
			} catch (NotaNoExistenteException e) {
				this.notaHistoria= e.getMessage();
			}
			try {
				this.notaLiteratura= Registro.getInstance().traerNota("literatura");
				
			} catch (NotaNoExistenteException e) {
				this.notaLiteratura=e.getMessage();
			}
			try {
				this.notaMatematica= Registro.getInstance().traerNota("matematica");
				
			} catch (NotaNoExistenteException e) {
				this.notaMatematica=e.getMessage();
			}
			
			if(this.estadoFisica.equals("a cursar")) {
				cont++;
			}
			if(this.estadoHistoria.equals("a cursar")) {
				cont++;
			}
			if(this.estadoLiteratura.equals("a cursar")) {
				cont++;
			}
			if(this.estadoMatematica.equals("a cursar")) {
				cont++;
			}
			if(cont>=2) {
				this.condicion="regular";
			}else {
				this.condicion= "irregular";
			}
		}
		
		this.verificarInvariante();
		return rta;
	}
	
	/**
	 * <b>PRE:<\b> el legajo debe existir. <br>
	 * @return apellido y nombre del alumno
	 */
	public String traerApellidoyNombre() {
		this.verificarInvariante();
		if(this.existeLegajo) {
		return this.apellidoNombre;
		}
		else {
			return null;
		}
	}
	
	/**
	 * <b>PRE:<\b> el legajo debe existir. Las materias pueden ser matematica, fisica, historia, literatura <br>
	 * <b>POST:<\b> el estado de la materia tiene que ser: a cursar, aprobado, cursada.
	 * @param materia: nombre de la materia a traer estado.
	 * @return String estado de la materia.
	 */
	public String traerEstado(String materia) {
		String aux;
		
		assert this.verificaNombreMateria(materia): "nombre de materia incorrecto";
		if(this.existeLegajo==true) {
			if(materia.equals("matematica")) {
				aux=this.estadoMatematica;
			}else if(materia.equals("fisica")) {
				aux=this.estadoFisica;
			}else if(materia.equals("historia")) {
				aux=this.estadoHistoria;
			}else {
				aux=this.estadoLiteratura;
			}
		}else {
			aux=null;
		}
		
		assert this.verificaEstadoMateria(materia): "estado incorrecto";
		this.verificarInvariante();
		return aux;
	}
	
	/**
	 * <b>PRE:<\b> el legajo debe existir y ademas la materia no puede ser distinta de matematica, fisica, historia, literatura <br>
	 * <b>POST:<\b> la nota debe ser entera, entre 0 y 10, si el estado de la materia es "aprobada" y en caso de que sea otro estado sera null.
	 * @param materia: nombre de la materia que puede ser: matematica, fisica, historia, literatura.
	 * @return String con la nota de la materia o null en caso de no tener nota asignada
	 */
	public String traerNota(String materia) {
		String aux="";
		assert this.verificaNombreMateria(materia): "nombre materia incorrecto";
		if(this.existeLegajo==true) {
			if(materia.equals("fisica")) {
				aux=this.notaFisica;
			}else if(materia.equals("historia")) {
				aux=this.notaHistoria;
			}else if(materia.equals("literatura")) {
				aux=this.notaLiteratura;
			}else {
				aux=this.notaMatematica;
			}
		}else {
			aux=null;
		}
		
		assert this.verificarNota(materia): "nota incorrecta";
		this.verificarInvariante();
		return aux;
	}
	

	/**
	 * <b> PRE: <\b> el legajo tiene que existir <br>
	 * <b> POST: <\B> la condicion puede ser regular o irregular, si es regular se tiene que cumplir que 
	 * 					2 o mas materias tengas el estado "a cursar", sino el alumno es irregular
	 * @return String con la condicion del Alumno que se paso su legajo
	 */
	public String traerCondicion() {
		String aux="";
		
		
		if(this.existeLegajo==true) {
			aux=this.condicion;
		}else {
			aux=null;
		}
		
		assert this.verificarCondicion(): "condicion incorrecta";
		return aux;
	}
	
	private boolean verificarNota(String materia) {
		boolean rta=false;
		
		if(materia.equals("literatura")) {
			if(this.estadoLiteratura.equals("aprobado") && Integer.parseInt(this.notaLiteratura)>=0 && Integer.parseInt(this.notaLiteratura)<=10) {
				rta=true;
			}
		}else if(materia.equals("fisica")) {
			if(this.estadoFisica.equals("aprobado") && Integer.parseInt(this.notaFisica)>=0 && Integer.parseInt(this.notaFisica)<=10) {
				rta=true;
			}
		}else if(materia.equals("historia")) {
			if(this.estadoHistoria.equals("aprobado") && Integer.parseInt(this.notaHistoria)>=0 && Integer.parseInt(this.notaHistoria)<=10) {
				rta=true;
			}
		}else {
			if(this.estadoMatematica.equals("aprobado") && Integer.parseInt(this.notaMatematica)>=0 && Integer.parseInt(this.notaMatematica)<=10) {
				rta=true;
			}
		}
		return rta;
	}
	private boolean verificarCondicion() {
		boolean rta=false;
		int cont=0;
		
		if(this.estadoFisica.equals("a cursar")) {
			cont++;
		}else if(this.estadoHistoria.equals("a cursar")) {
			cont++;
		}else if(this.estadoLiteratura.equals("a cursar")) {
			cont++;
		}else if(this.estadoMatematica.equals("a cursar")) {
			cont++;
		}
		if((cont>=2 && this.condicion.equals("regular")) || (cont<2 && this.condicion.equals("irregular"))) {
			rta=true;
		}
	
		return rta;
	}
	
	private boolean verificaEstadoMateria(String materia) {
		boolean rta=false;
		
		if(materia.equals("fisica")) {
			if(this.estadoFisica.equals("a cursar") || this.estadoFisica.equals("cursada") || this.estadoFisica.equals("aprobada")) {
				rta=true;
			}
		}else  if(materia.equals("historia")) {
			if(this.estadoHistoria.equals("a cursar")||this.estadoHistoria.equals("cursada")||this.estadoHistoria.equals("aprobada")) {
				rta=true;
			}
		}else if(materia.equals("literatura")) {
			if(this.estadoLiteratura.equals("a cursar")||this.estadoLiteratura.equals("cursada")||this.estadoLiteratura.equals("aprobada")) {
				rta=true;
			}
		}else {
			if(this.estadoMatematica.equals("a cursar")||this.estadoMatematica.equals("aprobada")||this.estadoMatematica.equals("cursada")) {
				rta=true;
			}
		}
		
		return rta;
	}
	
	private boolean verificaNombreMateria(String materia) {
		boolean rta=false;
		
		if(materia.equals("fisica")) {
			rta=true;
		}else if(materia.equals("historia")) {
			rta=true;
		}else if(materia.equals("literatura")) {
			rta=true;
		}else if(materia.equals("matematica")) {
			rta=true;
		}
		return rta;
	}
	
	private void verificarInvariante() {
		assert this.existeLegajo==true && this.apellidoNombre!=null : "el legajo no tiene nomre y apellido";
		
	}
}
