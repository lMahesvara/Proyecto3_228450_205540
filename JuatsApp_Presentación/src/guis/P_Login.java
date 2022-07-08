package guis;

import eventos.PublicEvent;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import swingComponents.LimitJTextField;

public class P_Login extends javax.swing.JPanel {

    /**
     * Creates new form P_Login
     */
    public P_Login() {
        initComponents();
        init();
        
    }
    
    private void init(){
        this.txtTelefono.setDocument(new LimitJTextField(12));
        this.txtPassword.setDocument(new LimitJTextField(50));
        
    }
    
    private void limpiarFormulario(){
        this.txtTelefono.setText("");
        this.txtPassword.setText("");
    }
    
    private boolean validarCampos(){

        StringBuffer mensaje = new StringBuffer();
        
        
        char[] pass=txtPassword.getPassword();
        String password="";
        for (int i = 0; i < pass.length; i++) {
            password+=pass[i];
        }
        
        String telefono= txtTelefono.getText();
        
        
        //Usuario
        
        if(!password.isEmpty()){
            if(password.length()<4){
                mensaje.append("La contraseña debe tener mínimo 4 caracteres.\n");
            }
        }else{
            mensaje.append("La contraseña no puede ser vacío\n");
        }
        
        if(!telefono.isEmpty()){
            if (telefono.length()!=12) {
                mensaje.append("Introduzca un teléfono de 10 dígitos.\n");
            }
        }else{
             mensaje.append("El teléfono no puede ser vacío.\n");
        }
        
        
        
       if (mensaje.length() == 0) {
           return true;
        }
        JOptionPane.showMessageDialog(this, mensaje, "Información invalida", JOptionPane.INFORMATION_MESSAGE);
        return false;
        
      }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbTitle = new javax.swing.JLabel();
        lbUsername = new javax.swing.JLabel();
        lbPassword = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();
        btnRegister = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setOpaque(false);

        lbTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitle.setText("Login");
        lbTitle.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        lbTitle.setForeground(new java.awt.Color(255, 255, 255));

        lbUsername.setText("Teléfono");
        lbUsername.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lbUsername.setForeground(new java.awt.Color(255, 255, 255));

        lbPassword.setText("Password");
        lbPassword.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lbPassword.setForeground(new java.awt.Color(255, 255, 255));

        txtTelefono.setBackground(new java.awt.Color(32, 44, 51));
        txtTelefono.setForeground(java.awt.Color.white);
        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });
        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });

        txtPassword.setBackground(new java.awt.Color(32, 44, 51));
        txtPassword.setForeground(java.awt.Color.white);

        btnLogin.setBackground(new java.awt.Color(32, 44, 51));
        btnLogin.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        btnLogin.setForeground(java.awt.Color.white);
        btnLogin.setText("Login");
        btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        btnRegister.setBackground(new java.awt.Color(32, 44, 51));
        btnRegister.setForeground(new java.awt.Color(63, 166, 129));
        btnRegister.setText("Register");
        btnRegister.setBorderPainted(false);
        btnRegister.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLogin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
                    .addComponent(lbUsername, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTelefono))
                .addGap(20, 20, 20))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(127, Short.MAX_VALUE)
                .addComponent(lbTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbUsername)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbPassword)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(149, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        // TODO add your handling code here:
        PublicEvent.getInstance().getEventLogin().goRegister();
        limpiarFormulario();
    }//GEN-LAST:event_btnRegisterActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:
        String telefono=txtTelefono.getText();
        char[] pass=txtPassword.getPassword();
        String password="";
        for (int i = 0; i < pass.length; i++) {
            password+=pass[i];
        }
        
        if(validarCampos()){
            if(PublicEvent.getInstance().getEventLogin().login(telefono,password)){
                limpiarFormulario();
            }
            
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        // TODO add your handling code here:
       if(!((int)evt.getKeyChar()==KeyEvent.VK_BACK_SPACE)){
         switch(txtTelefono.getText().length()){
            case 3:txtTelefono.setText(txtTelefono.getText()+"-"); break;
            case 7:txtTelefono.setText(txtTelefono.getText()+"-"); break;
            default:
                if(!Character.isDigit(evt.getKeyChar())){
                    evt.consume();
                } break;
            }
       }
        
    }//GEN-LAST:event_txtTelefonoKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnRegister;
    private javax.swing.JLabel lbPassword;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JLabel lbUsername;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
