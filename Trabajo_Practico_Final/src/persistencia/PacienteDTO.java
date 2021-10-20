package persistencia;

import java.io.Serializable;
import java.util.ArrayList;


import personas.Paciente;

/*Los pacientes ingresados deber�n quedar registrados, tanto sus datos personales como un
hist�rico de las pr�cticas e internaciones realizadas.*/

public class PacienteDTO implements Serializable{
	ArrayList<Paciente> pacientes= new ArrayList<Paciente>();
	
	public PacienteDTO(){
	}

	public ArrayList<Paciente> getPacientes() {
		return pacientes;
	}

	public void setPacientes(ArrayList<Paciente> pacientes) {
		this.pacientes = pacientes;
	}


}
