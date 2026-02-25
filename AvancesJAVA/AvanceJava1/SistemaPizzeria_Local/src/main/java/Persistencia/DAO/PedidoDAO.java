/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia.DAO;

import Persistencia.Conexion.IConexionBD;
import Persistencia.Dominio.Cupon;
import Persistencia.Dominio.DetallesPizza;
import Persistencia.Dominio.Pedido;
import java.sql.CallableStatement;
import com.mysql.cj.protocol.Resultset;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import persistencia.excepciones.PersistenciaException;

/**
 * Logica de acceso a la base de datos Su unica funcion es establecer la
 * conexion con la base de datos, inyecta scripts SQL y no almacena logica
 *
 * @author aaron
 */
public class PedidoDAO implements IPedidoDAO {

    /**
     * Componente que inicializa la conexion con la base de datos Al hacerlo por
     * constructor, se reduce el acoplamiento entre capas
     */
    private final IConexionBD conexionBD;

    /**
     * Logger para registrar información relevante durante operaciones de
     * persistencia.
     */
    private static final Logger LOG = Logger.getLogger(PedidoDAO.class.getName());

    /**
     * Constructor que inicializa la dependencia con la bd
     *
     * @param conexionBD componente que se conexta con la bd
     */
    public PedidoDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    @Override
    public void cambiarEstado(Integer id, String estado) throws PersistenciaException {
        String comandoSQL = """
                            update pedidos set estado = ? where id_pedido = ? and estado not in ('Entregado', 'Cancelado');
                            """;

        try (Connection conexion = conexionBD.crearConexion(); PreparedStatement ps = conexion.prepareStatement(comandoSQL)) {
            // reemplazar los signos de interrogacion por datos reales
            ps.setString(1, estado);
            ps.setInt(2, id);

            // dejar validaciones pendientes
            int filasCambiadas = ps.executeUpdate();
            if (filasCambiadas == 0) {
                LOG.warning("El pedido no se encontró.");
                throw new PersistenciaException("Pedido no registrado.");
            }
        } catch (SQLException ex) {
            throw new PersistenciaException(ex.getMessage());
        }
    }
    
    @Override
    public void registrarPedidoCompleto(Pedido pedido, List<DetallesPizza> detallePizza, Cupon cupon)throws PersistenciaException{
        String comandoSQL = """
                            {CALL SP_CrearPedidoCompleto(?, ?, ?, ?, ?, ?)}
                        """;
        /**
         * 1 = metodo pago
         * 2 = total
         * 3 = total descuento
         * 4 = id_usuario
         * 5 = id cupon
         * 6 = regresa el id del pedido
         */
        String SQLDetalles = """
                             insert into detallesPizzas (id_pedido, costo, cantidad, tamaño, notas, id_pizza) 
                             values(?, ?, ?, ?, ?, ?)
                             """;
        // establecer la conexion a sql
        try (Connection conexion = this.conexionBD.crearConexion(); 
             CallableStatement psP = conexion.prepareCall(comandoSQL)){
            
            conexion.setAutoCommit(false); // Iniciamos transacción
            // mapeo creo pero ahora para mandar los datos para la creacion de pedido
            psP.setString(1, pedido.getMetodo_pago());
            psP.setDouble(2, pedido.getTotal());
            psP.setDouble(3, pedido.getTotalDCTO());
            psP.setInt(4, pedido.getIdUsuario());
            // Manejo de cupón opcional (evita NullPointerException)
            if (cupon != null && cupon.getId_cupon() != null) {
                psP.setInt(5, cupon.getId_cupon());
            } else {
                psP.setNull(5, java.sql.Types.INTEGER);
            }
            
            // REGISTRAR EL PARAMETRO DE SALIDA
            psP.registerOutParameter(6, java.sql.Types.INTEGER);
            
            psP.execute(); // ejecuta el sql 
            
            int idGenerado = psP.getInt(6);
            
            // Segunda conexion
            try(PreparedStatement psD = conexion.prepareStatement(SQLDetalles)){
                for (DetallesPizza detP : detallePizza){
                    psD.setInt(1, idGenerado);
                    psD.setDouble(2, detP.getCosto());
                    psD.setInt(3, detP.getCantidad());
                    psD.setString(4, detP.getTamanio());
                    psD.setString(5, detP.getNotas());
                    psD.setInt(6, detP.getId_pizza());
                    psD.executeUpdate();
                   
                }
            conexion.commit(); // Todo fue un éxito
            }catch(SQLException ex){
                conexion.rollback(); // por si hubo una falla, regresar todos los cambios
                LOG.warning(ex.getMessage());
                throw new PersistenciaException(ex.getMessage());
            }
        }catch(SQLException ex){
            LOG.warning(ex.getMessage());
            throw new PersistenciaException(ex.getMessage());
        }    
    }

    @Override
    public Pedido consultarPedido (Integer id) throws PersistenciaException{
        String comandoSQL = """
                        select metodo_pago, total, totalDCTO, tipo, estado, fechaHora_entrega, fechaHora_elaboracion, id_usuario
                        from pedidos where id_pedido = ?;
                        """;
        // establecer la conexion a sql
        try (Connection conexion = this.conexionBD.crearConexion(); PreparedStatement ps = conexion.prepareStatement(comandoSQL)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                // creacion de instancia
                Pedido pedido = new Pedido();

                pedido.setIdPedido(id);
                // Extraer valores simples
                pedido.setMetodo_pago(rs.getString(1)); // metodo pago
                pedido.setTotal(rs.getDouble(2)); // total
                pedido.setTotalDCTO(rs.getDouble(3)); // totaldcto
                pedido.setTipo(rs.getString(4)); // tipo
                pedido.setEstado(rs.getString(5)); // estado

                //3. Manejo de fecha NULL
                if (rs.getDate(6) != null) {
                    pedido.setFechaHora_entrega(rs.getDate(6).toLocalDate());
                } else {
                    pedido.setFechaHora_entrega(null);
                }

                // Fecha elaboración (asumimos que no es NULL)
                pedido.setFechaHora_elaboracion(rs.getDate(7).toLocalDate());

                pedido.setIdUsuario(rs.getInt(8));
                return pedido;
            }
            return null;
        } catch (SQLException ex) {
            LOG.warning("Error al consultar pedido: " + ex.getMessage());
            throw new PersistenciaException("Error al consultar pedido: " + ex.getMessage());
        }
       
    }
} 