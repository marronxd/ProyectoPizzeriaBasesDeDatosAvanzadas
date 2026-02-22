package Persistencia.Dominio;
import java.time.LocalDate;
import java.util.ArrayList;


/**
 * Representa a un cliente en el sistema
 * Hace pedidos y puede cambiar su información
 */
public class Cliente extends Usuario{
    
    //Declara los atributos
    private Domicilio domicilio;
    private String correo;
    private LocalDate fechaNacimiento;
    private String estado;
    private ArrayList<Telefono> telefonos;
    
    
    
    //Constructores
    /**
     * Constructor completo
     * @param idUsuario
     * @param nombres
     * @param apellidoPaterno
     * @param apellidoMaterno
     * @param contrasenia
     * @param tipo
     * @param domicilio
     * @param correo
     * @param fechaNacimiento
     * @param estado
     */
    public Cliente(Integer idUsuario, String nombres, String apellidoPaterno, String apellidoMaterno, 
                   String nombreUsuario, String contrasenia, String tipo, Domicilio domicilio,
                   String correo, LocalDate fechaNacimiento, String estado) {
        super(idUsuario, nombres, apellidoPaterno, apellidoMaterno, contrasenia, tipo, nombreUsuario);
        this.domicilio = domicilio;
        this.correo = correo;
        this.fechaNacimiento = fechaNacimiento;
        this.estado = estado;
        this.telefonos = new ArrayList<>();
    }
    
    /**
     * Constructor sin Id
     * @param nombres
     * @param apellidoPaterno
     * @param apellidoMaterno
     * @param contrasenia
     * @param tipo
     * @param domicilio
     * @param correo
     * @param fechaNacimiento
     * @param estado
     * @param telefonos 
     */
    public Cliente(String nombres, String apellidoPaterno, String apellidoMaterno, 
                   String nombreUsuario, String contrasenia, String tipo, Domicilio domicilio,
                   String correo, LocalDate fechaNacimiento, String estado) {
        super(nombres, apellidoPaterno, apellidoMaterno, contrasenia, tipo, nombreUsuario);
        this.domicilio = domicilio;
        this.correo = correo;
        this.fechaNacimiento = fechaNacimiento;
        this.estado = estado;
        this.telefonos = new ArrayList<>();
    }
    
    /**
     * Constructor sin domicilio
     * @param nombres
     * @param apellidoPaterno
     * @param apellidoMaterno
     * @param nombreUsuario
     * @param contrasenia
     * @param tipo
     * @param correo
     * @param fechaNacimiento
     * @param estado
     */
    public Cliente(String nombres, String apellidoPaterno, String apellidoMaterno, 
                   String nombreUsuario, String contrasenia, String tipo,
                   String correo, LocalDate fechaNacimiento, String estado) {
        super(nombres, apellidoPaterno, apellidoMaterno, contrasenia, tipo, nombreUsuario);
        this.correo = correo;
        this.fechaNacimiento = fechaNacimiento;
        this.estado = estado;
        this.telefonos = new ArrayList<>();
    }
    
    /**
     * Constructor vacío
     */
    public Cliente() {
        
    }
    
    
    
    //Getters y setters
    public Domicilio getDomicilio() {
        return domicilio;
    } public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }
    
    public String getCorreo() {
        return correo;
    } public void setCorreo(String correo) {
        this.correo = correo;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    } public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getEstado() {
        return estado;
    } public void setEstado(String estado) {
        this.estado = estado;
    }

    public ArrayList<Telefono> getTelefonos() {
        return telefonos;
    } public void setTelefonos(ArrayList<Telefono> telefonos) {
        this.telefonos = telefonos;
    }
    
    
    
    /**
     * Agrega un teléfono a la lista del cliente
     * @param telefono 
     */
    public void agregarTelefono(Telefono telefono) {
        this.telefonos.add(telefono);
    }
}