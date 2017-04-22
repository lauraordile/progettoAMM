/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook.classi;

/**
 *
 * @author Laura
 */
public class Gruppi {
    
    private int id;
    private Utentiregistrati [] utentiGruppo;
    private String nomeGruppo;
    
    public Gruppi(){
        id=0;
        nomeGruppo="";
        utentiGruppo= new Utentiregistrati[100];
    }

    /**
     * @param utentiGruppo l'insieme degli utenti del gruppo
     */
    public void setUtentiGruppo(Utentiregistrati[] utentiGruppo) {
	if (utentiGruppo.length!=0)
	this.utentiGruppo = utentiGruppo;
    }
    
    public Utentiregistrati[] getUtentiGruppo(){
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

}
