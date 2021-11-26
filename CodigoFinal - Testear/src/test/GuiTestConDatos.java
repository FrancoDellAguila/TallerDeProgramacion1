package test;

import java.awt.AWTException;
import java.awt.Component;
import java.awt.Robot;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import controlador.Controlador_Medicos;
import controlador.Controlador_Menu;
import decorators.IMedico;
import excepciones.PacienteYaExisteException;
import modelo.Clinica;
import modelo.Medico;
import modelo.Paciente;
import util.Mensajes;

public class GuiTestConDatos {
    Robot robot;
    Controlador_Medicos controlador;
    Controlador_Menu controladorMenu;
    FalsoOptionPane op = new FalsoOptionPane();
    
    public GuiTestConDatos()
    {
        try
        {
            robot = new Robot();
        } catch (AWTException e)
        {
        }
    }

    @Before
    public void setUp() throws Exception
    {
        controlador = new Controlador_Medicos();
        controladorMenu = new Controlador_Menu();
        controlador.setOp(op);
        Clinica.getInstance().addMedico(new Medico("30303030", "aaa", "bbb", "ccc", "ddd", "19999999",1));
		Clinica.getInstance().addMedico(new Medico("30303030", "aaa", "bbb", "ccc", "ddd", "19999999", 4));
		Clinica.getInstance().addMedico(new Medico("40404040", "aaa", "bbb", "ccc", "ddd", "19999999", 3));
		Clinica.getInstance().addMedico(new Medico("20202020", "aaa", "bbb", "ccc", "ddd", "19999999", 2));
    }

    @After
    public void tearDown() throws Exception
    {
        controlador.getVista().setVisible(false);
    }
    
    @Test
    public void testCantidad()
    {
        Assert.assertEquals("Debe haber 4 usuarios registrados", 4, Clinica.getInstance().getMedicos().size());
    }
    
    @Test
    public void testBorraMedico()
    {
    	robot.delay(TestUtils.getDelay());
    	//obtengo las referencias a los componentes necesarios
    	JButton abrirMedicos = controladorMenu.getVista().getBtnMedicos();
    	JList<IMedico> listmedicos = controlador.getVista().getListMedicos();
    	
    	JButton agregar = controlador.getVista().getBtnAgregar();
        JButton eliminar = controlador.getVista().getBtnEliminar();
        
        TestUtils.clickComponent(abrirMedicos, robot);
        robot.delay(TestUtils.getDelay());

        TestUtils.clickComponent(listmedicos, robot);
        TestUtils.clickComponent(eliminar, robot);

        Assert.assertEquals("Debería haber un elemento menos que antes", 3, Clinica.getInstance().getMedicos().size());
    }
    
    @Test
    public void testAgregarCompleto()
    {
        robot.delay(TestUtils.getDelay());
        //obtengo las referencias a los componentes necesarios
        JButton abrirMedicos = controladorMenu.getVista().getBtnMedicos();
        JTextField nombre = controlador.getVista().getTextFieldNombre();
        JTextField apellido = controlador.getVista().getTextFieldApellido();
        JTextField dni = controlador.getVista().getTextFieldDni();
        JTextField domicilio = controlador.getVista().getTextFieldDomicilio();
        JTextField ciudad = controlador.getVista().getTextFieldCiudad();
        JTextField telefono = controlador.getVista().getTextFieldTelefono();
        JTextField matricula = controlador.getVista().getTextFieldMatricula();
        
        ButtonGroup especialidad = controlador.getVista().getGrupoEspecialidad();
        ButtonGroup contratacion = controlador.getVista().getGrupoContratacion();
        ButtonGroup posgrado = controlador.getVista().getGrupoPosgrado();
        JRadioButton clinica = (JRadioButton) TestUtils.getRadioButtonForNameEspecialidad(especialidad,"clinica");
        JRadioButton permanente = (JRadioButton) TestUtils.getRadioButtonForNameContratacion(contratacion,"residente");
        JRadioButton ninguno = (JRadioButton) TestUtils.getRadioButtonForNamePosgrado(posgrado,"ninguno");
        
        JButton agregar = controlador.getVista().getBtnAgregar();
        //lleno los JTextField
        TestUtils.clickComponent(abrirMedicos, robot);
        robot.delay(TestUtils.getDelay());
        especialidad.clearSelection();
        TestUtils.clickComponent(clinica, robot);
        contratacion.clearSelection();
        TestUtils.clickComponent(permanente, robot);
        posgrado.clearSelection();
        TestUtils.clickComponent(ninguno, robot);
        TestUtils.clickComponent(nombre, robot);
        TestUtils.tipeaTexto("Guille", robot);
        TestUtils.clickComponent(apellido, robot);
        TestUtils.tipeaTexto("Guccione", robot);
        TestUtils.clickComponent(dni, robot);
        TestUtils.tipeaTexto("12345678", robot);
        TestUtils.clickComponent(domicilio, robot);
        TestUtils.tipeaTexto("juanBjusto", robot);
        TestUtils.clickComponent(ciudad, robot);
        TestUtils.tipeaTexto("Mar del Plata", robot);
        TestUtils.clickComponent(telefono, robot);
        TestUtils.tipeaTexto("2235678912", robot);
        TestUtils.clickComponent(matricula, robot);
        TestUtils.tipeaTexto("123", robot);
        //verifico los resultados
        
        TestUtils.clickComponent(agregar, robot);
        Assert.assertEquals("Debería haber un elemento mas que antes", 5, Clinica.getInstance().getMedicos().size());
    }
    
    
    @Test
    public void testCompletoErrorDni()
    {
        robot.delay(TestUtils.getDelay());
        //obtengo las referencias a los componentes necesarios
        JButton abrirMedicos = controladorMenu.getVista().getBtnMedicos();
        JTextField nombre = controlador.getVista().getTextFieldNombre();
        JTextField apellido = controlador.getVista().getTextFieldApellido();
        JTextField dni = controlador.getVista().getTextFieldDni();
        JTextField domicilio = controlador.getVista().getTextFieldDomicilio();
        JTextField ciudad = controlador.getVista().getTextFieldCiudad();
        JTextField telefono = controlador.getVista().getTextFieldTelefono();
        JTextField matricula = controlador.getVista().getTextFieldMatricula();
        
        ButtonGroup especialidad = controlador.getVista().getGrupoEspecialidad();
        ButtonGroup contratacion = controlador.getVista().getGrupoContratacion();
        ButtonGroup posgrado = controlador.getVista().getGrupoPosgrado();
        JRadioButton clinica = (JRadioButton) TestUtils.getRadioButtonForNameEspecialidad(especialidad,"clinica");
        JRadioButton permanente = (JRadioButton) TestUtils.getRadioButtonForNameContratacion(contratacion,"residente");
        JRadioButton ninguno = (JRadioButton) TestUtils.getRadioButtonForNamePosgrado(posgrado,"ninguno");
        
        JButton agregar = controlador.getVista().getBtnAgregar();
        //lleno los JTextField
        TestUtils.clickComponent(abrirMedicos, robot);
        robot.delay(TestUtils.getDelay());
        especialidad.clearSelection();
        TestUtils.clickComponent(clinica, robot);
        contratacion.clearSelection();
        TestUtils.clickComponent(permanente, robot);
        posgrado.clearSelection();
        TestUtils.clickComponent(ninguno, robot);
        TestUtils.clickComponent(nombre, robot);
        TestUtils.tipeaTexto("Guille", robot);
        TestUtils.clickComponent(apellido, robot);
        TestUtils.tipeaTexto("Guccione", robot);
        TestUtils.clickComponent(dni, robot);
        TestUtils.tipeaTexto("123456", robot);
        TestUtils.clickComponent(domicilio, robot);
        TestUtils.tipeaTexto("juanBjusto", robot);
        TestUtils.clickComponent(ciudad, robot);
        TestUtils.tipeaTexto("Mar del Plata", robot);
        TestUtils.clickComponent(telefono, robot);
        TestUtils.tipeaTexto("2235678912", robot);
        TestUtils.clickComponent(matricula, robot);
        TestUtils.tipeaTexto("123", robot);
        
        TestUtils.clickComponent(agregar, robot);
        //verifico los resultados
        Assert.assertEquals("No se deberia agregar", 4, Clinica.getInstance().getMedicos().size());
    }
    
