package Negocio.BO;
import Negocio.DTO.TelefonoDTO;
import java.util.ArrayList;
import negocio.excepciones.NegocioException;

/**
 * Intefaz telefonobo
 */
public interface ITelefonoBO {

    /**
     * Consulta un teléfono por su identificador
     * @param idTelefono
     * @return teléfono encontrado
     * @throws NegocioException
     */
    TelefonoDTO consultarTelefono(int idTelefono) throws NegocioException;

    /**
     * Consulta todos los teléfonos asociados a un cliente
     * @param idCliente
     * @return lista de teléfonos
     * @throws NegocioException
     */
    ArrayList<TelefonoDTO> consultarTelefonos(int idCliente) throws NegocioException;

    /**
     * Agrega un nuevo teléfono a un cliente
     * @param telefonoAgregar
     * @param idCliente
     * @return teléfono agregado
     * @throws NegocioException
     */
    TelefonoDTO agregarTelefono(TelefonoDTO telefonoAgregar, int idCliente) throws NegocioException;

    /**
     * Actualiza un teléfono existente
     * @param telefonoActualizar
     * @return teléfono actualizado
     * @throws NegocioException
     */
    TelefonoDTO actualizarTelefono(TelefonoDTO telefonoActualizar) throws NegocioException;
}