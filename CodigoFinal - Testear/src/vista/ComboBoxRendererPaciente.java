package vista;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;


import modelo.Paciente;
/**
 * @author Betti Francisco, Kollman Deborah, Stimmler Francisco, Veitch Matias
 *<br>
 *Clase creada para que el comboBox de Pacientes muestre distinto al toString de asociados. extiende de JLabel e implementa ListCellRenderer.
 */
class ComboBoxRendererPaciente extends JLabel implements ListCellRenderer {

	@Override
	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
			boolean cellHasFocus) {
		
		Paciente selectedIndex = (Paciente) value;

        if (isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }
        if(selectedIndex!=null)
        	setText(selectedIndex.mostrarMinimo());
        
		return this;
	}
}
