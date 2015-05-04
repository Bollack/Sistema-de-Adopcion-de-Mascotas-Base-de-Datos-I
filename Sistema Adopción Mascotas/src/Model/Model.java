/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.InputValueNotAcceptableException;
import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
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
    
    public boolean checkUserExists(String username) throws SQLException, ClassNotFoundException, NullPointerException, IOException
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
 
    public boolean checkPassword(String username,String password) throws SQLException, ClassNotFoundException, NullPointerException, IOException{
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
    
    public String[] getDatosFromUsername(String username) throws SQLException, NullPointerException, ClassNotFoundException, IOException
    {
        this.conexion.setConnection(1);
        String[] datos = new String[8];
        String[] parametros = new String[2];
        parametros[0] = username;//"'"+username+"'";
        try {
            parametros[1]="password";
            datos[0]=username;
            String respuesta= ((String) this.conexion.callFunction("get Datos Usuario",parametros));
            System.out.println(respuesta);
            datos[1]=respuesta;
            
            parametros[1]="nombre";
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
    
    public Object[] getDatosFromMascota(int id) throws SQLException, IOException, ClassNotFoundException
    {
        this.conexion.setConnection(1);
        Object[] datos = new Object[23];
        Object[] parametros = new Object[2];
        parametros[0] = id;//"'"+username+"'";
        try {
            parametros[1]="nombre";
            datos[0]=id;
            String respuesta= ((String) this.conexion.callFunction("get Datos Usuario",parametros));
            System.out.println(respuesta);
            datos[1]=respuesta;
            
            parametros[1]="tipo";
            respuesta= ((String) this.conexion.callFunction("get Datos Mascota",parametros));
            System.out.println(respuesta);
            datos[2]=respuesta;
            
            parametros[1]="raza";
            respuesta= ((String) this.conexion.callFunction("get Datos Mascota",parametros));
            System.out.println(respuesta);
            datos[3]=respuesta;
            
            parametros[1]="tamano";
            respuesta= ((String) this.conexion.callFunction("get Datos Mascota",parametros));
            System.out.println(respuesta);
            datos[4]=respuesta;
            
            parametros[1]="color1";
            respuesta= ((String) this.conexion.callFunction("get Datos Mascota",parametros));
            System.out.println(respuesta);
            datos[5]=respuesta;
            
            parametros[1]="color2";
            respuesta= ((String) this.conexion.callFunction("get Datos Mascota",parametros));
            System.out.println(respuesta);
            datos[6]=respuesta;
            
            parametros[1]="nivel_energia";
            respuesta= ((String) this.conexion.callFunction("get Datos Mascota",parametros));
            System.out.println(respuesta);
            datos[7]=respuesta;
            
            parametros[1]="";
            respuesta= ((String) this.conexion.callFunction("get Datos Mascota",parametros));
            System.out.println(respuesta);
            datos[8]=respuesta;
                      
            parametros[1]="";
            respuesta= ((String) this.conexion.callFunction("get Datos Mascota",parametros));
            System.out.println(respuesta);
            datos[9]=respuesta;
            
            parametros[1]="";
            respuesta= ((String) this.conexion.callFunction("get Datos Mascota",parametros));
            System.out.println(respuesta);
            datos[10]=respuesta;
            
            parametros[1]="";
            respuesta= ((String) this.conexion.callFunction("get Datos Mascota",parametros));
            System.out.println(respuesta);
            datos[11]=respuesta;
            
            parametros[1]="";
            respuesta= ((String) this.conexion.callFunction("get Datos Mascota",parametros));
            System.out.println(respuesta);
            datos[12]=respuesta;
            
            parametros[1]="";
            respuesta= ((String) this.conexion.callFunction("get Datos Mascota",parametros));
            System.out.println(respuesta);
            datos[13]=respuesta;
            
            parametros[1]="";
            respuesta= ((String) this.conexion.callFunction("get Datos Mascota",parametros));
            System.out.println(respuesta);
            datos[14]=respuesta;
            
            parametros[1]="";
            respuesta= ((String) this.conexion.callFunction("get Datos Mascota",parametros));
            System.out.println(respuesta);
            datos[15]=respuesta;
            
            parametros[1]="";
            respuesta= ((String) this.conexion.callFunction("get Datos Mascota",parametros));
            System.out.println(respuesta);
            datos[16]=respuesta;
            
            parametros[1]="";
            respuesta= ((String) this.conexion.callFunction("get Datos Mascota",parametros));
            System.out.println(respuesta);
            datos[17]=respuesta;
            
            parametros[1]="";
            respuesta= ((String) this.conexion.callFunction("get Datos Mascota",parametros));
            System.out.println(respuesta);
            datos[18]=respuesta;
            
                        parametros[1]="";
            respuesta= ((String) this.conexion.callFunction("get Datos Mascota",parametros));
            System.out.println(respuesta);
            datos[18]=respuesta;
            
                        parametros[1]="";
            respuesta= ((String) this.conexion.callFunction("get Datos Mascota",parametros));
            System.out.println(respuesta);
            datos[18]=respuesta;
            
                        parametros[1]="";
            respuesta= ((String) this.conexion.callFunction("get Datos Mascota",parametros));
            System.out.println(respuesta);
            datos[18]=respuesta;
            
                        parametros[1]="";
            respuesta= ((String) this.conexion.callFunction("get Datos Mascota",parametros));
            System.out.println(respuesta);
            datos[18]=respuesta;
            
                        parametros[1]="";
            respuesta= ((String) this.conexion.callFunction("get Datos Mascota",parametros));
            System.out.println(respuesta);
            datos[18]=respuesta;
            
        } catch (SQLException ex) {
            throw ex;
        } catch (NullPointerException ex) {
            System.out.println();
            throw ex;
        }
        this.conexion.endConnection();
        return datos;
    }
    
    
    public boolean insertMascota(String username, String nombre, String tipoMascota, String Raza, String Color1, String Color2,
                                String espacio, String tamano, String training, String energia,String sexo, String veterinario,
                                String medicamentos, String enfermedades,String notas,String Tratamientos, String situacion, String severidad, File foto_antes,
                                File foto_despues) throws SQLException, ClassNotFoundException, FileNotFoundException
    {
        Object[] datos = new Object[20];
        try //Trata de insertar la tupla en la tabla mascota, solicitándoselo a 
            //Database_Connection y esperando su respuesta
        {
            this.conexion = new Database_Connection(1); //Se conecta como usuario, 
            datos[0] = username;
            datos[1] = nombre;
            datos[2] = tipoMascota;
            datos[3] = Raza;
            datos[4] = Color1;
            datos[5] = Color2;
            datos[6] = espacio;
            datos[7] = tamano;
            datos[8] = training;
            datos[9] = energia;
            datos[10] = sexo;
            datos[11] = veterinario;
            datos[12] = medicamentos;
            datos[13] = enfermedades;
            datos[14] = notas;
            datos[15] = Tratamientos;
            datos[16] = situacion;
            datos[17] = severidad;
            datos[18] = foto_antes;
            datos[19] = foto_despues;

            this.conexion.callProcedure("Insertar Mascota",datos);
            
            this.conexion.endConnection();
        }catch (SQLException e)
        {
            System.out.println(e.getMessage());
            throw e;
            
        }catch (ClassNotFoundException a)
        {
            System.out.println(a.getMessage());
            throw a;
        }
        this.conexion.endConnection();
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
            String[] datosAextraer = new String[10];
            DefaultTableModel modelo;
            switch (comando)
            {   
                case "Mascota visitante":
                    this.conexion.setConnection(1);
                    datosAextraer = new String[8];
                    datosAextraer[0] = "id";
                    datosAextraer[1] = "tipo";
                    datosAextraer[2] = "raza";
                    datosAextraer[3] = "sexo";
                    datosAextraer[4] = "tamano";
                    datosAextraer[5] = "Administrador.get_lugar_from_id(contacto) AS lugar";
                    datosAextraer[6] = "severidad";
                    datosAextraer[7] = "Administrador.get_nombrecompleto_from_id(contacto) AS contacto";
                    modelo = this.conexion.getTablaSinCondicion("Mascota",datosAextraer);
                    System.out.println(modelo.getColumnName(3));
                    //JTable tabla = new JTable(modelo);
                    // System.out.println(tabla.getColumnName(0));
                    this.conexion.endConnection();
                    return modelo;
                case "Personas administrador":
                    this.conexion.setConnection(1);
                    datosAextraer = new String[6];
                    datosAextraer[0] = "Usuario";
                    datosAextraer[1] = "Administrador.get_NombreCompleto_from_id(id) AS Nombre_completo";
                    datosAextraer[2] = "lugar";
                    datosAextraer[3] = "telefono";
                    datosAextraer[4] = "email";
                    datosAextraer[5] = "Fecha_creacion AS Fecha_Registro";
                    modelo = this.conexion.getTablaSinCondicion("Persona",datosAextraer);
                    System.out.println(modelo.getColumnName(3));
                    //JTable tabla = new JTable(modelo);
                    // System.out.println(tabla.getColumnName(0));
                    this.conexion.endConnection();
                    return modelo;
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
    
    public ImageIcon getImageFromTable(String orden, int id)  throws InputValueNotAcceptableException, SQLException, ClassNotFoundException, NullPointerException, IOException
    {
        this.conexion.setConnection(2);
        Image imagen;
        Object[] parametros = new String[1];
        parametros[0] = id;
        switch (orden)
        {
            case "Extraer imagen mascota foto Despues":
                imagen = (Image) this.conexion.callFunction("Extraer imagen mascota foto Despues", (Object[]) parametros[1]);
                return new ImageIcon(imagen);
            case "Extraer imagen mascota Foto Antes":
                imagen = (Image) this.conexion.callFunction("Extraer imagen mascota foto Antes", (Object[]) parametros[1]);
                return new ImageIcon(imagen);
        }
        this.conexion.endConnection();
        ImageIcon image=null;
        return image;
    }
    
    public String getUsernamefromID(int id) throws SQLException, ClassNotFoundException, NullPointerException, IOException
    {
        this.conexion.setConnection(2);
        Object[] parametros = new Object[1];
        parametros[0]=id;
        String resultado = (String) this.conexion.callFunction("Get Username from ID", parametros);
        this.conexion.endConnection();
        return resultado;
    }
    
    public void ModifyUser(String[] datos) throws SQLException, ClassNotFoundException, FileNotFoundException
    {
        this.conexion.setConnection(2);
        boolean resultado = this.conexion.callProcedure("Modificar usuario-persona", datos);
        if (resultado)
        {
            System.out.println("Modificado usuario-persona exitoso");
        }
        this.conexion.endConnection();
    }
    
    public void ModifyMascota(int mascotaID,String username, String nombre, String tipoMascota, String Raza, String Color1, String Color2,
                                String espacio, String tamano, String training, String energia,String sexo, String veterinario,
                                String medicamentos, String enfermedades,String notas,String Tratamientos, String situacion, String severidad, File foto_antes,
                                File foto_despues) throws SQLException, ClassNotFoundException, FileNotFoundException
    {
        Object[] datos = new Object[21];
        try //Trata de insertar la tupla en la tabla mascota, solicitándoselo a 
            //Database_Connection y esperando su respuesta
        {
            this.conexion = new Database_Connection(1); //Se conecta como usuario, 
            datos[0] = mascotaID;
            datos[1] = username;
            datos[2] = nombre;
            datos[3] = tipoMascota;
            datos[4] = Raza;
            datos[5] = Color1;
            datos[6] = Color2;
            datos[7] = espacio;
            datos[8] = tamano;
            datos[9] = training;
            datos[10] = energia;
            datos[11] = sexo;
            datos[12] = veterinario;
            datos[13] = medicamentos;
            datos[14] = enfermedades;
            datos[15] = notas;
            datos[16] = Tratamientos;
            datos[17] = situacion;
            datos[18] = severidad;
            datos[19] = foto_antes;
            datos[20] = foto_despues;

            this.conexion.callProcedure("Modificar Mascota",datos);
            
            this.conexion.endConnection();
        }catch (SQLException e)
        {
            System.out.println(e.getMessage());
            throw e;
            
        }catch (ClassNotFoundException a)
        {
            System.out.println(a.getMessage());
            throw a;
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
        String[][] datos = (String[][]) this.conexion.select("Raza_mascota", "Raza", condicion);
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
