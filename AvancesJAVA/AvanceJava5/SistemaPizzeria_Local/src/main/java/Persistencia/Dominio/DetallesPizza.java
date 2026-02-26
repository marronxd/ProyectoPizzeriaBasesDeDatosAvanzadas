package Persistencia.Dominio;

/**
 * Representa un tipo de pizza dentro de un pedido
 * Costo en ese momento o la cantidad de pizzas son cosas que muestra
 */
public class DetallesPizza {
    
    //Declara los atributos
    private Integer id;
    private double costo;
    private int cantidad;
    private String notas;
    private String tamanio;

    
    
    //Constructores
    /**
     * Constructor completo
     * @param idDetallesPizza
     * @param costo
     * @param cantidad
     * @param notas
     * @param tamanio 
     */
    public DetallesPizza(Integer idDetallesPizza, double costo, int cantidad, String notas, String tamanio) {
        this.id = idDetallesPizza;
        this.costo = costo;
        this.cantidad = cantidad;
        this.notas = notas;
        this.tamanio = tamanio;
    }
    
    /**
     * Constructor sin Id
     * @param costo
     * @param cantidad
     * @param notas
     * @param tamanio 
     */
    public DetallesPizza(double costo, int cantidad, String notas, String tamanio) {
        this.costo = costo;
        this.cantidad = cantidad;
        this.notas = notas;
        this.tamanio = tamanio;
    }
    
    /**
     * Constructor vacío
     */
    public DetallesPizza() {
        
    }
    
    
    
    //Getters y setters
    public Integer getIdDetallesPizza() {
        return id;
    } public void setIdDetallesPizza(Integer idDetallesPizza) {
        this.id = idDetallesPizza;
    }

    public double getCosto() {
        return costo;
    } public void setCosto(double costo) {
        this.costo = costo;
    }

    public int getCantidad() {
        return cantidad;
    } public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getNotas() {
        return notas;
    } public void setNotas(String notas) {
        this.notas = notas;
    }

    public String getTamanio() {
        return tamanio;
    } public void setTamanio(String tamanio) {
        this.tamanio = tamanio;
    }  
}