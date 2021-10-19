package modelo;

import java.util.Iterator;
import java.util.TreeSet;
import personas.IMedico;

public class BDdeMedicos {	


    TreeSet<IMedico> medicosBD= new TreeSet<>();

	public BDdeMedicos() {

	}
	
	public void agregarMedico(IMedico medico) {
		medicosBD.add(medico);
	}

	public TreeSet<IMedico> getMedicosBD() {
		return medicosBD;
	}

	public void setMedicosBD(TreeSet<IMedico> medicosBD) {
		this.medicosBD = medicosBD;
	}
}
