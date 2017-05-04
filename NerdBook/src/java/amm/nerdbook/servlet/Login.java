/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook.servlet;


import amm.nerdbook.classi.UtenteRegistrato;
import amm.nerdbook.classi.UtentiregistratiFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
public class Login extends HttpServlet {

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
        
        HttpSession sessione = request.getSession();
        
        // logout
        if(request.getParameter("logout")!=null){
            sessione.invalidate();
            request.getRequestDispatcher("M3/login.jsp").forward(request, response);
            return;
        }
        
        // sessione attiva 
        if (sessione.getAttribute("loggato") != null && sessione.getAttribute("loggato").equals(true)) {
            request.getRequestDispatcher("Bacheca").forward(request, response);
            return;
        }
        else {
            // sessione non attiva
            String username = request.getParameter("username");
            String password = request.getParameter("password");
        
            if (username != null && password != null){
                // faccio il login
                int idUtenteLoggato = UtentiregistratiFactory.getInstance().login(username, password);
                //se l'utente è valido...
                if(idUtenteLoggato!=-1){
                    sessione.setAttribute("utenteLoggato", UtentiregistratiFactory.getInstance().getUtentiregistratiById(idUtenteLoggato));
                    sessione.setAttribute("idUtenteLoggato", idUtenteLoggato);
                    sessione.setAttribute("loggato", true);
                    return;
                } else { 
                    
                    //dati Sbagliati
                    request.setAttribute("datiSbagliati", true);
                    request.getRequestDispatcher("M3/login.jsp").forward(request, response);
                    return;
                }  
             }
        }
 
        request.getRequestDispatcher("M3/login.jsp").forward(request, response);
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
