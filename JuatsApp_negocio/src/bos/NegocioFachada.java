package bos;

import entidades.Chat;
import entidades.Direccion;
import entidades.Usuario;
import excepciones.NegocioException;
import interfaces.IChatBO;
import interfaces.INegocioFachada;
import interfaces.IUsuarioBO;
import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;

public class NegocioFachada implements INegocioFachada{

    IUsuarioBO usuarioBO;
    IChatBO chatBO;

    public NegocioFachada() {
        usuarioBO = BOsFactory.createUsuarioBO();
        chatBO = BOsFactory.createChatBO();
    }
    
    @Override
    public void agregarUsuario(Usuario usuario) throws NegocioException{
        try {
            usuarioBO.agregar(usuario);
        } catch (Exception ex) {
            throw new NegocioException(ex.getMessage());
        }
    }

    @Override
    public void actualizarUsuario(Usuario usuario) throws NegocioException{
        try {
            usuarioBO.actualizar(usuario);
        } catch (Exception e) {
            throw new NegocioException(e.getMessage());
        }
    }
    
    @Override
    public void actualizarPassword(Usuario usuario) throws NegocioException{
        try {
            usuarioBO.actualizarPassword(usuario);
        } catch (Exception e) {
            throw new NegocioException(e.getMessage());
        }
    }

    @Override
    public List<Usuario> consultarUsuarios() throws NegocioException{
        try {
            return usuarioBO.consultarTodos();
        } catch (Exception e) {
            throw new NegocioException(e.getMessage());
        }
    }

    @Override
    public Usuario consultarUsuario(ObjectId idUsuario) throws NegocioException{
        try {
            return usuarioBO.consultar(idUsuario);
        } catch (Exception e) {
            throw new NegocioException(e.getMessage());
        }
    }

    @Override
    public Usuario consultarUsuario(String telefono) throws NegocioException{
        try {
            return usuarioBO.consultar(telefono);
        } catch (Exception e) {
            throw new NegocioException(e.getMessage());
        }
    }

    @Override
    public Usuario consultarPorUsername(String username) throws NegocioException{
        try {
            return usuarioBO.consultarPorUsuario(username);
        } catch (Exception e) {
            throw new NegocioException(e.getMessage());
        }
    }
    
    @Override
    public boolean compararPasswords(String passwordEncriptada, String passwordNueva) throws NegocioException {
        try {
            usuarioBO.compararPasswords(passwordEncriptada, passwordNueva);
            return true;
        } catch (Exception e) {
            throw new NegocioException(e.getMessage());
        }
    }

    @Override
    public void agregarChat(Chat chat) throws NegocioException{
        try {
            chatBO.agregar(chat);
        } catch (Exception e) {
            throw new NegocioException(e.getMessage());
        }
    }

    @Override
    public void actualizarChat(Chat chat) throws NegocioException{
        try {
            chatBO.actualizar(chat);
        } catch (Exception e) {
            throw new NegocioException(e.getMessage());
        }
    }

    @Override
    public List<Chat> consultarChats() throws NegocioException{
        try {
            return chatBO.consultarTodos();
        } catch (Exception e) {
            throw new NegocioException(e.getMessage());
        }
    }

    @Override
    public Chat consultarChat(ObjectId idChat) throws NegocioException{
        try {
            return chatBO.consultar(idChat);
        } catch (Exception e) {
            throw new NegocioException(e.getMessage());
        }
    }

    @Override
    public List<Chat> consultarChatsPorUsuario(Usuario usuario) throws NegocioException{
        try {
            return chatBO.consultarTodos(usuario);
        } catch (Exception e) {
            throw new NegocioException(e.getMessage());
        }
    }

    @Override
    public Chat consultarChat(Usuario usuario, Usuario receptor) throws NegocioException{
        try {
            return chatBO.consultar(usuario, receptor);
        } catch (Exception e) {
            throw new NegocioException(e.getMessage());
        }
    }

    
}