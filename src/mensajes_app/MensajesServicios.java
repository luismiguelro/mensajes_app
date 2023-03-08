/*
Esta capa de servicios es la encarga de preguntar los datos, para enviar 
a la capa de mensajes
 */
package mensajes_app;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Luis Miguel
 */
public class MensajesServicios {
    // metodos para conectar con la capa DAO
    public static void crearMensajes(){
        String mensaje  = JOptionPane.showInputDialog("Escribe tu mensaje");
        String autor  = JOptionPane.showInputDialog("Escribe tu nombre");
        
        Mensajes reg = new Mensajes();
        reg.setMensaje(mensaje);
        reg.setAutor_mensaje(autor);
        
        //Enviar a la capa DAO
        MensajesDAO.crearMensajeBD(reg);

    }
    
    public static void listarMensajes(){
       String salida = "";
       ArrayList <Mensajes> mensajes = MensajesDAO.leerMensajesBD();
       
       //recorrer y guardar en variable salida
       salida="****MENSAJES****\n";
       for(Mensajes mensaje:mensajes){
           salida+= "\nID: "+mensaje.getId_mensaje()+ "\n";
           salida+= "Mensaje: "+mensaje.getMensaje()+ "\n";
           salida+= "Autor: "+mensaje.getAutor_mensaje()+ "\n";
           salida+= "Fecha "+mensaje.getFecha_mensaje()+ "\n";
           salida +="*********************************";
       }
       JOptionPane.showMessageDialog(null,salida);
    }
    public static void borrarMensajes(){
        
        listarMensajes();
        int id_mensaje = Integer.parseInt(JOptionPane.showInputDialog(null,"Elige el ID del Mensaje que desees ELIMINAR:\n"));
        
        // validar la eliminacion del mensjae
        int validacion  = Integer.parseInt(JOptionPane.showInputDialog("Estas seguro de eliminar el mensaje : "+id_mensaje+ "\n1:Si\n2:No"));
        do{
            if(validacion == 1){
                MensajesDAO.borrarMensajesBD(id_mensaje);
                JOptionPane.showMessageDialog(null,"Mensaje Eliminado...");
                return;
            } else{
               JOptionPane.showMessageDialog(null,"Redirigiendo al menú ..."); 
            } 
        } while (validacion !=2);
            
        
    }
    
    public static void editarMensajes(){
        //Obtener mensaje y id
       String mensaje = JOptionPane.showInputDialog(null,"Escribe tu nuevo mensaje");
       int id_mensaje = Integer.parseInt(JOptionPane.showInputDialog(null,"Escribe el ID del Mensaje que desees ACTUALIZAR"));
       
       boolean idVerificar = MensajesDAO.validarId(id_mensaje);
       
       if(idVerificar == true){
            //objeto
       Mensajes actualizacion = new Mensajes();
       actualizacion.setId_mensaje(id_mensaje);
       actualizacion.setMensaje(mensaje);
       
       MensajesDAO.actualizar(actualizacion);
       } else{
           JOptionPane.showMessageDialog(null,"No existe un mensaje con el id: "+id_mensaje); 
       }
      
       
    }
    
}
