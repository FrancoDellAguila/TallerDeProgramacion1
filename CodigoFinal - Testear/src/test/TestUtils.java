package test;

import java.awt.Component;
import java.awt.Container;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.Enumeration;
import java.util.Iterator;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import vista.IVistaMenu;
import vista.IVistaMedico;

/**
 * Clase que ofrece metodos estáticos para ayudar al testeo de GUI utilizando la clase Robot
 */
public class TestUtils

{
    private static int delay = 20;

    /**
     * @param delay atributo estatico que indica la cantidad de milisegundos de espera que usara el Robot.
     */
    public static void setDelay(int delay) {
        TestUtils.delay = delay;
    }

    /**
     * @return devuelve el atributo estatico delay que indica la cantidad de milisegundos de espera que usara el Robot
     */
    public static int getDelay() {
        return delay;
    }

    public static JRadioButton getRadioButtonForNameEspecialidad(ButtonGroup grupo, String name) {
    	JRadioButton retorno = null;
    	String funcion1 = "clinica",funcion2 = "cirugia";
    	Iterator<AbstractButton> it = grupo.getElements().asIterator();
    	if (name.compareTo(funcion1)==0)
    		retorno = (JRadioButton) it.next();
    	else {
    		it.next();
    		if (name.compareTo(funcion2)==0)
    			retorno = (JRadioButton) it.next();
    		else {
    			it.next();
    			retorno = (JRadioButton) it.next();
    		}
    	}
    	return retorno;
    }
    
    public static JRadioButton getRadioButtonForNameContratacion(ButtonGroup grupo, String name) {
    	JRadioButton retorno = null;
    	String funcion = "permanente";
    	Iterator<AbstractButton> it = grupo.getElements().asIterator();
    	if (name.compareTo(funcion) == 0)
    		retorno = (JRadioButton) it.next();
    	else {
    		it.next();
    		retorno = (JRadioButton) it.next();
    	}
    	return retorno;
    }
   
    public static JRadioButton getRadioButtonForNamePosgrado(ButtonGroup grupo, String name) {
    	JRadioButton retorno = null;
    	String funcion1 = "ninguno",funcion2 = "magister";
    	Iterator<AbstractButton> it = grupo.getElements().asIterator();
    	if (name.compareTo(funcion1)==0)
    		retorno = (JRadioButton) it.next();
    	else {
    		it.next();
    		if (name.compareTo(funcion2)==0)
    			retorno = (JRadioButton) it.next();
    		else {
    			it.next();
    			retorno = (JRadioButton) it.next();
    		}
    	}
    	return retorno;
    }
    

    /**
     * Metodo que devuelve el punto central de un componente
     * @param componente Componente del que se quiere obtener el punto central
     * @return Punto central del componente requerido.
     */
    public static Point getCentro(Component componente) {
        Point retorno = null;
        if (componente != null)
            retorno = componente.getLocationOnScreen();
        retorno.x += componente.getWidth() / 2;
        retorno.y += componente.getHeight() / 2;
        return retorno;
    }

    /**MEtodo que hace click en un componente utilizando la clase Robot
     * @param component Componente sobre el que se quiere hacer click
     * @param robot Referencia al Robot que se utilizará
     */
    public static void clickComponent(Component component, Robot robot) {
        Point punto = TestUtils.getCentro(component);
        robot.mouseMove(punto.x, punto.y);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(getDelay());
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
        robot.delay(getDelay());
    }

    /**
     * Metodo que tipea un texto utilizando la clase Robot.
     * Solo se aplica a textos que contengan letras de la 'a' a la 'z', tanto mayusculas como minusculas. 
     * @param texto Texto que se desea tipear. Debera contener solamente letras de la 'a' a la 'z', tanto mayusculas como minusculas. 
     * @param robot Referencia al Robot que se utilizará
     */
    public static void tipeaTexto(String texto, Robot robot) {
        String mayusculas = texto.toUpperCase();
        char letras[] = mayusculas.toCharArray();
        for (int i = 0; i < letras.length; i++)
        {
            robot.delay(getDelay());
            if (texto.charAt(i) >= 'A' && texto.charAt(i) <= 'Z')
                robot.keyPress(KeyEvent.VK_SHIFT);
            robot.keyPress(letras[i]);
            robot.delay(getDelay());
            robot.keyRelease(letras[i]);
            if (texto.charAt(i) >= 'A' && texto.charAt(i) <= 'Z')
                robot.keyRelease(KeyEvent.VK_SHIFT);

        }
    }

    /**
     * Borra el texto de un JTextField simulando el pulsado de la tecla 'Delete' utilizando la clase Robot
     * @param jtextfield JTextField al que se desea borrar su texto
     * @param robot Referencia al Robot que se utilizará
     */
    public static void borraJTextField(JTextField jtextfield, Robot robot) {
        Point punto = null;
        if (jtextfield != null)
        {
            robot.delay(getDelay());
            punto = jtextfield.getLocationOnScreen();
            robot.mouseMove(punto.x, punto.y);
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.delay(getDelay());
            robot.mouseRelease(InputEvent.BUTTON1_MASK);
            robot.delay(getDelay());
            while (!jtextfield.getText().isEmpty())
            {
                robot.delay(getDelay());
                robot.keyPress(KeyEvent.VK_DELETE);
                robot.delay(getDelay());
                robot.keyRelease(KeyEvent.VK_DELETE);
            }
        }
    }
}
