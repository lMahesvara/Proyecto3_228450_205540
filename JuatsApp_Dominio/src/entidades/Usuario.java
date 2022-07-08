package entidades;

import java.util.Date;
import java.util.Objects;
import org.bson.types.ObjectId;

public class Usuario {
    private ObjectId id;
    private String username;
    private String password;
    private String telefono;
    private Direccion direccion;
    private Date fecha_nacimiento;
    private String sexo;

    public Usuario() {
    }

    public Usuario(String username, String password, String telefono, Direccion direccion, Date fecha_nacimiento, String sexo) {
        this.username = username;
        this.password = password;
        this.telefono = telefono;
        this.direccion = direccion;
        this.fecha_nacimiento = fecha_nacimiento;
        this.sexo = sexo;
    }

    public Usuario(ObjectId id, String username, String password, String telefono, Direccion direccion, Date fecha_nacimiento, String sexo) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.telefono = telefono;
        this.direccion = direccion;
        this.fecha_nacimiento = fecha_nacimiento;
        this.sexo = sexo;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    
        
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.id);
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
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", username=" + username + ", password=" + password + ", fecha_nacimiento=" + fecha_nacimiento + ", sexo=" + sexo + '}';
    }

    



   
    
    
   
}
