import Excepciones.NotaNoExistenteException;

public class Alumno {

	private String nombre, apellido, notaMatematica, notaHistoria, notaLiteratura, notaFisica;
	private int legajo;
	private String estadoHistoria, estadoMatematica, estadoLiteratura, estadoFisica;
	public Alumno(String nombre, String apellido, int legajo, String notaMatematica, String notaHistoria, String notaLiteratura,
			String notaFisica, String estadoHistoria, String estadoMatematica, String estadoLiteratura,
			String estadoFisica) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.legajo = legajo;
		this.notaMatematica = notaMatematica;
		this.notaHistoria = notaHistoria;
		this.notaLiteratura = notaLiteratura;
		this.notaFisica = notaFisica;
		this.estadoHistoria = estadoHistoria;
		this.estadoMatematica = estadoMatematica;
		this.estadoLiteratura = estadoLiteratura;
		this.estadoFisica = estadoFisica;
	}
	public String getNombre() {
		return nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public int getLegajo() {
		return legajo;
	}
	public String getNotaMatematica() throws NotaNoExistenteException {
		if(this.estadoMatematica.equals("aprobado")) {
		return notaMatematica;
		}
		else {
			throw new NotaNoExistenteException("estado de la materia "+ this.estadoMatematica);
		}
	}
	public String getNotaHistoria() throws NotaNoExistenteException {
		if (this.estadoHistoria.equals("aprobado")) {
			return notaHistoria;
		}else {
			throw new NotaNoExistenteException("estado de la materia "+ this.estadoHistoria);
		}
	}
	public String getNotaLiteratura() throws NotaNoExistenteException {
		if (this.estadoLiteratura.equals("aprobado")) {
			return notaLiteratura;
		}else {
			throw new NotaNoExistenteException("estado de la materia "+ this.estadoLiteratura);
		}
	}
	public String getNotaFisica() throws NotaNoExistenteException {
		if (this.estadoFisica.equals("aprobado")) {
			return notaFisica;
		}else {
			throw new NotaNoExistenteException("estado de la materia "+ this.estadoFisica);
		}
	}
	public String getEstadoHistoria() {
		return estadoHistoria;
	}
	public String getEstadoMatematica() {
		return estadoMatematica;
	}
	public String getEstadoLiteratura() {
		return estadoLiteratura;
	}
	public String getEstadoFisica() {
		return estadoFisica;
	}
	
	
}
