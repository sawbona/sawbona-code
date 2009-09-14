package unam.fciencias.algs1.examples;

/**
 * Representa a un alumno por su nombre y número de cuenta.
 * @author Ernesto Carrillo Espinosa.
 */
public class Alumno{
    private String nombre;
    private String apaterno;
    private String amaterno;
    private int ncuenta;
    
    public Alumno(String nombre, String apaterno, String amaterno, int ncuenta){
        this.nombre = nombre;
        this.apaterno = apaterno;
        this.amaterno = amaterno;
        this.ncuenta = ncuenta;
    }
    
    @Override
    public String toString(){
        return nombre + "\t" +
               apaterno + "\t" +
               amaterno + "\t" +
               ncuenta;
    }
}