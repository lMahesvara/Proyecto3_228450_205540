package implementaciones;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Aggregates.lookup;
import static com.mongodb.client.model.Aggregates.match;
import com.mongodb.client.model.Filters;
import static com.mongodb.client.model.Filters.in;
import entidades.Chat;
import entidades.Usuario;
import excepciones.PersistenciaException;
import interfaces.IConexionBD;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;
import interfaces.IChatsDAO;
import org.bson.conversions.Bson;

public class ChatsDAO implements IChatsDAO{    
    private MongoDatabase baseDatos;
    
    public ChatsDAO(IConexionBD conexion){
        this.baseDatos = conexion.getInstanceConexion();

    }
    
    private MongoCollection<Chat> getColeccion(){
        return this.baseDatos.getCollection("chats", Chat.class); 
    }
    @Override
    public void agregar(Chat chat) throws PersistenciaException{
        try {
            MongoCollection<Chat> coleccion =this.getColeccion();
            coleccion.insertOne(chat);
        } catch (Exception e) {
            throw new PersistenciaException("No fue posible agregar el chat.");
        }
    }
    
    @Override
    public void actualizar(Chat chat) throws PersistenciaException{
        try {
            MongoCollection<Chat> coleccion=this.getColeccion();
            Document filters=new Document();
            filters.append("_id", chat.getId());
            Document modificar =new Document("$set",new Document()
            .append("idParticipantes", chat.getIdParticipantes())
            .append("titulo", chat.getTitulo())
            .append("mensajes", chat.getMensajes()));
            coleccion.updateOne(filters,modificar);
        } catch (Exception e) {
            throw new PersistenciaException("No fue posible actualizar el chat.");
        }
        
    }

    @Override
    public List<Chat> consultarTodos() throws PersistenciaException{
        try {
            MongoCollection<Chat> coleccion = this.getColeccion();
            List<Chat> listaChats = new LinkedList<>();
            List<Bson> etapas = new ArrayList<>();
            etapas.add(lookup("usuarios","idParticipantes","_id","participantes"));
            coleccion.aggregate(etapas).into(listaChats);
            return listaChats;
            
        } catch (Exception e) {
            throw new PersistenciaException("No fue posible consultar los chats.");
        }
    }
    
    @Override
     public List<Chat> consultarTodos(Usuario usuario) throws PersistenciaException{
         try {
            MongoCollection<Chat> coleccion = this.getColeccion();
            List<Chat> listaChats = new LinkedList<>();
            List<Bson> etapas = new ArrayList<>();
            etapas.add(match(in("idParticipantes", Arrays.asList(usuario.getId()))));
            etapas.add(lookup("usuarios","idParticipantes","_id","participantes"));
            coleccion.aggregate(etapas).into(listaChats);
            return listaChats;
        } catch (Exception e) {
            throw new PersistenciaException("No fue posible consultar los chats.");
        }
    }
    @Override
    public Chat consultar(Usuario usuario, Usuario receptor) throws PersistenciaException{
        try {
            MongoCollection<Chat> coleccion = this.getColeccion();
            List<Chat> listaChats = new LinkedList<>();
            List<Bson> etapas = new ArrayList<>();
            etapas.add(match(Filters.and(
                    in("idParticipantes", Arrays.asList(usuario.getId())),
                    in("idParticipantes", Arrays.asList(receptor.getId()))
            )));
            etapas.add(lookup("usuarios","idParticipantes","_id","participantes"));
            coleccion.aggregate(etapas).into(listaChats);
            if(listaChats.isEmpty())
                return null;
            return listaChats.get(0);            
        } catch (Exception e) {
            throw new PersistenciaException("No fue posible consultar el chat.");
        }
    }
     
    @Override
    public Chat consultar(ObjectId idChat) throws PersistenciaException{
        try {
            MongoCollection<Chat> coleccion = this.getColeccion();
            List<Chat> listaChats = new LinkedList<>();
            List<Bson> etapas = new ArrayList<>();
            etapas.add(match(new Document("_id", idChat)));
            etapas.add(lookup("usuarios","idParticipantes","_id","participantes"));
            coleccion.aggregate(etapas).into(listaChats);
            if(listaChats.isEmpty())
                return null;
            return listaChats.get(0);
        } catch (Exception e) {
            throw new PersistenciaException("No fue posible consultar el chat.");
        }
    }
}
