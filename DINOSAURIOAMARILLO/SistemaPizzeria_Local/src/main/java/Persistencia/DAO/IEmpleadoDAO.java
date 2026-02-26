/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Persistencia.DAO;

import Persistencia.Dominio.Empleado;
import java.sql.SQLException;

/**
 *  Interfaz de metodos de usuario dao
 * @author aaron
 */
public interface IEmpleadoDAO {
    
    public Empleado consultarEmpleado(Integer id) throws SQLException;
    
    //public Empleado consultarUsuario()
    
    
}
