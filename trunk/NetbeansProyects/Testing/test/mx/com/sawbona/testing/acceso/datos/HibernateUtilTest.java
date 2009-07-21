/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.com.sawbona.testing.acceso.datos;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import mx.com.sawbona.testing.modelo.ArchivoLab;
import mx.com.sawbona.testing.modelo.Perfil;
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
public class HibernateUtilTest {

    public HibernateUtilTest() {
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
     * Test of getEntityManager method, of class DataDaoUtil.
     */
    @Test
    public void testGetSessionFactory1() {
        System.out.println("getSessionFactory");

        EntityManager entityManager = DataDaoUtil.getEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        if(entityManager == null){
            fail();
        }
        Usuario usuario = new Usuario();
        usuario.setNombre("Cosme");
        usuario.setApellidoPaterno("Fulanito");
        usuario.setEmail("sawbona@gmail.com");
        Perfil perfil = new Perfil();
        perfil.setDescripcion("El perfil de Cosme");
        entityManager.persist(usuario);
        entityManager.persist(perfil);
        entityManager.flush();
        transaction.commit();
    }

}