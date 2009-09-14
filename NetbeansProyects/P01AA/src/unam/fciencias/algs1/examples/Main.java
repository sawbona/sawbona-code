package unam.fciencias.algs1.examples;

/**
 * Clase principal.
 * @author Ernesto Carrillo Espinosa.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Leyendo grupo del archivo \'xml/grupo1.xml\' ");
        Grupo grupo = (new GrupoXMLReader()).getGrupo(
                "C:/Documents and Settings/" +
                "jacob/Mis documentos/back/algoritmos/practica1/xml/grupo1.xml");
        System.out.println("Profesor:\n\t" + grupo.getProfesor() + "\n");

        System.out.println("Alumnos:");
        for (Alumno a : grupo.getAlumnos()) {
            System.out.println("\t" + a);
        }
    }
}