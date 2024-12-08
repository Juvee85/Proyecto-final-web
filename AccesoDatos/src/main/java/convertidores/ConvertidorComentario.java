package convertidores;

import entidades.Comentario;
import pojos.ComentarioPojo;

/**
 *
 * @author juventino
 */
public class ConvertidorComentario extends Convertidor<Comentario, ComentarioPojo> {
    
    public ConvertidorComentario() {
        super(ConvertidorComentario::convertToPojo, ConvertidorComentario::convertToBO);
    }

    private static ComentarioPojo convertToPojo(Comentario comentario) {
        ComentarioPojo pojo = new ComentarioPojo();
        pojo.setFechaHora(comentario.getFechaHora());
        pojo.setContenido(comentario.getContenido());
        return pojo;
    }

    private static Comentario convertToBO(ComentarioPojo pojo) {
        Comentario comentario = new Comentario();
        comentario.setFechaHora(pojo.getFechaHora());
        comentario.setContenido(pojo.getContenido());
        return comentario;
    }
}
