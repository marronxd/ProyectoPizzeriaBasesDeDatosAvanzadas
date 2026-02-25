package Mappers;
import Negocio.DTO.DomicilioDTO;
import Persistencia.Dominio.Domicilio;

/**
 *
 */
public class DomicilioMapper {
    
    /**
     * Mapea un DTO a domicilio
     * @param domicilioDTO
     * @return el domicilioDTO mapeado a entidad
     */
    public static Domicilio mapearEntidad(DomicilioDTO domicilioDTO){
        
        //Valida que no sea null
        if (domicilioDTO == null) {
            return null;
        }
        
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
    public static DomicilioDTO mapearDTO(Domicilio domicilio){
        
        //Valida que no sea null
        if (domicilio == null) {
            return null;
        }

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
