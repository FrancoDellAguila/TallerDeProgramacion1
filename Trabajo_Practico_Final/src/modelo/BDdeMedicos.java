package modelo;

import java.util.ArrayList;

import personas.Medico;

public class BDdeMedicos {	


    ArrayList<IMedico> medicosBD = new ArrayList<IMedico>();

	public BDdeMedicos() {

	}
	
	public void agregarMedico(IMedico medico) {
		medicosBD.add(medico);
	}

	public ArrayList<IMedico> getMedicosBD() {
		return medicosBD;
	}

	public void setMedicosBD(ArrayList<IMedico> medicosBD) {
		this.medicosBD = medicosBD;
	}


}
