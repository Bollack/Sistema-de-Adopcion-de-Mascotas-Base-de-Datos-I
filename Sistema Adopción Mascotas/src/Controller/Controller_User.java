/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import GUI_View.Main_Visitante;
import GUI_View.Registro_Usuario;
import GUI_View.Log_In;
import GUI_View.Registro_Rescate_Mascota;
import Model.Model;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.apache.commons.lang3.*;
import org.apache.commons.mail.*;
import org.apache.commons.validator.*;
import java.lang.UnsupportedOperationException;
import javax.swing.event.DocumentListener;


/**
@author Daniel Troyo
02/04/2015  8:21 p.m Clase que controla las acciones y procesos realizados en la sesión de usuario 
 */
public class Controller_User 
{
    private String username; //Se utilizará para almacenarlo en los campos de auditoría 
    
    
    public Controller_User()
    {
        
    }
    
    
    public void actionPerformed(ActionEvent e) {
       String comando = e.getActionCommand();

       if (comando=="")
       {

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
    
    public void log_In(){
        //Crea el objeto de clase ventana de logeo
        Log_In ventanalogeo = new Log_In();
        //Establece los listeners y nombra los 
        ventanalogeo.LogInButton.addActionListener((ActionListener) this);
        ventanalogeo.LogInButton.setActionCommand("Log In-Ventana Logeo");
        ventanalogeo.exitButton.addActionListener((ActionListener) this);
        ventanalogeo.exitButton.setActionCommand("Atrás-Ventana Logeo");
        ventanalogeo.logAsComboBox.addActionListener((ActionListener) this);
        ventanalogeo.logAsComboBox.setActionCommand("Cambio de Vista-Ventana Logeo ");
        ventanalogeo.show();      
    }
    
    
    public void registrar_Mascota()
    {
        //Se istancia el objeto de la clase ventana
        Registro_Rescate_Mascota ventana_rescate = new Registro_Rescate_Mascota();
        //Se inicializan los listener de los elementos de las ventanas
        ventana_rescate.atrasMascotaButton.addActionListener((ActionListener) this);
        ventana_rescate.color1MascotaComboBox.addActionListener((ActionListener) this);
        ventana_rescate.color2MascotaComboBox.addActionListener((ActionListener) this);
        ventana_rescate.energiaMascotaComboBox.addActionListener((ActionListener) this);
        ventana_rescate.entrenamientoMascotaComboBox.addActionListener((ActionListener) this);
        ventana_rescate.espacioMascotaComboBox.addActionListener((ActionListener) this);
        ventana_rescate.espacioMascotaComboBox.addActionListener((ActionListener) this);
        ventana_rescate.findImageButton.addActionListener((ActionListener) this);
        ventana_rescate.imageDirMascotaField.addActionListener((ActionListener) this);
        ventana_rescate.lugarMascotaField.addActionListener((ActionListener) this);
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
        
        ventana_rescate.tamanoMascotaComboBox.addItem("");
        ventana_rescate.tamanoMascotaComboBox.addItem("");
        ventana_rescate.tamanoMascotaComboBox.addItem("");
        
        ventana_rescate.



    }    
    
    
    private boolean validate_Email(String email)
    {
        EmailValidator validator=EmailValidator.getInstance(); //Verificación de mail mediante la utilización de la librería Validate de Apache Commons
        if(validator.isValid(email)==false)
        {
            return false;
        }
        return true;

    }
    private boolean validate_Tel(String telefono)
    {
        if (telefono.matches("\\d{4}-\\d{2}-\\d{2}"))
        {
            return true;
        }
        return false;
    }    
    private boolean validate_Username(String username)
    {
        return false;
    }
    private boolean validate_Password(String pass)
    {
        return false;
    }
    private boolean validate_AllFieldsRegister(String correo, String username, String pass, String telefono, String nombre, String apellido) throws UnsupportedOperationException
    {
        if (this.validate_Tel(telefono)==false)
        {
            
        }if (this.validate_Email(correo)==false){
            
        }if (this.validate_Username(username)==false | this.validate_Password(pass)==false)
        {
            throw new UnsupportedOperationException();
        }
        
        return true;
        
    }
}



