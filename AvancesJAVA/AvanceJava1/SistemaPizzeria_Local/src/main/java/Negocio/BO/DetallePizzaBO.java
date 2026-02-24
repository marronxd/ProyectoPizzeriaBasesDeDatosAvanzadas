/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio.BO;

import Negocio.DTO.DetallePizzaNuevoDTO;
import Negocio.Excepciones.NegocioException;
import Persistencia.DAO.IDetallePizzaDAO;
import Persistencia.Dominio.DetallesPizza;
import java.util.logging.Logger;

/**
 *
 * @author aaron
 */
public class DetallePizzaBO implements IDetallePizzaBO{
    private final IDetallePizzaDAO detalleDAO;
    private final Logger Log = Logger.getLogger(DetallePizzaBO.class.getName());
    
    //constructor 
    public DetallePizzaBO(IDetallePizzaDAO detalleDAO){
        this.detalleDAO = detalleDAO;
    }
    
    @Override
    public DetallePizzaNuevoDTO agregarDetallePizza(DetallePizzaNuevoDTO detalleAgregar)throws NegocioException{
        if(detalleAgregar == null){
            Log.warning("Detalle pizza vacío.");
            throw new NegocioException("Detalle pizza vacio.");
        }
        // 1.- Mappeo de entidad
        DetallesPizza detallePizza = new DetallesPizza();
        
        detallePizza.setCantidad(detalleAgregar.getCantidad());
        detallePizza.setTamanio(detalleAgregar.getTamaño().trim());
        detallePizza.setId_pizza(detalleAgregar.getId_pizza());
        detallePizza.setNotas(detalleAgregar.getNotas().trim());
        
        // 2.- Enviar al DAO
        
        // 3.- validar de regreso
        
        // 4.- mapear dto
        return null;
    }
    @Override
    public DetallesPizza agregarPizza(DetallesPizza detalleModificar) throws NegocioException{
        return null;
    }
    @Override
    public DetallesPizza eliminarPizza(DetallesPizza detalleModificar) throws NegocioException{
        return null;
    }
}
