package modelo;

import java.util.ArrayList;

import personas.Medico;

public class BDdeMedicos {	


    ArrayList<IMedico> medicosBD = new ArrayList<IMedico>();

	public BDdeMedicos() {

	}
	
	/**Se agrega un m�dico al arreglo medicosBD
	 * <b> Pre: medico es distinto de null.</b>
	 * <b> Post: Se agreg� un m�dico al arreglo medicosBD.</b>
	 * @param medico:Parametro de tipo Imedico.
	 */
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
