/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sawbona.code.test.ejb.f2;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author jacob
 */
@Remote(SimpleEJBF2Interface.class)
@Stateless(name = "SimpleEJBF2RemoteBean", mappedName = "ejb/SimpleEJBF2RemoteBean")
public class SimpleEJBF2Remote implements SimpleEJBF2Interface {

    @PersistenceContext(unitName = "EntitiesF3PU")
    private EntityManager entityManager;

    @Override
    public Object find(Class clase) {
        Object object = null;

        String nombreClase = clase.getName().replaceAll(clase.getPackage().getName().concat("."), "");
        Query query =
                entityManager.createQuery("select max(t.id) from " + nombreClase + " t ");
        try {
            object = query.getSingleResult();
        } catch (NoResultException nre) {
            nre.printStackTrace();
            return null;
        }
        return object;
    }
}
