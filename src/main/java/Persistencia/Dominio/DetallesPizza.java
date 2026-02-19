package Persistencia.Dominio;



public class DetallesPizza {
    
    
    
    //Declara los atributos
    private Integer idDetallesPizza;
    private float costo;
    private int cantidad;
    private String notas;
    
    
    
    /**
     * Constructor completo
     * @param idDetallesPizza
     * @param costo
     * @param cantidad
     * @param notas 
     */
    public DetallesPizza(Integer idDetallesPizza, float costo, int cantidad, String notas) {
        this.idDetallesPizza = idDetallesPizza;
        this.costo = costo;
        this.cantidad = cantidad;
        this.notas = notas;
    }
    
    
    
    /**
     * Constructor sin Id
     * @param costo
     * @param cantidad
     * @param notas 
     */
    public DetallesPizza(float costo, int cantidad, String notas) {
        this.costo = costo;
        this.cantidad = cantidad;
        this.notas = notas;
    }
    
    
    
    /**
     * Constructor vacío
     */
    public DetallesPizza() {
        
    }

    
    
    //Getters y setters
    public Integer getIdDetallesPizza() {
        return idDetallesPizza;
    } public void setIdDetallesPizza(Integer idDetallesPizza) {
        this.idDetallesPizza = idDetallesPizza;
    }

    public float getCosto() {
        return costo;
    } public void setCosto(float costo) {
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
}