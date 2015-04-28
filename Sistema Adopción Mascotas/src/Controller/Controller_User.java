/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import GUI_View.Error_connection_db;
import GUI_View.Main_User;
import GUI_View.Registro_Rescate_Mascota;
import Model.Model;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.lang.UnsupportedOperationException;
import java.sql.SQLException;
import javafx.stage.FileChooser;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.event.DocumentListener;
import org.apache.commons.lang3.*;
import org.apache.commons.mail.*;
import org.apache.commons.validator.*;
import javax.imageio.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;


/*
@author Daniel Troyo
02/04/2015  8:21 p.m Clase que controla las acciones y procesos realizados en la sesión de usuario 
 */
public class Controller_User implements ActionListener
{
    private String username; //Se utilizará para almacenarlo en los campos de auditoría 
    private Model modelo;
    private JFrame gui_Inicial;
    
    public Controller_User(Model modelo, String userLogeo)
    {
        this.modelo = modelo;
        this.username = userLogeo;
        this.gui_Inicial = new Main_User();
        
        
    }
    
    
    public void actionPerformed(ActionEvent e) {
       String comando = e.getActionCommand();

       if (comando=="Cerrar Sesión-Ventana Usuario")
       {

       }else if(comando=="Buscar Personas"){
           
       }else if(comando=="Ver mis mascotas adoptadas"){
           
       }else if(comando=="Ordenar por"){
           
           
       /*
           Se establecen las acciones a realizar en la sección de Registro Mascota, ya sean eventos
           activados por botones, selecciones o cambios en algún componente.
       */
       }else if(comando=="Registrar Mascota "){
           
       }else if(comando=="FileChooser-FotoAntesMascota-Registrar Mascota"){
           
           
           /*
           Se establece un filtro para que el FileChooser sólo muestre archivos con formatos
           de imágenes manejables por JAVA. Para esto se utiliza la clase FileFilter, así como
           la librería ImageIO y la clase FileNameExtensionFilter, los cuales permiten la 
           obtención de dichos formatos y su aplicación en el filtro. 
           
           TO TEST
           */
            JFileChooser fileOpen = new JFileChooser();
            String[] suffices = ImageIO.getReaderFileSuffixes();

     
            for (int i = 0; i < suffices.length; i++) {
            FileFilter filter = new FileNameExtensionFilter(suffices[i] + " files", suffices[i]);
            fileOpen.addChoosableFileFilter(filter);
            }
            int ret = fileOpen.showDialog(null, "Open file");

       }else if(comando=="Atras-Registrar Mascota"){
           
       }else if(comando==""){
           
       }else if(comando==""){
           
       }
        
    }
    

    
    
