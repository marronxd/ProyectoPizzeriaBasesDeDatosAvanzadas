package Validaciones;

import Persistencia.Dominio.Telefono;
import static Validaciones.Util.tamanioStringValido;

/**
 * Validaciones atómicas de teléfono
 * @author Andre
 */
public class ValidacionesTelefono {
    
    
    /**
     * Valida que un número tel sean 10 digitos
     * @param numero
     * @return 
     */
    public static boolean validarTamanioNumero(String numero) {
        
        //Si es null o vacio
        if (Util.stringNullVacio(numero)) {
            return false;
        }
        
        //Variables
        int tamanio = 10;
        
        //Valida rango de string
        return tamanioStringValido(numero, tamanio);
    }
    
    
    
    /**
     * Valida que solo sean numeros
     * @param numero
     * @return 
     */
    public static boolean sonPurosNumeros(String numero) {
        return numero.chars().allMatch(Character::isDigit);
    }
    
    
    
    /**
     * Valida la etiqueta con tamaño correcto
     * @param etiqueta
     * @return 
     */
    public static boolean validarFormatoEtiqueta(String etiqueta) {
        
        //Si es null o vacio
        if (Util.stringNullVacio(etiqueta)) {
            return false;
        }
        
        //Variables
        int max = 100;
        
        //Valida rango de string
        return Util.rangoStringValido(etiqueta, max);
    }
}