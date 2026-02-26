/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mappers;

import Negocio.DTO.PizzaDTO;
import Persistencia.Dominio.Pizza;

/**
 *
 * @author Andre
 */
public class PizzaMapper {
    
    /**
     * Mapea de dto a entidad
     * @param pizzaDTO
     * @return 
     */
    public static Pizza mapearEntidad(PizzaDTO pizzaDTO) {
        
        //Valida que no sea null
        if (pizzaDTO == null) {
            return null;
        }
        
        //Crea la entidad
        Pizza pizza = new Pizza();
        
        //Hace el mapeo
        pizza.setId(pizzaDTO.getId());
        pizza.setNombre(pizzaDTO.getNombre());
        pizza.setDescripcion(pizzaDTO.getDescripcion());
        pizza.setPrecio(pizzaDTO.getPrecio());
        pizza.setEstado(pizzaDTO.getEstado());
        
        //Regresa la entidad
        return pizza;
    }
    
    
    
    /**
    * Mapea de entidad a DTO
    * @param pizza
    * @return
    */
   public static PizzaDTO mapearDTO(Pizza pizza) {

       //Valida que no sea null
       if (pizza == null) {
           return null;
       }

       //Crea el DTO
       PizzaDTO pizzaDTO = new PizzaDTO();

       //Hace el mapeo
       pizzaDTO.setId(pizza.getId());
       pizzaDTO.setNombre(pizza.getNombre());
       pizzaDTO.setDescripcion(pizza.getDescripcion());
       pizzaDTO.setPrecio(pizza.getPrecio());
       pizzaDTO.setEstado(pizza.getEstado());

       //Regresa el DTO
       return pizzaDTO;
   }
}