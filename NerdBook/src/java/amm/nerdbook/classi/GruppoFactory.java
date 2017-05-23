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
/**
 *
 * @author Laura
 */
public class GruppoFactory {
    private String connectionString;
    //Pattern Design Singleton
    private static GruppoFactory singleton;

    public static GruppoFactory getInstance() {
        if (singleton == null) {
            singleton = new GruppoFactory();
        }
        return singleton;
    }

    private ArrayList<Gruppo> listaGruppo = new ArrayList<Gruppo>();

    private GruppoFactory()  {
        
        /*UtentiregistratiFactory utentiregistratiFactory = UtentiregistratiFactory.getInstance();

        //Creazione Gruppo
        Gruppo gruppo1 = new Gruppo();
       
        UtenteRegistrato u1 = utentiregistratiFactory.getUtentiregistratiById(1);
        UtenteRegistrato u4= utentiregistratiFactory.getUtentiregistratiById(4);
    
        gruppo1.addUtente(u1);
        gruppo1.addUtente(u4);
        gruppo1.setId(0);
        gruppo1.setNomeGruppo("Paperini");
        gruppo1.setDescrizione("");

        Gruppo gruppo2 = new Gruppo();
        UtenteRegistrato u2 = utentiregistratiFactory.getUtentiregistratiById(2);
        UtenteRegistrato u3 = utentiregistratiFactory.getUtentiregistratiById(3);
    
        gruppo2.addUtente(u2);
        gruppo2.addUtente(u3);
        gruppo2.setId(1);
        gruppo2.setNomeGruppo("Topolini");
        gruppo2.setDescrizione("");

        listaGruppo.add(gruppo1);
        listaGruppo.add(gruppo2);
      
    */}
     public Gruppo getGruppoById(int id) {
         UtentiregistratiFactory utenteFactory =UtentiregistratiFactory.getInstance();
        //GruppoFactory gruppoFactory =GruppoFactory.getInstance();
        try {
            Connection conn= DriverManager.getConnection(connectionString,"ammdb","l.ordile");
            String quesry =
                    " select* from gruppo "
                    +" join utentepergruppo on utentepergruppo.gruppo = gruppo.id"
                    +"where id=?";
            PreparedStatement stmt= conn.prepareStatement(quesry);
            stmt.setInt(1, id);
            ResultSet res=stmt.executeQuery();
            if(res.next()){
                Gruppo current= new Gruppo();
                current.setId(res.getInt("id"));
                current.setNomeGruppo(res.getString("nome"));
                current.setDescrizione(res.getString("descrizione"));
                UtenteRegistrato amministratore = utenteFactory.getUtentiregistratiById(res.getInt("amministratore"));
                current.setAmministratore(amministratore);

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
        /*for (Post post : this.listaPost) {
            if (post.getId() == id) {
                return post;
            }
        }*/
        return null;
    }

   

      public Gruppo getUtenteByName(int idGruppo)
    {
        for (Gruppo gruppo : this.listaGruppo) 
        {
            if (gruppo.getNomeGruppo().equals(idGruppo))
                return gruppo;
        }
        return null;
    } 
    
      public void setConnectionString(String s){
	this.connectionString = s;
}

      public String getConnectionString(){
	return this.connectionString;
      }
}
