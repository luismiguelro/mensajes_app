package mensajes_app;

import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Luis Miguel
 */
public class Mensajes_app {
    public static void main(String[] args) {
        
        String menu = "------------------------------------\n" +
                        "Aplicación de Mensajes\n" +
                        "1.Crear un Mensaje\n" +
                        "2.Listar Mensaje\n" +
                        "3.Eliminar Mensaje\n" +
                        "4.Editar Mensaje\n" +
                        "0.Salir\n"+
                        "Ingresa una opción";
        int opcion=0;
        
        
        
        do{
            
            opcion  = Integer.parseInt(JOptionPane.showInputDialog(menu));
            switch(opcion){
                case 1:
                    MensajesServicios.crearMensajes();
                    break;
                case 2:
                    MensajesServicios.listarMensajes();
                    break;
                case 3:
                   MensajesServicios.borrarMensajes();
                    break;
                case 4: 
                    MensajesServicios.editarMensajes();
                    break;
                case 0: JOptionPane.showMessageDialog(null,"Hasta pronto... :)");
                        break;
            }
        }while(opcion != 0);
       
    }
    
}
