package persistencia;

import java.io.Serializable;
import java.util.ArrayList;


import personas.Medico;



/*Los profesionales que trabajen en la clínica deberán quedar registrados, tanto sus datos
personales como su desempeño dentro de la clínica.*/

public class MedicoDTO implements Serializable{
	
	private ArrayList<Medico> medicosBD = new ArrayList<Medico>();

	public ArrayList<Medico> getMedicosBD() {
		return medicosBD;
	}

	public void setMedicosBD(ArrayList<Medico> medicosBD) {
		this.medicosBD = medicosBD;
	}




	
	
}
