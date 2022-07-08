package interfaces;

import entidades.Chat;
import entidades.Usuario;
import excepciones.PersistenciaException;
import java.util.List;
import org.bson.types.ObjectId;

public interface IChatsDAO {
    public void agregar(Chat chat)throws PersistenciaException;
    public void actualizar(Chat chat)throws PersistenciaException;
    public List<Chat> consultarTodos()throws PersistenciaException;
    public Chat consultar(ObjectId idChat)throws PersistenciaException;
    public List<Chat> consultarTodos(Usuario usuario)throws PersistenciaException;
    public Chat consultar(Usuario usuario, Usuario receptor)throws PersistenciaException;
}
