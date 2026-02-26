package Negocio.BO;

import Negocio.DTO.DomicilioDTO;
import Persistencia.Dominio.Domicilio;
import negocio.excepciones.NegocioException;

/**
 * Interfaz para métodos de DomicilioeBO
 * Describe el funcionamieno de los métodos de forma general
 */
public interface IDomicilioBO {
    
    /**
     * Valida que la información de un domicilio sea adecuada para consultarlo
     * @param idCliente
     * @return
     * @throws NegocioException 
     */
    public DomicilioDTO consultarDomicilio(int idCliente) throws NegocioException;
    
    /**
     * Valida la información para actualizar un domicilio
     * @param domicilio
     * @return
     * @throws NegocioException 
     */
    public DomicilioDTO actualizarDomicilio(DomicilioDTO domicilio) throws NegocioException;
}