package guis;

import entidades.Direccion;
import entidades.Usuario;
import eventos.PublicEvent;
import excepciones.NegocioException;
import interfaces.INegocioFachada;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import swingComponents.LimitJTextField;

public class P_Register_Configuracion extends javax.swing.JPanel {

    private Home home;
    private INegocioFachada negFac;
    /**
     * Creates new form P_Login
     */
    public P_Register_Configuracion(Home home, INegocioFachada negFac) {
        initComponents();
        this.negFac = negFac;
        this.home = home;
        init();
    }
 
    private void init(){
        dpFecha.setDateToToday();
        dpFecha.getComponentDateTextField().setEditable(false);
        this.txtNombre.setDocument(new LimitJTextField(50));
        this.txtTelefono.setDocument(new LimitJTextField(12));
        //this.txtPassword.setDocument(new LimitJTextField(50));
        this.txtCalle.setDocument(new LimitJTextField(50));
        this.txtCiudad.setDocument(new LimitJTextField(50));
        this.txtCodigoPostal.setDocument(new LimitJTextField(5));
        this.txtNumero.setDocument(new LimitJTextField(5));
        this.txtColonia.setDocument(new LimitJTextField(50));
        this.cbxSexo.setSelectedIndex(0);
        dpFecha.getComponentDateTextField().setBackground(new Color(32,44,51));
        dpFecha.getComponentDateTextField().setForeground(new Color(255,255,255));
        dpFecha.getComponentToggleCalendarButton().setBackground(new Color(32,44,51));
        dpFecha.getComponentToggleCalendarButton().setForeground(new Color(255,255,255));
        llenarCbSexo();
        llenarFormulario(home.getPrincipal());
    }
    
    private void llenarCbSexo(){
        String [] edades=new String[] {"MASCULINO","FEMENINO","ROBOT","NINJA","OTRO"};
       
        DefaultComboBoxModel<String> cmbmSexo = new DefaultComboBoxModel<>(edades);
        
        this.cbxSexo.setModel(cmbmSexo);
        
    }
    
    
    
