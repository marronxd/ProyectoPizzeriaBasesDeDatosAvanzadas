/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.sistemapizzeria_local;


import Negocio.BO.IPedidoBO;
import Negocio.DTO.DetallePizzaNuevoDTO;
import Negocio.DTO.PedidoNuevoDTO;
import Negocio.Excepciones.NegocioException;
import Negocio.fabrica.FabricaBO;
import Persistencia.Dominio.Pedido;
import Persistencia.Dominio.Pizza;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Andre
 */
public class SistemaPizzeria_Local {

    public static void main(String[] args) {
        //crear pedido bo
        IPedidoBO  pedidoBO = FabricaBO.obtenerPedidoBO();
        
        // crear dto
        // PedidoNuevoDTO pedido = new PedidoNuevoDTO("Tarjeta", 0, 0, "Programado", "Pendiente", LocalDate.now(), null, 1);
        // crear dto 
        
        try {
            /**
            Pedido pedido = pedidoBO.consultarPedido(2);
            System.out.println("consulta: " + pedido.toString());
            System.out.println("==============");
            
            List<DetallePizzaNuevoDTO> listaDetalle = new ArrayList<DetallePizzaNuevoDTO>();
            Pizza pizza = new Pizza(1, "xd", "Grande", "sisi", 100, "Disponible");
            
            DetallePizzaNuevoDTO d1 = new DetallePizzaNuevoDTO(1, 200, "Grande", "ninguna", pizza.getId());
            
            listaDetalle.add(d1);
            
            
            PedidoNuevoDTO pedido2 = new PedidoNuevoDTO("Efectivo", listaDetalle);
            pedidoBO.agregarPedidoCompleto(pedido2);
            System.out.println(pedido2.toString());
            */
            
            pedidoBO.cambiarEstado(6, "Entregado");
        } catch (NegocioException ex) {
            System.getLogger(SistemaPizzeria_Local.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
      
        
    }
}
