package interfaces;

import entidades.Usuario;

/**
 *
 * @author juventino
 */
public interface IUsuarioDAO {
    
    public void agregarUsuario(Usuario usuario);
    
    public Usuario obtenerUsuarioPorCorreo(String correo);
}
