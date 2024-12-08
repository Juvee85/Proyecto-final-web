package pojos;

import org.bson.types.ObjectId;

/**
 *
 * @author juventino
 */
public class EstadoPojo {

    private ObjectId _id;

    private String nombre;

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

}
