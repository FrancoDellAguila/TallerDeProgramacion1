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

public class GuiTestEnabledDisabled
{
    Robot robot;
    Controlador_Medicos controlador;
    Controlador_Menu controladorMenu;

    public GuiTestEnabledDisabled()
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
    	//Clinica.getInstance().addMedico(new Medico("30303030", "aaa", "bbb", "ccc", "ddd", "19999999",1));
        controladorMenu = new Controlador_Menu();
        controlador = new Controlador_Medicos();
        JButton abrirMedicos = controladorMenu.getVista().getBtnMedicos();
        TestUtils.clickComponent(abrirMedicos, robot);
    }

    @After
    public void tearDown() throws Exception
    {
        controlador.getVista().setVisible(false);
    }

    @Test
    public void testVacio()
    {
        robot.delay(TestUtils.getDelay());
        //obtengo las referencias a los componentes necesarios
        JButton agregar = controlador.getVista().getBtnAgregar();
        JButton eliminar = controlador.getVista().getBtnEliminar();

        robot.delay(TestUtils.getDelay());   robot.delay(TestUtils.getDelay());robot.delay(TestUtils.getDelay());robot.delay(TestUtils.getDelay());robot.delay(TestUtils.getDelay());robot.delay(TestUtils.getDelay());robot.delay(TestUtils.getDelay());robot.delay(TestUtils.getDelay());robot.delay(TestUtils.getDelay());robot.delay(TestUtils.getDelay());robot.delay(TestUtils.getDelay());robot.delay(TestUtils.getDelay());robot.delay(TestUtils.getDelay());robot.delay(TestUtils.getDelay());robot.delay(TestUtils.getDelay());robot.delay(TestUtils.getDelay());robot.delay(TestUtils.getDelay());robot.delay(TestUtils.getDelay());robot.delay(TestUtils.getDelay());robot.delay(TestUtils.getDelay());robot.delay(TestUtils.getDelay());robot.delay(TestUtils.getDelay());robot.delay(TestUtils.getDelay());robot.delay(TestUtils.getDelay());robot.delay(TestUtils.getDelay());robot.delay(TestUtils.getDelay());robot.delay(TestUtils.getDelay());
        //verifico los resultados
        Assert.assertFalse("El boton de registro deberia estar deshablitado", agregar.isEnabled());
        Assert.assertFalse("El boton de eliminar deberia estar deshablitado", eliminar.isEnabled());
    }

    @Test
    public void testSoloNombre()
    {
        robot.delay(TestUtils.getDelay());
        //obtengo las referencias a los componentes necesarios
        
        JTextField nombre = controlador.getVista().getTextFieldNombre();
        JButton agregar = controlador.getVista().getBtnAgregar();
        JButton eliminar = controlador.getVista().getBtnEliminar();
        //lleno los JTextField
        
        robot.delay(TestUtils.getDelay());        
        TestUtils.clickComponent(nombre, robot);
        TestUtils.tipeaTexto("Guille", robot);
        //verifico los resultados
        Assert.assertFalse("El boton de registro deberia estar deshablitado", agregar.isEnabled());
        Assert.assertFalse("El boton de eliminar deberia estar deshablitado", eliminar.isEnabled());
        
    }
    
    
    @Test
    public void testSoloApellido()
    {
        robot.delay(TestUtils.getDelay());
        //obtengo las referencias a los componentes necesarios
        
        JTextField apellido = controlador.getVista().getTextFieldApellido();
        JButton agregar = controlador.getVista().getBtnAgregar();
        JButton eliminar = controlador.getVista().getBtnEliminar();
        //lleno los JTextField
        
        robot.delay(TestUtils.getDelay());
        TestUtils.clickComponent(apellido, robot);
        TestUtils.tipeaTexto("Lazurri", robot);
        //verifico los resultados
        Assert.assertFalse("El boton de registro deberia estar deshablitado", agregar.isEnabled());
        Assert.assertFalse("El boton de eliminar deberia estar deshablitado", eliminar.isEnabled());
        
    }
    
    @Test
    public void testSoloDni()
    {
        robot.delay(TestUtils.getDelay());
        //obtengo las referencias a los componentes necesarios
        
        JTextField dni = controlador.getVista().getTextFieldDni();
        JButton agregar = controlador.getVista().getBtnAgregar();
        JButton eliminar = controlador.getVista().getBtnEliminar();
        //lleno los JTextField
        
        robot.delay(TestUtils.getDelay());
        TestUtils.clickComponent(dni, robot);
        TestUtils.tipeaTexto("12345678", robot);
        //verifico los resultados
        Assert.assertFalse("El boton de registro deberia estar deshablitado", agregar.isEnabled());
        Assert.assertFalse("El boton de eliminar deberia estar deshablitado", eliminar.isEnabled());
    }
    
    @Test
    public void testSoloDomicilio()
    {
        robot.delay(TestUtils.getDelay());
        //obtengo las referencias a los componentes necesarios
        
        JTextField domicilio = controlador.getVista().getTextFieldDomicilio();
        JButton agregar = controlador.getVista().getBtnAgregar();
        JButton eliminar = controlador.getVista().getBtnEliminar();
        //lleno los JTextField
        
        robot.delay(TestUtils.getDelay());
        TestUtils.clickComponent(domicilio, robot);
        TestUtils.tipeaTexto("JuanBJusto", robot);
        //verifico los resultados
        Assert.assertFalse("El boton de registro deberia estar deshablitado", agregar.isEnabled());
        Assert.assertFalse("El boton de eliminar deberia estar deshablitado", eliminar.isEnabled());
    }
    
    @Test
    public void testSoloCiudad()
    {
        robot.delay(TestUtils.getDelay());
        //obtengo las referencias a los componentes necesarios
        
        JTextField ciudad = controlador.getVista().getTextFieldCiudad();
        JButton agregar = controlador.getVista().getBtnAgregar();
        JButton eliminar = controlador.getVista().getBtnEliminar();
        //lleno los JTextField
        
        robot.delay(TestUtils.getDelay());
        TestUtils.clickComponent(ciudad, robot);
        TestUtils.tipeaTexto("Mar del Plata", robot);
        //verifico los resultados
        Assert.assertFalse("El boton de registro deberia estar deshablitado", agregar.isEnabled());
        Assert.assertFalse("El boton de eliminar deberia estar deshablitado", eliminar.isEnabled());
    }
    
    @Test
    public void testSoloTelefono()
    {
        robot.delay(TestUtils.getDelay());
        //obtengo las referencias a los componentes necesarios
        
        JTextField telefono = controlador.getVista().getTextFieldTelefono();
        JButton agregar = controlador.getVista().getBtnAgregar();
        JButton eliminar = controlador.getVista().getBtnEliminar();
        //lleno los JTextField
        
        robot.delay(TestUtils.getDelay());
        TestUtils.clickComponent(telefono, robot);
        TestUtils.tipeaTexto("2235678912", robot);
        //verifico los resultados
        Assert.assertFalse("El boton de registro deberia estar deshablitado", agregar.isEnabled());
        Assert.assertFalse("El boton de eliminar deberia estar deshablitado", eliminar.isEnabled());
    }
    
    @Test
    public void testSoloMatricula()
    {
        robot.delay(TestUtils.getDelay());
        //obtengo las referencias a los componentes necesarios
        
        JTextField matricula = controlador.getVista().getTextFieldMatricula();
        JButton agregar = controlador.getVista().getBtnAgregar();
        JButton eliminar = controlador.getVista().getBtnEliminar();
        //lleno los JTextField
        
        robot.delay(TestUtils.getDelay());
        TestUtils.clickComponent(matricula, robot);
        TestUtils.tipeaTexto("123", robot);
        //verifico los resultados
        Assert.assertFalse("El boton de registro deberia estar deshablitado", agregar.isEnabled());
        Assert.assertFalse("El boton de eliminar deberia estar deshablitado", eliminar.isEnabled());
    }
    
    @Test
    public void testSoloClinica()
    {
        robot.delay(TestUtils.getDelay());
        //obtengo las referencias a los componentes necesarios
        
        ButtonGroup especialidad = controlador.getVista().getGrupoEspecialidad();
        
        JRadioButton clinica = (JRadioButton) TestUtils.getRadioButtonForNameEspecialidad(especialidad,"clinica");
        JButton agregar = controlador.getVista().getBtnAgregar();
        JButton eliminar = controlador.getVista().getBtnEliminar();
        //lleno los JTextField
        especialidad.clearSelection();
        TestUtils.clickComponent(clinica, robot);
        //verifico los resultados
        Assert.assertFalse("El boton de registro deberia estar deshablitado", agregar.isEnabled());
        Assert.assertFalse("El boton de eliminar deberia estar deshablitado", eliminar.isEnabled());
    }
    
    @Test
    public void testSoloCirugia()
    {
        robot.delay(TestUtils.getDelay());
        //obtengo las referencias a los componentes necesarios
        
        ButtonGroup especialidad = controlador.getVista().getGrupoEspecialidad();
        JRadioButton cirugia = (JRadioButton) TestUtils.getRadioButtonForNameEspecialidad(especialidad,"cirugia");
        JButton agregar = controlador.getVista().getBtnAgregar();
        JButton eliminar = controlador.getVista().getBtnEliminar();
        //lleno los JTextField
        
        robot.delay(TestUtils.getDelay());
        especialidad.clearSelection();
        TestUtils.clickComponent(cirugia, robot);
        //verifico los resultados
        Assert.assertFalse("El boton de registro deberia estar deshablitado", agregar.isEnabled());
        Assert.assertFalse("El boton de eliminar deberia estar deshablitado", eliminar.isEnabled());
    }
    
    @Test
    public void testSoloPediatria()
    {
        robot.delay(TestUtils.getDelay());
        //obtengo las referencias a los componentes necesarios
        
        ButtonGroup especialidad = controlador.getVista().getGrupoEspecialidad();
        JRadioButton pediatria = (JRadioButton) TestUtils.getRadioButtonForNameEspecialidad(especialidad,"pediatria");
        JButton agregar = controlador.getVista().getBtnAgregar();
        JButton eliminar = controlador.getVista().getBtnEliminar();
        //lleno los JTextField
        
        robot.delay(TestUtils.getDelay());
        especialidad.clearSelection();
        TestUtils.clickComponent(pediatria, robot);
        //verifico los resultados
        Assert.assertFalse("El boton de registro deberia estar deshablitado", agregar.isEnabled());
        Assert.assertFalse("El boton de eliminar deberia estar deshablitado", eliminar.isEnabled());
    }
    
    @Test
    public void testSoloPermanente()
    {
        robot.delay(TestUtils.getDelay());
        //obtengo las referencias a los componentes necesarios
        
        ButtonGroup contratacion = controlador.getVista().getGrupoContratacion();
        JRadioButton permanente = (JRadioButton) TestUtils.getRadioButtonForNameContratacion(contratacion,"permanente");
        JButton agregar = controlador.getVista().getBtnAgregar();
        JButton eliminar = controlador.getVista().getBtnEliminar();
        //lleno los JTextField
        
        robot.delay(TestUtils.getDelay());
        contratacion.clearSelection();
        TestUtils.clickComponent(permanente, robot);
        //verifico los resultados
        Assert.assertFalse("El boton de registro deberia estar deshablitado", agregar.isEnabled());
        Assert.assertFalse("El boton de eliminar deberia estar deshablitado", eliminar.isEnabled());
    }
    
    @Test
    public void testSoloResidente()
    {
        robot.delay(TestUtils.getDelay());
        //obtengo las referencias a los componentes necesarios
        
        ButtonGroup contratacion = controlador.getVista().getGrupoContratacion();
        JRadioButton residente = (JRadioButton) TestUtils.getRadioButtonForNameContratacion(contratacion,"residente");
        JButton agregar = controlador.getVista().getBtnAgregar();
        JButton eliminar = controlador.getVista().getBtnEliminar();
        //lleno los JTextField
        
        robot.delay(TestUtils.getDelay());
        contratacion.clearSelection();
        TestUtils.clickComponent(residente, robot);
        //verifico los resultados
        Assert.assertFalse("El boton de registro deberia estar deshablitado", agregar.isEnabled());
        Assert.assertFalse("El boton de eliminar deberia estar deshablitado", eliminar.isEnabled());
    }
    
    @Test
    public void testSoloNinguno()
    {
        robot.delay(TestUtils.getDelay());
        //obtengo las referencias a los componentes necesarios
        
        ButtonGroup posgrado = controlador.getVista().getGrupoPosgrado();
        JRadioButton ninguno = (JRadioButton) TestUtils.getRadioButtonForNamePosgrado(posgrado,"ninguno");
        JButton agregar = controlador.getVista().getBtnAgregar();
        JButton eliminar = controlador.getVista().getBtnEliminar();
        //lleno los JTextField
        
        robot.delay(TestUtils.getDelay());
        posgrado.clearSelection();
        TestUtils.clickComponent(ninguno, robot);
        //verifico los resultados
        Assert.assertFalse("El boton de registro deberia estar deshablitado", agregar.isEnabled());
        Assert.assertFalse("El boton de eliminar deberia estar deshablitado", eliminar.isEnabled());
    }
    
    @Test
    public void testSoloMagister()
    {
        robot.delay(TestUtils.getDelay());
        //obtengo las referencias a los componentes necesarios
        
        ButtonGroup posgrado = controlador.getVista().getGrupoPosgrado();
        JRadioButton magister = (JRadioButton) TestUtils.getRadioButtonForNamePosgrado(posgrado,"magister");
        JButton agregar = controlador.getVista().getBtnAgregar();
        JButton eliminar = controlador.getVista().getBtnEliminar();
        //lleno los JTextField
        
        robot.delay(TestUtils.getDelay());
        posgrado.clearSelection();
        TestUtils.clickComponent(magister, robot);
        //verifico los resultados
        Assert.assertFalse("El boton de registro deberia estar deshablitado", agregar.isEnabled());
        Assert.assertFalse("El boton de eliminar deberia estar deshablitado", eliminar.isEnabled());
    }    
    
    @Test
    public void testSoloDoctor()
    {
        robot.delay(TestUtils.getDelay());
        //obtengo las referencias a los componentes necesarios
        
        ButtonGroup posgrado = controlador.getVista().getGrupoPosgrado();
        JRadioButton doctor = (JRadioButton) TestUtils.getRadioButtonForNamePosgrado(posgrado,"doctor");
        JButton agregar = controlador.getVista().getBtnAgregar();
        JButton eliminar = controlador.getVista().getBtnEliminar();
        //lleno los JTextField
        
        robot.delay(TestUtils.getDelay());
        posgrado.clearSelection();
        TestUtils.clickComponent(doctor, robot);
        //verifico los resultados
        Assert.assertFalse("El boton de registro deberia estar deshablitado", agregar.isEnabled());
        Assert.assertFalse("El boton de eliminar deberia estar deshablitado", eliminar.isEnabled());
    }   
    
    @Test
    public void testNombreApellido()
    {
        robot.delay(TestUtils.getDelay());
        //obtengo las referencias a los componentes necesarios
        
        JTextField nombre = controlador.getVista().getTextFieldNombre();
        JTextField apellido = controlador.getVista().getTextFieldApellido();
        JButton agregar = controlador.getVista().getBtnAgregar();
        JButton eliminar = controlador.getVista().getBtnEliminar();
        //lleno los JTextField
        
        robot.delay(TestUtils.getDelay());
        TestUtils.clickComponent(nombre, robot);
        TestUtils.tipeaTexto("Guille", robot);
        TestUtils.clickComponent(apellido, robot);
        TestUtils.tipeaTexto("Lazurri", robot);
        //verifico los resultados
        Assert.assertFalse("El boton de registro deberia estar deshablitado", agregar.isEnabled());
        Assert.assertFalse("El boton de eliminar deberia estar deshablitado", eliminar.isEnabled());
    }
    
    @Test
    public void testNombreDni()
    {
        robot.delay(TestUtils.getDelay());
        //obtengo las referencias a los componentes necesarios
        
        JTextField nombre = controlador.getVista().getTextFieldNombre();
        JTextField dni = controlador.getVista().getTextFieldDni();
        JButton agregar = controlador.getVista().getBtnAgregar();
        JButton eliminar = controlador.getVista().getBtnEliminar();
        //lleno los JTextField
        
        robot.delay(TestUtils.getDelay());
        TestUtils.clickComponent(nombre, robot);
        TestUtils.tipeaTexto("Guille", robot);
        TestUtils.clickComponent(dni, robot);
        TestUtils.tipeaTexto("12345678", robot);
        //verifico los resultados
        Assert.assertFalse("El boton de registro deberia estar deshablitado", agregar.isEnabled());
        Assert.assertFalse("El boton de eliminar deberia estar deshablitado", eliminar.isEnabled());
    }
    
    @Test
    public void testNombreDomicilio()
    {
        robot.delay(TestUtils.getDelay());
        //obtengo las referencias a los componentes necesarios
        
        JTextField nombre = controlador.getVista().getTextFieldNombre();
        JTextField domicilio = controlador.getVista().getTextFieldDomicilio();
        JButton agregar = controlador.getVista().getBtnAgregar();
        JButton eliminar = controlador.getVista().getBtnEliminar();
        //lleno los JTextField
        
        robot.delay(TestUtils.getDelay());
        TestUtils.clickComponent(nombre, robot);
        TestUtils.tipeaTexto("Guille", robot);
        TestUtils.clickComponent(domicilio, robot);
        TestUtils.tipeaTexto("juanBjusto", robot);
        //verifico los resultados
        Assert.assertFalse("El boton de registro deberia estar deshablitado", agregar.isEnabled());
        Assert.assertFalse("El boton de eliminar deberia estar deshablitado", eliminar.isEnabled());
    }
    
    @Test
    public void testNombreCiudad()
    {
        robot.delay(TestUtils.getDelay());
        //obtengo las referencias a los componentes necesarios
        
        JTextField nombre = controlador.getVista().getTextFieldNombre();
        JTextField ciudad = controlador.getVista().getTextFieldCiudad();
        JButton agregar = controlador.getVista().getBtnAgregar();
        JButton eliminar = controlador.getVista().getBtnEliminar();
        //lleno los JTextField
        
        robot.delay(TestUtils.getDelay());
        TestUtils.clickComponent(nombre, robot);
        TestUtils.tipeaTexto("Guille", robot);
        TestUtils.clickComponent(ciudad, robot);
        TestUtils.tipeaTexto("Mar del Plata", robot);
        //verifico los resultados
        Assert.assertFalse("El boton de registro deberia estar deshablitado", agregar.isEnabled());
        Assert.assertFalse("El boton de eliminar deberia estar deshablitado", eliminar.isEnabled());
    }
    
    @Test
    public void testNombreTelefono()
    {
        robot.delay(TestUtils.getDelay());
        //obtengo las referencias a los componentes necesarios
        
        JTextField nombre = controlador.getVista().getTextFieldNombre();
        JTextField telefono = controlador.getVista().getTextFieldTelefono();
        JButton agregar = controlador.getVista().getBtnAgregar();
        JButton eliminar = controlador.getVista().getBtnEliminar();
        //lleno los JTextField
        
        robot.delay(TestUtils.getDelay());
        TestUtils.clickComponent(nombre, robot);
        TestUtils.tipeaTexto("Guille", robot);
        TestUtils.clickComponent(telefono, robot);
        TestUtils.tipeaTexto("2235678912", robot);
        //verifico los resultados
        Assert.assertFalse("El boton de registro deberia estar deshablitado", agregar.isEnabled());
        Assert.assertFalse("El boton de eliminar deberia estar deshablitado", eliminar.isEnabled());
    }
    
    @Test
    public void testNombreMatricula()
    {
        robot.delay(TestUtils.getDelay());
        //obtengo las referencias a los componentes necesarios
        
        JTextField nombre = controlador.getVista().getTextFieldNombre();
        JTextField matricula = controlador.getVista().getTextFieldMatricula();
        JButton agregar = controlador.getVista().getBtnAgregar();
        JButton eliminar = controlador.getVista().getBtnEliminar();
        //lleno los JTextField
        
        robot.delay(TestUtils.getDelay());
        TestUtils.clickComponent(nombre, robot);
        TestUtils.tipeaTexto("Guille", robot);
        TestUtils.clickComponent(matricula, robot);
        TestUtils.tipeaTexto("123", robot);
        //verifico los resultados
        Assert.assertFalse("El boton de registro deberia estar deshablitado", agregar.isEnabled());
        Assert.assertFalse("El boton de eliminar deberia estar deshablitado", eliminar.isEnabled());
    }
    
    @Test
    public void testCompleto()
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
        Assert.assertTrue("El boton de registro deberia estar hablitado", agregar.isEnabled());
        Assert.assertFalse("El boton de eliminar deberia estar deshablitado", eliminar.isEnabled());
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
        TestUtils.tipeaTexto("123456", robot);
        TestUtils.clickComponent(domicilio, robot);
        TestUtils.tipeaTexto("juanBjusto", robot);
        TestUtils.clickComponent(ciudad, robot);
        TestUtils.tipeaTexto("Mar del Plata", robot);
        TestUtils.clickComponent(telefono, robot);
        TestUtils.tipeaTexto("2235678912", robot);
        TestUtils.clickComponent(matricula, robot);
        TestUtils.tipeaTexto("123", robot);
        //verifico los resultados
        Assert.assertFalse("El boton de registro deberia estar deshablitado", agregar.isEnabled());
        Assert.assertFalse("El boton de eliminar deberia estar deshablitado", eliminar.isEnabled());
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
        Assert.assertFalse("El boton de registro deberia estar deshablitado", agregar.isEnabled());
        Assert.assertFalse("El boton de eliminar deberia estar deshablitado", eliminar.isEnabled());
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
        Assert.assertTrue("El boton de agregar deberia estar habilitado", agregar.isEnabled());
        Assert.assertFalse("El boton de eliminar deberia estar deshabilitado", eliminar.isEnabled());
        robot.keyPress(KeyEvent.VK_ENTER);
    }
}
