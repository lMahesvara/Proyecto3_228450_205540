package implementaciones;

import interfaces.IConexionBD;
import interfaces.IUsuariosDAO;
import interfaces.IChatsDAO;

public class DAOsFactory {
    private final static IConexionBD conexion=ConexionBD.getInstance();
    
    public static IUsuariosDAO crearUsuarioDAO(){
        return new UsuariosDAO(conexion);
    }
    
    public static IChatsDAO crearChatDAO(){
        return new ChatsDAO(conexion);
    }
    
}
