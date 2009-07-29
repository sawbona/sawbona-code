
package mx.com.sawbona.testing.logic.usuarios;

import mx.com.sawbona.testing.modelo.acceso.datos.usuarios.UsuariosAccessData;
import mx.com.sawbona.testing.modelo.Usuario;

/**
 *
 * @author jacob
 */
public class UsuariosServiciosImpl implements UsuariosServicios{

    private UsuariosAccessData usuariosAccessData;

    public UsuariosAccessData getUsuariosAccessData() {
        return usuariosAccessData;
    }

    public void setUsuariosAccessData(UsuariosAccessData usuariosAccessData) {
        this.usuariosAccessData = usuariosAccessData;
    }

    public boolean existeUsuario(Usuario usuario) {
        return usuariosAccessData.exiteUsuario(usuario);
    }

    @Override
    public void altaUsuario(Usuario usuario) {
        usuariosAccessData.altaUsuario(usuario);
    }

}
