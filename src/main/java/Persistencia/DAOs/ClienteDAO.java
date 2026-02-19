/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia.DAOs;

import Persistencia.Conexion.IConexionBD;
import java.util.logging.Logger;

/**
 *
 * @author Andre
 */
public class ClienteDAO {
    
    private final IConexionBD conexionBD;
    
    private static final Logger LOG = Logger.getLogger(ClienteDAO.class.getName());
    
    public ClienteDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }
    
}
