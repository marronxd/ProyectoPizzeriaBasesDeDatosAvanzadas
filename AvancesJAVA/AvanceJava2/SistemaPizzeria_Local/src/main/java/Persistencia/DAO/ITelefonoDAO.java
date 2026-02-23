package Persistencia.DAO;
import Negocio.DTO.TelefonoDTO;
import Persistencia.Dominio.Telefono;
import java.util.ArrayList;
import persistencia.excepciones.PersistenciaException;

/**
 * Interfaz para métodos de TelefonoDAO
 * Describe el funcionamieno de los métodos de forma general
 */
public interface ITelefonoDAO {
    
    /**
     * Obtiene la información los teléfonos asociados a un cliente
     * @param idCliente
     * @return los telefonos del cliente
     * @throws PersistenciaException 
     */
    public ArrayList<Telefono> consultarTelefonos(int idCliente) throws PersistenciaException;
    
    /**
     * Agrega un teléfono al sistema asociado a un cliente
     * @param telefono
     * @return el teléfono agregado
     * @throws PersistenciaException 
     */
    public Telefono agregarTelefono(Telefono telefono, int idCliente) throws PersistenciaException;
    
    /**
     * Actualiza un teléfono del sistema
     * @param telefono
     * @return el teléfono actualizado
     * @throws PersistenciaException 
     */
    public Telefono actualizarTelefono(Telefono telefono) throws PersistenciaException;
}