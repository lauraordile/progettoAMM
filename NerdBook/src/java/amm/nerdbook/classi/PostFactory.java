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
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author Laura
 */

public class PostFactory {
     //private String connectionString;
    //Pattern Design Singleton
    private static PostFactory singleton;

    public static PostFactory getInstance() {
        if (singleton == null) {
            singleton = new PostFactory();
        }
        return singleton;
    }
    private String connectionString;
    public void setConnectionString(String s){
	this.connectionString = s;
    }
    
    public String getConnectionString(){
            return this.connectionString;
}
    private ArrayList<Post> listaPost = new ArrayList<Post>();

    private PostFactory() {
        /*
        UtentiregistratiFactory utentiregistratiFactory = UtentiregistratiFactory.getInstance();

        //Creazione Post
        Post post1 = new Post();
        post1.setContenutoTesto("");
        post1.seturl("");
        post1.setId(0);
        post1.setUser(utentiregistratiFactory.getUtentiregistratiById(0));
        post1.setUrlType(Post.Type.NULL);

        Post post2 = new Post();
        post2.setContenutoTesto("");
        post2.seturl("");
        post2.setId(1);
        post2.setUser(utentiregistratiFactory.getUtentiregistratiById(0));
        post2.setUrlType(Post.Type.IMAGE);

        Post post3 = new Post();
        post2.setContenutoTesto("");
        post2.seturl("");
        post3.setId(2);
        post3.setUser(utentiregistratiFactory.getUtentiregistratiById(0));
        post3.setUrlType(Post.Type.LINK);

        
        listaPost.add(post1);
        listaPost.add(post2);
        listaPost.add(post3);
        */
    }

    public Post getPostById(int id) {
        UtentiregistratiFactory utenteFactory =UtentiregistratiFactory.getInstance();
        try {
            Connection conn= DriverManager.getConnection(connectionString,"ammdb","l.ordile");
            String quesry =
                    "select* from post"
                    +"join tipurl on post.tipo = tipourl.id"
                    +"where id=?";
            PreparedStatement stmt= conn.prepareStatement(quesry);
            stmt.setInt(1, id);
            ResultSet res=stmt.executeQuery();
            if(res.next()){
                Post current=new Post();
                current.setId(res.getInt("id"));
                current.setContenutoTesto(res.getString("testo"));
                current.seturl(res.getString("url"));
                current.setUrlType(this.urlTypeToString(res.getString("tipo")));
                UtenteRegistrato autore = utenteFactory.getUtentiregistratiById(res.getInt("utente"));
                current.setUser(autore);

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
    
    private Post.Type urlTypeToString(String type){
        
        if(type.equals("IMAGE"))
            return Post.Type.IMAGE;
        if(type.equals("LINK"))
            return Post.Type.LINK;
        return Post.Type.NULL;
}

    
    public List getPostList(UtenteRegistrato utente) {

        List<Post> listaPost = new ArrayList<Post>();
        
        try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString,"ammdb","l.ordile");
            
            String query = 
                      "select * from post "
                    + "join tipoUrl on posts.tipo = tipoUrl.id "
                    + "where utente = ?";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Si associano i valori
            stmt.setInt(1, utente.getId());
            
            // Esecuzione query
            ResultSet res = stmt.executeQuery();

            // ciclo sulle righe restituite
            while (res.next()) {
                
                Post current = new Post();
                //imposto id del post
                current.setId(res.getInt("post_id"));
                
                //impost il contenuto del post
                current.setContenutoTesto(res.getString("testo"));
                
                //imposto il tipo del post
                current.setUrlType(this.urlTypeToString(res.getString("nomeTipo")));

                //imposto l'autore del post
                current.setUser(utente);
                
                listaPost.add(current);
            }

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaPost;
    }
    
     public List getPostList(Gruppo gruppo) {

        List<Post> listaPost = new ArrayList<Post>();
        
        try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString,"ammdb","l.ordile");
            
            String query = 
                      "select * from post "
                    + "join tipoUrl on posts.tipo = tipoUrl.id "
                    + "where gruppo = ?";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Si associano i valori
            stmt.setInt(1, gruppo.getId());
            
            // Esecuzione query
            ResultSet res = stmt.executeQuery();

            // ciclo sulle righe restituite
            while (res.next()) {
                
                Post current = new Post();
                //imposto id del post
                current.setId(res.getInt("post_id"));
                
                //impost il contenuto del post
                current.setContenutoTesto(res.getString("testo"));
                
                //imposto il tipo del post
                current.setUrlType(this.urlTypeToString(res.getString("nomeTipo")));

                //imposto l'autore del post
               // current.setUser(gruppo);
                
                listaPost.add(current);
            }

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaPost;
    }
    public void addNewPost(Post post){
        try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString,"ammdb","l.ordile");
            
            String query = 
                      "insert into post (id, testo,url, tipo, utente) "
                    + "values (default, ? , ? , ? , ? )";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Si associano i valori
            stmt.setString(1, post.getContenutoTesto());

            //stmt.setInt(2, post.geturl());
            stmt.setInt(3, this.postTypeFromEnum(post.getUrlType()));
            
            stmt.setInt(4, post.getUser().getId());
            
            // Esecuzione query
            stmt.executeUpdate();
            stmt.close();
            conn.close();
        }
            
            
        catch(SQLException e){
        e.printStackTrace();
        }
         
    }
    
    public void deletePost(Post post){
        try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString,"ammdb","l.ordile");
            
            String query = 
                      "delete *"
                    + "from post"
                    + "where id = ?";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Si associano i valori
            stmt.setInt(1, post.getId());

            // Esecuzione query
            stmt.executeUpdate();
            stmt.close();
            conn.close();
        }
        catch(SQLException e){
        e.printStackTrace();
        }
         
    }
    
    public void deleteAllPost(UtenteRegistrato u){
        try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString,"ammdb","l.ordile");
            
            String query = 
                      "delete *"
                    + "from post"
                    + "where utente = ?";
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Si associano i valori
            stmt.setInt(1, u.getId());

            // Esecuzione query
            stmt.executeUpdate();
            stmt.close();
            conn.close();
        }
        catch(SQLException e){
        e.printStackTrace();
        }
         
    }
    
    
    public int postTypeFromEnum(Post.Type type){
        //È realizzabile in modo più robusto rispetto all'hardcoding degli indici
        if(type == Post.Type.NULL)
                return 1;
        if(type == Post.Type.IMAGE)
                return 2;
            else
                return 3;
        }

    
        /*for (Post post : this.listaPost) {
            if (post.getUser().equals(utente)) {
                listaPost.add(post);
            }
        }
        return listaPost;
    }

         public void setConnectionString(String s){
	this.connectionString = s;
}

      public String getConnectionString(){
	return this.connectionString;
      }*/
}
