package interfaces;

import entidades.Estado;
import java.util.List;

/**
 *
 * @author juventino
 */
public interface IEstadoDAO {

    public List<Estado> obtenerEstados();

    public Estado obtenerEstadoPorNombre(String nombre);
}
