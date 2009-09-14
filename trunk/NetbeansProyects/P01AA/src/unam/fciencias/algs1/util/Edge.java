package unam.fciencias.algs1.util;

/**
 * Una instancia de esta clase representará una arista de una gráfica.
 * @author Ernesto Carrillo Espinosa
 */
public class Edge{
    /** Vértice origen. */
    private Vertex source;
    /** Vértice destino. */
    private Vertex target;
    /** Peso. */
    private int weight;
    /** Índice. */
    private int index;

    /**
     * Crea una instancia de la clase con
     * el vértice origen <i>s</i> y vértice destino <i>t</i>.
     * El peso será <i>DEFAULT_WEIGHT</i> y el índice <i>NULL_INDEX</i>.
     * @param s vértice orgigen.
     * @param t vértice destino.
     */
    public Edge(Vertex s, Vertex t){
        this(s, t, Graph.DEFAULT_WEIGHT, Graph.NULL_INDEX);
    }
    
    /**
     * Crea una instancia de la clase con
     * el vértice origen <i>s</i>, vértice destino <i>t</i>,
     * peso w e índice idx.
     * @param s vértice orgigen.
     * @param t vértice destino.
     * @param w peso.
     * @param idx índice.
     */
    public Edge(Vertex s, Vertex t, int w, int idx){
        source = s;
        target = t;
        weight = w;
        index = idx;
    }
    
    public Vertex getSource(){
        return source;
    }
    
    public Vertex getTarget(){
        return target;
    }
    
    public int getWeight(){
        return weight;
    }
    
    public void setWeight(int w){
        weight = w;
    }
    
    public int getIndex(){
        return index;
    }
}
