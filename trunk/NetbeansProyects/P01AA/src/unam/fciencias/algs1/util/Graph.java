package unam.fciencias.algs1.util;

import java.util.List;
/**
 * Interfaz de la clase Graph G=(V,E) donde V es un conjunto de 
 * Vertices (Vertex) y E es un conjunto de aristas (Edge) 
 * (formadas por pares de vertices en V). V no vacio.
 * @author Daniel Estevez Fuentes
 */
public interface Graph{
    /*
     * =========================================================================
     * -------------------------------- FIELDS ---------------------------------
     * =========================================================================
     */
    /** indice nulo. */
    public static int NULL_INDEX = -1;
    /** Peso predeterminado */
    public static int DEFAULT_WEIGHT = 1;
    /*
     * =========================================================================
     * -------------------------------- FIELDS ---------------------------------
     * =========================================================================
     */
    
    /*
     * =========================================================================
     * -------------------------------- METHODS --------------------------------
     * =========================================================================
     */
    /**
     * Obtiene el numero de vertices de la grafica.
     * @return el numero de vertices n.
     */
    public int getVertexNum();
    
    /**
     * Obtiene el numero de aristas de la grafica.
     * @return el numero de aristas
     */
    public int getEdgesNum();

    /**
     * Regresa una List de vertices de la grafica.
     * @return lista de vertices
     */
    public List<Vertex> getVertexList();
    
    /**
     * Regresa un arreglo de vertices de la grafica.
     * @return arreglo de vertices.
     */
    public Vertex[] getVertexArray();

    /**
     * Regresa un objeto Vertex correspondiente al vertice con identificador
     * entero i, el entero i identifica un vertice de la grafica de manera
     * unica.
     * @param i el identificador del vertice.
     * @return el objeto vertex correpondiente.
     */
    public Vertex getVertex(int i);

    /**
     * Regresa una List de aristas de la grafica,
     * si el conjunto de aristas de la grafica es vacio regresa null.
     * @return lista de aristas.
     */    
    public List<Edge> getEdgesList();
        
    /**
     * Regresa un arreglo de aristas de la grafica,
     * si el conjunto de aristas de la grafica es vacio regresa null.
     * @return arreglo de aristas.
     */
    public Edge[] getEdgesArray();
    
    /**
     * Regresa un objeto Edge que une al vertice inicio con el vertice fin,
     * si existe; si no existe tal arista se regresa una con peso 0. 
     * @param start vertice de partida.
     * @param end vertice de llegada.
     * @return una arista que une start con end.
     */    
    public Edge getEdge(Vertex start, Vertex end);
    
    /**
     * Regresa la arista etiquetada con el numero i de la grafica,
     * si no existe arista, regresa una arista con peso 0.
     * @param i el numero de arista que se requiere.
     * @return la arista etiquetada con i.
     */    
    public Edge getEdge(int i);
    
    /**
     * Devuelve true si los vertices start y end son adyacentes
     * (si existe arista entre ellos)y false en otro caso.
     * @param start vertice de partida.
     * @param end vertice de llegada.
     * @return true si start es adyacente a end, false en otro caso.
     */
    public boolean isAdjacent(Vertex start, Vertex end);
    
    /**
     * Devuelve true si los dos vertices numerados con i,j son adyacentes
     * y false en otro caso.
     * @param i indice del vertice de partida.
     * @param j indice del vertice de llegada.
     * @return true si i es adyacente a j, false en otro caso.
     */
    public boolean isAdjacent(int i, int j) ;
    
    /**
     * Obtiene el grado del vertice v (el numero de vertices adyacentes a el).
     * @param v el vertice.
     * @return el grado de v.
     */    
    public int getDegree(Vertex v);
    
    /**
     * Obtiene el grado del vertice i-esimo de la grafica
     * (el numero de vertices adyacentes a el).
     * @param i indice del vertice.
     * @return el grado de tal vertice.
     */
    public int getDegree(int i);
    
    /**
     * Obtiene el peso de la arista e. Si no existe tal arista se regresa 0.
     * @param e la arista.
     * @return un entero que corresponde al peso de la arista e.
     */
    public int getWeight(Edge e);
    
    /**
     * obtiene el peso de la arista conformada por los vertices start y end.
     * Si no existe tal arista se regresa 0
     * @param start vertice de partida.
     * @param end vertice de llegada.
     * @return un entero que corresponde al peso de la arista 
     */    
    public int getWeight(Vertex start,Vertex end);
    
    /**
     * Obtiene el peso de la arista conformada por los vertices start y end
     * identificados como el i-esimo y j-esimo respectivamente.
     * Si no existe tal arista se regresa 0.
     * @param start vertice de partida.
     * @param end vertice de llegada.
     * @return un entero que corresponde al peso de la arista.
     */        
    public int getWeight(int start,int end);
    
    /**
     * Obtiene un arreglo de los vecinos del vertice v.
     * @param v el vertice.
     * @return el arreglo de vecinos.
     */    
    public Vertex[] getNeighborsArray(Vertex v);
    
    /**
     * Obtiene un arreglo de los vecinos del vertice i-esimo de la grafica
     * @param i el identificador del vertice
     * @return el arreglo de vecinos
     */        
    public Vertex[] getNeighborsArray(int i);
    
    /**
     * Obtiene una List de los vecinos del vertice v.
     * @param v el vertice.
     * @return la lista de vecinos.
     */        
    public List<Vertex> getNeighborsList(Vertex v);
    
    /**
     * Obtiene una List de los vecinos del vertice i-esimo de la grafica.
     * @param i el identificador del vertice
     * @return la lista de vecinos
     */            
    public List<Vertex> getNeighborsList(int i);
    
    @Override
    public String toString();
    /*
     * =========================================================================
     * -------------------------------- METHODS --------------------------------
     * =========================================================================
     */
}
