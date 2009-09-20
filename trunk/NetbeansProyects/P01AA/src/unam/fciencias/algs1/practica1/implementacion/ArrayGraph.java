/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package unam.fciencias.algs1.practica1.implementacion;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import unam.fciencias.algs1.util.Edge;
import unam.fciencias.algs1.util.Graph;
import unam.fciencias.algs1.util.Vertex;

/**
 *
 * @author jacob
 */
public class ArrayGraph implements Graph{

    private Vertex[] vertices;

    private Edge[] aristas;

    public int getVertexNum() {
        return vertices.length;
    }

    public int getEdgesNum() {
        return aristas.length;
    }

    public List<Vertex> getVertexList() {
        return Arrays.asList(vertices);
    }

    public Vertex[] getVertexArray() {
        return vertices;
    }

    public Vertex getVertex(int i) {
        return vertices[i];
    }

    public List<Edge> getEdgesList() {
        return Arrays.asList(aristas);
    }

    public Edge[] getEdgesArray() {
        return aristas;
    }

    public Edge getEdge(Vertex start, Vertex end) {
        Edge resultado = new Edge(start, end);
        return resultado;
    }

    private Edge getEdge(Vertex s, Vertex E, List<Vertex> visitados){
        for(int i = 0; i < aristas.length ; ++i){
            if(visitado){

            }
        }
    }


    public Edge getEdge(int i) {
        return aristas[i];
    }

    public final boolean isAdjacent(Vertex start, Vertex end) {
        for (int i = 0; i < aristas.length; i++) {
            Edge arista = aristas[i];
            if(arista.getSource() == start && arista.getTarget() == end){
                return true;
            }
        }
        return false;
    }

    public boolean isAdjacent(int i, int j) {
        return isAdjacent(vertices[i], vertices[j]);
    }

    public int getDegree(Vertex v) {
        return getNeighborsList(v).size();
    }

    public int getDegree(int i) {
        return getNeighborsList(vertices[i]).size();
    }

    public int getWeight(Edge e) {
        return getEdge(e.getSource(), e.getTarget()).getWeight();
    }

    public int getWeight(Vertex start, Vertex end) {
        return getEdge(start, end).getWeight();
    }

    public int getWeight(int start, int end) {
        return getEdge(vertices[start], vertices[end]).getWeight();
    }

    public Vertex[] getNeighborsArray(Vertex v) {
       return (Vertex[]) getNeighborsList(v).toArray();
    }

    public Vertex[] getNeighborsArray(int i) {
        return (Vertex[]) getNeighborsList(vertices[i]).toArray();
    }

    public final List<Vertex> getNeighborsList(Vertex v) {
        List<Vertex> vecinos = new LinkedList<Vertex>();
        for(int i = 0; i < aristas.length; ++i){
            Edge arista = aristas[i];
            if(arista.getSource() == v){
                vecinos.add(arista.getTarget());
            }
        }
        return vecinos;
    }

    public List<Vertex> getNeighborsList(int i) {
        return vertices[i].getNeighboursList();
    }

}
