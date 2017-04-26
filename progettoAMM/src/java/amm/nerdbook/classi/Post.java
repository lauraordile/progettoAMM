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
public class Post {
    
    public enum Type {
        TEXT, IMAGE
    };
    
    protected int id;
    protected UtenteRegistrato user;
    private String contenuto;
    private Type postType;

    public Post() {
        id = 0;
        user = null;
        contenuto = "";
        postType = Type.TEXT;
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
     * @return the user
     */
    public UtenteRegistrato getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(UtenteRegistrato user) {
        this.user = user;
    }

    /**
     * @return il contenuto
     */
    public String getContent() {
        return contenuto;
    }

    /**
     * @param contenuto il contenuto da scrivere
     */
    public void setContent(String contenuto) {
        this.contenuto = contenuto;
    }

    /**
     * @return the postType
     */
    public Type getPostType() {
        return postType;
    }

    /**
     * @param postType the postType to set
     */
    public void setPostType(Type postType) {
        this.postType = postType;
    }
}
