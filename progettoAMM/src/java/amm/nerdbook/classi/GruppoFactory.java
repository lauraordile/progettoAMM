/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook.classi;
import java.util.ArrayList;
/**
 *
 * @author Laura
 */
public class GruppoFactory {
    
    //Pattern Design Singleton
    private static GruppoFactory singleton;

    public static GruppoFactory getInstance() {
        if (singleton == null) {
            singleton = new GruppoFactory();
        }
        return singleton;
    }

    private ArrayList<Gruppo> listaGruppo = new ArrayList<Gruppo>();

    private GruppoFactory() {
        
        UtentiregistratiFactory utentiregistratiFactory = UtentiregistratiFactory.getInstance();

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
      
    }

    public Gruppo getGruppoById(int id) {
        for (Gruppo gruppo : this.listaGruppo) {
            if (gruppo.getId() == id) {
                return gruppo;
            }
        }
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
    
}
