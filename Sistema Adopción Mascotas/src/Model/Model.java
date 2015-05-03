/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.InputValueNotAcceptableException;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Daniel
 *  3/04/2015  6:21 p.m
 */
public class Model {
    
    private Database_Connection conexion;
    
    
    public Model() throws SQLException, ClassNotFoundException { //Prueba la conexión a la DB ingresando como visitante.
        try
        {
           this.conexion= new Database_Connection(3); 
           this.conexion.endConnection();
        }catch (SQLException e){
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
                                    String correo, String username, String password) throws SQLException, ClassNotFoundException, FileNotFoundException
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
            String[] camposAllenar1 = {"nombre", "apellido", "provincia","telefono","email","usuario", "genero"};
            Object[] valores1={nombre, apellido, provincia, telefono, correo,username,genero};
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
    

    public void insertUsuario_Persona(String username, String password, String nombre, String apellido, String telefono,
                                    String correo, String direccion, String genero) throws SQLException, ClassNotFoundException, FileNotFoundException
    {
        /*
        Se añaden todos los atributos insertados. Esto no importa ya que todos los valores son obligatorios y
        no sucederá lo que pasará en mascota, que igual se enviará el atributo pero como valor null.
        */
        Object[] datos ={username, password, nombre, apellido, telefono, correo, direccion, genero};
        try
        {
            //Se establece conexión como Admin
            this.conexion.setConnection(1);
            System.out.println("Establecida la conexión. Comenzando insertado...");
            //Se llama a la función que ejecuta funciones de la DB y devuelve si se logró o no. 
            boolean resultado = this.conexion.callProcedure("Insertar usuario-persona", datos);
            if (resultado)
            {
                System.out.println("Insertado exitoso");
            }
            this.conexion.endConnection();
        }catch(SQLException e)
        {
            throw e;
        }
    }
    
    public boolean checkUserExists(String username) throws SQLException, ClassNotFoundException
    {
        /*
                Hace uso de la función en la base de datos 
                que realiza dicha función y el cual devuelve un boolean.
        */
        try
        {
                this.conexion.setConnection(1);
                System.out.println("Dentro de modelo, checkeando que :"+username+" exista...");
                Object[] parametros = {username};
                int existencia =  (int) this.conexion.callFunction("Check if username exists",parametros);
                System.out.println("Se obtiene resultado int existencia de la función Check if username exits dentro de Model");
                System.out.println("Existencia:"+existencia);
                this.conexion.endConnection();
                if (existencia==1)
                {
                    return true;
                }else
                {
                    return false;
                }
        }catch (SQLException e)
        {
            System.out.println("Ocurrió una excepción en checkUserExists de Modelo. Lanzando Exception...");
            throw e;
        }
    }      
 
    public boolean checkPassword(String username,String password) throws SQLException, ClassNotFoundException{
             /*
                Hace uso de la función  en la base de datos 
                que realiza dicha función y el cual devuelve un boolean.
                
            */
        try
        {
                this.conexion.setConnection(1);
                Object[] parametros = {username, password};
                System.out.println("Dentro de modelo, checkeando que :"+username+" tenga como password a "+password+"...");
                int validez = (int) this.conexion.callFunction("Check if password is correct",parametros);
                System.out.println("Validez: "+validez);
                this.conexion.endConnection();
                if (validez==1)
                {
                    return true;
                }else
                {
                    return false;
                }
        }catch (SQLException e)
        {
            throw e;
        }
    }
    
    
    
    /*
    Función que devuelve un array que contiene  [username, password, nombre, apellido, telefono, correo, direccion, geoero] de un
    usuario insertado por parametro.
    */
    
    public String[] getDatosFromUsername(String username) throws SQLException, NullPointerException, ClassNotFoundException
    {
        this.conexion.setConnection(1);
        String[] datos = new String[8];
        String[] parametros = new String[2];
        parametros[0] = username;//"'"+username+"'";
        try {
            parametros[1]="'password'";
            datos[0]=username;
            String respuesta= ((String) this.conexion.callFunction("get Datos Usuario",parametros));
            System.out.println(respuesta);
            datos[1]=respuesta;
            
            parametros[1]="'nombre'";
            respuesta= ((String) this.conexion.callFunction("get Datos Usuario",parametros));
            System.out.println(respuesta);
            datos[2]=respuesta;
            
            parametros[1]="apellido";
            respuesta= ((String) this.conexion.callFunction("get Datos Usuario",parametros));
            System.out.println(respuesta);
            datos[3]=respuesta;
            
            parametros[1]="telefono";
            respuesta= ((String) this.conexion.callFunction("get Datos Usuario",parametros));
            System.out.println(respuesta);
            datos[4]=respuesta;
            
            parametros[1]="correo";
            respuesta= ((String) this.conexion.callFunction("get Datos Usuario",parametros));
            System.out.println(respuesta);
            datos[5]=respuesta;
            
            parametros[1]="lugar";
            respuesta= ((String) this.conexion.callFunction("get Datos Usuario",parametros));
            System.out.println(respuesta);
            datos[6]=respuesta;
            
            parametros[1]="genero";
            respuesta= ((String) this.conexion.callFunction("get Datos Usuario",parametros));
            System.out.println(respuesta);
            datos[7]=respuesta;
            
            
        } catch (SQLException ex) {
            throw ex;
        } catch (NullPointerException ex) {
            System.out.println();
            throw ex;
        }
        this.conexion.endConnection();
        return datos;
    }
    
    public boolean insertMascota(String username, String password, String nombre, String tipoMascota, String Raza, String Color1, String Color2,
                                String espacio, String tamano, String training, String sexo, String energia, String veterinario,
                                String medicamentos, String Tratamientos, String situacion, String notas, File fotografia_antes,
                                String contacto) throws SQLException, ClassNotFoundException
    {
        Object[] datos=null;
        try //Trata de insertar la tupla en la tabla mascota, solicitándoselo a 
            //Database_Connection y esperando su respuesta
        {
            this.conexion = new Database_Connection(3); //Se conecta como usuario, 
            String[] camposAllenar = {"username","password"};
            String[] valores ={username, password};
            this.conexion.callProcedure("Insertar Mascota",datos);
        }catch (SQLException e)
        {
            System.out.println(e.getMessage());
            throw e;
            
        }catch (ClassNotFoundException a)
        {
            System.out.println(a.getMessage());
            throw a;
        }
        return true;
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
    
    public DefaultTableModel getModelFromResultSet(String comando) throws SQLException, ClassNotFoundException
    {
        try
        {
            switch (comando)
            {   
                case "Mascota visitante":
                    this.conexion.setConnection(1);
                    String[] datosAextraer = {"id","tipo","raza", "sexo","tamano","Administrador.get_lugar_from_id(contacto) AS lugar", "severidad", "Administrador.get_nombrecompleto_from_id(contacto) AS contacto"};
                    DefaultTableModel modelo = this.conexion.getTablaSinCondicion("Mascota",datosAextraer);
                    System.out.println(modelo.getColumnName(3));
                    //JTable tabla = new JTable(modelo);
                    // System.out.println(tabla.getColumnName(0));
                    this.conexion.endConnection();
                    return modelo;
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
    
    public ImageIcon getImageFromTable(String orden)  throws InputValueNotAcceptableException
    {
        switch (orden)
        {
            case "Extraer imagen mascota actual":
                
                
            case "Extraer imagen mascota amtes":
        }
        ImageIcon image=null;
        return image;
    }
    
    public void ModifyUser(String[] datos) throws SQLException, ClassNotFoundException
    {
        this.conexion.setConnection(2);
        boolean resultado = this.conexion.callProcedure("Modificar usuario-persona", datos);
        if (resultado)
        {
            System.out.println("Modificado usuario-persona exitoso");
        }
        this.conexion.endConnection();
    }
    
    
    /*
        Método que devuelve un arreglo con los tipos de mascotas disponibles en el sistema.
        Dicho arreglo de strings se insertará en los combobox disponibles para crear y modificar mascota.
    */
    public String[] getTiposMascota() throws SQLException, ClassNotFoundException
    {
        this.conexion.setConnection(1);
        String[][] datos = (String[][]) this.conexion.select("Tipo_mascota", "Especie", null);
        System.out.println(datos.length);
        System.out.println(datos[0][0]);
        System.out.println(datos[1][0]);
        System.out.println(datos[2][0]);
        System.out.println(datos[3][0]);
        System.out.println(datos[4][0]);
        String[] grupos = new String[datos.length];
        for (int i=0;i<datos.length; i++)
        {
            grupos[i]=datos[i][0];
        }
        this.conexion.endConnection();
        return grupos;
    }
    
    
    /*
    Método que devuelve un arreglo con las razas disponibles para un tipoMascota insertado por parámetro.
    Dicho arreglo de strings se insertará en los combobox disponibles para crear y modificar mascota.
    */
    
    public String[] getRazasFromTipoMascota(String tipoMascota) throws SQLException, ClassNotFoundException
    {
        this.conexion.setConnection(1);
        String condicion = "Grupo = "+"'"+tipoMascota+"'";
        System.out.println(condicion);
        String[][] datos = (String[][]) this.conexion.select("Raza_mascota", "Raza", condicion);
        System.out.println(datos.length);
        System.out.println(datos[0][0]);
        System.out.println(datos[1][0]);
        System.out.println(datos[2][0]);
        System.out.println(datos[3][0]);
        System.out.println(datos[4][0]);
        String[] razas = new String[datos.length];
        for (int i=0;i<datos.length; i++)
        {
            razas[i]=datos[i][0];
        }
        
        this.conexion.endConnection();
        return razas;
    }
    
    
    /*
    Método que devuelve un arreglo de imágenes de una adopción
    y las cuales serán msotradas cuando el usuario desee ver fotos que sube
    el adoptante sobre una adopción con una mascota. 
    */
    
    
    public ImageIcon[] getImagesfromAdopcion(int idAdopcion)
    {
        ImageIcon[] arreglo = null;
        /*
        Obtener un arreglo de ImageIcon de DatabaseConnection e irlos agregando en el
        arreglo a a retornar. Dichas imágenes serán consultadas de la tabla Foto mediante
        una consulta condicional WHERE idAdopcion=tabla,idAdopcion;
        */
        return arreglo;
        
    }
    
    /*
    Función que prueba si la contraseña insertada es la correcta para poder
    conectarse a Admin
    */
    public boolean testAdmin(String password)
    {
        try
        {
            this.conexion.tryConnectionAsAdmin(password);
            return true;
        }catch(SQLException e)
        {
            return false;
        }
    }
}
