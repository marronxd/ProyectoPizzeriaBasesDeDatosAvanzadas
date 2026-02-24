package Negocio.BO;
import Negocio.DTO.TelefonoDTO;
import Persistencia.DAO.ITelefonoDAO;
import Persistencia.Dominio.Telefono;
import Utilerias.Validar;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import negocio.excepciones.NegocioException;
import persistencia.excepciones.PersistenciaException;

/**
 * Se encarga de la lógica de negocio para los teléfonos
 * Interactúa entre presentación y DAO
 * No conoce la BD
 */
public class TelefonoBO {
    
    //El DAO de su clase
    private final ITelefonoDAO telefonoDAO;
    
    //Logger para registrar sucesos
    private static final Logger LOG = Logger.getLogger(TelefonoBO.class.getName());
    
    //Constante del nombre de la entidad que maneja el archivo para centralizar LOGs
    private static final String CLASE = "el teléfono";

    
    
    /**
     * Constructor que agrega el DAO
     * @param telefonoDAO 
     */
    public TelefonoBO(ITelefonoDAO telefonoDAO) {
        this.telefonoDAO = telefonoDAO;
    }
    
    
    
    /**
     * Valida que las ID sea mayor a 0 para consultarlo
     * @param idTelefono
     * @return el telefonoDTO
     * @throws NegocioException 
     */
    public TelefonoDTO consultarTelefono(int idTelefono) throws NegocioException {
        
        //Valida el ID
        if (idTelefono < 1) {
            LOG.warning("ID debe ser numero mayor o igual a 1");
            throw new NegocioException("ID debe ser numero mayor o igual a 1");
        }
        
        //Try para consultar
        try {
            
            //Llama al DAO
            Telefono telefonoObtenido = this.telefonoDAO.consultarTelefono(idTelefono);
            
            //Excepción si es nulo
            if (telefonoObtenido == null || telefonoObtenido.getId() == null) {
                throw new NegocioException("No se pudo consultar " + CLASE);
            }
            
            //Regresa el teléfono mapeado
            return mapearDTO(telefonoObtenido);
            
        //Encapsula la excepción de persistencia en una de negocio    
        } catch (PersistenciaException ex) {
            LOG.log(Level.SEVERE, "Error de persistencia al consultar " + CLASE, ex);
            throw new NegocioException("Error al consultar " + CLASE, ex);
        }
    }
    
    
    
    /**
     * Valida que las ID sean mayores a 0 para consultarlas
     * Se maneja con listas de teléfonos, mapéandolos cuando se necesite
     * @param idCliente
     * @return lista de teléfonos en formato DTO
     * @throws NegocioException 
     */
    public ArrayList<TelefonoDTO> consultarTelefonos(int idCliente) throws NegocioException {
        
        //Valida el ID
        if (idCliente < 1) {
            LOG.warning("ID debe ser numero mayor o igual a 1");
            throw new NegocioException("ID debe ser numero mayor o igual a 1");
        }
        
        //Try para consultar
        try {
            
            //Llama al DAO y obtiene una lista de teléfonos
            ArrayList<Telefono> telefonosObtenidos = this.telefonoDAO.consultarTelefonos(idCliente);
            
            //Crea una lista de telefonoDTO
            ArrayList<TelefonoDTO> telefonosDTO = new ArrayList<>();
            
            //Itera sobre los teléfonos y los valida para después mapearlos a DTO
            for (Telefono telefono: telefonosObtenidos) {
                if (telefono == null || telefono.getId() == null) {
                    throw new NegocioException("No se pudo consultar " + CLASE);
                }
                telefonosDTO.add(mapearDTO(telefono));
            }
            
            //Regresa la lista con los teléfonos mapeados
            return telefonosDTO;
            
        //Encapsula la excepción de persistencia en una de negocio    
        } catch (PersistenciaException ex) {
            LOG.log(Level.SEVERE, "Error de persistencia al consultar " + CLASE, ex);
            throw new NegocioException("Error al consultar " + CLASE, ex);
        }
    }
    
    
    
