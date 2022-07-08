package interfaces;

import entidades.Usuario;
import excepciones.PersistenciaException;
import java.util.List;
import org.bson.types.ObjectId;

public interface IUsuariosDAO {
    public void agregar(Usuario usuario)throws PersistenciaException;
    public void actualizar(Usuario usuario)throws PersistenciaException;
    public void actualizarPassword(Usuario usuario)throws PersistenciaException;
    public List<Usuario> consultarTodos()throws PersistenciaException;
    public Usuario consultar(ObjectId idUsuario)throws PersistenciaException;
    public Usuario consultar(String telefono)throws PersistenciaException;
    public Usuario consultarPorUsuario(String username)throws PersistenciaException;
}
