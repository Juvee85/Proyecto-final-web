package convertidores;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 *
 * @author juventino
 * @param <T>
 * @param <U>
 */
public class Convertidor<T, U> {

    private final Function<T, U> fromBO;
    private final Function<U, T> fromPojo;

    /**
     * Constrictor usado por las clases que heredan de Convertidor para definir
     * las cunciones que hacen la converción de BO a POJO y viceversa
     *
     * @param fromBO Función para convertir de BO a POJO
     * @param fromPojo Función para convertir de POJO a DTO
     */
    public Convertidor(final Function<T, U> fromBO, final Function<U, T> fromPojo) {
        this.fromBO = fromBO;
        this.fromPojo = fromPojo;
    }

    /**
     * Convierte un BO a un POJO
     *
     * @param bo BO del cual se desea convertir a POJO
     * @return POJO convertido desde el BO
     */
    public final U convertFromBO(final T bo) {
        return fromBO.apply(bo);
    }

    /**
     * Convierte un POJO a un BO
     *
     * @param pojo POJO del cual se desea convertir a BO
     * @return BO convertido desde el POJO
     */
    public final T convertFromPojo(final U pojo) {
        return fromPojo.apply(pojo);
    }

    /**
     * Convierte una lista de BOS a POJOs
     *
     * @param bos Lista con BOs
     * @return Lista con POJOs convertidos desde la lista dada por el parametro
     */
    public final List<U> createFromBOs(final Collection<T> bos) {
        return bos.stream().map(this::convertFromBO).collect(Collectors.toList());
    }

    /**
     * Convierte una lista de POJOs a BOs
     *
     * @param pojos Lista con POJOs
     * @return Lista con BOs convertidos deade la lista dada por el parametro
     */
    public final List<T> createFromPojos(final Collection<U> pojos) {
        return pojos.stream().map(this::convertFromPojo).collect(Collectors.toList());
    }
}
