/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook.classi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Laura
 */
public class UtentiregistratiFactory {
  
    private static UtentiregistratiFactory singleton;

    public static UtentiregistratiFactory getInstance() {
        if (singleton == null) {
            singleton = new UtentiregistratiFactory();
        }
        return singleton;
    }

    private String connectionString;
    public void setConnectionString(String s){
	this.connectionString = s;
    }
    
    public String getConnectionString(){
            return this.connectionString;
    }
    //private ArrayList<UtenteRegistrato> listaUtentiregistrati = new ArrayList<UtenteRegistrato>();

    private UtentiregistratiFactory() {
        //Creazione utenti

        //Djanni
        /*
        UtenteRegistrato utente1 = new UtenteRegistrato();
        utente1.setId(1);
        utente1.setNome("Donald");
        utente1.setEmail("DonaldFauntleroyDuck@gmail.com");
        utente1.setCognome("Fauntleroy Duck");
        utente1.setPassword("1234");
        utente1.setUrlProfilo("img/djanniprofilo.jpg");
        utente1.setFrase("");
        utente1.setDataNascita("");

        //HeavyBreathing
        UtenteRegistrato utente2 = new UtenteRegistrato();
        utente2.setId(2);
        utente2.setNome("Minerva");
        utente2.setEmail("MinervaMouse@gmail.com");
        utente2.setCognome("Mouse");
        utente2.setPassword("5678");
        utente2.setUrlProfilo("img/djanniprofilo.jpg");
        utente2.setFrase("");
        utente2.setDataNascita("");

        //GymWorkOut
        UtenteRegistrato utente3 = new UtenteRegistrato();
        utente3.setId(3);
        utente3.setNome("Mickey");
        utente3.setEmail("MickeyMouse@gmail.com");
        utente3.setCognome("Mouse");
        utente3.setPassword("91011");
        utente3.setUrlProfilo("img/djanniprofilo.jpg");
        utente3.setFrase("");
        utente3.setDataNascita("");
       
        UtenteRegistrato utente4 = new UtenteRegistrato();
        utente4.setId(4);
        utente4.setNome("Daisy");
        utente4.setEmail("DaisyDuck@gmail.com");
        utente4.setCognome("Duck");
        utente4.setPassword("1213");
        utente4.setUrlProfilo("img/djanniprofilo.jpg");
        utente4.setFrase("");
        utente4.setDataNascita("");

        listaUtentiregistrati.add(utente1);
        listaUtentiregistrati.add(utente2);
        listaUtentiregistrati.add(utente3);
        listaUtentiregistrati.add(utente4);*/
    }

