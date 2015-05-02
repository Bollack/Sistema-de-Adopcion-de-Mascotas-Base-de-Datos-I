/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import GUI_View.Error_connection_db;
import GUI_View.Main_User;
import GUI_View.ModificarCuenta;
import GUI_View.Registro_Rescate_Mascota;
import Model.Model;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.lang.UnsupportedOperationException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.stage.FileChooser;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import org.apache.commons.lang3.*;
import org.apache.commons.mail.*;
import org.apache.commons.validator.*;
import javax.imageio.*;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import oracle.net.aso.a;


/*
@author Daniel Troyo
02/04/2015  8:21 p.m Clase que controla las acciones y procesos realizados en la sesión de usuario 
 */
public class Controller_User implements ActionListener
{
    private String username; //Se utilizará para almacenarlo en los campos de auditoría 
    private Model modelo;
    private JFrame gui;
    
    public Controller_User(Model modelo, String userLogeo)
    {
        this.modelo = modelo;
        this.username = userLogeo;
        this.gui = new Main_User();
        this.Start();
        
    }
    
    public void Start()
    {
        this.gui = new Main_User();
        Main_User ventana = (Main_User) this.gui;
        ventana.usernameLabel.setText(this.username);
        /*
        Se agregan los listeners y nombres de comandos a las acciones posibles dentro de la ventana principal
        de usuario. 
        */
        ventana.BuscarMascotasButton.addActionListener((ActionListener)this);
        ventana.BuscarMascotasButton.setActionCommand("Buscar Mascotas - Main User");
        
        ventana.BuscarPersonasButton.addActionListener((ActionListener)this);
        ventana.BuscarPersonasButton.setActionCommand("Buscar Personas - Main Menu");
        
        ventana.formularioButton.addActionListener((ActionListener)this);
        ventana.formularioButton.setActionCommand("Formulario - Main Menu");
        
        ventana.registrarMascota.addActionListener((ActionListener)this);
        ventana.registrarMascota.setActionCommand("Registrar Mascota - Main Menu");
                
        ventana.verMascotasEnEsperaButton.addActionListener((ActionListener)this);
        ventana.verMascotasEnEsperaButton.setActionCommand("Ver Mascotas Adopción - Main Menu");
        
        ventana.verMisAdopcionesButton.addActionListener((ActionListener)this);
        ventana.verMisAdopcionesButton.setActionCommand("Ver Mis Adopciones - Main Menu");
        
        ventana.verMisMascotasRescatadasButton.addActionListener((ActionListener)this);
        ventana.verMisMascotasRescatadasButton.setActionCommand("Ver Mis Rescates - Main Menu");
        
        ventana.verDatosCuenta.addActionListener((ActionListener)this);
        ventana.verDatosCuenta.setActionCommand("Ver Cuenta - Main Menu");
                
        ventana.logOutUsuarioButton.addActionListener((ActionListener)this);
        ventana.logOutUsuarioButton.setActionCommand("Cerrar Sesión - Main Menu");
        

        ventana.show();
        ventana.setResizable(true);
    }
    
    
        private void Log_Out()
        {
            int warning =  JOptionPane.YES_NO_OPTION;
            int answer = JOptionPane.showConfirmDialog (null, "¿Está seguro de que desea salir del programa y volver al menú de visitante","Advertencia",warning);
            if (answer == JOptionPane.YES_OPTION)
            {
                this.gui.dispose();
                this.gui.show(false);
                Controller engine = new Controller();
                engine.Start();
            }
        }
    
