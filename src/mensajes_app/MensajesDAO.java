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
        
         
        
        try{
            Connection cn = Conexion.conexion();
        PreparedStatement ps = cn.prepareStatement(
        "INSERT INTO mensajes VALUES (?,?,?,current_timestamp(),current_timestamp(),current_timestamp())"
        );
            ps.setInt(1,0);
            ps.setString(2,mensaje.getMensaje());
            ps.setString(3,mensaje.getAutor_mensaje());
            ps.executeUpdate();
            ps.close();
            
            JOptionPane.showMessageDialog(null,"Mensaje creado correctamente...");
        } catch (SQLException ex){
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