    public void registrar_Mascota()
    {
        //Se istancia el objeto de la clase ventana
        Registro_Rescate_Mascota ventana_rescate = new Registro_Rescate_Mascota();
        //Se inicializan los listener de los elementos de las ventanas
        /*
        Se establece el listener del botón atrás, el cual lleva al método que devuelve al usuario al menú
        principal de usuario
        */
        ventana_rescate.atrasMascotaButton.addActionListener((ActionListener) this);
        ventana_rescate.atrasMascotaButton.setActionCommand("Atras-Registrar Mascota");
        
        ventana_rescate.color1MascotaComboBox.addActionListener((ActionListener) this);
        ventana_rescate.color2MascotaComboBox.addActionListener((ActionListener) this);
        ventana_rescate.energiaMascotaComboBox.addActionListener((ActionListener) this);
        ventana_rescate.entrenamientoMascotaComboBox.addActionListener((ActionListener) this);
        ventana_rescate.espacioMascotaComboBox.addActionListener((ActionListener) this);
        ventana_rescate.espacioMascotaComboBox.addActionListener((ActionListener) this);
        /*
        Aquí se establece el listener para cuando el usuario presiona el botón de 
        Examinar y establecer así el atributo FOTO_ANTES de mascota. 
        */
        ventana_rescate.findImageButton.addActionListener((ActionListener) this);
        ventana_rescate.findImageButton.setActionCommand("FileChooser-FotoAntesMascota-Registrar Mascota");
        
        ventana_rescate.imageDirMascotaField.addActionListener((ActionListener) this);
        
        ventana_rescate.medicamentosMascotaField.getDocument().addDocumentListener((DocumentListener) (ActionListener) this);
        
        ventana_rescate.nameMascotaField.addActionListener((ActionListener) this);
        
        ventana_rescate.notasMascotaField.getDocument().addDocumentListener((DocumentListener) (ActionListener) this);
        
        ventana_rescate.razaMascotaComboBox.addActionListener((ActionListener) this);
        ventana_rescate.registrarMascotaButton.addActionListener((ActionListener) this);
        
        ventana_rescate.situacionMascotaField.getDocument().addDocumentListener((DocumentListener) (ActionListener) this);
        
        ventana_rescate.tamanoMascotaComboBox.addActionListener((ActionListener) this);
        ventana_rescate.tipoMascotaComboBox.addActionListener((ActionListener) this);
        
        ventana_rescate.tratamientoMascotaField.getDocument().addDocumentListener((DocumentListener) (ActionListener) this);
        
        ventana_rescate.veterinarioMascotaField.addActionListener((ActionListener) this);
        
        //Se comienza a alterar los componentes con restricciones en reemplazo de tablas catálogo
        
        ventana_rescate.energiaMascotaComboBox.addItem("Atlético");
        ventana_rescate.energiaMascotaComboBox.addItem("Activo");
        ventana_rescate.energiaMascotaComboBox.addItem("Regular");
        ventana_rescate.energiaMascotaComboBox.addItem("Pasivo");
        ventana_rescate.energiaMascotaComboBox.addItem("Perezoso");
        
        ventana_rescate.espacioMascotaComboBox.addItem("Amplio");
        ventana_rescate.espacioMascotaComboBox.addItem("Mediano");
        ventana_rescate.espacioMascotaComboBox.addItem("Mínimo");
        
        ventana_rescate.entrenamientoMascotaComboBox.addItem("Obediente");
        ventana_rescate.entrenamientoMascotaComboBox.addItem("Tranquilo");
        ventana_rescate.entrenamientoMascotaComboBox.addItem("Disperso");
        ventana_rescate.entrenamientoMascotaComboBox.addItem("Hiperactivo");
        
        ventana_rescate.tamanoMascotaComboBox.addItem("Grande");
        ventana_rescate.tamanoMascotaComboBox.addItem("Mediano");
        ventana_rescate.tamanoMascotaComboBox.addItem("Pequeño");
        
        ventana_rescate.color1MascotaComboBox.addItem("");
        ventana_rescate.color1MascotaComboBox.addItem("");
        ventana_rescate.color1MascotaComboBox.addItem("");
        ventana_rescate.color1MascotaComboBox.addItem("");
        ventana_rescate.color1MascotaComboBox.addItem("");
        ventana_rescate.color1MascotaComboBox.addItem("");
        ventana_rescate.color1MascotaComboBox.addItem("");
        
        ventana_rescate.color2MascotaComboBox.addItem("");
        ventana_rescate.color2MascotaComboBox.addItem("");
        ventana_rescate.color2MascotaComboBox.addItem("");
        ventana_rescate.color2MascotaComboBox.addItem("");
        ventana_rescate.color2MascotaComboBox.addItem("");
        ventana_rescate.color2MascotaComboBox.addItem("");
        ventana_rescate.color2MascotaComboBox.addItem("");
        
        ventana_rescate.
        
        ventana_rescate.show(true);



    }    
    
        private void errorConn(SQLException e)
    {
        Error_connection_db error = new Error_connection_db(e);
        error.show();
        error.setResizable(false);
    }
    

        
        private ImageIcon displayImageInLabel(ImageIcon icon, int width, int height, int x, int y)
        {
        
        Image img = icon.getImage();
        BufferedImage bi = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        Graphics g = bi.createGraphics();
        g.drawImage(img, x, y, width, y, null, null);
        icon = new ImageIcon(bi);
        return icon;
        }
        
        
        //Función ejecutada cuando el usuario presiona el botón de Cerrar Sesión ya sea en la barra o en
        // esquina inferior derecha.
        private void Log_Out()
        {
            this.gui_Inicial.dispose();
        }
}



