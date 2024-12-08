package convertidores;

import entidades.Estado;
import pojos.EstadoPojo;

/**
 *
 * @author juventino
 */
public class ConvertidorEstado extends Convertidor<Estado, EstadoPojo> {
    
    public ConvertidorEstado() {
        super(ConvertidorEstado::convertToPojo, ConvertidorEstado::convertToBO);
    }

    private static Estado convertToBO(EstadoPojo pojo) {
        Estado estado = new Estado();
        estado.setNombre(pojo.getNombre());
        
        return estado;
    }

    private static EstadoPojo convertToPojo(Estado estado) {
        EstadoPojo pojo = new EstadoPojo();
        pojo.setNombre(estado.getNombre());

        return pojo;
    }
}
