package componentes;

import entidades.Chat;
import entidades.Mensaje;
import entidades.Usuario;
import excepciones.NegocioException;
import swingComponents.ScrollBar;
import java.awt.Adjustable;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.util.Calendar;
import javax.swing.JScrollBar;
import net.miginfocom.swing.MigLayout;
import interfaces.INegocioFachada;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Chat_Body extends javax.swing.JPanel {

    private Usuario principal;
    private Usuario usuarioChat;
    private Chat chat;
    private INegocioFachada negFac;
    private Date fechaActual;
    
    public Chat_Body(Usuario principal, Usuario usuarioChat, Chat chat, INegocioFachada negFac) {
        initComponents();
        this.negFac = negFac;
        this.principal = principal;
        this.usuarioChat = usuarioChat;
        this.chat = chat;
        init();
    }

    private void init() {
        panBody.setLayout(new MigLayout("fillx", "", "5[]5"));
        panBodyChat.setVerticalScrollBar(new ScrollBar());
        cargarItems();
    }
    
    private void cargarItems(){
        fechaActual = null;
        for(Mensaje m: chat.getMensajes()){
            if(addDate(m.getFecha_de_registro(), fechaActual)){
                fechaActual = m.getFecha_de_registro();
            }
            if(m.getUsuario().equals(principal)){
                cargarItemRight(m);
            }
            if(m.getUsuario().equals(usuarioChat)){
                addItemLeft(m);
            }
        }
    }

    public void addItemLeft(Mensaje mensaje) {
        Chat_Left item = new Chat_Left();
        item.setText(mensaje.getTexto(), mensaje.getFecha_de_registro());
        panBody.add(item, "wrap, w 100::60%");//  ::80% set max with 80%
        panBody.repaint();
        panBody.revalidate();
    }

    public void addItemRight(String text) {
        try {
            Chat_Right item = new Chat_Right();
            item.setText(text);
            Date hora = Calendar.getInstance().getTime();
            item.setTime(hora);
            if(addDate(hora, fechaActual)){
                fechaActual = hora;
            }
            panBody.add(item, "wrap, al right, w 100::60%");//  ::80% set max with 80%
            panBody.repaint();
            panBody.revalidate();
            scrollToBottom();
            Mensaje mensaje = new Mensaje(principal, text, hora);
            chat.addMensaje(mensaje);
            if(chat.getId() == null){
                negFac.agregarChat(chat);
            }else{
                negFac.actualizarChat(chat);
            }
        
        } catch (NegocioException ex) {
            Logger.getLogger(Chat_Body.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void cargarItemRight(Mensaje mensaje) {
        Chat_Right item = new Chat_Right();
        item.setText(mensaje.getTexto());
        panBody.add(item, "wrap, al right, w 100::60%");//  ::80% set max with 80%
        panBody.repaint();
        panBody.revalidate();
        item.setTime(mensaje.getFecha_de_registro());
        scrollToBottom();
    }

    public boolean addDate(Date fechaNueva, Date fechaActual) {
        LocalDate fechaNuevalSinHoras = fechaNueva.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        if(fechaActual != null){
            LocalDate fechaActualSinHoras = fechaActual.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            if(fechaActualSinHoras.equals(fechaNuevalSinHoras))
                return false;
        }
        Chat_Date item = new Chat_Date();
        if(fechaNuevalSinHoras.equals(LocalDate.now())){
            item.setDate("HOY");
        }else{
            SimpleDateFormat formateo = new SimpleDateFormat("dd/MM/yyyy");
            item.setDate(formateo.format(fechaNueva));
        }
        panBody.add(item, "wrap, al center");
        panBody.repaint();
        panBody.revalidate();
        return true;
    }
    
    private void scrollToBottom() {
        JScrollBar verticalBar = panBodyChat.getVerticalScrollBar();
        AdjustmentListener downScroller = new AdjustmentListener() {
            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
                Adjustable adjustable = e.getAdjustable();
                adjustable.setValue(adjustable.getMaximum());
                verticalBar.removeAdjustmentListener(this);
            }
        };
        verticalBar.addAdjustmentListener(downScroller);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panBodyChat = new javax.swing.JScrollPane();
        panBody = new javax.swing.JPanel();

        panBodyChat.setBorder(null);
        panBodyChat.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        panBody.setBackground(new java.awt.Color(17, 27, 33));

        javax.swing.GroupLayout panBodyLayout = new javax.swing.GroupLayout(panBody);
        panBody.setLayout(panBodyLayout);
        panBodyLayout.setHorizontalGroup(
            panBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 826, Short.MAX_VALUE)
        );
        panBodyLayout.setVerticalGroup(
            panBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 555, Short.MAX_VALUE)
        );

        panBodyChat.setViewportView(panBody);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panBodyChat)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panBodyChat)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panBody;
    private javax.swing.JScrollPane panBodyChat;
    // End of variables declaration//GEN-END:variables
}
