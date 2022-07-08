package interfaces;

import entidades.Chat;
import entidades.Usuario;
import excepciones.PersistenciaException;
import java.util.List;
import org.bson.types.ObjectId;

public interface IPersistenciaFachada {
    //Métodos IUsuariosDAO
    public void agregarUsuario(Usuario usuario)throws PersistenciaException;
    public void actualizarUsuario(Usuario usuario)throws PersistenciaException;
    public void actualizarPassword(Usuario usuario)throws PersistenciaException;
    public List<Usuario> consultarUsuarios()throws PersistenciaException;
    public Usuario consultarUsuario(ObjectId idUsuario)throws PersistenciaException;
    public Usuario consultarUsuario(String correo)throws PersistenciaException;
    public Usuario consultarPorUsername(String username)throws PersistenciaException;
    //Métodos IChatsDAO
    public void agregarChat(Chat chat)throws PersistenciaException;
    public void actualizarChat(Chat chat)throws PersistenciaException;
    public List<Chat> consultarChats()throws PersistenciaException;
    public Chat consultarChat(ObjectId idChat)throws PersistenciaException;
    public List<Chat> consultarChatsPorUsuario(Usuario usuario)throws PersistenciaException;
    public Chat consultarChat(Usuario usuario, Usuario receptor)throws PersistenciaException;
}
