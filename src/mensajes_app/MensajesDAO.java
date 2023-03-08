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
    static Connection cn = Conexion.obtenerConexion();
    static PreparedStatement ps = null;
    static ResultSet rs = null;
    // Metodos
    public static void crearMensajeBD(Mensajes mensaje){
        try{
            //sentencia para insertar
            
         ps = cn.prepareStatement(
        "INSERT INTO mensajes VALUES (?,?,?,current_timestamp(),current_timestamp(),current_timestamp())"
        );
            ps.setInt(1,0);
            ps.setString(2,mensaje.getMensaje());
            ps.setString(3,mensaje.getAutor_mensaje());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null,"Mensaje creado correctamente...");
        } catch (SQLException ex){
            System.out.println(ex);
            
        }
    }
    
    public static ArrayList<Mensajes> leerMensajesBD(){
        
        ArrayList<Mensajes> mensajes = new ArrayList<Mensajes>();
         try{
          
             ps = cn.prepareStatement(
        "SELECT * FROM mensajes"
        );
            //obtener despues de la ejecucion
             rs = ps.executeQuery();
            
            while(rs.next()){
                // añadir al array
                 Mensajes mensaje = new Mensajes();
                 mensaje.setId_mensaje(rs.getInt("id_mensaje"));
                 mensaje.setMensaje(rs.getString("mensaje"));
                 mensaje.setAutor_mensaje(rs.getString("autor_mensaje"));
                 mensaje.setFecha_mensaje(rs.getString("fecha_mensaje"));
 
                 mensajes.add(mensaje);
            }
            
               } catch (SQLException ex){
            ex.printStackTrace();
            System.out.println(ex);
            
        }
        return mensajes;
        
    }
    
    public static void borrarMensajesBD (int id_mensaje){
     
         try{
             // sentencia para eliminar
              ps = cn.prepareStatement(
        "DELETE FROM mensajes WHERE id_mensaje = ?"
        );
             ps.setInt(1,id_mensaje);
             ps.executeUpdate();
         } catch (SQLException ex){
            ex.printStackTrace();
            System.out.println(ex);
             
         }

    }
    
      
    
    public static void actualizar(Mensajes mensaje){
       
         try{
             
             //consulta para actualizar
            ps = cn.prepareStatement(
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
    }
    
    //metodo para validar id de un mensaje
    public static boolean validarId(int id){
          try{
             
             //consulta para actualizar
            ps = cn.prepareStatement(
        "SELECT *FROM mensajes WHERE id = ?;"
        );
            
             //parametros
             
             ps.setInt(1,id);
             
             //ejecutar sentencia
             ps.executeUpdate();
             rs =ps.executeQuery();
             
              
             //excepciones
         } catch (SQLException ex){
           System.out.println("No exite ID ("+ex+")");
            return false;
             
         } 
        return false;
    }
}
