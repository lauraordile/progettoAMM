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
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
/**
 *
 * @author Laura
 */
public class UtentiregistratiFactory {
    //private String connectionString;
      //Pattern Design Singleton
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
    private ArrayList<UtenteRegistrato> listaUtentiregistrati = new ArrayList<UtenteRegistrato>();

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
                
                //current.setDataNascita(res.("datanascita"));
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
                    +"where nome = ? and password = ?";
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
       return -1;/*
        for (UtenteRegistrato utente : this.listaUtentiregistrati){
            if(utente.getNome().equals(user)&& utente.getPassword().equals(password)){
                return utente.getId();
            }
        }
        return -1;*/
    }
    
    public List getListaUtenti() {
        return listaUtentiregistrati;
    }
   
     public int login(String nome ,String password) {
        for (UtenteRegistrato user : this.listaUtentiregistrati) {
            if (user.getNome().equals(nome) && user.confermaPassword(password)) {
                return user.getId();
            }
        }
        return -1;
    }
}
