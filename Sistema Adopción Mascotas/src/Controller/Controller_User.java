/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import GUI_View.BuscarPersonas;
import GUI_View.Error_connection_db;
import GUI_View.Main_User;
import GUI_View.ModificarCuenta;
import GUI_View.ModifyMascota;
import GUI_View.Registro_Rescate_Mascota;
import Model.Model;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
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
        
    }
    
    public void start()
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
    
    
    private void log_Out()
    {
        int warning =  JOptionPane.YES_NO_OPTION;
        int answer = JOptionPane.showConfirmDialog (null, "¿Está seguro de que desea salir del programa y volver al menú de visitante?","Advertencia",warning);
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
           this.start();
    }
    
    
    private void accountSettings_Window() 
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
            
            ventana.generoButtonGroup.add(ventana.femaleRadioButton);
            ventana.generoButtonGroup.add(ventana.maleRadioButton);
            /*
            Se extraen todos los datos del usuario de la base de datos y se insertan
            en los textfields que el usuario modificará, así este puede ver la data que modifica y
            presionar "Guardar Cambios" para guardar las ediciones hechas en dichos textfield
            */
            String[] datos = this.modelo.getDatosFromUsername(this.username); //
            
            ventana.passwordTextField.setText(datos[1]);
            ventana.nameTextField.setText(datos[2]);
            ventana.apellidoUsuarioTextField.setText(datos[3]);
            ventana.telefonoTextField.setText(datos[4]);
            ventana.correoTextField.setText(datos[5]);
            ventana.direccionTextField.setText(datos[6]);
            if (datos[7]=="Masculino")
            {
                ventana.maleRadioButton.setSelected(true);
            }else if (datos[7]=="Femenino")
            {
                ventana.femaleRadioButton.setSelected(true);
            }else{
                
            }
            
            
            this.gui.show();
            this.gui.pack();
        } catch (SQLException ex) {

            int a = JOptionPane.ERROR_MESSAGE;
            JOptionPane.showMessageDialog(this.gui, "Error de conexión SQL. Por favor, trate otra vez o contacte al desarollador para recibir asistencia.", "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("Excepcion SQL en accountSettings_Window()");
            System.out.println(ex.getMessage());
            this.backtoAccountScreen();
        } catch (NullPointerException ex) {
            int a = JOptionPane.ERROR_MESSAGE;
            JOptionPane.showMessageDialog(this.gui, "Error de conexión NullPointer. Por favor, trate otra vez o contacte al desarollador para recibir asistencia.", "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("Excepcion NullPointerException en accountSettings_Window()");
            this.backtoAccountScreen();
        } catch (ClassNotFoundException ex) {
                        int a = JOptionPane.ERROR_MESSAGE;
            JOptionPane.showMessageDialog(this.gui, "Error de conexión ClassNotFound. Por favor, trate otra vez o contacte al desarollador para recibir asistencia.", "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("Excepcion ClassNotFound en accountSettings_Window()");
            this.backtoAccountScreen();
        } catch (IOException ex) {
            int a = JOptionPane.ERROR_MESSAGE;
            JOptionPane.showMessageDialog(this.gui, "Error de conexión IOException. Por favor, trate otra vez o contacte al desarollador para recibir asistencia.", "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("Excepcion ClassNotFound en accountSettings_Window()");
            this.backtoAccountScreen();
        }
    }
    
    private void verMisMascotasAdoptadas_Window()
    {
        
    }
    
    private void buscarPersonas_Window()
    {
        this.gui.show(false);
        this.gui.dispose();
        BuscarPersonas ventana = new BuscarPersonas();
        this.gui = ventana;
        /*
        Se añaden los radio buttons a un buttonGroup para que sólo uno pueda ser seleccionado.
        */
        ventana.buttonGroup1.add(ventana.adoptantesRadioButton);
        ventana.buttonGroup1.add(ventana.adoptantesRadioButton);
        ventana.buttonGroup1.add(ventana.adoptantesRadioButton);
        ventana.buttonGroup1.add(ventana.adoptantesRadioButton);
    }
    
    private void buscarMascotas_Window()
    {
        
    }
    
    private void MascotasAdopcion_Window()
    {
        
    }
    
    private void VerMisRescates_Window()
    {
        
    }
    
    private void registrar_Mascota_Window() throws SQLException, ClassNotFoundException
    {
        this.gui.dispose();
        this.gui.show(false);
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
        
        ventana_rescate.sexoMascotaButtonGroup.add(ventana_rescate.hembraMascotaRadioButton); //Se añaden los radiobuttons a un ButtonGroup, impidiendoq que ambos sean seleccionados a la vez.
        ventana_rescate.sexoMascotaButtonGroup.add(ventana_rescate.machoMascotaRadioButton);
        
        /*
        En el siguiente bloque de se asigna los tipos de mascota como items al combo box
        de tipo mascota.
        */
        String[] grupos = this.modelo.getTiposMascota();
        ventana_rescate.tipoMascotaComboBox.removeAllItems();
        for (int i=0; i<grupos.length;i++)
        {
            ventana_rescate.tipoMascotaComboBox.addItem(grupos[i]);
        }
        
        /*
        En el siguiente bloque de código se añade un listener al combobox anterior que se activa
        al ocurrir el evento de cambiar de item seleccionado, esto llama a la lista de razas del 
        grupo de animales seleccionado y a la añade al combobox de raza.
        */
        
        ventana_rescate.razaMascotaComboBox.removeAllItems();
        
        ventana_rescate.tipoMascotaComboBox.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) 
                {
                    try 
                    {
                        String grupo = (String) ventana_rescate.tipoMascotaComboBox.getSelectedItem();
                        Model a = new Model();
                        ventana_rescate.razaMascotaComboBox.removeAllItems();
                        String[] razas = a.getRazasFromTipoMascota((String) ventana_rescate.tipoMascotaComboBox.getSelectedItem());
                        for (int i=0; i<razas.length;i++)
                        {
                            ventana_rescate.razaMascotaComboBox.addItem(razas[i]);
                        }
                    } catch (SQLException ex) 
                    {
                    } catch (ClassNotFoundException ex) 
                    {
                    }
                }
            
        });
     
        
        
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
        ventana_rescate.color1MascotaComboBox.addItem("Negro");
        ventana_rescate.color1MascotaComboBox.addItem("Blanco");
        ventana_rescate.color1MascotaComboBox.addItem("Café");
        ventana_rescate.color1MascotaComboBox.addItem("Gris");
        ventana_rescate.color1MascotaComboBox.addItem("Beige");
        ventana_rescate.color1MascotaComboBox.addItem("Morado");
        ventana_rescate.color1MascotaComboBox.addItem("Rojo");
        ventana_rescate.color1MascotaComboBox.addItem("Verde");
        ventana_rescate.color1MascotaComboBox.addItem("Azul");
        ventana_rescate.color1MascotaComboBox.addItem("Amarillo");
        ventana_rescate.color1MascotaComboBox.addItem("Naranja");
        ventana_rescate.color1MascotaComboBox.addItem("Dorado");
        ventana_rescate.color1MascotaComboBox.addItem("Púrpura");
        ventana_rescate.color1MascotaComboBox.addItem("Rosado");
        ventana_rescate.color1MascotaComboBox.addItem("Lila");
        ventana_rescate.color1MascotaComboBox.addItem("Celeste");
        ventana_rescate.color1MascotaComboBox.addItem("Crema");
        ventana_rescate.color1MascotaComboBox.addItem("Vino");
        ventana_rescate.color1MascotaComboBox.addItem("Otro");
        
        
        ventana_rescate.color2MascotaComboBox.removeAllItems();
        ventana_rescate.color2MascotaComboBox.addItem("Negro");
        ventana_rescate.color2MascotaComboBox.addItem("Blanco");
        ventana_rescate.color2MascotaComboBox.addItem("Café");
        ventana_rescate.color2MascotaComboBox.addItem("Gris");
        ventana_rescate.color2MascotaComboBox.addItem("Beige");
        ventana_rescate.color2MascotaComboBox.addItem("Morado");
        ventana_rescate.color2MascotaComboBox.addItem("Rojo");
        ventana_rescate.color2MascotaComboBox.addItem("Verde");
        ventana_rescate.color2MascotaComboBox.addItem("Azul");
        ventana_rescate.color2MascotaComboBox.addItem("Amarillo");
        ventana_rescate.color2MascotaComboBox.addItem("Naranja");
        ventana_rescate.color2MascotaComboBox.addItem("Dorado");
        ventana_rescate.color2MascotaComboBox.addItem("Púrpura");
        ventana_rescate.color2MascotaComboBox.addItem("Rosado");
        ventana_rescate.color2MascotaComboBox.addItem("Lila");
        ventana_rescate.color2MascotaComboBox.addItem("Celeste");
        ventana_rescate.color2MascotaComboBox.addItem("Crema");
        ventana_rescate.color2MascotaComboBox.addItem("Vino");
        ventana_rescate.color2MascotaComboBox.addItem("Otro");
       
        ventana_rescate.severidadMascotaComboBox.removeAllItems();
        ventana_rescate.severidadMascotaComboBox.addItem("Crítico");
        ventana_rescate.severidadMascotaComboBox.addItem("Mal estado");
        ventana_rescate.severidadMascotaComboBox.addItem("Buen estado");
        
        ventana_rescate.show(true);
        ventana_rescate.pack();
        ventana_rescate.setResizable(false);
        this.gui = ventana_rescate;
    }  
    
    private void modificar_Mascota_Window(int id) throws SQLException, ClassNotFoundException, IOException
    {
        this.gui.dispose();
        this.gui.show(false);
        //Se istancia el objeto de la clase ventana
        ModifyMascota ventana = new ModifyMascota();
        
        this.gui = ventana;
        //Se inicializan los listener de los elementos de las ventanas
        /*
        Se establece el listener del botón atrás, el cual lleva al método que devuelve al usuario al menú
        principal de usuario
        */
        ventana.atrasMascotaButton.addActionListener((ActionListener) this);
        ventana.atrasMascotaButton.setActionCommand("Atras - Modificar Mascota");
        
        ventana.color1MascotaComboBox.addActionListener((ActionListener) this);
        ventana.color2MascotaComboBox.addActionListener((ActionListener) this);
        ventana.energiaMascotaComboBox.addActionListener((ActionListener) this);
        ventana.entrenamientoMascotaComboBox.addActionListener((ActionListener) this);
        ventana.espacioMascotaComboBox.addActionListener((ActionListener) this);
        ventana.espacioMascotaComboBox.addActionListener((ActionListener) this);
        /*
        Aquí se establece el listener para cuando el usuario presiona el botón de 
        Examinar y establecer así el atributo FOTO_ANTES de mascota. 
        */
        ventana.findImageButton.addActionListener((ActionListener) this);
        ventana.findImageButton.setActionCommand("FileChooser-FotoAntesMascota - Modificar Mascota");
        
        ventana.findImageButton1.addActionListener((ActionListener) this);
        ventana.findImageButton1.setActionCommand("FileChooser-FotoDespuesMascota - Modificar Mascota");
        
        ventana.modificarMascotaButton.addActionListener((ActionListener)this);
        ventana.modificarMascotaButton.setActionCommand("Modificar Mascota - Modificar Mascota");
                
        ventana.imageDirMascotaField.addActionListener((ActionListener) this);
        
        
        ventana.nameMascotaField.addActionListener((ActionListener) this);
        
        
        ventana.razaMascotaComboBox.addActionListener((ActionListener) this);
        ventana.modificarMascotaButton.addActionListener((ActionListener) this);
        
        
        ventana.tamanoMascotaComboBox.addActionListener((ActionListener) this);
        ventana.tipoMascotaComboBox.addActionListener((ActionListener) this);
        
        
        ventana.veterinarioMascotaField.addActionListener((ActionListener) this);
        
        //Se comienza a alterar los componentes con restricciones en reemplazo de tablas catálogo
        
        ventana.sexoMascotaButtonGroup.add(ventana.hembraMascotaRadioButton); //Se añaden los radiobuttons a un ButtonGroup, impidiendoq que ambos sean seleccionados a la vez.
        ventana.sexoMascotaButtonGroup.add(ventana.machoMascotaRadioButton);
        
        /*
        En el siguiente bloque de se asigna los tipos de mascota como items al combo box
        de tipo mascota.
        */
        String[] grupos = this.modelo.getTiposMascota();
        ventana.tipoMascotaComboBox.removeAllItems();
        for (int i=0; i<grupos.length;i++)
        {
            ventana.tipoMascotaComboBox.addItem(grupos[i]);
        }
        
        /*
        En el siguiente bloque de código se añade un listener al combobox anterior que se activa
        al ocurrir el evento de cambiar de item seleccionado, esto llama a la lista de razas del 
        grupo de animales seleccionado y a la añade al combobox de raza.
        */
        
        ventana.razaMascotaComboBox.removeAllItems();
        
        ventana.tipoMascotaComboBox.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) 
                {
                    try 
                    {
                        String grupo = (String) ventana.tipoMascotaComboBox.getSelectedItem();
                        Model a = new Model();
                        ventana.razaMascotaComboBox.removeAllItems();
                        String[] razas = a.getRazasFromTipoMascota((String) ventana.tipoMascotaComboBox.getSelectedItem());
                        for (int i=0; i<razas.length;i++)
                        {
                            ventana.razaMascotaComboBox.addItem(razas[i]);
                        }
                    } catch (SQLException ex) 
                    {
                    } catch (ClassNotFoundException ex) 
                    {
                    }
                }
            
        });
        
        
        
        
        ventana.energiaMascotaComboBox.removeAllItems();
        ventana.energiaMascotaComboBox.addItem("Atlético");
        ventana.energiaMascotaComboBox.addItem("Activo");
        ventana.energiaMascotaComboBox.addItem("Regular");
        ventana.energiaMascotaComboBox.addItem("Pasivo");
        ventana.energiaMascotaComboBox.addItem("Perezoso");
        
        ventana.espacioMascotaComboBox.removeAllItems();
        ventana.espacioMascotaComboBox.addItem("Amplio");
        ventana.espacioMascotaComboBox.addItem("Mediano");
        ventana.espacioMascotaComboBox.addItem("Mínimo");
        
        
        
        ventana.entrenamientoMascotaComboBox.removeAllItems();
        ventana.entrenamientoMascotaComboBox.addItem("Obediente");
        ventana.entrenamientoMascotaComboBox.addItem("Tranquilo");
        ventana.entrenamientoMascotaComboBox.addItem("Disperso");
        ventana.entrenamientoMascotaComboBox.addItem("Hiperactivo");
        
        ventana.tamanoMascotaComboBox.removeAllItems();
        ventana.tamanoMascotaComboBox.addItem("Grande");
        ventana.tamanoMascotaComboBox.addItem("Mediano");
        ventana.tamanoMascotaComboBox.addItem("Pequeño");
        
        ventana.color1MascotaComboBox.removeAllItems();
        ventana.color1MascotaComboBox.addItem("Negro");
        ventana.color1MascotaComboBox.addItem("Blanco");
        ventana.color1MascotaComboBox.addItem("Café");
        ventana.color1MascotaComboBox.addItem("Gris");
        ventana.color1MascotaComboBox.addItem("Beige");
        ventana.color1MascotaComboBox.addItem("Morado");
        ventana.color1MascotaComboBox.addItem("Rojo");
        ventana.color1MascotaComboBox.addItem("Verde");
        ventana.color1MascotaComboBox.addItem("Azul");
        ventana.color1MascotaComboBox.addItem("Amarillo");
        ventana.color1MascotaComboBox.addItem("Naranja");
        ventana.color1MascotaComboBox.addItem("Dorado");
        ventana.color1MascotaComboBox.addItem("Púrpura");
        ventana.color1MascotaComboBox.addItem("Rosado");
        ventana.color1MascotaComboBox.addItem("Lila");
        ventana.color1MascotaComboBox.addItem("Celeste");
        ventana.color1MascotaComboBox.addItem("Crema");
        ventana.color1MascotaComboBox.addItem("Vino");
        ventana.color1MascotaComboBox.addItem("Otro");
        
        
        ventana.color2MascotaComboBox.removeAllItems();
        ventana.color2MascotaComboBox.addItem("Negro");
        ventana.color2MascotaComboBox.addItem("Blanco");
        ventana.color2MascotaComboBox.addItem("Café");
        ventana.color2MascotaComboBox.addItem("Gris");
        ventana.color2MascotaComboBox.addItem("Beige");
        ventana.color2MascotaComboBox.addItem("Morado");
        ventana.color2MascotaComboBox.addItem("Rojo");
        ventana.color2MascotaComboBox.addItem("Verde");
        ventana.color2MascotaComboBox.addItem("Azul");
        ventana.color2MascotaComboBox.addItem("Amarillo");
        ventana.color2MascotaComboBox.addItem("Naranja");
        ventana.color2MascotaComboBox.addItem("Dorado");
        ventana.color2MascotaComboBox.addItem("Púrpura");
        ventana.color2MascotaComboBox.addItem("Rosado");
        ventana.color2MascotaComboBox.addItem("Lila");
        ventana.color2MascotaComboBox.addItem("Celeste");
        ventana.color2MascotaComboBox.addItem("Crema");
        ventana.color2MascotaComboBox.addItem("Vino");
        ventana.color2MascotaComboBox.addItem("Otro");
       
        ventana.severidadMascotaComboBox.removeAllItems();
        ventana.severidadMascotaComboBox.addItem("Crítico");
        ventana.severidadMascotaComboBox.addItem("Mal estado");
        ventana.severidadMascotaComboBox.addItem("Buen estado");
        try
        {
            this.actualizarValoresMascota_VentanaModificacion(ventana, id);
            ventana.show(true);
            ventana.pack();
            ventana.setResizable(false); 
        }catch(SQLException e)
        {
            this.errorConn(e);
            this.backtoAccountScreen();
        }

    }
    
    private void actualizarValoresMascota_VentanaModificacion(ModifyMascota ventana, int id) throws SQLException, IOException, ClassNotFoundException
    {
        Object[] datosMascota = this.modelo.getDatosFromMascota(id);
    }
    
    public void actionPerformed(ActionEvent e) {
       String comando = e.getActionCommand();

       if (comando=="Cerrar Sesión - Main Menu")
       {
           this.log_Out();

       }else if(comando=="Ver Cuenta - Main Menu")
       {
           this.accountSettings_Window();
           
       }else if(comando=="Guardar Cambios - Cuenta Window")
       {
            cambiarDatosCuenta((ModificarCuenta)this.gui);
  
       }else if(comando=="Atrás - Cuenta Window")
       {
           this.backtoAccountScreen();
           
       }else if(comando=="Buscar Mascotas - Main Menu")
       {
           this.buscarMascotas_Window();
       }else if(comando=="Buscar Personas - Main Menu")
       {
           this.buscarPersonas_Window();
           
       }else if(comando=="Formulario - Main Menu")
       {
           //TO DO
         
       }else if(comando=="Registrar Mascota - Main Menu")
       {
           try {
               this.registrar_Mascota_Window();
           } catch (SQLException ex) {
               this.errorConn(ex);
           } catch (ClassNotFoundException ex) {
               this.errorConn(ex);
           }
           
       }else if(comando=="Ver Mascotas Adopción - Main Menu")
       {
           this.MascotasAdopcion_Window();
       }else if(comando=="Ver Mis Adopciones - Main Menu")
       {
           this.verMisMascotasAdoptadas_Window();
       }else if(comando=="Ver Mis Rescates - Main Menu")
       {
           this.VerMisRescates_Window();
       }
       /*
        Se comienzan a crear las acciones para los botones y eventos
        que provienen de la ventana de registro/rescate de mascota 
       */
       else if(comando=="FileChooser-FotoAntesMascota - Registrar Mascota")
       {        
           /*
           Se establece un filtro para que el FileChooser sólo muestre archivos con formatos
           de imágenes manejables por JAVA. Para esto se utiliza la clase FileFilter, así como
           la librería ImageIO y la clase FileNameExtensionFilter, los cuales permiten la 
           obtención de dichos formatos y su aplicación en el filtro. 
           
           TO TEST
           */
           Registro_Rescate_Mascota ventana = (Registro_Rescate_Mascota) this.gui;
            JFileChooser fileOpen = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter ("Image Files", "jpg","png", "jpeg");
            fileOpen.setFileFilter(filter);
            fileOpen.setFileSelectionMode(JFileChooser.FILES_ONLY);
            fileOpen.setAcceptAllFileFilterUsed(false);
            fileOpen.setFont(new Font("Rockwell",Font.BOLD, 12));
            int ret = fileOpen.showDialog(null, "Open file");
            if (ret == JFileChooser.APPROVE_OPTION) {
                File direccion = fileOpen.getSelectedFile();
                System.out.println("Dirección de imagen: "+direccion.getAbsolutePath());
                ventana.imageDirMascotaField.setText(direccion.getAbsolutePath());
                   ImageIcon icon = new ImageIcon(direccion.getAbsolutePath());
                   //ImageIcon imagen = this.displayImageInLabel(icon, 260, 178,ventana.foto.getX()+30,ventana.foto.getY());
                   Image scaleImage = icon.getImage().getScaledInstance(260, 178,Image.SCALE_DEFAULT);
                   icon =new ImageIcon(scaleImage);
                   ventana.foto.setText("");
                   ventana.foto.setIcon(icon);
                   ventana.foto.resize(260, 178);
            }
       }else if(comando=="Registrar Mascota - Registrar Mascota")
       {
           this.registrar_Mascota();
       }else if(comando=="Atras - Registrar Mascota")
       {
           this.backtoAccountScreen();
           
       }else if(comando=="Guardar Cambios - Account Settings")
       {
           this.cambiarDatosCuenta((ModificarCuenta) this.gui);
           
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
        /*
        Utilizada en la ventana de ModificarCuenta y se encarga de guardar y actualizar en la 
        base de datos todos los cambios que el usuario aplicó en sus datos personales y de cuenta.
        */
        String[] data = new String[8];
        
        
        String correo = ventana.correoTextField.getText();
        String telefono = ventana.telefonoTextField.getText();
        String password = ventana.passwordTextField.getText();
        String direccion = ventana.direccionTextField.getText();
        String nombre = ventana.nameTextField.getText();
        String apellido = ventana.apellidoUsuarioTextField.getText();
        if (ventana.femaleRadioButton.isSelected())
        {
            String genero = ventana.femaleRadioButton.getText();
            data[0]=this.username; //Usuario a modificar
            data[1]=password;
            data[2]=nombre;
            data[3]=apellido;
            data[4]=telefono;
            data[5]=correo;
            data[6]=direccion;
            data[7]=genero;
        }else if(ventana.maleRadioButton.isSelected())
        {
            String genero = ventana.maleRadioButton.getText();
            data[0]=this.username; //Usuario a modificar
            data[1]=password;
            data[2]=nombre;
            data[3]=apellido;
            data[4]=telefono;
            data[5]=correo;
            data[6]=direccion;
            data[7]=genero;
        }else{
           int a = JOptionPane.ERROR_MESSAGE;
           JOptionPane.showMessageDialog(this.gui, "Por favor, seleccione algunos de los dos botones de selección de género.", "Error", JOptionPane.ERROR_MESSAGE);  
        }
        try
        {         
            this.validate_AllFieldsRegister(data);
            System.out.println("Todos los campos validados");
            //De aquí en adelante se toma que todos los valores ingresados por el usuario son válidos nombre, apellido, telefono, correo, direccion, username, password, genero
            this.modelo.ModifyUser(data);
            /*
            Se modifica el usuario actual del controlador y el cual es utilizado para guardar
            como usuario_creacion y usuario_modificación y de las inserciones y modificaciones realizadas
            a tablas tales como mascota, adopciones y rescates. 
            */
            this.username=data[1];
            //Se informa al usuario de la operación exitosa.
            int a = JOptionPane.OK_OPTION;
            JOptionPane.showConfirmDialog(ventana, "La alteración de datos se ha realizado con éxito.", "Operación exitosa", a);
            this.backtoAccountScreen(); //Se vuelve al menú de usuario
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
        } catch (FileNotFoundException ex) {
            this.errorConn(ex);
        }
    }
    
    
    
    private void validate_AllFieldsRegister(String[] datos) throws UnsupportedOperationException, InputValueNotAcceptableException, UnsupportedOperationException, SQLException, ClassNotFoundException
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
        if (!this.validate_Password(datos[1])) //Valida password
        {
            throw new NullPointerException();
        }
        if (datos[7]=="" || datos[7]==null) //Valida genero
        {
            throw new NullPointerException();
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
    
    
  
    private void registrar_Mascota() 
    {
        Registro_Rescate_Mascota ventana = (Registro_Rescate_Mascota) this.gui;
        try
        {
            this.validate_AllFieldsRegistroMascota(ventana);
            
            /*
            Se extraen los valores insertados por el usuario y se insertan
            en variable para hacer su reconocimiento y manejo más fácil.
            */
            String nombre = ventana.nameMascotaField.getText();
            String tipo = (String) ventana.tipoMascotaComboBox.getSelectedItem();
            String raza = (String) ventana.razaMascotaComboBox.getSelectedItem();
            String color1 = (String) ventana.color1MascotaComboBox.getSelectedItem();
            String color2 = (String) ventana.color2MascotaComboBox.getSelectedItem();
            String espacio = (String) ventana.espacioMascotaComboBox.getSelectedItem();
            String tamano = (String) ventana.tamanoMascotaComboBox.getSelectedItem();
            String training = (String) ventana.entrenamientoMascotaComboBox.getSelectedItem();
            String energia = (String) ventana.energiaMascotaComboBox.getSelectedItem();
            String sexo=null;
            if (ventana.machoMascotaRadioButton.isSelected())
            {
                sexo= ventana.machoMascotaRadioButton.getText();
            }else if (ventana.hembraMascotaRadioButton.isSelected()){
                sexo = ventana.hembraMascotaRadioButton.getText();
            }else
            {
                throw new NullPointerException();
            }
            String veterinario;
            if (ventana.veterinarioMascotaField.getText()!="")
            {
                veterinario = ventana.veterinarioMascotaField.getText();
            }else
            {
                veterinario = null;
            }
            String medicamentos;
            if (ventana.medicamentosMascotaField.getText()!="")
            {
                medicamentos = ventana.medicamentosMascotaField.getText();
            }else
            {
                medicamentos = null;
            }
            String enfermedades;
            if (ventana.enfermedadesMascotaField.getText()!="")
            {
                enfermedades = ventana.enfermedadesMascotaField.getText();
            }else
            {
                enfermedades = null;
            }
            String notas;
            if (ventana.notasMascotaField.getText()!="")
            {
                notas = ventana.notasMascotaField.getText();
                
            }else
            {
                notas = null;
            }
            String tratamientos;
            if (ventana.tratamientoMascotaField.getText()!="")
            {
                tratamientos = ventana.tratamientoMascotaField.getText();
            }else
            {
                tratamientos = null;
            }
            String situacion;
            if (ventana.situacionMascotaField.getText()!="")
            {
                situacion = ventana.situacionMascotaField.getText();
            }else
            {
                situacion = null;
            }
            String severidad =(String) ventana.severidadMascotaComboBox.getSelectedItem();
            File foto_antes;
            if (ventana.imageDirMascotaField.getText()!="")
            {
                foto_antes = new File(ventana.imageDirMascotaField.getText());
            }else
            {
                foto_antes=null;
            }
            File foto_despues=null;
            String contacto = this.username;
            
            
            this.modelo.insertMascota(this.username,nombre,tipo, raza, color1, color2, espacio, tamano, training, 
                                      energia, sexo, veterinario, medicamentos, enfermedades, notas, tratamientos,
                                      situacion, severidad, foto_antes, foto_despues, contacto);
            //Se informa al usuario de la operación exitosa.
            int a = JOptionPane.OK_OPTION;
            JOptionPane.showConfirmDialog(ventana, "El registro de la mascota ha sido exitosa. Puede modificar los datos insertados en la ventana Mis Mascotas Rescatadas.", "Operación exitosa", a);
            this.backtoAccountScreen(); //Se vuelve al menú de usuario    
        }catch(NullPointerException e)
        {
            System.out.println("Excepcion NullPointerException en RegistrarMascota()");
            int a = JOptionPane.ERROR_MESSAGE;
            JOptionPane.showMessageDialog(this.gui, "Por favor, inserte valores válidos y llene los valores indicados como obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            this.errorConn(ex);
        } catch (ClassNotFoundException ex) {
            this.errorConn(ex);
        } catch (FileNotFoundException ex) {
            System.out.println("Excepcion NullPointerException en RegistrarMascota()");
            int a = JOptionPane.ERROR_MESSAGE;
            JOptionPane.showMessageDialog(this.gui, "Error insertando la imagen seleccioanda a la base de datos. Vuelva a intentar y si el error persiste, contacte al desarollador para recibir soporte.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    private void validate_AllFieldsRegistroMascota(Registro_Rescate_Mascota ventana)
    {
        String nombre = ventana.nameMascotaField.getText();
        if (nombre==null || nombre=="")
        {
            throw new NullPointerException();
        }
        String sexo;
        if  (ventana.machoMascotaRadioButton.isSelected())
        {
            sexo = "Macho";
        }else if(ventana.hembraMascotaRadioButton.isSelected())
        {
            sexo = "Hembra";
        }else{
            throw new NullPointerException();
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
        
        
        //Función ejecutada cuando el usuario presiona el botón de Cerrar Sesión ya sea en la barra o en
        // esquina inferior derecha.




    private void errorConn(Exception e)
    {
        if (e instanceof SQLException)
        {
            Error_connection_db error = new Error_connection_db((SQLException) e); 
            error.show();
            error.setSize(new Dimension(524,250));
            error.setPreferredSize(new Dimension(524,250));
            error.validate();
            //error.pack();
            error.setMinimumSize(new Dimension(524,250));
        }else{
            Error_connection_db error = new Error_connection_db(e);
            error.show();
            error.setSize(new Dimension(524,250));
            error.setPreferredSize(new Dimension(524,250));
            error.validate();
            error.setMinimumSize(new Dimension(524,250));
            //error.pack();
        }
    }
}

