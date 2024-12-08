package daos;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.eq;
import conexion.ConexionBD;
import convertidores.ConvertidorEstado;
import convertidores.ConvertidorMunicipio;
import entidades.Estado;
import entidades.Municipio;
import interfaces.IMunicipioDAO;
import java.util.ArrayList;
import java.util.List;
import pojos.EstadoPojo;
import pojos.MunicipioPojo;

/**
 *
 * @author juventino
 */
public class MunicipioDAO implements IMunicipioDAO {

    private static MunicipioDAO instance;
    private ConvertidorMunicipio convertidor;
    private ConvertidorEstado convertidorEstado;
    private final MongoCollection coleccionMunicipios;
    private final MongoCollection coleccionEstados;

    private MunicipioDAO() {
        coleccionMunicipios = ConexionBD.getDatabase().getCollection("municipios", MunicipioPojo.class);
        coleccionEstados = ConexionBD.getDatabase().getCollection("estados", EstadoPojo.class);
        convertidor = new ConvertidorMunicipio();
        convertidorEstado = new ConvertidorEstado();
    }

    public static MunicipioDAO getInstance() {
        return (instance == null) ? new MunicipioDAO() : instance;
    }

    @Override
    public List<Municipio> obtenerMunicipios() {
        List<MunicipioPojo> resultado = (List) coleccionMunicipios.find().into(new ArrayList<>());

        return convertidor.createFromPojos(resultado);
    }

    @Override
    public List<Municipio> obtenerMunicipiosPorNombreEstado(String nombreEstado) {
        FindIterable<EstadoPojo> estadoResultado = coleccionEstados.find(eq("nombre", nombreEstado));
        EstadoPojo estadoPojo = estadoResultado.first();

        if (estadoPojo == null) {
            return new ArrayList<>();
        }

        FindIterable<MunicipioPojo> municipioResultado = coleccionMunicipios.find(eq("_id", estadoPojo.getId()));

        ArrayList<Municipio> municipios = new ArrayList<>();
        for (MunicipioPojo municipioPojo : municipioResultado) {
            Municipio municipio = convertidor.convertFromPojo(municipioPojo);
            Estado estado = convertidorEstado.convertFromPojo(estadoPojo);
            municipio.setEstado(estado);
            municipios.add(municipio);
        }

        return municipios;
    }

    @Override
    public Municipio obtenerMunicipioPorNombre(String nombreMunicipio) {
        FindIterable<MunicipioPojo> resultado = coleccionMunicipios.find(eq("nombre", nombreMunicipio));

        return convertidor.convertFromPojo(resultado.first());
    }

}
