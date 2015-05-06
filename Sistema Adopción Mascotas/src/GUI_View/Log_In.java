/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_View;

/**
 *
 * @author Daniel
 */
public class Log_In extends javax.swing.JFrame {

    /**
     * Creates new form Log_In
     */
    public int asAdmin;
    
    public Log_In() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        wrongDataMessageBox = new javax.swing.JDialog();
        tituloWrongDataMessageBox = new javax.swing.JLabel();
        label1MessageBox = new javax.swing.JLabel();
        aceptarWrongDataMessageBox = new javax.swing.JButton();
        label2MessageBox = new javax.swing.JLabel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        correctDataMessageBox = new javax.swing.JDialog();
        tituloWrongDataMessageBox1 = new javax.swing.JLabel();
        label1MessageBox1 = new javax.swing.JLabel();
        label2MessageBox1 = new javax.swing.JLabel();
        aceptarCorrectDataMessageBox = new javax.swing.JButton();
        jFileChooser1 = new javax.swing.JFileChooser();
        datos_no_validos_OptionPane = new javax.swing.JOptionPane();
        jPanel1 = new javax.swing.JPanel();
        userTextField = new javax.swing.JTextField();
        passwordTextField = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        logAsComboBox = new javax.swing.JComboBox();
        LogInButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();

        wrongDataMessageBox.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        wrongDataMessageBox.setTitle("Datos incorrectos");
        wrongDataMessageBox.setAlwaysOnTop(true);
        wrongDataMessageBox.setResizable(false);

        tituloWrongDataMessageBox.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        tituloWrongDataMessageBox.setForeground(new java.awt.Color(204, 0, 0));
        tituloWrongDataMessageBox.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tituloWrongDataMessageBox.setText("Datos ingresados incorrectos");

        label1MessageBox.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        label1MessageBox.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label1MessageBox.setText("Nombre de Usuario o contraseña incorrecta.");

        aceptarWrongDataMessageBox.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        aceptarWrongDataMessageBox.setText("Aceptar");
        aceptarWrongDataMessageBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarWrongDataMessageBoxActionPerformed(evt);
            }
        });

        label2MessageBox.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        label2MessageBox.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label2MessageBox.setText("Por favor, ingrese los datos correctos.");

        javax.swing.GroupLayout wrongDataMessageBoxLayout = new javax.swing.GroupLayout(wrongDataMessageBox.getContentPane());
        wrongDataMessageBox.getContentPane().setLayout(wrongDataMessageBoxLayout);
        wrongDataMessageBoxLayout.setHorizontalGroup(
            wrongDataMessageBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tituloWrongDataMessageBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(label1MessageBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(label2MessageBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(wrongDataMessageBoxLayout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(aceptarWrongDataMessageBox)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        wrongDataMessageBoxLayout.setVerticalGroup(
            wrongDataMessageBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(wrongDataMessageBoxLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tituloWrongDataMessageBox)
                .addGap(12, 12, 12)
                .addComponent(label1MessageBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label2MessageBox)
                .addGap(23, 23, 23)
                .addComponent(aceptarWrongDataMessageBox)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        correctDataMessageBox.setTitle("Log In exitoso");

        tituloWrongDataMessageBox1.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        tituloWrongDataMessageBox1.setForeground(new java.awt.Color(0, 204, 0));
        tituloWrongDataMessageBox1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tituloWrongDataMessageBox1.setText("Ingreso al sistema exitoso");

        label1MessageBox1.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        label1MessageBox1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label1MessageBox1.setText("Los datos ingresados son correctos.");

        label2MessageBox1.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        label2MessageBox1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label2MessageBox1.setText("Por favor, espere mientras se accede al sistema.");

        aceptarCorrectDataMessageBox.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        aceptarCorrectDataMessageBox.setText("Aceptar");
        aceptarCorrectDataMessageBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarCorrectDataMessageBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout correctDataMessageBoxLayout = new javax.swing.GroupLayout(correctDataMessageBox.getContentPane());
        correctDataMessageBox.getContentPane().setLayout(correctDataMessageBoxLayout);
        correctDataMessageBoxLayout.setHorizontalGroup(
            correctDataMessageBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tituloWrongDataMessageBox1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(label1MessageBox1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
            .addComponent(label2MessageBox1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(correctDataMessageBoxLayout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(aceptarCorrectDataMessageBox)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        correctDataMessageBoxLayout.setVerticalGroup(
            correctDataMessageBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(correctDataMessageBoxLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tituloWrongDataMessageBox1)
                .addGap(12, 12, 12)
                .addComponent(label1MessageBox1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label2MessageBox1)
                .addGap(18, 18, 18)
                .addComponent(aceptarCorrectDataMessageBox)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Acceso al sistema");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true), "Ingreso al Sistema", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Rockwell", 1, 24))); // NOI18N
        jPanel1.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N

        userTextField.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        userTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userTextFieldActionPerformed(evt);
            }
        });

        passwordTextField.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        jLabel1.setText("Nombre de usuario:");

        jLabel2.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        jLabel2.setText("Contraseña");

        jLabel4.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        jLabel4.setText("Ingresar como:");

        logAsComboBox.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        logAsComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        LogInButton.setFont(new java.awt.Font("Rockwell", 1, 24)); // NOI18N
        LogInButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI_View/Images/ingresar.png"))); // NOI18N
        LogInButton.setBorderPainted(false);
        LogInButton.setContentAreaFilled(false);
        LogInButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogInButtonActionPerformed(evt);
            }
        });

        exitButton.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        exitButton.setText("Atrás");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addGap(36, 36, 36)
                        .addComponent(logAsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGap(36, 36, 36)
                            .addComponent(LogInButton, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(userTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(passwordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(passwordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(logAsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LogInButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(exitButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );

        logAsComboBox.removeAllItems();

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void userTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userTextFieldActionPerformed

    private void aceptarWrongDataMessageBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarWrongDataMessageBoxActionPerformed
        // TODO add your handling code here:
        wrongDataMessageBox.show(false);
    }//GEN-LAST:event_aceptarWrongDataMessageBoxActionPerformed

    private void aceptarCorrectDataMessageBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarCorrectDataMessageBoxActionPerformed
        // TODO add your handling code here:
        correctDataMessageBox.show(false);
    }//GEN-LAST:event_aceptarCorrectDataMessageBoxActionPerformed

    private void LogInButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogInButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LogInButtonActionPerformed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_exitButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Log_In.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Log_In.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Log_In.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Log_In.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Log_In().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton LogInButton;
    public javax.swing.JButton aceptarCorrectDataMessageBox;
    public javax.swing.JButton aceptarWrongDataMessageBox;
    private javax.swing.ButtonGroup buttonGroup1;
    public javax.swing.JDialog correctDataMessageBox;
    private javax.swing.JOptionPane datos_no_validos_OptionPane;
    public javax.swing.JButton exitButton;
    private javax.swing.JFileChooser jFileChooser1;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel4;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JLabel label1MessageBox;
    public javax.swing.JLabel label1MessageBox1;
    public javax.swing.JLabel label2MessageBox;
    public javax.swing.JLabel label2MessageBox1;
    public javax.swing.JComboBox logAsComboBox;
    public javax.swing.JTextField passwordTextField;
    public javax.swing.JLabel tituloWrongDataMessageBox;
    public javax.swing.JLabel tituloWrongDataMessageBox1;
    public javax.swing.JTextField userTextField;
    public javax.swing.JDialog wrongDataMessageBox;
    // End of variables declaration//GEN-END:variables
}
