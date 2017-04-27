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
        TEXT, IMAGE, LINK
    };
    
    protected int id;
    protected UtenteRegistrato user;
    private String contenutoTesto;
    private String contenutoImm;
    private String contenutoLink;
    private Type postType;

    public Post() {
        id = 0;
        user = null;
        contenutoTesto = "";
        contenutoImm = "";
        contenutoLink = "";
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

    /**
     * @return the contenutoTesto
     */
    public String getContenutoTesto() {
        return contenutoTesto;
    }

    /**
     * @param contenutoTesto the contenutoTesto to set
     */
    public void setContenutoTesto(String contenutoTesto) {
        this.contenutoTesto = contenutoTesto;
    }

    /**
     * @return the contenutoImm
     */
    public String getContenutoImm() {
        return contenutoImm;
    }

    /**
     * @param contenutoImm the contenutoImm to set
     */
    public void setContenutoImm(String contenutoImm) {
        this.contenutoImm = contenutoImm;
    }

    /**
     * @return the contenutoLink
     */
    public String getContenutoLink() {
        return contenutoLink;
    }

    /**
     * @param contenutoLink the contenutoLink to set
     */
    public void setContenutoLink(String contenutoLink) {
        this.contenutoLink = contenutoLink;
    }
}
