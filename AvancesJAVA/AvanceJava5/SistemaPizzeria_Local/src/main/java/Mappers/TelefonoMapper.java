package Mappers;

import Negocio.DTO.TelefonoDTO;
import Persistencia.Dominio.Telefono;
import java.util.ArrayList;


public class TelefonoMapper {
    
    /**
     * Mapea un DTO a telefono
     * @param telefonoDTO
     * @return el telefonoDTO mapeado a entidad
     */
    public static Telefono mapearEntidad(TelefonoDTO telefonoDTO){
        
        //Valida que no sea null
        if (telefonoDTO == null) {
            return null;
        }
        
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
     * Mapea una lista de dto
     * @param telefonosDTO
     * @return 
     */
    public static ArrayList<Telefono> mapearEntidadLista(ArrayList<TelefonoDTO> telefonosDTO) {
        
        //Valida que no sea null
        if (telefonosDTO == null) {
            return null;
        }
        
        //Crea lista entidad
        ArrayList<Telefono> telefonos = new ArrayList<Telefono>();
        
        //Itera y agrega a la nueva lista
        for (TelefonoDTO t: telefonosDTO) {
            telefonos.add(mapearEntidad(t));
        }
        
        //Regresa la lista
        return telefonos;
        
    }
    
    
    
    /**
     * Mapea un telefono a DTO
     * @param telefono
     * @return el telefono mapeado a DTO
     */
    public static TelefonoDTO mapearDTO(Telefono telefono){
        
        //Valida que no sea null
        if (telefono == null) {
            return null;
        }
        
        //Crea el DTO
        TelefonoDTO telefonoDTO = new TelefonoDTO();
        
        //Hace el mapeo
        telefonoDTO.setId(telefono.getId());
        telefonoDTO.setNumero(telefono.getNumero());
        telefonoDTO.setEtiqueta(telefono.getEtiqueta());
        
        //Regresa el DTO
        return telefonoDTO;
    }      
    
    
    
    /**
     * Mapea una lista de entidades
     * @param telefonos
     * @return 
     */
    public static ArrayList<TelefonoDTO> mapearDTOLista(ArrayList<Telefono> telefonos) {
        
        //Valida que no sea null
        if (telefonos == null) {
            return null;
        }
        
        //Crea lista entidad
        ArrayList<TelefonoDTO> telefonosDTO = new ArrayList<TelefonoDTO>();
        
        //Itera y agrega a la nueva lista
        for (Telefono t: telefonos) {
            telefonosDTO.add(mapearDTO(t));
        }
        
        //Regresa la lista
        return telefonosDTO;
    }
}
