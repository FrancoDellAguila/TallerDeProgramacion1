package persistencia;

import java.io.IOException;
import java.io.Serializable;

/**
 * @author Betti Francisco, Kollman Deborah, Stimmler Francisco, Veitch Matias
 *<br>
 *Interfaz que representa los métodos para lograr la persistencia.
 */
public interface IPersistencia
{
	/**
	 * Método que permite abrir un archivo para su lectura.<br>
	 * <b>Pre: </b> El parámetro debe ser distinto de null.<br>
	 * @param nombre: Parámetro de tipo String que representa el nombre del archivo a abrir.
	 */
	void abrirInput(String nombre) throws IOException;

	/**
	 * Método que permite abrir un archivo para su escritura.<br>
	 * <b>Pre: </b> El parámetro debe ser distinto de null.<br>
	 * @param nombre: Parámetro de tipo String que representa el nombre del archivo a abrir.
	 */
    void abrirOutput(String nombre) throws IOException;

    /**
	 * Método que permite cerrar un archivo abierto previamente para su escritura.<br>
	 */
    void cerrarOutput() throws IOException;

    /**
	 * Método que permite cerrar un archivo abierto previamente para su lectura.<br>
	 */
    void cerrarInput() throws IOException;

    /**
	 * Método que permite serializar un objeto de tipo Serializable.<br>
	 * <b>Pre: </b> El parámetro debe ser distinto de null.<br>
	 * <b>Post: </b> Serializará la clase enviada por parámetro en el archivo abierto.<br>
	 * @param p: Parámetro de tipo Serializable que representa el objeto a serializar.
	 */
    void escribir(Serializable p) throws IOException;

    /**
	 * Método que permite deserializar un objeto.<br>
	 */
    Serializable leer() throws IOException, ClassNotFoundException;
}
