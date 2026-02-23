/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.sistemapizzeria_local;

import Negocio.BO.IPedidoBO;
import Negocio.DTO.PedidoNuevoDTO;
import Negocio.Excepciones.NegocioException;
import Negocio.fabrica.FabricaBO;
import Persistencia.Dominio.Pedido;
import java.time.LocalDate;

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
            Pedido pedido = pedidoBO.consultarPedido(2);
            System.out.println("consulta: " + pedido.toString());
        } catch (NegocioException ex) {
            System.getLogger(SistemaPizzeria_Local.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
       
    }
}
