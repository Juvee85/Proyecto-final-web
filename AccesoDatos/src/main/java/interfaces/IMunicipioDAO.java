package interfaces;

import entidades.Municipio;
import java.util.List;

/**
 *
 * @author juventino
 */
public interface IMunicipioDAO {

    public List<Municipio> obtenerMunicipios();
    
    public List<Municipio> obtenerMunicipiosPorNombreEstado(String nombreEstado);

    public Municipio obtenerMunicipioPorNombre(String nombreMunicipio);
}
