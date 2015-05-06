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
public class VerFotosAdopcion extends javax.swing.JFrame {

    
    public int idAdopcion;
    /**
     * Creates new form VerFotosAdopcion
     */
    public VerFotosAdopcion() {
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

        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        anteriorFotoButton = new javax.swing.JButton();
        SIguienteFotoButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        verAdoptanteButton = new javax.swing.JButton();
        verMascotaButton = new javax.swing.JButton();
        razaMascotaLabel = new javax.swing.JLabel();
        tipoMascotaLabel = new javax.swing.JLabel();
        nombreAdoptante = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        fechaAdopcionLabel = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        foto2 = new javax.swing.JLabel();
        foto1 = new javax.swing.JLabel();
        descripcionFoto1 = new javax.swing.JLabel();
        descripcionFoto2 = new javax.swing.JLabel();
        atrasButton = new javax.swing.JButton();
        backgroungImage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Fotografías de la adopción");
        setPreferredSize(new java.awt.Dimension(900, 675));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Rockwell", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Fotografías de la adopción");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 890, 30);

        jPanel2.setOpaque(false);

        anteriorFotoButton.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        anteriorFotoButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI_View/Images/back_arrow.png"))); // NOI18N
        anteriorFotoButton.setBorderPainted(false);
        anteriorFotoButton.setContentAreaFilled(false);

        SIguienteFotoButton.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        SIguienteFotoButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI_View/Images/next_arrow.png"))); // NOI18N
        SIguienteFotoButton.setBorderPainted(false);
        SIguienteFotoButton.setContentAreaFilled(false);
        SIguienteFotoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SIguienteFotoButtonActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "Datos de la adopción", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Rockwell", 1, 14))); // NOI18N
        jPanel3.setDoubleBuffered(false);
        jPanel3.setOpaque(false);

        jLabel5.setFont(new java.awt.Font("Rockwell", 1, 13)); // NOI18N
        jLabel5.setText("Adoptante");

        jLabel6.setFont(new java.awt.Font("Rockwell", 1, 13)); // NOI18N
        jLabel6.setText("Tipo Mascota:");

        jLabel7.setFont(new java.awt.Font("Rockwell", 1, 13)); // NOI18N
        jLabel7.setText("Raza de mascota:");

        verAdoptanteButton.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        verAdoptanteButton.setText("Ver Adoptante");
        verAdoptanteButton.setBorderPainted(false);
        verAdoptanteButton.setOpaque(false);

        verMascotaButton.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        verMascotaButton.setText("Ver Datos de la Mascota");
        verMascotaButton.setBorderPainted(false);
        verMascotaButton.setOpaque(false);

        razaMascotaLabel.setFont(new java.awt.Font("Rockwell", 1, 13)); // NOI18N
        razaMascotaLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        razaMascotaLabel.setText("razaMascotaLabel");

        tipoMascotaLabel.setFont(new java.awt.Font("Rockwell", 1, 13)); // NOI18N
        tipoMascotaLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tipoMascotaLabel.setText("jLabel9");

        nombreAdoptante.setFont(new java.awt.Font("Rockwell", 1, 13)); // NOI18N
        nombreAdoptante.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nombreAdoptante.setText("jLabel10");

        jLabel9.setFont(new java.awt.Font("Rockwell", 1, 13)); // NOI18N
        jLabel9.setText("Fecha de Adopción");

        fechaAdopcionLabel.setFont(new java.awt.Font("Rockwell", 1, 13)); // NOI18N
        fechaAdopcionLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fechaAdopcionLabel.setText("fechaAdopcionLabel");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(verMascotaButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(verAdoptanteButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(razaMascotaLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(71, 71, 71)
                                .addComponent(nombreAdoptante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(43, 43, 43)
                                .addComponent(tipoMascotaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(fechaAdopcionLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nombreAdoptante)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tipoMascotaLabel)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(razaMascotaLabel)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fechaAdopcionLabel)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(verAdoptanteButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(verMascotaButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel4.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("<html><body>En esta ventana se muestran las fotos subidas por un adoptante de una adopción que él realizó. Presione \"Siguiente\" para ver las siguientes fotos y \"Anterior\" para volver a las anteriores. Refiérase al manual de usuario para más información.</body></html>");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(anteriorFotoButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(SIguienteFotoButton))
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(SIguienteFotoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(anteriorFotoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(30, 40, 830, 240);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "Fotografías", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Rockwell", 1, 14))); // NOI18N
        jPanel1.setOpaque(false);

        foto2.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        foto2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        foto2.setText("Foto (257, 309)");
        foto2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        foto1.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        foto1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        foto1.setText("Foto (357, 268)");
        foto1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        descripcionFoto1.setText("jLabel8");
        descripcionFoto1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Descripción", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Rockwell", 1, 14))); // NOI18N

        descripcionFoto2.setText("jLabel8");
        descripcionFoto2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Descripción", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Rockwell", 1, 14))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(foto1, javax.swing.GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE)
                    .addComponent(descripcionFoto1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(foto2, javax.swing.GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE)
                    .addComponent(descripcionFoto2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(42, 42, 42))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(descripcionFoto2, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                    .addComponent(descripcionFoto1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(foto1, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
                    .addComponent(foto2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(20, 240, 840, 400);

        atrasButton.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        atrasButton.setText("Atrás");
        atrasButton.setBorderPainted(false);
        atrasButton.setOpaque(false);
        getContentPane().add(atrasButton);
        atrasButton.setBounds(750, 640, 110, 31);

        backgroungImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI_View/Images/FOTO_ADOPCION.jpg"))); // NOI18N
        getContentPane().add(backgroungImage);
        backgroungImage.setBounds(0, 0, 890, 675);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SIguienteFotoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SIguienteFotoButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SIguienteFotoButtonActionPerformed

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
            java.util.logging.Logger.getLogger(VerFotosAdopcion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VerFotosAdopcion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VerFotosAdopcion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VerFotosAdopcion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VerFotosAdopcion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton SIguienteFotoButton;
    public javax.swing.JButton anteriorFotoButton;
    public javax.swing.JButton atrasButton;
    private javax.swing.JLabel backgroungImage;
    public javax.swing.JLabel descripcionFoto1;
    public javax.swing.JLabel descripcionFoto2;
    public javax.swing.JLabel fechaAdopcionLabel;
    public javax.swing.JLabel foto1;
    public javax.swing.JLabel foto2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public javax.swing.JLabel nombreAdoptante;
    public javax.swing.JLabel razaMascotaLabel;
    public javax.swing.JLabel tipoMascotaLabel;
    public javax.swing.JButton verAdoptanteButton;
    public javax.swing.JButton verMascotaButton;
    // End of variables declaration//GEN-END:variables
}
