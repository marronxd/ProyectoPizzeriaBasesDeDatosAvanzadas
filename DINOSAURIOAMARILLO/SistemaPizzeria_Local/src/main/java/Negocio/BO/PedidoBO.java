/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio.BO;

import Negocio.DTO.DetallePizzaNuevoDTO;
import Negocio.DTO.PedidoNuevoDTO;
import Negocio.Excepciones.NegocioException;
import Persistencia.DAO.ICuponDAO;
import Persistencia.DAO.IPedidoDAO;
import Persistencia.Dominio.Cupon;
import Persistencia.Dominio.DetallesPizza;
import Persistencia.Dominio.Pedido;
import Seguridad.Encriptar;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import persistencia.excepciones.PersistenciaException;


/**
 * Es la capa de negocio que valida todo lo relacionado a pedido, normaliza y conecta las capas
 * 
 * Se inyectan las dependencias de pedido 
 * y las de cupon solamente para validar el cupon en esta capa
 * 
 * contiene metodos para extraer,  modificar y crear pedidos
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
    /**
     * Método que cambia el estado de los pedidos express con el pin que recibe
     * @param idPedido el id asociado a ese pedido express
     * @param pin es que introduce el usuario
     * @throws NegocioException si ocurre algun movimiento inesperado
     */
    @Override
    public void cambiarEstadoExpress(Integer idPedido, Integer pin) throws NegocioException{
        // validaciones
        if(idPedido == null){
            Log.warning("El id introducido es nulo.");
            throw new NegocioException("El id buscado es nulo");
        }
        if(pin == null){
            Log.warning("El pin extraido es nulo.");
            throw new NegocioException("El pin buscado es nulo");
        }
        if(idPedido <0){
            Log.warning("El id introducido es menor a 1.");
            throw new NegocioException("El id no puede ser menor a 1");
        }
        try {
            PedidoNuevoDTO p = this.pedidoDAO.consultarExpress(idPedido);
            if(p.getPin().equals(Encriptar.encriptar(pin))){ // determinista
                this.pedidoDAO.cambiarEstado(idPedido, "Entregado");
            }
        } catch (PersistenciaException ex) {
            Log.warning(ex.getMessage());
            throw new NegocioException(ex.getMessage());
        }
        
    }
    /**
     * Metodo que cambia el estado de un pedido programado en secuencia
     * @param id el id del pedido al que nos referimos
     * @param estado el estado al que se quiere cambiar
     * @throws NegocioException  si ocurre un suceso innesperado o que no queremos que pase
     */
    @Override
    public void cambiarEstado(Integer id, String estado) throws NegocioException{
        // VALIDACIONES
        if(id == null){
            Log.warning("El id introducido es nulo.");
            throw new NegocioException("El id buscado es nulo");
        }
        
        if(estado == null){
            Log.warning("El estado es nulo.");
            throw new NegocioException("El estado es nulo");
        }
        
        if(id <1){
            Log.warning("El id introducido es menor a 1.");
            throw new NegocioException("El id no puede ser menor a 1");
        }
        // normalizar el estado
        estado = estado.trim();
        
        // auxiliar
        // Validar estados permitidos  - - jeje, sí, lo busque en internet
        List<String> estadosValidos = List.of(
            "Listo", // 0 
            "Entregado", // 1
            "Cancelado", // 2
            "Pendiente", // 3
            "No entregado" // 4
        );
        
        // si el estado no esta registrado dentro de su dominio
        if (!estadosValidos.contains(estado)){
            Log.warning("Estado invalido");
            throw new NegocioException("Estado invalido");
        }
        
        try{
            Pedido pedidoCambiar = this.pedidoDAO.consultarPedido(id);
            if (pedidoCambiar == null) {
                throw new NegocioException("Pedido no encontrado.");
            }
            // se extrae el estado original del pedido
            String estadoActual = pedidoCambiar.getEstado().trim();
            
            // se valida que dicho estado no esté finalizado
            if(estadoActual.equals(estadosValidos.get(1)) || estadoActual.equals(estadosValidos.get(2)) || estadoActual.equals(estadosValidos.get(4))){
                Log.warning("Estados finalizados");
                throw new NegocioException("No se puede modificar un estado finalizado");
            }
            
            // VALIDAR SECUENCIA DE ESTADOS
            if(estadoActual.equals("Pendiente")){
                if(!estado.equals("Listo") && !estado.equals("Cancelado")){
                    Log.warning("cambio no lineal");
                    throw new NegocioException("Falla en la secuencia de cambio");
                }
            }else if(estadoActual.equals("Listo")){
                if (!estado.equals("Entregado") && !estado.equals("No entregado")) {
                    Log.warning("cambio no lineal");
                    throw new NegocioException("Un pedido Listo solo puede pasar a Entregado o No entregado.");
                }
            }
            
            //se modifica la entidad 
            this.pedidoDAO.cambiarEstado(id, estado);
            
        }catch(PersistenciaException ex){
            Log.warning("Error al consultar pedido" + ex.getMessage());
            throw new NegocioException("Error al consultar pedido" + ex.getMessage());
        }
    }
    /**
     *  Metodo que deuelve un objeto o entidad de la base de datos
     * @param id el id del pedido al  que nos referimos
     * @return el objeto completo de la bd
     * @throws NegocioException 
     */
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
    /**
     * Metodo que mapea un pedido ya bien formado al dao
     * @param pedidoNuevo el "boceto" del pedido que queremos añadir, un pedido no registrado
     * @return verdadero o falso si se ejecuta o no
     * @throws NegocioException 
     */
    @Override 
    public boolean agregarPedidoCompleto(PedidoNuevoDTO pedidoNuevo)throws NegocioException{
        // PRIMERO VALIDACIONES DE PEDIDO COMO TAL
        
        // Validar que el objeto no sea nulo
        if(pedidoNuevo == null){
            Log.warning("Error de operacion. Objeto nulo");
            throw new NegocioException("El pedido se encuentra vacío.");
        }
        
        // Validar que el id sea permitido o tenga valor
        if(pedidoNuevo.getIdUsuario() != null){
            if(pedidoNuevo.getIdUsuario() < 0){
                 Log.warning("Problemas con el id.");
                throw new NegocioException("El id no puede ser negativo.");
            }
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
        if (pedidoNuevo.getCodigoCupon() != null && pedidoNuevo.getIdUsuario() != null){
            
            try {
                cupon = this.cuponDAO.validarCupon(pedidoNuevo.getCodigoCupon().trim());
                if(cupon == null){
                    Log.warning("No hay cupon registrado");
                    throw new NegocioException("No hay cupon registrado con este codigo");
                }
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
            dp.setId_pizza(detalle.getId_pizza());
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
        
        // para saber que tipo de pedido es en base al id usuario
        if(pedidoNuevo.getIdUsuario() == null){
            pedidoAgregar.setTipo("EXPRESS");
            
        }else{
            pedidoAgregar.setTipo("PROGRAMADO");
        }
        pedidoAgregar.setIdUsuario(pedidoNuevo.getIdUsuario());
        pedidoAgregar.setTotal(total - cantidadCupon);
        // el pedido con el descuento
        pedidoAgregar.setTotalDCTO(cantidadCupon);
        
        // para el pin del express
        
        int pinGenerado = 10000000 + new java.util.Random().nextInt(90000000);
        // para detalles pizza
        try {
            this.pedidoDAO.registrarPedidoCompleto(pedidoAgregar, lista, cupon, pinGenerado);
        } catch (PersistenciaException ex) {
            Log.warning("Error de operacion. No se pudo registrar pedido");
            throw new NegocioException("Error al intentar registrar pedido");
        }
        
        return true;
    }
     /**
     * Metodo que valida las entradas antes de enviar al dao
     * @param id_usuario
     * @param estado
     * @return
     * @throws NegocioException 
     */
    public List<Pedido> consultarpedidoFiltro(Integer id_usuario, String estado) throws NegocioException{
        
        // validaciones null (sí, las genere pq el tiempo se acaba)
        if (id_usuario == null && (estado == null || estado.trim().isEmpty())) {
            Log.warning("error de operacion con la busqueda");
            throw new NegocioException("Entradas invalidas");
        }

        try {
            // 2. Llamada al DAO
            List<Pedido> pedidos = pedidoDAO.consultarpedidoFiltro(id_usuario, estado);

            if (pedidos.isEmpty()) {
                throw new NegocioException("No se encontraron pedidos con los filtros aplicados.");
            }

            return pedidos;

        } catch (PersistenciaException e) {
            //Atrapamos el error de SQL y relanzamos
            throw new NegocioException("Error al procesar la consulta de pedidos: " + e.getMessage());
        }
    }
}
