package persistencia;

import java.io.Serializable;
import java.util.TreeSet;

import personas.Paciente;

/*Los pacientes ingresados deberán quedar registrados, tanto sus datos personales como un
histórico de las prácticas e internaciones realizadas.*/

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
