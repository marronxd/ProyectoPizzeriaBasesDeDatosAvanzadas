package Persistencia.DAO;
import Persistencia.Dominio.Cliente;
import Persistencia.Dominio.Domicilio;
import Persistencia.Dominio.Telefono;
import persistencia.excepciones.PersistenciaException;

/**
 * Interfaz para métodos de ClienteDAO
 * Describe el funcionamieno de los métodos de forma general
 */
public interface IClienteDAO {
    
    /**
     * Busca un cliente del sistema
     * @param idCliente
     * @return cliente encontrado
     * @throws PersistenciaException 
     */
    public Cliente consultarCliente(int idCliente) throws PersistenciaException;
    
    /**
     * Agrega un cliente completo en el sistema
     * Todos sus datos como persona, su domicilio y primer teléfono
     * @param cliente
     * @param domicilio
     * @param telefono
     * @return cliente completo
     * @throws persistencia.excepciones.PersistenciaException 
     */
    public Cliente agregarCliente(Cliente cliente, Domicilio domicilio, Telefono telefono) throws PersistenciaException;
    
    /**
     * Actualiza la información de un cliente en el sistema
     * @param cliente
     * @return el cliente actualizado
     * @throws PersistenciaException 
     */
    public Cliente actualizarCliente(Cliente cliente) throws PersistenciaException;
    
    /**
     * Da de baja un cliente en el sistema
     * @param cliente
     * @return
     * @throws PersistenciaException 
     */
    public boolean darBajaCliente(int idCliente) throws PersistenciaException;
}