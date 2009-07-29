/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.com.sawbona.testing.modelo.acceso.datos.usuarios;

import mx.com.sawbona.testing.modelo.Usuario;

/**
 * Altas, bajas, cambios, consulta y eliminaciones de usuarios.
 * @author jacob
 */
public interface UsuariosAccessData {

    boolean exiteUsuario(Usuario usuario);
    void altaUsuario(Usuario usuario);
}
