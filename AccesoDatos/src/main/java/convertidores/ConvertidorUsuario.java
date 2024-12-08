package convertidores;

import entidades.Usuario;
import pojos.UsuarioPojo;

/**
 *
 * @author juventino
 */
public class ConvertidorUsuario extends Convertidor<Usuario, UsuarioPojo> {

    public ConvertidorUsuario() {
        super(ConvertidorUsuario::convertToPojo, ConvertidorUsuario::convertToBO);

    }

    private static UsuarioPojo convertToPojo(Usuario usuario) {
        UsuarioPojo pojo = new UsuarioPojo();
        pojo.setNombre(usuario.getNombre());
        pojo.setCorreo(usuario.getCorreo());
        pojo.setContrasenha(usuario.getContrasenha());
        pojo.setTelefono(usuario.getTelefono());
        pojo.setUrlAvatar(usuario.getUrlAvatar());
        pojo.setFechaNacimiento(usuario.getFechaNacimiento());
        pojo.setGenero(usuario.getGenero());
        pojo.setEsAdmin(usuario.isEsAdmin());

        return pojo;
    }

    private static Usuario convertToBO(UsuarioPojo pojo) {
        Usuario usuario = new Usuario();
        usuario.setNombre(pojo.getNombre());
        usuario.setCorreo(pojo.getCorreo());
        usuario.setContrasenha(pojo.getContrasenha());
        usuario.setTelefono(pojo.getTelefono());
        usuario.setUrlAvatar(pojo.getUrlAvatar());
        usuario.setFechaNacimiento(pojo.getFechaNacimiento());
        usuario.setGenero(pojo.getGenero());
        usuario.setEsAdmin(pojo.isEsAdmin());

        return usuario;
    }
}
