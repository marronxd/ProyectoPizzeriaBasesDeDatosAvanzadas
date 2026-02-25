/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio.BO;

import Negocio.DTO.DetallePizzaNuevoDTO;
import Negocio.DTO.PedidoNuevoDTO;
import Negocio.Excepciones.NegocioException;
import Persistencia.DAO.CuponDAO;
import Persistencia.DAO.ICuponDAO;
import Persistencia.DAO.IPedidoDAO;
import Persistencia.Dominio.Cupon;
import Persistencia.Dominio.DetallesPizza;
import Persistencia.Dominio.Pedido;
import Persistencia.Dominio.PedidoProgramado;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import persistencia.excepciones.PersistenciaException;


/**
 *
 * @author aaron
 */
public class PedidoBO implements IPedidoBO{
    
    private final IPedidoDAO pedidoDAO;
    private  final ICuponDAO cuponDAO;
    private final Logger Log = Logger.getLogger(PedidoBO.class.getName());
    
    // inicia la conexion con la interfaz de pedido dao
    public PedidoBO(IPedidoDAO pedido, ICuponDAO cupon){
        this.pedidoDAO = pedido; //inyeccion de dependencia
        this.cuponDAO = cupon;
    }
        
    
    @Override
    public void cambiarEstado(Integer id, String estado) throws NegocioException{
        if(id <1){
            Log.warning("El id introducido es menor a 1.");
            throw new NegocioException("El id no puede ser menor a 1");
        }
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
        if(id <1){
            Log.warning("El id introducido es menor a 1.");
            throw new NegocioException("El id no puede ser menor a 1");
        }
        if(id == null){
            Log.warning("El id introducido es nulo.");
            throw new NegocioException("El id buscado es nulo");
        }
        // validaciones pendientes
        try{
            Pedido pedidoConsultado = this.pedidoDAO.consultarPedido(id);
            return pedidoConsultado;
        }catch(PersistenciaException ex){
            throw new NegocioException("Error al consultar pedido: " + ex.getMessage());
        }
    }
    
    
    @Override
    public void agregarDetalle(DetallePizzaNuevoDTO detallePizza, Integer id_pedido) throws NegocioException{
        
        // PRIMERO VALIDACIONES DE 
        

    }
    
    @Override 
    public boolean agregarPedidoCompleto(PedidoNuevoDTO pedidoNuevo)throws NegocioException{
        // PRIMERO VALIDACIONES DE PEDIDO COMO TAL
        
        // Validar que el objeto no sea nulo
        if(pedidoNuevo == null){
            Log.warning("Error de operacion. Objeto nulo");
            throw new NegocioException("El pedido se encuentra vacío.");
        }
        
        // Validar que el id sea permitido o tenga valor
        if(pedidoNuevo.getIdUsuario() == null || pedidoNuevo.getIdUsuario() < 0){
            Log.warning("Problemas con el id.");
            throw new NegocioException("El id no puede ser nulo o negativo.");
        }
        
        // Validar el metodo de pago
        if(pedidoNuevo.getMetodo_pago() == null){
            Log.warning("Error de operacion. Metodo_pago nulo");
            throw new NegocioException("El pedido no tiene un metodo de pago.");
        }
        
        // Validar el metodo de pago permitido
        if(!pedidoNuevo.getMetodo_pago().equals("Tarjeta") && !pedidoNuevo.getMetodo_pago().equals("Efectivo")){
            Log.warning("Error de operacion. Metodo_pago no adecuado");
            throw new NegocioException("El pedido no tiene un metodo de pago vàlido.");
        }
        
        // VALIDACIONES DE LOS DETALLES PIZZAS
        
        // validacion de la lista de detalles dto
        if(pedidoNuevo.getListaDetallesPizza() == null){
            Log.warning("Error de operacion. Lista de detalles vacia");
            throw new NegocioException("El pedido no detalles del pedido asignado.");
        }
        
        // para validar que la cantidad no sea nula o negativa
        // variable sumatoria que almacenara elcosto total de cada detalle pedido registrado
        double total = 0;
        
        // CÓMO PUEDO AGREGAR EL DESCUENTO???? 🫀🥲🥲
        double cantidadCupon = 0;
        // validar codigo del cupoon
        Cupon cupon = new Cupon();
        if (pedidoNuevo.getCodigoCupon() != null){
            
            try {
                cupon = this.cuponDAO.validarCupon(pedidoNuevo.getCodigoCupon().trim());
                cantidadCupon = cupon.getCantidad();
            } catch (PersistenciaException ex) {
                throw new NegocioException(ex.getMessage());
            }
            
        }
        
        
        
        // mapear de dpDTO a dp
        List<DetallesPizza> lista = new ArrayList<DetallesPizza>();
        
        
        for(DetallePizzaNuevoDTO detalle: pedidoNuevo.getListaDetallesPizza()){
            // validar si es negativo el costo
            if(detalle.getCosto() <0){
                Log.warning("Error de operacion. Costo negativo");
                throw new NegocioException("El pedido tiene costo negativo asignado.");
            }
            // validar si es negativa
            if(detalle.getCantidad() <0){
                Log.warning("Error de operacion. cantidad negativa.");
                throw new NegocioException("El pedido tiene cantidad negativa.");
            }
            DetallesPizza dp = new DetallesPizza();
            // Mapeo de dto a entidad
            dp.setCosto(detalle.getCosto());
            dp.setCantidad(detalle.getCantidad());
            dp.setNotas(detalle.getNotas());
            dp.setTamanio(detalle.getTamaño());
            //agregar a la lista
            lista.add(dp);
            // sumatoria de totales
            total += detalle.getCosto();
        }
        
        // NORMALIZACION DE DATOS
        
        // Para pedido
        Pedido pedidoAgregar = new Pedido();
        pedidoAgregar.setMetodo_pago(pedidoNuevo.getMetodo_pago().trim());
        pedidoAgregar.setIdUsuario(pedidoNuevo.getIdUsuario());
        pedidoAgregar.setTotal(total - cantidadCupon);
        
        // el pedido con el descuento
        pedidoAgregar.setTotalDCTO(cantidadCupon);
        
        // para detalles pizza
        try {
            this.pedidoDAO.registrarPedidoCompleto(pedidoAgregar, lista, cupon);
        } catch (PersistenciaException ex) {
            Log.warning("Error de operacion. No se pudo registrar pedido");
            throw new NegocioException("Error al intentar registrar pedido");
        }
        
        return true;
    }
}
