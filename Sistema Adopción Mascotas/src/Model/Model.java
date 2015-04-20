/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Daniel
 *  3/04/2015  6:21 p.m
 */
public class Model {
    
    private Database_Connection conexion;
    
    
    public Model() throws Exception {
        try{
           this.conexion= new Database_Connection();
           
        }catch (Exception e){
             throw e;
        }
           
        
    }
    
    
    /*public ResultSet enviarConsulta(){
        
    }
    
    */
    public boolean insertUser()
    {
        try{
            
            return true;
        }catch (Exception e)
        {
            return false;
        }        
    }
    
    public boolean insertMascota(){
        try{
            
            return true;
        }catch (Exception e)
        {
            return false;
        }   
    }
    
    public boolean insertDevolucion(){
        try{
            
            return true;
        }catch (Exception e)
        {
            return false;
        }        
    }
}
