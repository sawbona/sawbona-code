/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.com.sawbona.testing.acceso.datos;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Hibernate Utility class with a convenient method to get Session Factory object.
 *
 * @author jacob
 */
public class DataDaoUtil {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("TestingsPU");

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
}
