package entidades;

import java.util.Date;
import java.util.Objects;
import org.bson.types.ObjectId;

public class Mensaje {
    private ObjectId id;
    private Usuario usuario;
    private String texto;
    private Date fecha_de_registro;

    public Mensaje() {
    }

    
    public Mensaje(Usuario usuario, String texto, Date fecha_de_registro) {
        this.usuario = usuario;
        this.texto = texto;
        this.fecha_de_registro = fecha_de_registro;
    }

    public Mensaje(ObjectId id, Usuario usuario, String texto, Date fecha_de_registro) {
        this.id = id;
        this.usuario = usuario;
        this.texto = texto;
        this.fecha_de_registro = fecha_de_registro;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public void generarId(){
        this.setId(new ObjectId());
    }
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Date getFecha_de_registro() {
        return fecha_de_registro;
    }

    public void setFecha_de_registro(Date fecha_de_registro) {
        this.fecha_de_registro = fecha_de_registro;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.usuario);
        hash = 97 * hash + Objects.hashCode(this.fecha_de_registro);
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
        final Mensaje other = (Mensaje) obj;
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        if (!Objects.equals(this.fecha_de_registro, other.fecha_de_registro)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Mensaje{" + "usuario=" + usuario + ", texto=" + texto + ", fecha_de_registro=" + fecha_de_registro + '}';
    }

    
    
    
}
