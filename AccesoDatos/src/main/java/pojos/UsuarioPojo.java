package pojos;

import java.time.LocalDate;
import org.bson.types.ObjectId;

/**
 *
 * @author juventino
 */
public class UsuarioPojo {
    
    private String nombre;
    private String correo;
    private String contrasenha;
    private String telefono;
    private String urlAvatar;
    private ObjectId idMunicipio; 
    private LocalDate fechaNacimiento;
    private String genero;
    private boolean esAdmin;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenha() {
        return contrasenha;
    }

    public void setContrasenha(String contrasenha) {
        this.contrasenha = contrasenha;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getUrlAvatar() {
        return urlAvatar;
    }

    public void setUrlAvatar(String urlAvatar) {
        this.urlAvatar = urlAvatar;
    }

    public ObjectId getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(ObjectId idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public boolean isEsAdmin() {
        return esAdmin;
    }

    public void setEsAdmin(boolean esAdmin) {
        this.esAdmin = esAdmin;
    }
    
    
}
