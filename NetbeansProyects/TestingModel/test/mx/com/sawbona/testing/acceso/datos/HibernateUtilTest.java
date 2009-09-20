/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.com.sawbona.testing.acceso.datos;

import mx.com.sawbona.testing.modelo.acceso.datos.usuarios.Util;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import mx.com.sawbona.testing.modelo.Grupo;
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

    /**!
     * Test of getEntityManager method, of class Util.
     */
    @Test
    public void testGetSessionFactory1() {
        System.out.println("getSessionFactory");

        EntityManager entityManager = Util.getEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        if(entityManager == null){
            fail();
        }
        Usuario usuario = new Usuario();
        usuario.setNombre("Cosme");
        usuario.setApellidoPaterno("Fulanito");
        usuario.setEmail("sawbona@gmail.com");
        usuario.setPassword("cosme");
        Perfil perfil = new Perfil();
        perfil.setDescripcion("El perfil de Cosme");
        Grupo g = new Grupo();
        g.setNombre("testHibernate");
        g.setEmail("sawbona@gmail.com");
        entityManager.persist(g);
        entityManager.persist(usuario);
        entityManager.persist(perfil);
        entityManager.flush();
        transaction.commit();
    }

}