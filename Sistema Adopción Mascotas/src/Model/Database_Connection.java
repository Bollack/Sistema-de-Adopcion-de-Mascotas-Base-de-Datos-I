

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
    
    private String direccion =  "jdbc:oracle:thin:@192.168.0.101:1521:DBprueba";//"jdbc:oracle:thin:@186.176.166.148:1521:DBprueba";
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
    public boolean callProcedure(String comando,Object[] parametros) throws SQLException
    {
        try
        {
            switch(comando)
            {
                case "Insertar usuario-persona":
                    String llamado = "{CALL INSERT_USER(?,?)";
                    CallableStatement storedPro = this.conn.prepareCall(llamado);
                    storedPro.setString(1, (String) parametros[0]);
                    storedPro.setString(2, (String) parametros[1]);
                    try{
                        storedPro.execute();
                        llamado = "{CALL INSERT_USER(?,?,?,?,?,?,?,?)";
                        storedPro = this.conn.prepareCall(llamado);
                        storedPro.setString(1, (String) parametros[0]);
                        storedPro.setString(2, (String) parametros[1]);
                        storedPro.setString(3, (String) parametros[2]);
                        storedPro.setString(4, (String) parametros[3]);
                        storedPro.setString(5, (String) parametros[4]);
                        storedPro.setString(6, (String) parametros[5]);
                        storedPro.setString(7, (String) parametros[6]);
                        storedPro.setString(8, (String) parametros[7]);
                        storedPro.executeQuery();
                        return true;
                    }catch(SQLException e){
                        throw e;
                    }

                        llamado = "{CALL INSERT_USER(?,?,?,?,?,?,?,?)";
                    storedPro = this.conn.prepareCall(llamado);
                case "Modificar usuario-persona":
                    String llamado = "Ñ"
                    CallableStatement storedPro = this.conn.prepareCall(llamado);
                    
                case "Insertar Mascota":
                    String llamado = "{call INSERT_MASCOTA(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
                    /*
                    Genera una conexión con el atributo conexion y prepara
                    la llamada con el string definido anteriormente, el cual
                    establece el query a consultar y definiendo parámetros
                    "?", donde el primero será el resultado de la función 
                    */
                    CallableStatement storedPro = this.conn.prepareCall(llamado);
                    break;
                case "Registrar Mascota":
                    CallableStatement storedPro = this.conn.prepareCall(llamado);
                case "Generar Adopcion":
                    CallableStatement storedPro = this.conn.prepareCall(llamado);
                case "Generar Formulario":
                    CallableStatement storedPro = this.conn.prepareCall(llamado);
                case "Devolver Mascota":                   
                    CallableStatement storedPro = this.conn.prepareCall(llamado);
                    
            }
            return true;
        }catch(SQLException e)
        {
            throw e;
        }
    }
    

    
    public Object callFunction(String comando, Object[] parametros) throws SQLException, NullPointerException 
    {
        try
        {
            /*
            Se define valores que se usarán en todos los casos posibles, 
            por lo tanto, se definen fuera del switch.
            */
            String llamado;
            CallableStatement stmt;
            
            
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
                    stmt.setString(2, llamado);
                    stmt.setString(3, llamado);
                    /*
                    Registra el parámetro extraído, el cual es el primer parámetro
                    predeterminado en el string llamado y se asegura que sea un
                    booleano.
                    */
                    stmt.registerOutParameter(1, java.sql.Types.BOOLEAN);
                    
                    stmt.execute();
                    //Devuelve dicho parámetro.
                    return stmt.getBoolean(1);
                case "Check if username exists":
                    llamado = "{? = call check_existing_username(?)}";
                    /*
                    Procedimiento similar al case pasado. 
                    */
                    stmt = this.conn.prepareCall(llamado);
                     
                    String user = (String) parametros[0];
                    stmt.setString(2, user);
                    
                    stmt.registerOutParameter(1, java.sql.Types.BOOLEAN);
                    
                    stmt.execute();
                    
                    return stmt.getBoolean(1);
                case "Get ID from Username - Persona":
                    
                case "Get name from ID - Persona":
                    
                case "Get Foto actual from ID - Mascota":
                    
                case "Get Foto antes from ID - Mascota":
                case "":
                    
                default :
                    throw new NullPointerException();
                    
            }
        }catch (SQLException e)
        {
            throw e;
        }
        
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
        query+= "* FROM "+tabla;
    
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
            a.le
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
    
      


