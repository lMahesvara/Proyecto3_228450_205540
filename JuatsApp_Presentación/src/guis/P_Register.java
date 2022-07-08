package guis;

import entidades.Direccion;
import entidades.Usuario;
import eventos.PublicEvent;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import swingComponents.LimitJTextField;

public class P_Register extends javax.swing.JPanel {

    /**
     * Creates new form P_Login
     */
    public P_Register() {
        initComponents();
        init();
    }
 
    private void init(){
        datePicker.setDateToToday();
        datePicker.getComponentDateTextField().setEditable(false);
        this.txtNombre.setDocument(new LimitJTextField(50));
        this.txtTelefono.setDocument(new LimitJTextField(12));
        this.txtPassword.setDocument(new LimitJTextField(50));
        this.txtCalle.setDocument(new LimitJTextField(50));
        this.txtCiudad.setDocument(new LimitJTextField(50));
        this.txtCodigoPostal.setDocument(new LimitJTextField(5));
        this.txtNumero.setDocument(new LimitJTextField(5));
        this.txtColonia.setDocument(new LimitJTextField(50));
        this.comboSexo.setSelectedIndex(0);
        datePicker.getComponentDateTextField().setBackground(new Color(32,44,51));
        datePicker.getComponentDateTextField().setForeground(new Color(255,255,255));
        datePicker.getComponentToggleCalendarButton().setBackground(new Color(32,44,51));
        datePicker.getComponentToggleCalendarButton().setForeground(new Color(255,255,255));
        llenarCbSexo();
    }
    
    private void llenarCbSexo(){
        String [] edades=new String[] {"MASCULINO","FEMENINO","ROBOT","NINJA","OTRO"};
       
        DefaultComboBoxModel<String> cmbmSexo = new DefaultComboBoxModel<>(edades);
        
        this.comboSexo.setModel(cmbmSexo);
        
    }
    
    private void limpiarFormulario(){
         this.txtNombre.setText("");
         this.txtTelefono.setText("");
         this.txtPassword.setText("");
         this.txtCalle.setText("");
         this.txtCiudad.setText("");
         this.txtCodigoPostal.setText("");
         this.txtColonia.setText("");
         this.txtNumero.setText("");
         this.comboSexo.setSelectedIndex(0);
         this.datePicker.setDateToToday();
    
    }
    
