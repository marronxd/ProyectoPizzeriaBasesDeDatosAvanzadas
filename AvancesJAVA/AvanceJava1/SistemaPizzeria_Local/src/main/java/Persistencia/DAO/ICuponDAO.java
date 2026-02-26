/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Persistencia.DAO;

import Persistencia.Dominio.Cupon;
import persistencia.excepciones.PersistenciaException;

/**
 * Interfaz que ayudara a inyectar dependencias en otras partes
 * @author aaron
 */
public interface ICuponDAO {
    /**
     * Metodo que valida la existencia de un cupon en la bd
     * @return
     * @throws PersistenciaException 
     */
    public Cupon validarCupon(String codigo) throws PersistenciaException;
}
