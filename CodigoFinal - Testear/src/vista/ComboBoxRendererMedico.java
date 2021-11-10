package vista;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import decorators.IMedico;
/**
 * @author Betti Francisco, Kollman Deborah, Stimmler Francisco, Veitch Matias
 *<br>
 *Clase creada para que el comboBox de medicos muestre distinto al toString de asociados. extiende de JLabel e implementa ListCellRenderer.
 */
class ComboBoxRendererMedico extends JLabel implements ListCellRenderer {

	@Override
	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
			boolean cellHasFocus) {
		
		IMedico selectedIndex = (IMedico) value;

        if (isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }
        if(selectedIndex!=null)
        	setText("N°"+selectedIndex.getNroMatricula()+" "+selectedIndex.getNombre());
        
		return this;
	}
}
