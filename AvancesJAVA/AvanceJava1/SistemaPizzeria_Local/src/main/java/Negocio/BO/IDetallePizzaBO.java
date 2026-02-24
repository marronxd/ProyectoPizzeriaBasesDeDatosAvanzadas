/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Negocio.BO;

import Negocio.DTO.DetallePizzaNuevoDTO;
import Negocio.Excepciones.NegocioException;
import Persistencia.Dominio.DetallesPizza;

/**
 *
 * @author aaron
 */
public interface IDetallePizzaBO {
    
    public DetallePizzaNuevoDTO agregarDetallePizza(DetallePizzaNuevoDTO detalleAgregar) throws NegocioException;
    
    public DetallesPizza agregarPizza(DetallesPizza detalleModificar) throws NegocioException;
    
    public DetallesPizza eliminarPizza(DetallesPizza detalleModificar) throws NegocioException;
 }
