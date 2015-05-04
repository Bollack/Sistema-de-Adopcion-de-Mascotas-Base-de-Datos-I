/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI_View;

import java.sql.SQLException;

/**
 *
 * @author Daniel
 */
public class Error_connection_db extends javax.swing.JFrame {

    /*
     * Creates new form ver_Usuario
     *
    */
    public Error_connection_db(SQLException e) {
        initComponents();
        String mensaje=e.getMessage();
        this.mensajeErrorLabel.setText("<html><body>"+mensaje+"</body></html>");
    }
    
    public Error_connection_db(Exception e) {
        initComponents();
        String mensaje=e.getMessage();
        this.mensajeErrorLabel.setText("<html><body>"+mensaje+"</body></html>");

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        aceptarButton = new javax.swing.JButton();
        mensajeErrorLabel = new javax.swing.JLabel();
        backgroundImage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("¡Abandonen toda esperanza!");
        getContentPane().setLayout(null);

        jLabel2.setFont(new java.awt.Font("Rockwell", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Error de conexión");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 524, 29);

        jLabel3.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("<html><body>¡Oh no! Ha ocurrido un error tratando de conectar la base de datos.  Vuelve a intentarlo y si el problema persiste, contacte al desarollador de la aplicación para recibir asistencia. </body></html>");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(30, 40, 470, 60);

        aceptarButton.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        aceptarButton.setText("Aceptar");
        aceptarButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        aceptarButton.setContentAreaFilled(false);
        aceptarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarButtonActionPerformed(evt);
            }
        });
        getContentPane().add(aceptarButton);
        aceptarButton.setBounds(210, 180, 101, 31);

        mensajeErrorLabel.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        mensajeErrorLabel.setForeground(new java.awt.Color(204, 0, 0));
        mensajeErrorLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mensajeErrorLabel.setText("a");
        getContentPane().add(mensajeErrorLabel);
        mensajeErrorLabel.setBounds(30, 100, 462, 70);

        backgroundImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI_View/Images/perro-abandonado2.jpg"))); // NOI18N
        getContentPane().add(backgroundImage);
        backgroundImage.setBounds(-6, -1, 520, 220);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void aceptarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarButtonActionPerformed
        // TODO add your handling code here:
        this.show(false);
        this.hide();
    }//GEN-LAST:event_aceptarButtonActionPerformed

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton aceptarButton;
    private javax.swing.JLabel backgroundImage;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    public javax.swing.JLabel mensajeErrorLabel;
    // End of variables declaration//GEN-END:variables
}
