package Negocio.BO;
import Negocio.DTO.ClienteDTO;
import Negocio.DTO.DomicilioDTO;
import Persistencia.DAO.IClienteDAO;
import Persistencia.Dominio.Cliente;
import Persistencia.Dominio.Domicilio;
import Utilerias.Validar;
import static Utilerias.Validar.stringNullVacio;
import java.util.logging.Level;
import java.util.logging.Logger;
import negocio.excepciones.NegocioException;
import persistencia.excepciones.PersistenciaException;

/**
 * Se encarga de la lógica de negocio para los clientes
 * Interactúa entre presentación y DAO
 * No conoce la BD
 */
public class ClienteBO {
    
    //El DAO de su clase
    private final IClienteDAO clienteDAO;
    
    //Logger para registrar sucesos
    private static final Logger LOG = Logger.getLogger(DomicilioBO.class.getName());
    
    //Constante del nombre de la entidad que maneja el archivo para centralizar LOGs
    private static final String CLASE = "el cliente";

    
    
    /**
     * Constructor que le agrega al DAO
     * @param clienteDAO 
     */
    public ClienteBO(IClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }
    
    
    
    /**
     * Valida que la ID sea mayor a 0 para poder consultarlo en la BD
     * @param idCliente
     * @return el cliente consultado
     * @throws NegocioException 
     */
    public ClienteDTO consultarCliente(int idCliente) throws NegocioException {
        
        //Valida el ID
        if (idCliente < 1) {
            LOG.warning("ID debe ser numero mayor o igual a 1");
            throw new NegocioException("ID debe ser numero mayor o igual a 1");
        }
        
        //Try para consultar
        try {
            
            //Llama al DAO
            Cliente clienteObtenido = this.clienteDAO.consultarCliente(idCliente);

            //Excepción si es nulo
            if (clienteObtenido == null || clienteObtenido.getId() == null) {
                throw new NegocioException("No se pudo consultar " + CLASE);
            }
            
            //Regresa el domicilio mapeado
            return mapearDTO(clienteObtenido);
            
        //Encapsula la excepción de persistencia en una de negocio    
        } catch (PersistenciaException ex) {
            LOG.log(Level.SEVERE, "Error de persistencia al consultar " + CLASE, ex);
            throw new NegocioException("Error al consultar " + CLASE, ex);
        }
    }
    
    
    
    private void validarCliente(Cliente cliente) throws NegocioException{
        
        //Verifica que no sea nulo
        if (cliente == null) {
            LOG.warning(CLASE + " no puede ser nulo");
            throw new NegocioException(CLASE + " no puede ser nulo");
        }
        
        //Verifica que no tenga campos Strings nulos o vacíos
        if (Validar.stringsValidos(cliente)) {
            LOG.warning(CLASE + " no puede tener campos vacíos o nulos");
            throw new NegocioException(CLASE + " no puede tener campos vacíos o nulos");
        }
        
        //Verifica que la fecha de nacimiento no sea nula
        if (cliente.getFechaNacimiento() == null) {
            LOG.warning("La fecha de nacimiento de " + CLASE + " no puede ser nulo");
            throw new NegocioException("La fecha de nacimiento de " + CLASE + " no puede ser nulo");
        }
    }
    
    
    
    //AQUI FALTA PONER EL MÉTODO DE AGREGAR Y ACTUALIZAR CLIENTE
    
    
    /**
     * 
     * @param string
     * @param permitirEspeciales
     * @throws NegocioException 
     */
    public void validarStringCliente(String string, boolean permitirEspeciales) throws NegocioException {
        
        //Valida que no sea nulo o vacío
        if (stringNullVacio(string)) {
            LOG.warning("El string no pueden ser nulo");
            throw new NegocioException("El string no puede ser nulo");
        }
        
        //Regex según el caso, si solo valida caracteres normales o de todo tipo (para contraseñas y nombres de usuario)
        String regex;
        if (permitirEspeciales) {
            regex = "^[\\p{L}0-9!@#$%&*()_+=<>?{}\\[\\]|:;.,'-]{1,100}$";
        } else {
            regex = "^[\\p{L} .'-]{1,100}$";
        }
        
        //Valida si cumple con el regex
        if (!string.matches(regex)) {
            LOG.warning("Máximo 100 caracteres");
            throw new NegocioException("Máximo 100 caracteres");
        }
    }
    
    /**
     * Mapea un DTO a cliente
     * @param clienteoDTO
     * @return el clienteDTO mapeado a entidad
     */
    private Cliente mapearEntidad(ClienteDTO clienteDTO){
        
        //Crea la entidad
        Cliente cliente = new Cliente();
        
        //Hace el mapeo
        cliente.setId(clienteDTO.getId());
        cliente.setNombres(clienteDTO.getNombres());
        cliente.setApellidoPaterno(clienteDTO.getApellidoPaterno());
        cliente.setApellidoMaterno(clienteDTO.getApellidoMaterno());
        cliente.setContrasenia(clienteDTO.getContrasenia());
        cliente.setTipo(clienteDTO.getTipo());
        cliente.setCorreo(clienteDTO.getCorreo());
        cliente.setFechaNacimiento(clienteDTO.getFechaNacimiento());
        cliente.setEstado(clienteDTO.getEstado());
        
        //Regresa la entidad
        return cliente;
    }
    
    
    
    /**
    * Mapea un cliente a DTO
    * @param cliente
    * @return el cliente mapeado a DTO
    */
   private ClienteDTO mapearDTO(Cliente cliente) {

       // Crea el DTO
       ClienteDTO clienteDTO = new ClienteDTO();

       // Hace el mapeo
       clienteDTO.setId(cliente.getId());
       clienteDTO.setNombres(cliente.getNombres());
       clienteDTO.setApellidoPaterno(cliente.getApellidoPaterno());
       clienteDTO.setApellidoMaterno(cliente.getApellidoMaterno());
       clienteDTO.setContrasenia(cliente.getContrasenia());
       clienteDTO.setTipo(cliente.getTipo());
       clienteDTO.setCorreo(cliente.getCorreo());
       clienteDTO.setFechaNacimiento(cliente.getFechaNacimiento());
       clienteDTO.setEstado(cliente.getEstado());

       // Regresa el DTO
       return clienteDTO;
   }
}