    private void backtoAccountScreen()
    {
           this.gui.dispose();
           this.gui.show(false);
           this.gui = new Main_User();
           this.gui.show();
           this.gui.pack();
    }
    
    
    private void AccountSettings_Window()
    {
        try {
            this.gui.dispose();
            this.gui.show(false);
            ModificarCuenta ventana = new ModificarCuenta();;
            this.gui = ventana;
            
            //Agregar los listeners a eventos realizados dentro de esta pantalla, tales como
            //presionar botón o alterar un campo.
            
            ventana.guardarCambiosButton.addActionListener((ActionListener) this);
            ventana.guardarCambiosButton.setActionCommand("Guardar Cambios - Account Settings");
            
            ventana.backButton.addActionListener((ActionListener) this);
            ventana.backButton.setActionCommand("Atrás - Account Settings");
            /*
            Se extraen todos los datos del usuario de la base de datos y se insertan
            en los textfields que el usuario modificará, así este puede ver la data que modifica y
            presionar "Guardar Cambios" para guardar las ediciones hechas en dichos textfield
            */
            String[] datos = this.modelo.getDatosFromUsername(this.username); //
            
            ventana.userTextField.setText(datos[0]);
            ventana.passwordTextField.setText(datos[1]);
            ventana.nameTextField.setText(datos[2]);
            ventana.apellidoUsuarioTextField.setText(datos[3]);
            ventana.telefonoTextField.setText(datos[4]);
            ventana.correoTextField.setText(datos[5]);
            ventana.direccionTextField.setText(datos[6]);
            if (datos[7]=="Masculino")
            {
                ventana.maleRadioButton.setSelected(true);
            }else
            {
                ventana.femaleRadioButton.setSelected(true);
            }
            
            
            this.gui.show();
            this.gui.pack();
        } catch (SQLException ex) {
            Logger.getLogger(Controller_User.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException ex) {
            Logger.getLogger(Controller_User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void verMascotasAdoptadas_Window()
    {
        
    }
    
    private void BuscarPersonas_Window(){
        
    }
    
    private void registrar_Mascota_Window()
    {
        this.gui.dispose();
        this.gui.show();
        //Se istancia el objeto de la clase ventana
        Registro_Rescate_Mascota ventana_rescate = new Registro_Rescate_Mascota();
        
        this.gui = ventana_rescate;
        //Se inicializan los listener de los elementos de las ventanas
        /*
        Se establece el listener del botón atrás, el cual lleva al método que devuelve al usuario al menú
        principal de usuario
        */
        ventana_rescate.atrasMascotaButton.addActionListener((ActionListener) this);
        ventana_rescate.atrasMascotaButton.setActionCommand("Atras - Registrar Mascota");
        
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
        ventana_rescate.findImageButton.setActionCommand("FileChooser-FotoAntesMascota - Registrar Mascota");
        
        ventana_rescate.registrarMascotaButton.addActionListener((ActionListener)this);
        ventana_rescate.registrarMascotaButton.setActionCommand("Registrar Mascota - Registrar Mascota");
                
        ventana_rescate.imageDirMascotaField.addActionListener((ActionListener) this);
        
        
        ventana_rescate.nameMascotaField.addActionListener((ActionListener) this);
        
        
        ventana_rescate.razaMascotaComboBox.addActionListener((ActionListener) this);
        ventana_rescate.registrarMascotaButton.addActionListener((ActionListener) this);
        
        
        ventana_rescate.tamanoMascotaComboBox.addActionListener((ActionListener) this);
        ventana_rescate.tipoMascotaComboBox.addActionListener((ActionListener) this);
        
        
        ventana_rescate.veterinarioMascotaField.addActionListener((ActionListener) this);
        
        //Se comienza a alterar los componentes con restricciones en reemplazo de tablas catálogo
        
        ventana_rescate.energiaMascotaComboBox.removeAllItems();
        ventana_rescate.energiaMascotaComboBox.addItem("Atlético");
        ventana_rescate.energiaMascotaComboBox.addItem("Activo");
        ventana_rescate.energiaMascotaComboBox.addItem("Regular");
        ventana_rescate.energiaMascotaComboBox.addItem("Pasivo");
        ventana_rescate.energiaMascotaComboBox.addItem("Perezoso");
        
        ventana_rescate.espacioMascotaComboBox.removeAllItems();
        ventana_rescate.espacioMascotaComboBox.addItem("Amplio");
        ventana_rescate.espacioMascotaComboBox.addItem("Mediano");
        ventana_rescate.espacioMascotaComboBox.addItem("Mínimo");
        
        ventana_rescate.entrenamientoMascotaComboBox.removeAllItems();
        ventana_rescate.entrenamientoMascotaComboBox.addItem("Obediente");
        ventana_rescate.entrenamientoMascotaComboBox.addItem("Tranquilo");
        ventana_rescate.entrenamientoMascotaComboBox.addItem("Disperso");
        ventana_rescate.entrenamientoMascotaComboBox.addItem("Hiperactivo");
        
        ventana_rescate.tamanoMascotaComboBox.removeAllItems();
        ventana_rescate.tamanoMascotaComboBox.addItem("Grande");
        ventana_rescate.tamanoMascotaComboBox.addItem("Mediano");
        ventana_rescate.tamanoMascotaComboBox.addItem("Pequeño");
        
        ventana_rescate.color1MascotaComboBox.removeAllItems();
        ventana_rescate.color1MascotaComboBox.addItem("");
        ventana_rescate.color1MascotaComboBox.addItem("");
        ventana_rescate.color1MascotaComboBox.addItem("");
        ventana_rescate.color1MascotaComboBox.addItem("");
        ventana_rescate.color1MascotaComboBox.addItem("");
        ventana_rescate.color1MascotaComboBox.addItem("");
        ventana_rescate.color1MascotaComboBox.addItem("");
        
        ventana_rescate.color2MascotaComboBox.removeAllItems();
        ventana_rescate.color2MascotaComboBox.addItem("");
        ventana_rescate.color2MascotaComboBox.addItem("");
        ventana_rescate.color2MascotaComboBox.addItem("");
        ventana_rescate.color2MascotaComboBox.addItem("");
        ventana_rescate.color2MascotaComboBox.addItem("");
        ventana_rescate.color2MascotaComboBox.addItem("");
        ventana_rescate.color2MascotaComboBox.addItem("");
        
        ventana_rescate.severidadMascotaComboBox.removeAllItems();
        ventana_rescate.severidadMascotaComboBox.addItem("Crítico");
        ventana_rescate.severidadMascotaComboBox.addItem("Mal estado");
        ventana_rescate.severidadMascotaComboBox.addItem("Buen estado");
        
        ventana_rescate.show(true);
        ventana_rescate.pack();
        ventana_rescate.setResizable(false);
    }  
    
    
    public void actionPerformed(ActionEvent e) {
       String comando = e.getActionCommand();

       if (comando=="Cerrar Sesión - Main Menu")
       {
           this.Log_Out();

       }else if(comando=="Ver Cuenta - Main Menu")
       {
           this.AccountSettings_Window();
           
       }else if(comando=="Guardar Cambios - Cuenta Window")
       {
           try
           {
               cambiarDatosCuenta((ModificarCuenta)this.gui);
           }catch (Exception e)
           {
               int a = JOptionPane.ERROR_MESSAGE;
               JOptionPane.showMessageDialog(this.gui, "Ha ocurrido un error guardando los cambios", "Error", JOptionPane.ERROR_MESSAGE);
           }
           
       }else if(comando=="Atrás - Cuenta Window")
       {
           this.backtoAccountScreen();
           
       }else if(comando=="Buscar Mascotas - Main Menu")
       {
           
       }else if(comando=="Buscar Personas - Main Menu")
       {
           
       }else if(comando=="Formulario - Main Menu")
       {
           
         
       }else if(comando=="Registrar Mascota - Main Menu")
       {
           this.registrar_Mascota_Window();
           
       }else if(comando=="Ver Mascotas Adopción - Main Menu")
       {
           
       }else if(comando=="Ver Mis Adopciones - Main Menu")
       {
           
       }else if(comando=="Ver Mis Rescates - Main Menu")
       {
           
       }
       /*
        Se comienzan a crear las acciones para los botones y eventos
        que provienen de la ventana de registro/rescate de mascota 
       */
       else if(comando=="FileChooser-FotoAntesMascota-Registrar Mascota")
       {        
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
            String direccion = fileOpen.getSelectedFile().getAbsolutePath();
            Registro_Rescate_Mascota ventana = (Registro_Rescate_Mascota)this.gui;
            ventana.imageDirMascotaField.setText(direccion);

           
       }else if(comando=="Registrar Mascota - Registrar Mascota")
       {
           this.registrar_Mascota_Window();
       }else if(comando=="Atrás -Registrar Mascota")
       {
           this.backtoAccountScreen();
           
       }else if(comando=="Guardar Cambios - Account Settings")
       {
           
       }else if(comando=="Atrás - Account Settings")
       {
           this.backtoAccountScreen();
           
       }else if(comando=="Registrar Mascota - Main Menu ")
       {
           
       }else if(comando=="Registrar Mascota - Main Menu ")
       {
           
       }else if(comando=="")
       {
           
   
       }else if(comando==""){
           
       }else if(comando==""){
           
       }else if(comando==""){
           
       }else if(comando==""){
           
       }else if(comando==""){
           
       }else if(comando==""){
           
       }else if(comando==""){
           
       }else if(comando==""){
           
       }else if(comando==""){
           
       }else if(comando==""){
           
       }else if(comando==""){
           
       }else if(comando==""){
           
       }else if(comando==""){
           
       }else if(comando==""){
           
       }else if(comando==""){
           
       }else if(comando==""){
           
       }else if(comando==""){
           
       }
        
    }
    
    private void cambiarDatosCuenta(ModificarCuenta ventana)
    {
        //vent
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

}



