
package Controller;

import Controller.Controller_User;
import GUI_View.Main_Visitante;
import GUI_View.Error_connection_db;
import GUI_View.Log_In;
import GUI_View.Registro_Usuario;
import Model.Model;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.sql.SQLException;
import java.util.InputMismatchException;
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
import java.lang.ClassNotFoundException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;

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
        } catch (SQLException ex) {
            Error_connection_db errorVentana = new Error_connection_db(ex);
            errorVentana.show();
            System.out.println(ex.getMessage());
        }catch (ClassNotFoundException a)
        {
        
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
        /*

        
        GridBagConstraints constraint = new GridBagConstraints();
        constraint.fill = GridBagConstraints.HORIZONTAL;
        constraint.gridwidth=1;
	constraint.gridx=0;
        constraint.gridy=0;
	constraint.weightx=0.5;
            */    
        vista.Foto.setLayout(new GridBagLayout());
        
        //vista.Foto.setMaximumSize(new Dimension(225,156));
        ImageIcon icon = new ImageIcon(this.getClass().getResource("/GUI_View/Images/logo.jpg"));
        Image img = icon.getImage();
        BufferedImage bi = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        Graphics g = bi.createGraphics();
        g.drawImage(img, 0, 0, 197, 143, null, null); //218,156
        icon = new ImageIcon(bi);
        //vista.Foto.resize(218, 156);
        vista.Foto.setText("");
        vista.Foto.setIcon(icon);
        //vista.Foto.resize(218, 156);

        
        try
        {
            vista.tablaMascotas.setModel(this.modelo.getModelFromResultSet("Mascota visitante")); 
            System.out.println(vista.tablaMascotas.getColumnName(0));
            //vista.tablaMascotas.setModel((TableModel) this.modelo.getModelFromResultSet("Mascota visitante"));
            //vista.jScrollPane2.removeAll();
            //vista.jScrollPane2.add(vista.tablaMascotas);
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
           this.validate_data_Log_in((Log_In) this.gui);
           
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
           String[] datos = this.get_data_Sign_up((Registro_Usuario) this.gui);
           
           
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
        ImageIcon imagen= this.modelo.getImageFromTable(null)
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
    
    private void Log_In_User(String username)
    {
        try
        {
            Controller_User accesoUser = new Controller_User(this.modelo, username);
            this.gui.show(false);
        }catch(Exception e)
        {
            this.errorConn(e);
        }
    }
    
    private void Log_In_Admin()
    {
        try
        {
            Controller_Admin accesoAdmin = new Controller_Admin(this.modelo);
            this.gui.show(false);
        }catch (Exception e)
        {
            this.errorConn(e);
        }
    }
    
    private void Registrarse(String[] datos)
    {
       
       try
       {
           this.modelo.
           
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
    private void validate_data_Log_in(Log_In ventana)
    {
        
        
        String username =ventana.userTextField.getText();
        String pass = ventana.passwordTextField.getText();
        System.out.println(ventana.passwordTextField.getText());
        System.out.println(ventana.asAdmin);
        try
        {
            switch (ventana.asAdmin)
            {
                case 0: //Validación como Usuario
                    boolean usuarioValidez = this.validate_Username(username);
                    boolean passValidez = this.validate_Password_to_Log_in(username, pass);
                    
                    if (!usuarioValidez){
                        ventana.wrongDataMessageBox.show();
                        ventana.wrongDataMessageBox.setResizable(false);

                        
                        ventana.tituloWrongDataMessageBox.setForeground(new java.awt.Color(204, 0, 0)); //Rojo

                        ventana.tituloWrongDataMessageBox.setText("Usuario no Existente");
                        ventana.label1MessageBox.setText("El usuario insertado no existe.");
                        ventana.label2MessageBox.setText("Por favor, inserte un nombre de usuario válido.");
                        ventana.wrongDataMessageBox.pack();
                        ventana.wrongDataMessageBox.toFront();
                        break;
                    }
                    if (!passValidez)
                    {
                        ventana.wrongDataMessageBox.show();
                        ventana.wrongDataMessageBox.setResizable(false);

                        
                        ventana.tituloWrongDataMessageBox.setForeground(new java.awt.Color(204, 0, 0)); //Rojo
                        ventana.tituloWrongDataMessageBox.setText("Datos ingesados erróneos");
                        ventana.label1MessageBox.setText("La contraseña ingresada no es correcta.");
                        ventana.label2MessageBox.setText("Por favor, ingrese una contraseña válida.");
                        ventana.wrongDataMessageBox.pack();
                        ventana.wrongDataMessageBox.toFront();
                        break;
                    }
                    if (usuarioValidez & passValidez)
                    {
                        System.out.println(pass);
                        ventana.correctDataMessageBox.show();
                        ventana.correctDataMessageBox.setResizable(false);
                        //ventana.pack();
                        ventana.toFront();
                        
                        //Comienza el proceso lógico de Log_In
                        
                        Log_In_User(ventana.userTextField.getText());
                      
                        
                    }
                    break;
                case 1: //Validación como Admin
                    if (this.modelo.testAdmin(pass))
                    {
                        System.out.println(pass);
                        ventana.correctDataMessageBox.show();
                        ventana.correctDataMessageBox.setResizable(false);
                        //Comienza el proceso lógico de Log_In
                        
                        Log_In_Admin();
                    }else
                    {
                        System.out.println(pass);
                        ventana.wrongDataMessageBox.show();
                        ventana.wrongDataMessageBox.setResizable(false);

                
                        ventana.tituloWrongDataMessageBox.setText("Datos ingesados erróneos");
                        ventana.label1MessageBox.setText("La contraseña ingresada no es correcta.");
                        ventana.label2MessageBox.setText("Por favor, ingrese una contraseña válida.");        
                        ventana.tituloWrongDataMessageBox.setForeground(new java.awt.Color(204, 0, 0)); //Rojo
                        ventana.wrongDataMessageBox.pack();
                        ventana.wrongDataMessageBox.toFront();

                    }
                    break;
            }

            
        }catch (Exception e)
        {
            this.errorConn(e);
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
    
    /*
    Función que verifica la validez de un username al ser ingresado
    como username en la ventana de Log_In. 
    */
    private boolean validate_Username(String username) throws InputMismatchException
    {
        boolean validez = false;
        try
        {
            validez = this.modelo.checkUserExists(username);
            
        }catch(Exception e)
        {
            this.errorConn(e);
        }
        return validez;
    }
    private boolean validate_Username_to_Create(String username) throws SQLException
    {
        if (username=="" || username==null)
        {
            return false;
        }
        try {
            if (this.modelo.checkUserExists(username))
            {
                return false;
            }
        } catch (SQLException ex) {
            throw ex;
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
    
    private boolean validate_Password_to_Log_in(String pass, String username) throws SQLException
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
    private void validate_AllFieldsRegister(String[] datos) throws UnsupportedOperationException, Exception
    {
        if (datos[0]=="" || datos[0]==null) //Valida nombre
        {
            throw new NullPointerException();
        }
        if (datos[1]=="" || datos[1]==null) //Valida apellido
        {
            throw new NullPointerException();
        }
        if (!this.validate_Tel(datos[2])) //Valida telefono
        {
            throw new InputValueNotAcceptableException(datos[2]);
        }
        if (!this.validate_Email(datos[3])) //Valida correo
        {
            throw new InputValueNotAcceptableException(datos[3]);
        }
        if (datos[3]=="" || datos[3]==null) //Valida dirección
        {
            throw new NullPointerException();
        }
        if (datos[4]=="" || datos[4]==null || !this.validate_Username_to_Create(datos[4])) //Valida username
        {
            throw new UnsupportedOperationException();
        }
        if (this.validate_Password(datos[5])) //Valida password
        {
            throw new NullPointerException();
        }
        if (datos[6]=="" || datos[6]==null) //Valida genero
        {
            throw new NullPointerException();
        }        
    }
    
    private void errorConn(Exception e)
    {
        Error_connection_db error = new Error_connection_db((SQLException) e);
        error.show();
        error.setResizable(false);
    }
    
    
}
