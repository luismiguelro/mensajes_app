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
        do {
            try {
                /*Tomar opcion del usuario*/
                opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));
                switch(opcion) {
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
                    case 0:
                        JOptionPane.showMessageDialog(null,"Hasta pronto... :)");
                        break;
                        /*validar si ingresa una opcion que no este en el menu*/
                    default:
                        JOptionPane.showMessageDialog(null,"Opción inválida");
                        break;
                }
                /*Si se ingresa una cadena que no representa un número, se lanzará una excepción */
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ingrese un número válido");
          while(opcion != 0);

    }
    
}
