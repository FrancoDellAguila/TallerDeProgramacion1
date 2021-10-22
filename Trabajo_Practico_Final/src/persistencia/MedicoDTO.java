package persistencia;

import java.io.Serializable;
import java.util.ArrayList;

import modelo.IMedico;
import personas.Medico;



/*Los profesionales que trabajen en la clínica deberán quedar registrados, tanto sus datos
personales como su desempeño dentro de la clínica.*/

public class MedicoDTO implements Serializable{
	
	private ArrayList<IMedico> medicosBD = new ArrayList<IMedico>();

	public ArrayList<IMedico> getMedicosBD() {
		return medicosBD;
	}

	public void setMedicosBD(ArrayList<IMedico> medicosBD) {
		this.medicosBD = medicosBD;
	}




	
	
}
