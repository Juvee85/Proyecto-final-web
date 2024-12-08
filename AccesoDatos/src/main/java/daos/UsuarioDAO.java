package daos;

import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.eq;
import conexion.ConexionBD;
import convertidores.ConvertidorMunicipio;
import convertidores.ConvertidorUsuario;
import entidades.Usuario;
import interfaces.IUsuarioDAO;
import org.bson.types.ObjectId;
import pojos.MunicipioPojo;
import pojos.UsuarioPojo;

/**
 *
 * @author juventino
 */
public class UsuarioDAO implements IUsuarioDAO {

    private static UsuarioDAO instance;
    private final MongoCollection<UsuarioPojo> coleccionUsuarios;
    private final MongoCollection<MunicipioPojo> coleccionMunicipios;
    private final ConvertidorUsuario convertidor;
    private final ConvertidorMunicipio convertidorMunicipios;

    private UsuarioDAO() {
        coleccionUsuarios = ConexionBD.getDatabase().getCollection("usuarios", UsuarioPojo.class);
        coleccionMunicipios = ConexionBD.getDatabase().getCollection("municipios", MunicipioPojo.class);
        this.convertidor = new ConvertidorUsuario();
        this.convertidorMunicipios = new ConvertidorMunicipio();
    }

    public static UsuarioDAO getInstance() {
        return (instance == null) ? new UsuarioDAO() : instance;
    }

    @Override
    public void agregarUsuario(Usuario usuario) {
        UsuarioPojo usuarioPojo = convertidor.convertFromBO(usuario);

        ObjectId idMunicipio = coleccionMunicipios.find(eq("nombre", usuario.getMunicipio().getNombre())).first().getId();
        usuarioPojo.setIdMunicipio(idMunicipio);

        coleccionUsuarios.insertOne(usuarioPojo);
    }

    @Override
    public Usuario obtenerUsuarioPorCorreo(String correo) {
        UsuarioPojo usuarioPojo = coleccionUsuarios.find(eq("correo", correo)).first();
        if (usuarioPojo != null) {
            Usuario usuario = convertidor.convertFromPojo(usuarioPojo);

            MunicipioPojo municipio = coleccionMunicipios.find(eq("_id", usuarioPojo.getIdMunicipio())).first();
            usuario.setMunicipio(convertidorMunicipios.convertFromPojo(municipio));
            return usuario;
        }
        return null;
    }

}
