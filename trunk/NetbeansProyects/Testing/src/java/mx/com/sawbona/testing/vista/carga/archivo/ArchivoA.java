/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.sawbona.testing.vista.carga.archivo;

import java.io.InputStream;
import java.nio.ByteBuffer;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.com.sawbona.testing.acceso.datos.DataDaoUtil;
import mx.com.sawbona.testing.modelo.ArchivoLab;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import org.apache.struts.upload.FormFile;

/**
 *
 * @author jacob
 */
public class ArchivoA extends org.apache.struts.action.Action {

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
        ArchivoAF forma = (ArchivoAF) form;
        FormFile file = forma.getArchivo();
        EntityManager entityManager = DataDaoUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        ArchivoLab archivo = new ArchivoLab();
        archivo.setNombreArchivo(file.getFileName());
        byte[] buffer = new byte[file.getFileSize()];
        InputStream inputStream = file.getInputStream();
        while(inputStream.available() > 0){
            inputStream.read(buffer);
        }
        archivo.setBytes(buffer);
        entityManager.persist(archivo);
        entityManager.flush();
        transaction.commit();
        file.destroy();
        return mapping.findForward(SUCCESS);
    }
}
