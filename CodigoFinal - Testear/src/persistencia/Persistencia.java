package persistencia;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author Betti Francisco, Kollman Deborah, Stimmler Francisco, Veitch Matias
 *<br>
 *Clase representa la persistencia binaria. Implementa IPersistencia.
 */
public class Persistencia implements IPersistencia
{
    private FileOutputStream fileoutput;
    private FileInputStream fileinput;
    private ObjectOutputStream objectoutput;
    private ObjectInputStream objectinput;

    /**
	 * Método que permite abrir un archivo binario para su lectura.<br>
	 * <b>Pre: </b> El parámetro debe ser distinto de null.<br>
	 * @param nombre: Parámetro de tipo String que representa el nombre del archivo a abrir.
	 */
    public void abrirInput(String nombre) throws IOException
    {
        fileinput = new FileInputStream(nombre);
        objectinput = new ObjectInputStream(fileinput);
    }

    /**
	 * Método que permite abrir un archivo binario para su escritura.<br>
	 * <b>Pre: </b> El parámetro debe ser distinto de null.<br>
	 * @param nombre: Parámetro de tipo String que representa el nombre del archivo a abrir.
	 */
    public void abrirOutput(String nombre) throws IOException
    {
        fileoutput = new FileOutputStream(nombre);
        objectoutput = new ObjectOutputStream(fileoutput);

    }

    /**
	 * Método que permite cerrar un archivo abierto previamente para su escritura.<br>
	 */
    public void cerrarOutput() throws IOException
    {
        if (objectoutput != null)
            objectoutput.close();

    }

    /**
   	 * Método que permite cerrar un archivo abierto previamente para su lectura.<br>
   	 */
    public void cerrarInput() throws IOException
    {
        if (objectinput != null)
            objectinput.close();

    }

    /**
	 * Método que permite serializar un objeto de tipo Serializable.<br>
	 * <b>Pre: </b> El parámetro debe ser distinto de null.<br>
	 * <b>Post: </b> Serializará la clase enviada por parámetro en el archivo abierto.<br>
	 * @param p: Parámetro de tipo Serializable que representa el objeto a serializar.
	 */
    public void escribir(Serializable p) throws IOException
    {
        if (objectoutput != null)
            objectoutput.writeObject(p);
    }

    /**
	 * Método que permite deserializar un objeto.<br>
	 */
    public Serializable leer() throws IOException, ClassNotFoundException
    {
        Serializable p = null;
        if (objectinput != null)
            p = (Serializable) objectinput.readObject();
        return p;
    }
}
