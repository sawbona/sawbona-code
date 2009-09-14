package unam.fciencias.algs1.util;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import org.w3c.dom.Document;

public class XMLReader{
    //Mensajes de Error
    public final static String EPAR   = "Error al hacer el parse";
    public final static String EIO    = "Error de lectura";

    /**
     * Imprime un mensaje de error en stream de error del sistema.
     * @param message el mensaje.
     */
    public static void printErrorMessage(String message){
        System.err.println(message);
    }
    
    /**
     * Hace el parse al archivo xml y lo regresa
     * como una instancia de la clase Document.
     * @param archivo el nombre del archivo XML
     * @return el documento que contiene al archivo xml
     * con el parse hecho.
     */
    protected Document getDocument(String archivo){
	Document d = null;
	try{
	    DocumentBuilderFactory f =
		DocumentBuilderFactory.newInstance();
	    f.setValidating(true);

	    DocumentBuilder b = f.newDocumentBuilder();
	    b.setErrorHandler(new Validator());

	    d = b.parse(new File(archivo));
	}catch (ParserConfigurationException pce){
            pce.printStackTrace();
	    printErrorMessage(EPAR);
	}catch (SAXException saxe){
            saxe.printStackTrace();
	    printErrorMessage(EPAR);
	}catch (IOException ioe){
            ioe.printStackTrace();
	    printErrorMessage(EIO);
	}

	return d;
    }
}