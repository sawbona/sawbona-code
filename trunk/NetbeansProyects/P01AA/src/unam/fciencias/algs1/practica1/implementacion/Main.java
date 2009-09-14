/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package unam.fciencias.algs1.practica1.implementacion;

import unam.fciencias.algs1.util.Edge;
import unam.fciencias.algs1.util.Graph;
import unam.fciencias.algs1.util.Vertex;

/**
 *
 * @author jacob
 */
public class Main {

    public static void main(String args[]){
        Vertex uno = new SimpleVertex();
        Vertex dos = new SimpleVertex();
        Vertex tres = new SimpleVertex();
        Vertex[] vertices = new Vertex[]{uno, dos, tres};
        Edge aristaUno = new Edge(dos, tres);
        Edge aristaDos = new Edge(dos, uno);
        Edge[] aristas = new Edge[]{aristaUno, aristaDos};

    }
}
