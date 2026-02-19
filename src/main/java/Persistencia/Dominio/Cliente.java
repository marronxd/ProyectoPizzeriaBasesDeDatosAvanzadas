package Persistencia.Dominio;
import java.time.LocalDate;
import java.util.ArrayList;



public class Cliente extends Usuario{
    
    
    
    //Declara los atributos
    private String calle;
    private String numero;
    private String colonia;
    private String codigoPostal;
    private String correo;
    private LocalDate fechaNacimiento;
    private String estado;
    private ArrayList<String> telefonos;
    
    
    
    /**
     * Constructor completo
     * @param idUsuario
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
    public Cliente(Integer idUsuario, String nombres, String apellidoPaterno, String apellidoMaterno, 
                   String contrasenia, String tipo, 
                   String calle, String numero, String colonia, String codigoPostal, 
                   String correo, LocalDate fechaNacimiento, String estado, ArrayList<String> telefonos) {
        super(nombres, apellidoPaterno, apellidoMaterno, contrasenia, tipo);
        this.calle = calle;
        this.numero = numero;
        this.colonia = colonia;
        this.codigoPostal = codigoPostal;
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
                   String contrasenia, String tipo, 
                   String calle, String numero, String colonia, String codigoPostal, 
                   String correo, LocalDate fechaNacimiento, String estado, ArrayList<String> telefonos) {
        super(nombres, apellidoPaterno, apellidoMaterno, contrasenia, tipo);
        this.calle = calle;
        this.numero = numero;
        this.colonia = colonia;
        this.codigoPostal = codigoPostal;
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
    public String getCalle() {
        return calle;
    } public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero() {
        return numero;
    } public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getColonia() {
        return colonia;
    } public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    } public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
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

    public ArrayList<String> getTelefonos() {
        return telefonos;
    } public void setTelefonos(ArrayList<String> telefonos) {
        this.telefonos = telefonos;
    }
}