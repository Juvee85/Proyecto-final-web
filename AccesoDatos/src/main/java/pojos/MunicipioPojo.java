package pojos;

import org.bson.types.ObjectId;

/**
 *
 * @author juventino
 */
public class MunicipioPojo {

    private ObjectId _id;
    
    private String nombre;

    private ObjectId estadoId;

    public ObjectId getId() {
        return _id;
    }

    public void setId(ObjectId _id) {
        this._id = _id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ObjectId getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(ObjectId estadoId) {
        this.estadoId = estadoId;
    }
}
