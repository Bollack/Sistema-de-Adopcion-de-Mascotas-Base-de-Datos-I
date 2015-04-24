/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import GUI_View.Main_Visitante;
import Model.Model;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    
    public Controller_Admin()
    {
        
    }
 public void actionPerformed(ActionEvent e) {
       String comando = e.getActionCommand();

       if (comando=="Log In")
       {
           gui.show(false);
           gui.disable();
           this.log_In_Window();
       }else if(comando=="Buscar Personas-Ventana Main")
       {
           
       }else if(comando=="Cambio de Vista-Ventana Logeo")
       {
           
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
}
