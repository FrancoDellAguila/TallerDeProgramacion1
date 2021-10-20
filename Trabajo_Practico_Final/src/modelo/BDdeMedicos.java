package modelo;

import java.util.ArrayList;

import personas.Medico;

public class BDdeMedicos {	


    ArrayList<Medico> medicosBD = new ArrayList<Medico>();

	public BDdeMedicos() {

	}
	
	public void agregarMedico(Medico medico) {
		medicosBD.add(medico);
	}

	public ArrayList<Medico> getMedicosBD() {
		return medicosBD;
	}

	public void setMedicosBD(ArrayList<Medico> medicosBD) {
		this.medicosBD = medicosBD;
	}


}
