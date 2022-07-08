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

public class Item_People extends javax.swing.JPanel {

    private boolean isSelected;
    private Menu_Left padre;
    private Usuario usuario;
    private INegocioFachada negFac;
    
    public Item_People(Menu_Left padre, Usuario usuario, INegocioFachada negFac) {
        initComponents();
        this.negFac = negFac;
        this.padre = padre;
        this.usuario = usuario;
        isSelected = false;
        lblNombre.setText(this.usuario.getUsername());
        init();
    }

    private void init() {
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

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imgAvatar = new swingComponents.ImageAvatar();
        lblNombre = new javax.swing.JLabel();

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

        lblNombre.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(255, 255, 255));
        lblNombre.setText("Nombre");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(imgAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imgAvatar, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(lblNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        try {
            //Eliminar selección chats activos
            padre.setUsuarioActivoSeleccionado(null);
            
            //Eliminar configuración si existe
            padre.toggleConfig();
            
            if(Arrays.asList(padre.getHome().getComponents()).contains(padre.getHome().getChatPanel())){
                padre.getHome().remove(padre.getHome().getChatPanel());
            }
            
            Chat chat = negFac.consultarChat(padre.getUsuario(), usuario);
            if(chat == null){
               
                chat = new Chat(padre.getUsuario(),usuario);
            }
            padre.cambiarSeleccionChatNuevo(this);
            padre.getHome().setChatPanel(new ChatPanel(padre.getUsuario(), usuario, chat, negFac));
            padre.getHome().add(padre.getHome().getChatPanel());
            padre.getHome().repaint();
            padre.getHome().revalidate();
        } catch (NegocioException ex) {
            Logger.getLogger(Item_People.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(padre.getHome(), ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_formMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swingComponents.ImageAvatar imgAvatar;
    private javax.swing.JLabel lblNombre;
    // End of variables declaration//GEN-END:variables
}
