package Persistencia.Dominio;

/**
 * Representa un tipo de pizza dentro de un pedido
 * Costo en ese momento o la cantidad de pizzas son cosas que muestra
 */
public class DetallesPizza {
    
    //Declara los atributos
    private Integer idDetallesPizza;
    private Integer id_pedido;
    private double costo;
    private int cantidad;
    private String notas;
    private String tamanio;
    private Integer id_pizza;

    public DetallesPizza() {
    }

    @Override
    public String toString() {
        return "DetallesPizza{" + "idDetallesPizza=" + idDetallesPizza + ", id_pedido=" + id_pedido + ", costo=" + costo + ", cantidad=" + cantidad + ", notas=" + notas + ", tamanio=" + tamanio + ", id_pizza=" + id_pizza + '}';
    }

    
    
    /**
     * Sin id
     * @param id_pedido
     * @param costo
     * @param cantidad
     * @param notas
     * @param tamanio
     * @param id_pizza 
     */
    public DetallesPizza(Integer id_pedido, double costo, int cantidad, String notas, String tamanio, Integer id_pizza) {
        this.id_pedido = id_pedido;
        this.costo = costo;
        this.cantidad = cantidad;
        this.notas = notas;
        this.tamanio = tamanio;
        this.id_pizza = id_pizza;
    }

    
    
    /**
     * Cnstructor completo
     * @param idDetallesPizza
     * @param id_pedido
     * @param costo
     * @param cantidad
     * @param notas
     * @param tamanio
     * @param id_pizza 
     */
    public DetallesPizza(Integer idDetallesPizza, Integer id_pedido, double costo, int cantidad, String notas, String tamanio, Integer id_pizza) {
        this.idDetallesPizza = idDetallesPizza;
        this.id_pedido = id_pedido;
        this.costo = costo;
        this.cantidad = cantidad;
        this.notas = notas;
        this.tamanio = tamanio;
        this.id_pizza = id_pizza;
    }

    
    
    public Integer getIdDetallesPizza() {
        return idDetallesPizza;
    }

    public void setIdDetallesPizza(Integer idDetallesPizza) {
        this.idDetallesPizza = idDetallesPizza;
    }

    public Integer getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(Integer id_pedido) {
        this.id_pedido = id_pedido;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public String getTamanio() {
        return tamanio;
    }

    public void setTamanio(String tamanio) {
        this.tamanio = tamanio;
    }

    public Integer getId_pizza() {
        return id_pizza;
    }

    public void setId_pizza(Integer id_pizza) {
        this.id_pizza = id_pizza;
    }

    
    

}