/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.com.sawbona.testing.logic.usuarios;

import mx.com.sawbona.testing.modelo.acceso.datos.usuarios.UsuariosAccessData;
import mx.com.sawbona.testing.modelo.acceso.datos.usuarios.UsuariosAccessDataImpl;
import mx.com.sawbona.testing.modelo.Usuario;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jacob
 */
public class ServiciosUsuariosImplTest {

    public ServiciosUsuariosImplTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of existeUsuario method, of class UsuariosServiciosImpl.
     */
    @Test
    public void testExiteUsuario() {
        System.out.println("exiteUsuario");
        Usuario usuario = new Usuario();
        usuario.setNombre("Jacob");
        usuario.setApellidoPaterno("Fulanito");
        usuario.setEmail("sawbona@gmail.com");
        UsuariosAccessData usuariosAccessData = new UsuariosAccessDataImpl();
        UsuariosServiciosImpl instance = new UsuariosServiciosImpl();
        instance.setUsuariosAccessData(usuariosAccessData);
        instance.altaUsuario(usuario);
        boolean expResult = false;
        boolean result = instance.existeUsuario(usuario);
    }

}