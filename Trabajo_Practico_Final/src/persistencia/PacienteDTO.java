package persistencia;

import java.io.Serializable;
import java.util.TreeSet;

import personas.Paciente;

/*Los pacientes ingresados deber�n quedar registrados, tanto sus datos personales como un
hist�rico de las pr�cticas e internaciones realizadas.*/

public class PacienteDTO implements Serializable{
	TreeSet<Paciente> pacientes= new TreeSet<>();
	
	public PacienteDTO(){
	}

	public TreeSet<Paciente> getPacientes() {
		return this.pacientes;
	}

	public void setPacientes(TreeSet<Paciente> pacientes) {
		this.pacientes = pacientes;
	}
	
}
