package clases;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Samuel Males 
 */
public class PlantaDAO {
    
    // Recibe el estado que se quiera buscar y devuelve el total.
    // Aplicamos el principio DRY para no escribir 3 consultas distintas.
    public int contarPlantasEstado (String estadoPlanta) {
        int cantidad = 0;
        
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "SELECT COUNT(*) FROM plantas WHERE estatus  = ?"
            );
            
            pst.setString(1, estadoPlanta);
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                // El ídice 1 extrae el resultado matemático del COUNT(*)
                cantidad = rs.getInt(1);
            }
            cn.close();
            
        } catch (SQLException e) {
            System.err.println("Erro en contarPlantasEstado (PlantaDAO): " + e);
        }
        return cantidad;
    }
    
    public int contarPlantasNoArchivadas () {
        int cantidad = 0;
        
        try {
            Connection cn = Conexion.conectar();
           PreparedStatement pst = cn.prepareStatement(
                   "SELECT COUNT(*) FROM plantas WHERE estatus != 'Archivada'"
           );
           ResultSet rs = pst.executeQuery();
           
            if (rs.next()) {
                cantidad = rs.getInt(1);
            }
            cn.close();
            
        } catch (SQLException e) {
            System.err.println("Error en contarPlantasNoArchivadas (PlantaDAO): " + e);
        }
        return cantidad;
    } 
}
