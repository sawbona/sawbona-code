/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.com.sawbona.testing.vista.descarga.archivo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;

/**
 *
 * @author jacob
 */
public class DescargarArchivoA extends org.apache.struts.action.Action {
    
    /* forward name="success" path="" */
    private final static String SUCCESS = "success";
    
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
//        String nombreDelArchivo = request.getParameter("id");
//        EntityManager entityManager = DataDaoUtil.getEntityManager();
//        ArchivoLab leido = entityManager.find(ArchivoLab.class, nombreDelArchivo);
//        response.setContentType("application/octet-stream");
//        response.setHeader("Content-Disposition","inline; filename=" + leido.getNombreArchivo());
//        response.getOutputStream().write(leido.getBytes());
        return mapping.findForward(SUCCESS);
    }
}
