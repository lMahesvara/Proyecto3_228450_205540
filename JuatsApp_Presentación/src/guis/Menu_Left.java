package guis;

import componentes.ItemChatActivo;
import componentes.Item_People;
import entidades.Chat;
import entidades.Usuario;
import eventos.EventMenuLeft;
import eventos.PublicEvent;
import excepciones.NegocioException;
import java.awt.Color;
import java.util.List;
import swingComponents.ScrollBar;
import net.miginfocom.swing.MigLayout;
import interfaces.INegocioFachada;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Menu_Left extends javax.swing.JPanel {
    private Usuario usuario;
    private Home home;
    private Item_People usuarioNuevoSeleccionado;
    private ItemChatActivo usuarioActivoSeleccionado;
    private INegocioFachada negFac;
    
    public Menu_Left(Home home, Usuario usuario, INegocioFachada negFac) {
        initComponents();
        this.negFac = negFac;
        this.home = home;
        this.usuario = usuario;
        init();
    }
    
    private void init() {
        panListaContactos.setVerticalScrollBar(new ScrollBar());
        panLista.setLayout(new MigLayout("fillx", "0[]0", "0[]0"));
        mostrarChatsActivos();
        PublicEvent.getInstance().addEventMenuLeft(new EventMenuLeft() {
            @Override
            public void refresh() {
                mostrarChatsActivos();
                usuarioNuevoSeleccionado = null;
                btnMensajes.setSelected(true);
                btnContactos.setSelected(false);
                mostrarChatsActivos();
            }
            
        });
    }
    
    public void cambiarSeleccionChatNuevo(Item_People nuevaSeleccion){
        if(usuarioNuevoSeleccionado != null){
            usuarioNuevoSeleccionado.setBackground(new Color(17,27,33));
            usuarioNuevoSeleccionado.setIsSelected(false);
        }
        usuarioNuevoSeleccionado = nuevaSeleccion;
        usuarioNuevoSeleccionado.setIsSelected(true);
        usuarioNuevoSeleccionado.setBackground(new Color(42,57,66));
    }
    
    public void cambiarSeleccionChatActivo(ItemChatActivo nuevaSeleccion){
        if(usuarioActivoSeleccionado != null){
            usuarioActivoSeleccionado.setBackground(new Color(17,27,33));
            usuarioActivoSeleccionado.setIsSelected(false);
        }
        usuarioActivoSeleccionado = nuevaSeleccion;
        usuarioActivoSeleccionado.setIsSelected(true);
        usuarioActivoSeleccionado.setBackground(new Color(42,57,66));
    }
    
    private void activarSeleccionadoChatActivo(Usuario usuario, ItemChatActivo nuevaSeleccion){
        if(usuarioActivoSeleccionado != null && usuario.equals(usuarioActivoSeleccionado.getUsuario())){
            cambiarSeleccionChatActivo(nuevaSeleccion);
        }
        if(usuarioNuevoSeleccionado != null && usuario.equals(usuarioNuevoSeleccionado.getUsuario())){
            cambiarSeleccionChatActivo(nuevaSeleccion);
        }
    }

    private void mostrarChatsActivos() {
        try {
            panLista.removeAll();
            List<Chat> chats = negFac.consultarChatsPorUsuario(usuario);
            chats.forEach((chat) -> {
                ItemChatActivo nuevoChat = new ItemChatActivo(this, chat.getParticipante(usuario), negFac);
                panLista.add(nuevoChat, "wrap");
                activarSeleccionadoChatActivo(chat.getParticipante(usuario), nuevoChat);
            });
            
            refreshMenuList();
        } catch (NegocioException ex) {
            Logger.getLogger(Menu_Left.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(home, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void mostrarUsuariosSinChat() {
        try {
            panLista.removeAll();
            List<Chat> chats = negFac.consultarChatsPorUsuario(usuario);
            List<Usuario> usuarios = negFac.consultarUsuarios();
            boolean existe = false;
            for(Usuario usuario: usuarios) {
                if(usuario.equals(home.getPrincipal()))
                    continue;
                for(Chat chat: chats){
                    if(chat.getParticipantes().contains(usuario)){
                        existe=true;
                        break;
                    }
                }
                if(!existe){
                    panLista.add(new Item_People(this, usuario, negFac), "wrap");
                }
                existe=false;
            }
            refreshMenuList();
        } catch (NegocioException ex) {
            Logger.getLogger(Menu_Left.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(home, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void refreshMenuList() {
        panLista.repaint();
        panLista.revalidate();
    }
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Home getHome() {
        return home;
    }

    public void setHome(Home home) {
        this.home = home;
    }

    public Item_People getUsuarioNuevoSeleccionado() {
        return usuarioNuevoSeleccionado;
    }

    public void setUsuarioNuevoSeleccionado(Item_People usuarioNuevoSeleccionado) {
        this.usuarioNuevoSeleccionado = usuarioNuevoSeleccionado;
    }

    public ItemChatActivo getUsuarioActivoSeleccionado() {
        return usuarioActivoSeleccionado;
    }

    public void setUsuarioActivoSeleccionado(ItemChatActivo usuarioActivoSeleccionado) {
        this.usuarioActivoSeleccionado = usuarioActivoSeleccionado;
    }
    
    public void toggleConfig(){
        if(Arrays.asList(home.getComponents()).contains(home.getConfig())){
            if(Arrays.asList(home.getComponents()).contains(home.getMenuRight())){
                home.remove(home.getMenuRight());
            }
            home.layoutDefault();
            home.remove(home.getConfig());
            home.repaint();
            home.revalidate();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panMenu = new javax.swing.JLayeredPane();
        btnMensajes = new componentes.MenuButton();
        btnContactos = new componentes.MenuButton();
        btnConfig = new componentes.MenuButton();
        panListaContactos = new javax.swing.JScrollPane();
        panLista = new javax.swing.JLayeredPane();

        setBackground(new java.awt.Color(242, 242, 242));

        panMenu.setBackground(new java.awt.Color(32, 44, 51));
        panMenu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(47, 59, 67)));
        panMenu.setOpaque(true);
        panMenu.setLayout(new java.awt.GridLayout(1, 3));

        btnMensajes.setIconSelected(new javax.swing.ImageIcon(getClass().getResource("/iconos/message_selected.png"))); // NOI18N
        btnMensajes.setIconSimple(new javax.swing.ImageIcon(getClass().getResource("/iconos/message.png"))); // NOI18N
        btnMensajes.setSelected(true);
        btnMensajes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMensajesActionPerformed(evt);
            }
        });
        panMenu.add(btnMensajes);

        btnContactos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/group.png"))); // NOI18N
        btnContactos.setIconSelected(new javax.swing.ImageIcon(getClass().getResource("/iconos/group_selected.png"))); // NOI18N
        btnContactos.setIconSimple(new javax.swing.ImageIcon(getClass().getResource("/iconos/group.png"))); // NOI18N
        btnContactos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContactosActionPerformed(evt);
            }
        });
        panMenu.add(btnContactos);

        btnConfig.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/profileSettings.png"))); // NOI18N
        btnConfig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfigActionPerformed(evt);
            }
        });
        panMenu.add(btnConfig);

        panListaContactos.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        panListaContactos.setBackground(new java.awt.Color(242, 242, 242));
        panListaContactos.setBorder(null);

        panLista.setBackground(new java.awt.Color(17, 27, 33));
        panLista.setOpaque(true);

        javax.swing.GroupLayout panListaLayout = new javax.swing.GroupLayout(panLista);
        panLista.setLayout(panListaLayout);
        panListaLayout.setHorizontalGroup(
            panListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panListaLayout.setVerticalGroup(
            panListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 576, Short.MAX_VALUE)
        );

        panListaContactos.setViewportView(panLista);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
            .addComponent(panListaContactos)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(panListaContactos)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnMensajesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMensajesActionPerformed
        if (!btnMensajes.isSelected()) {
            btnMensajes.setSelected(true);
            btnContactos.setSelected(false);
            mostrarChatsActivos();
        }
    }//GEN-LAST:event_btnMensajesActionPerformed

    private void btnContactosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContactosActionPerformed
        if (!btnContactos.isSelected()) {
            btnMensajes.setSelected(false);
            btnContactos.setSelected(true);
            mostrarUsuariosSinChat();
        }
    }//GEN-LAST:event_btnContactosActionPerformed

    private void btnConfigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfigActionPerformed
        home.toggleChatPanel();
        if(Arrays.asList(home.getComponents()).contains(home.getConfig())){
            if(Arrays.asList(home.getComponents()).contains(home.getMenuRight())){
                home.remove(home.getMenuRight());
            }
            home.layoutDefault();
            home.remove(home.getConfig());
        }else{
            home.setConfig(new Configuracion(negFac, home));
            home.add(home.getConfig());
        }
        home.repaint();
        home.revalidate();  
    }//GEN-LAST:event_btnConfigActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private componentes.MenuButton btnConfig;
    private componentes.MenuButton btnContactos;
    private componentes.MenuButton btnMensajes;
    private javax.swing.JLayeredPane panLista;
    private javax.swing.JScrollPane panListaContactos;
    private javax.swing.JLayeredPane panMenu;
    // End of variables declaration//GEN-END:variables
}
