/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook.servlet;


import amm.nerdbook.classi.GruppoFactory;
import amm.nerdbook.classi.PostFactory;
import amm.nerdbook.classi.UtenteRegistrato;
import amm.nerdbook.classi.UtentiregistratiFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
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
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        
        HttpSession sessione = request.getSession();
        
        // logout
        if(request.getParameter("logout")!=null){
            sessione.invalidate();
            request.getRequestDispatcher("M4/login.jsp").forward(request, response);
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
                    request.getRequestDispatcher("M4/login.jsp").forward(request, response);
                    return;
                }  
             }
        }
 
        request.getRequestDispatcher("M4/login.jsp").forward(request, response);
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
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


