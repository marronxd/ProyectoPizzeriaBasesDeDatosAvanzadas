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
    
    //Banderas de rastreo: verifican si un campo fue editado
    private boolean nombresEditado;
    private boolean apellidoPaternoEditado;
    private boolean apellidoMaternoEditado;
    private boolean contraseniaEditada;
    private boolean tipoEditado;
    private boolean nombreUsuarioEditado;
    
    //Constructores
    /**
     * Constructor completo
     * @param id
     * @param nombres
     * @param apellidoMaterno
     * @param contrasenia
     * @param tipo
     * @param nombreUsuario
     */
    public Usuario(Integer id, String nombres, String apellidoPaterno, String apellidoMaterno,
                   String contrasenia, String tipo, String nombreUsuario) {
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
     * @param nombreUsuario
     */
    public Usuario(String nombres, String apellidoPaterno, String apellidoMaterno,
                   String contrasenia, String tipo, String nombreUsuario) {
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
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
        this.nombresEditado = true;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoPaternoEditado = true;
    }
    
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
        this.apellidoMaternoEditado = true;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
        this.contraseniaEditada = true;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
        this.tipoEditado = true;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
        this.nombreUsuarioEditado = true;
    }
    
    //Getters de las banderas
    public boolean isNombresEditado() {
        return nombresEditado;
    }

    public boolean isApellidoPaternoEditado() {
        return apellidoPaternoEditado;
    }

    public boolean isApellidoMaternoEditado() {
        return apellidoMaternoEditado;
    }

    public boolean isContraseniaEditada() {
        return contraseniaEditada;
    }

    public boolean isTipoEditado() {
        return tipoEditado;
    }

    public boolean isNombreUsuarioEditado() {
        return nombreUsuarioEditado;
    }
    
    //Resetea las banderas después de persistir
    public void resetFlags() {
        nombresEditado = false;
        apellidoPaternoEditado = false;
        apellidoMaternoEditado = false;
        contraseniaEditada = false;
        tipoEditado = false;
        nombreUsuarioEditado = false;
    }
}