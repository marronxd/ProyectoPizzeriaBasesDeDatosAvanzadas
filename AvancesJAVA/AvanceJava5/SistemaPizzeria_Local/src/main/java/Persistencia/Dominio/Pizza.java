package Persistencia.Dominio;


/**
 * Representa una opción dentro del menú de pizzas
 */
public class Pizza {
    
    //Declara los atributos
    private Integer id;
    private String nombre;
    private String descripcion;
    private double precio;
    private String estado;
    
    
    
    //Constructores
    /**
     * Constructor completo
     * @param id
     * @param nombre
     * @param descripcion
     * @param precio
     * @param estado 
     */
    public Pizza(Integer id, String nombre, String descripcion, float precio, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.estado = estado;
    }
    
    /**
     * Constructor sin Id
     * @param nombre
     * @param descripcion
     * @param precio
     * @param estado 
     */
    public Pizza(String nombre, String descripcion, float precio, String estado) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.estado = estado;
    }
    
    /**
     * Constructor vacío
     */
    public Pizza() {
        
    }

    
    
    //Getters y setters
    public Integer getId() {
        return id;
    } public void setId(Integer idUsuario) {
        this.id = idUsuario;
    }

    public String getNombre() {
        return nombre;
    } public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    } public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    } public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getEstado() {
        return estado;
    } public void setEstado(String estado) {
        this.estado = estado;
    }
}