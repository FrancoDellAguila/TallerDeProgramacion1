package test;

import controlador.Controlador_Medicos;
import controlador.Controlador_Menu;
import decorators.IMedico;

import java.awt.AWTException;
import java.awt.Robot;

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
        controlador = new Controlador_Medicos();
        controladorMenu = new Controlador_Menu();
        
    }
/*
    @After
    public void tearDown() throws Exception
    {
        controlador.getVista().;
    }*/

    @Test
    public void testVacio()
    {
        robot.delay(TestUtils.getDelay());
        //obtengo las referencias a los componentes necesarios
        JButton abrirMedicos = controladorMenu.getVista().getBtnMedicos();
        JButton agregar = controlador.getVista().getBtnAgregar();
        JButton eliminar = controlador.getVista().getBtnEliminar();

        //verifico los resultados
        Assert.assertFalse("El boton de registro deberia estar deshablitado", agregar.isEnabled());
        Assert.assertFalse("El boton de eliminar deberia estar deshablitado", eliminar.isEnabled());
    }

    @Test
    public void testSoloNombre()
    {
        robot.delay(TestUtils.getDelay());
        //obtengo las referencias a los componentes necesarios
        JButton abrirMedicos = controladorMenu.getVista().getBtnMedicos();
        JTextField nombre = controlador.getVista().getTextFieldNombre();
        JButton agregar = controlador.getVista().getBtnAgregar();
        JButton eliminar = controlador.getVista().getBtnEliminar();
        //lleno los JTextField
        TestUtils.clickComponent(abrirMedicos, robot);
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
        JButton abrirMedicos = controladorMenu.getVista().getBtnMedicos();
        JTextField apellido = controlador.getVista().getTextFieldApellido();
        JButton agregar = controlador.getVista().getBtnAgregar();
        JButton eliminar = controlador.getVista().getBtnEliminar();
        //lleno los JTextField
        TestUtils.clickComponent(abrirMedicos, robot);
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
        JButton abrirMedicos = controladorMenu.getVista().getBtnMedicos();
        JTextField dni = controlador.getVista().getTextFieldDni();
        JButton agregar = controlador.getVista().getBtnAgregar();
        JButton eliminar = controlador.getVista().getBtnEliminar();
        //lleno los JTextField
        TestUtils.clickComponent(abrirMedicos, robot);
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
        JButton abrirMedicos = controladorMenu.getVista().getBtnMedicos();
        JTextField domicilio = controlador.getVista().getTextFieldDomicilio();
        JButton agregar = controlador.getVista().getBtnAgregar();
        JButton eliminar = controlador.getVista().getBtnEliminar();
        //lleno los JTextField
        TestUtils.clickComponent(abrirMedicos, robot);
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
        JButton abrirMedicos = controladorMenu.getVista().getBtnMedicos();
        JTextField ciudad = controlador.getVista().getTextFieldCiudad();
        JButton agregar = controlador.getVista().getBtnAgregar();
        JButton eliminar = controlador.getVista().getBtnEliminar();
        //lleno los JTextField
        TestUtils.clickComponent(abrirMedicos, robot);
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
        JButton abrirMedicos = controladorMenu.getVista().getBtnMedicos();
        JTextField telefono = controlador.getVista().getTextFieldTelefono();
        JButton agregar = controlador.getVista().getBtnAgregar();
        JButton eliminar = controlador.getVista().getBtnEliminar();
        //lleno los JTextField
        TestUtils.clickComponent(abrirMedicos, robot);
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
        JButton abrirMedicos = controladorMenu.getVista().getBtnMedicos();
        JTextField matricula = controlador.getVista().getTextFieldMatricula();
        JButton agregar = controlador.getVista().getBtnAgregar();
        JButton eliminar = controlador.getVista().getBtnEliminar();
        //lleno los JTextField
        TestUtils.clickComponent(abrirMedicos, robot);
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
        JButton abrirMedicos = controladorMenu.getVista().getBtnMedicos();
        ButtonGroup especialidad = controlador.getVista().getGrupoEspecialidad();
        JRadioButton clinica = (JRadioButton) TestUtils.getRadioButtonForNameEspecialidad(especialidad,"clinica");
        JButton agregar = controlador.getVista().getBtnAgregar();
        JButton eliminar = controlador.getVista().getBtnEliminar();
        //lleno los JTextField
        TestUtils.clickComponent(abrirMedicos, robot);
        clinica.setEnabled(true);
        //verifico los resultados
        Assert.assertFalse("El boton de registro deberia estar deshablitado", agregar.isEnabled());
        Assert.assertFalse("El boton de eliminar deberia estar deshablitado", eliminar.isEnabled());
    }
    
    @Test
    public void testSoloCirugia()
    {
        robot.delay(TestUtils.getDelay());
        //obtengo las referencias a los componentes necesarios
        JButton abrirMedicos = controladorMenu.getVista().getBtnMedicos();
        ButtonGroup especialidad = controlador.getVista().getGrupoEspecialidad();
        JRadioButton cirugia = (JRadioButton) TestUtils.getRadioButtonForNameEspecialidad(especialidad,"cirugia");
        JButton agregar = controlador.getVista().getBtnAgregar();
        JButton eliminar = controlador.getVista().getBtnEliminar();
        //lleno los JTextField
        TestUtils.clickComponent(abrirMedicos, robot);
        robot.delay(TestUtils.getDelay());
        especialidad.clearSelection();
        especialidad.setSelected((ButtonModel) cirugia, true);
        //verifico los resultados
        Assert.assertFalse("El boton de registro deberia estar deshablitado", agregar.isEnabled());
        Assert.assertFalse("El boton de eliminar deberia estar deshablitado", eliminar.isEnabled());
    }
    
    @Test
    public void testSoloPediatria()
    {
        robot.delay(TestUtils.getDelay());
        //obtengo las referencias a los componentes necesarios
        JButton abrirMedicos = controladorMenu.getVista().getBtnMedicos();
        ButtonGroup especialidad = controlador.getVista().getGrupoEspecialidad();
        JRadioButton pediatria = (JRadioButton) TestUtils.getRadioButtonForNameEspecialidad(especialidad,"pediatria");
        JButton agregar = controlador.getVista().getBtnAgregar();
        JButton eliminar = controlador.getVista().getBtnEliminar();
        //lleno los JTextField
        TestUtils.clickComponent(abrirMedicos, robot);
        robot.delay(TestUtils.getDelay());
        especialidad.clearSelection();
        especialidad.setSelected((ButtonModel) pediatria, true);
        //verifico los resultados
        Assert.assertFalse("El boton de registro deberia estar deshablitado", agregar.isEnabled());
        Assert.assertFalse("El boton de eliminar deberia estar deshablitado", eliminar.isEnabled());
    }
    
    @Test
    public void testSoloPermanente()
    {
        robot.delay(TestUtils.getDelay());
        //obtengo las referencias a los componentes necesarios
        JButton abrirMedicos = controladorMenu.getVista().getBtnMedicos();
        ButtonGroup contratacion = controlador.getVista().getGrupoContratacion();
        JRadioButton permanente = (JRadioButton) TestUtils.getRadioButtonForNameContratacion(contratacion,"permanente");
        JButton agregar = controlador.getVista().getBtnAgregar();
        JButton eliminar = controlador.getVista().getBtnEliminar();
        //lleno los JTextField
        TestUtils.clickComponent(abrirMedicos, robot);
        robot.delay(TestUtils.getDelay());
        contratacion.clearSelection();
        contratacion.setSelected((ButtonModel) permanente, true);
        //verifico los resultados
        Assert.assertFalse("El boton de registro deberia estar deshablitado", agregar.isEnabled());
        Assert.assertFalse("El boton de eliminar deberia estar deshablitado", eliminar.isEnabled());
    }
    
    @Test
    public void testSoloResidente()
    {
        robot.delay(TestUtils.getDelay());
        //obtengo las referencias a los componentes necesarios
        JButton abrirMedicos = controladorMenu.getVista().getBtnMedicos();
        ButtonGroup contratacion = controlador.getVista().getGrupoContratacion();
        JRadioButton residente = (JRadioButton) TestUtils.getRadioButtonForNameContratacion(contratacion,"residente");
        JButton agregar = controlador.getVista().getBtnAgregar();
        JButton eliminar = controlador.getVista().getBtnEliminar();
        //lleno los JTextField
        TestUtils.clickComponent(abrirMedicos, robot);
        robot.delay(TestUtils.getDelay());
        contratacion.clearSelection();
        contratacion.setSelected((ButtonModel) residente, true);
        //verifico los resultados
        Assert.assertFalse("El boton de registro deberia estar deshablitado", agregar.isEnabled());
        Assert.assertFalse("El boton de eliminar deberia estar deshablitado", eliminar.isEnabled());
    }
    
    @Test
    public void testSoloNinguno()
    {
        robot.delay(TestUtils.getDelay());
        //obtengo las referencias a los componentes necesarios
        JButton abrirMedicos = controladorMenu.getVista().getBtnMedicos();
        ButtonGroup posgrado = controlador.getVista().getGrupoContratacion();
        JRadioButton ninguno = (JRadioButton) TestUtils.getRadioButtonForNamePosgrado(posgrado,"ninguno");
        JButton agregar = controlador.getVista().getBtnAgregar();
        JButton eliminar = controlador.getVista().getBtnEliminar();
        //lleno los JTextField
        TestUtils.clickComponent(abrirMedicos, robot);
        robot.delay(TestUtils.getDelay());
        posgrado.clearSelection();
        posgrado.setSelected((ButtonModel) ninguno, true);
        //verifico los resultados
        Assert.assertFalse("El boton de registro deberia estar deshablitado", agregar.isEnabled());
        Assert.assertFalse("El boton de eliminar deberia estar deshablitado", eliminar.isEnabled());
    }
    
    @Test
    public void testSoloMagister()
    {
        robot.delay(TestUtils.getDelay());
        //obtengo las referencias a los componentes necesarios
        JButton abrirMedicos = controladorMenu.getVista().getBtnMedicos();
        ButtonGroup posgrado = controlador.getVista().getGrupoContratacion();
        JRadioButton magister = (JRadioButton) TestUtils.getRadioButtonForNamePosgrado(posgrado,"magister");
        JButton agregar = controlador.getVista().getBtnAgregar();
        JButton eliminar = controlador.getVista().getBtnEliminar();
        //lleno los JTextField
        TestUtils.clickComponent(abrirMedicos, robot);
        robot.delay(TestUtils.getDelay());
        posgrado.clearSelection();
        posgrado.setSelected((ButtonModel) magister, true);
        //verifico los resultados
        Assert.assertFalse("El boton de registro deberia estar deshablitado", agregar.isEnabled());
        Assert.assertFalse("El boton de eliminar deberia estar deshablitado", eliminar.isEnabled());
    }    
    
    @Test
    public void testSoloDoctor()
    {
        robot.delay(TestUtils.getDelay());
        //obtengo las referencias a los componentes necesarios
        JButton abrirMedicos = controladorMenu.getVista().getBtnMedicos();
        ButtonGroup posgrado = controlador.getVista().getGrupoContratacion();
        JRadioButton doctor = (JRadioButton) TestUtils.getRadioButtonForNamePosgrado(posgrado,"doctor");
        JButton agregar = controlador.getVista().getBtnAgregar();
        JButton eliminar = controlador.getVista().getBtnEliminar();
        //lleno los JTextField
        TestUtils.clickComponent(abrirMedicos, robot);
        robot.delay(TestUtils.getDelay());
        posgrado.clearSelection();
        doctor.setSelected(true);
        //verifico los resultados
        Assert.assertFalse("El boton de registro deberia estar deshablitado", agregar.isEnabled());
        Assert.assertFalse("El boton de eliminar deberia estar deshablitado", eliminar.isEnabled());
    }   
    
    @Test
    public void testNombreApellido()
    {
        robot.delay(TestUtils.getDelay());
        //obtengo las referencias a los componentes necesarios
        JButton abrirMedicos = controladorMenu.getVista().getBtnMedicos();
        JTextField nombre = controlador.getVista().getTextFieldNombre();
        JTextField apellido = controlador.getVista().getTextFieldApellido();
        JButton agregar = controlador.getVista().getBtnAgregar();
        JButton eliminar = controlador.getVista().getBtnEliminar();
        //lleno los JTextField
        TestUtils.clickComponent(abrirMedicos, robot);
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
        JButton abrirMedicos = controladorMenu.getVista().getBtnMedicos();
        JTextField nombre = controlador.getVista().getTextFieldNombre();
        JTextField dni = controlador.getVista().getTextFieldDni();
        JButton agregar = controlador.getVista().getBtnAgregar();
        JButton eliminar = controlador.getVista().getBtnEliminar();
        //lleno los JTextField
        TestUtils.clickComponent(abrirMedicos, robot);
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
        JButton abrirMedicos = controladorMenu.getVista().getBtnMedicos();
        JTextField nombre = controlador.getVista().getTextFieldNombre();
        JTextField domicilio = controlador.getVista().getTextFieldDomicilio();
        JButton agregar = controlador.getVista().getBtnAgregar();
        JButton eliminar = controlador.getVista().getBtnEliminar();
        //lleno los JTextField
        TestUtils.clickComponent(abrirMedicos, robot);
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
        JButton abrirMedicos = controladorMenu.getVista().getBtnMedicos();
        JTextField nombre = controlador.getVista().getTextFieldNombre();
        JTextField ciudad = controlador.getVista().getTextFieldCiudad();
        JButton agregar = controlador.getVista().getBtnAgregar();
        JButton eliminar = controlador.getVista().getBtnEliminar();
        //lleno los JTextField
        TestUtils.clickComponent(abrirMedicos, robot);
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
        JButton abrirMedicos = controladorMenu.getVista().getBtnMedicos();
        JTextField nombre = controlador.getVista().getTextFieldNombre();
        JTextField telefono = controlador.getVista().getTextFieldTelefono();
        JButton agregar = controlador.getVista().getBtnAgregar();
        JButton eliminar = controlador.getVista().getBtnEliminar();
        //lleno los JTextField
        TestUtils.clickComponent(abrirMedicos, robot);
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
        JButton abrirMedicos = controladorMenu.getVista().getBtnMedicos();
        JTextField nombre = controlador.getVista().getTextFieldNombre();
        JTextField matricula = controlador.getVista().getTextFieldMatricula();
        JButton agregar = controlador.getVista().getBtnAgregar();
        JButton eliminar = controlador.getVista().getBtnEliminar();
        //lleno los JTextField
        TestUtils.clickComponent(abrirMedicos, robot);
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
        JButton eliminar = controlador.getVista().getBtnEliminar();
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
        robot.delay(TestUtils.getDelay());robot.delay(TestUtils.getDelay());robot.delay(TestUtils.getDelay());robot.delay(TestUtils.getDelay());
        System.out.print(controlador.getVista().getBtnAgregar().isEnabled());
        Assert.assertTrue("El boton de registro deberia estar hablitado", agregar.isEnabled());
        Assert.assertFalse("El boton de eliminar deberia estar deshablitado", eliminar.isEnabled());
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
        JButton eliminar = controlador.getVista().getBtnEliminar();
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
        //verifico los resultados
        Assert.assertTrue("El boton de registro deberia estar hablitado", agregar.isEnabled());
        Assert.assertFalse("El boton de eliminar deberia estar deshablitado", eliminar.isEnabled());
    }
    
    @Test
    public void testCompletoErrorTelefono()
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
        JButton eliminar = controlador.getVista().getBtnEliminar();
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
        robot.delay(TestUtils.getDelay());robot.delay(TestUtils.getDelay());robot.delay(TestUtils.getDelay());robot.delay(TestUtils.getDelay());
        System.out.print(controlador.getVista().getBtnAgregar().isEnabled());
        Assert.assertFalse("El boton de registro deberia estar deshablitado", agregar.isEnabled());
        Assert.assertFalse("El boton de eliminar deberia estar deshablitado", eliminar.isEnabled());
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
        Assert.assertFalse("El boton de agregar deberia estar deshablitado", agregar.isEnabled());
        Assert.assertTrue("El boton de eliminar deberia estar hablitado", eliminar.isEnabled());
    }
}
