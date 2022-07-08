package implementaciones;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import entidades.Chat;
import entidades.Usuario;
import excepciones.PersistenciaException;
import interfaces.IConexionBD;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;
import interfaces.IUsuariosDAO;

public class UsuariosDAO implements IUsuariosDAO{
    private MongoDatabase baseDatos;
   
    public UsuariosDAO(IConexionBD conexion){
        this.baseDatos=conexion.getInstanceConexion();
    }
    
    private MongoCollection<Usuario> getColeccion(){
        return this.baseDatos.getCollection("usuarios", Usuario.class); 
    }
    @Override
    public void agregar(Usuario usuario) throws PersistenciaException{
        try {
            MongoCollection<Usuario> coleccion =this.getColeccion();
            coleccion.insertOne(usuario);
        } catch (Exception e) {
            throw new PersistenciaException("No fue posible agregar el usuario.");
        }
    }

    @Override
    public List<Usuario> consultarTodos() throws PersistenciaException{
        try {
            MongoCollection<Usuario> coleccion = this.getColeccion();
            List<Usuario> listaUsuarios = new LinkedList<>();
            coleccion.find(
            ).into(listaUsuarios);
            return listaUsuarios;
        } catch (Exception e) {
            throw new PersistenciaException("No fue posible consultar los usuarios.");
        }
    }

    @Override
    public Usuario consultar(ObjectId idUsuario) throws PersistenciaException{
        try {
            MongoCollection<Usuario> coleccion = this.getColeccion();
            List<Document> etapas = new ArrayList<>();
            etapas.add(new Document()
                .append("$match", new Document()
                    .append("_id", idUsuario)));
            List<Usuario> usuarios = new LinkedList<>();
            coleccion.aggregate(etapas).into(usuarios);
           if(usuarios.size()>0){
                return usuarios.get(0);
            }else{
                return null;
            }
        } catch (Exception e) {
            throw new PersistenciaException("No fue posible consultar el usuario.");
        }
    }
    
    @Override
    public Usuario consultar(String telefono) throws PersistenciaException{
        try {
            MongoCollection<Usuario> coleccion = this.getColeccion();
            List<Document> etapas = new ArrayList<>();
            etapas.add(new Document()
                .append("$match", new Document()
                    .append("telefono", telefono)));
            List<Usuario> usuarios = new LinkedList<>();
            coleccion.aggregate(etapas).into(usuarios);
            if(usuarios.size()>0){
                return usuarios.get(0);
            }else{
                return null;
            }
        } catch (Exception e) {
            throw new PersistenciaException("No fue posible consultar el usuario.");
        }
        
    }
    
    @Override
    public Usuario consultarPorUsuario(String username) throws PersistenciaException{
        try {
            MongoCollection<Usuario> coleccion = this.getColeccion();
            List<Document> etapas = new ArrayList<>();
            etapas.add(new Document()
                .append("$match", new Document()
                    .append("username", username)));
            List<Usuario> usuarios = new LinkedList<>();
            coleccion.aggregate(etapas).into(usuarios);
            if(usuarios.size()>0){
                return usuarios.get(0);
            }else{
                return null;
            }
        } catch (Exception e) {
            throw new PersistenciaException("No fue posible consultar el usuario.");
        }
    }
    
    @Override
    public void actualizar(Usuario usuario) throws PersistenciaException{
        try {
            MongoCollection<Usuario> coleccion=this.getColeccion();
            Document filters=new Document();
            filters.append("_id", usuario.getId());
            Document modificar =new Document("$set",new Document()
            .append("username", usuario.getUsername())
            .append("telefono", usuario.getTelefono())
            .append("sexo", usuario.getSexo())
            .append("fecha_nacimiento", usuario.getFecha_nacimiento())
            .append("direccion", usuario.getDireccion()));
            coleccion.updateOne(filters,modificar);
        } catch (Exception e) {
            throw new PersistenciaException("No fue posible actualizar el usuario.");
        }
    }
   
    @Override
    public void actualizarPassword(Usuario usuario) throws PersistenciaException{
        try {
            MongoCollection<Usuario> coleccion=this.getColeccion();
            Document filters=new Document();
            filters.append("_id", usuario.getId());
            Document modificar =new Document("$set",new Document()
            .append("password", usuario.getPassword()));
            coleccion.updateOne(filters,modificar);
        } catch (Exception e) {
            throw new PersistenciaException("No fue posible actualizar la contraseña.");
        }
    }
}
