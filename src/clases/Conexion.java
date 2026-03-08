package clases;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Samuel Males Williams
 */
public class Conexion {
    public static Connection conectar () {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            String url = "jdbc:mysql://localhost/bd_biologic";
            
            String usuario = "samuel";
            String password = "bio123";
            
            Connection cn = DriverManager.getConnection(url, usuario, password);
            
            System.out.println("¡Conexion Exitosa a BioLogic!");
            return cn;
        } catch (ClassNotFoundException e) {
            System.out.println("Error: No se encontró el Driver. " + e);
            return null;
        } catch (SQLException e) {
            System.out.println("Error: No pude conectar a la BD. " + e);
            return null;
        }
    }
}
