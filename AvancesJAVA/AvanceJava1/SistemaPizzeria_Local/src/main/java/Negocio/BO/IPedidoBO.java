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
 * Es la interfaz que se usa para inyectar dependencia en otras capas sin tener que involucarlas
 * directamente
 * @author aaron
 */
public interface IPedidoBO {
    /**
     * Metodo que cambia el estado de un pedido programado en secuencia
     * @param id el id del pedido al que nos referimos
     * @param estado el estado al que se quiere cambiar
     * @throws NegocioException  si ocurre un suceso innesperado o que no queremos que pase
     */
    public void cambiarEstado(Integer id, String estado) throws NegocioException;
    /**
     *  Metodo que deuelve un objeto o entidad de la base de datos
     * @param id el id del pedido al  que nos referimos
     * @return el objeto completo de la bd
     * @throws NegocioException 
     */
    public Pedido consultarPedido(Integer id)throws NegocioException;
    /**
     * Metodo que mapea un pedido ya bien formado al dao
     * @param pedidoNuevo el "boceto" del pedido que queremos añadir, un pedido no registrado
     * @return verdadero o falso si se ejecuta o no
     * @throws NegocioException 
     */
    public boolean agregarPedidoCompleto(PedidoNuevoDTO pedidoNuevo) throws NegocioException;
    /**
     * Método que cambia el estado de los pedidos express con el pin que recibe
     * @param idPedido el id asociado a ese pedido express
     * @param pin es que introduce el usuario
     * @throws NegocioException si ocurre algun movimiento inesperado
     */
    public void cambiarEstadoExpress(Integer id_pedido, Integer pin) throws NegocioException;
}