/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.sawbona.testing.vista.carga.archivo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.upload.FormFile;

/**
 *
 * @author jacob
 */
public class ArchivoAF extends org.apache.struts.action.ActionForm {
    public static final Logger logger = Logger.getLogger(ArchivoAF.class.getName());

    private static int MB = 1048576;

    private static final long serialVersionUID = 3998351996094182271L;
    private FormFile archivo;

    public FormFile getArchivo() {
        return archivo;
    }

    public void setArchivo(FormFile archivo) {
        this.archivo = archivo;
    }

    @Override
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errores = new ActionErrors();
        if (archivo != null) {
            try {
                if (!archivo.getContentType().equals("application/octet-stream")) {
                    //Validamos que se haya seleccionado un rol
                    errores.add("",
                            new ActionMessage("error.cargar.archivo.proporcionar"));
                }
                if (archivo.getFileSize() > (3 * MB)) {
                    errores.add("",
                            new ActionMessage("error.cargar.archivo.tamanio", "3"));
                }
                if (archivo.getFileSize() == 0) {
                    errores.add("",
                            new ActionMessage("error.carga.archivo.tamanio.cero"));
                }
                if (archivo.getInputStream() == null) {
                    errores.add("",
                            new ActionMessage("error.cargar.archivo.no.input.stream"));
                }
            } catch (FileNotFoundException ex) {
                logger.log(Level.SEVERE, null, ex);
                errores.add("", new ActionMessage("error.cargar.archivo.file.not.found"));
            } catch (IOException ex) {
                logger.log(Level.SEVERE, null, ex);
                errores.add("", new ActionMessage("error.cargar.archivo.io.exception"));
            }
        } else {
            errores.add("",
                    new ActionMessage("error.carga.archivo.tamanio.cero"));
        }
        return errores;
    }
}
