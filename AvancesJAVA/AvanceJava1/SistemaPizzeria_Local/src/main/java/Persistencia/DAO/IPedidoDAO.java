/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Persistencia.DAO;

import Negocio.DTO.DetallePizzaNuevoDTO;
import Persistencia.Dominio.DetallesPizza;
import Persistencia.Dominio.Pedido;
import java.util.ArrayList;
import java.util.List;
import persistencia.excepciones.PersistenciaException;

/**
 *
 * @author aaron
 */
public interface IPedidoDAO {
    
    
    //CRUD basico
    /**
     * Metodo para cambiar el estado de un pedido 
     * @param id es el id del pedido en especifico que queremos cambiar
     * @throws SQLException por si no jala alla en sql
     */
    public void cambiarEstado(Integer id, String pedido) throws PersistenciaException;
    
    /**
     * Metodo para consultar pedido
     * @param pedido
     * @throws PersistenciaException 
     */
    public Pedido consultarPedido(Integer pedido) throws PersistenciaException;
    
    public void registrarPedidoCompleto(Pedido pedido, List<DetallesPizza> detallesPizza)throws PersistenciaException;
}
