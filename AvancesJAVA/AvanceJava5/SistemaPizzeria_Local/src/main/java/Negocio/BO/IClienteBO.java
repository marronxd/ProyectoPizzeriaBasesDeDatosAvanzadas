package Negocio.BO;
import Negocio.DTO.ClienteDTO;
import negocio.excepciones.NegocioException;

/**
 * Intefaz clienteBO
 */
public interface IClienteBO {

    /**
     * Consulta un cliente por su identificador
     * @param idCliente
     * @return cliente encontrado
     * @throws NegocioException
     */
    ClienteDTO consultarCliente(int idCliente) throws NegocioException;

    /**
     * Actualiza la información de un cliente existente
     * @param clienteActualizar
     * @return cliente actualizado
     * @throws NegocioException
     */
    ClienteDTO actualizarCliente(ClienteDTO clienteActualizar) throws NegocioException;

    /**
     * Agrega un nuevo cliente al sistema
     * @param clienteDTO
     * @return cliente agregado
     * @throws NegocioException
     */
    ClienteDTO agregarCliente(ClienteDTO clienteDTO) throws NegocioException;
}