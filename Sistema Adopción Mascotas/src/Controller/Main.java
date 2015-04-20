/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import GUI_View.Main_Visitante;
import Model.Database_Connection;
import Model.Model;
import java.sql.SQLException;

/**
 *
 * @author Daniel Troyo
 * 3/04/2015  6:21 p.m
 */
public class Main {
    
        public static void main(String[] args) throws SQLException {
        //se crean los objetos MODELO Y VISTA
            Main_Visitante vista = new Main_Visitante();
        //Para colocar un skin propio de java
            Controller Engine = new Controller(vista);
            Engine.Start(); //Inicia la aplicación*/
        }
}
