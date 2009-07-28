/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.com.sawbona.testing.vista.alta.usuarios;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;
import mx.com.sawbona.testing.modelo.Usuario;
import mx.com.sawbona.testing.vista.alta.usuarios.AltaUsuariosAF;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;

/**
 *
 * @author jacob
 */
public class IniciaAltaUsuario extends org.apache.struts.action.Action {
    
    /**
     * This is the action called from the Struts framework.
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        HttpSession session = request.getSession();
        AltaUsuariosAF forma = (AltaUsuariosAF) session.getAttribute("AltaUsuarioAF");
        if(forma == null){
            forma = new AltaUsuariosAF();
            session.setAttribute("AltaUsuarioAF", forma);
        }
        forma.setUsuario(new Usuario());
        return mapping.findForward("alta.usuario");
    }
}