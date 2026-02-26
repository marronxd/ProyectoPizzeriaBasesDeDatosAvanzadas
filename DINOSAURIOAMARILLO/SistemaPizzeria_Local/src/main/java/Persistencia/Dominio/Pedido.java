/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia.Dominio;

import java.time.LocalDate;

/**
 * Representa un pedido en la base de datos
 * @author aaron
 */
public class Pedido {
    private Integer idPedido;
    private String metodo_pago;
    private double total;
    private double totalDCTO;
    private String tipo;
    private String estado;
    private LocalDate fechaHora_entrega;
    private LocalDate fechaHora_elaboracion;
    private Integer idUsuario;

    
    
    /**
     * constructor con el id pedido
     * @param idPedido
     * @param metodo_pago
     * @param total
     * @param totalDCTO
     * @param tipo
     * @param estado
     * @param fechaHora_entrega
     * @param fechaHora_elaboracion
     * @param idUsuario 
     */
    public Pedido(Integer idPedido, String metodo_pago, double total, double totalDCTO, String tipo, String estado, LocalDate fechaHora_entrega, LocalDate fechaHora_elaboracion, Integer idUsuario) {
        this.idPedido = idPedido;
        this.metodo_pago = metodo_pago;
        this.total = total;
        this.totalDCTO = totalDCTO;
        this.tipo = tipo;
        this.estado = estado;
        this.fechaHora_entrega = fechaHora_entrega;
        this.fechaHora_elaboracion = fechaHora_elaboracion;
        this.idUsuario = idUsuario;
    }
    /**
     * Constructor vacío
     */
    public Pedido(){
        
    }
    
    
    /**
     * Constructor sin el id pedido
     * @param metodo_pago
     * @param total
     * @param totalDCTO
     * @param tipo
     * @param estado
     * @param fechaHora_entrega
     * @param fechaHora_elaboracion
     * @param idUsuario 
     */
    public Pedido(String metodo_pago, double total, double totalDCTO, String tipo, String estado, LocalDate fechaHora_entrega, LocalDate fechaHora_elaboracion, Integer idUsuario) {
        this.metodo_pago = metodo_pago;
        this.total = total;
        this.totalDCTO = totalDCTO;
        this.tipo = tipo;
        this.estado = estado;
        this.fechaHora_entrega = fechaHora_entrega;
        this.fechaHora_elaboracion = fechaHora_elaboracion;
        this.idUsuario = idUsuario;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public void setMetodo_pago(String metodo_pago) {
        this.metodo_pago = metodo_pago;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setTotalDCTO(double totalDCTO) {
        this.totalDCTO = totalDCTO;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setFechaHora_entrega(LocalDate fechaHora_entrega) {
        this.fechaHora_entrega = fechaHora_entrega;
    }

    public void setFechaHora_elaboracion(LocalDate fechaHora_elaboracion) {
        this.fechaHora_elaboracion = fechaHora_elaboracion;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    
    
    
    public Integer getIdPedido() {
        return idPedido;
    }

    public String getMetodo_pago() {
        return metodo_pago;
    }

    public double getTotal() {
        return total;
    }

    public double getTotalDCTO() {
        return totalDCTO;
    }

    public String getTipo() {
        return tipo;
    }

    public String getEstado() {
        return estado;
    }

    public LocalDate getFechaHora_entrega() {
        return fechaHora_entrega;
    }

    public LocalDate getFechaHora_elaboracion() {
        return fechaHora_elaboracion;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    @Override
    public String toString() {
        return "Pedido{" + "idPedido=" + idPedido + ", metodo_pago=" + metodo_pago + ", total=" + total + ", totalDCTO=" + totalDCTO + ", tipo=" + tipo + ", estado=" + estado + ", fechaHora_entrega=" + fechaHora_entrega + ", fechaHora_elaboracion=" + fechaHora_elaboracion + ", idUsuario=" + idUsuario + '}';
    }
    
    
    
    
}
