package Persistencia.Dominio;

/**
 * Representa a cualquier persona que ingrese e interactúe en el sistema
 * Solo es la clase padre de Cliente y Empleado
 */
public abstract class Usuario {
    
    //Declara los atributos
    private Integer idUsuario;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String contrasenia;
    private String tipo;
    
    
    //Constructores
    /**
     * Constructor completo
     * @param idUsuario
     * @param nombres
     * @param apellidoPaterno
     * @param apellidoMaterno
     * @param contrasenia
     * @param tipo 
     */
    public Usuario(Integer idUsuario, String nombres, String apellidoPaterno, String apellidoMaterno, String contrasenia, String tipo) {
        this.idUsuario = idUsuario;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.contrasenia = contrasenia;
        this.tipo = tipo;
    }
    
    /**
     * Constructor sin Id
     * @param nombres
     * @param apellidoPaterno
     * @param apellidoMaterno
     * @param contrasenia
     * @param tipo 
     */
    public Usuario(String nombres, String apellidoPaterno, String apellidoMaterno, String contrasenia, String tipo) {
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.contrasenia = contrasenia;
        this.tipo = tipo;
    }
    
    //constructor sin tipo
    public Usuario(String nombres, String apellidoPaterno, String apellidoMaterno, String contrasenia) {
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.contrasenia = contrasenia;
    }
    public Usuario(Integer idUsuario, String nombres, String apellidoPaterno, String apellidoMaterno, String contrasenia) {
        this.idUsuario = idUsuario;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.contrasenia = contrasenia;
    }
    
    /**
     * Constructor vacío
     */
    public Usuario() {
        
    }
    
    
    
    //Getters y setters
    public Integer getIdUsuario() {
        return idUsuario;
    } public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
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
}