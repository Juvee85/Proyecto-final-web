package pojos;

import java.time.LocalDateTime;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author juventino
 */
public class ComentarioPojo {

    private LocalDateTime fechaHora;
    private String contenido;
    private ObjectId idUsuario;
    private List<ComentarioPojo> comentarios;

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public ObjectId getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(ObjectId idUsuario) {
        this.idUsuario = idUsuario;
    }

    public List<ComentarioPojo> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<ComentarioPojo> comentarios) {
        this.comentarios = comentarios;
    }

}
