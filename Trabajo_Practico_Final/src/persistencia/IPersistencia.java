package persistencia;

import java.io.IOException;
import java.io.Serializable;

public interface IPersistencia {
	void abrirInput();
	
	void abrirOutput();
	
	void cerrarOutput();

	void cerrarInput();
	
	void escribir(Serializable p) throws IOException;

    E leer() throws IOException, ClassNotFoundException;
}
