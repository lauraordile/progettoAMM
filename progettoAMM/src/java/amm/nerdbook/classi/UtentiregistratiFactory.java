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
public class UtentiregistratiFactory {
      //Pattern Design Singleton
    private static UtentiregistratiFactory singleton;

    public static UtentiregistratiFactory getInstance() {
        if (singleton == null) {
            singleton = new UtentiregistratiFactory();
        }
        return singleton;
    }

    private ArrayList<Utentiregistrati> listaUtentiregistrati = new ArrayList<Utentiregistrati>();

    private UtentiregistratiFactory() {
        //Creazione utenti

        //Djanni
        Utentiregistrati utente1 = new Utentiregistrati();
        utente1.setId(0);
        utente1.setNome("Djanni");
        utente1.setEmail("djannigatto@gmail.com");
        utente1.setCognome("Incrocio");
        utente1.setPassword("123");
        utente1.setUrlProfilo("img/djanniprofilo.jpg");
        utente1.setFrase("");
        utente1.setDataNascita("");

        //HeavyBreathing
        Utentiregistrati utente2 = new Utentiregistrati();
        utente2.setId(0);
        utente2.setNome("Djanni");
        utente2.setEmail("djannigatto@gmail.com");
        utente2.setCognome("Incrocio");
        utente2.setPassword("123");
        utente2.setUrlProfilo("img/djanniprofilo.jpg");
        utente2.setFrase("");
        utente2.setDataNascita("");

        //GymWorkOut
        Utentiregistrati utente3 = new Utentiregistrati();
        utente3.setId(0);
        utente3.setNome("Djanni");
        utente3.setEmail("djannigatto@gmail.com");
        utente3.setCognome("Incrocio");
        utente3.setPassword("123");
        utente3.setUrlProfilo("img/djanniprofilo.jpg");
        utente3.setFrase("");
        utente3.setDataNascita("");
       
        Utentiregistrati utente4 = new Utentiregistrati();
        utente4.setId(0);
        utente4.setNome("Djanni");
        utente4.setEmail("djannigatto@gmail.com");
        utente4.setCognome("Incrocio");
        utente4.setPassword("123");
        utente4.setUrlProfilo("img/djanniprofilo.jpg");
        utente4.setFrase("");
        utente4.setDataNascita("");

        listaUtentiregistrati.add(utente1);
        listaUtentiregistrati.add(utente2);
        listaUtentiregistrati.add(utente3);
        listaUtentiregistrati.add(utente4);
    }

    public Utentiregistrati getGattoById(int id) {
        for (Utentiregistrati utente : this.listaUtentiregistrati) {
            if (utente.getId() == id) {
                return utente;
            }
        }
        return null;
    }

}
