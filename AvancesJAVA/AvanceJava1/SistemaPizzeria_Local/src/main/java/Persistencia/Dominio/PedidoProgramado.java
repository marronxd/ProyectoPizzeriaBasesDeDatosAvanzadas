/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia.Dominio;

import java.time.LocalDate;

/**
 *
 * @author aaron
 */
public class PedidoProgramado extends Pedido{
    private Integer id_cupon;

    public PedidoProgramado() {
    }

    public PedidoProgramado(Integer id_cupon, Integer idPedido, String metodo_pago, double total, double totalDCTO, String tipo, String estado, LocalDate fechaHora_entrega, LocalDate fechaHora_elaboracion, Integer idUsuario) {
        super(idPedido, metodo_pago, total, totalDCTO, tipo, estado, fechaHora_entrega, fechaHora_elaboracion, idUsuario);
        this.id_cupon = id_cupon;
    }

    public PedidoProgramado(Integer id_cupon, String metodo_pago, double total, double totalDCTO, String tipo, String estado, LocalDate fechaHora_entrega, LocalDate fechaHora_elaboracion, Integer idUsuario) {
        super(metodo_pago, total, totalDCTO, tipo, estado, fechaHora_entrega, fechaHora_elaboracion, idUsuario);
        this.id_cupon = id_cupon;
    }

    
    
    
    
    public Integer getId_cupon() {
        return id_cupon;
    }

    public void setId_cupon(Integer id_cupon) {
        this.id_cupon = id_cupon;
    }

    @Override
    public String toString() {
        return "PedidoProgramado{" + "id_cupon=" + id_cupon + '}';
    }
    
    
}