    public UtenteRegistrato getUtentiregistratiById(int id) {
        
        try {
            Connection conn= DriverManager.getConnection(connectionString,"ammdb","l.ordile");
            String quesry =
                    "select* from utente"
                    +"where id=?";
            PreparedStatement stmt= conn.prepareStatement(quesry);
            stmt.setInt(1, id);
            ResultSet res=stmt.executeQuery();
            if(res.next()){
                UtenteRegistrato current=new UtenteRegistrato();
                current.setId(res.getInt("id"));
                current.setNome(res.getString("nome"));
                current.setEmail(res.getString("email"));
                current.setCognome(res.getString("cognome"));
                current.setPassword(res.getString("password"));
                current.setUrlProfilo(res.getString("urlFoto"));
                current.setFrase(res.getString("frasePresentazione"));
                
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

                String DateAsString = sdf.format("dataNascita");
                current.setDataNascita(res.getDate(DateAsString));
               /*input*/
               /*String dataNascita = request.getParameter("data");
                java.util.Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dataNascita);
                preparedStatement.setDate(index,new java.sql.Date(date.getTime())); */ 
                stmt.close();
                conn.close();
                return current;
            }
            stmt.close();
            conn.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return null;
        /*for (UtenteRegistrato utente : this.listaUtentiregistrati) {
            if (utente.getId() == id) {
                return utente;
            }
        }
        return null;*/
    }
    
    public int getIdByUserAndPassword(String user, String password){
       try{
           Connection conn= DriverManager.getConnection(connectionString,"ammdb","l.ordile");
            String quesry =
                    "select id from utente"
                    +"where email = ? and password = ?";
           PreparedStatement stmt= conn.prepareStatement(quesry);

             stmt.setString(1, user);
             stmt.setString(2, password);
             ResultSet res = stmt.executeQuery();
             
             if(res.next()){
                 int id= res.getInt("id");
                 
                 stmt.close();
                 conn.close();
                 return id;
             }
             stmt.close();
             conn.close();
             
       }
       catch(SQLException e){
            e.printStackTrace();
            
        }
       return -1;
       }
    
     public List getListaUtenti(String nome) {
        List<UtenteRegistrato> listaUtentiregistrati = new ArrayList<UtenteRegistrato>();
         
        try{
            Connection conn = DriverManager.getConnection(connectionString, "ammdb","l.ordile");
           
            String query = 
                      "select * from utente where nome like?";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            stmt.setString(1,"%" + nome + "%");
            // Esecuzione query
            ResultSet res = stmt.executeQuery();

           // ciclo sulle righe restituite
            while (res.next()) {
                UtenteRegistrato current = new UtenteRegistrato();
                current.setId(res.getInt("id"));
                current.setNome(res.getString("nome"));
                current.setCognome(res.getString("cognome"));
                current.setPassword(res.getString("password"));
                current.setEmail(res.getString("email"));
                current.setUrlProfilo(res.getString("urlFoto"));
                //current.setDataNascita(res.getDate("dataNascita"));
                
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String DateAsString = sdf.format("dataNascita");
                current.setDataNascita(res.getDate(DateAsString));
                
                listaUtentiregistrati.add(current);
            }

            stmt.close();
            conn.close();
        } catch (SQLException e) {
        }
        
        return listaUtentiregistrati;
     }
    
    public List getListaUtenti() {
        List<UtenteRegistrato> listaUtentiregistrati = new ArrayList<UtenteRegistrato>();
         
        try{
            Connection conn = DriverManager.getConnection(connectionString, "ammdb","l.ordile");
           
            String query = 
                      "select * from utente";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Esecuzione query
            ResultSet res = stmt.executeQuery();

           // ciclo sulle righe restituite
            while (res.next()) {
                UtenteRegistrato current = new UtenteRegistrato();
                current.setId(res.getInt("id"));
                current.setNome(res.getString("nome"));
                current.setCognome(res.getString("cognome"));
                current.setPassword(res.getString("password"));
                current.setPassword(res.getString("password"));
                current.setEmail(res.getString("email"));
                current.setUrlProfilo(res.getString("urlFoto"));
                //current.setDataNascita(res.getDate("dataNascita"));
                 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

                String DateAsString = sdf.format("dataNascita");
                current.setDataNascita(res.getDate(DateAsString));
                
                listaUtentiregistrati.add(current);
            }

            stmt.close();
            conn.close();
        } catch (SQLException e) {
        }
        
        return listaUtentiregistrati;
     }
    
   
     
      public int login(String email, String password) {
        try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "ammdb","l.ordile");
            
            String query = 
                      "select * id from utente "
                    + "where email = ? and password = ?";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Si associano i valori
            stmt.setString(1, email);
            stmt.setString(2, password);
            
            // Esecuzione query
            ResultSet res = stmt.executeQuery();
            int utenteLoggato;
                
            if (res.next()) {
                utenteLoggato = res.getInt("id");
                
                stmt.close();
                conn.close();
                return utenteLoggato;
            }

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
}
      
      public void aggiornaProfilo(UtenteRegistrato utente){
        try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "Nerdbook", "password");
            
