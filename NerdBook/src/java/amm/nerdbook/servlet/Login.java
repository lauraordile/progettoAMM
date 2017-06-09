/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook.servlet;

import amm.nerdbook.classi.*;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Laura
 *
 */
@WebServlet(loadOnStartup = 0)
public class Login extends HttpServlet {
    private static final String JDBC_DRIVER ="org.apache.derby.jdbc.EmbeddedDriver";
    private static final String DB_CLEAN_PATH = "../../web/WEB-INF/db/ammdb";
    private static final String DB_BUILD_PATH = "WEB-INF/db/ammdb";



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
            request.setAttribute("loggedIn", false);
            request.getRequestDispatcher("M5/login.jsp").forward(request, response);
            return;
        }
        
        // sessione attiva 
        if (sessione.getAttribute("loggedIn") != null && sessione.getAttribute("loggedIn").equals(true)) {
            request.getRequestDispatcher("Bacheca").forward(request, response);
            int loggedUserID = (int)sessione.getAttribute("loggedUserID");
            UtenteRegistrato utente = UtentiregistratiFactory.getInstance().getUtentiregistratiById(loggedUserID);
            return;
        }
        else {
            // sessione non attiva
            String email = request.getParameter("email");
            String password = request.getParameter("password");
        
            if (email != null && password != null){
                // faccio il login
                int idUtenteLoggato = UtentiregistratiFactory.getInstance().getIdByUserAndPassword(email, password);
                //se l'utente è valido...
                if(idUtenteLoggato!=-1){
                    
                    sessione.setAttribute("loggedIn", true);
                    sessione.setAttribute("loggedUserID", idUtenteLoggato);
                    //UtenteRegistrato loggedUser = UtentiregistratiFactory.getInstance().getIdByUserAndPassword(email,password);
                   // sessione.setAttribute("loggedUser", loggedUser);
                    
                   // if(loggedUser!=null && loggedUser.incompleto())
                       // request.getRequestDispatcher("Profilo").forward(request, response);
                    //else
                        request.getRequestDispatcher("Bacheca").forward(request, response);
                    return;
                    //sessione.setAttribute("utenteLoggato", UtentiregistratiFactory.getInstance().getUtentiregistratiById(idUtenteLoggato));
                    //sessione.setAttribute("idUtenteLoggato", idUtenteLoggato);
                    //sessione.setAttribute("loggedIn", true);
                    //request.getRequestDispatcher("Bacheca").forward(request, response);
                    //return;
                } else { 
                    
                    //dati Sbagliati
                    request.setAttribute("datiSbagliati", true);
                    request.getRequestDispatcher("M5/login.jsp").forward(request, response);
                    return;
                }  
             }
        }
 
        request.getRequestDispatcher("M5/login.jsp").forward(request, response);
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
    @Override
   public void init(){

       String dbConnection = "jdbc:derby:" + this.getServletContext().getRealPath("/") + DB_BUILD_PATH;
       try {
           Class.forName(JDBC_DRIVER);
       } catch (ClassNotFoundException ex) {
           Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
       }
       UtentiregistratiFactory.getInstance().setConnectionString(dbConnection);
       GruppoFactory.getInstance().setConnectionString(dbConnection);
       PostFactory.getInstance().setConnectionString(dbConnection);
   }
}


