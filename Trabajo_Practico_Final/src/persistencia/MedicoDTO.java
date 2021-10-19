package persistencia;

import java.io.Serializable;

import java.util.TreeSet;

import modelo.BDdeMedicos;
import modelo.IMedico;
import personas.Paciente;


/*Los profesionales que trabajen en la cl�nica deber�n quedar registrados, tanto sus datos
personales como su desempe�o dentro de la cl�nica.*/

public class MedicoDTO implements Serializable{
	
	private TreeSet<IMedico> medicosBD = new TreeSet<>();

	public TreeSet<IMedico> getMedicos() {
		return this.medicosBD;
	}

	public void setMedicos(TreeSet<IMedico> BDdeMedicos) {
		this.medicosBD = BDdeMedicos;
	}
	
	
}
