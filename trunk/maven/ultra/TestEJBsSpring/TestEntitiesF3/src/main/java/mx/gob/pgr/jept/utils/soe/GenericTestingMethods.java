package mx.gob.pgr.jept.utils.soe;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class GenericTestingMethods {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("EntitiesF3PU");

    /** EntityManagerCreator */
    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    /** FindObjectAllElements*/
    public List objectFindAll(Class clazz) {
        List objects = null;
        Query query = getEntityManager().createQuery("select o from " + clazz.getName().replaceAll(clazz.getPackage().getName().concat("."), "") + " o");
        objects = query.getResultList();
        Iterator iter = objects.iterator();
        return objects;
    }

    /** FindObjectById */
    public Object objectFindById(Class clazz, Object id) {
        Object object = null;
        Query query =
                getEntityManager().createQuery("SELECT o FROM " + clazz.getName().replaceAll(clazz.getPackage().getName().concat("."), "") + " o WHERE o.id = :id").setParameter("id",
                id);
        try {
            object = query.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
        return object;
    }

    /** Crete: PersistObject */
    public Object objectPersist(Object entity) {
        final EntityManager em = getEntityManager();
        try {
            final EntityTransaction et = em.getTransaction();
            try {
                et.begin();
                em.persist(entity);
                et.commit();
            } finally {
                if (et != null && et.isActive()) {
                    entity = null;
                    et.rollback();
                }
            }
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
        return entity;
    }

    /** Update: MergeObject */
    public Object objectMerge(Object entity) {
        final EntityManager em = getEntityManager();
        try {
            final EntityTransaction et = em.getTransaction();
            try {
                et.begin();
                em.merge(entity);
                et.commit();
            } finally {
                if (et != null && et.isActive()) {
                    entity = null;
                    et.rollback();
                }
            }
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
        return entity;
    }

    public Object objectGetMax(Class clase) {
        Object object = null;
        
        String nombreClase = clase.getName().replaceAll(clase.getPackage().getName().concat("."), "");
        Query query =
                getEntityManager().createQuery("select max(t.id) from "+nombreClase+ " t ");
        try {
            object = query.getSingleResult();
        } catch (NoResultException nre) {
            nre.printStackTrace();
            return null;
        }
        return object;
    }
}
