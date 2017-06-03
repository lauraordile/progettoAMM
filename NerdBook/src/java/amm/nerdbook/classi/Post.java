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
       NULL, IMAGE, LINK
    };
    
    protected int id;
    public UtenteRegistrato user;
    private String contenutoTesto;
    private String url;
    private Type urlType;

    public Post() {
        id = 0;
        user = null;
        contenutoTesto = "";
        url = "";
        urlType = Type.NULL;
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
    public Type getUrlType() {
        return urlType;
    }

    /**
     * @param urlType the postType to set
     */
    public void setUrlType(Type urlType) {
        this.urlType = urlType;
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
     * @return the contenutoLink
     */
    public String geturl() {
        return url;
    }

    /**
     * @param url the contenutoLink to set
     */
    public void seturl(String url) {
        this.url = url;
    }
}
