package componentes;

public class Chat_Date extends javax.swing.JLayeredPane {

    public Chat_Date() {
        initComponents();
    }

    public void setDate(String date) {
        lblDate.setText(date);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblDate = new javax.swing.JLabel();
        lblLinea1 = new swingComponents.Line();
        lblLinea2 = new swingComponents.Line();

        lblDate.setForeground(new java.awt.Color(191, 191, 191));
        lblDate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDate.setText("06/06/2021");

        lblLinea1.setForeground(new java.awt.Color(191, 191, 191));

        lblLinea2.setForeground(new java.awt.Color(191, 191, 191));

        setLayer(lblDate, javax.swing.JLayeredPane.DEFAULT_LAYER);
        setLayer(lblLinea1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        setLayer(lblLinea2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblLinea1, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblLinea2, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLinea2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblDate)
                        .addComponent(lblLinea1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblDate;
    private swingComponents.Line lblLinea1;
    private swingComponents.Line lblLinea2;
    // End of variables declaration//GEN-END:variables
}
