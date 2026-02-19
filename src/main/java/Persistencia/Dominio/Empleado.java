package Persistencia.Dominio;



public class Empleado extends Usuario {
    
    
    
    //Declara los atributos
    private String rol;
    private String telefono;

    
    
    /**
     * Constructor completo
     * @param idUsuario
     * @param nombres
     * @param apellidoPaterno
     * @param apellidoMaterno
     * @param contrasenia
     * @param tipo 
     * @param rol
     * @param telefono
     */
    public Empleado(Integer idUsuario, String nombres, String apellidoPaterno, String apellidoMaterno, 
                    String contrasenia, String tipo, String rol, String telefono) {
        super(nombres, apellidoPaterno, apellidoMaterno, contrasenia, tipo);
        this.rol = rol;
        this.telefono = telefono;
    }
    
    
    
    /**
     * Constructor sin Id
     * @param rol
     * @param telefono
     * @param nombres
     * @param apellidoPaterno
     * @param apellidoMaterno
     * @param contrasenia
     * @param tipo 
     */
    public Empleado(String nombres, String apellidoPaterno, String apellidoMaterno, 
                    String contrasenia, String tipo, String rol, String telefono) {
        super(nombres, apellidoPaterno, apellidoMaterno, contrasenia, tipo);
        this.rol = rol;
        this.telefono = telefono;
    }
    
    
    
    /**
     * Constructor vacío
     */
    public Empleado() {
        
    }

    
    
    //Getters y setters
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
    
    public String getRol() {
        return rol;
    } public void setRol(String rol) {
        this.rol = rol;
    }

    public String getTelefono() {
        return telefono;
    } public void setTelefono(String telefono) {
        this.telefono = telefono;
    } 
}