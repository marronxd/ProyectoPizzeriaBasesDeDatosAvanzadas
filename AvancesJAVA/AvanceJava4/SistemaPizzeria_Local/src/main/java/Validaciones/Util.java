package Validaciones;
import java.lang.reflect.Field;

/**
 * Clase de utilerías que sirve para realizar diferentes validaciones
 */
public class Util {
    
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
     * Método reflexión: el programa revisa su propia estructura en ejecución
     * Va inspeccionando los atributos: primero de la clase, luego su superclase, así hasta que acabe
     * Valida que no existan Strings nulos o campos vacíos y que no excedan un límite
     * Útil para los atributos de clientes
     * @param objeto
     * @param max
     * @return si es válido o no
     */
    public static boolean validarRangoStrings(Object objeto, int max) {
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
                        
                        //Valida que el String no sobrepase el tope
                        if (!rangoStringValido(valor, max)) {
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
     * Valida que un string esté en un rango, o sea que tenga un maximo válido
     * @param string
     * @param maximo
     * @return 
     */
    public static boolean rangoStringValido(String string, int maximo) {
        if (stringNullVacio(string)) {
            return false;
        }

        int longitud = string.trim().length();
        return longitud >= 1 && longitud <= maximo;
    }
    
    
    
    /**
     * Valida que un String sea de cierto tamaño fijo
     * @param string
     * @param tamanio
     * @return 
     */
    public static boolean tamanioStringValido(String string, int tamanio) {
        if (stringNullVacio(string)) {
            return false;
        }

        int longitud = string.trim().length();
        return longitud == tamanio;
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