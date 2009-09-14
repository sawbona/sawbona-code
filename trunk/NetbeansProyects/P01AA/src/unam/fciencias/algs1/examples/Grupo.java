package unam.fciencias.algs1.examples;

import java.util.List;

/**
 * Representa un grupo por su clave, hace
 * referencia al profesol titular y a los alumnos que toman el curso.
 * @author Ernesto Carrillo Espinosa.
 */
public class Grupo{
    private Profesor profesor;
    private List<Alumno> alumnos;
    private int clave;
    
    public Grupo(Profesor p, List<Alumno> al, int clave){
        profesor = p;
        alumnos = al;
        this.clave = clave;
    }

    public Profesor getProfesor(){
        return profesor;
    }
    
    public List<Alumno> getAlumnos(){
        return alumnos;
    }
    
    public int getClave(){
        return clave;
    }
}