    /**
     * Aplica todas las reglas de negocio para agregar un teléfono
     * @param telefonoAgregar
     * @param idCliente
     * @return el telefono en DTO
     * @throws NegocioException 
     */
    public TelefonoDTO agregarTelefono(TelefonoDTO telefonoAgregar, int idCliente) throws NegocioException {
        
        //Valida el teléfono
        validarTelefono(telefonoAgregar);
        
        //Mapea a una entidad
        Telefono telefono = mapearEntidad(telefonoAgregar);
        
        //Try para agregarlo a la BD
        try {
            
            //Llama al DAO para que se refleje en la BD
            Telefono telefonoAgregado = this.telefonoDAO.agregarTelefono(telefono, idCliente);
            
            //Excepción si es nulo
            if (telefonoAgregado == null || telefonoAgregado.getId() == null) {
                throw new NegocioException("No se pudo registrar " + CLASE);
            }
            
            //Mapea a un DTO y lo regresa
            return mapearDTO(telefonoAgregado);
            
        //Encapsula la excepción de persistencia en una de negocio    
        } catch (PersistenciaException ex) {
            LOG.log(Level.SEVERE, "Error de persistencia al agregar " + CLASE, ex);
            throw new NegocioException("Error al registrar " + CLASE, ex);
        }
    }
    
    
    /**
     * 
     * @param telefonoActualizar
     * @return
     * @throws NegocioException 
     */
    public TelefonoDTO actualizarTelefono(TelefonoDTO telefonoActualizar) throws NegocioException {
        
        //Valida el teléfono
        validarTelefono(telefonoActualizar);
        
        //Valida que tenga ID
        if (telefonoActualizar.getId() == null) {
            LOG.warning("No se puede actualizar " + CLASE + " sin ID");
            throw new NegocioException(CLASE + " debe tener ID para actualizarse");
        }
        
        //Mapea a una entidad
        Telefono telefono = mapearEntidad(telefonoActualizar);
        
        //Try para actualizar
        try {
            
            //Llama al DAO para actualizar en la BD
            Telefono telefonoActualizado = this.telefonoDAO.actualizarTelefono(telefono);
            
            //Excepción si es nulo
            if (telefonoActualizado == null || telefonoActualizado.getId() == null) {
                throw new NegocioException("No se pudo actualizar " + CLASE);
            }
            
            //Mapea a un DTO y lo regresa
            return mapearDTO(telefonoActualizado);
            
        //Encapsula la excepción de persistencia en una de negocio    
        } catch (PersistenciaException ex) {
            LOG.log(Level.SEVERE, "Error de persistencia al actualizar " + CLASE, ex);
            throw new NegocioException("Error al actualizar " + CLASE, ex);
        }
        
    }
    
    
    
    /**
     * Valida que un teléfono sea apto para su uso
     * @param telefono
     * @throws NegocioException 
     */
    private void validarTelefono(TelefonoDTO telefono) throws NegocioException{
        
        //Verifica que no sea nulo
        if (telefono == null) {
            LOG.warning(CLASE + " no puede ser nulo");
            throw new NegocioException(CLASE + " no puede ser nulo");
        }
        
        //Verifica que no tenga campos nulos o vacíos
        if (Validar.stringsValidos(telefono)) {
            LOG.warning(CLASE + " no puede tener campos vacíos o nulos");
            throw new NegocioException(CLASE + " no puede tener campos vacíos o nulos");
        }
        
        //Verifica que el codigo postal tenga cinco dígitos
        if (!Validar.numeroValido(telefono.getNumero())) {
            LOG.warning(CLASE + " no es válido");
            throw new NegocioException(CLASE + " no es válido");
        }
    }
    
    
    
    /**
     * Mapea un DTO a telefono
     * @param telefonoDTO
     * @return el telefonoDTO mapeado a entidad
     */
    private Telefono mapearEntidad(TelefonoDTO telefonoDTO){
        
        //Crea la entidad
        Telefono telefono = new Telefono();

        //Hace el mapeo
        telefono.setId(telefonoDTO.getId());
        telefono.setNumero(telefonoDTO.getNumero());
        telefono.setEtiqueta(telefonoDTO.getEtiqueta());
        
        //Regresa la entidad
        return telefono;
    }
    
    
    
    /**
     * Mapea un telefono a DTO
     * @param telefono
     * @return el telefono mapeado a DTO
     */
    private TelefonoDTO mapearDTO(Telefono telefono){
        
        //Crea el DTO
        TelefonoDTO telefonoDTO = new TelefonoDTO();
        
        //Hace el mapeo
        telefonoDTO.setId(telefono.getId());
        telefonoDTO.setNumero(telefono.getNumero());
        telefonoDTO.setEtiqueta(telefono.getEtiqueta());
        
        //Regresa el DTO
        return telefonoDTO;
    }  
}