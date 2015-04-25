/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;

/**
 *
 * @author Daniel
 *  3/04/2015  6:21 p.m
 */
public class Model {
    
    private Database_Connection conexion;
    
    
    public Model() throws Exception { //Prueba la conexión a la DB ingresando como visitante.
        try
        {
           this.conexion= new Database_Connection(3); 
           this.conexion.endConnection();
        }catch (Exception e){
             throw e;
        }
    }
    
    /*
        El nombre explica la función del método. Recibe los parámetros insertados por el controllador
        y los cuales el usuario insertó. Las validaciones externas ya son realizadas por el controlador, tales
        como correo válido y número de teléfono en formato correcto. Además que si se llenaron los campos
        obligatorios y validaciones superficiales similares.
    */
    public boolean InsertarUsuario(String nombre, String apellido, String provincia, String genero, String telefono,
                                    String correo, String username, String password) throws SQLException, ClassNotFoundException
    {
        try //Trata de insertar al usuario 
        {
            this.conexion = new Database_Connection(1); //Se conecta como admin, puesto que la tabla es de admin y manipulada por admin
            String[] camposAllenar ={"username", "password"};
            String[] valores ={username, password};
            this.conexion.insertToTable("Usuario", camposAllenar, valores); //inserta al usuario
            
        }catch (SQLException e)
        {
            System.out.println(e.getMessage());
            throw e;
            
        }catch (ClassNotFoundException a)
        {
            System.out.println(a.getMessage());
            throw a;
        }
        try //Trata de insertar a la persona en la tabla de personas
        {   
            /*
                Obtiene el id del usuario recientemente creado para asociar la persona
                a crear con dicha tupla en la tabla usuarios. 
            */
            String usuarioTofind = "username="+username; 
            Object[][] idUsuarioCreado = conexion.select("Usuario", "id", usuarioTofind);
            int idUser = (int) idUsuarioCreado[0][0]; //Extrae del arreglo el id del usuario insertado 
            String[] camposAllenar1 = {"nombre", "apellido", "provincia","telefono","email","usuario", "genero"};
            Object[] valores1={nombre, apellido, provincia, telefono, correo,idUser,genero};
            this.conexion.insertToTable("Persona", camposAllenar1, valores1);
            //Finaliza la conexión
            this.conexion.endConnection(); 
            //Devuelve una señal indicando que la operación se realizó con éxito 
            return true;
        }catch (SQLException e)
        {
            //Devuelve la excepción para que así el controlador pueda mostrar su mensaje en 
            //ventana de error y el administrador/usuario pueda verlo desde la misma app.
            throw e;
        }      
    }
    
    /*public ResultSet enviarConsulta(){
        
    }
    
    */
    public boolean checkUserExists(String username)
            /*
                Hace uso del procedimiento almacenado en la base de datos 
                que realiza dicha función y el cual devuelve un boolean.
            */
    {
        try{
            
            return true;
        }catch (Exception e)
        {
            return false;
        }        
    }
    
    public boolean checkPassword(String password, String username){
             /*
                Hace uso del procedimiento almacenado en la base de datos 
                que realiza dicha función y el cual devuelve un boolean.
            */
        
    }
    public boolean insertMascota(String username, String password, String nombre, String tipoMascota, String Raza, String Color1, String Color2,
                                String espacio, String tamano, String training, String sexo, String energia, String veterinario,
                                String medicamentos, String Tratamientos, String situacion, String notas, File fotografia_antes,
                                String contacto) throws SQLException, ClassNotFoundException
    {
        try //Trata de insertar la tupla en la tabla mascota, solicitándoselo a 
            //Database_Connection y esperando su respuesta
        {
            this.conexion = new Database_Connection(2); //Se conecta como admin, 
                                                        //puesto que la tabla es de admin y manipulada por admin
            String[] camposAllenar = {"username","password"};
            String[] valores ={username, password};
            this.conexion.insertToTable("Usuario", camposAllenar, valores); //inserta al usuario
            
        }catch (SQLException e)
        {
            System.out.println(e.getMessage());
            throw e;
            
        }catch (ClassNotFoundException a)
        {
            System.out.println(a.getMessage());
            throw a;
        }
    }
    
    public boolean insertDevolucion(String motivo, int idMascota,String username){
             /*
                Hace uso del procedimiento almacenado en la base de datos 
                que realiza dicha función y el cual devuelve un boolean.
            */
        try{
            
            return true;
        }catch (Exception e)
        {
            return false;
        }        
    }
    
    public JTable getModelFromResultSet(String comando) throws SQLException
    {
        try
        {
            switch (comando)
            {   
                case "Mascota visitante":
                    this.conexion.setConnection(3);
                    String[] datosAextraer = {"id","nombre","tipo","raza", "sexo","tamano"};
                    ResultSet resset = this.conexion.getTablaSinCondicion("Mascota",datosAextraer);
                    ListTableModel modelo = ListTableModel.createModelFromResultSet(resset);
                    JTable tabla = new JTable(modelo);
                    this.conexion.endConnection();
                    return tabla;
                case "Personas administrador":
                case "Mascotas administrador":
                case "Adopciones administrador":                   
                case "Devoluciones administrador":                    
                case "Lista negra administrador":                    
            }
        }catch(SQLException e)
        {
            throw e;
        }
        return null;
    }
}
