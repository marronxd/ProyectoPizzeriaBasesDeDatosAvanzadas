package Negocio.BO;
import Mappers.ClienteMapper;
import Mappers.DomicilioMapper;
import Mappers.TelefonoMapper;
import Negocio.DTO.ClienteDTO;
import Negocio.DTO.DomicilioDTO;
import Negocio.DTO.TelefonoDTO;
import Persistencia.DAO.IClienteDAO;
import Persistencia.Dominio.Cliente;
import Persistencia.Dominio.Domicilio;
import Persistencia.Dominio.Telefono;
import Validaciones.Util;
import static Validaciones.Util.stringNullVacio;
import static Validaciones.Util.stringsValidos;
import static Validaciones.Util.validarRangoStrings;
import Validaciones.ValidacionesCliente;
import static Validaciones.ValidacionesDomicilio.validarCodigoPostal;
import Validaciones.ValidacionesTelefono;
import java.util.ArrayList;
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
    private static final String DOM = "el domicilio";

    //Constante con el límite de caracteres de strings cliente
    int MAX_CLIENTE = 100;
    
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
            return ClienteMapper.mapearDTO(clienteObtenido);
            
        //Encapsula la excepción de persistencia en una de negocio    
        } catch (PersistenciaException ex) {
            LOG.log(Level.SEVERE, "Error de persistencia al consultar " + CLASE, ex);
            throw new NegocioException("Error al consultar " + CLASE, ex);
        }
    }
    
    
    
    //AQUI FALTA PONER ACTUALIZAR CLIENTE
    
    
    /**
     * 
     * @param clienteDTO
     * @return
     * @throws NegocioException 
     */
    public ClienteDTO agregarCliente(ClienteDTO clienteDTO) throws NegocioException {
        
        //Verifica que no sea nulo
        if (clienteDTO == null) {
            LOG.warning(CLASE + " no puede ser nulo");
            throw new NegocioException(CLASE + " no puede ser nulo");
        }
        
        //Verifica que el cliente tenga un teléfono
        if (clienteDTO.getTelefonos() == null || clienteDTO.getTelefonos().isEmpty()) {
            LOG.warning(CLASE + " debe tener al menos un teléfono");
            throw new NegocioException(CLASE + " debe tener al menos un teléfono");
        }
        
        //Verifica que tenga domicilio
        if (clienteDTO.getDomicilio() == null) {
            LOG.warning(DOM + " no puede ser nulo");
            throw new NegocioException(DOM + " no puede ser nulo");
        }

        //Mapea a una entidad cliente y la valida
        Cliente cliente = ClienteMapper.mapearEntidad(clienteDTO);
        validarCliente(cliente);
        
        //Mapea el domicilio y lo valida
        Domicilio domicilio = DomicilioMapper.mapearEntidad(clienteDTO.getDomicilio());
        validarDomicilio(domicilio);
        
        //Mapea y valida los teléfonos
        TelefonoDTO telefonoDTO = clienteDTO.getTelefonos().get(0);
        Telefono telefono = TelefonoMapper.mapearEntidad(telefonoDTO);
        validarTelefono(telefono);
        
        //Try para agregar
        try {
            
            Cliente clienteAgregado = this.clienteDAO.agregarCliente(cliente, domicilio, telefono);
            
            //Excepción si es nulo
            if (clienteAgregado == null || clienteAgregado.getId() == null) {
                throw new NegocioException("No se pudo agregar " + CLASE);
            }
            
            //Mapea a un DTO el telefono
            Telefono tel = clienteAgregado.getTelefonos().get(0);
            TelefonoDTO telefonoMapeado = TelefonoMapper.mapearDTO(tel);
            
            //Mapea DTO domicilio
            Domicilio dom = clienteAgregado.getDomicilio();
            DomicilioDTO domicilioMapeado = DomicilioMapper.mapearDTO(dom);
            
            //Mapea DTO cliente
            ClienteDTO clienteMapeado = ClienteMapper.mapearDTO(clienteAgregado);
            
            //Une todo y lo regresa
            clienteMapeado.setDomicilio(domicilioMapeado);
            clienteMapeado.agregarTelefono(telefonoMapeado);
            return clienteMapeado;
            
        //Encapsula la excepción de persistencia en una de negocio    
        } catch (PersistenciaException ex) {
            LOG.log(Level.SEVERE, "Error de persistencia al agregar " + CLASE, ex);
            throw new NegocioException("Error al agregar" + CLASE, ex);
        }
    }
        
        
        
    private void validarCliente(Cliente cliente) throws NegocioException{
        
        //Verifica que no tenga campos Strings nulos o vacíos
        if (!Util.stringsValidos(cliente)) {
            LOG.warning(CLASE + " no puede tener campos vacíos o nulos");
            throw new NegocioException(CLASE + " no puede tener campos vacíos o nulos");
        }
        
        if (validarRangoStrings(cliente, MAX_CLIENTE)) {
            LOG.warning(CLASE + " no puede tener más caracteres que " + MAX_CLIENTE);
            throw new NegocioException(CLASE + " no puede tener más caracteres que " + MAX_CLIENTE);
        }
        
        //Verifica que la fecha de nacimiento no sea nula
        if (cliente.getFechaNacimiento() == null) {
            LOG.warning("La fecha de nacimiento de " + CLASE + " no puede ser nulo");
            throw new NegocioException("La fecha de nacimiento de " + CLASE + " no puede ser nulo");
        }
    }



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
     * Valida que un domicilio se apto para su uso
     * @param domicilio
     * @throws NegocioException 
     */
    private void validarDomicilio(Domicilio domicilio) throws NegocioException{
        
        //Verifica que no tenga campos nulos o vacíos
        if (!stringsValidos(domicilio)) {
            LOG.warning(DOM + " no puede tener campos vacíos o nulos");
            throw new NegocioException(DOM + " no puede tener campos vacíos o nulos");
        }
        
        //Verifica que el codigo postal tenga cinco dígitos
        if (!validarCodigoPostal(domicilio.getCodigoPostal())) {
            LOG.warning("El código postal no es válido");
            throw new NegocioException("El código postal no es válido");
        }
    } 
    
    
    
    /**
     * Valida que un teléfono sea apto para su uso
     * @param telefono
     * @throws NegocioException 
     */
    private void validarTelefono(Telefono telefono) throws NegocioException{
        
        //Verifica que no tenga campos nulos o vacíos
        if (!Util.stringsValidos(telefono)) {
            LOG.warning(CLASE + " no puede tener campos vacíos o nulos");
            throw new NegocioException(CLASE + " no puede tener campos vacíos o nulos");
        }
        
        //Verifica que sean puros numeros
        if (!ValidacionesTelefono.sonPurosNumeros(telefono.getNumero())) {
            LOG.warning(CLASE + " deben ser solo numeros");
            throw new NegocioException(CLASE + " deben ser solo numeros");
        }
        
        //Verifica que el telefono sean 10 numeros
        if (!ValidacionesTelefono.validarTamanioNumero(telefono.getNumero())) {
            LOG.warning(CLASE + " no es válido");
            throw new NegocioException(CLASE + " no es válido");
        }
        
        //Verifica al etiqueta
        if (!ValidacionesTelefono.validarFormatoEtiqueta(telefono.getEtiqueta())) {
            LOG.warning(CLASE + " no es válido su etiqueta");
            throw new NegocioException(CLASE + " no es válido su etiqueta");
        }
    }
    
    
    
    /**
     * Valida todos los teléfonos
     * @param telefonos 
     */
    private void validarTelefonos(ArrayList<Telefono> telefonos) throws NegocioException {
        for (Telefono t: telefonos) {
            validarTelefono(t);
        }
    }
}