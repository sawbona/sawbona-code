/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.sawbona.testing.modelo.acceso.datos.usuarios;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author jacob
 */
public final class Util {

    /**
     * Factory del sistema.
     */
    private static EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("TestingsPU");
    private static EntityManager entityMannager;

    /**
     * Obtiene el factory del sistema.
     * @return
     */
    public static EntityManager getEntityManager() {
        if (entityMannager == null) {
            entityMannager = emf.createEntityManager();
        }
        return entityMannager;
    }
}
