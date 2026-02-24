package Negocio.DTO;
import java.time.LocalDate;
import java.util.ArrayList;


/**
 * Representa a un cliente en el sistema
 * Hace pedidos y puede cambiar su información
 */
public class ClienteDTO extends UsuarioDTO{
    
    //Declara los atributos
    private DomicilioDTO domicilio;
    private String correo;
    private LocalDate fechaNacimiento;
    private String estado;
    private ArrayList<TelefonoDTO> telefonos;
    
    
    
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
    public ClienteDTO(Integer id, String nombres, String apellidoPaterno, String apellidoMaterno, 
                   String nombreUsuario, String contrasenia, String tipo, DomicilioDTO domicilio,
                   String correo, LocalDate fechaNacimiento, String estado) {
        super(id, nombres, apellidoPaterno, apellidoMaterno, contrasenia, tipo, nombreUsuario);
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
     */
    public ClienteDTO(String nombres, String apellidoPaterno, String apellidoMaterno, 
                   String nombreUsuario, String contrasenia, String tipo, DomicilioDTO domicilio,
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
    public ClienteDTO(String nombres, String apellidoPaterno, String apellidoMaterno, 
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
    public ClienteDTO() {
        
    }
    
    
    
    //Getters y setters
    public DomicilioDTO getDomicilio() {
        return domicilio;
    } public void setDomicilio(DomicilioDTO domicilio) {
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

    public ArrayList<TelefonoDTO> getTelefonos() {
        return telefonos;
    } public void setTelefonos(ArrayList<TelefonoDTO> telefonos) {
        this.telefonos = telefonos;
    }
    
    
    
    /**
     * Agrega un teléfono a la lista del cliente
     * @param telefono 
     */
    public void agregarTelefono(TelefonoDTO telefono) {
        this.telefonos.add(telefono);
    }
}