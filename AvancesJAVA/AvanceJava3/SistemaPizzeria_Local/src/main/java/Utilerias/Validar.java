package Utilerias;
import java.lang.reflect.Field;

/**
 * Clase de utilerías que sirve para realizar diferentes validaciones
 */
public class Validar {
    
    /**
     * Método reflexión: el programa revisa su propia estructura en ejecución
     * Va inspeccionando los atributos: primero de la clase, luego su superclase, así hasta que acabe
     * Valida que no existan Strings nulos o campos vacíos
     * Útil para teléfonos, domicilios, clientes
     * @param objeto
     * @return si es válido o no
     */
    public static boolean stringsValidos(Object objeto) {
        try {
            
            //Obtiene el metadato de la clas en ejecución
            Class<?> clase = objeto.getClass();

            //Mientras aún haya clases padre
            while (clase != null) {
            
                //Inicia un For each
                for (Field campo: //Field representa el atributo en medio de la ejecución del programa (metadato)
                                clase.getDeclaredFields()) { //Obtiene todos los atributos del objeto

                    //Valida si los atributos fueron declarados como String
                    if (campo.getType().equals(String.class)) {

                        //Rompe la protección y accede a los datos, incluso si son privados
                        campo.setAccessible(true);

                        //Castea el atributo en String usarlo
                        String valor = (String)campo.get(objeto);

                        //Valida si el String está nulo o vacío
                        if (stringNullVacio(valor)) {
                            return false;
                        }
                    }
                }
                //Accede a su clase padre para seguir el proceso
                clase = clase.getSuperclass();
            }
                
        //Excepción si hubo error    
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Error examinando el objeto", e);
        }
        
        //Si todos los Strings son válidos, regresa verdadero
        return true;
    }
    
    
    
    /**
     * Valida que un código postal conste de 5 dígitos
     * @param codigoPostal
     * @return si es válido o no
     */
    public static boolean codigoPostalValido(String codigoPostal) {
        
        //Valida que no sea nulo o vacío
        if (stringNullVacio(codigoPostal)) {
            return false;
        }

        //Regex: cinco dígitos
        String regex = "^\\d{5}$";
        
        //Valida si cumple con el regex
        return codigoPostal.trim().matches(regex);
    }
    
    
    
    /**
     * Valida que un número telefónico conste de 5 dígitos
     * @param numero
     * @return si es válido o no
     */
    public static boolean numeroValido(String numero) {
        
        //Valida que no sea nulo o vacío
        if (stringNullVacio(numero)) {
            return false;
        }

        //Regex: diez dígitos
        String regex = "^\\d{10}$";
        
        //Valida si cumple con el regex
        return numero.trim().matches(regex);
    }
    
    
    
    /**
     * Valida que un String no sea nulo o esté vacío
     * @param string
     * @return si es válido o no
     */
    public static boolean stringNullVacio(String string) {
        return (string == null || string.isBlank());
    }
}