    private boolean validarCampos(Usuario usuario) {

        StringBuffer mensaje = new StringBuffer();
        
        String nombre=usuario.getUsername();
        String password=usuario.getPassword();
        String telefono=usuario.getTelefono();
        Direccion direccion= usuario.getDireccion();
        String calle=direccion.getCalle();
        String numero=direccion.getNumero();
        String colonia=direccion.getColonia();
        String ciudad=direccion.getCiudad();
        String codigoPostal=direccion.getCodigo_postal();
        
        //Usuario
        if(nombre.isEmpty()){
            mensaje.append("El username no puede ser vacío.\n");
        }
        if(!password.isEmpty()){
            if(password.length()<4){
                mensaje.append("La contraseña debe tener mínimo 4 caracteres.\n");
            }
        }else{
            mensaje.append("La contraseña no puede ser vacío.\n");
        }
        
        if(!telefono.isEmpty()){
            if (telefono.length()!=12) {
                mensaje.append("Introduzca un número de 10 dígitos.\n");
            }
        }else{
             mensaje.append("El teléfono no puede ser vacío.\n");
        }
        
        if(datePicker.getDate().isAfter(LocalDate.now())){
            mensaje.append("No puede nacer mañana no mame.\n");
        }
        
        //Direccion 
        if(calle.isEmpty()){
           mensaje.append("La calle no puede ser vacío.\n"); 
        }
        
        if(numero.isEmpty()){
             mensaje.append("El número no puede ser vacío.\n");
        }
        
        if(colonia.isEmpty()){
             mensaje.append("La colonia no puede ser vacía.\n");
        }
        
        if(ciudad.isEmpty()){
             mensaje.append("La ciudad no puede ser vacía.\n");
        }
        
        if(codigoPostal.isEmpty()){
             mensaje.append("El código postal no puede ser vacío.\n");
        }else{
            if(codigoPostal.length()!=5){
                mensaje.append("El código postal debe tener mínimo 5 dígitos.\n");
            }
            
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

        txtTelefono4 = new javax.swing.JTextField();
        lbTitle = new javax.swing.JLabel();
        lbPassword = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        btnRegister = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        lbUsername = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lbFechaNacimiento = new javax.swing.JLabel();
        lbSexo = new javax.swing.JLabel();
        comboSexo = new javax.swing.JComboBox<>();
        lbTelefono = new javax.swing.JLabel();
        datePicker = new com.github.lgooddatepicker.components.DatePicker();
        lbCalle = new javax.swing.JLabel();
        txtCalle = new javax.swing.JTextField();
        lbColonia = new javax.swing.JLabel();
        txtColonia = new javax.swing.JTextField();
        lbCiudad = new javax.swing.JLabel();
        txtCiudad = new javax.swing.JTextField();
        lbCodigoPostal = new javax.swing.JLabel();
        lbNumero = new javax.swing.JLabel();
        txtCodigoPostal = new javax.swing.JTextField();
        txtNumero = new javax.swing.JTextField();

        txtTelefono4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefono4ActionPerformed(evt);
            }
        });

        setBackground(new java.awt.Color(255, 255, 255));
        setOpaque(false);

        lbTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitle.setText("Register");
        lbTitle.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        lbTitle.setForeground(new java.awt.Color(255, 255, 255));

        lbPassword.setText("Password");
        lbPassword.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lbPassword.setForeground(new java.awt.Color(255, 255, 255));

        txtTelefono.setBackground(new java.awt.Color(32, 44, 51));
        txtTelefono.setForeground(new java.awt.Color(255, 255, 255));
        txtTelefono.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTelefonoFocusLost(evt);
            }
        });
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
        txtPassword.setForeground(new java.awt.Color(255, 255, 255));

        btnRegister.setText("Register");
        btnRegister.setBackground(new java.awt.Color(32, 44, 51));
        btnRegister.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnRegister.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        btnRegister.setForeground(new java.awt.Color(255, 255, 255));
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });

        btnBack.setText("Regresar a inicio");
        btnBack.setBackground(new java.awt.Color(32, 44, 51));
        btnBack.setBorderPainted(false);
        btnBack.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnBack.setForeground(new java.awt.Color(63, 166, 129));
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        lbUsername.setText("Username");
        lbUsername.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lbUsername.setForeground(new java.awt.Color(255, 255, 255));

        txtNombre.setBackground(new java.awt.Color(32, 44, 51));
        txtNombre.setForeground(new java.awt.Color(255, 255, 255));
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        lbFechaNacimiento.setText("Fecha de nacimiento");
        lbFechaNacimiento.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lbFechaNacimiento.setForeground(new java.awt.Color(255, 255, 255));

        lbSexo.setText("Sexo");
        lbSexo.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lbSexo.setForeground(new java.awt.Color(255, 255, 255));

        comboSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboSexo.setBackground(new java.awt.Color(32, 44, 51));
        comboSexo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        comboSexo.setForeground(new java.awt.Color(255, 255, 255));
        comboSexo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboSexoActionPerformed(evt);
            }
        });

        lbTelefono.setText("Teléfono");
        lbTelefono.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lbTelefono.setForeground(new java.awt.Color(255, 255, 255));

        datePicker.setOpaque(false);

        lbCalle.setText("Calle");
        lbCalle.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lbCalle.setForeground(new java.awt.Color(255, 255, 255));

        txtCalle.setBackground(new java.awt.Color(32, 44, 51));
        txtCalle.setForeground(new java.awt.Color(255, 255, 255));
        txtCalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCalleActionPerformed(evt);
            }
        });

        lbColonia.setText("Colonia");
        lbColonia.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lbColonia.setForeground(new java.awt.Color(255, 255, 255));

        txtColonia.setBackground(new java.awt.Color(32, 44, 51));
        txtColonia.setForeground(new java.awt.Color(255, 255, 255));
        txtColonia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtColoniaActionPerformed(evt);
            }
        });

        lbCiudad.setText("Ciudad");
        lbCiudad.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lbCiudad.setForeground(new java.awt.Color(255, 255, 255));

        txtCiudad.setBackground(new java.awt.Color(32, 44, 51));
        txtCiudad.setForeground(new java.awt.Color(255, 255, 255));
        txtCiudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCiudadActionPerformed(evt);
            }
        });

        lbCodigoPostal.setText("Código postal");
        lbCodigoPostal.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lbCodigoPostal.setForeground(new java.awt.Color(255, 255, 255));

        lbNumero.setText("Número");
        lbNumero.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lbNumero.setForeground(new java.awt.Color(255, 255, 255));

        txtCodigoPostal.setBackground(new java.awt.Color(32, 44, 51));
        txtCodigoPostal.setForeground(new java.awt.Color(255, 255, 255));
        txtCodigoPostal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoPostalActionPerformed(evt);
            }
        });
        txtCodigoPostal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoPostalKeyTyped(evt);
            }
        });

        txtNumero.setBackground(new java.awt.Color(32, 44, 51));
        txtNumero.setForeground(new java.awt.Color(255, 255, 255));
        txtNumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumeroActionPerformed(evt);
            }
        });
        txtNumero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNumeroKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtCalle, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lbCalle, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbNumero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNumero, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)))
                    .addComponent(btnRegister, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbUsername, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNombre)
                    .addComponent(txtPassword)
                    .addComponent(txtTelefono)
                    .addComponent(txtColonia)
                    .addComponent(lbColonia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbTelefono, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbPassword, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(datePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(comboSexo, 0, 176, Short.MAX_VALUE)
                            .addComponent(lbSexo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lbCiudad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtCiudad, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCodigoPostal)
                            .addComponent(lbCodigoPostal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(10, 10, 10))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lbTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbUsername)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(lbPassword)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbTelefono)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCalle)
                    .addComponent(lbNumero))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbColonia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtColonia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCiudad)
                    .addComponent(lbCodigoPostal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodigoPostal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbFechaNacimiento)
                    .addComponent(lbSexo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(datePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(74, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        PublicEvent.getInstance().getEventLogin().goLogin();
        limpiarFormulario();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        // TODO add your handling code here:
        String username =txtNombre.getText().trim();
        char[] pass=txtPassword.getPassword();
        String password="";
        for (int i = 0; i < pass.length; i++) {
            password+=pass[i];
        }
        String telefono=txtTelefono.getText();
        String sexo=(String)comboSexo.getSelectedItem();
        Date fecha_nacimiento = Date.from(datePicker.getDate().atStartOfDay(ZoneId.systemDefault()).toInstant());
        //Direccion info
        String calle=txtCalle.getText().trim();
        String numero=txtNumero.getText().trim();
        String colonia=txtColonia.getText().trim();
        String ciudad=txtCiudad.getText().trim();
        String codigoPostal=txtCodigoPostal.getText();
        Direccion direccion=new Direccion(calle,numero,colonia,ciudad,codigoPostal);
        //Crear usario y mandarlo
        
        Usuario usuario=new Usuario(username,password,telefono,direccion,fecha_nacimiento,sexo);
        if(validarCampos(usuario)){
            if(PublicEvent.getInstance().getEventLogin().register(usuario)){
                limpiarFormulario();
            }
            
        }
        
    }//GEN-LAST:event_btnRegisterActionPerformed

    private void txtCalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCalleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCalleActionPerformed

    private void txtColoniaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtColoniaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtColoniaActionPerformed

    private void txtCiudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCiudadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCiudadActionPerformed

    private void txtTelefono4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefono4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefono4ActionPerformed

    private void txtCodigoPostalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoPostalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoPostalActionPerformed

    private void txtNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumeroActionPerformed

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

    private void txtNumeroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumeroKeyTyped
        // TODO add your handling code here:
        if(!Character.isDigit(evt.getKeyChar())){
                    evt.consume();
         }
    }//GEN-LAST:event_txtNumeroKeyTyped

    private void txtCodigoPostalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoPostalKeyTyped
        // TODO add your handling code here:
        if(!Character.isDigit(evt.getKeyChar())){
                    evt.consume();
        }
    }//GEN-LAST:event_txtCodigoPostalKeyTyped

    private void txtTelefonoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTelefonoFocusLost
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtTelefonoFocusLost

    private void comboSexoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboSexoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboSexoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnRegister;
    private javax.swing.JComboBox<String> comboSexo;
    private com.github.lgooddatepicker.components.DatePicker datePicker;
    private javax.swing.JLabel lbCalle;
    private javax.swing.JLabel lbCiudad;
    private javax.swing.JLabel lbCodigoPostal;
    private javax.swing.JLabel lbColonia;
    private javax.swing.JLabel lbFechaNacimiento;
    private javax.swing.JLabel lbNumero;
    private javax.swing.JLabel lbPassword;
    private javax.swing.JLabel lbSexo;
    private javax.swing.JLabel lbTelefono;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JLabel lbUsername;
    private javax.swing.JTextField txtCalle;
    private javax.swing.JTextField txtCiudad;
    private javax.swing.JTextField txtCodigoPostal;
    private javax.swing.JTextField txtColonia;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtTelefono4;
    // End of variables declaration//GEN-END:variables
}
