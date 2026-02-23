/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio.DTO;

/**
 * Representa un empleado que no ha sido registrado, es decir, solo representa la informacion
 * de un empleado con los datos necesarios para guardar uno
 * @author aaron
 */
public class EmpleadoNuevoDTO {
    
    //atributos 
    private String telefono; 
    private UsuarioDTO usuario;
    
    public EmpleadoNuevoDTO(String telefono, UsuarioDTO usuario) {
        this.telefono = telefono;
        this.usuario = usuario;
    }

    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
    }

    public String getTelefono() {
        return telefono;
    }

    public UsuarioDTO getUsuario() {
        return usuario;
    }
    
    
    
}
