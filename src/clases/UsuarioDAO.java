package clases;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Samuel Males Williams.
 */
public class UsuarioDAO {
    // Este método recibirá el usuario y la contraseña desde la ventana,
    // irá a la base de datos, y devolverá el ROL (Nivel de Permiso) si es correcto,
    // o devolverá un texto vacío ("") si las credenciales son incorrectas.
    public String validarLogin (String username, String password) {
        String nivelPermiso = "";
        
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "SELECT nivel_permiso, estatus FROM usuarios WHERE nombre_usuario = ? AND password = ?"
            );
            
            // Los signos de interrogación (?) protegen contra ataques de Inyección SQL
            pst.setString(1, username);
            pst.setString(2, password);
            
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                // Verificamos si el usuario no fue dado de baja (Borrado Lógico)
                String estatus = rs.getString("estatus");
                if (estatus.equalsIgnoreCase("Activo")) {
                    nivelPermiso = rs.getString("nivel_permiso");
                } else {
                    nivelPermiso = "INACTIVO";
                }
            }
            cn.close();
            
        } catch (Exception e) {
            System.err.println("Error en validarLogin (UsuarioDAO): " + e);
            nivelPermiso = "ERROR_BD";
        }
        
        return nivelPermiso;
    }
}
