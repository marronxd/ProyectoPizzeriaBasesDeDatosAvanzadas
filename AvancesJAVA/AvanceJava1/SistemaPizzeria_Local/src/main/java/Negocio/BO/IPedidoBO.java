/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Negocio.BO;

import Negocio.DTO.DetallePizzaNuevoDTO;
import Negocio.DTO.PedidoNuevoDTO;
import Negocio.Excepciones.NegocioException;
import Persistencia.Dominio.Pedido;

/**
 *
 * @author aaron
 */
public interface IPedidoBO {
    public void cambiarEstado(Integer id, String estado) throws NegocioException;
    
    public Pedido consultarPedido(Integer id)throws NegocioException;
    
    public boolean agregarPedidoCompleto(PedidoNuevoDTO pedidoNuevo) throws NegocioException;
    
    public void agregarDetalle(DetallePizzaNuevoDTO detallePizza, Integer id_pedido) throws NegocioException;
}
