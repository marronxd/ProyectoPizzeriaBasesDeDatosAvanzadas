/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Negocio.BO;

import Negocio.Excepciones.NegocioException;
import Persistencia.Dominio.Pedido;

/**
 *
 * @author aaron
 */
public interface IPedidoBO {
    public void cambiarEstado(Integer id, String estado) throws NegocioException;
    
    public Pedido consultarPedido(Integer id)throws NegocioException;
}
