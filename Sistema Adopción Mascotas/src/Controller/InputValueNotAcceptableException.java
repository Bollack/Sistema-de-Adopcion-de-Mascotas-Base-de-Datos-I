/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author Daniel
 */
public class InputValueNotAcceptableException extends Exception{
    
    private Object value;
    
    public InputValueNotAcceptableException(Object value)
    {
        this.value=value;
        
    }
    
    @Override
    public String getMessage(){
        return "Valor insertado erróneo o negado por restricciones del sistema: "+value.toString();
    }
    
    public Object getValue()
    {
        return value;
    }
}

