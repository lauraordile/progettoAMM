/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook.servlet;


import amm.nerdbook.classi.UtenteRegistrato;
import amm.nerdbook.classi.Post;
import amm.nerdbook.classi.PostFactory;
import amm.nerdbook.classi.UtentiregistratiFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Laura
 */
public class Bacheca extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession sessione = request.getSession(false);
        
        if(sessione!=null && sessione.getAttribute("loggato")!=null && sessione.getAttribute("loggato").equals(true)){
            

            String parUtente = request.getParameter("utente");
            int idUtente;
            
            if(parUtente != null){
                idUtente = Integer.parseInt(parUtente);
            } else {
                Integer idUtenteLoggato = (Integer)sessione.getAttribute("idUtenteLoggato");
                idUtente=idUtenteLoggato;

            }

            UtenteRegistrato u = UtentiregistratiFactory.getInstance().getUtentiregistratiById(idUtente);
            if(u != null){
                request.setAttribute("utente", u);
                
                List<Post> listaPost = PostFactory.getInstance().getPostList(u);
                request.setAttribute("listaPost", listaPost);

                List<UtenteRegistrato> listaUtenti = UtentiregistratiFactory.getInstance().getListaUtenti();
                request.setAttribute("listaUtenti",listaUtenti);
                
                request.getRequestDispatcher("M4/bacheca.jsp").forward(request, response);
            } else {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            }
        }
        else{
            try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Bacheca</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Bacheca at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            }
        }
    }
 // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
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
     *
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
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}


