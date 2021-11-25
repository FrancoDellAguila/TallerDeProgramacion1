package test;

import excepciones.PacienteYaExisteException;
import modelo.Clinica;
import modelo.Paciente;

public class EscenarioClinicaConDatos {

	
	private Paciente p1;
	public EscenarioClinicaConDatos() {
		this.p1 = new Paciente("19999999", "aaa", "bbb", "ccc", "ddd", "19999999", 1);;
	}
	
	public void agregarPacientes() {
		try {
			Clinica.getInstance().addPaciente(new Paciente("30303030", "aaa", "bbb", "ccc", "ddd", "19999999", 5));
			Clinica.getInstance().addPaciente(new Paciente("30303030", "aaa", "bbb", "ccc", "ddd", "19999999", 4));
			Clinica.getInstance().addPaciente(new Paciente("40404040", "aaa", "bbb", "ccc", "ddd", "19999999", 3));
			Clinica.getInstance().addPaciente(new Paciente("20202020", "aaa", "bbb", "ccc", "ddd", "19999999", 2));
		} catch (PacienteYaExisteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
