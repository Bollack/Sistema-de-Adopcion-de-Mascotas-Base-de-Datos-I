

package Model;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import static java.sql.JDBCType.BLOB;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import oracle.jdbc.driver.*;
import oracle.sql.BLOB;


/**
 *
 * @author Daniel
 */
public class Database_Connection {
    
    private String direccion =  "jdbc:oracle:thin:@192.168.0.102:1521:DBprueba";//"jdbc:oracle:thin:@186.176.166.148:1521:DBprueba";
    private Connection conn;
    
    
    /*
    tipoConexion se utiliza para establecer si es de admin, usuario, visitante o system
    0=system
    1=admin
    2=user
    3=visitante
    */
    public Database_Connection(int tipoConexion) throws SQLException, ClassNotFoundException  
    {
        try
        {
            Class.forName("oracle.jdbc.OracleDriver");
            switch(tipoConexion){
                case 0:
                    this.conn = DriverManager.getConnection(direccion,"system","Lordaeron1");
                    break;
                case 1:
                    this.conn = DriverManager.getConnection(direccion,"Administrador", "Admin12");
                    break;
                case 2:
                    this.conn = DriverManager.getConnection(direccion,"Usuario","usuario14");
                    break;
                case 3:
                    this.conn = DriverManager.getConnection(direccion,"Visitante", "visitante13");
                    break;    
            }
            this.conn.setAutoCommit(true);
        }catch(SQLException e)
        {
            System.out.println(e.getMessage());
            throw e;
        }         
    }
    
    
    /*
    Método que se encarga de probar la conexión a la DB ingresando como
    admin e insertando la password ingresada como parámetro. Esto
    con el fin de probar en el programa la validez de la contraseña ingresada por el
    usuario cuando quiere ingresar como Administrador. Tira excepción si la contraseña no
    es correcta.
    */
    public void tryConnectionAsAdmin(String password) throws SQLException
    {
        try
        {
            this.conn = DriverManager.getConnection(direccion,"Administrador", password);
            this.endConnection();
        }catch(SQLException e)
        {
            throw e;
        }
    }
    
    /*
    Método que se encarga de establecer una conexión de algún tipo en base al parámetro ingresado, 
    siendo este un entero que indica el tipo de conexión (Como cuál usuario) a establecer.
    No se cierra la conexión. 
    */
    
    public void setConnection(int tipoConexion)throws SQLException, ClassNotFoundException
    {
        try 
        {
               Class.forName("oracle.jdbc.OracleDriver");
            switch(tipoConexion){
                case 0:
                    this.conn = DriverManager.getConnection(direccion,"system","Lordaeron1");
                    break;
                case 1:
                    this.conn = DriverManager.getConnection(direccion,"Administrador", "Admin12");
                    break;
                case 2:
                    this.conn = DriverManager.getConnection(direccion,"Usuario","usuario14");
                        break;
                case 3:
                    this.conn = DriverManager.getConnection(direccion,"Visitante", "visitante13");
                    break; 
            }
            this.conn.setAutoCommit(true);
        }catch (SQLException e)
            {
                throw e;
            }
    }
    
    //No es necesaria descripción.   
    public Connection getConnection()
    {
        return this.conn;
    }
    //No es necesaria descripción.   
    public void endConnection() throws SQLException
    {
        try {
            this.conn.close();
        } catch (SQLException ex) {
            throw ex;
        }
    }
    
