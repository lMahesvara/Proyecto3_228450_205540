package componentes;

import entidades.Usuario;

public class Chat_Title extends javax.swing.JPanel {
    
    public Chat_Title(Usuario user) {
        initComponents();
        lblNombre.setText(user.getUsername());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        layer = new javax.swing.JLayeredPane();
        lblNombre = new javax.swing.JLabel();
        imgAvatar = new swingComponents.ImageAvatar();

        setBackground(new java.awt.Color(32, 44, 51));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(47, 59, 67)));

        layer.setLayout(new java.awt.GridLayout(0, 1));

        lblNombre.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(255, 255, 255));
        lblNombre.setText("Nombre");

        imgAvatar.setBackground(new java.awt.Color(17, 27, 33));
        imgAvatar.setBorderSize(0);
        imgAvatar.setImage(new javax.swing.ImageIcon(getClass().getResource("/iconos/profile.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(layer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(imgAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblNombre)
                .addContainerGap(332, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(layer, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
                    .addComponent(lblNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(3, 3, 3))
            .addComponent(imgAvatar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swingComponents.ImageAvatar imgAvatar;
    private javax.swing.JLayeredPane layer;
    private javax.swing.JLabel lblNombre;
    // End of variables declaration//GEN-END:variables
}
