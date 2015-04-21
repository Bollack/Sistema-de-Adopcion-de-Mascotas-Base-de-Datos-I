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
/**
 *
 * @author Daniel Troyo
 * 11/04/2015  8:21 p.m Clase que controla las acciones y procesos realizados en la sesión de ADMIN
 */
public class Controller_Admin implements ActionListener 
{
 
    private Model modelo;
    private Main_Admin guiInicial;
    
    public Controller_Admin()
    {
        
    }
 public void actionPerformed(ActionEvent e) {
       String comando = e.getActionCommand();

       if (comando=="")
       {
           gui.show(false);
           Controller_User controlUser = new Controller_User();
           controlUser.log_In();
       }
        
    }
}
