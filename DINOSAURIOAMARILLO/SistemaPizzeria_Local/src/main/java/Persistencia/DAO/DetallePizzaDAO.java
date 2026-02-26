/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia.DAO;

import Persistencia.Conexion.IConexionBD;
import Persistencia.Dominio.DetallesPizza;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import persistencia.excepciones.PersistenciaException;

/** 
 * DetallePizza  dao no tiene como tal (la verdad no le he dado uso pero igual lo hice por si alguien lo ocupa)
 * @author aaron
 */
public class DetallePizzaDAO implements IDetallePizzaDAO{
    
    //inyectar depdnedencia
    public final IConexionBD conexionBD;
    
    
    //constructor que inicializa el valor
    public DetallePizzaDAO(IConexionBD conexionBD){
        this.conexionBD = conexionBD;
    }
    /**
     * Agrega un detalle pizza (no se utiliza)
     * @param detalle
     * @return
     * @throws PersistenciaException 
     */
    @Override
    public DetallesPizza agregarDetallePizza(DetallesPizza detalle) throws PersistenciaException {
        // SQL para insertar en la tabla intermedia/detalle
        // Ajusta los nombres de las columnas según tu base de datos
        String sql = "INSERT INTO detalles_pizza (id_pedido, costo, cantidad, tamaño, notas, id_pizza) VALUES (?, ?, ?, ?, ?, ?)";
        
        try (Connection con = this.conexionBD.crearConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setInt(1, detalle.getId_pedido());
            ps.setInt(2, detalle.getId_pizza());
            ps.setDouble(3, detalle.getCosto());
            ps.setInt(4, detalle.getCantidad());
            ps.setString(5, detalle.getNotas());
            ps.setString(6, detalle.getTamanio());
            
            ps.executeUpdate();
            return detalle;
            
        } catch (SQLException ex) {
            throw new PersistenciaException("Error al insertar detalle de pizza: " + ex.getMessage());
        }
    }
    /**
     * se pensaba para que agregara una pizza a und etalle existente pero descartado
     * @param detalleModificar
     * @return
     * @throws PersistenciaException 
     */
    @Override
    public DetallesPizza agregarPizza(DetallesPizza detalleModificar) throws PersistenciaException{
        return detalleModificar;
    }
    /**
     * Se puede reutilizar pero ya no me dio tiempo de desarrollarlo ( descartado)
     * Modificaba
     * @param detalleModificar
     * @return
     * @throws PersistenciaException 
     */
    @Override
    public DetallesPizza eliminarPizza(DetallesPizza detalleModificar) throws PersistenciaException{
        return detalleModificar;
    }

}
