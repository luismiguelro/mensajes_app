package mensajes_app;
import java.sql.*;
/**
 *
 * @author Luis Miguel
 */

public class Conexion {
   //variables de instancia para almacenar la conexión
   private static Connection conexion = null;
   private static String url = "jdbc:mysql://localhost:3306/mensajes_app";
   private static String usuario = "root";
   private static String password = "";

   //Constructor privado para evitar que se instancie directamente
   private Conexion() {}

   //Método estático para obtener la instancia única
   public static Connection obtenerConexion() {
      if (conexion == null) {
         try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection(url, usuario, password);
         } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
         }
      }
      return conexion;
   }

   //Método para cerrar la conexión
   public static void cerrarConexion() {
      if (conexion != null) {
         try {
            conexion.close();
            conexion = null;
         } catch (SQLException e) {
            e.printStackTrace();
         }
      }
   }
}

