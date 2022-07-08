package bos;

import encriptadores.EncriptadorAES;
import entidades.Usuario;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import implementaciones.PersistenciaFachada;
import interfaces.IPersistenciaFachada;
import interfaces.IUsuarioBO;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.JOptionPane;
import org.bson.types.ObjectId;

public class UsuarioBO implements IUsuarioBO{

    private IPersistenciaFachada perFac;
    private EncriptadorAES encriptador;
    public UsuarioBO() {
        perFac = new PersistenciaFachada();
        encriptador=new EncriptadorAES();
    }
    
    @Override
    public void agregar(Usuario usuario) throws NegocioException{
        String contraseniaEncriptada="";
        try {
            contraseniaEncriptada =encriptador.encriptar(usuario.getPassword());
            usuario.setPassword(contraseniaEncriptada);
            perFac.agregarUsuario(usuario);
        } catch (Exception ex) {
            Logger.getLogger(UsuarioBO.class.getName()).log(Level.SEVERE, null, ex);
            throw new NegocioException(ex.getMessage());
        }
        
    }
    
    @Override
    public void actualizar(Usuario usuario) throws NegocioException{
        try {
            perFac.actualizarUsuario(usuario);
        }catch (Exception ex) {
            Logger.getLogger(UsuarioBO.class.getName()).log(Level.SEVERE, null, ex);
            throw new NegocioException(ex.getMessage());
        } 
        
    }
    
    @Override
    public void actualizarPassword(Usuario usuario) throws NegocioException{
        String contraseniaEncriptada="";
        String mensajeError="El usuario no pudo ser agregado, error al encriptar contraseña.";
        try {
            contraseniaEncriptada =encriptador.encriptar(usuario.getPassword());
            usuario.setPassword(contraseniaEncriptada);
            perFac.actualizarPassword(usuario);
        } catch (PersistenciaException ex) {
            Logger.getLogger(UsuarioBO.class.getName()).log(Level.SEVERE, null, ex);
            throw new NegocioException(ex.getMessage());
        }catch (Exception ex) {
            Logger.getLogger(UsuarioBO.class.getName()).log(Level.SEVERE, null, ex);
            throw new NegocioException(ex.getMessage());
        } 
    }

    @Override
    public List<Usuario> consultarTodos() throws NegocioException{
        try {
            return perFac.consultarUsuarios();
        } catch (PersistenciaException ex) {
            Logger.getLogger(UsuarioBO.class.getName()).log(Level.SEVERE, null, ex);
            throw new NegocioException(ex.getMessage());
        }
    }

    @Override
    public Usuario consultar(ObjectId idUsuario) throws NegocioException{
        try {
            return perFac.consultarUsuario(idUsuario);
        } catch (PersistenciaException ex) {
            Logger.getLogger(UsuarioBO.class.getName()).log(Level.SEVERE, null, ex);
            throw new NegocioException(ex.getMessage());
        }
    }

    @Override
    public Usuario consultar(String correo) throws NegocioException{
        try {
            return perFac.consultarUsuario(correo);
        } catch (PersistenciaException ex) {
            Logger.getLogger(UsuarioBO.class.getName()).log(Level.SEVERE, null, ex);
            throw new NegocioException(ex.getMessage());
        }
    }

    @Override
    public Usuario consultarPorUsuario(String username) throws NegocioException{
        try {
            return perFac.consultarPorUsername(username);
        } catch (PersistenciaException ex) {
            Logger.getLogger(UsuarioBO.class.getName()).log(Level.SEVERE, null, ex);
            throw new NegocioException(ex.getMessage());
        }
    }

    @Override
    public boolean compararPasswords(String passwordEncriptada, String passwordNueva) throws NegocioException {
        try {
            if(passwordEncriptada.equals(encriptador.encriptar(passwordNueva))){
               return true; 
            }
            throw new NegocioException("Las credenciales son incorrectas.");
            
        }catch (NegocioException ex) {
            throw ex;
        } catch (Exception ex) {
            Logger.getLogger(UsuarioBO.class.getName()).log(Level.SEVERE, null, ex);
            throw new NegocioException(ex.getMessage());
        }
    }

    

    
    
}
