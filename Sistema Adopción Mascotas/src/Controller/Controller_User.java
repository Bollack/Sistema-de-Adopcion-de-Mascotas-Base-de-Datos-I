/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import GUI_View.Log_In;
import GUI_View.Main_User;
import GUI_View.Main_Visitante;
import GUI_View.Registro_Rescate_Mascota;
import GUI_View.Registro_Usuario;
import Model.Model;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.UnsupportedOperationException;
import javax.swing.event.DocumentListener;
import org.apache.commons.lang3.*;
import org.apache.commons.mail.*;
import org.apache.commons.validator.*;


/*
@author Daniel Troyo
02/04/2015  8:21 p.m Clase que controla las acciones y procesos realizados en la sesión de usuario 
 */
public class Controller_User implements ActionListener
{
    private String username; //Se utilizará para almacenarlo en los campos de auditoría 
    private Model modelo;
    private Main_User gui_Inicial;
    
    public Controller_User(Model modelo, String userLogeo)
    {
        this.modelo = modelo;
        this.username = userLogeo;
        this.gui_Inicial = new Main_User();
        
        this.gui_Inicial.
        this.gui_Inicial
        this.gui_Inicial
        this.gui_Inicial                
        this.gui_Inicial                
        this.gui_Inicial
    }
    
    
    public void actionPerformed(ActionEvent e) {
       String comando = e.getActionCommand();

       if (comando=="Cerrar Sesión-Ventana Usuario")
       {

       }else if(comando=="Buscar Personas"){
           
       }else if(comando=="Ver mis mascotas adoptadas"){
           
       }else if(comando=="Ordenar por"){
           
       }else if(comando=="Ver "){
           
       }else if(comando==""){
           
       }else if(comando==""){
           
       }else if(comando==""){
           
       }else if(comando==""){
           
       }
        
    }
    

    
    
    public void registrar_Mascota()
    {
        //Se istancia el objeto de la clase ventana
        Registro_Rescate_Mascota ventana_rescate = new Registro_Rescate_Mascota();
        //Se inicializan los listener de los elementos de las ventanas
        ventana_rescate.atrasMascotaButton.addActionListener((ActionListener) this);
        ventana_rescate.color1MascotaComboBox.addActionListener((ActionListener) this);
        ventana_rescate.color2MascotaComboBox.addActionListener((ActionListener) this);
        ventana_rescate.energiaMascotaComboBox.addActionListener((ActionListener) this);
        ventana_rescate.entrenamientoMascotaComboBox.addActionListener((ActionListener) this);
        ventana_rescate.espacioMascotaComboBox.addActionListener((ActionListener) this);
        ventana_rescate.espacioMascotaComboBox.addActionListener((ActionListener) this);
        ventana_rescate.findImageButton.addActionListener((ActionListener) this);
        ventana_rescate.imageDirMascotaField.addActionListener((ActionListener) this);
        ventana_rescate.medicamentosMascotaField.getDocument().addDocumentListener((DocumentListener) (ActionListener) this);
        ventana_rescate.nameMascotaField.addActionListener((ActionListener) this);
        ventana_rescate.notasMascotaField.getDocument().addDocumentListener((DocumentListener) (ActionListener) this);
        ventana_rescate.razaMascotaComboBox.addActionListener((ActionListener) this);
        ventana_rescate.registrarMascotaButton.addActionListener((ActionListener) this);
        ventana_rescate.situacionMascotaField.getDocument().addDocumentListener((DocumentListener) (ActionListener) this);
        ventana_rescate.tamanoMascotaComboBox.addActionListener((ActionListener) this);
        ventana_rescate.tipoMascotaComboBox.addActionListener((ActionListener) this);
        ventana_rescate.tratamientoMascotaField.getDocument().addDocumentListener((DocumentListener) (ActionListener) this);
        ventana_rescate.veterinarioMascotaField.addActionListener((ActionListener) this);
        
        //Se comienza a alterar los componentes con restricciones en reemplazo de tablas catálogo
        
        ventana_rescate.energiaMascotaComboBox.addItem("Atlético");
        ventana_rescate.energiaMascotaComboBox.addItem("Activo");
        ventana_rescate.energiaMascotaComboBox.addItem("Regular");
        ventana_rescate.energiaMascotaComboBox.addItem("Pasivo");
        ventana_rescate.energiaMascotaComboBox.addItem("Perezoso");
        
        ventana_rescate.espacioMascotaComboBox.addItem("Amplio");
        ventana_rescate.espacioMascotaComboBox.addItem("Mediano");
        ventana_rescate.espacioMascotaComboBox.addItem("Mínimo");
        
        ventana_rescate.entrenamientoMascotaComboBox.addItem("Obediente");
        ventana_rescate.entrenamientoMascotaComboBox.addItem("Tranquilo");
        ventana_rescate.entrenamientoMascotaComboBox.addItem("Disperso");
        ventana_rescate.entrenamientoMascotaComboBox.addItem("Hiperactivo");
        
        ventana_rescate.tamanoMascotaComboBox.addItem("");
        ventana_rescate.tamanoMascotaComboBox.addItem("");
        ventana_rescate.tamanoMascotaComboBox.addItem("");
        
        ventana_rescate.show(true);



    }    
    
    

}



