/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia.Dominio;

/**
 * Representa al empleado en el sistema
 * @author aaron
 */
public class Empleado{
    
    //Definir atributos caracteristicos
    private String telefono;
    
    // Constructores
    //sin id
    public Empleado(String nombres, String apellidoPaterno, String apellidoMaterno, String contrasenia, String telefono){
        //super(nombres, apellidoPaterno, apellidoMaterno, contrasenia);
        this.telefono = telefono;
    }
    //con id
    public Empleado(Integer idUsuario,String apellidoPaterno, String apellidoMaterno, String contrasenia, String telefono){
        //super(idUsuario, telefono, apellidoPaterno, apellidoMaterno, contrasenia);
        this.telefono = telefono;
    }
    //constructor sin atributos
    public Empleado(){
        
    }
    
    
    
    //agregar setter y getters

    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono){
        this.telefono = telefono;
    }
    
    @Override
    public String toString() {
        return "Empleado{" + "telefono=" + telefono + '}';
    }
    
    
}
