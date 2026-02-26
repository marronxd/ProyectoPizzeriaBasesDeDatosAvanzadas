package Negocio.BO;
import Mappers.DomicilioMapper;
import static Mappers.DomicilioMapper.mapearDTO;
import static Mappers.DomicilioMapper.mapearEntidad;
import Negocio.DTO.DomicilioDTO;
import Persistencia.DAO.IDomicilioDAO;
import Persistencia.Dominio.Domicilio;
import Validaciones.Util;
import static Validaciones.Util.stringsValidos;
import static Validaciones.ValidacionesDomicilio.validarCodigoPostal;
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
     * 
     * @param domicilioActualizar
     * @return
     * @throws NegocioException 
     */
    @Override
    public DomicilioDTO actualizarDomicilio(DomicilioDTO domicilioActualizar) throws NegocioException {
        
        //Verifica que no sea nulo
        if (domicilioActualizar == null) {
            LOG.warning(CLASE + " no puede ser nulo");
            throw new NegocioException(CLASE + " no puede ser nulo");
        }
        
        //Mapea a una entidad
        Domicilio domicilio = mapearEntidad(domicilioActualizar);

        //Valida el domicilio
        validarDomicilio(domicilio);
        
        //Valida que tenga ID
        if (domicilioActualizar.getId() == null) {
            LOG.warning("No se puede actualizar " + CLASE + " sin ID");
            throw new NegocioException(CLASE + " debe tener ID para actualizarse");
        }
        
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
    private void validarDomicilio(Domicilio domicilio) throws NegocioException{
        
        //Verifica que no tenga campos nulos o vacíos
        if (!stringsValidos(domicilio)) {
            LOG.warning(CLASE + " no puede tener campos vacíos o nulos");
            throw new NegocioException(CLASE + " no puede tener campos vacíos o nulos");
        }
        
        //Verifica que el codigo postal tenga cinco dígitos
        if (!validarCodigoPostal(domicilio.getCodigoPostal())) {
            LOG.warning("El código postal no es válido");
            throw new NegocioException("El código postal no es válido");
        }
    } 
}