    @Test
    public void testErrorMatricula()
    {
    	robot.delay(TestUtils.getDelay());
    	//obtengo las referencias a los componentes necesarios
        JButton abrirMedicos = controladorMenu.getVista().getBtnMedicos();
        JTextField nombre = controlador.getVista().getTextFieldNombre();
        JTextField apellido = controlador.getVista().getTextFieldApellido();
        JTextField dni = controlador.getVista().getTextFieldDni();
        JTextField domicilio = controlador.getVista().getTextFieldDomicilio();
        JTextField ciudad = controlador.getVista().getTextFieldCiudad();
        JTextField telefono = controlador.getVista().getTextFieldTelefono();
        JTextField matricula = controlador.getVista().getTextFieldMatricula();
        
        ButtonGroup especialidad = controlador.getVista().getGrupoEspecialidad();
        ButtonGroup contratacion = controlador.getVista().getGrupoContratacion();
        ButtonGroup posgrado = controlador.getVista().getGrupoPosgrado();
        JRadioButton clinica = (JRadioButton) TestUtils.getRadioButtonForNameEspecialidad(especialidad,"clinica");
        JRadioButton permanente = (JRadioButton) TestUtils.getRadioButtonForNameContratacion(contratacion,"residente");
        JRadioButton ninguno = (JRadioButton) TestUtils.getRadioButtonForNamePosgrado(posgrado,"ninguno");
        
        JButton agregar = controlador.getVista().getBtnAgregar();
        //lleno los JTextField
        TestUtils.clickComponent(abrirMedicos, robot);
        robot.delay(TestUtils.getDelay());
        especialidad.clearSelection();
        TestUtils.clickComponent(clinica, robot);
        contratacion.clearSelection();
        TestUtils.clickComponent(permanente, robot);
        posgrado.clearSelection();
        TestUtils.clickComponent(ninguno, robot);
        TestUtils.clickComponent(nombre, robot);
        TestUtils.tipeaTexto("Guille", robot);
        TestUtils.clickComponent(apellido, robot);
        TestUtils.tipeaTexto("Guccione", robot);
        TestUtils.clickComponent(dni, robot);
        TestUtils.tipeaTexto("12345678", robot);
        TestUtils.clickComponent(domicilio, robot);
        TestUtils.tipeaTexto("juanBjusto", robot);
        TestUtils.clickComponent(ciudad, robot);
        TestUtils.tipeaTexto("Mar del Plata", robot);
        TestUtils.clickComponent(telefono, robot);
        TestUtils.tipeaTexto("2235678912", robot);
        TestUtils.clickComponent(matricula, robot);
        TestUtils.tipeaTexto("abc", robot);
        
        //verifico los resultados
        TestUtils.clickComponent(agregar, robot);
        
        Assert.assertEquals("Mensaje incorrecto, debería decir "+Mensajes.ERROR_MATRICULA_INCORRECTA.getValor(),Mensajes.ERROR_MATRICULA_INCORRECTA.getValor(),op.getMensaje());
    }
}
