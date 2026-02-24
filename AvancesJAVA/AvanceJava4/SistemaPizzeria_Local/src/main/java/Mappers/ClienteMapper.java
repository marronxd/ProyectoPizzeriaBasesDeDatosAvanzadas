package Mappers;

import Negocio.DTO.ClienteDTO;
import Persistencia.Dominio.Cliente;

/**
 *
 * @author Andre
 */
public class ClienteMapper {
    
    
    /**
     * Mapea un DTO a cliente
     * @param clienteoDTO
     * @return el clienteDTO mapeado a entidad
     */
    public static Cliente mapearEntidad(ClienteDTO clienteDTO){
        
        if (clienteDTO == null) {
           return null;
        }
        
        
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
   public static ClienteDTO mapearDTO(Cliente cliente) {
       
       if (cliente == null) {
           return null;
       }
       
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