    /*
        Método que 
    */
    public boolean callProcedure(String comando,Object[] parametros) throws SQLException, FileNotFoundException
    {
        try
        {
            String llamado ="";
            CallableStatement storedPro;
            switch(comando)
            {
                case "Insertar usuario-persona":

                   try{
                        System.out.println("Comenzando proceso de base de datos. Insertar usuario-persona");
                        llamado = "{CALL INSERT_USER_PERSONA(?,?,?,?,?,?,?,?)}";
                        storedPro = this.conn.prepareCall(llamado);
                        System.out.println("storedPro creado");
                        storedPro.setString(1, (String) parametros[0]);
                        storedPro.setString(2, (String) parametros[1]);
                        storedPro.setString(1, (String) parametros[0]);
                        storedPro.setString(2, (String) parametros[1]);
                        storedPro.setString(3, (String) parametros[2]);
                        storedPro.setString(4, (String) parametros[3]);
                        storedPro.setString(5, (String) parametros[4]);
                        storedPro.setString(6, (String) parametros[5]);
                        storedPro.setString(7, (String) parametros[6]);
                        storedPro.setString(8, (String) parametros[7]);
                        storedPro.executeQuery();
                        System.out.println("Persona y usuario insertados");
                        storedPro.close();
                        return true;
                    }catch(SQLException e)
                    {
                        throw e;
                    }
                case "Modificar usuario-persona":
                    System.out.println("Comenzando proceso de base de datos. Modificar usuario-persona");
                    llamado = "{CALL Update_User_Persona(?,?,?,?,?,?,?,?}";
                    try{
                        storedPro = this.conn.prepareCall(llamado);
                        System.out.println("storedPro creado");
                        storedPro.setString(1, (String) parametros[0]);
                        storedPro.setString(2, (String) parametros[1]);
                        storedPro.setString(3, (String) parametros[2]);
                        storedPro.setString(4, (String) parametros[3]);
                        storedPro.setString(5, (String) parametros[4]);
                        storedPro.setString(6, (String) parametros[5]);
                        storedPro.setString(7, (String) parametros[6]);
                        storedPro.setString(8, (String) parametros[7]);
                        System.out.println((String)parametros[0] +" "+(String)parametros[1]+" "+(String)parametros[2]+" "+(String)parametros[3]+(String)parametros[4]+(String)parametros[5]+(String)parametros[6]+(String)parametros[7]);
                        System.out.println("Asignados parámetros. Ejecutando...");
                        storedPro.execute();
                        System.out.println("Persona y usuario "+(String)parametros[0]+" modificados");
                        storedPro.close();
                        return true;
                    }catch (SQLException e)
                    {
                        throw e;
                    }

                    
                case "Insertar Mascota":
                    llamado = "{ INSERT_MASCOTA(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
                    /*
                    Genera una conexión con el atributo conexion y prepara
                    la llamada con el string definido anteriormente, el cual
                    establece el query a consultar y definiendo parámetros
                    "?", donde el primero será el resultado de la función 
                    */
                    System.out.println("Creando storedPro...");
                    storedPro = this.conn.prepareCall(llamado);
                    System.out.println("Creado. Ordenando parámetros...");
                    storedPro.setString(1, (String) parametros[0]); //usuario
                    System.out.println(parametros[0]);
                    storedPro.setString(2, (String)parametros[1]); //nombre
                    System.out.println(parametros[1]);
                    storedPro.setString(3, (String)parametros[2]); //tipo
                    System.out.println(parametros[2]);
                    storedPro.setString(4, (String)parametros[3]); //raza
                    System.out.println(parametros[3]);
                    storedPro.setString(5, (String) parametros[4]); //color1
                    System.out.println(parametros[4]);
                    if (parametros[5]!=null) //color 2
                    {
                      storedPro.setString(6, (String) parametros[5]);   
                    }else
                    {
                        storedPro.setNull(6, java.sql.Types.NULL);
                    }
                    System.out.println(parametros[5]);
                    storedPro.setString(7, (String) parametros[6]); //espacio
                    System.out.println(parametros[6]);
                    storedPro.setString(8, (String) parametros[7]); //tamano
                    System.out.println(parametros[7]);
                    storedPro.setString(9, (String) parametros[8]); //training
                    System.out.println(parametros[8]);
                    storedPro.setString(10, (String) parametros[9]); //energia
                    System.out.println(parametros[9]);
                    storedPro.setString(11, (String) parametros[10]); //sexo
                    System.out.println(parametros[10]);
                    if (parametros[11]!=null)//veterinario
                    {
                        storedPro.setString(12, (String) parametros[11]);
                    }else
                    {
                        storedPro.setNull(12, java.sql.Types.NULL);
                    }
                    System.out.println(parametros[11]);
                    if (parametros[12]!=null)//medicamentos
                    {
                        storedPro.setString(13, (String) parametros[12]);
                    }else
                    {
                        storedPro.setNull(13, java.sql.Types.NULL);
                    }
                    System.out.println(parametros[12]);
                    if (parametros[13]!=null)//enfermedades
                    {
                        storedPro.setString(14, (String) parametros[13]);
                    }else
                    {
                        storedPro.setNull(14, java.sql.Types.NULL);
                    }
                    System.out.println(parametros[13]);
                    if (parametros[14]!=null)//notas
                    {
                        storedPro.setString(15, (String) parametros[13]);
                    }else
                    {
                        storedPro.setNull(15, java.sql.Types.NULL);
                    }
                    System.out.println(parametros[14]);
                    if (parametros[15]!=null)//tratamientos
                    {
                        storedPro.setString(16, (String) parametros[15]);
                    }else
                    {
                        storedPro.setNull(16, java.sql.Types.NULL);
                    }
                    System.out.println(parametros[15]);
                    if (parametros[16]!=null)//situacion
                    {
                        storedPro.setString(17, (String) parametros[16]);
                    }else
                    {
                        storedPro.setNull(17, java.sql.Types.NULL);
                    }
                    System.out.println(parametros[16]);
                    storedPro.setString(18, (String) parametros[17]); //severidad
                    System.out.println(parametros[17]);
                 
                    if (parametros[18]!=null) //Foto_Antes
                    {
                       FileInputStream imagen = this.convertImageToBLOB((File) parametros[18]);
                       storedPro.setBlob(19,imagen);
                    }else
                    {
                       storedPro.setNull(19, java.sql.Types.NULL);
                               
                    } 
                    System.out.println(parametros[18]);
                    storedPro.setNull(20, java.sql.Types.NULL); //Al insertar mascota, se le prohíbe al usuario insertat Foto_Después, ergo, siempre será null.
                    System.out.println(parametros[19]);
                    System.out.println("Parámetros asignados. Ejecutando...");
                    storedPro.executeQuery();
                    System.out.println("Ejecutado");
                    storedPro.close();
                    return true;
                case "Modificar Mascota":
                    llamado = "{call update_mascota(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
                    System.out.println("Modificando mascota...");                  
                    System.out.println("Creando storedPro...");
                    storedPro = this.conn.prepareCall(llamado);
                    System.out.println("Creado. Ordenando parámetros...");
                    storedPro.setInt(1, (int) parametros[0]); //id
                    storedPro.setString(2, (String) parametros[1]); //usuario
                    storedPro.setString(3, (String)parametros[2]); //nombre
                    storedPro.setString(4, (String)parametros[3]); //tipo
                    storedPro.setString(5, (String)parametros[4]); //raza
                    storedPro.setString(6, (String) parametros[5]); //color1
                    if (parametros[6]!=null) //color 2
                    {
                      storedPro.setString(7, (String) parametros[6]);   
                    }else
                    {
                        //storedPro.setNull(7, java.sql.Types.NULL);
                    }
                    storedPro.setString(8, (String) parametros[7]); //espacio
                    storedPro.setString(9, (String) parametros[8]); //tamano
                    storedPro.setString(10, (String) parametros[9]); //training
                    storedPro.setString(11, (String) parametros[10]); //energia
                    storedPro.setString(12, (String) parametros[11]); //sexo
                    if (parametros[12]!=null)//veterinario
                    {
                        storedPro.setString(13, (String) parametros[12]);
                    }else
                    {
                        storedPro.setString(13, (String) parametros[12]);
                        //storedPro.setNull(13, java.sql.Types.NULL);
                    }
                    if (parametros[13]!=null)//medicamentos
                    {
                        storedPro.setString(14, (String) parametros[13]);
                    }else
                    {
                        storedPro.setString(14, (String) parametros[13]);
                        //storedPro.setNull(14, java.sql.Types.NULL);
                    }
                    if (parametros[14]!=null)//enfermedades
                    {
                        storedPro.setString(15, (String) parametros[14]);
                    }else
                    {
                        storedPro.setString(15, (String) parametros[14]);
                        //storedPro.setNull(15, java.sql.Types.NULL);
                    }
                    if (parametros[15]!=null)//notas
                    {
                        storedPro.setString(16, (String) parametros[15]);
                    }else
                    {
                        storedPro.setString(16, (String) parametros[15]);
                        //storedPro.setNull(16, java.sql.Types.NULL);
                    }
                    if (parametros[16]!=null)//tratamientos
                    {
                        storedPro.setString(17, (String) parametros[16]);
                    }else
                    {
                        storedPro.setString(17, (String) parametros[16]);
                        //storedPro.setNull(17, java.sql.Types.NULL);
                    }
                    if (parametros[17]!=null)//situacion
                    {
                        storedPro.setString(18, (String) parametros[17]);
                    }else
                    {
                        storedPro.setString(18, (String) parametros[17]);
                        //storedPro.setNull(18, java.sql.Types.NULL);
                    }
                    storedPro.setString(19, (String) parametros[18]); //severidad
                    if (parametros[19]!=null) //Foto_Antes
                    {
                       FileInputStream imagen = this.convertImageToBLOB((File) parametros[19]);
                       storedPro.setBlob(20,imagen);
                    }else
                    {
                       //storedPro.setNull(20, java.sql.Types.NULL);
                               
                    }
                    if (parametros[20]!=null) //Foto_Antes
                    {
                       FileInputStream imagen = this.convertImageToBLOB((File) parametros[20]);
                       storedPro.setBlob(21,imagen);
                    }else
                    {
                       FileInputStream imagen = this.convertImageToBLOB((File) parametros[20]);
                       storedPro.setBlob(21,imagen);//storedPro.setNull(21, java.sql.Types.NULL);
                               
                    }
                    if (parametros[21]!=null) //Foto_despues
                    {
                        FileInputStream imagen = this.convertImageToBLOB((File) parametros[21]);
                        storedPro.setBlob(22, imagen);
                    }else
                    {
                        FileInputStream imagen = this.convertImageToBLOB((File) parametros[21]);
                        storedPro.setBlob(22, imagen);
                        //storedPro.setNull(22, java.sql.Types.NULL);                   
                    }
                    System.out.println("Parámetros asignados. Ejecutando...");
                    storedPro.execute();
                    System.out.println("Ejecutado");
                    storedPro.close();
                    return true;
                case "Enviar Solicitud":
                    storedPro = this.conn.prepareCall(llamado);
                case "Aceptar Solicitud":
                    storedPro = this.conn.prepareCall(llamado);
                case "Denegar Solicitud":                   
                    storedPro = this.conn.prepareCall(llamado);
                case "":
                    llamado ="{}";
                    storedPro = this.conn.prepareCall(llamado);
                case "Calificar Adoptante":
                    llamado = "{call calificar_adoptante(?,?,?,?)}";
                    System.out.println("Llamando  a procedimiento calificar_adoptante");
                    storedPro = this.conn.prepareCall(llamado);
                    
                case "Añadir adoptante a lista negra":
                case "Quitar adoptante de lista negra":
                default:
                    return false;
                    /*
                case "s":
                case "s":
                case "s":
                case "s":
                case "s":
                case "s":
                case "s":
                case "s":
                case "s":
                case "s":
                case "s"
                 */
            }
        }catch(SQLException e)
        {
            throw e;
        }
    }
    

    
    public Object callFunction(String comando, Object[] parametros) throws SQLException, NullPointerException, IOException 
    {
        try
        {
            /*
            Se define valores que se usarán en todos los casos posibles, 
            por lo tanto, se definen fuera del switch.
            */
            String llamado;
            CallableStatement stmt;
            String resultadoS = null;
            int resultadoI = 0;
            switch (comando)
            {  
                case "Check if password is correct":
                    llamado ="{? = call check_password(?,?) }";
                    /*
                    Genera una conexión con el atributo conexion y prepara
                    la llamada con el string definido anteriormente, el cual
                    establece el query a consultar y definiendo parámetros
                    "?", donde el primero será el resultado de la función 
                    */
                    stmt = this.conn.prepareCall(llamado);
                    String username =(String) parametros[0];
                    String password =(String) parametros[1];
                    /*
                    Al recibir la función call Function un array de String, el cual
                    mantiene los parámetros a llamar en la función, dichos parámetros
                    se insertan en el String llamado, reemplazando a los parámetros
                    predeterminados "?" y evitando así SQL Injection. 
                    Dicho método se utiliza en otras partes del proyecto, para así
                    tratar de evitar mayores posibilidades de SQL Injection.
                    */
                    stmt.setString(2, username);
                    stmt.setString(3, password);
                    /*
                    Registra el parámetro extraído, el cual es el primer parámetro
                    predeterminado en el string llamado y se asegura que sea un
                    booleano.
                    */
                    stmt.registerOutParameter(1, java.sql.Types.NUMERIC);
                    
                    stmt.execute();
                    //Devuelve dicho parámetro.
                    resultadoI = stmt.getInt(1);
                    stmt.close();
                    return resultadoI;
                case "Check if username exists":
                    llamado = "{? = call check_existing_username(?)}";
                    /*
                    Procedimiento similar al case pasado. 
                    */
                    stmt = this.conn.prepareCall(llamado);
                     System.out.println("stmt creado");
                    String user = (String) parametros[0];
                    System.out.println("Usuario a verificar existencia: "+user);
                    stmt.setString(2, user);
                    System.out.println("stmt.setString(2,user) hecho");
                    stmt.registerOutParameter(1, java.sql.Types.NUMERIC);
                    System.out.println("stmt.registerOutParameter(1, java.sql.Types.numeric); hecho");
                    stmt.execute();
                    System.out.println("Ejecutado");
                    resultadoI = stmt.getInt(1);
                    stmt.close();
                    return resultadoI;
                case "Get ID from Username - Persona":
                    llamado="{? = call funcion(?)}";
                    stmt = this.conn.prepareCall(llamado);
                    stmt.setString(1, (String) parametros[0]);
                    stmt.registerOutParameter(1, java.sql.Types.NUMERIC);
                    stmt.execute();
                    resultadoI = stmt.getInt(1);
                    stmt.close();
                    return resultadoI;
                case "Get name from ID - Persona":
                    llamado="{? = call funcion(?)}";
                    stmt = this.conn.prepareCall(llamado);
                    stmt.close();
                    stmt.execute();
                    return resultadoS;
                case "Extraer imagen mascota foto Despues":
                    llamado="{? = call get_foto_despues(?)}";
                    stmt = this.conn.prepareCall(llamado);
                    stmt.setInt(2, (int) parametros[0]);
                    stmt.registerOutParameter(1, java.sql.Types.BLOB);
                    stmt.execute();
                    BLOB resultadoImagen = (BLOB) stmt.getBlob(1);
                    Image imagen = this.convertBLOBtoImage((BLOB) resultadoImagen);
                    stmt.close();
                    return imagen;
                case "Extraer imagen mascota foto Antes":
                    llamado="{? = call get_foto_antes(?)}";
                    stmt = this.conn.prepareCall(llamado);
                    stmt.setInt(2, (int) parametros[0]);
                    stmt.registerOutParameter(1, java.sql.Types.BLOB);
                    stmt.execute();
                    resultadoImagen = (BLOB) stmt.getBlob(1);
                    imagen = this.convertBLOBtoImage((BLOB) resultadoImagen);
                    stmt.close();
                    return imagen;
                case "Get Username from ID":
                    llamado = "{? = get_username_from_id(?)}";
                    stmt = this.conn.prepareCall(llamado);
                    stmt.setInt(2, (int) parametros[0]);
                    stmt.registerOutParameter(1, java.sql.Types.VARCHAR);
                    stmt.close();
                    stmt.execute();
                    resultadoS = stmt.getString(1);
                    return resultadoS;
                case "get Datos Usuario":
                    System.out.println("Llamando a función get_datos_usuario() del usuario "+(String) parametros[0]+" DATO: "+parametros[1]);
                    llamado ="{? = call  get_datos_usuario(?,?)}";
                    stmt = this.conn.prepareCall(llamado);
                    stmt.setString(2, (String) parametros[0]); //username
                    stmt.setString(3, (String) parametros[1]); //valor a extraer, sea nombre, genero, lugar, etc.
                    System.out.println("Parámetros asignados");
                    stmt.registerOutParameter(1, java.sql.Types.VARCHAR);
                    System.out.println("Salida asignada");
                    stmt.execute();
                    System.out.println("Ejecutado");
                    resultadoS = stmt.getString(1);
                    stmt.close();
                    return resultadoS;
                case "get Datos Mascota":
                    //TO DO
                    System.out.println("Llamando a función get_datos_mascota() de la mascota con id: "+(int) parametros[0]+" DATO: "+(String)parametros[1]);
                    llamado ="{? = call  get_datos_usuario(?,?)}";
                    stmt = this.conn.prepareCall(llamado);
                    stmt.setString(2, (String) parametros[0]); //username
                    stmt.setString(3, (String) parametros[1]); //valor a extraer, sea nombre, genero, lugar, etc.
                    System.out.println("Parámetros asignados");
                    stmt.registerOutParameter(1, java.sql.Types.VARCHAR);
                    System.out.println("Salida asignada");
                    stmt.execute();
                    System.out.println("Ejecutado");
                    resultadoS = stmt.getString(1);
                    stmt.close();
                    return resultadoS;

            }
        }catch (SQLException e)
        {
            System.out.println(e.getMessage());
            System.out.println(e.getErrorCode());
            System.out.println(e.getSQLState());
            throw e;
        }
        return 0;
    }
//___________________________________________________________________________________ Soy una barra separadora :)
/* METODO PARA REALIZAR UNA CONSULTA A LA BASE DE DATOS
 * INPUT:  
 *      table => nombre de la tabla donde se realizara la consulta, puede utilizarse tambien INNER JOIN
 *      fields => String con los nombres de los campos a devolver Ej.: campo1,campo2campo_n
 *      where => condicion para la consulta
 * OUTPUT: un object[][], el cual pasa a ser una tabla, con los datos resultantes, sino retorna NULL
 */
    public Object [][] select(String table, String fields, String where) throws SQLException{
      int registros = 0;      
      String colname[] = fields.split(",");

      //Consultas SQL
      String q ="SELECT " + fields + " FROM " + table;
      String q2 = "SELECT count(*) as total FROM " + table;
      if(where!=null)
      {
          q+= " WHERE " + where;
          q2+= " WHERE " + where;
      }
      //obtenemos la cantidad de registros existentes en la tabla
      try{
         System.out.println(q);
         PreparedStatement pstm = conn.prepareStatement(q2);
         ResultSet res = pstm.executeQuery();
         res.next();
         registros = res.getInt("total");
         res.close();
      }catch(SQLException e){
         throw e;
      }
    //se crea una matriz con tantas filas y columnas que necesite
    Object[][] data = new String[registros][fields.split(",").length];
    //realizamos la consulta sql y llenamos los datos en la matriz "Object"
      try{
         PreparedStatement pstm = conn.prepareStatement(q);
         ResultSet res = pstm.executeQuery();
         int i = 0;
         while(res.next()){
            for(int j=0; j<=fields.split(",").length-1;j++){
                data[i][j] = res.getString( colname[j].trim() );
            }
            i++;         }
         res.close();
          }catch(SQLException e){
         System.out.println(e);
    }
    return data;
 }
    
    
/* METODO PARA INSERTAR UN REGISTRO EN LA BASE DE DATOS
 * INPUT:
	table = Nombre de la tabla
	fields = String con los nombres de los campos donde insertar Ej.: campo1,campo2campo_n
	values = String con los datos de los campos a insertar Ej.: valor1, valor2, valor_n
*/
    public DefaultTableModel getTablaSinCondicion(String tabla, String[] valoresAmostrar) throws SQLException
    {
        
        String query = "SELECT ";
        /*
            Va extrayendo las columnas a mostrar del arreglo a un string, 
            para que así pueda ser concatenado con el String query
        
        */
        /*
        for (int j=0; j<valoresAmostrar.length; j++)
        {
            query+='?';
            if (j!=valoresAmostrar.length-1)
            {
                query+=", ";
            }
        }
        */
        for (int i=0; i<valoresAmostrar.length;i++)
        {
            query+=valoresAmostrar[i];
            if (i!=valoresAmostrar.length-1)
            query+=", ";
        }
        query+= " FROM "+tabla;
    
        Vector <Object> filas;
        
        /*
        columnNombes será la fila de headers que guadará el nombre
        de las columnas extraídas en las consultas. Se usará para
        crear el modelo de tabla a devolver.
        */
        Vector<Object> columnNombres;
        
        try
        {
            System.out.println(query);
            PreparedStatement consulta = this.conn.prepareStatement(query);
            System.out.println("PS creado");
            /*
            for (int j=0; j<=valoresAmostrar.length; j++)
            {
                /*
                    LOS ÍNDICES DE COLUMNA EN ORACLE COMIENZAN DESDE 1 Y NO DESDE 0. 
                
                consulta.setString(j+1, valoresAmostrar[j]);
                System.out.println("setString hecho "+valoresAmostrar[j]);
                System.out.println(consulta.toString());
            }
            */
            System.out.println("Ejecutando...");
            ResultSet rs;
            System.out.println("RS CREADO...");
            consulta.executeQuery(query);
            System.out.println("Ejecutando...");
            rs = consulta.getResultSet();
            System.out.println("Ejecutado. Rs extraído");
            ResultSetMetaData rdata = rs.getMetaData();
            
            
            columnNombres = new Vector<Object>();
            
            System.out.println("Número de columnas a añadir: "+valoresAmostrar.length);
            for (int j=1; j<=valoresAmostrar.length; j++)
            {
                /*
                    Se añade al vector creado para almacenar los nombres de las columnas
                    los nombres de las columnas y este vector se usará para generar el 
                    modelo que devuelve la presente función, junto con los múltiples 
                    vectores de las filas
                */
                columnNombres.addElement(rdata.getColumnName(j));
                System.out.println("Añadida a vector columna: "+rdata.getColumnName(j));

            }
            
            //Esta será una matriz que almacenará las filas
            
            filas = new Vector<Object>();
            
            while (rs.next())
            {
                /*
                Se van creando vectores que almacenerán las tuplas
                junto con sus valores solicitados siempre y cuando
                rs envíe señal positiva de que tiene otra tupla
                más a mostrar, para eso sirve el método rs.next()
                */
                
                Vector <Object> filaDeTabla = new Vector<Object>(valoresAmostrar.length);
                
                for (int j=1; j<=valoresAmostrar.length;j++)
                {
                    //Se añaden los valores metadata de cada 
                    //rs.next() al vector de cafa fila
                    
                    filaDeTabla.addElement(rs.getObject(j));
                    System.out.println("Añadiendo "+rs.getObject(j));
                }
                
                /*
                Se añade la fila creada a un vector de filas,
                el cual servirá para añadirlo luego a la creación del
                modelo como matriz de filas.
                */
                
                filas.addElement(filaDeTabla);
               
            }
            rs.close();
            consulta.close();  
            //System.out.println(consulta.getResultSet().findColumn("id"));
        }catch (SQLException e)
        {
            System.out.println("Excepción desde Database_Connection: "+e.getSQLState());
            System.out.println(e.getErrorCode());
            System.out.println(e.getMessage());
            throw e;
        }
        System.out.println("Creando modelo de tabla...");
        DefaultTableModel model = new DefaultTableModel(filas, columnNombres)
        {
            @Override
            public Class getColumnClass(int column)
            {
                for (int fila = 0; fila < getRowCount(); fila++)
                {
                    Object o = getValueAt(fila, column);

                    if (o != null)
                    {
                        return o.getClass();
                    }
                }

                return Object.class;
            }
        };
        return model;
    }
    
    
    
