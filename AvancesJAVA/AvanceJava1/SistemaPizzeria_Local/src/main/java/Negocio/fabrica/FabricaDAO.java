/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio.fabrica;

import Persistencia.Conexion.ConexionBD;
import Persistencia.Conexion.IConexionBD;
import Persistencia.DAO.CuponDAO;
import Persistencia.DAO.ICuponDAO;
import Persistencia.DAO.IPedidoDAO;
import Persistencia.DAO.PedidoDAO;

/**
 *
 * @author aaron
 */
public class FabricaDAO {
    private static IConexionBD conexionBD = new ConexionBD();
    
    
    // metodo para obtener la interfaz
    public static IPedidoDAO obtenerPedidoDAO(){
        // se inyecta la dependencia
        IPedidoDAO pedidoDAO = new PedidoDAO(conexionBD);
        return pedidoDAO;
        
    }
    //para obtener la interfaz del cupon
    public static ICuponDAO obtenerCuponDAO(){
        ICuponDAO cuponDAO = new CuponDAO(conexionBD);
        return cuponDAO;
    }
    
}
