package clases;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author Samuel Males Williams
 */
public class MotorMatematico {
    
    //Recibe 4 textos y devuelve 1 número (o lanza un error justificando por qué falló)
    public double calcularTasaCrecimiento (String strFecha1, String strAltura1, String strFecha2, String strAltura2) throws Exception {
        if (strFecha1.isEmpty() || strAltura1.isEmpty() || strFecha2.isEmpty() || strAltura2.isEmpty()) {
            throw new Exception("Debes llenar todos los campos.");
        }
        
        try {
            double y1 = Double.parseDouble(strAltura1);
            double y2 = Double.parseDouble(strAltura2);
            
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate fecha1 = LocalDate.parse(strFecha1, formato);
            LocalDate fecha2 = LocalDate.parse(strFecha2, formato);
            
            long deltaX = ChronoUnit.DAYS.between(fecha1, fecha2);
            
            if (deltaX == 0) {
                // Usamos ArithmeticException para errores matemáticos puros
                throw new ArithmeticException("Matemáticamente inválido: Las fechas son iguales (División por cero).");
            } else if (deltaX < 0) {
                // Usamos IllegalArgumentException para reglas de negocio rotas
                throw new IllegalArgumentException("Lógica temporal invertida: La fecha #2 debe ser posterior a la fecha #1.");
            }
            
            double deltaY = y2 - y1;
            return deltaY / deltaX;
            
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Error de formato: Las alturas deben ser números.");
        } catch (DateTimeParseException e) {
            throw new Exception("Error temporal: El formato de fecha debe ser el indicado (dd/MM/yyyy).");
        }
    }
}
