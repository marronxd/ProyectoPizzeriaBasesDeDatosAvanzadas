package persistencia.excepciones;

/**
 * Una excepción en el sistema
 */
public class PersistenciaException extends Exception{

    //Constructores
    public PersistenciaException() {
        
    }

    public PersistenciaException(String message) {
        super(message);
    }

    public PersistenciaException(String message, Throwable cause) {
        super(message, cause);
    }
}