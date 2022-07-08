package componentes;

import entidades.Chat;
import entidades.Usuario;
import excepciones.NegocioException;
import guis.ChatPanel;
import guis.Menu_Left;
import interfaces.INegocioFachada;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ItemChatActivo extends javax.swing.JPanel {

    private boolean isSelected;
    private Menu_Left padre;
    private Usuario usuario;
    private INegocioFachada negFac;
    private Chat chat;
    
    public ItemChatActivo(Menu_Left padre, Usuario usuario, INegocioFachada negFac) {
        initComponents();
        this.negFac = negFac;
        this.padre = padre;
        this.usuario = usuario;
        init();
    }

    private void init() {
        try {
            isSelected = false;
            lblNombre.setText(this.usuario.getUsername());
            this.chat = negFac.consultarChat(padre.getUsuario(), usuario);
            String texto = null;
            if(!chat.getMensajes().isEmpty())
                texto = chat.getMensajes().get(chat.getMensajes().size()-1).getTexto();
            texto = formatearMensaje(texto);
            
            lblUltimoMensaje.setText(texto);
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent me) {
                    if(!isSelected)
                        setBackground(new Color(32,44,51));
                }
                
                @Override
                public void mouseExited(MouseEvent me) {
                    if(!isSelected)
                        setBackground(new Color(17,27,33));
                }
            });
        } catch (NegocioException ex) {
            Logger.getLogger(ItemChatActivo.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(padre.getHome(), ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private String formatearMensaje(String texto){
        int maximosCaracteres = 15;
        if(texto == null)
            return "";
        if(texto.length() > maximosCaracteres){
            return texto.substring(0, 13) + " ...";
        }
        return texto;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setIsSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }

    public Usuario getUsuario() {
        return usuario;
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imgAvatar = new swingComponents.ImageAvatar();
        panInformacion = new javax.swing.JPanel();
        lblNombre = new javax.swing.JLabel();
        lblUltimoMensaje = new javax.swing.JLabel();

        setBackground(new java.awt.Color(17, 27, 33));
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        imgAvatar.setBackground(new java.awt.Color(17, 27, 33));
        imgAvatar.setBorderSize(0);
        imgAvatar.setImage(new javax.swing.ImageIcon(getClass().getResource("/iconos/profile.png"))); // NOI18N

        panInformacion.setBackground(new java.awt.Color(255, 255, 255));
        panInformacion.setOpaque(false);

        lblNombre.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(255, 255, 255));
        lblNombre.setText("Nombre");

        lblUltimoMensaje.setFont(new java.awt.Font("sansserif", 0, 12)); // NOI18N
        lblUltimoMensaje.setForeground(new java.awt.Color(134, 150, 160));
        lblUltimoMensaje.setText("Ultimo mensaje ");

        javax.swing.GroupLayout panInformacionLayout = new javax.swing.GroupLayout(panInformacion);
        panInformacion.setLayout(panInformacionLayout);
        panInformacionLayout.setHorizontalGroup(
            panInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panInformacionLayout.createSequentialGroup()
                .addComponent(lblUltimoMensaje, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                .addContainerGap())
        );
        panInformacionLayout.setVerticalGroup(
            panInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panInformacionLayout.createSequentialGroup()
                .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lblUltimoMensaje)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(imgAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panInformacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panInformacion, javax.swing.GroupLayout.PREFERRED_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(imgAvatar, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        //Eliminar selección chats Nuevos
        padre.setUsuarioNuevoSeleccionado(null);
        
        //Eliminar configuración si existe
        padre.toggleConfig();
        
        if(Arrays.asList(padre.getHome().getComponents()).contains(padre.getHome().getChatPanel())){
                    padre.getHome().remove(padre.getHome().getChatPanel());
        }
        
        if(chat == null){
            try {
                negFac.agregarChat(new Chat(padre.getUsuario(), usuario));
                chat = negFac.consultarChat(padre.getUsuario(), usuario);
            } catch (NegocioException ex) {
                Logger.getLogger(ItemChatActivo.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(padre.getHome(), ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        padre.cambiarSeleccionChatActivo(this);
        padre.getHome().setChatPanel(new ChatPanel(padre.getUsuario(), usuario, chat, negFac));
        padre.getHome().add(padre.getHome().getChatPanel());
        padre.getHome().repaint();
        padre.getHome().revalidate();
    }//GEN-LAST:event_formMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swingComponents.ImageAvatar imgAvatar;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblUltimoMensaje;
    private javax.swing.JPanel panInformacion;
    // End of variables declaration//GEN-END:variables
}
