/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package unam.fciencias.algs1.practica1.implementacion;

import java.util.LinkedList;
import java.util.List;
import unam.fciencias.algs1.util.Vertex;

/**
 *
 * @author jacob
 */
public class SimpleVertex extends Vertex{

    private List<Vertex> vecinos = new LinkedList<Vertex>();

    @Override
    public List<Vertex> getNeighboursList() {
        return vecinos;
    }

    @Override
    public Vertex getNeighbour(int i) {
        return vecinos.get(i);
    }

    @Override
    public void addNeighbours(List<Vertex> vs) {
        vecinos.addAll(vs);
    }

    @Override
    public void addSymmetricNeighbours(List<Vertex> vs) {
        vecinos.addAll(vs);
        for (Vertex vertex : vs) {
            vertex.addNeighbour(this);
        }
    }

    @Override
    public void addNeighbour(Vertex v) {
        vecinos.add(v);
    }

    @Override
    public int grade() {
        return vecinos.size();
    }

    @Override
    public void addSymmetricNeighbour(Vertex v) {
        vecinos.add(v);
        v.addNeighbour(this);
    }

}
