package Persistencia.DAO;
import Persistencia.Dominio.Domicilio;
import persistencia.excepciones.PersistenciaException;

/**
 * Interfaz para métodos de DomicilioDAO
 * Describe el funcionamieno de los métodos de forma general
 */
public interface IDomicilioDAO {
    
    /**
     * Obtiene la información de un domicilio
     * @param idCliente
     * @return el domicilio
     * @throws persistencia.excepciones.PersistenciaException 
     */
    public Domicilio consultarDomicilio(int idCliente) throws PersistenciaException;
    
    /**
     * Agrega un domicilio en el sistema
     * @param domicilio
     * @return domicilio creado con ID añadida
     * @throws PersistenciaException 
     */
    public Domicilio agregarDomicilio(Domicilio domicilio, int idCliente) throws PersistenciaException;
    
    /**
     * Actualiza los campos de un domicilio existente
     * @param domicilio
     * @return domicilio actualizado
     * @throws PersistenciaException 
     */
    public Domicilio actualizarDomicilio(Domicilio domicilio) throws PersistenciaException;
}