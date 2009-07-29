
package mx.com.sawbona.testing.modelo.acceso.datos.usuarios;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import mx.com.sawbona.testing.modelo.Usuario;

/**
 *
 * @author jacob
 */
public class UsuariosAccessDataImpl implements UsuariosAccessData{

    @Override
    public boolean exiteUsuario(Usuario usuario) {
        boolean resultado = true;
        Util.getEntityManager();
        return resultado;
    }

    @Override
    public void altaUsuario(Usuario usuario) {
        EntityManager entityManager = Util.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(usuario);
        entityManager.flush();
        transaction.commit();
    }

}
