package Negocio.DTO;

import Persistencia.Dominio.EstadoCliente;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Representa a un cliente en el sistema.
 * Hace pedidos y puede cambiar su información.
 * Extiende UsuarioDTO para heredar atributos básicos de usuario y sus flags de edición.
 */
public class ClienteDTO extends UsuarioDTO {

    // Atributos propios de Cliente
    private DomicilioDTO domicilio;
    private String correo;
    private LocalDate fechaNacimiento;
    private EstadoCliente estado;
    private ArrayList<TelefonoDTO> telefonos;

    // Flags de rastreo: campos propios de Cliente
    private boolean domicilioEditado;
    private boolean correoEditado;
    private boolean fechaNacimientoEditado;
    private boolean estadoEditado;
    private boolean telefonosEditados;

    // Constructores
    public ClienteDTO() {
        this.telefonos = new ArrayList<>();
    }

    public ClienteDTO(Integer id, String nombres, String apellidoPaterno, String apellidoMaterno,
                      String nombreUsuario, String contrasenia, String tipo, DomicilioDTO domicilio,
                      String correo, LocalDate fechaNacimiento, EstadoCliente estado) {
        super(id, nombres, apellidoPaterno, apellidoMaterno, contrasenia, tipo, nombreUsuario);
        this.domicilio = domicilio;
        this.correo = correo;
        this.fechaNacimiento = fechaNacimiento;
        this.estado = estado;
        this.telefonos = new ArrayList<>();
    }

    public ClienteDTO(String nombres, String apellidoPaterno, String apellidoMaterno,
                      String nombreUsuario, String contrasenia, String tipo, DomicilioDTO domicilio,
                      String correo, LocalDate fechaNacimiento, EstadoCliente estado) {
        super(nombres, apellidoPaterno, apellidoMaterno, contrasenia, tipo, nombreUsuario);
        this.domicilio = domicilio;
        this.correo = correo;
        this.fechaNacimiento = fechaNacimiento;
        this.estado = estado;
        this.telefonos = new ArrayList<>();
    }

    public ClienteDTO(String nombres, String apellidoPaterno, String apellidoMaterno,
                      String nombreUsuario, String contrasenia, String tipo,
                      String correo, LocalDate fechaNacimiento, EstadoCliente estado) {
        super(nombres, apellidoPaterno, apellidoMaterno, contrasenia, tipo, nombreUsuario);
        this.correo = correo;
        this.fechaNacimiento = fechaNacimiento;
        this.estado = estado;
        this.telefonos = new ArrayList<>();
    }

    // Getters y setters con tracking de campos propios
    public DomicilioDTO getDomicilio() { return domicilio; }
    public void setDomicilio(DomicilioDTO domicilio) {
        this.domicilio = domicilio;
        this.domicilioEditado = true;
    }
    public boolean isDomicilioEditado() { return domicilioEditado; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) {
        this.correo = correo;
        this.correoEditado = true;
    }
    public boolean isCorreoEditado() { return correoEditado; }

    public LocalDate getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
        this.fechaNacimientoEditado = true;
    }
    public boolean isFechaNacimientoEditado() { return fechaNacimientoEditado; }

    public EstadoCliente getEstado() { return estado; }
    public void setEstado(EstadoCliente estado) {
        this.estado = estado;
        this.estadoEditado = true;
    }
    public boolean isEstadoEditado() { return estadoEditado; }

    public ArrayList<TelefonoDTO> getTelefonos() { return telefonos; }
    public void setTelefonos(ArrayList<TelefonoDTO> telefonos) {
        this.telefonos = telefonos;
        this.telefonosEditados = true;
    }
    public boolean isTelefonosEditados() { return telefonosEditados; }

    public void agregarTelefono(TelefonoDTO telefono) {
        if (this.telefonos == null) this.telefonos = new ArrayList<>();
        this.telefonos.add(telefono);
        this.telefonosEditados = true;
    }

    
    
    public void resetFlags() {
        // Flags heredadas de UsuarioDTO
        nombresEditado = false;
        apellidoPaternoEditado = false;
        apellidoMaternoEditado = false;
        nombreUsuarioEditado = false;
        contraseniaEditada = false;
        tipoEditado = false;

        // Flags propias de Cliente
        domicilioEditado = false;
        correoEditado = false;
        fechaNacimientoEditado = false;
        estadoEditado = false;
        telefonosEditados = false;
    }
}