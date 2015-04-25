
package Controller;

import GUI_View.Main_Visitante;
import GUI_View.Error_connection_db;
import GUI_View.Log_In;
import GUI_View.Registro_Usuario;
import Model.Model;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.util.InputMismatchException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;
import org.apache.commons.lang3.*;
import org.apache.commons.mail.*;
import org.apache.commons.validator.*;


/**
 *
 * @author Daniel Troyo
 * 3/04/2015  6:21 p.m
 */
public class Controller implements ActionListener
{
    
    private JFrame gui;
    private Model modelo;

    /**
     *
     * @param vista
     */
    public Controller() {
        try {
            this.modelo = new Model();
        } catch (Exception ex) {
            Error_connection_db errorVentana = new Error_connection_db();
            errorVentana.show();
            System.out.println(ex.getMessage());
        }
    }
    
    public void Start()
    {
        Main_Visitante vista = new Main_Visitante();
        this.gui = vista;
        this.gui.show();
        this.gui.setResizable(false);
        this.gui.pack();
        vista.exitButton.addActionListener((ActionListener) this);
        vista.RegisterButton.addActionListener((ActionListener) this);
        vista.RegisterButton.setActionCommand("Registrarse");
        vista.LogInButton.addActionListener((ActionListener) this);
        vista.exitButton.setActionCommand("Salir");
        vista.LogInButton.setActionCommand("Log In");
        try
        {
            vista.tablaMascotas = this.modelo.getModelFromResultSet("Mascota visitante");
            //vista.tablaMascotas.setModel((TableModel) this.modelo.getModelFromResultSet("Mascota visitante"));
            vista.jScrollPane2.removeAll();
            vista.jScrollPane2.add(vista.tablaMascotas);
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    private void backToMenu()
    {
        this.Start();
    }
    
    public void actionPerformed(ActionEvent e) {
       String comando = e.getActionCommand();

       if (comando=="Log In")
       {
           gui.show(false);
           gui.disable();
           this.log_In_Window();
       }else if(comando=="Log In-Ventana Logeo")
       {
           this.Log_In((Log_In) this.gui);
           
       }else if(comando=="Cambio de Vista-Ventana Logeo")
       {
           Log_In ventana = (Log_In) this.gui;
           if ((String)ventana.logAsComboBox.getSelectedItem()=="Administrador")
           {
               ventana.userTextField.setText("");
               ventana.userTextField.setEnabled(false);
               ventana.passwordTextField.setText("");
               ventana.asAdmin = 1;
           }
           if ((String)ventana.logAsComboBox.getSelectedItem()=="Usuario")
           {
               ventana.userTextField.setEnabled(true);
               ventana.passwordTextField.setText("");
               ventana.asAdmin = 0;
           }
           
       }else if(comando=="Atrás-Ventana Logeo")
       {
           this.gui.disable();
           this.gui.show(false);
           this.backToMenu();
       }else if(comando=="Registrarse")
       {
           gui.show(false);
           this.Registrase_Window();
       }else if(comando=="Registrarse-Ventana Registro")
       {
           
       }else if(comando=="Atrás-Ventana Registro")
       {
           this.gui.dispose();
           this.gui.show(false);
           this.backToMenu();
           
       }else if(comando=="")
       {
           
       }else if(comando=="")
       {
           
       }else if(comando=="Salir")
       {
           this.gui.show(false);
           System.exit(0);
           
       }
    }
    
    private void valueChanged(ListSelectionEvent event)
    {
        Main_Visitante ventana =(Main_Visitante) this.gui;
        int id =(int) ventana.tablaMascotas.getValueAt(ventana.tablaMascotas.getSelectedRow(),0);
        ventana.
    }
       
        
    
    
    
    private void log_In_Window()
    {
        //Crea el objeto de clase ventana de logeo
        Log_In ventanalogeo = new Log_In();
        this.gui = ventanalogeo;
        //Establece los listeners y nombra los 
        ventanalogeo.LogInButton.addActionListener((ActionListener) this);
        ventanalogeo.LogInButton.setActionCommand("Log In-Ventana Logeo");
        ventanalogeo.LogInButton.enable();
        
        ventanalogeo.exitButton.addActionListener((ActionListener) this);
        ventanalogeo.exitButton.setActionCommand("Atrás-Ventana Logeo");
        
        
        ventanalogeo.logAsComboBox.addItem("Usuario");
        ventanalogeo.logAsComboBox.addItem("Administrador");
        ventanalogeo.logAsComboBox.addActionListener ((ActionListener) this);
        ventanalogeo.logAsComboBox.setActionCommand("Cambio de Vista-Ventana Logeo");
        
        ventanalogeo.asAdmin = 0;
        ventanalogeo.show();  
        ventanalogeo.setResizable(false);
    }
    
    private void Registrase_Window()
    {
        Registro_Usuario sign_up = new Registro_Usuario();
        this.gui = sign_up;
        sign_up.backButton.addActionListener((ActionListener) this);
        sign_up.backButton.setActionCommand("Atrás-Ventana Registro");
        sign_up.registerButton.addActionListener((ActionListener) this);
        sign_up.registerButton.setActionCommand("Registrarse-Ventana Registro");
        this.gui.show();
        this.gui.enable();
        sign_up.setResizable(false);
        sign_up.show();
        sign_up.enable();
    }
    
    private void Log_In(Log_In ventana)
    {
        try
        {
            switch (ventana.asAdmin)
            {
                case 1:
                    if (ventana.passwordTextField.getText().equals(modelo))
                    break;
                case 0:
                    break;
            }
            
        }catch(Exception e)
        {
            
        }
    }
    
    private void Registrarse()
    {
       String[] datos = this.get_data_Sign_up((Registro_Usuario) this.gui);
       try
       {
           
       }catch (Exception e)
       {
           
       }
       
    }
    
    private String[] get_data_Sign_up(Registro_Usuario ventana) throws NullPointerException
    {
        String correo = ventana.direccionTextField.getText();
        String telefono = ventana.telefonoTextField.getText();
        String username = ventana.usernameTextField.getText();
        String password = ventana.passwordField.getText();
        String direccion = ventana.direccionTextField.getText();
        String nombre = ventana.nameTextField.getText();
        String apellido = ventana.apellidoUsuarioTextField.getText();
        if (ventana.femaleRadioButton.isSelected())
        {
            String genero = ventana.femaleRadioButton.getText();
            String[] dataUsuarioRegistro ={nombre, apellido, telefono, correo, direccion, username, password, genero};
            return dataUsuarioRegistro;
        }else if(ventana.maleRadioButton.isSelected())
        {
            String genero = ventana.maleRadioButton.getText();
            String[] dataUsuarioRegistro ={nombre, apellido, telefono, correo, direccion, username, password, genero};
            return dataUsuarioRegistro;
        }else{
            throw new NullPointerException();
        }


        
    }
    /*
    Función que extrae los parámetros insertados en la ventana de Log In
    y valida que estén correctos, permitiéndole al usuario ingresar a su cuenta y abre
    las ventanas correspondientes así como todo el proceso lógico necesario. 
    */
    private String[] validate_data_Log_in(Log_In ventana)
    {
        String username =ventana.userTextField.getText();
        String pass = ventana.passwordTextField.getText();
        try
        {
            boolean usuarioValidez = this.validate_Username(username);
            boolean passValidez = this.validate_Password_to_Log_in(username, pass);
            if (!usuarioValidez){
                
            }
            
        }catch (Exception e)
        {
            
        }
        
    }   
    private boolean validate_Email(String email)
    {
        if (email=="" || email==null)
        {
            return false;
        }
        EmailValidator validator=EmailValidator.getInstance(); //Verificación de mail mediante la utilización de la librería Validate de Apache Commons
        if(validator.isValid(email)==false)
        {
            return false;
        }
        return true;

    }
    private boolean validate_Tel(String telefono)
    {
        if (telefono=="" || telefono==null)
        {
            return false;
        }
        if (telefono.matches("\\d{4}-\\d{2}-\\d{2}"))
        {
            return true;
        }
        return false;
    }    
    private boolean validate_Username(String username) throws InputMismatchException
    {

    }
    private boolean validate_Username_to_Create(String username)
    {
        if (username=="" || username==null)
        {
            return false;
        }
        if (this.modelo.checkUserExists(username))
        {
            throw new InputMismatchException();
        }
        return true;
    }
    
    private boolean validate_Password(String pass)
    {
        if (pass=="" || pass==null)
        {
            return false;
        }
        return true;
    }
    
    private boolean validate_Password_to_Log_in(String pass, String username)
    {
        if (!this.modelo.checkUserExists(username))
        {
            return false;
        }
        if (!this.modelo.checkPassword(pass, username))
        {
            return false;
        }
        return true;
    }
    private boolean validate_AllFieldsRegister(String[] datos) throws UnsupportedOperationException
    {
        if (datos[0]=="" || datos[0]==null) //Valida nombre
        {
            return false;
        }
        if (datos[1]=="" || datos[1]==null) //Valida apellido
        {
            return false;
        }
        if (!this.validate_Tel(datos[2])) //Valida telefono
        {
            return false;
        }
        if (!this.validate_Email(datos[3])) //Valida correo
        {
            return false;
        }
        if (datos[3]=="" || datos[3]==null) //Valida dirección
        {
            return false;
        }
        try
        {
            
        }
        if (datos[0]=="" || datos[0]==null) //Valida username
        {
            
        }
        if (datos[0]=="" || datos[0]==null) //Valida password
        {
            
        }
        if (datos[0]=="" || datos[0]==null) //Valida genero
        {
            
        }
        return true;
        
    }
    
    
}
