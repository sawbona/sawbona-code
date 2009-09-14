/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package unam.fciencias.algs1.practica1.implementacion;

import java.util.Arrays;
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

    public Edge getEdge(int i) {
        return aristas[i];
    }

    public boolean isAdjacent(Vertex start, Vertex end) {
        for (int i = 0; i < aristas.length; i++) {
            Edge arista = aristas[i];
            if(arista.getSource() == start && arista.getTarget() == end ||
                    (arista.getSource() == end && arista.getTarget() == start)){
                return true;
            }
        }
        return false;
    }

    public boolean isAdjacent(int i, int j) {
        return isAdjacent(vertices[i], vertices[j]);
    }

    public int getDegree(Vertex v) {
        return v.grade();
    }

    public int getDegree(int i) {
        return vertices[i].getNeighboursList().size();
    }

    public int getWeight(Edge e) {
        return e.getWeight();
    }

    public int getWeight(Vertex start, Vertex end) {
        return getEdge(start, end).getWeight();
    }

    public int getWeight(int start, int end) {
        return getEdge(vertices[start], vertices[end]).getWeight();
    }

    public Vertex[] getNeighborsArray(Vertex v) {
       return (Vertex[]) v.getNeighboursList().toArray();
    }

    public Vertex[] getNeighborsArray(int i) {
        return (Vertex[]) vertices[i].getNeighboursList().toArray();
    }

    public List<Vertex> getNeighborsList(Vertex v) {
        return v.getNeighboursList();
    }

    public List<Vertex> getNeighborsList(int i) {
        return vertices[i].getNeighboursList();
    }

}
