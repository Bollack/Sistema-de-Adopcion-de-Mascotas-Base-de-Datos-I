/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import GUI_View.Main_Visitante;
import Model.Database_Connection;
import Model.Model;
import java.awt.Font;
import java.sql.SQLException;
import javax.swing.UIManager;

/**
 *
 * @author Daniel Troyo
 * 3/04/2015  6:21 p.m
 */
public class Main {
    
        public static void main(String[] args) throws SQLException, ClassNotFoundException {

            Font font = new Font("Rockwell",Font.BOLD, 14);
            UIManager.put("OptionPane.messageFont", font);
            UIManager.put("OptionPane.buttonFont", font);
            
            Controller Engine = new Controller();
            Engine.Start(); //Inicia la aplicación*/
            /*
            HAPPENING
            */
        }
}
