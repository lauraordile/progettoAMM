/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook.classi;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author Laura
 */
public class PostFactory {

    //Pattern Design Singleton
    private static PostFactory singleton;

    public static PostFactory getInstance() {
        if (singleton == null) {
            singleton = new PostFactory();
        }
        return singleton;
    }

    private ArrayList<Post> listaPost = new ArrayList<Post>();

    private PostFactory() {
        
        UtentiregistratiFactory utentiregistratiFactory = UtentiregistratiFactory.getInstance();

        //Creazione Post
        Post post1 = new Post();
        post1.setContenutoTesto("Ciao, miei schiavi. Datemi cibo! Adesso! Miaomiaomiaomiaomiao!");
        post1.setContenutoImm("");
        post1.setContenutoLink("");
        post1.setId(0);
        post1.setUser(utentiregistratiFactory.getUtentiregistratiById(0));

        Post post2 = new Post();
        post2.setContenutoTesto("");
        post2.setContenutoImm("");
        post2.setContenutoLink("");
        post2.setId(1);
        post2.setUser(utentiregistratiFactory.getUtentiregistratiById(0));
        post2.setPostType(Post.Type.IMAGE);

        Post post3 = new Post();
        post2.setContenutoTesto("");
        post2.setContenutoImm("");
        post2.setContenutoLink("");
        post3.setId(2);
        post3.setUser(utentiregistratiFactory.getUtentiregistratiById(0));
        post3.setPostType(Post.Type.IMAGE);

        
        listaPost.add(post1);
        listaPost.add(post2);
        listaPost.add(post3);
        
    }

    public Post getPostById(int id) {
        for (Post post : this.listaPost) {
            if (post.getId() == id) {
                return post;
            }
        }
        return null;
    }

    public List getPostList(UtenteRegistrato utente) {

        List<Post> listaPost = new ArrayList<Post>();

        for (Post post : this.listaPost) {
            if (post.getUser().equals(utente)) {
                listaPost.add(post);
            }
        }
        return listaPost;
    }

}
