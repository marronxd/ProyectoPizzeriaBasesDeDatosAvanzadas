package Persistencia.Dominio;

/**
 * Representa a cualquier persona que ingrese e interactúe en el sistema
 * Solo es la clase padre de Cliente y Empleado
 */
public abstract class Usuario {
    
    //Declara los atributos
    private Integer id;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String contrasenia;
    private String tipo;
    private String nombreUsuario;
    
    
    //Constructores
    /**
     * Constructor completo
     * @param id
     * @param nombres
     * @param apellidoPaterno
     * @param apellidoMaterno
     * @param contrasenia
     * @param tipo 
     */
    public Usuario(Integer id, String nombres, String apellidoPaterno, String apellidoMaterno, String contrasenia, String tipo, String nombreUsuario) {
        this.id = id;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.contrasenia = contrasenia;
        this.tipo = tipo;
        this.nombreUsuario = nombreUsuario;
    }
    
    /**
     * Constructor sin Id
     * @param nombres
     * @param apellidoPaterno
     * @param apellidoMaterno
     * @param contrasenia
     * @param tipo 
     */
    public Usuario(String nombres, String apellidoPaterno, String apellidoMaterno, String contrasenia, String tipo, String nombreUsuario) {
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.contrasenia = contrasenia;
        this.tipo = tipo;
        this.nombreUsuario = nombreUsuario;
    }
    
    /**
     * Constructor vacío
     */
    public Usuario() {
        
    }
    
    
    
    //Getters y setters
    public Integer getId() {
        return id;
    } public void setId(Integer id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    } public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    } public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }
    
    public String getApellidoMaterno() {
        return apellidoMaterno;
    } public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getContrasenia() {
        return contrasenia;
    } public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    
    public String getTipo() {
        return tipo;
    } public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    } public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
}