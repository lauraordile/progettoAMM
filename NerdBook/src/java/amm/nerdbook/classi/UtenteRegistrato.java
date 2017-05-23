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
public class UtenteRegistrato {
    private int id;
    private String nome; 
    private String cognome;
    private String dataNascita;
    private String urlProfilo;
    private String frase;
    private String email;
    private String password;

    public UtenteRegistrato(){
        id =0;
        nome="";
        cognome="";
        dataNascita="";
        urlProfilo="";
        frase="";
        password="";
        email="";
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
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the cognome
     */
    public String getCognome() {
        return cognome;
    }

    /**
     * @param cognome the cognome to set
     */
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    /**
     * @return the dataNascita
     */
    public String getDataNascita() {
        return dataNascita;
    }

    /**
     * @param dataNascita data di nascita
     */
    public void setDataNascita(String dataNascita) {
        this.dataNascita = dataNascita;
    }

    /**
     * @return the urlProfilo
     */
    public String getUrlProfilo() {
        return urlProfilo;
    }

    /**
     * @param urlProfilo url del profilo
     */
    public void setUrlProfilo(String urlProfilo) {
        this.urlProfilo = urlProfilo;
    }
    
    /**
     * @return the frase
     */
    public String getFrase() {
        return frase;
    }

    /**
     * @param frase frase di presentazione
     */
    public void setFrase(String frase) {
        this.frase = frase;
    }
    
    public boolean confermaPassword(String password){
        return this.password.equals(password);
    }
    
    @Override
    public boolean equals(Object altroUtente) {
        if (altroUtente instanceof UtenteRegistrato)
            if (this.getId() == ((UtenteRegistrato)altroUtente).getId()) return true;
        return false;
    }
    
}

