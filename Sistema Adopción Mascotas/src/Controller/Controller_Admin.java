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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JFrame;
/**
 *
 * @author Daniel Troyo
 * 11/04/2015  8:21 p.m Clase que controla las acciones y procesos realizados en la sesión de ADMIN
 */
public class Controller_Admin implements ActionListener 
{
 
    private Model modelo;
    private JFrame guiInicial;
    
    public Controller_Admin(Model modelo)
    {
        this.modelo = modelo;
        initiate();
    }
    
    private void initiate()
    {
        this.guiInicial = new Main_Admin();
        guiInicial.show();
        guiInicial.setResizable(false);
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
           this.backToMenu();
       }else if(comando=="Tab Formulario")
       {
           gui.show(false);
           this.Registrase_Window();
       }else if(comando=="Registrarse-Ventana Registro")
       {
           
       }else if(comando=="Cerrar Sesión")
       {
           this.guiInicial.dispose();
           this.guiInicial.show(false);
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


 
 
 
 
 
 }