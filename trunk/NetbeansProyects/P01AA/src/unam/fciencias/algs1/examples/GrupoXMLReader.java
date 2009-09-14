package unam.fciencias.algs1.examples;

import unam.fciencias.algs1.util.XMLReader;

import java.util.Vector;

import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;

/**
 * Un objeto de esta clase relizará <i>parse</i> a un archivo <i>XML</i>
 * objetos <i>Grupo</i>, <i>Profesor</i> <i>Alumno</i>
 * @author Ernesto Carrillo Espinosa.
 */
public class GrupoXMLReader extends XMLReader {

    /** Nombre del tipo relacionado un objeto <i>Profesor</i> */
    public static final String PROF = "profesor";
    /** Nombre del tipo relacionado un objeto <i>Alumno</i> */
    public static final String ALUM = "alumno";
    /** Nombre del atributo relacionado con la clave del <i>Grupo</i> */
    public static final String CLAVE = "clave";
    /** Etiqueta nombre */
    public static final String NOM = "nombre";
    /** Etiqueta apaterno */
    public static final String APAT = "apaterno";
    /** Etiqueta amaterno */
    public static final String AMAT = "amaterno";
    /** Etiqueta categoria */
    public static final String CAT = "categoria";
    /** Opción tiempo completo para categoria */
    public static final String TC = "TC";
    /** Opción asignatura para categoria */
    public static final String AS = "AS";
    /** Atributo de alumno ncuenta*/
    public static final String NCUEN = "ncuenta";

    /**
     * Crea un objeto grupo a partir del archivo dado.
     * @param archivo archivo XML.
     * @return el grupo representado en el archivo.
     */
    public Grupo getGrupo(String archivo) {
        Element e = getDocument(archivo).getDocumentElement();

        //profesor
        Profesor p = null;
        //alumnos
        Vector<Alumno> al = new Vector<Alumno>();
        //calve
        int clave = Integer.parseInt(e.getAttribute(CLAVE));

        NodeList l = e.getChildNodes();
        for (int i = 0; i < l.getLength(); i++) {
            Node n = l.item(i);
            //Entradas
            if (n.getNodeName().trim().equals(PROF)) {
                p = getProfesor(n);
            }

            if (n.getNodeName().trim().equals(ALUM)) {
                al.add(getAlumno(n));
            }

        }
        //Grupo
        Grupo m = new Grupo(p, al, clave);
        return m;
    }

    /**
     * Da una instancia de la clase Profesor.
     * @param n nodo con los datos.
     * @return una instacia de Profesor.
     */
    private Profesor getProfesor(Node n) {
        NamedNodeMap map = n.getAttributes();
        //Categoria
        String cat = map.getNamedItem(CAT).getNodeValue();

        //nombre
        String nom = "";
        //apaterno
        String apa = "";
        //amaterno
        String ama = "";

        NodeList nl = n.getChildNodes();
        for (int i = 0; i < nl.getLength(); i++) {
            Node n0 = nl.item(i);
            if (n0.getNodeName().equals(NOM)) {
                nom = n0.getFirstChild().getNodeValue();
            }

            if (n0.getNodeName().equals(APAT)) {
                apa = n0.getFirstChild().getNodeValue();
            }

            if (n0.getNodeName().equals(AMAT)) {
                ama = n0.getFirstChild().getNodeValue();
            }
        }

        return new Profesor(nom, apa, ama, cat);
    }

    /**
     * Da una instancia de la clase Alumno.
     * @param n nodo con los datos.
     * @return una instacia de Alumno.
     */
    private Alumno getAlumno(Node n) {
        NamedNodeMap map = n.getAttributes();
        //Categoria
        int cla = Integer.parseInt(map.getNamedItem(NCUEN).getNodeValue());

        //nombre
        String nom = "";
        //apaterno
        String apa = "";
        //amaterno
        String ama = "";

        NodeList nl = n.getChildNodes();
        for (int i = 0; i < nl.getLength(); i++) {
            Node n0 = nl.item(i);
            if (n0.getNodeName().equals(NOM)) {
                nom = n0.getFirstChild().getNodeValue();
            }

            if (n0.getNodeName().equals(APAT)) {
                apa = n0.getFirstChild().getNodeValue();
            }

            if (n0.getNodeName().equals(AMAT)) {
                ama = n0.getFirstChild().getNodeValue();
            }
        }

        return new Alumno(nom, apa, ama, cla);
    }
}
