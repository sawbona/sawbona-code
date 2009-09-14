package unam.fciencias.algs1.examples;

/**
 * Representa a un profesor por su nombre y categoria,
 * la cual puede ser tiempo completo <i>TC</i> o asignatura <i>AS</i>.
 * @author Ernesto Carrillo Espinosa.
 */
public class Profesor{
    private String nombre;
    private String apaterno;
    private String amaterno;
    private String catego;
    
    public Profesor(String nombre, String apaterno, String amaterno, String catego){
        this.nombre = nombre;
        this.apaterno = apaterno;
        this.amaterno = amaterno;
        this.catego = catego;
    }

    @Override
    public String toString(){
        return nombre + "\t" +
               apaterno + "\t" +
               amaterno + "\t" +
               catego;
    }
}