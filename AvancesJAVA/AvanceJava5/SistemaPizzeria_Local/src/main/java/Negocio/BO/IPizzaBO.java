package Negocio.BO;
import Negocio.DTO.PizzaDTO;
import java.util.ArrayList;
import negocio.excepciones.NegocioException;

/**
 * Interfaz para pizzas
 * @author Andre
 */
public interface IPizzaBO {
    
    /**
     * Consulta todas las pizzas
     * @return
     * @throws NegocioException 
     */
    public ArrayList<PizzaDTO> consultarPizzas() throws NegocioException;
}