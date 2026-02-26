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
    // en caso de ser express
    private Integer folio;
    private String pin;
    //opcional para en caso de que sea pedidoProgramado
    private String codigoCupon;

    public PedidoNuevoDTO(String metodo_pago, String tipo, Integer idUsuario, List<DetallePizzaNuevoDTO> listaDetallesPizza, String codigoCupon) {
        this.metodo_pago = metodo_pago;
        this.tipo = tipo;
        this.idUsuario = idUsuario;
        this.listaDetallesPizza = listaDetallesPizza;
        this.codigoCupon = codigoCupon;
    }

    public PedidoNuevoDTO(String metodo_pago, List<DetallePizzaNuevoDTO> listaDetallesPizza) {
        this.metodo_pago = metodo_pago;
        this.listaDetallesPizza = listaDetallesPizza;
    }

    public PedidoNuevoDTO(String metodo_pago, String tipo, List<DetallePizzaNuevoDTO> listaDetallesPizza, Integer folio, String pin) {
        this.metodo_pago = metodo_pago;
        this.tipo = tipo;
        this.listaDetallesPizza = listaDetallesPizza;
        this.folio = folio;
        this.pin = pin;
    }

    public PedidoNuevoDTO(Integer folio, String pin) {
        this.folio = folio;
        this.pin = pin;
    }

    public PedidoNuevoDTO() {
    }

    
    
    public PedidoNuevoDTO(String metodo_pago, String tipo, Integer idUsuario, List<DetallePizzaNuevoDTO> listaDetallesPizza, Integer folio, String pin, String codigoCupon) {
        this.metodo_pago = metodo_pago;
        this.tipo = tipo;
        this.idUsuario = idUsuario;
        this.listaDetallesPizza = listaDetallesPizza;
        this.folio = folio;
        this.pin = pin;
        this.codigoCupon = codigoCupon;
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

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public List<DetallePizzaNuevoDTO> getListaDetallesPizza() {
        return listaDetallesPizza;
    }

    public void setListaDetallesPizza(List<DetallePizzaNuevoDTO> listaDetallesPizza) {
        this.listaDetallesPizza = listaDetallesPizza;
    }

    public Integer getFolio() {
        return folio;
    }

    public void setFolio(Integer folio) {
        this.folio = folio;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getCodigoCupon() {
        return codigoCupon;
    }

    public void setCodigoCupon(String codigoCupon) {
        this.codigoCupon = codigoCupon;
    }

    @Override
    public String toString() {
        return "PedidoNuevoDTO{" + "metodo_pago=" + metodo_pago + ", tipo=" + tipo + ", idUsuario=" + idUsuario + ", listaDetallesPizza=" + listaDetallesPizza + ", folio=" + folio + ", pin=" + pin + ", codigoCupon=" + codigoCupon + '}';
    }
    

    
}
