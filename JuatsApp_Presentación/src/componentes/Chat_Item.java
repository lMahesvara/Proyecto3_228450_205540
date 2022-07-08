package componentes;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.border.EmptyBorder;

public class Chat_Item extends javax.swing.JLayeredPane {

    private JLabel label;

    public Chat_Item() {
        initComponents();
        txtTexto.setEditable(false);
        txtTexto.setBackground(new Color(0, 0, 0, 0));
        txtTexto.setOpaque(false);
    }

    public void setText(String text) {
        txtTexto.setText(text);
    }

    private String formatearHora(Date time){
        SimpleDateFormat formateo = new SimpleDateFormat("h:mm aa");
        return formateo.format(time);
    }
    
    public void setTime(Date time) {
        JLayeredPane layer = new JLayeredPane();
        layer.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 0));
        layer.setBorder(new EmptyBorder(0, 5, 10, 5));
        label = new JLabel(formatearHora(time));
        label.setForeground(new Color(113, 164, 155));
        label.setHorizontalTextPosition(JLabel.LEFT);
        layer.add(label);
        add(layer);
    }

    public void hideText() {
        txtTexto.setVisible(false);
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtTexto = new swingComponents.JIMSendTextPane();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.PAGE_AXIS));

        txtTexto.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 5, 10));
        txtTexto.setForeground(new java.awt.Color(255, 255, 255));
        txtTexto.setSelectionColor(new java.awt.Color(92, 188, 255));
        add(txtTexto);
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        super.paintComponent(grphcs);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swingComponents.JIMSendTextPane txtTexto;
    // End of variables declaration//GEN-END:variables
}
