package guis;

import componentes.Chat_Body;
import componentes.Chat_Bottom;
import componentes.Chat_Title;
import entidades.Chat;
import entidades.Usuario;
import eventos.EventChat;
import eventos.PublicEvent;
import interfaces.INegocioFachada;
import net.miginfocom.swing.MigLayout;

public class ChatPanel extends javax.swing.JPanel {

    private Usuario principal;
    private Usuario usuarioChat;
    private Chat chat;
    private INegocioFachada negFac;
    
    /**
     * Creates new form Menu_Left
     */
    public ChatPanel(Usuario principal, Usuario usuarioChat, Chat chat, INegocioFachada negFac) {
        initComponents();
        this.principal = principal;
        this.usuarioChat = usuarioChat;
        this.chat = chat;
        this.negFac = negFac;
        init();
    }

    private void init(){
        setLayout(new MigLayout("fillx", "0[fill]0", "0[shrink 0]0[100%, bottom]0[shrink 0]0"));
        Chat_Title chatTitle = new Chat_Title(usuarioChat);
        Chat_Body chatBody = new Chat_Body(principal, usuarioChat, chat, negFac);
        Chat_Bottom chatBottom = new Chat_Bottom();
        PublicEvent.getInstance().addEventChat(new EventChat() {
            @Override
            public void sendMessage(String text) {
                chatBody.addItemRight(text);
                
            }
        });
        add(chatTitle, "wrap");
        add(chatBody, "wrap");
        add(chatBottom, "h ::50%");
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(17, 27, 33));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 727, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 665, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
