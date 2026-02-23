/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio.BO;

import Negocio.Excepciones.NegocioException;
import Persistencia.DAO.IPedidoDAO;
import Persistencia.Dominio.Pedido;
import java.util.List;
import java.util.logging.Logger;
import persistencia.excepciones.PersistenciaException;

/**
 *
 * @author aaron
 */
public class PedidoBO implements IPedidoBO{
    
    private final IPedidoDAO pedidoDAO;
    private final Logger Log = Logger.getLogger(PedidoBO.class.getName());
    
    // inicia la conexion con la interfaz de pedido dao
    public PedidoBO(IPedidoDAO pedido){
        this.pedidoDAO = pedido; //inyeccion de dependencia
    }
    
    @Override
    public void cambiarEstado(Integer id, String estado) throws NegocioException{
        if(id == null){
            Log.warning("El id introducido es nulo.");
            throw new NegocioException("El id buscado es nulo");
        }
        if(estado == null){
            Log.warning("El estado es nulo.");
            throw new NegocioException("El estado es nulo");
        }
        // auxiliar
        // Validar estados permitidos  - - jeje, sí, lo busque en internet
        List<String> estadosValidos = List.of(
            "Listo",
            "No reclamado",
            "Entregado",
            "Cancelado",
            "Pendiente",
            "No entregado"
        );
        
        // si el estado no esta registrado dentro de su dominio
        if (!estadosValidos.contains(estado)){
            Log.warning("Estado invalido");
            throw new NegocioException("Estado invalido");
        }
        
        
        
        // crear la entidad con 
        try{
            Pedido pedidoCambiar = this.pedidoDAO.consultarPedido(id);
            if (pedidoCambiar == null) {
                throw new NegocioException("Pedido no encontrado.");
            }
            // se extrae el estado original del pedido
            String estadoActual = pedidoCambiar.getEstado();
            
            // se valida que dicho estado no esté finalizado
            if(estadoActual.equals("Entregado") || estadoActual.equals("Cancelado")){
                Log.warning("Estados finalizados");
                throw new NegocioException("No se puede modificar un estado finalizado");
            }
            
            //se modifica la entidad 
            this.pedidoDAO.cambiarEstado(id, estado);
            
        }catch(PersistenciaException ex){
            Log.warning("Error al consultar pedido" + ex.getMessage());
            throw new NegocioException("Error al consultar pedido" + ex.getMessage());
        }
    }
    @Override
    public Pedido consultarPedido(Integer id) throws NegocioException{
        // validaciones pendientes
        try{
            Pedido pedidoConsultado = this.pedidoDAO.consultarPedido(id);
            return pedidoConsultado;
        }catch(PersistenciaException ex){
            throw new NegocioException("Error al consultar pedido: " + ex.getMessage());
        }
    }
}
