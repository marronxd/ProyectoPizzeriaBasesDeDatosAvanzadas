package Persistencia.Dominio;

/**
 * Representa un tipo de pizza dentro de un pedido
 * Costo en ese momento o la cantidad de pizzas son cosas que muestra
 */
public class DetallesPizza {
    
    //Declara los atributos
    private Integer idDetallesPizza;
    private Integer idPedido;
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
    public DetallesPizza(Integer idDetallesPizza, Integer idPedido, double costo, int cantidad, String notas, String tamanio) {
        this.idDetallesPizza = idDetallesPizza;
        this.idPedido = idPedido;
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
    public DetallesPizza(Integer idPedido, double costo, int cantidad, String notas, String tamanio) {
        this.idPedido = idPedido;
        this.costo = costo;
        this.cantidad = cantidad;
        this.notas = notas;
        this.tamanio = tamanio;
    }

    public Integer getIdPedido() {
        return idPedido;
    }
    
    /**
     * Constructor vacío
     */
    public DetallesPizza() {
        
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }
    
    
    
    //Getters y setters
    public Integer getIdDetallesPizza() {
        return idDetallesPizza;
    } public void setIdDetallesPizza(Integer idDetallesPizza) {
        this.idDetallesPizza = idDetallesPizza;
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

    @Override
    public String toString() {
        return "DetallesPizza{" + "idDetallesPizza=" + idDetallesPizza + ", costo=" + costo + ", cantidad=" + cantidad + ", notas=" + notas + ", tamanio=" + tamanio + '}';
    }
    
    
    
}