package unam.fciencias.algs1.util;

import java.util.List;

/**
 *
 * @author Ernesto Carrillo Espinosa
 */
public abstract class Vertex{
    /** Elemento contenido en el vértice */
    private Object element;
    
    /** Índice */
    private int index;
    
    /**
     * Crea una instancia vacía.
     */
    public Vertex(){
        this(null, Graph.NULL_INDEX);
    }

    /**
     * Crea una intancia con el elemento <i>element</i> contenido.
     * @param element elemento.
     */
    public Vertex(Object element){
        this(element, Graph.NULL_INDEX);
    }

    /**
     * Crea una instancia que contenga a <i>element</i>, y el indice dado.
     * @param element elemento.
     * @param index el indece del vertices.
     */
    public Vertex(Object element, int index){
        this.element = element;
        this.index = index;
    }

    public Object getElement(){
        return element;
    }

    public void setElement(Object element){
        this.element = element;
    }

    /**
     * Da una lista con los vertices adyacentes.
     * @return la lista con los vertices adyacentes.
     */
    public abstract List<Vertex> getNeighboursList();

    /**
     * Da el vértice adyacente en la i-ésima posición de <i>neighbours</i>.
     * @param i la posición del vértice deseado.
     * @return el i-ésimo vecino, si no existe tal posición 
     */
    public abstract Vertex getNeighbour(int i);

    /**
     * Hace a la intancia adyacente a los vértices de <i>vs</i>.
     * @param vs vértices adyacentes.
     */
    public abstract void addNeighbours(List<Vertex> vs);
    
    /**
     * Hace a la intancia adyacente a los vértices de <i>vs</i> y viceverza.
     * @param vs vértices adyacentes.
     */
    public abstract void addSymmetricNeighbours(List<Vertex> vs);
    
    /**
     * Hace a la intancia adyacente al vértice <i>v</i>.
     * @param v el vértice.
     */
    public abstract void addNeighbour(Vertex v);

    public int getIndex(){
        return index;
    }
    
    public void setIndex(int idx){
        index = idx;
    }

    /**
     * Indica si <i>element</i> es <i>null</i>.
     * @return <i>true</i> si <i>element</i> es <i>null</i>,
     * <i>false></i> en otro caso.
     */
    public boolean isEmpty(){
        return (element == null)? true : false;
    }

    /**
     * Da el grado del vértice.
     * El grado del vértice es el número de vértices a los que éste es adyacente.
     * @return el grado del vértice.
     */
    public abstract int grade();
    
    /**
     * Hace a la intancia adyacente al vértice <i>v</i> y viceverza.
     * @param v el vértice.
     */
    public abstract void addSymmetricNeighbour(Vertex v);
}
