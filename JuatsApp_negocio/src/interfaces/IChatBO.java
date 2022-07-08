package interfaces;


import entidades.Chat;
import entidades.Usuario;
import excepciones.NegocioException;
import java.util.List;
import org.bson.types.ObjectId;

public interface IChatBO {
    public void agregar(Chat chat)throws NegocioException;
    public void actualizar(Chat chat)throws NegocioException;
    public List<Chat> consultarTodos()throws NegocioException;
    public Chat consultar(ObjectId idChat)throws NegocioException;
    public List<Chat> consultarTodos(Usuario usuario)throws NegocioException;
    public Chat consultar(Usuario usuario, Usuario receptor)throws NegocioException;
}
