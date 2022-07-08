package interfaces;

import entidades.Chat;
import entidades.Usuario;
import excepciones.NegocioException;
import java.util.List;
import org.bson.types.ObjectId;

public interface INegocioFachada {
    //Métodos IUsuariosDAO
    public void agregarUsuario(Usuario usuario)throws NegocioException;
    public void actualizarUsuario(Usuario usuario)throws NegocioException;
    public void actualizarPassword(Usuario usuario)throws NegocioException;
    public List<Usuario> consultarUsuarios()throws NegocioException;
    public Usuario consultarUsuario(ObjectId idUsuario)throws NegocioException;
    public Usuario consultarUsuario(String telefono)throws NegocioException;
    public Usuario consultarPorUsername(String username)throws NegocioException;
    public boolean compararPasswords(String passwordEncriptada, String passwordNueva)throws NegocioException;
    //Métodos IChatsDAO
    public void agregarChat(Chat chat)throws NegocioException;
    public void actualizarChat(Chat chat)throws NegocioException;
    public List<Chat> consultarChats()throws NegocioException;
    public Chat consultarChat(ObjectId idChat)throws NegocioException;
    public List<Chat> consultarChatsPorUsuario(Usuario usuario)throws NegocioException;
    public Chat consultarChat(Usuario usuario, Usuario receptor)throws NegocioException;
}
