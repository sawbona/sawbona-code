/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.com.sawbona.testing.logic.usuarios;

import mx.com.sawbona.testing.modelo.Usuario;

/**
 * Altas, bajas, cambios, consulta y eliminaciones de usuarios.
 * @author jacob
 */
public interface UsuariosServicios {

    boolean existeUsuario(Usuario usuario);

    void altaUsuario(Usuario usuario);

}
