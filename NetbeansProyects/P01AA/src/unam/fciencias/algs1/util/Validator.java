package unam.fciencias.algs1.util;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;


/**
 * Clase para el manejo de errores al hacer el parser
 **/
public class Validator implements ErrorHandler{
    /**
     * Da aviso de las advertencias y abienta la misma advertencia
     */
    public void warning(SAXParseException e) throws SAXException{
        System.out.println("Warning: "+e.getMessage());
        throw e;
    }
    /**
     * Da aviso de los errores y abienta el mismo error
     */
    public void error(SAXParseException e) throws SAXException{
        System.out.println("Error: "+e.getMessage());
        throw e;
    }
    /**
     * Da aviso de los errores fatales y los abienta
     */
    public void fatalError(SAXParseException e) throws SAXException{
        System.out.println("Fattal error: "+e.getMessage());
        throw e;
    }
}