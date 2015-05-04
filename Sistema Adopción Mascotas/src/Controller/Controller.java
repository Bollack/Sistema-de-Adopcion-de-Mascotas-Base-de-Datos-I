package Controller;

import Controller.Controller_User;
import GUI_View.Main_Visitante;
import GUI_View.Error_connection_db;
import GUI_View.Log_In;
import GUI_View.Registro_Usuario;
import Model.Model;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.InputMismatchException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import org.apache.commons.validator.*;
import java.lang.ClassNotFoundException;
import javax.swing.ImageIcon;
import javax.swing.ListSelectionModel;

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
            this.errorConn(ex);
        }catch (ClassNotFoundException a)
        {
            this.errorConn(a);
        }
    }
    
    public void Start()
    {
        Main_Visitante vista = new Main_Visitante();
        this.gui = vista;

        //this.gui.pack();
        
        
        vista.exitButton.addActionListener((ActionListener) this);
        vista.RegisterButton.addActionListener((ActionListener) this);
        vista.RegisterButton.setActionCommand("Registrarse");
        vista.LogInButton.addActionListener((ActionListener) this);
        vista.exitButton.setActionCommand("Salir");
        vista.LogInButton.setActionCommand("Log In");
        /*
            Se asigna el listener y el modelo a la tabla.
        */
        
        try
        {
            this.gui.show();
            this.gui.setResizable(false);
            vista.tablaMascotas.setModel(this.modelo.getModelFromResultSet("Mascota visitante")); 
            vista.tablaMascotas.setRowSelectionAllowed(true);
            ListSelectionModel rowSelectionModel = vista.tablaMascotas.getSelectionModel();
            rowSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

            rowSelectionModel.addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e){
                    String selectedData = null;
                    int fila = vista.tablaMascotas.getSelectedRow();
                    int id = (int) vista.tablaMascotas.getValueAt(fila, 0);
                    ImageIcon imagen;
                    try {
                        imagen = new Model().getImageFromTable(selectedData, id);
                    } catch (SQLException ex) {
                        errorConn(e);
                    } catch (ClassNotFoundException ex) {
                        errorConn(e);
                    } catch (InputValueNotAcceptableException ex) {
                        errorConn(e);
                    } catch (NullPointerException ex) {
                        errorConn(e);
                    } catch (IOException ex) {
                        errorConn(e);                    
                    }
                }
            
            
        });}catch(SQLException e)
        {
            this.errorConn(e);
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException ex) {
            this.errorConn(ex);
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
           try {
               this.validate_data_Log_in((Log_In)this.gui);
           } catch (ClassNotFoundException ex) {
               Log_In ventana = (Log_In) this.gui;
               ventana.datos_no_validos_OptionPane.createDialog(ventana, "Datos no válidos. Por favor, introduzca un nombre de usuario y contraseña válidos.");
           } catch (NullPointerException ex) {
                int warning =  JOptionPane.ERROR_MESSAGE;
                JOptionPane.showConfirmDialog (null, "Ha ocurrido un error NullPointerException extrayendo datos de la base de datos. Por favor, vuelva a intentar más tarde o contacte al desarollador para recibir soporte.","Error",warning);
           } catch (IOException ex) {
                 int warning =  JOptionPane.ERROR_MESSAGE;
                 JOptionPane.showConfirmDialog (null, "Ha ocurrido un error IOException extrayendo datos de la base de datos. Por favor, vuelva a intentar más tarde o contacte al desarollador para recibir soporte.","Error",warning);
           }
  
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
           try {
               this.Registrarse();
           } catch (UnsupportedOperationException ex) {
                 int warning =  JOptionPane.ERROR_MESSAGE;
                 JOptionPane.showConfirmDialog (null, "Ha ocurrido un error UnsupportedOperationException extrayendo datos de la base de datos. Por favor, vuelva a intentar más tarde o contacte al desarollador para recibir soporte.","Error",warning);
           } catch (IOException ex) {
                 int warning =  JOptionPane.ERROR_MESSAGE;
                 JOptionPane.showConfirmDialog (null, "Ha ocurrido un error IOException extrayendo datos de la base de datos. Por favor, vuelva a intentar más tarde o contacte al desarollador para recibir soporte.","Error",warning);;
           }
           //this.Start();
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

        int warning =  JOptionPane.YES_NO_OPTION;
        int answer = JOptionPane.showConfirmDialog (null, "¿Está seguro de que desea salir del programa?","Advertencia",warning);
        if (answer == JOptionPane.YES_OPTION)
        {
            System.exit(0);
        }
    
           
       }
    }
    

       
    /*
    Función cuya función es expuesta en el nombre. Recibe un ImageIcon y lo devuelve ajustado a las dimensiones
    insertadas por parámetro. Puede ser un poco lento con imágenes grandes.
    */
        
    private ImageIcon resizeImage(ImageIcon icon, int width, int height)
    {
        
        Image scaleImage = icon.getImage().getScaledInstance(width, height,Image.SCALE_DEFAULT);
        icon = new ImageIcon(scaleImage);
        return icon;
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
        ventanalogeo.getRootPane().setDefaultButton(ventanalogeo.LogInButton);
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
            this.gui.dispose();
            accesoUser.start();
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(this.gui, "Error accesando a su cuenta de usuario. Vuelva a intentar","Error de aplicación",
                                             JOptionPane.ERROR_MESSAGE);
            this.Start();
        }
    }
    
    
    /*
        Método que es activado una vez la validación de datos al loguearse como admin devuelve
    un valor positivo. Activa el controlador de modo administrador y pasa a ala ventana del mismo.
    */
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
    
    
    /*
    Función que es ejecutada cuando el usuario inserta los valores para registrarse y la cual se encarga de llamar otras funciones
    que extraen los datos, los validan y lanzan excepción si no son válidos. Dicha función se encarga de mostrar las ventanas de error
    en caso de que estos errores se den y se encarga de transmitirle los datos al modelo para su inserción en la db si los datos
    son válidos.
    */
    private void Registrarse() throws UnsupportedOperationException, IOException
    {
       try
       {
           String[] data_Sign_up = this.get_data_Sign_up((Registro_Usuario) this.gui);
           System.out.println("Validando datos insertados por el usuario...");
           this.validate_AllFieldsRegister(data_Sign_up);
           System.out.println("Todos los campos validados");
           //De aquí en adelante se toma que todos los valores ingresados por el usuario son válidos nombre, apellido, telefono, correo, direccion, username, password, genero
           this.modelo.insertUsuario_Persona(data_Sign_up[0],data_Sign_up[1],data_Sign_up[2],data_Sign_up[3],data_Sign_up[4],data_Sign_up[5],data_Sign_up[6],data_Sign_up[7]);
           /*
           Se le informa al usuario que la operación fue exitosa.
           */
           int a = JOptionPane.OK_OPTION;
           JOptionPane.showConfirmDialog(this.gui, "Usuario registrado con éxito", "Operación exitosa", a);
       }catch (UnsupportedOperationException e)
       {
           System.out.println("Excepcion UnsupportedOperationException en Registrarse()");
           int a = JOptionPane.ERROR_MESSAGE;
           JOptionPane.showMessageDialog(this.gui, "El nombre de usuario deseado no es válido o ya existe en la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
           
       }catch (NullPointerException e)
       {
           System.out.println(e.getMessage());
           System.out.println("Excepcion NullPointerException en Registrarse()");
           int a = JOptionPane.ERROR_MESSAGE;
           JOptionPane.showMessageDialog(this.gui, "Por favor, llene todos los valores mostrados como obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
       }catch (InputValueNotAcceptableException e)
       {
           int a = JOptionPane.ERROR_MESSAGE;
           JOptionPane.showMessageDialog(this.gui, "Por favor, inserte valores válidos.", "Error", JOptionPane.ERROR_MESSAGE);
           System.out.println("Excepcion InputValueNotAcceptableException en Registrarse()");
       }catch (SQLException e){
           this.errorConn(e);
           //int a = JOptionPane.ERROR_MESSAGE;
           //JOptionPane.showMessageDialog(this.gui, "El nombre de usuario deseado no es válido o ya existe en la bsee de datos", "Error", JOptionPane.ERROR_MESSAGE);
           System.out.println("Excepcion SQLException en Registrarse()");
           this.errorConn(e);
       }catch (ClassNotFoundException e){
           System.out.println("Excepcion ClassNotFoundException en Registrarse()");
           this.errorConn(e);
       }catch(FileNotFoundException e)
       {
           System.out.println("Excepcion FileNotFoundException en Registrarse()");
           this.errorConn(e);
       }
       
    }
    
    
    /*
    Devuelve como un arreglo de Strings los datos insertados por el usuario en la ventana de registro de usuario. 
    
    */
    private String[] get_data_Sign_up(Registro_Usuario ventana) throws NullPointerException
    {
        String correo = ventana.emailTextField.getText();
        String telefono = ventana.telefonoTextField.getText();
        String username = ventana.usernameTextField.getText();
        String password = ventana.passwordField.getText();
        String direccion = ventana.direccionTextField.getText();
        String nombre = ventana.nameTextField.getText();
        String apellido = ventana.apellidoUsuarioTextField.getText();
        if (ventana.femaleRadioButton.isSelected())
        {
            String genero = ventana.femaleRadioButton.getText();
            String[] dataUsuarioRegistro ={username, password, nombre, apellido, telefono, correo, direccion, genero};
            return dataUsuarioRegistro;
        }else if(ventana.maleRadioButton.isSelected())
        {
            String genero = ventana.maleRadioButton.getText();
            String[] dataUsuarioRegistro ={username, password, nombre, apellido, telefono, correo, direccion, genero};
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
    private void validate_data_Log_in(Log_In ventana) throws ClassNotFoundException, NullPointerException, IOException
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
                        ventana.wrongDataMessageBox.setResizable(false);

                        
                        ventana.tituloWrongDataMessageBox.setForeground(new java.awt.Color(204, 0, 0)); //Rojo

                        ventana.tituloWrongDataMessageBox.setText("Usuario no Existente");
                        ventana.label1MessageBox.setText("El usuario insertado no existe.");
                        ventana.label2MessageBox.setText("Por favor, inserte un nombre de usuario válido.");
                        ventana.wrongDataMessageBox.pack();
                        
                        ventana.wrongDataMessageBox.show();
                        ventana.wrongDataMessageBox.toFront();
                        
                        break;
                    }
                    if (!passValidez)
                    {
                        ventana.wrongDataMessageBox.setResizable(false);

                        
                        ventana.tituloWrongDataMessageBox.setForeground(new java.awt.Color(204, 0, 0)); //Rojo
                        ventana.tituloWrongDataMessageBox.setText("Datos ingesados erróneos");
                        ventana.label1MessageBox.setText("La contraseña ingresada no es correcta.");
                        ventana.label2MessageBox.setText("Por favor, ingrese una contraseña válida.");
                        ventana.wrongDataMessageBox.pack();
                        ventana.wrongDataMessageBox.show();                        
                        ventana.wrongDataMessageBox.toFront();
                        break;
                    }
                    if (usuarioValidez & passValidez)
                    {
                        System.out.println(pass);
                        ventana.correctDataMessageBox.setResizable(false);
                        ventana.correctDataMessageBox.pack();
                        ventana.correctDataMessageBox.toFront();
                        ventana.correctDataMessageBox.show();
                        /*
                        En esta sección del código genera un evento para cuando el usuario presione aceptar en el botón del
                        JDialog, el cual es escuchado por el listener y ejecuta el segmento de código especificado abajo. 
                        */
                            ventana.aceptarCorrectDataMessageBox.addActionListener(new ActionListener() {

                            public void actionPerformed(ActionEvent e)
                            {
                            //Se ejecuta la acción al ser presionado el botón de Aceptar
                            //Comienza el proceso lógico de Log_In
                            //ventana.correctDataMessageBox.show(false);
                            Log_In_User(ventana.userTextField.getText());
                            //ventana.dispose();
                            //ventana.show(false);
                            }
                            });  
                    }
                    break;
                case 1: //Validación como Admin
                    if (this.modelo.testAdmin(pass))
                    {
                        System.out.println(pass);
                        ventana.correctDataMessageBox.setResizable(false);
                        //Comienza el proceso lógico de Log_In
                        ventana.validate();
                        ventana.aceptarCorrectDataMessageBox.show(true);
                        
                        {
                            
                        }
                        
                        Log_In_Admin();
                    }else
                    {
                        System.out.println(pass);
                        ventana.wrongDataMessageBox.setResizable(false);

                
                        ventana.tituloWrongDataMessageBox.setText("Datos ingesados erróneos");
                        ventana.label1MessageBox.setText("La contraseña ingresada no es correcta.");
                        ventana.label2MessageBox.setText("Por favor, ingrese una contraseña válida.");        
                        ventana.tituloWrongDataMessageBox.setForeground(new java.awt.Color(204, 0, 0)); //Rojo
                        
                        ventana.wrongDataMessageBox.show();
                        ventana.wrongDataMessageBox.pack();
                        ventana.wrongDataMessageBox.toFront();

                    }
                    break;
            }

            
        }catch (InputMismatchException | SQLException e)
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
    private boolean validate_Username_to_Create(String username) throws SQLException, ClassNotFoundException, NullPointerException, IOException
    {
        if (username=="" || username==null)
        {
            return false;
        }
        try {
            if (this.modelo.checkUserExists(username))
            {
                return false;
            }else{
                return true;
            }
        } catch (SQLException ex) {
            throw ex;
        }
    }
    
    private boolean validate_Password(String pass)
    {
        if (pass=="" || pass==null)
        {
            return false;
        }
        return true;
    }
    
    private boolean validate_Password_to_Log_in( String username,String pass) throws SQLException, ClassNotFoundException, NullPointerException, IOException
    {
        if (!this.modelo.checkUserExists(username))
        {
            return false;
        }
        if (!this.modelo.checkPassword(username,pass))
        {
            return false;
        }
        return true;
    }
    private void validate_AllFieldsRegister(String[] datos) throws UnsupportedOperationException, InputValueNotAcceptableException, UnsupportedOperationException, SQLException, ClassNotFoundException, NullPointerException, IOException
    {
        if (datos[2]=="" || datos[2]==null) //Valida nombre     
        {
            throw new NullPointerException();
        }
        if (datos[4]=="" || datos[3]==null) //Valida apellido
        {
            throw new NullPointerException();
        }
        if (!this.validate_Tel(datos[4])) //Valida telefono
        {
            System.out.println(datos[4]);
            System.out.println("Excepcion InputValueNotAcceptable en validación de teléfono en validate_AllFieldsRegister");
            throw new InputValueNotAcceptableException(datos[4]);
        }
        if (!this.validate_Email(datos[5])) //Valida correo
        {
            System.out.println("Excepcion InputValueNotAcceptable en validación de correo en validate_AllFieldsRegister");
            throw new InputValueNotAcceptableException(datos[5]);
        }
        if (datos[6]=="" || datos[6]==null) //Valida dirección
        {
            throw new NullPointerException();
        }
        if (datos[0]=="" || datos[0]==null || !this.validate_Username_to_Create(datos[0])) //Valida username
        {
            throw new UnsupportedOperationException();
        }
        if (!this.validate_Password(datos[1])) //Valida password
        {
            throw new NullPointerException();
        }
        if (datos[7]=="" || datos[7]==null) //Valida genero
        {
            throw new NullPointerException();
        }        
    }
    
    
    /*
    Método que devuelve una ventana predeterminada mostrando un error de conexión a la DB y mostrando datos
    del error.
    */
    private void errorConn(Exception e)
    {
        if (e instanceof SQLException)
        {
            Error_connection_db error = new Error_connection_db((SQLException) e); 
            error.show();
            error.setSize(new Dimension(524,225));
            error.setPreferredSize(new Dimension(524,225));
            error.validate();
            //error.pack();
            error.setMinimumSize(new Dimension(524,225));
        }else{
            Error_connection_db error = new Error_connection_db(e);
            error.show();
            error.setSize(new Dimension(524,225));
            error.setPreferredSize(new Dimension(524,225));
            error.validate();
            error.setMinimumSize(new Dimension(524,225));
            //error.pack();
        }
    }
}


