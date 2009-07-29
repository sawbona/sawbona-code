/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.com.sawbona.testing.vista.alta.usuarios;

import mx.com.sawbona.testing.modelo.Usuario;

/**
 *
 * @author jacob
 */
public final class AltaUsuariosAF extends org.apache.struts.action.ActionForm {

    /**
     * Version del objeto.
     */
    private static final long serialVersionUID = 4463194490805558165L;

    /**
     * Boton presionado por el usuario dentro de la forma.
     */
    private String accion;

    /**
     * Get the value of accion
     *
     * @return the value of accion
     */
    public String getAccion() {
        return accion;
    }

    /**
     * Set the value of accion
     *
     * @param accion new value of accion
     */
    public void setAccion(String accion) {
        this.accion = accion;
    }

    /**
     * Usuario a ser dado de alta.
     */
    private Usuario usuario;

    /**
     * Get the value of usuario
     *
     * @return the value of usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * Set the value of usuario
     *
     * @param usuario new value of usuario
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}