            String query = 
                    "UPDATE utente SET nome = ?, cognome = ?, email = ?, "
                    + "password = ?, urlProfilo = ?, dataNascita = ?, presentazione = ? "
                    + "WHERE id = ?";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Si associano i valori
            stmt.setString(1, utente.getNome());
            stmt.setString(2, utente.getCognome());
            stmt.setString(3, utente.getEmail());
            stmt.setString(4, utente.getPassword());
            stmt.setString(5, utente.getFrase());
            stmt.setString(6, utente.getUrlProfilo());
            stmt.setDate(7, utente.getDataNascita());
            stmt.setInt(8,utente.getId());
            // Esecuzione query
            stmt.execute();

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }    
   
    
    public List getFriendList(int id) {
        
        try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString,"ammdb","l.ordile");
            List<UtenteRegistrato> amici = new ArrayList<>();
            String query = 
                    "SELECT * FROM Utente " +
                    "JOIN Amicizie ON Utente.id = Amicizie.Utente1 " +
                    "WHERE Amicizie.Utente2 = ? " +
                    "UNION " +
                    "SELECT * FROM Utente " +
                    "JOIN Amicizie ON Utente.id = Amicizie.Utente2 " +
                    "WHERE Amicizie.Utente1 = ?";
            
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            // Si associano i valori
            stmt.setInt(1, id);
            stmt.setInt(2, id);
            
            // Esecuzione query
            ResultSet res;
            UtenteRegistrato current;
            res = stmt.executeQuery();
            
            // ciclo sulle righe restituite
            while (res.next()) {
                current = new UtenteRegistrato();
                current.setId(res.getInt("id"));
                current.setNome(res.getString("nome"));
                current.setCognome(res.getString("cognome"));   
                 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

                String DateAsString = sdf.format("dataNascita");
                current.setDataNascita(res.getDate(DateAsString));
                //current.setDataNascita(res.getString("dataNascita"));
                current.setFrase(res.getString("frasepresentazione"));
                current.setUrlProfilo(res.getString("urlFoto"));
                current.setPassword(res.getString("password"));
                current.setEmail(res.getString("email"));
                amici.add(current);
            }
            
            stmt.close();
            conn.close();
            return amici;
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
}
        public void deleteUser(UtenteRegistrato user){
       
        try{
            Connection connessione = DriverManager.getConnection(connectionString,"ammdb","l.ordile");
            String query = "delete from utentepergruppo where utente = ? ";
            PreparedStatement frase = connessione.prepareStatement(query);
            frase.setInt(1, user.getId());
            frase.executeUpdate();
            
            query = "delete from utenti where utenteId = ?";
            frase = connessione.prepareStatement(query);
            frase.setInt(1, user.getId());
            frase.executeUpdate();
            
            frase.close();
            connessione.close();
        } 
        catch (SQLException e) {
            System.out.println("Errore SQL su eliminaListaPost");
            e.printStackTrace();
        }

}
        public List getUtentiList(int id) {
        
        try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "nerd", "nerd");
            List<UtenteRegistrato> amici = new ArrayList<>();
            String query = 
                    "SELECT * FROM utente " +
                    "JOIN amicizie ON utente.id = amicizie.idUtente1 " +
                    "WHERE amicizie.idUtente2 = ? " +
                    "UNION " +
                    "SELECT * FROM utente " +
                    "JOIN amicizie ON utente.id = amicizie.idUtente2 " +
                    "WHERE amicizie.idUtente1 = ?";
            
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            // Si associano i valori
            stmt.setInt(1, id);
            stmt.setInt(2, id);
            
            // Esecuzione query
            ResultSet res;
            UtenteRegistrato current;
            res = stmt.executeQuery();
            
            // ciclo sulle righe restituite
            while (res.next()) {
                current = new UtenteRegistrato();
                current.setId(res.getInt("id"));
                current.setNome(res.getString("nome"));
                current.setCognome(res.getString("cognome"));
                current.setPassword(res.getString("password"));
                current.setEmail(res.getString("email"));
                current.setUrlProfilo(res.getString("urlFoto"));
                current.setFrase(res.getString("frasepresentazione"));
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

                String DateAsString = sdf.format("dataNascita");
                current.setDataNascita(res.getDate(DateAsString));
                //current.setDataNascita(res.getString("dataNascita"));
                amici.add(current);
            }
            
            stmt.close();
            conn.close();
            return amici;
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public List getUtentiList(String nome, int id) {
        List<UtenteRegistrato> listaUtenti = new ArrayList<UtenteRegistrato>();
        
        try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "nerd", "nerd");
            
            String query = 
                      "select * from utente" +
                      "where nome like ? or cognome like ? and id in ";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Si associano i valori
            stmt.setString(1, "%" + nome + "%");
            stmt.setString(2, "%" + nome + "%");
            stmt.setInt(3, id);
            stmt.setInt(4, id);
            
            // Esecuzione query
            ResultSet res = stmt.executeQuery();

            // ciclo sulle righe restituite
            while (res.next()) {
                UtenteRegistrato current = new UtenteRegistrato();
                current.setId(res.getInt("id"));
                current.setNome(res.getString("nome"));
                current.setCognome(res.getString("cognome"));
                current.setEmail(res.getString("email"));
                current.setPassword(res.getString("password"));
                current.setUrlProfilo(res.getString("urlProfilo"));
               SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

                String DateAsString = sdf.format("dataNascita");
                current.setDataNascita(res.getDate(DateAsString));
                //current.setDataNascita(res.getString("dataNascita"));
                current.setFrase(res.getString("frasepresentazione"));
                
                listaUtenti.add(current);
            }

            stmt.close();
            conn.close();
            return listaUtenti;
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
        
}
}
