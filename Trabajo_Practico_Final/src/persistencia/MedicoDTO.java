package persistencia;

import java.io.Serializable;
import java.util.ArrayList;


import personas.Medico;



/*Los profesionales que trabajen en la cl�nica deber�n quedar registrados, tanto sus datos
personales como su desempe�o dentro de la cl�nica.*/

public class MedicoDTO implements Serializable{
	
	private ArrayList<Medico> medicosBD = new ArrayList<Medico>();

	public ArrayList<Medico> getMedicosBD() {
		return medicosBD;
	}

	public void setMedicosBD(ArrayList<Medico> medicosBD) {
		this.medicosBD = medicosBD;
	}




	
	
}
