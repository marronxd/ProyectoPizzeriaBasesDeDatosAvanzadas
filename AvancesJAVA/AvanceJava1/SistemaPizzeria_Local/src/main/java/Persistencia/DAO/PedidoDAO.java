/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia.DAO;

import Persistencia.Conexion.IConexionBD;
import Persistencia.Dominio.Pedido;
import com.mysql.cj.protocol.Resultset;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.logging.Logger;
import persistencia.excepciones.PersistenciaException;

/**
 * Logica de acceso a la base de datos
 * Su unica funcion es establecer la conexion con la base de datos,
 * inyecta scripts SQL y no almacena logica
 * @author aaron
 */
public class PedidoDAO implements IPedidoDAO{
    
    /**
     * Componente que inicializa la conexion con la base de datos
     * Al hacerlo por constructor, se reduce el acoplamiento entre capas
     */
    private final IConexionBD conexionBD;
    
    
    /**
     * Logger para registrar información relevante durante operaciones de
     * persistencia.
     */
    private static final Logger LOG = Logger.getLogger(PedidoDAO.class.getName());
    
    /**
     * Constructor que inicializa la dependencia con la bd
     * @param conexionBD  componente que se conexta con la bd
     */
    public PedidoDAO(IConexionBD conexionBD){
        this.conexionBD = conexionBD;
    }
    @Override
    public void cambiarEstado(Integer id, String estado) throws PersistenciaException{
        String comandoSQL = """
                            update pedidos set estado = ? where id_pedido = ? and estado not in ('Entregado', 'Cancelado');
                            """;
        
        try(Connection conexion = conexionBD.crearConexion(); PreparedStatement ps = conexion.prepareStatement(comandoSQL) ){
            // reemplazar los signos de interrogacion por datos reales
            ps.setString(1, estado);
            ps.setInt(2, id);
            
            // dejar validaciones pendientes
            
            
            int filasCambiadas = ps.executeUpdate();
            if(filasCambiadas == 0){
                LOG.warning("El pedido no se encontró.");
                throw new PersistenciaException("Pedido no registrado.");
            }
        }catch(SQLException ex){
            throw new PersistenciaException(ex.getMessage());
        }
    }
    @Override
    public void generarPedido(Pedido pedido) throws PersistenciaException{
        String comandoSQL1 = """
                            
                            """;
        //iniciar conexion sql
    }
    @Override
    public Pedido consultarPedido(Integer id) throws PersistenciaException{
        String comandoSQL = """
                            select metodo_pago, total, totalDCTO, tipo, estado, fechaHora_entrega, fechaHora_elaboracion, id_usuario
                            from pedidos where id_pedido = ?;
                            """;
        // establecer la conexion a sql
        try(Connection conexion = this.conexionBD.crearConexion(); PreparedStatement ps = conexion.prepareStatement(comandoSQL)){
            ps.setInt(1, id);
            ResultSet  rs =  ps.executeQuery();
            
            if(rs.next()){
                // creacion de instancia
                Pedido  pedido = new Pedido();
                
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
