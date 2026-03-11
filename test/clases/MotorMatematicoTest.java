package clases;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Samuel Males Williams
 */
public class MotorMatematicoTest {

    // Prueba 1: Crecimiento normal esperado
    @Test
    public void testCrecimientoNormal () throws Exception {
        
        MotorMatematico motor = new MotorMatematico();
        //Si crece de 10cm a 20cm en 10 días, la tasa debe ser 1.0cm por día
        double resultado = motor.calcularTasaCrecimiento("01/01/2026", "10", "11/01/2026", "20");
        
        assertEquals(1.0, resultado , 0.01);
    }
    
    // Prueba 2: Validar el bloqueo de División por Cero
    // Le indicamos a JUnit que esta prueba SOLO es exitosa si el motor lanza ArithmeticException
    @Test(expected = ArithmeticException.class)
    public void testDivisionPorCero() throws Exception {
        MotorMatematico motor = new MotorMatematico();
        // Al enviar la misma fecha, el motor debe estallar y lanzar el error matemático
        motor.calcularTasaCrecimiento("15/05/2026", "15.5", "15/05/2026", "20.0");
    }
}
