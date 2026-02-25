package Validaciones;

import Persistencia.Dominio.Cliente;
import static Validaciones.Util.validarRangoStrings;

/**
 *
 * @author Andre
 */
public class ValidacionesCliente {
    
    
    /**
     * Valida que todos los Strings de cliente no superen los 100 caracteres
     * @param cliente
     * @return 
     */
    public static boolean validarStringsCliente (Cliente cliente) {
        return validarRangoStrings(cliente, 100);
    }
}
