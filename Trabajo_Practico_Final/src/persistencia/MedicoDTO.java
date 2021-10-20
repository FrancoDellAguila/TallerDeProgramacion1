package persistencia;

import java.io.Serializable;
import java.util.ArrayList;

import modelo.BDdeMedicos;
import modelo.IMedico;
import personas.Paciente;


/*Los profesionales que trabajen en la cl�nica deber�n quedar registrados, tanto sus datos
personales como su desempe�o dentro de la cl�nica.*/

public class MedicoDTO implements Serializable{
	
	private ArrayList<IMedico> medicosBD = new ArrayList<IMedico>();

	public ArrayList<IMedico> getMedicosBD() {
		return medicosBD;
	}

	public void setMedicosBD(ArrayList<IMedico> medicosBD) {
		this.medicosBD = medicosBD;
	}
	
	
}
