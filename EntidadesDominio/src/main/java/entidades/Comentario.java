package entidades;

import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author juventino
 */
public class Comentario {

    private LocalDateTime fechaHora;
    private String contenido;
    private Usuario usuariosuario;
    private List<Comentario> comentarios;

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

    public Usuario getUsuariosuario() {
        return usuariosuario;
    }

    public void setUsuariosuario(Usuario usuariosuario) {
        this.usuariosuario = usuariosuario;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }
    
}
