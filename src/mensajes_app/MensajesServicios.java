/*
Esta capa de servicios es la encarga de preguntar los datos, para enviar 
a la capa de mensajes
 */
package mensajes_app;

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
        MensajesDAO.leerMensajesBD();
    }
    public static void borrarMensajes(){
        
    }
    
    public static void editarMensajes(){
        
    }
    
}
