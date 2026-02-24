/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio.DTO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
    private List<DetallePizzaNuevoDTO> listaDetallesPizza;
    
    //opcional para en caso de que sea pedidoProgramado
    private String idCupon;

    public PedidoNuevoDTO(String metodo_pago, String tipo, Integer idUsuario, List<DetallePizzaNuevoDTO> listaDetallesPizza, String idCupon) {
        this.metodo_pago = metodo_pago;
        this.tipo = tipo;
        this.idUsuario = idUsuario;
        this.listaDetallesPizza = listaDetallesPizza;
        this.idCupon = idCupon;
    }

    
    
    public List<DetallePizzaNuevoDTO> getListaDetallesPizza() {
        return listaDetallesPizza;
    }

    public void setListaDetallesPizza(List<DetallePizzaNuevoDTO> listaDetallesPizza) {
        this.listaDetallesPizza = listaDetallesPizza;
    }
    
    public PedidoNuevoDTO() {
    }
    

    public String getMetodo_pago() {
        return metodo_pago;
    }


    public void setMetodo_pago(String metodo_pago) {
        this.metodo_pago = metodo_pago;
    }


    public Integer getIdUsuario() {
        return idUsuario;
    }

    @Override
    public String toString() {
        return "PedidoNuevoDTO{" + "metodo_pago=" + metodo_pago + ", tipo=" + tipo + ", idUsuario=" + idUsuario + ", listaDetallesPizza=" + listaDetallesPizza + ", idCupon=" + idCupon + '}';
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getIdCupon() {
        return idCupon;
    }

    public void setIdCupon(String idCupon) {
        this.idCupon = idCupon;
    }

    

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    
}
