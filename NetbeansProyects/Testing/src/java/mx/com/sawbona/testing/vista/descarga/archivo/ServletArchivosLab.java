/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.com.sawbona.testing.vista.descarga.archivo;

import java.io.IOException;
import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mx.com.sawbona.testing.acceso.datos.DataDaoUtil;
import mx.com.sawbona.testing.modelo.ArchivoLab;

/**
 *
 * @author jacob
 */
public class ServletArchivosLab extends HttpServlet {
    private static final long serialVersionUID = -3371622906659437189L;
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        String nombreDelArchivo = requestURI.substring(requestURI.lastIndexOf("/") + 1, requestURI.length());
        EntityManager entityManager = DataDaoUtil.getEntityManager();
        ArchivoLab leido = entityManager.find(ArchivoLab.class, nombreDelArchivo);
        response.setContentType("application/octet-stream");
        response.getOutputStream().write(leido.getBytes());
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