    private void llenarFormulario(Usuario usuario){
         this.txtNombre.setText(usuario.getUsername());
         this.txtTelefono.setText(usuario.getTelefono());
         //this.txtPassword.setText(usuario.getPassword());
         this.txtCalle.setText(usuario.getDireccion().getCalle());
         this.txtCiudad.setText(usuario.getDireccion().getCiudad());
         this.txtCodigoPostal.setText(usuario.getDireccion().getCodigo_postal());
         this.txtColonia.setText(usuario.getDireccion().getColonia());
         this.txtNumero.setText(usuario.getDireccion().getNumero());
         this.cbxSexo.setSelectedItem(usuario.getSexo());
         Date fechaNacimiento=usuario.getFecha_nacimiento();
         this.dpFecha.setDate(fechaNacimiento.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
         
     }
    
    private Usuario validarCampos() {

        StringBuffer mensaje = new StringBuffer();
        String username =txtNombre.getText().trim();
        String telefono=txtTelefono.getText();
        String sexo=(String)cbxSexo.getSelectedItem();
        Date fecha_nacimiento = Date.from(dpFecha.getDate().atStartOfDay(ZoneId.systemDefault()).toInstant());
        //Direccion info
        String calle=txtCalle.getText().trim();
        String numero=txtNumero.getText().trim();
        String colonia=txtColonia.getText().trim();
        String ciudad=txtCiudad.getText().trim();
        String codigoPostal=txtCodigoPostal.getText();
        Direccion direccion=new Direccion(calle,numero,colonia,ciudad,codigoPostal);
        //Crear usario y mandarlo

        //Usuario
        if(username.isEmpty()){
            mensaje.append("El username no puede ser vacío\n");
        }
        
        if(!telefono.isEmpty()){
            if (telefono.length()!=12) {
                mensaje.append("Introduzca un número de 10 dígitos.\n");
            }
        }else{
             mensaje.append("El teléfono no puede ser vacío.\n");
        }
        
        if(dpFecha.getDate().isAfter(LocalDate.now())){
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
           return new Usuario(home.getPrincipal().getId(),username,null,telefono,direccion,fecha_nacimiento,sexo);
        }
        JOptionPane.showMessageDialog(this, mensaje, "Información invalida", JOptionPane.INFORMATION_MESSAGE);
        return null;
        
      }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        btnActualizar = new javax.swing.JButton();
        btnCerrarSesion = new javax.swing.JButton();
        lblUsername = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblFechaNacimiento = new javax.swing.JLabel();
        lblSexo = new javax.swing.JLabel();
        cbxSexo = new javax.swing.JComboBox<>();
        lblTelefono = new javax.swing.JLabel();
        dpFecha = new com.github.lgooddatepicker.components.DatePicker();
        lblCalle = new javax.swing.JLabel();
        txtCalle = new javax.swing.JTextField();
        lblColonia = new javax.swing.JLabel();
        txtColonia = new javax.swing.JTextField();
        lblCiudad = new javax.swing.JLabel();
        txtCiudad = new javax.swing.JTextField();
        lblCodigoPostal = new javax.swing.JLabel();
        lblNumero = new javax.swing.JLabel();
        txtCodigoPostal = new javax.swing.JTextField();
        txtNumero = new javax.swing.JTextField();
        btnCambiarPassword = new javax.swing.JButton();

        setBackground(new java.awt.Color(32, 44, 51));
        setForeground(new java.awt.Color(32, 44, 51));
        setOpaque(false);

        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Configuración de Usuario");
        lblTitulo.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));

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

        btnActualizar.setBackground(new java.awt.Color(32, 44, 51));
        btnActualizar.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        btnActualizar.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizar.setText("Actualizar");
        btnActualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnCerrarSesion.setBackground(new java.awt.Color(32, 44, 51));
        btnCerrarSesion.setForeground(new java.awt.Color(63, 166, 129));
        btnCerrarSesion.setText("Cerrar sesión");
        btnCerrarSesion.setBorderPainted(false);
        btnCerrarSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });

        lblUsername.setText("Username");
        lblUsername.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lblUsername.setForeground(new java.awt.Color(255, 255, 255));

        txtNombre.setBackground(new java.awt.Color(32, 44, 51));
        txtNombre.setForeground(new java.awt.Color(255, 255, 255));
        txtNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNombreFocusLost(evt);
            }
        });
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        lblFechaNacimiento.setText("Fecha de nacimiento");
        lblFechaNacimiento.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lblFechaNacimiento.setForeground(new java.awt.Color(255, 255, 255));

        lblSexo.setText("Sexo");
        lblSexo.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lblSexo.setForeground(new java.awt.Color(255, 255, 255));

        cbxSexo.setBackground(new java.awt.Color(32, 44, 51));
        cbxSexo.setForeground(new java.awt.Color(255, 255, 255));
        cbxSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxSexo.setBorder(null);
        cbxSexo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lblTelefono.setText("Teléfono");
        lblTelefono.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lblTelefono.setForeground(new java.awt.Color(255, 255, 255));

        dpFecha.setBackground(new java.awt.Color(32, 44, 51));
        dpFecha.setForeground(new java.awt.Color(32, 44, 51));

        lblCalle.setText("Calle");
        lblCalle.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lblCalle.setForeground(new java.awt.Color(255, 255, 255));

        txtCalle.setBackground(new java.awt.Color(32, 44, 51));
        txtCalle.setForeground(new java.awt.Color(255, 255, 255));
        txtCalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCalleActionPerformed(evt);
            }
        });

        lblColonia.setText("Colonia");
        lblColonia.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lblColonia.setForeground(new java.awt.Color(255, 255, 255));

        txtColonia.setBackground(new java.awt.Color(32, 44, 51));
        txtColonia.setForeground(new java.awt.Color(255, 255, 255));
        txtColonia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtColoniaActionPerformed(evt);
            }
        });

        lblCiudad.setText("Ciudad");
        lblCiudad.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lblCiudad.setForeground(new java.awt.Color(255, 255, 255));

        txtCiudad.setBackground(new java.awt.Color(32, 44, 51));
        txtCiudad.setForeground(new java.awt.Color(255, 255, 255));
        txtCiudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCiudadActionPerformed(evt);
            }
        });

        lblCodigoPostal.setText("Código postal");
        lblCodigoPostal.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lblCodigoPostal.setForeground(new java.awt.Color(255, 255, 255));

        lblNumero.setText("Número");
        lblNumero.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lblNumero.setForeground(new java.awt.Color(255, 255, 255));

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

        btnCambiarPassword.setText("Cambiar Contraseña");
        btnCambiarPassword.setBackground(new java.awt.Color(32, 44, 51));
        btnCambiarPassword.setBorderPainted(false);
        btnCambiarPassword.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnCambiarPassword.setForeground(new java.awt.Color(255, 255, 255));
        btnCambiarPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarPasswordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtCalle, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblCalle, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNumero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNumero)))
                    .addComponent(btnActualizar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblUsername, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNombre)
                    .addComponent(txtTelefono)
                    .addComponent(txtColonia)
                    .addComponent(lblColonia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTelefono, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblCiudad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCodigoPostal)
                            .addComponent(lblCodigoPostal, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dpFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(lblFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(cbxSexo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCambiarPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblTitulo)
                .addGap(18, 18, 18)
                .addComponent(lblUsername)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTelefono)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCalle)
                    .addComponent(lblNumero))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblColonia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtColonia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCiudad)
                    .addComponent(lblCodigoPostal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodigoPostal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblFechaNacimiento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dpFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblSexo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(btnCambiarPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(btnCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        int opcion = JOptionPane.showConfirmDialog(home, "¿Confirmas que deseas cerrar sesión?","¿Cerrar sesión?",JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
        if(opcion == JOptionPane.YES_OPTION){
            PublicEvent.getInstance().getEventCerrarSesion().cerrarSesion();
            
        }
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        Usuario usuario = validarCampos();
        
        if(usuario == null)
            return;
        int opcion = JOptionPane.showConfirmDialog(home, "¿Está seguro de actualizar el Usuario?","Actualizar",JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
        if(opcion == JOptionPane.YES_OPTION){
            try {
                //TODO: Trycatch con errores
                negFac.actualizarUsuario(usuario);
                JOptionPane.showMessageDialog(home, "El usuario se actualizó correctamente", "Usuario actualizado", JOptionPane.INFORMATION_MESSAGE);        
                home.setPrincipal(usuario);
            } catch (NegocioException ex) {
                Logger.getLogger(P_Register_Configuracion.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(home, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void txtCalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCalleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCalleActionPerformed

    private void txtColoniaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtColoniaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtColoniaActionPerformed

    private void txtCiudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCiudadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCiudadActionPerformed

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

    private void btnCambiarPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarPasswordActionPerformed
        home.toggleCambiarPassword();
    }//GEN-LAST:event_btnCambiarPasswordActionPerformed

    private void txtNombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombreFocusLost
        String username = txtNombre.getText();
        if(username == null || username.isEmpty())
            return;
        try {
            Usuario user = negFac.consultarPorUsername(username);
            if(user != null && !user.getUsername().equals(home.getPrincipal().getUsername())){
                JOptionPane.showMessageDialog(home,"El username ya existe", "Información",  JOptionPane.INFORMATION_MESSAGE);
                txtNombre.requestFocus();
            }
        } catch (NegocioException ex) {
            Logger.getLogger(P_Register_Configuracion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtNombreFocusLost

    private void txtTelefonoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTelefonoFocusLost
        String telefono = txtTelefono.getText();
        if(telefono == null || telefono.isEmpty())
            return;
        try {
            Usuario user = negFac.consultarUsuario(telefono);
            if(user != null && !user.getTelefono().equals(home.getPrincipal().getTelefono())){
                JOptionPane.showMessageDialog(home,"El teléfono ya existe", "Información",  JOptionPane.INFORMATION_MESSAGE);
                txtTelefono.requestFocus();
            }
        } catch (NegocioException ex) {
            Logger.getLogger(P_Register_Configuracion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtTelefonoFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnCambiarPassword;
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JComboBox<String> cbxSexo;
    private com.github.lgooddatepicker.components.DatePicker dpFecha;
    private javax.swing.JLabel lblCalle;
    private javax.swing.JLabel lblCiudad;
    private javax.swing.JLabel lblCodigoPostal;
    private javax.swing.JLabel lblColonia;
    private javax.swing.JLabel lblFechaNacimiento;
    private javax.swing.JLabel lblNumero;
    private javax.swing.JLabel lblSexo;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JTextField txtCalle;
    private javax.swing.JTextField txtCiudad;
    private javax.swing.JTextField txtCodigoPostal;
    private javax.swing.JTextField txtColonia;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
