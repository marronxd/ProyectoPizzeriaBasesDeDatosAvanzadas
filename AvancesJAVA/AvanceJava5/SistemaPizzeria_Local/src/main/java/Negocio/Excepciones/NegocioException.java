/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio.excepciones;

/**
 * Excepcion personalizada para la capa de negocio
 * @author aaron
 */
public class NegocioException extends Exception{

    public NegocioException(String msj){
        super(msj);
    }
    public NegocioException(){
        
    }
    public NegocioException(String msj, Throwable cause){
        super(msj, cause);
    }
}