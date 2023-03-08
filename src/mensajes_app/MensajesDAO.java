package mensajes_app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
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
            Connection cn = Conexion.obtenerConexion();
        PreparedStatement ps = cn.prepareStatement(
        "INSERT INTO mensajes VALUES (?,?,?,current_timestamp(),current_timestamp(),current_timestamp())"
        );
            ps.setInt(1,0);
            ps.setString(2,mensaje.getMensaje());
            ps.setString(3,mensaje.getAutor_mensaje());
            ps.executeUpdate();
            
            Conexion.cerrarConexion();
            
            JOptionPane.showMessageDialog(null,"Mensaje creado correctamente...");
        } catch (SQLException ex){
            System.out.println(ex);
            
        }
    }
    
    public static ArrayList<Mensajes> leerMensajesBD(){
        
        ArrayList<Mensajes> mensajes = new ArrayList<Mensajes>();
         try{
            Connection cn = Conexion.obtenerConexion();
            PreparedStatement ps = cn.prepareStatement(
        "SELECT * FROM mensajes"
        );
            //obtener despues de la ejecucion
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                // añadir al array
                 Mensajes mensaje = new Mensajes();
                 mensaje.setId_mensaje(rs.getInt("id_mensaje"));
                 mensaje.setMensaje(rs.getString("mensaje"));
                 mensaje.setAutor_mensaje(rs.getString("autor_mensaje"));
                 mensaje.setFecha_mensaje(rs.getString("fecha_mensaje"));
 
                 mensajes.add(mensaje);
            }
            
            Conexion.cerrarConexion();

        } catch (SQLException ex){
            ex.printStackTrace();
            System.out.println(ex);
            
        }
        return mensajes;
        
    }
    
    public static void borrarMensajesBD (int id_mensaje){
        Connection cn = Conexion.obtenerConexion();
         try{
             PreparedStatement ps = cn.prepareStatement(
        "DELETE FROM mensajes WHERE id_mensaje = ?"
        );
             ps.setInt(1,id_mensaje);
             ps.executeUpdate();
         } catch (SQLException ex){
            ex.printStackTrace();
            System.out.println(ex);
             
         }
        
        Conexion.cerrarConexion();
    }
    
      
    
    public static void actualizar(Mensajes mensaje){
        Connection cn = Conexion.obtenerConexion();
         try{
             
             //consulta para actualizar
             PreparedStatement ps = cn.prepareStatement(
        "UPDATE mensajes SET mensaje = ? WHERE id_mensaje =?"
        );
            
             //parametros
             ps.setString(1, mensaje.getMensaje());
             ps.setInt(2,mensaje.getId_mensaje());
             
             //ejecutar sentencia
             ps.executeUpdate();
             
              JOptionPane.showMessageDialog(null,"Mensaje actulizado correctamente...");
              
             //excepciones
         } catch (SQLException ex){
            ex.printStackTrace();
            System.out.println(ex);
             
         }
        
        Conexion.cerrarConexion();
        
    }
    
}
