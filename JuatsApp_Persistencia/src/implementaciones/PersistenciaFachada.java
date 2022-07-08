package implementaciones;

import entidades.Chat;
import entidades.Usuario;
import excepciones.PersistenciaException;
import interfaces.IChatsDAO;
import interfaces.IPersistenciaFachada;
import interfaces.IUsuariosDAO;
import java.util.List;
import org.bson.types.ObjectId;

public class PersistenciaFachada implements IPersistenciaFachada{
    
    IUsuariosDAO usuariosDAO;
    IChatsDAO chatsDAO;

    public PersistenciaFachada() {
        usuariosDAO = DAOsFactory.crearUsuarioDAO();
        chatsDAO = DAOsFactory.crearChatDAO();
    }
    
    

    @Override
    public void agregarUsuario(Usuario usuario) throws PersistenciaException{
        try {
            usuariosDAO.agregar(usuario);
        } catch (Exception e) {
            throw new PersistenciaException(e.getMessage());
        }
    }

    @Override
    public void actualizarUsuario(Usuario usuario) throws PersistenciaException{
        try {
            usuariosDAO.actualizar(usuario);
        } catch (Exception e) {
            throw new PersistenciaException(e.getMessage());
        }
    }

    @Override
    public void actualizarPassword(Usuario usuario) throws PersistenciaException{
        try {
            usuariosDAO.actualizarPassword(usuario);
        } catch (Exception e) {
            throw new PersistenciaException(e.getMessage());
        }
    }
    
    @Override
    public List<Usuario> consultarUsuarios() throws PersistenciaException{
        try {
            return usuariosDAO.consultarTodos();
        } catch (Exception e) {
            throw new PersistenciaException(e.getMessage());
        }
    }

    @Override
    public Usuario consultarUsuario(ObjectId idUsuario) throws PersistenciaException{
        try {
            return usuariosDAO.consultar(idUsuario);
        } catch (Exception e) {
            throw new PersistenciaException(e.getMessage());
        }
    }

    @Override
    public Usuario consultarUsuario(String correo) throws PersistenciaException{
        try {
            return usuariosDAO.consultar(correo);
        } catch (Exception e) {
            throw new PersistenciaException(e.getMessage());
        }
    }

    @Override
    public Usuario consultarPorUsername(String username) throws PersistenciaException{
        try {
            return usuariosDAO.consultarPorUsuario(username);
        } catch (Exception e) {
            throw new PersistenciaException(e.getMessage());
        }
    }

    @Override
    public void agregarChat(Chat chat) throws PersistenciaException{
        try {
            chatsDAO.agregar(chat);
        } catch (Exception e) {
            throw new PersistenciaException(e.getMessage());
        }
    }

    @Override
    public void actualizarChat(Chat chat) throws PersistenciaException{
        try {
            chatsDAO.actualizar(chat);
        } catch (Exception e) {
            throw new PersistenciaException(e.getMessage());
        }
    }

    @Override
    public List<Chat> consultarChats() throws PersistenciaException{
        try {
            return chatsDAO.consultarTodos();
        } catch (Exception e) {
            throw new PersistenciaException(e.getMessage());
        }
    }

    @Override
    public Chat consultarChat(ObjectId idChat) throws PersistenciaException{
        try {
            return chatsDAO.consultar(idChat);
        } catch (Exception e) {
            throw new PersistenciaException(e.getMessage());
        }
    }

    @Override
    public List<Chat> consultarChatsPorUsuario(Usuario usuario) throws PersistenciaException{
        try {
            return chatsDAO.consultarTodos(usuario);
        } catch (Exception e) {
            throw new PersistenciaException(e.getMessage());
        }
    }

    @Override
    public Chat consultarChat(Usuario usuario, Usuario receptor) throws PersistenciaException{
        try {
            return chatsDAO.consultar(usuario, receptor);
        } catch (Exception e) {
            throw new PersistenciaException(e.getMessage());
        }
    }
}