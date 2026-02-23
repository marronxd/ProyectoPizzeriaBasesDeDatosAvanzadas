/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Persistencia.DAO;

import Persistencia.Dominio.Pedido;
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
     * Metodo para generar un pedido, recibe un pedido no registrado
     * @param pedido es el pedido que recibe para crearse en la base de datos
     * @throws SQLException 
     */
    public void generarPedido(Pedido pedido) throws PersistenciaException;
    
    /**
     * Metodo para consultar pedido
     * @param pedido
     * @throws PersistenciaException 
     */
    public Pedido consultarPedido(Integer pedido) throws PersistenciaException;
    
    
}
