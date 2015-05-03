/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import GUI_View.Error_connection_db;
import GUI_View.Main_Admin;
import GUI_View.Main_Visitante;
import GUI_View.verPerfil;
import Model.Model;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
/**
 *
 * @author Daniel Troyo
 * 11/04/2015  8:21 p.m Clase que controla las acciones y procesos realizados en la sesión de ADMIN
 */
public class Controller_Admin implements ActionListener 
{
 
    private Model modelo;
    private JFrame gui;
    
    public Controller_Admin(Model modelo)
    {
        this.modelo = modelo;
        initiate();
    }
    
    private void log_Out()
    {
        int warning =  JOptionPane.YES_NO_OPTION;
        int answer = JOptionPane.showConfirmDialog (null, "¿Está seguro de que desea salir del modo de administrador y volver al menú de visitante?","Advertencia",warning);
        if (answer == JOptionPane.YES_OPTION)
        {
            this.gui.dispose();
            this.gui.show(false);
            Controller engine = new Controller();
            engine.Start();
        }
    }
    
    private void initiate()
    {
        this.gui = new Main_Admin();
        gui.show();
        gui.setResizable(false);
        Main_Admin ventana = (Main_Admin) this.gui;
        /*
            Se añaden los listeners a cada uno de los botones y elementos/componentes con los que interactua
            usuario. Así estos pueden tener secuencias de órdenes al ser activados/presionados/alterados.
            Se comienza por los más generarles y luego por los más específicos.
        */
        
        
        ventana.SalirButton.addActionListener((ActionListener) this);
        ventana.SalirButton.setActionCommand("Cerrar Sesión");
        
        //Se comienza a agregar los listener de los elementos en la pestaña de formulario
        

        
        ventana.addPreguntaButton.addActionListener((ActionListener) this);
        ventana.addPreguntaButton.setActionCommand("Añadir Pregunta - Formulario");
        
        
        ventana.borrarPreguntaButton.addActionListener((ActionListener) this);
        ventana.borrarPreguntaButton.setActionCommand("Borrar Pregunta - Formulario");
        
        ventana.EditarPreguntaButton.addActionListener((ActionListener) this);
        ventana.EditarPreguntaButton.setActionCommand("Editar Pregunta - Formulario");
              
        ventana.asignarVariableAaveriguarButton.addActionListener((ActionListener) this);
        ventana.asignarVariableAaveriguarButton.setActionCommand("Asignar variable a averiguar - Formulario");
        
        ventana.ModificarPreguntaButton.addActionListener((ActionListener) this);
        ventana.ModificarPreguntaButton.setActionCommand("Guardar Cambios modificados pregunta - Formulario");

                    //Se comienza con los listeners de la pestaña de adopciones y devoluciones
        //Se comienza con los listeners de la pestaña de mascotas
                    //Se comienza con los listeners de la pestaña de usuarios
        try 
        {  
            ventana.tablaUsuariosAdmin.setModel(this.modelo.getModelFromResultSet("Personas administrador"));
        }catch (SQLException ex) {
            this.errorConn(ex);
        } catch (ClassNotFoundException ex) {
            int a = JOptionPane.ERROR_MESSAGE;
            JOptionPane.showMessageDialog(ventana, "Excepción ClassNotFoundException al generar la tabla Personas administrador. Intente de nuevo más tarde o contacte al desarollador para recibir asistencia.", "Error", a);
        }
        ventana.tablaUsuariosAdmin.setRowSelectionAllowed(true);
        ListSelectionModel rowSelectionModel = ventana.tablaUsuariosAdmin.getSelectionModel();
        rowSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        rowSelectionModel.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e){
                String selectedData = null;
                ventana.verPefilUsuarioAdminButton.enable();
                ventana.verAdopcionesyRescatesButton.enable();
            }
        });
        //guiInicial.setIconImage(new ImageIcon());
        
    }
    
    
    private void backToMainWindow()
    {
        this.initiate();
    }
    
    public void actionPerformed(ActionEvent e) {
       String comando = e.getActionCommand();

       if (comando=="")
       {

       }else if(comando=="Borrar Pregunta - Formulario")
       {
       }else if(comando=="Añadir Pregunta - Formulario")
       {
       }else if(comando=="Editar Pregunta - Formulario")
       {
       }else if(comando=="Añadir respuesta-Tab Formulario")
       {
       }else if(comando=="Asignar Variable a Averiguar-Tab Formulario")
       {
       }else if(comando=="Borrar Pregunta-Tab Formulario")
       {
       }else if(comando=="Pregunta Anterior-Tab Formulario")
       {
       }else if(comando=="Siguiente Pregunta-Tab Formulario")
       {
       }else if(comando=="Registrarse-Ventana Registro")
       {
           
       }else if(comando=="Cerrar Sesión")
       {
           this.log_Out();
           
       }else if(comando=="")
       {
           
       }else if(comando=="")
       {
           
       }else if(comando=="")
       {
           
       }else if(comando=="")
       {
           
       }else if(comando=="")
       {
           
       }else if(comando=="")
       {
           
       }else if(comando=="")
       {
           
       }else if(comando=="")
       {
           
       }else if(comando=="")
       {
           
       }else if(comando=="")
       {
           
       }else if(comando=="")
       {
           
       }else if(comando=="")
       {
           
       }   
    }


    private void verPersona()
    {
        this.gui.show(false);
        this.gui.dispose();
        verPerfil ventana = new verPerfil();
        this.gui = ventana;
    }
    
    private void verMascota()
    {
        
    }
    
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

    private ImageIcon resizeImage(ImageIcon icon, int width, int height)
    {
        
        Image scaleImage = icon.getImage().getScaledInstance(width, height,Image.SCALE_DEFAULT);
        icon = new ImageIcon(scaleImage);
        return icon;
    }
 
 
 
 
 
 }