/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio.BO;

import static Mappers.PizzaMapper.mapearDTO;
import Negocio.DTO.PizzaDTO;
import Persistencia.DAO.IPizzaDAO;
import Persistencia.Dominio.Pizza;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import negocio.excepciones.NegocioException;
import persistencia.excepciones.PersistenciaException;

/**
 *
 * @author Andre
 */
public class PizzaBO implements IPizzaBO{
    
    
    //El DAO de su clase
    private final IPizzaDAO pizzaDAO;
    
    //Logger para registrar sucesos
    private static final Logger LOG = Logger.getLogger(PizzaBO.class.getName());
    
    //Constante del nombre de la entidad que maneja el archivo para centralizar LOGs
    private static final String CLASE = "las pizzas";
    

    
    
    /**
     * Constructor que agrega el DAO 
     * @param pizzaDAO
     */
    public PizzaBO(IPizzaDAO pizzaDAO) {
        this.pizzaDAO = pizzaDAO;
    }
    
    
    
    /**
     * Obtiene en una lista todas las pizzas
     * @return
     * @throws NegocioException 
     */
    @Override
    public ArrayList<PizzaDTO> consultarPizzas() throws NegocioException {
        
        //Try para consultar
        try {
            
            //Llama al DAO y obtiene una lista de teléfonos
            ArrayList<Pizza> pizzasObtenidas = this.pizzaDAO.consultarPizzas();
            
            //Crea una lista de telefonoDTO
            ArrayList<PizzaDTO> pizzasDTO = new ArrayList<>();
            
            //Itera sobre los teléfonos y los valida para después mapearlos a DTO
            for (Pizza pizza: pizzasObtenidas) {
                if (pizza == null || pizza.getId() == null) {
                    throw new NegocioException("No se pudo consultar " + CLASE);
                }
                pizzasDTO.add(mapearDTO(pizza));
            }
            
            //Regresa la lista con las pizzas mapeados
            return pizzasDTO;
            
        //Encapsula la excepción de persistencia en una de negocio    
        } catch (PersistenciaException ex) {
            LOG.log(Level.SEVERE, "Error de persistencia al consultar " + CLASE, ex);
            throw new NegocioException("Error al consultar " + CLASE, ex);
        }
    }
}