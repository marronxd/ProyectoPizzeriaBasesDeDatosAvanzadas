package Persistencia.DAO;
import Persistencia.Conexion.IConexionBD;
import Persistencia.Dominio.Cliente;
import Persistencia.Dominio.Domicilio;
import Persistencia.Dominio.Telefono;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistencia.excepciones.PersistenciaException;

/**
 * DAO que maneja la lógica para manipular la BD de los clientes
 * No se encarga de reglas de negocio, solo de persistencia
 */
public class ClienteDAO implements IClienteDAO {
    
    //Conexión a la BD
    private final IConexionBD conexionBD;
    
    //Logger para registrar sucesos
    private static final Logger LOG = Logger.getLogger(ClienteDAO.class.getName());
    
    
    
    /**
     * Constructor que inyecta la conexión de la BD
     * @param conexionBD 
     */
    public ClienteDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }
    
    
    
    /**
     * Mapea una fila en memoria a un objeto de la clase Cliente
     * No incluye domicilio ni teléfonos para no mezclar roles de DAOs
     * Este método no es parte de la interfaz 
     * @param rs
     * @return cliente extraído
     * @throws SQLException 
     */
    private Cliente extraerCliente(ResultSet rs) throws SQLException {
        Cliente cliente = new Cliente();
        
        //Nombre
        cliente.setNombres(rs.getString("nombres"));
        cliente.setApellidoPaterno(rs.getString("apellido_paterno"));
        cliente.setApellidoMaterno(rs.getString("apellido_materno"));
        
        //Otros atributos
        cliente.setContrasenia(rs.getString("contrasenia"));
        cliente.setNombreUsuario(rs.getString("nombre_usuario"));
        cliente.setTipo(rs.getString("tipo"));
        cliente.setCorreo(rs.getString("correo"));
        cliente.setCorreo(rs.getString("estado"));
        
        //Fecha de nacimiento
        Date fecha = rs.getDate("fecha_nacimiento");
        cliente.setFechaNacimiento(fecha != null ? fecha.toLocalDate() : null);
        
        //Regresa el cliente
        return cliente;
    }
    
    
    
    /**
     * Ejecuta SELECT sobre la tabla clientes
     * No selecciona domicilio ni teléfonos
     * @param idCliente
     * @return cliente consultado
     * @throws PersistenciaException 
     */
    @Override
    public Cliente consultarCliente(int idCliente) throws PersistenciaException {
        
        //Comando para interactuar con la BD
        String comando = """
                            SELECT id_usuario, estado, correo, fecha_nacimiento
                            FROM clientes
                            WHERE id_cliente = ?
                         """;
        
        //Try with resources
        try (Connection conn = this.conexionBD.crearConexion(); PreparedStatement ps = conn.prepareStatement(comando)) {
            ps.setInt(1, idCliente);
            try (ResultSet rs = ps.executeQuery()) {
                
                ///Si no existe esa ID
                if (!rs.next()) {
                    LOG.log(Level.WARNING, "No se encontró el cliente relacionado a ID {0}", idCliente);
                    throw new PersistenciaException("No existe un cliente de un cliente con ese ID");
                }
               
               //Regresa el domicilio
               return extraerCliente(rs);
            }

        //Excepción si hay un error al conectarse con la BD
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, "Error de SQL al consultar cliente", ex);
            throw new PersistenciaException("Error al consultar cliente", ex);
        }
    }
    
    
    
    /**
     * Ejecuta la transacción SP_crear_registro_cliente_completo
     * Agrega un cliente con su domicilio y teléfono inicial al mismo tiempo
     * El cliente al registrarse lo hace con un solo teléfono, después puede agregar más
     * @param cliente
     * @param domicilio
     * @param telefono
     * @return cliente ya completo, con domicilio y su nuevo teléfono
     * @throws PersistenciaException 
     */
    @Override
    public Cliente agregarCliente(Cliente cliente, Domicilio domicilio, Telefono telefono) throws PersistenciaException{
        
        //Comando para interactuar con la BD
        String comando = "{CALL SP_crear_registro_cliente_completo(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
        
        //Try que ejecuta procedimientos almacenados
        try (Connection conn = this.conexionBD.crearConexion(); CallableStatement cs = conn.prepareCall(comando)) {
            
            //Asigna valores a los parámetros del cliente
            cs.setString(1, cliente.getNombres());
            cs.setString(2, cliente.getApellidoPaterno());
            cs.setString(3, cliente.getApellidoMaterno());
            cs.setString(4, cliente.getNombreUsuario());
            cs.setString(5, cliente.getContrasenia());
            cs.setString(6, cliente.getCorreo());
            
            //Transforma el LocalDate y lo convierte en un Date de SQL
            LocalDate fecha = cliente.getFechaNacimiento();
            cs.setDate(7, java.sql.Date.valueOf(fecha));
            
            //Asigna valores a los parámetros del domicilio
            cs.setString(8, domicilio.getCalle());
            cs.setString(9, domicilio.getNumero());
            cs.setString(10, domicilio.getColonia());
            cs.setString(11, domicilio.getCodigoPostal());
            
            //Asigna los valores a los parámetros del teléfono
            cs.setString(12, telefono.getNumero());
            cs.setString(13, telefono.getEtiqueta());
            
            //Asigna el parámetro de salida (la ID del usuario agregado)
            cs.registerOutParameter(14, java.sql.Types.INTEGER);
            
            //Ejecuta la transacción y obtiene el ID generado
            cs.execute();
            cliente.setIdUsuario(cs.getInt(14));
            
            //Asigna domicilio e inserta el teléfono al cliente
            cliente.setDomicilio(domicilio);
            cliente.agregarTelefono(telefono);

            //Regresa el cliente completo
            LOG.log(Level.INFO, "Cliente insertado con éxito. ID: {0}", cliente.getIdUsuario());
            return cliente;
            
        //Excepción si hay un error al conectarse con la BD
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, "Error de SQL al agregar cliente", ex);
            throw new PersistenciaException("Error al agregar cliente", ex);
        }
    }
    
    
    
    /**
     * Ejecuta UPDATE sobre la tabla de clientes
     * Afecta a la información independiente del cliente
     * Domicilio y teléfonos se actualizan en sus respectivos DAOs
     * @param cliente
     * @return el cliente actualizado
     * @throws PersistenciaException 
     */
    @Override
    public Cliente actualizarCliente(Cliente cliente) throws PersistenciaException {
        
        //Comando para interactuar con la BD
        String comando = """
                            UPDATE clientes
                            SET 
                                nombres = ?, apellido_paterno = ?, apellido_materno = ?,
                                nombreUsuario = ?, contraseña = ?, correo = ? tipo = ?, estado = ?,
                                fecha_nacimiento = ?
                            WHERE id_domicilio = ?
                         """;
        
        //Try with resources
        try (Connection conn = this.conexionBD.crearConexion(); PreparedStatement ps = conn.prepareStatement(comando)) {

            //Asigna cada valor del domicilio ("?") una posición en la consulta
            ps.setString(1, cliente.getNombres());
            ps.setString(2, cliente.getApellidoPaterno());
            ps.setString(3, cliente.getApellidoMaterno());
            ps.setString(4, cliente.getNombreUsuario());
            ps.setString(5, cliente.getContrasenia());
            ps.setString(6, cliente.getCorreo());
            ps.setString(7, cliente.getTipo());
            ps.setString(8, cliente.getEstado());
            
            //Transforma el LocalDate y lo convierte en un Date de SQL
            LocalDate fecha = cliente.getFechaNacimiento();
            ps.setDate(9, java.sql.Date.valueOf(fecha));
            
            //Asigna el valor de la ID mientras no sea null, de lo contrario java no admite el wrapper con el setInt
            if (cliente.getIdUsuario() == null) {
                throw new PersistenciaException("No se puede actualizar cliente sin ID");
            }
            ps.setInt(10, cliente.getIdUsuario());

            //Excepción si no se actualizó ninguna fila
            if (ps.executeUpdate() == 0) {
                throw new PersistenciaException("No se pudo actualizar: el ID proporcionado no existe");
            }
            
            //Regresa el domicilio
            LOG.log(Level.INFO, "Cliente actualizado con éxito. ID: {0}", cliente.getIdUsuario());
            return cliente;
            
        //Excepción si hay un error al conectarse con la BD
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, "Error de SQL al actualizar cliente", ex);
            throw new PersistenciaException("Error al actualizar cliente", ex);
        }
    }
}