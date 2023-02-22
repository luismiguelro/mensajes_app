package mensajes_app;
import java.sql.*;
/**
 *
 * @author Luis Miguel
 */
public class Conexion {
    //Conexion Local
    public static Connection conexion(){
        try{
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mensajes_app","root","");
            return cn;
        }catch(SQLException e){
            System.out.println("Error: "+ e);
        }
        return(null);
    }
    
}