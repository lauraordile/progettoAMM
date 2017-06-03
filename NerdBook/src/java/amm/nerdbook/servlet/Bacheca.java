/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook.servlet;


import amm.nerdbook.classi.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
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
        
        if(sessione!=null && sessione.getAttribute("loggedIn")!=null && sessione.getAttribute("loggedIn").equals(true)){
            
            
            
            int loggedUserID = (Integer)sessione.getAttribute("loggedUserID");
            UtenteRegistrato loggedUser = UtentiregistratiFactory.getInstance().getUtentiregistratiById(loggedUserID);
            
            /* leggo i parametri group e user, se presenti */
            String userp = request.getParameter("user");
            String paramGroup = request.getParameter("group");
            int userID =-1;
            int idGroup=-1;
            
            /* Se è presente il parametro group, leggo l'id del gruppo di cui voglio vedere i post */
            if(paramGroup != null)
                idGroup = Integer.parseInt(paramGroup);
            // altrimenti
            else{
                /* se è presente invece il parametro user, leggo l'id dell'utente */
                if(userp != null)
                    userID = Integer.parseInt(userp);
                // se nessuno dei due è presente, leggo la bacheca dell'utente loggato
                else{                   
                   // Integer loggedUserID = (Integer)sessione.getAttribute("loggedUserID");
                    userID = loggedUserID;
                }
            }

            /* carico i dati di utente/gruppo che voglio visualizzare (uno dei due sarà null) */
            UtenteRegistrato user = UtentiregistratiFactory.getInstance().getUtentiregistratiById(userID);
            Gruppo gruppo = GruppoFactory.getInstance().getGruppoById(idGroup);
            
            List<Post> posts;
            if(gruppo != null ){ // se ho scelto un gruppo, ed è presente, carico i suoi dati e imposto la richiesta
                posts = PostFactory.getInstance().getPostList(gruppo);
                request.setAttribute("gruppo", gruppo);
                request.setAttribute("tipoBacheca","group");
                request.setAttribute("nomeDest",gruppo.getNomeGruppo());
            }else{
                if(user == null) // se non è stato scelto un gruppo, e l'eventuale utente cercato è inesistente, si carica l'utente loggato
                    user = loggedUser;
                posts = PostFactory.getInstance().getPostList(user);
                request.setAttribute("user", user);
                request.setAttribute("tipoBacheca","user");
                request.setAttribute("nomeDest",user.getNome());
            }

            request.setAttribute("posts", posts);
            List<UtenteRegistrato> amici = UtentiregistratiFactory.getInstance().getFriendList(loggedUserID);
            request.setAttribute("friends", amici);
            //List<Gruppo> gruppi = GruppoFactory.getInstance().getGroupListByUser(loggedUserID);
            //request.setAttribute("groups", gruppi);
            request.getRequestDispatcher("M5/bacheca.jsp").forward(request, response);
        }
        else{
            try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Accesso Negato</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Errore: Accesso Negato</h1>");
            out.println("</body>");
            out.println("</html>");
            }
  }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

            
           /* String parUtente = request.getParameter("utente");
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
            request.getRequestDispatcher("Login").forward(request, response);
        }*/
    
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


