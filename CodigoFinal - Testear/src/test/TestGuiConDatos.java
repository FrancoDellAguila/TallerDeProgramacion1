package test;

import controlador.Controlador_Medicos;
import controlador.Controlador_Menu;
import decorators.IMedico;
import modelo.Clinica;
import modelo.Medico;
import util.Mensajes;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestGuiConDatos
{
    Robot robot;
    Controlador_Medicos controlador;
    Controlador_Menu controladorMenu;
    FalsoOptionPane op = new FalsoOptionPane();
    
    public TestGuiConDatos()
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
    	Clinica.getInstance().addMedico(new Medico("30303030", "aaa", "bbb", "ccc", "ddd", "19999999",1));
		Clinica.getInstance().addMedico(new Medico("30303030", "aaa", "bbb", "ccc", "ddd", "19999999", 4));
		Clinica.getInstance().addMedico(new Medico("40404040", "aaa", "bbb", "ccc", "ddd", "19999999", 3));
		Clinica.getInstance().addMedico(new Medico("20202020", "aaa", "bbb", "ccc", "ddd", "19999999", 2));
        controladorMenu = new Controlador_Menu();
        controlador = new Controlador_Medicos();
        controlador.setOp(op);
        JButton abrirMedicos = controladorMenu.getVista().getBtnMedicos();
        TestUtils.clickComponent(abrirMedicos, robot);
    }

    @After
    public void tearDown() throws Exception
    {
        controlador.getVista().setVisible(false);
    }

   
    @Test
    public void testCantidad()
    {
        Assert.assertEquals("Debe haber 4 m?dicos registrados", 4, Clinica.getInstance().getMedicos().size());
    }
    
    @Test
    public void testBorraMedico()
    {
    	robot.delay(TestUtils.getDelay());
    	//obtengo las referencias a los componentes necesarios
    	
    	JList<IMedico> listmedicos = controlador.getVista().getListMedicos();
    	
    	JButton agregar = controlador.getVista().getBtnAgregar();
        JButton eliminar = controlador.getVista().getBtnEliminar();
        
        
        robot.delay(TestUtils.getDelay());

        TestUtils.clickComponent(listmedicos, robot);
        TestUtils.clickComponent(eliminar, robot);

        Assert.assertEquals("Deber?a haber un elemento menos que antes", 3, Clinica.getInstance().getMedicos().size());
    }
    
    @Test
    public void testAgregarCompleto()
    {
        robot.delay(TestUtils.getDelay());
        //obtengo las referencias a los componentes necesarios
        
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
        Assert.assertEquals("Deber?a haber un elemento mas que antes", 5, Clinica.getInstance().getMedicos().size());
    }
    
    
    @Test
    public void testCompletoErrorDni()
    {
        robot.delay(TestUtils.getDelay());
        //obtengo las referencias a los componentes necesarios
        
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
    public void testCompletoErrorTelefono()
    {
        robot.delay(TestUtils.getDelay());
        //obtengo las referencias a los componentes necesarios
        
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
        JButton eliminar = controlador.getVista().getBtnEliminar();
        //lleno los JTextField
        
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
        TestUtils.tipeaTexto("1234567", robot);
        TestUtils.clickComponent(domicilio, robot);
        TestUtils.tipeaTexto("juanBjusto", robot);
        TestUtils.clickComponent(ciudad, robot);
        TestUtils.tipeaTexto("Mar del Plata", robot);
        TestUtils.clickComponent(telefono, robot);
        TestUtils.tipeaTexto("223", robot);
        TestUtils.clickComponent(matricula, robot);
        TestUtils.tipeaTexto("123", robot);
        //verifico los resultados
        TestUtils.clickComponent(agregar, robot);
        //verifico los resultados
        Assert.assertEquals("No se deberia agregar", 4, Clinica.getInstance().getMedicos().size());
    }
    
    @Test
    public void testErrorMatricula()
    {
    	robot.delay(TestUtils.getDelay());
    	//obtengo las referencias a los componentes necesarios
        
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
        
        JButton eliminar = controlador.getVista().getBtnEliminar();
        JButton agregar = controlador.getVista().getBtnAgregar();
        //lleno los JTextField
        
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
        Assert.assertEquals("Mensaje incorrecto, deber?a decir "+Mensajes.ERROR_MATRICULA_INCORRECTA.getValor(),Mensajes.ERROR_MATRICULA_INCORRECTA.getValor(),op.getMensaje());
        Assert.assertEquals("No se deberia agregar", 4, Clinica.getInstance().getMedicos().size());
        robot.keyPress(KeyEvent.VK_ENTER);
    }
    
    
}
