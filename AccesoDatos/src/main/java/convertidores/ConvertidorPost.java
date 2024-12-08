package convertidores;

import entidades.Post;
import pojos.PostPojo;

/**
 *
 * @author juventino
 */
public class ConvertidorPost extends Convertidor<Post, PostPojo> {

    private static final ConvertidorComentario convertidorComentario = new ConvertidorComentario();

    public ConvertidorPost() {
        super(ConvertidorPost::convertToPojo, ConvertidorPost::convertToBO);
    }

    private static PostPojo convertToPojo(Post post) {
        PostPojo pojo = new PostPojo();
        pojo.setFechaHoraCreacion(post.getFechaHoraCreacion());
        pojo.setTitulo(post.getTitulo());
        pojo.setContenido(post.getContenido());
        pojo.setUrlImagen(post.getUrlImagen());
        pojo.setFechaHoraEdicion(post.getFechaHoraEdicion());
        pojo.setComentarios(convertidorComentario.createFromBOs(post.getComentarios()));
        pojo.setEsAnclado(post.isEsAnclado());
        return pojo;
    }

    private static Post convertToBO(PostPojo pojo) {
        Post post = new Post();
        post.setFechaHoraCreacion(pojo.getFechaHoraCreacion());
        post.setTitulo(pojo.getTitulo());
        post.setContenido(pojo.getContenido());
        post.setUrlImagen(pojo.getUrlImagen());
        post.setFechaHoraEdicion(pojo.getFechaHoraEdicion());
        post.setComentarios(convertidorComentario.createFromPojos(pojo.getComentarios()));
        post.setEsAnclado(pojo.isEsAnclado());
        return post;
    }

}
