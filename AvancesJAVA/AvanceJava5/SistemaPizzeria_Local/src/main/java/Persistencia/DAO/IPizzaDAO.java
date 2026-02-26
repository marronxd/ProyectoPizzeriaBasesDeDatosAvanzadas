package Persistencia.DAO;
import Persistencia.Dominio.Pizza;
import java.util.ArrayList;
import persistencia.excepciones.PersistenciaException;

/**
 * Interfaz para pizza DAO
 */
public interface IPizzaDAO {
    
    public ArrayList<Pizza> consultarPizzas() throws PersistenciaException;
}
