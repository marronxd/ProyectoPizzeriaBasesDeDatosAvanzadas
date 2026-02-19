package Persistencia.Dominio;



public class Pizza {
    
    
    
    //Declara los atributos
    private Integer idUsuario;
    private String nombre;
    private Tamanio tamanio;
    private String descripcion;
    private float precio;
    private String estado;
    
    
    
    /**
     * Constructor completo
     * @param idUsuario
     * @param nombre
     * @param tamanio
     * @param descripcion
     * @param precio
     * @param estado 
     */
    public Pizza(Integer idUsuario, String nombre, Tamanio tamanio, String descripcion, float precio, String estado) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.tamanio = tamanio;
        this.descripcion = descripcion;
        this.precio = precio;
        this.estado = estado;
    }
    
    
    
    /**
     * Constructor sin Id
     * @param nombre
     * @param tamanio
     * @param descripcion
     * @param precio
     * @param estado 
     */
    public Pizza(String nombre, Tamanio tamanio, String descripcion, float precio, String estado) {
        this.nombre = nombre;
        this.tamanio = tamanio;
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
    public Integer getIdUsuario() {
        return idUsuario;
    } public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    } public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Tamanio getTamanio() {
        return tamanio;
    } public void setTamanio(Tamanio tamanio) {
        this.tamanio = tamanio;
    }

    public String getDescripcion() {
        return descripcion;
    } public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecio() {
        return precio;
    } public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getEstado() {
        return estado;
    } public void setEstado(String estado) {
        this.estado = estado;
    }
}