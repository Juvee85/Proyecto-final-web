package convertidores;

import entidades.Municipio;
import pojos.MunicipioPojo;

/**
 *
 * @author juventino
 */
public class ConvertidorMunicipio extends Convertidor<Municipio, MunicipioPojo> {

    public ConvertidorMunicipio() {
        super(ConvertidorMunicipio::convertToPojo, ConvertidorMunicipio::convertToBO);
    }

    private static Municipio convertToBO(MunicipioPojo pojo) {
        Municipio municipio = new Municipio();
        municipio.setNombre(pojo.getNombre());

        return municipio;
    }

    private static MunicipioPojo convertToPojo(Municipio municipio) {
        MunicipioPojo pojo = new MunicipioPojo();
        pojo.setNombre(municipio.getNombre());

        return pojo;
    }
}
