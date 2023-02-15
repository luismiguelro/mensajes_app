package mensajes_app;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Luis Miguel
 */
public class Mensajes_app {
    public static void main(String[] args) {
       // validar
       Conexion conexion = new Conexion();
       try(Connection cn = conexion.conectar()){
       
       }catch(SQLException e){
            System.out.println("Error: "+ e);
       } 
    }
    
}
