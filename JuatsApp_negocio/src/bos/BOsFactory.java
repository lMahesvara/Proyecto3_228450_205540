package bos;

import interfaces.IChatBO;
import interfaces.IUsuarioBO;

public class BOsFactory {
    
    public static IUsuarioBO createUsuarioBO(){
        return new UsuarioBO();
    }
    
    public static IChatBO createChatBO(){
        return new ChatBO();
    }
    
}
