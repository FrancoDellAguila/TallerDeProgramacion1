package test;

import controlador.Controlador_Medicos;
import controlador.Controlador_Menu;
import java.awt.AWTException;
import java.awt.Robot;

import javax.swing.JButton;
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
        controlador.getVista().setVisible(false);
    }*/


    @Test
    public void testRegSoloNombre()
    {
        robot.delay(TestUtils.getDelay());
        //obtengo las referencias a los componentes necesarios
        JButton abrirMedicos = (JButton) controladorMenu.getVista().;
        robot.delay(TestUtils.getDelay());
        JTextField nombre = (JTextField) TestUtils.getComponentForName(controlador.getVista(), "jtNombreRegistro");
        JButton agregar = (JButton) TestUtils.getComponentForName(controlador.getVista(), "botonAgregar");
        JButton eliminar = (JButton) TestUtils.getComponentForName(controlador.getVista(), "botonEliminar");
        //lleno los JTextField
        TestUtils.clickComponent(abrirMedicos, robot);
        TestUtils.clickComponent(nombre, robot);
        TestUtils.tipeaTexto("Guille", robot);
        //verifico los resultados
        Assert.assertFalse("El boton de registro deberia estar deshablitado", agregar.isEnabled());
        Assert.assertFalse("El boton de eliminar deberia estar deshablitado", eliminar.isEnabled());
        
    }
    /*
    @Test
    public void testRegSoloConfirma()
    {
        robot.delay(TestUtils.getDelay());
        JTextField confirma =
            (JTextField) TestUtils.getComponentForName(controlador.getVista(), "jtConfirmacionRegistro");
        JButton aceptarReg = (JButton) TestUtils.getComponentForName(controlador.getVista(), "botonRegistro");
        JButton aceptarLog = (JButton) TestUtils.getComponentForName(controlador.getVista(), "botonLogin");
        //lleno los JTextField
        TestUtils.clickComponent(confirma, robot);
        TestUtils.tipeaTexto("hola", robot);
        //verifico los resultados
        Assert.assertFalse("El boton de registro deberia estar deshablitado", aceptarReg.isEnabled());
        Assert.assertFalse("El boton de login deberia estar deshablitado", aceptarLog.isEnabled());
    }

    
    @Test
    public void testRegSoloContrasena()
    {
        robot.delay(TestUtils.getDelay());
        //obtengo las referencias a los componentes necesarios
        JTextField contra =
            (JTextField) TestUtils.getComponentForName(controlador.getVista(), "jtContrasenaRegistro");
        JButton aceptarReg = (JButton) TestUtils.getComponentForName(controlador.getVista(), "botonRegistro");
        JButton aceptarLog = (JButton) TestUtils.getComponentForName(controlador.getVista(), "botonLogin");
        //lleno los JTextField
        TestUtils.clickComponent(contra, robot);
        TestUtils.tipeaTexto("hola", robot);
        //verifico los resultados
        Assert.assertFalse("El boton de registro deberia estar deshablitado", aceptarReg.isEnabled());
        Assert.assertFalse("El boton de login deberia estar deshablitado", aceptarLog.isEnabled());
    }
    
    @Test
    public void testVacios()
    {
        //obtengo las referencias a los componentes necesarios
        JButton aceptarReg = (JButton) TestUtils.getComponentForName(controlador.getVista(), "botonRegistro");
        JButton aceptarLog = (JButton) TestUtils.getComponentForName(controlador.getVista(), "botonLogin");
        //verifico los resultados
        Assert.assertFalse("El boton de registro deberia estar deshablitado", aceptarReg.isEnabled());
        Assert.assertFalse("El boton de login deberia estar deshablitado", aceptarLog.isEnabled());
    }

    

    
    @Test
    public void testRegTresLlenos()
    {
        robot.delay(TestUtils.getDelay());
        //obtengo las referencias a los componentes necesarios
        JTextField nombre = (JTextField) TestUtils.getComponentForName(controlador.getVista(), "jtNombreRegistro");
        JTextField confirma =
            (JTextField) TestUtils.getComponentForName(controlador.getVista(), "jtConfirmacionRegistro");
        JTextField contra =
            (JTextField) TestUtils.getComponentForName(controlador.getVista(), "jtContrasenaRegistro");

        JButton aceptarReg = (JButton) TestUtils.getComponentForName(controlador.getVista(), "botonRegistro");
        JButton aceptarLog = (JButton) TestUtils.getComponentForName(controlador.getVista(), "botonLogin");
        //lleno los JTextField
        TestUtils.clickComponent(nombre, robot);
        TestUtils.tipeaTexto("hola", robot);
        TestUtils.clickComponent(contra, robot);
        TestUtils.tipeaTexto("hola", robot);
        TestUtils.clickComponent(confirma, robot);
        TestUtils.tipeaTexto("hola", robot);
        //verifico los resultados
        Assert.assertTrue("El boton de registro deberia estar hablitado", aceptarReg.isEnabled());
        Assert.assertFalse("El boton de login deberia estar deshablitado", aceptarLog.isEnabled());
    }

    @Test
    public void testRegSinConfirma()
    {
        robot.delay(TestUtils.getDelay());
        //obtengo las referencias a los componentes necesarios
        JTextField nombre = (JTextField) TestUtils.getComponentForName(controlador.getVista(), "jtNombreRegistro");
        JTextField contra =
            (JTextField) TestUtils.getComponentForName(controlador.getVista(), "jtContrasenaRegistro");
        JButton aceptarReg = (JButton) TestUtils.getComponentForName(controlador.getVista(), "botonRegistro");
        JButton aceptarLog = (JButton) TestUtils.getComponentForName(controlador.getVista(), "botonLogin");
        //lleno los JTextField
        TestUtils.clickComponent(nombre, robot);
        TestUtils.tipeaTexto("hola", robot);
        TestUtils.clickComponent(contra, robot);
        TestUtils.tipeaTexto("hola", robot);
        //verifico los resultados
        Assert.assertFalse("El boton de registro deberia estar deshablitado", aceptarReg.isEnabled());
        Assert.assertFalse("El boton de login deberia estar deshablitado", aceptarLog.isEnabled());
    }

    @Test
    public void testRegSinContrasena()
    {
        robot.delay(TestUtils.getDelay());
        //obtengo las referencias a los componentes necesarios
        JTextField nombre = (JTextField) TestUtils.getComponentForName(controlador.getVista(), "jtNombreRegistro");
        JTextField confirma =
            (JTextField) TestUtils.getComponentForName(controlador.getVista(), "jtConfirmacionRegistro");
        JButton aceptarReg = (JButton) TestUtils.getComponentForName(controlador.getVista(), "botonRegistro");
        JButton aceptarLog = (JButton) TestUtils.getComponentForName(controlador.getVista(), "botonLogin");

        //lleno los JTextField
        TestUtils.clickComponent(nombre, robot);
        TestUtils.tipeaTexto("hola", robot);
        TestUtils.clickComponent(confirma, robot);
        TestUtils.tipeaTexto("hola", robot);
        //verifico los resultados
        Assert.assertFalse("El boton de registro deberia estar deshablitado", aceptarReg.isEnabled());
        Assert.assertFalse("El boton de login deberia estar deshablitado", aceptarLog.isEnabled());
    }


    @Test
    public void testRegSinNombre()
    {
        robot.delay(TestUtils.getDelay());
        //obtengo las referencias a los componentes necesarios
        JTextField contra =
            (JTextField) TestUtils.getComponentForName(controlador.getVista(), "jtContrasenaRegistro");
        JTextField confirma =
            (JTextField) TestUtils.getComponentForName(controlador.getVista(), "jtConfirmacionRegistro");
        JButton aceptarReg = (JButton) TestUtils.getComponentForName(controlador.getVista(), "botonRegistro");
        JButton aceptarLog = (JButton) TestUtils.getComponentForName(controlador.getVista(), "botonLogin");
        //lleno los JTextField
        TestUtils.clickComponent(contra, robot);
        TestUtils.tipeaTexto("hola", robot);
        TestUtils.clickComponent(confirma, robot);
        TestUtils.tipeaTexto("hola", robot);
        //verifico los resultados
        Assert.assertFalse("El boton de registro deberia estar deshablitado", aceptarReg.isEnabled());
        Assert.assertFalse("El boton de login deberia estar deshablitado", aceptarLog.isEnabled());
    }


    @Test
    public void testLogSoloNombre()
    {
        robot.delay(TestUtils.getDelay());
        //obtengo las referencias a los componentes necesarios
        JTextField nombre = (JTextField) TestUtils.getComponentForName(controlador.getVista(), "jtNombreLogin");
        JButton aceptarReg = (JButton) TestUtils.getComponentForName(controlador.getVista(), "botonRegistro");
        JButton aceptarLog = (JButton) TestUtils.getComponentForName(controlador.getVista(), "botonLogin");
        //lleno los JTextField
        TestUtils.clickComponent(nombre, robot);
        TestUtils.tipeaTexto("hola", robot);
        //verifico los resultados
        Assert.assertFalse("El boton de registro deberia estar deshablitado", aceptarReg.isEnabled());
        Assert.assertFalse("El boton de login deberia estar deshablitado", aceptarLog.isEnabled());
    }

    @Test
    public void testLogSoloContra()
    {
        robot.delay(TestUtils.getDelay());
        //obtengo las referencias a los componentes necesarios
        JTextField contrasena =
            (JTextField) TestUtils.getComponentForName(controlador.getVista(), "jtContrasenaLogin");
        JButton aceptarReg = (JButton) TestUtils.getComponentForName(controlador.getVista(), "botonRegistro");
        JButton aceptarLog = (JButton) TestUtils.getComponentForName(controlador.getVista(), "botonLogin");
        //lleno los JTextField
        TestUtils.clickComponent(contrasena, robot);
        TestUtils.tipeaTexto("hola", robot);
        //verifico los resultados
        Assert.assertFalse("El boton de registro deberia estar deshablitado", aceptarReg.isEnabled());
        Assert.assertFalse("El boton de login deberia estar deshablitado", aceptarLog.isEnabled());
    }

    @Test
    public void testLogLleno()
    {
        robot.delay(TestUtils.getDelay());
        //obtengo las referencias a los componentes necesarios
        JTextField contrasena =
            (JTextField) TestUtils.getComponentForName(controlador.getVista(), "jtContrasenaLogin");
        JTextField nombre = (JTextField) TestUtils.getComponentForName(controlador.getVista(), "jtNombreLogin");
        JButton aceptarReg = (JButton) TestUtils.getComponentForName(controlador.getVista(), "botonRegistro");
        JButton aceptarLog = (JButton) TestUtils.getComponentForName(controlador.getVista(), "botonLogin");
        //lleno los JTextField
        TestUtils.clickComponent(nombre, robot);
        TestUtils.tipeaTexto("hola", robot);
        TestUtils.clickComponent(contrasena, robot);
        TestUtils.tipeaTexto("hola", robot);
        //verifico los resultados
        Assert.assertFalse("El boton de registro deberia estar deshablitado", aceptarReg.isEnabled());
        Assert.assertTrue("El boton de login deberia estar hablitado", aceptarLog.isEnabled());
    }*/
}
