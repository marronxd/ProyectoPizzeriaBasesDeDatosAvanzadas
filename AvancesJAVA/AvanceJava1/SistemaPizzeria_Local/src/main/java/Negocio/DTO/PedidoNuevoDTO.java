/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio.DTO;

import java.time.LocalDate;

/**
 * Representa un pedido nuevo que no esta registrado en el ssitema
 * @author aaron
 */
public class PedidoNuevoDTO {
    private String metodo_pago;
    //private double total;
    //private double totalDCTO;
    private String tipo;
    //private String estado;
    //private LocalDate fechaHora_entrega;
    //private LocalDate fechaHora_elaboracion;
    private Integer idUsuario;

    /**
     * Constructor que crea un usuario no registrado
     * @param metodo_pago
     * @param idUsuario 
     */
    public PedidoNuevoDTO(String metodo_pago, String tipo, Integer id) {
        this.metodo_pago = metodo_pago;
        this.tipo = tipo;
        this.idUsuario = id;
      
    }

    public String getMetodo_pago() {
        return metodo_pago;
    }


    public void setMetodo_pago(String metodo_pago) {
        this.metodo_pago = metodo_pago;
    }

    public String getTipo() {
        return tipo;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    @Override
    public String toString() {
        return "PedidoNuevoDTO{" + "metodo_pago=" + metodo_pago + ", tipo=" + tipo + ", idUsuario=" + idUsuario + '}';
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    
}
