package entidades;

import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author juventino
 */
public class Post {

    private LocalDateTime fechaHoraCreacion;
    private String titulo;
    private String contenido;
    private String urlImagen;
    private LocalDateTime fechaHoraEdicion;
    private List<Comentario> comentarios;
    private Usuario usuario;
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

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public boolean isEsAnclado() {
        return esAnclado;
    }

    public void setEsAnclado(boolean esAnclado) {
        this.esAnclado = esAnclado;
    }

}
