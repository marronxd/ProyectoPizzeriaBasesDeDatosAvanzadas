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
    //sin uso
    public DetallesPizza agregarDetallePizza(DetallesPizza detalleAgregar) throws PersistenciaException;
    //sin uso
    public DetallesPizza agregarPizza(DetallesPizza detalleModificar) throws PersistenciaException;
    //sin uso
    public DetallesPizza eliminarPizza(DetallesPizza detalleModificar) throws PersistenciaException;
}
