package Negocio.DTO;

/**
 * DTO que representa a cualquier persona que ingrese e interactúe en el sistema en su forma DTO.
 * Solo es la clase padre de ClienteDTO y EmpleadoDTO.
 */
public abstract class UsuarioDTO {

    // Atributos
    private Integer id;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String contrasenia;
    private String tipo;
    private String nombreUsuario;

    // Flags de rastreo de edición (protected para herencia)
    protected boolean nombresEditado;
    protected boolean apellidoPaternoEditado;
    protected boolean apellidoMaternoEditado;
    protected boolean contraseniaEditada;
    protected boolean tipoEditado;
    protected boolean nombreUsuarioEditado;

    // Constructores
    public UsuarioDTO(Integer id, String nombres, String apellidoPaterno, String apellidoMaterno, String contrasenia, String tipo, String nombreUsuario) {
        this.id = id;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.contrasenia = contrasenia;
        this.tipo = tipo;
        this.nombreUsuario = nombreUsuario;
    }

    public UsuarioDTO(String nombres, String apellidoPaterno, String apellidoMaterno, String contrasenia, String tipo, String nombreUsuario) {
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.contrasenia = contrasenia;
        this.tipo = tipo;
        this.nombreUsuario = nombreUsuario;
    }

    public UsuarioDTO() {}

    // Getters y setters con tracking
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNombres() { return nombres; }
    public void setNombres(String nombres) {
        this.nombres = nombres;
        this.nombresEditado = true;
    }
    public boolean isNombresEditado() { return nombresEditado; }

    public String getApellidoPaterno() { return apellidoPaterno; }
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoPaternoEditado = true;
    }
    public boolean isApellidoPaternoEditado() { return apellidoPaternoEditado; }

    public String getApellidoMaterno() { return apellidoMaterno; }
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
        this.apellidoMaternoEditado = true;
    }
    public boolean isApellidoMaternoEditado() { return apellidoMaternoEditado; }

    public String getContrasenia() { return contrasenia; }
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
        this.contraseniaEditada = true;
    }
    public boolean isContraseniaEditada() { return contraseniaEditada; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) {
        this.tipo = tipo;
        this.tipoEditado = true;
    }
    public boolean isTipoEditado() { return tipoEditado; }

    public String getNombreUsuario() { return nombreUsuario; }
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
        this.nombreUsuarioEditado = true;
    }
    public boolean isNombreUsuarioEditado() { return nombreUsuarioEditado; }

    /**
     * Resetea todas las flags de edición
     */
    public void resetFlags() {
        nombresEditado = false;
        apellidoPaternoEditado = false;
        apellidoMaternoEditado = false;
        contraseniaEditada = false;
        tipoEditado = false;
        nombreUsuarioEditado = false;
    }
}