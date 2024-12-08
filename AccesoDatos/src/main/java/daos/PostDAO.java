package daos;

import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.model.Sorts;
import conexion.ConexionBD;
import convertidores.ConvertidorComentario;
import convertidores.ConvertidorPost;
import entidades.Comentario;
import entidades.Post;
import interfaces.IPostDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.bson.Document;
import pojos.ComentarioPojo;
import pojos.PostPojo;

/**
 *
 * @author juventino
 */
public class PostDAO implements IPostDAO {

    private final MongoCollection<PostPojo> coleccionPosts;
    private final ConvertidorPost convertidorPost;
    private final ConvertidorComentario convertidorComentario;
    private static PostDAO instance;

    public static PostDAO getInstance() {
        return (instance == null) ? new PostDAO() : instance;
    }

    private PostDAO() {
        this.coleccionPosts = ConexionBD.getDatabase().getCollection("posts", PostPojo.class);
        this.convertidorComentario = new ConvertidorComentario();
        this.convertidorPost = new ConvertidorPost();
    }

    @Override
    public List<Post> obtenerPosts() {
        List<PostPojo> resultado = coleccionPosts.find().sort(Sorts.descending("fechaHoraCreacion")).into(new ArrayList<>());
        return convertidorPost.createFromPojos(resultado);
    }

    @Override
    public List<Post> obtenerPostsFiltros(Map<String, String> filtros) {
        Document query = new Document();
        for (Map.Entry<String, String> filtro : filtros.entrySet()) {
            query.append(filtro.getKey(), filtro.getValue());
        }
        List<PostPojo> resultado = coleccionPosts.find(query).sort(Sorts.descending("fechaHoraCreacion")).into(new ArrayList<>());
        return convertidorPost.createFromPojos(resultado);
    }

    @Override
    public Post obtenerPost(String titulo) {
        PostPojo postPojo = coleccionPosts.find(eq("titulo", titulo)).first();
        if (postPojo != null) {
            return convertidorPost.convertFromPojo(postPojo);
        }
        return null;
    }

    @Override
    public void registrarPost(Post post) {
        PostPojo postPojo = convertidorPost.convertFromBO(post);

        coleccionPosts.insertOne(postPojo);
    }

    @Override
    public void registrarComentario(Comentario comentario, Post post) {
        PostPojo postPojo = coleccionPosts.find(eq("titulo", post.getTitulo())).first();
        if (postPojo != null) {
            ComentarioPojo comentarioPojo = convertidorComentario.convertFromBO(comentario);
            postPojo.getComentarios().add(comentarioPojo);
            coleccionPosts.updateOne(eq("titulo", postPojo.getTitulo()), new Document("$set", new Document("comentarios", postPojo.getComentarios())));
        } else {
            throw new IllegalArgumentException("Post no encontrado");
        }
    }

}
