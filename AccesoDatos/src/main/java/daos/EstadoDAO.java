package daos;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.eq;
import conexion.ConexionBD;
import convertidores.ConvertidorEstado;
import entidades.Estado;
import interfaces.IEstadoDAO;
import java.util.ArrayList;
import java.util.List;
import pojos.EstadoPojo;

/**
 *
 * @author juventino
 */
public class EstadoDAO implements IEstadoDAO {

    private static EstadoDAO instance;
    private ConvertidorEstado convertidor;
    private final MongoCollection coleccionEstados;

    private EstadoDAO() {
        coleccionEstados = ConexionBD.getDatabase().getCollection("estados", EstadoPojo.class);
        convertidor = new ConvertidorEstado();
    }

    public static EstadoDAO getInstance() {
        return (instance == null) ? new EstadoDAO() : instance;
    }

    @Override
    public List<Estado> obtenerEstados() {
        FindIterable<EstadoPojo> resultado = coleccionEstados.find();
        ArrayList<EstadoPojo> estados = new ArrayList<>();
        for (EstadoPojo estado : resultado) {
            estados.add(estado);
        }

        return convertidor.createFromPojos(estados);
    }

    @Override
    public Estado obtenerEstadoPorNombre(String nombre) {
        FindIterable<EstadoPojo> resultado = coleccionEstados.find(eq("nombre", nombre));

        return convertidor.convertFromPojo(resultado.first());
    }

}
