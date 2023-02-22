package mensajes_app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Luis Miguel
 */
public class MensajesDAO {
    
    // Metodos
    public static void crearMensajeBD(Mensajes mensaje){
        Conexion db_connect = new Conexion();
        
        try(Connection conexion = db_connect.conectar()){
            PreparedStatement ps = null;
            try{
                // consulta, se deja ?, porque es allí donde llegan los 
               String query = "INSERT INTO `mensajes` (mensaje`, `autor_mensaje`) VALUES (?,?,current_timestamp()));"; 
               
               ps=conexion.prepareStatement(query);
               ps.setString(1,mensaje.getMensaje());
               ps.setString(2,mensaje.getAutor_mensaje());
               ps.executeUpdate();
               JOptionPane.showMessageDialog(null,"Mensaje creado correctamente...");
            } catch (SQLException ex){
                System.out.println(ex);
      
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public static void leerMensajesBD(){
        
    }
    public static void borrarMensajesBD (int id_mensaje){
        
    }
    
    public static void actualizar(Mensajes mensaje){
        
    }
    
}
