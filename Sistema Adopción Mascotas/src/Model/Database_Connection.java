

package Model;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import static java.sql.JDBCType.BLOB;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
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
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
            throw e;
        }         
    }
    
    public void setConnection(int tipoConexion)throws SQLException
    {
        try 
        {
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
        }catch (SQLException e)
            {
                throw e;
            }
    }
    
    
    
    public Connection getConnection()
    {
        return this.conn;
    }
    
    public void endConnection() throws SQLException
    {
        try {
            this.conn.close();
        } catch (SQLException ex) {
            throw ex;
        }
    }
    
    public ResultSet callProcedure(String comando)
    {
        try
        {
            catch(comando)
            {
                case "Insertar Mascota":
                    
                    
            }
        }
    }
    
    public void callFunction(String comando)
    {
        
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
    public ResultSet getTablaSinCondicion(String tabla, String[] valoresAmostrar) throws SQLException
    {
        
        String query = "SELECT ";
        /*
            Va extrayendo las columnas a mostrar del arreglo a un string, 
            para que así pueda ser concatenado con el String query
        
        for (int j=0; j<valoresAmostrar.length; j++)
        {
            query+=valoresAmostrar[j];
            if (j!=valoresAmostrar.length-1)
            {
                query+=", ";
            }
        }
        */
        for (int j=0; j<valoresAmostrar.length; j++)
        {
            query+='?';
            if (j!=valoresAmostrar.length-1)
            {
                query+=", ";
            }
        }
        query+= " FROM "+tabla+";";
        try{
            System.out.println(query);
            PreparedStatement consulta = this.conn.prepareStatement(query);
            System.out.println("PS creado");
            System.out.println(valoresAmostrar.length);
            for (int j=1; j<=valoresAmostrar.length+1; j++)
            {
                /*
                    LOS ÍNDICES DE COLUMNA EN ORACLE COMIENZAN DESDE 1 Y NO DESDE 0. 
                */
                consulta.setString(j, valoresAmostrar[j-1]);
                System.out.println("setString hecho");

            }
            System.out.println(consulta.toString());
            consulta.execute();
            System.out.println(consulta.getResultSet().findColumn(id));
            return consulta.getResultSet();
        }catch (SQLException e)
        {
            System.out.println("Excepción desde Database_Connection: "+e.getSQLState());
            System.out.println(e.getErrorCode());
            System.out.println(e.getMessage());
            throw e;
        }
    }
    
    
    
    public boolean insertToTable(String table, String[] fields, Object[] values) throws SQLException
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
      return true;
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
        donde 3 es la posición como valor arbitrario en un script (Dígase, un '?') e image.lenght() es el largo de bits del archivo.
        */
    }
    
    private Image convertBLOBtoImage(BLOB extractedBLOB) throws SQLException
    {
             Connection con = null;
     PreparedStatement pstmt  = null;
     ResultSet rs = null;

     
     Blob imageBlob = null;
     String query = "select it.IMAGE_BLOB from IMAGE_TABLE it where it.IMAGE_ID = ?";

     try{

        this.setConnection(1);

        pstmt = con.prepareStatement(query);
        pstmt.setObject(1,imageId);

        rs = pstmt.executeQuery();

        if(rs.next()){

             Object obj = rs.getObject(1);
             
             if(obj instanceof Blob)
                 imageBlob = new javax.sql.SerialBlob((Blob)obj);
             

        } 

     }catch(Exception exp){

         exp.printStackTrace();

     }finally{

          if(rs != null){
             try{rs.close();}catch(Exception exp){};
          } 


          if(pstmt != null){
             try{pstmt.close();}catch(Exception exp){};
          } 

          if(con != null){
             try{con.close();}catch(Exception exp){};
          }
        Blob blob =  FileDAO.getFactoryObject().getImageData("746ABBGGA23");
        int length = (int)blob.length(); 
        byte buffer[] = blob.getBytes(1,length);
        ImageIcon imageIcon = new ImageIcon(buffer);
}

        
    }
}
    
      


