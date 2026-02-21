package Persistencia.Dominio;
import Negocio.DTO.DomicilioDTO;
import Negocio.DTO.TelefonoDTO;
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
     * @param correo
     * @param fechaNacimiento
     * @param estado
     * @param telefonos 
     */
    public Cliente(Integer idUsuario, String nombres, String apellidoPaterno, String apellidoMaterno, 
                   String contrasenia, String tipo, Domicilio domicilio,
                   String correo, LocalDate fechaNacimiento, String estado, ArrayList<Telefono> telefonos) {
        super(idUsuario, nombres, apellidoPaterno, apellidoMaterno, contrasenia, tipo);
        this.domicilio = domicilio;
        this.correo = correo;
        this.fechaNacimiento = fechaNacimiento;
        this.estado = estado;
        this.telefonos = telefonos;
    }
    
    /**
     * Constructor sin Id
     * @param nombres
     * @param apellidoPaterno
     * @param apellidoMaterno
     * @param contrasenia
     * @param tipo
     * @param calle
     * @param numero
     * @param colonia
     * @param codigoPostal
     * @param correo
     * @param fechaNacimiento
     * @param estado
     * @param telefonos 
     */
    public Cliente(String nombres, String apellidoPaterno, String apellidoMaterno, 
                   String contrasenia, String tipo, Domicilio domicilio,
                   String correo, LocalDate fechaNacimiento, String estado, ArrayList<Telefono> telefonos) {
        super(nombres, apellidoPaterno, apellidoMaterno, contrasenia, tipo);
        this.domicilio = domicilio;
        this.correo = correo;
        this.fechaNacimiento = fechaNacimiento;
        this.estado = estado;
        this.telefonos = telefonos;
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
}