    public boolean insertToTable(String table, String[] fields, Object[] values) throws SQLException, FileNotFoundException
    {
        boolean res=false;
        //Se arma la consulta
        //String q=" INSERT INTO " + table + " ( " + fields + " ) VALUES ( " + values + " ) ";
        //se ejecuta la consulta
        try 
        {
            String query="INSERT INTO "+table +"(";
            for (int j=0; j<fields.length;j++)
            {
                query+=fields[j].toString();
                if (j!=fields.length-1)
                {
                    query+=", ";
                }
            }
            query+=")";
            query+= "VALUES (";
            for (int j=0; j<values.length;j++)
            {
                query+="?";
                if (j!=values.length-1)
                {
                    query+=", ";
                }
            }
            query+=");";
            PreparedStatement pstm = conn.prepareStatement(query); //Evita SQL Injection
            for (int j=0; j<values.length;j++)
            {
                switch(this.whatClassIsIt(values[j]))
                {
                    case "String":
                        pstm.setString(j+1, (String) values[j]);
                        break;
                    case "BLOB":
                        FileInputStream binaryStream= this.convertImageToBLOB((File) values[j]);
                        pstm.setBinaryStream(j+1, binaryStream);
                        break;
                    case "Integer":
                        pstm.setInt(j+1, (int) values[j]);
                        break;
                    case "DATE":
                        pstm.setDate(j+1, null);
                        break;
                    default:
                        throw new SQLException();
                }
                
            }
            pstm.execute();
            pstm.close();
            return true;
         }catch(SQLException e){
             throw e;
      } catch (FileNotFoundException ex) {
            throw ex;
      }
    }
    
