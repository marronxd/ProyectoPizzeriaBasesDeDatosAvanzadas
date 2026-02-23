/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio.fabrica;

import Negocio.BO.IPedidoBO;
import Negocio.BO.PedidoBO;

/**
 *
 * @author aaron
 */
public class FabricaBO {
    
    public static IPedidoBO obtenerPedidoBO(){
        IPedidoBO tecnico = new PedidoBO(FabricaDAO.obtenerPedidoDAO());
        return tecnico;
    }
}
