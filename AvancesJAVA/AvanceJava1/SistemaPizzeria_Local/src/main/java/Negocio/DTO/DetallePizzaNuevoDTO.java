/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio.DTO;

/**
 * Representa un detalle pizza que no ha sido creado
 * @author aaron
 */
public class DetallePizzaNuevoDTO {
    //atributos
    private int cantidad;
    private double costo;
    private String tamaño;
    private String notas;
    private Integer id_pedido;
    private Integer id_pizza;

    public DetallePizzaNuevoDTO(int cantidad, String tamaño, String notas, Integer id_pizza) {
        this.cantidad = cantidad;
        this.tamaño = tamaño;
        this.notas = notas;
        this.id_pizza = id_pizza;
    }

    public DetallePizzaNuevoDTO(int cantidad, double costo, String tamaño, String notas, Integer id_pizza) {
        this.cantidad = cantidad;
        this.costo = costo;
        this.tamaño = tamaño;
        this.notas = notas;
        this.id_pizza = id_pizza;
    }

    
    // constructor vacio
    public DetallePizzaNuevoDTO() {
    }
    // con todos los atributos
    public DetallePizzaNuevoDTO(int cantidad, double costo, String tamaño, String notas, Integer id_pedido, Integer id_pizza) {
        this.cantidad = cantidad;
        this.costo = costo;
        this.tamaño = tamaño;
        this.notas = notas;
        this.id_pedido = id_pedido;
        this.id_pizza = id_pizza;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public String getTamaño() {
        return tamaño;
    }

    public void setTamaño(String tamaño) {
        this.tamaño = tamaño;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public Integer getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(Integer id_pedido) {
        this.id_pedido = id_pedido;
    }

    public Integer getId_pizza() {
        return id_pizza;
    }

    public void setId_pizza(Integer id_pizza) {
        this.id_pizza = id_pizza;
    }

    @Override
    public String toString() {
        return "DetallePizzaNuevoDTO{" + "cantidad=" + cantidad + ", costo=" + costo + ", tama\u00f1o=" + tamaño + ", notas=" + notas + ", id_pedido=" + id_pedido + ", id_pizza=" + id_pizza + '}';
    }

}
