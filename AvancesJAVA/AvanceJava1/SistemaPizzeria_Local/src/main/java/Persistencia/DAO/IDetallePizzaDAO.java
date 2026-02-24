/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Persistencia.DAO;

import Negocio.DTO.DetallePizzaNuevoDTO;
import Persistencia.Dominio.DetallesPizza;
import persistencia.excepciones.PersistenciaException;

/**
 *
 * @author aaron
 */
public interface IDetallePizzaDAO {
    public DetallesPizza agregarDetallePizza(DetallesPizza detalleAgregar) throws PersistenciaException;
    
    public DetallesPizza agregarPizza(DetallesPizza detalleModificar) throws PersistenciaException;
    
    public DetallesPizza eliminarPizza(DetallesPizza detalleModificar) throws PersistenciaException;
}
