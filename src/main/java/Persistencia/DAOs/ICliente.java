/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Persistencia.DAOs;

import Persistencia.Dominio.Cliente;
import persistencia.excepciones.PersistenciaException;

/**
 *
 * @author Andre
 */
public interface ICliente {
    
    Cliente consultarCliente(int idCliente) throws PersistenciaException;
    
}
