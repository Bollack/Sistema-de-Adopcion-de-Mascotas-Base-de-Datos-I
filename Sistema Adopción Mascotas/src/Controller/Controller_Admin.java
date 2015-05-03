/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import GUI_View.Error_connection_db;
import GUI_View.Main_Admin;
import GUI_View.Main_Visitante;
import Model.Model;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
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
        
        ventana.
        ventana;
              
        ventana;
        ventana;
        
        ventana;
        ventana;
        
        ventana;
        ventana;
        
        ventana;
        ventana;
        
        ventana;
        ventana;
        
        ventana;
        ventana;
        
        
  
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

       }else if(comando=="Ver Persona-Tab Usuario")
       {
           
       }else if(comando=="Tab Mascotas")
       {
           
       }else if(comando=="Tab Adopciones")
       {
           this.gui.disable();
           this.gui.show(false);
           this.backToMainWindow();
       }else if(comando=="Crear Formulario-Tab Formulario")
       {
           gui.show(false);
           this.Registrase_Window();
       }else if(comando=="Borrar Formulario-Tab Formulario")
       {
           gui.show(false);
           this.Registrase_Window();
       }else if(comando=="Añadir Pregunta-Tab Formulario")
       {
           gui.show(false);
           this.Registrase_Window();
       }else if(comando=="Modificar Pregunta-Tab Formulario")
       {
           gui.show(false);
           this.Registrase_Window();
       }else if(comando=="Añadir respuesta-Tab Formulario")
       {
           gui.show(false);
           this.Registrase_Window();
       }else if(comando=="Asignar Variable a Averiguar-Tab Formulario")
       {
           gui.show(false);
           this.Registrase_Window();
       }else if(comando=="Borrar Pregunta-Tab Formulario")
       {
           gui.show(false);
           this.Registrase_Window();
       }else if(comando=="Pregunta Anterior-Tab Formulario")
       {
           gui.show(false);
           this.Registrase_Window();
       }else if(comando=="Siguiente Pregunta-Tab Formulario")
       {
           gui.show(false);
           this.Registrase_Window();
       }else if(comando=="Registrarse-Ventana Registro")
       {
           
       }else if(comando=="Cerrar Sesión")
       {
           this.gui.dispose();
           this.gui.show(false);
           //Se inicializa la instancia de clase Controller y se llama al método que establece
           // su ventana, así como la lógica respectiva. Vuelve al menú principal (Visitante).
           Controller engine = new Controller();
           engine.Start();
           
       }else if(comando=="")
       {
           
       }else if(comando=="")
       {
           
       }  
    }


    private void verPersona()
    {

    }
    
    private void verMascota()
    {
        
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
 
 
 
 
 
 }