package persistencia;

import java.util.ArrayList;

import modelo.IMedico;

/*Los profesionales que trabajen en la cl�nica deber�n quedar registrados, tanto sus datos
personales como su desempe�o dentro de la cl�nica.*/

public class MedicoDTO implements Serializable{
	
	private ArrayList<IMedico> medicos = new ArrayList<IMedico>();

	public ArrayList<IMedico> getMedicos() {
		return medicos;
	}

	public void setMedicos(ArrayList<IMedico> medicos) {
		this.medicos = medicos;
	}
	
	
}