    private String whatClassIsIt(Object objeto)
    {
        if (objeto instanceof String)
        {
            if ((objeto.toString()).matches("\\d{2}/\\d{2}/\\d{2}"))
            {
                return "DATE";
            }
            return "String";
        }else if (objeto instanceof Integer)
        {
            return "Integer";
        }else if (objeto instanceof File)
        {
            return "BLOB";
        }
        return "NOT FOUND";
    }
    
    private FileInputStream convertImageToBLOB(File a) throws FileNotFoundException
    {
        try
        {
            FileInputStream   fis = new FileInputStream(a);
            return fis;
        }catch(FileNotFoundException e)
        {
            throw e;
        }
        /*
        Para cargar la imagen en la DB se inserta el objeto devuelto por esta función de la siguiente manera:
        PreparedStatement.setBinaryStream(3, fis, (int) image.length());
        
        donde 3 es la posición como valor arbitrario en un script (Dígase, un '?') e image.length() es el largo de bits del archivo.
        */
    }
    
    /*Función que devuelve una imagen en un buffer para su futura muestra en pantalla. Una vez se llama la función 
    que extrae el archivo BLOB, se genera un bufferedImage mediante este método y es pasado al modelo para que lo devuelva
    como un ImagenIcon utilizable por el controlador en la GUI. */
    
    private BufferedImage convertBLOBtoImage(BLOB extractedBLOB) throws SQLException, IOException
    {
        try
        {
            byte[] imgData = extractedBLOB.getBytes(1,(int)extractedBLOB.length());
            BufferedImage image = ImageIO.read(new ByteArrayInputStream(imgData));
            return image;
        }catch(SQLException | IOException e)
        {
            throw e;
        }
    }
}
    
      


