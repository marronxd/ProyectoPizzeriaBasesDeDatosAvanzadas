/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia.DAO;

import Persistencia.Conexion.IConexionBD;
import Persistencia.Dominio.DetallesPizza;
import persistencia.excepciones.PersistenciaException;

/**
 *
 * @author aaron
 */
public class DetallePizzaDAO implements IDetallePizzaDAO{
    
    //inyectar depdnedencia
    public final IConexionBD conexionBD;
    
    
    //constructor que inicializa el valor
    public DetallePizzaDAO(IConexionBD conexionBD){
        this.conexionBD = conexionBD;
    }
    @Override
    public DetallesPizza agregarDetallePizza(DetallesPizza detalleAgregar) throws PersistenciaException{
        return detalleAgregar;
    }
    @Override
    public DetallesPizza agregarPizza(DetallesPizza detalleModificar) throws PersistenciaException{
        return detalleModificar;
    }
    @Override
    public DetallesPizza eliminarPizza(DetallesPizza detalleModificar) throws PersistenciaException{
        return detalleModificar;
    }

}
