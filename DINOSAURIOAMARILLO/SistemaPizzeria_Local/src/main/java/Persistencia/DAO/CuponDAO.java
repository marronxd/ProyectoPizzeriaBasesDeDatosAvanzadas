/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia.DAO;

import Persistencia.Conexion.IConexionBD;
import Persistencia.Dominio.Cupon;
import com.mysql.cj.protocol.Resultset;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;
import persistencia.excepciones.PersistenciaException;

/**
 * Capa de cupon para comunicarme con la base de datos
 * tiene metodos para validar si un cupon esta registrado
 * @author aaron
 */
public class CuponDAO implements ICuponDAO{
    // Crear conexion
    private final IConexionBD conexionBD;
    /**
     * Logger para registrar información relevante durante operaciones de
     * persistencia.
     */
    private static final Logger LOG = Logger.getLogger(CuponDAO.class.getName());
    
    public CuponDAO(IConexionBD conexionBD){
        this.conexionBD = conexionBD;
    }
    /**
     * Metodo que valida si un cupon existe en una base de datos.
     * @param codigo el codigo que pertenece a un cupon
     * @return
     * @throws PersistenciaException 
     */
    @Override
    public Cupon validarCupon(String codigo) throws PersistenciaException{
        String comandoSQL = """
                            select id_cupon, limite_usos, fecha_caducidad, fecha_emision, 
                            cantidad, codigo from cupones where codigo = ?
                            """;
        try(Connection conexion = conexionBD.crearConexion(); PreparedStatement ps = conexion.prepareStatement(comandoSQL)){
            ps.setString(1, codigo); // 1 porque es el pirmer ?
            try(ResultSet rs = ps.executeQuery()){
                if(rs.next()){

                    // Mapeo de datos
                    Cupon cuponExtraido = new Cupon();

                    // extraccion de datos
                    cuponExtraido.setId_cupon((Integer) rs.getInt(1));


                    // 1. Para el Límite de Usos (Usamos getObject para capturar el null real de la BD)
                    Object limite = rs.getObject(2);
                    cuponExtraido.setLimite_usos(limite == null ? null : (Integer) limite);

                    // 2. Para la Fecha de Caducidad (Variable temporal para evitar NullPointerException)
                    java.sql.Date fechaCad = rs.getDate(3);
                    cuponExtraido.setFecha_caducidad(fechaCad == null ? null : fechaCad.toLocalDate());

                    // 3. Para la Fecha de Emisión
                    java.sql.Date fechaEmi = rs.getDate(4);
                    cuponExtraido.setFecha_emision(fechaEmi == null ? null : fechaEmi.toLocalDate());

                    // 4. Para la cantidad (ahora como Double)
                    Object cantObj = rs.getObject(5);
                    // Si es null le ponemos 0.0, si no, lo convertimos a Double
                    cuponExtraido.setCantidad(cantObj == null ? 0.0 : ((Number) cantObj).doubleValue());

                    cuponExtraido.setCodigo(rs.getString(6));

                    return cuponExtraido;
                }
            
            }
        }catch(SQLException ex){
            LOG.warning(ex.getMessage());
            throw new PersistenciaException(ex.getMessage());
        }
        return null;
    }
}
