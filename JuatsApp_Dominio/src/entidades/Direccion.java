package entidades;

import java.util.Objects;
import org.bson.types.ObjectId;

public class Direccion {
    private ObjectId id;
    private String calle;
    private String numero;
    private String colonia;
    private String ciudad;
    private String codigo_postal;

    public Direccion() {
    }
    
    public Direccion(String calle, String numero, String colonia, String ciudad, String codigo_postal) {
        this.calle = calle;
        this.numero = numero;
        this.colonia = colonia;
        this.ciudad = ciudad;
        this.codigo_postal = codigo_postal;
    }

    public Direccion(ObjectId id, String calle, String numero, String colonia, String ciudad, String codigo_postal) {
        this.id = id;
        this.calle = calle;
        this.numero = numero;
        this.colonia = colonia;
        this.ciudad = ciudad;
        this.codigo_postal = codigo_postal;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCodigo_postal() {
        return codigo_postal;
    }

    public void setCodigo_postal(String codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Direccion other = (Direccion) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Direccion{" + "id=" + id + ", calle=" + calle + ", numero=" + numero + ", colonia=" + colonia + ", ciudad=" + ciudad + ", codigo_postal=" + codigo_postal + '}';
    }
    
    
}
