/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Persistencia.DAO;

import Negocio.DTO.DetallePizzaNuevoDTO;
import Negocio.DTO.PedidoNuevoDTO;
import Persistencia.Dominio.Cupon;
import Persistencia.Dominio.DetallesPizza;
import Persistencia.Dominio.Pedido;
import java.util.ArrayList;
import java.util.List;
import persistencia.excepciones.PersistenciaException;

/**
 * Es la interfaz conectora por asi decirlo. Es el intermediario para que otra capa 
 * utilice los metodos
 * 
 * @author aaron
 */
public interface IPedidoDAO {
    
    
    //CRUD basico
    /**
     * Metodo para cambiar el estado de un pedido 
     *  PEDIDO SE REFIERE AL ESTADO
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
    /**
     * Método encargado de registrar por completo un pedido, sin importar de que tipo sea
     * @param pedido es el objeto que representa al pediod
     * @param detallesPizza es la lista de todos los detalles
     * @param cupon representa un cupon existente en la base de datos
     * @param pinGenerado es el pin que el usuario para poder reclamar 
     * @throws PersistenciaException 
     */
    public void registrarPedidoCompleto(Pedido pedido, List<DetallesPizza> detallesPizza, Cupon cupon, int pinGenerado)throws PersistenciaException;
    /**
     * Metodo para consultar un pedido express (Regresa pedidoNuevoDTO porque tiene todos 
     * los datos que  necesito)
     * @param idPedido 
     * @return
     * @throws PersistenciaException 
     */
    public PedidoNuevoDTO consultarExpress(Integer idPedido) throws PersistenciaException;
    
    /**
     * Metodo que filtra por id_usuario, por pedido o por ambos
     * @param id_usuario 
     * @param estado 
     * @return la lista de coincidencias
     * @throws PersistenciaException 
     */
    public List<Pedido> consultarpedidoFiltro(Integer id_usuario, String estado) throws PersistenciaException;
}
