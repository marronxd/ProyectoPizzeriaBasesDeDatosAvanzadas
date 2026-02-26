package Validaciones;

import Persistencia.Dominio.Domicilio;
import static Validaciones.Util.rangoStringValido;
import static Validaciones.Util.tamanioStringValido;
import static Validaciones.Util.validarRangoStrings;

/**
 *
 * @author Andre
 */
public class ValidacionesDomicilio {
    
    
    /**
     * Valida que todos los Strings de domicilio no superen los 100 caracteres
     * @param domicilio
     * @return 
     */
    public static boolean validarStringsDomicilio(Domicilio domicilio) {
        return validarRangoStrings(domicilio, 100);
    }
    
    
    
    /**
     * Valida que el código postal sea válido
     * @param codigoPostal
     * @return 
     */
    public static boolean validarCodigoPostal(String codigoPostal) {
        if (codigoPostal == null) {
            return false;
        }
        int tamanio = 5;
        return tamanioStringValido(codigoPostal, tamanio);
    }
}