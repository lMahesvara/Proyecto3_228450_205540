package bos;

import entidades.Chat;
import entidades.Usuario;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import implementaciones.PersistenciaFachada;
import interfaces.IChatBO;
import interfaces.IPersistenciaFachada;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.types.ObjectId;

public class ChatBO implements IChatBO{
    private IPersistenciaFachada perFac;

    public ChatBO() {
        perFac = new PersistenciaFachada();
    }
    
    @Override
    public void agregar(Chat chat) throws NegocioException{
        try {
            perFac.agregarChat(chat);
        } catch (PersistenciaException ex) {
            Logger.getLogger(ChatBO.class.getName()).log(Level.SEVERE, null, ex);
            throw new NegocioException(ex.getMessage());
        }
    }

    @Override
    public void actualizar(Chat chat) throws NegocioException{
        try {
            perFac.actualizarChat(chat);
        } catch (PersistenciaException ex) {
            Logger.getLogger(ChatBO.class.getName()).log(Level.SEVERE, null, ex);
            throw new NegocioException(ex.getMessage());
        }
    }

    @Override
    public List<Chat> consultarTodos() throws NegocioException{
        try {
            return perFac.consultarChats();
        } catch (PersistenciaException ex) {
            Logger.getLogger(ChatBO.class.getName()).log(Level.SEVERE, null, ex);
            throw new NegocioException(ex.getMessage());
        }
    }

    @Override
    public Chat consultar(ObjectId idChat) throws NegocioException{
        try {
            return perFac.consultarChat(idChat);
        } catch (PersistenciaException ex) {
            Logger.getLogger(ChatBO.class.getName()).log(Level.SEVERE, null, ex);
            throw new NegocioException(ex.getMessage());
        }
    }

    @Override
    public List<Chat> consultarTodos(Usuario usuario) throws NegocioException{
        try {
            return perFac.consultarChatsPorUsuario(usuario);
        } catch (PersistenciaException ex) {
            Logger.getLogger(ChatBO.class.getName()).log(Level.SEVERE, null, ex);
            throw new NegocioException(ex.getMessage());
        }
    }

    @Override
    public Chat consultar(Usuario usuario, Usuario receptor) throws NegocioException{
        try {
            return perFac.consultarChat(usuario, receptor);
        } catch (PersistenciaException ex) {
            Logger.getLogger(ChatBO.class.getName()).log(Level.SEVERE, null, ex);
            throw new NegocioException(ex.getMessage());
        }
    }
    
}
