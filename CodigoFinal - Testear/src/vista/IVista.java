package vista;

import java.awt.event.ActionListener;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
/**
 * @author Betti Francisco, Kollman Deborah, Stimmler Francisco, Veitch Matias
 *<br>
 *Interfaz de uso general de todas las ventanas
 */
public interface IVista{
	void addActionListener(ActionListener listener);
	void addWindowListener(WindowListener windowListener);
}
