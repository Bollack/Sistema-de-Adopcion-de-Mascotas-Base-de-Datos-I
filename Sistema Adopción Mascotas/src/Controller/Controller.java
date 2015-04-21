
package Controller;

import GUI_View.Main_Visitante;
import GUI_View.Error_connection_db;
import Model.Model;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Daniel Troyo
 * 3/04/2015  6:21 p.m
 */
public class Controller implements ActionListener{
    
    private Main_Visitante gui;
    private Model modelo;

    /**
     *
     * @param vista
     */
    public Controller(Main_Visitante vista) {
        this.gui = vista;
        try {
            this.modelo = new Model();
        } catch (Exception ex) {
            Error_connection_db errorVentana = new Error_connection_db();
            errorVentana.show();
            System.exit(0);
        }
    }
    
    public void Start()
    {
        gui.setVisible(true);
        gui.pack();
        gui.exitButton.addActionListener((ActionListener) this);
        gui.RegisterButton.addActionListener((ActionListener) this);
        gui.RegisterButton.setActionCommand("Registrarse");
        gui.LogInButton.addActionListener((ActionListener) this);
        gui.exitButton.setActionCommand("Salir");
        gui.LogInButton.setActionCommand("Log In");
        //gui.tablaMascotas
        try
        {
            this.modelo = new Model();
            
            
        }catch (Exception e){
            Error_connection_db error = new Error_connection_db();
            error.show();
            error.aceptarButton.addActionListener((ActionListener)this);
            System.exit(0);                                      
        }
    }
    
    public void actionPerformed(ActionEvent e) {
       String comando = e.getActionCommand();

       if (comando=="Log In")
       {
           gui.show(false);
           Controller_User controlUser = new Controller_User();
           controlUser.log_In();
       }
        
    }
    
    private boolean verifyPhone(String numero)
    {
        return true;
    }
    
    
}
