package pojos;

import java.time.LocalDateTime;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author juventino
 */
public class PostPojo {
    
    private LocalDateTime fechaHoraCreacion;
    private String titulo;
    private String contenido;
    private String urlImagen;
    private LocalDateTime fechaHoraEdicion;
    private List<ComentarioPojo> comentarios;
    private ObjectId idUsuario;
    private boolean esAnclado;

    public LocalDateTime getFechaHoraCreacion() {
        return fechaHoraCreacion;
    }

    public void setFechaHoraCreacion(LocalDateTime fechaHoraCreacion) {
        this.fechaHoraCreacion = fechaHoraCreacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public LocalDateTime getFechaHoraEdicion() {
        return fechaHoraEdicion;
    }

    public void setFechaHoraEdicion(LocalDateTime fechaHoraEdicion) {
        this.fechaHoraEdicion = fechaHoraEdicion;
    }

    public List<ComentarioPojo> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<ComentarioPojo> comentarios) {
        this.comentarios = comentarios;
    }

    public boolean isEsAnclado() {
        return esAnclado;
    }

    public void setEsAnclado(boolean esAnclado) {
        this.esAnclado = esAnclado;
    }

    public ObjectId getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(ObjectId idUsuario) {
        this.idUsuario = idUsuario;
    }
    
}
