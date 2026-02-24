package Negocio.BO;
import Negocio.DTO.DomicilioDTO;
import Persistencia.DAO.IDomicilioDAO;
import Persistencia.Dominio.Domicilio;
import Utilerias.Validar;
import java.util.logging.Level;
import java.util.logging.Logger;
import negocio.excepciones.NegocioException;
import persistencia.excepciones.PersistenciaException;

/**
 * Se encarga de la lógica de negocio para los domicilios
 * Interactúa entre presentación y DAO
 * No conoce la BD
 */
public class DomicilioBO implements IDomicilioBO{
    
    //El DAO de su clase
    private final IDomicilioDAO domicilioDAO;
    
    //Logger para registrar sucesos
    private static final Logger LOG = Logger.getLogger(DomicilioBO.class.getName());
    
    //Constante del nombre de la entidad que maneja el archivo para centralizar LOGs
    private static final String CLASE = "el domicilio";
    
    
    
    /**
     * Constructor que le agrega el DAO
     * @param domicilioDAO
     */
    public DomicilioBO(IDomicilioDAO domicilioDAO) {
        this.domicilioDAO = domicilioDAO;
    }
    
    
    
    /**
     * Valida que la ID sea mayor a 0 para poder consultarlo en la BD
     * @param idCliente
     * @return el domicilio consultado
     * @throws NegocioException 
     */
    @Override
    public DomicilioDTO consultarDomicilio(int idCliente) throws NegocioException {
        
        //Valida el ID
        if (idCliente < 1) {
            LOG.warning("ID debe ser numero mayor o igual a 1");
            throw new NegocioException("ID debe ser numero mayor o igual a 1");
        }
        
        //Try para consultar
        try {
            
            //Llama al DAO
            Domicilio domicilioObtenido = this.domicilioDAO.consultarDomicilio(idCliente);

            //Excepción si es nulo
            if (domicilioObtenido == null || domicilioObtenido.getId() == null) {
                throw new NegocioException("No se pudo consultar " + CLASE);
            }
            
            //Regresa el domicilio mapeado
            return mapearDTO(domicilioObtenido);
            
        //Encapsula la excepción de persistencia en una de negocio    
        } catch (PersistenciaException ex) {
            LOG.log(Level.SEVERE, "Error de persistencia al consultar " + CLASE, ex);
            throw new NegocioException("Error al consultar " + CLASE, ex);
        }
    }
    
    
    
    /**
     * Aplica todas las reglas de negocio para agregar un domicilo
     * @param domicilioAgregar
     * @param idCliente
     * @return el domicilio en DTO
     * @throws NegocioException 
     */
    @Override
    public DomicilioDTO agregarDomicilio(DomicilioDTO domicilioAgregar, int idCliente) throws NegocioException {
        
        //Valida el domicilio
        validarDomicilio(domicilioAgregar);
        
        //Mapea a una entidad
        Domicilio domicilio = mapearEntidad(domicilioAgregar);
        
        //Try para agregarlo a la BD
        try {
            
            //Llama al DAO para que se refleje en la BD
            Domicilio domicilioAgregado = this.domicilioDAO.agregarDomicilio(domicilio, idCliente);
            
            //Excepción si es nulo
            if (domicilioAgregado == null || domicilioAgregado.getId() == null) {
                throw new NegocioException("No se pudo agregar " + CLASE);
            }
            
            //Mapea a un DTO y lo regresa
            return mapearDTO(domicilioAgregado);
            
        //Encapsula la excepción de persistencia en una de negocio    
        } catch (PersistenciaException ex) {
            LOG.log(Level.SEVERE, "Error de persistencia al agregar " + CLASE, ex);
            throw new NegocioException("Error al agregar" + CLASE, ex);
        }
    }
    
    
    
    /**
     * 
     * @param domicilioActualizar
     * @return
     * @throws NegocioException 
     */
    @Override
    public DomicilioDTO actualizarDomicilio(DomicilioDTO domicilioActualizar) throws NegocioException {
        
        //Valida el domicilio
        validarDomicilio(domicilioActualizar);
        
        //Valida que tenga ID
        if (domicilioActualizar.getId() == null) {
            LOG.warning("No se puede actualizar " + CLASE + " sin ID");
            throw new NegocioException(CLASE + " debe tener ID para actualizarse");
        }
        
        //Mapea a una entidad
        Domicilio domicilio = mapearEntidad(domicilioActualizar);
        
        //Try para actualizar
        try {
            
            //Llama al DAO para actualizar en la BD
            Domicilio domicilioActualizado = this.domicilioDAO.actualizarDomicilio(domicilio);
            
            //Excepción si es nulo
            if (domicilioActualizado == null || domicilioActualizado.getId() == null) {
                throw new NegocioException("No se pudo actualizar " + CLASE);
            }
            
            //Mapea a un DTO y lo regresa
            return mapearDTO(domicilioActualizado);
            
        //Encapsula la excepción de persistencia en una de negocio    
        } catch (PersistenciaException ex) {
            LOG.log(Level.SEVERE, "Error de persistencia al actualizar " + CLASE, ex);
            throw new NegocioException("Error al actualizar " + CLASE, ex);
        }
    }

    
    
    /**
     * Valida que un domicilio se apto para su uso
     * @param domicilio
     * @throws NegocioException 
     */
    private void validarDomicilio(DomicilioDTO domicilio) throws NegocioException{
        
        //Verifica que no sea nulo
        if (domicilio == null) {
            LOG.warning(CLASE + " no puede ser nulo");
            throw new NegocioException(CLASE + " no puede ser nulo");
        }
        
        //Verifica que no tenga campos nulos o vacíos
        if (Validar.stringsValidos(domicilio)) {
            LOG.warning(CLASE + " no puede tener campos vacíos o nulos");
            throw new NegocioException(CLASE + " no puede tener campos vacíos o nulos");
        }
        
        //Verifica que el codigo postal tenga cinco dígitos
        if (!Validar.codigoPostalValido(domicilio.getCodigoPostal())) {
            LOG.warning("El código postal no es válido");
            throw new NegocioException("El código postal no es válido");
        }
    }
    
    
    
    /**
     * Mapea un DTO a domicilio
     * @param domicilioDTO
     * @return el domicilioDTO mapeado a entidad
     */
    private Domicilio mapearEntidad(DomicilioDTO domicilioDTO){
        
        //Crea la entidad
        Domicilio domicilio = new Domicilio();
        
        //Hace el mapeo
        domicilio.setId(domicilioDTO.getId());
        domicilio.setCalle(domicilioDTO.getCalle());
        domicilio.setNumero(domicilioDTO.getNumero());
        domicilio.setColonia(domicilioDTO.getColonia());
        domicilio.setCodigoPostal(domicilioDTO.getCodigoPostal());
        
        //Regresa la entidad
        return domicilio;
    }
    
    
    
    /**
     * Mapea un domicilio a DTO
     * @param domicilioDTO
     * @return el domicilio mapeado a DTO
     */
    private DomicilioDTO mapearDTO(Domicilio domicilio){
        
        //Crea el DTO
        DomicilioDTO domicilioDTO = new DomicilioDTO();
        
        //Hace el mapeo
        domicilioDTO.setId(domicilio.getId());
        domicilioDTO.setCalle(domicilio.getCalle());
        domicilioDTO.setNumero(domicilio.getNumero());
        domicilioDTO.setColonia(domicilio.getColonia());
        domicilioDTO.setCodigoPostal(domicilio.getCodigoPostal());
        
        //Regresa el DTOS
        return domicilioDTO;
    }
}