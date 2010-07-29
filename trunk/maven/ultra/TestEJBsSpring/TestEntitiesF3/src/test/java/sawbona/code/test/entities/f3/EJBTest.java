/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sawbona.code.test.entities.f3;

import java.util.Date;
import javax.persistence.RollbackException;

import mx.gob.pgr.jept.utils.soe.GenericTestingMethods;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author isaac
 */
public class EJBTest {

    private GenericTestingMethods instance;

    public EJBTest() {
        instance = new GenericTestingMethods();
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

    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //++++++++++++++++++++++++++ PRUEBAS +++++++++++++++++++++++++++++++++++++++
    @Test
    public void testSOE04_E001() {
        System.out.println("testSOE04_E001");
        EJB ejb = new EJB();
        ejb.setEjbName("Nombre EJB");
        //ejb.setEjbtiempo(new Date());
        try {
            instance.objectPersist(ejb);
            assertTrue(true);
        } catch (RollbackException e) {
            String mensaje = e.getCause().getMessage();
            e.printStackTrace();
            if (mensaje.contains("Internal Exception: java.sql.SQLException")) {
                assertFalse(mensaje.contains("ORA-01400"));
            }
        }
    }
}
