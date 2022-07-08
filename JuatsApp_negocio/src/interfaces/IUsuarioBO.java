package interfaces;

import entidades.Usuario;
import excepciones.NegocioException;
import java.util.List;
import org.bson.types.ObjectId;

public interface IUsuarioBO {
    public void agregar(Usuario usuario)throws NegocioException;
    public void actualizar(Usuario usuario)throws NegocioException;
    public void actualizarPassword(Usuario usuario)throws NegocioException;
    public List<Usuario> consultarTodos()throws NegocioException;
    public Usuario consultar(ObjectId idUsuario)throws NegocioException;
    public Usuario consultar(String correo)throws NegocioException;
    public Usuario consultarPorUsuario(String username)throws NegocioException;
    public boolean compararPasswords(String passwordEncriptada, String passwordNueva)throws NegocioException;
}
