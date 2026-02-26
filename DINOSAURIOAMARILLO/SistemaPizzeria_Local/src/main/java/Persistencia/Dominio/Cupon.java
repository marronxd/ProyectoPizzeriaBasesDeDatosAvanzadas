/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia.Dominio;

import java.time.LocalDate;

/**
 * Representa la entidad de un registro en la base de datos
 * @author aaron
 */
public class Cupon {
    private Integer id_cupon;
    private int limite_usos;
    private LocalDate fecha_caducidad;
    private LocalDate fecha_emision;
    private double cantidad;
    private String codigo;

    /**
     * constructor con id cupon
     * @param id_cupon
     * @param limite_usos
     * @param fecha_caducidad
     * @param fecha_emision
     * @param cantidad
     * @param codigo 
     */
    public Cupon(Integer id_cupon, int limite_usos, LocalDate fecha_caducidad, LocalDate fecha_emision, double cantidad, String codigo) {
        this.id_cupon = id_cupon;
        this.limite_usos = limite_usos;
        this.fecha_caducidad = fecha_caducidad;
        this.fecha_emision = fecha_emision;
        this.cantidad = cantidad;
        this.codigo = codigo;
    }
    /**
     * constructor sin id cupon
     * @param limite_usos
     * @param fecha_caducidad
     * @param fecha_emision
     * @param cantidad
     * @param codigo 
     */
    public Cupon(int limite_usos, LocalDate fecha_caducidad, LocalDate fecha_emision, double cantidad, String codigo) {
        this.limite_usos = limite_usos;
        this.fecha_caducidad = fecha_caducidad;
        this.fecha_emision = fecha_emision;
        this.cantidad = cantidad;
        this.codigo = codigo;
    }

    public Cupon() {
    }
    
    @Override
    public String toString() {
        return "Cupon{" + "id_cupon=" + id_cupon + ", limite_usos=" + limite_usos + ", fecha_caducidad=" + fecha_caducidad + ", fecha_emision=" + fecha_emision + ", cantidad=" + cantidad + ", codigo=" + codigo + '}';
    }

    // get y setters
    public Integer getId_cupon() {
        return id_cupon;
    }

    public void setId_cupon(Integer id_cupon) {
        this.id_cupon = id_cupon;
    }

    public int getLimite_usos() {
        return limite_usos;
    }

    public void setLimite_usos(int limite_usos) {
        this.limite_usos = limite_usos;
    }

    public LocalDate getFecha_caducidad() {
        return fecha_caducidad;
    }

    public void setFecha_caducidad(LocalDate fecha_caducidad) {
        this.fecha_caducidad = fecha_caducidad;
    }

    public LocalDate getFecha_emision() {
        return fecha_emision;
    }

    public void setFecha_emision(LocalDate fecha_emision) {
        this.fecha_emision = fecha_emision;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    
}
