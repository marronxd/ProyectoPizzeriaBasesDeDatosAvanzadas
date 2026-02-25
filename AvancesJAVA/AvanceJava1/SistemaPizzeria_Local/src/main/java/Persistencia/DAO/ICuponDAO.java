/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Persistencia.DAO;

import Persistencia.Dominio.Cupon;
import persistencia.excepciones.PersistenciaException;

/**
 *
 * @author aaron
 */
public interface ICuponDAO {
    /**
     * 
     * @return
     * @throws PersistenciaException 
     */
    public Cupon validarCupon(String codigo) throws PersistenciaException;
}
