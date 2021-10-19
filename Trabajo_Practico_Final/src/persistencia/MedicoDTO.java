package persistencia;

import java.util.ArrayList;

import modelo.IMedico;

/*Los profesionales que trabajen en la clínica deberán quedar registrados, tanto sus datos
personales como su desempeño dentro de la clínica.*/

public class MedicoDTO implements Serializable{
	
	private ArrayList<IMedico> medicos = new ArrayList<IMedico>();

	public ArrayList<IMedico> getMedicos() {
		return medicos;
	}

	public void setMedicos(ArrayList<IMedico> medicos) {
		this.medicos = medicos;
	}
	
	
}
