package interfaces;

import entidades.Comentario;
import entidades.Post;
import java.util.List;
import java.util.Map;

/**
 *
 * @author juventino
 */
public interface IPostDAO {
    
    public List<Post> obtenerPosts();
    
    public List<Post> obtenerPostsFiltros(Map<String, String> filtros);
    
    public Post obtenerPost(String titulo);
    
    public void registrarPost(Post post);
    
    public void registrarComentario(Comentario comentario, Post post);
    
}
