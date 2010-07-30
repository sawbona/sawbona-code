/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sawbona.code.test.ejb.war;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sawbona.code.test.ejb.f1.SimpleEJBF1Interface;

/**
 *
 * @author jacob
 */
public class ServletSaludador extends HttpServlet {

    @EJB(mappedName = "ejb/BusinessBDBean")
    private SimpleEJBF1Interface simpleEJBF1Interface;
//    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("EntitiesF3PU");
//    private static EntityManager em;


//    static {
//        em = emf.createEntityManager();
//    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletSaludador Prueba F1</title>");
            out.println("</head>");
            out.println("<body>");
            out.print("<h1>");
//            em.getTransaction().begin();
            out.print("Objeto encontrado: " + simpleEJBF1Interface.findNegocio(sawbona.code.test.entities.f3.EJB.class));
//            em.getTransaction().commit();
            out.print("</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
//        } catch (NamingException ex) {
//            Logger.getLogger(ServletSaludador.class.getName()).log(Level.SEVERE, null, ex);
//        }
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
