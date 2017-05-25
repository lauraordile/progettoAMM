/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook.classi;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Laura
 */
public class Gruppo {

    
    private int id;
    private List<UtenteRegistrato>  utentiGruppo;//da togliere???
    private int amministratore;
    private String nomeGruppo;
    private String descrizione;
    
    public Gruppo(){
        id=0;
        nomeGruppo="";
        
        //utentiGruppo = new ArrayList<>();
    }

    /**
     * @param utentiGruppo l'insieme degli utenti del gruppo
     */
    public void setUtentiGruppo(List<UtenteRegistrato> utentiGruppo) {
	if (utentiGruppo.size()!=0)
	this.utentiGruppo = utentiGruppo;
    }
    
    public void addUtente(UtenteRegistrato utente){
        this.utentiGruppo.add(utente);
    }
    
    public List<UtenteRegistrato> getUtentiGruppo(){
        return utentiGruppo;
    }
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return nomeGruppo
     */
    public String getNomeGruppo() {
        return nomeGruppo;
    }

    /**
     * @param nomeGruppo il nome del gruppo
     */
    public void setNomeGruppo(String nomeGruppo) {
        this.nomeGruppo = nomeGruppo;
    }
    /**
     * @return the descrizione
     */
    public String getDescrizione() {
        return descrizione;
    }

    /**
     * @param descrizione the descrizione to set
     */
    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    /**
     * @return the amministratore
     */
    public int getAmministratore() {
        return amministratore;
    }

    /**
     * @param amministratore the amministratore to set
     */
    public void setAmministratore(int amministratore) {
        this.amministratore = amministratore;
    }
}
