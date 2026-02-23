/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio.DTO;

/**
 *
 * @author aaron
 */
public class UsuarioDTO {
    private String nombreUsuario;
    private String contraseña;
    /**
    private int edad;
    private String tipo;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    */
    public UsuarioDTO(String nombreUsuario, String contraseña) {
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
        
    }
    
    //Constructor vacio
    public UsuarioDTO(){
        
    }
    //getters de la clase
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getContraseña() {
        return contraseña;
    }
     // setters de la clase 
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

}
