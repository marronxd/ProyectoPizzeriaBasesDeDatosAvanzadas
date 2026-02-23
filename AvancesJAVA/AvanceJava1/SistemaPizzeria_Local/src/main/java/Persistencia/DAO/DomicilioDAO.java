package Persistencia.DAO;
import Persistencia.Conexion.IConexionBD;
import Persistencia.Dominio.Domicilio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistencia.excepciones.PersistenciaException;

/**
 * DAO que maneja la lógica para manipular la BD
 * No se encarga de reglas de negocio, solo de persistencia
 */
public class DomicilioDAO implements IDomicilioDAO {
    
    //Conexión a la BD
    private final IConexionBD conexionBD;
    
    //Logger para registrar sucesos
    private static final Logger LOG = Logger.getLogger(DomicilioDAO.class.getName());
    
    
    
    /**
     * Constructor que inyecta la conexión de la BD
     * @param conexionBD 
     */
    public DomicilioDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }
    
    
    
    /**
     * Mapea una fila en memoria a un objeto de la clase Domicilio
     * Este método no es parte de la interfaz
     * @param rs
     * @return domicilio creado
     * @throws SQLException 
     */
    private Domicilio extraerDomicilio(ResultSet rs) throws SQLException {
        Domicilio domicilio = new Domicilio();
        domicilio.setCalle(rs.getString("calle"));
        domicilio.setNumero(rs.getString("numero"));
        domicilio.setColonia(rs.getString("colonia"));
        domicilio.setCodigoPostal(rs.getString("codigo_postal"));
        return domicilio;
    }
    
    
    
    /**
     * Ejecuta SELECT sobre la tabla domicilios_clientes
     * Utiliza la ID del cliente al tratarse de una relación 1:1
     * @param idCliente
     * @return el domicilio
     * @throws persistencia.excepciones.PersistenciaException 
     */
    @Override
    public Domicilio consultarDomicilio(int idCliente) throws PersistenciaException {
        
        //Comando para interactuar cona la BD
        String comando = """
                            SELECT id_domicilio, calle, numero, colonia, codigo_postal
                            FROM domicilios_clientes
                            WHERE id_cliente = ?
                         """;
        
        //Try with resources
        try (Connection conn = this.conexionBD.crearConexion(); PreparedStatement ps = conn.prepareStatement(comando)) {
            ps.setInt(1, idCliente);
            try (ResultSet rs = ps.executeQuery()) {

                //Si no existe con id asociada
               if (!rs.next()) {
                   LOG.log(Level.WARNING, "No se encontró el domicilio relacionado a ID {0}", idCliente);
                   throw new PersistenciaException("No existe un domicilio de un cliente con ese ID");
               }
               
               //Regresa el domicilio
               return extraerDomicilio(rs);
            }
            
        //Excepción si hay un error al conectarse con la BD
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, "Error de SQL al consultar domicilio", ex);
            throw new PersistenciaException("Error al consultar domicilio", ex);
        }
    }
    
    
    
    /**
     * Ejecuta INSERT sobre la tabla domicilios_clientes
     * @param domicilio
     * @return domicilio creado con ID añadida
     * @throws PersistenciaException 
     */
    @Override
    public Domicilio agregarDomicilio(Domicilio domicilio) throws PersistenciaException {
        
        //Comando para interactuar con la BD
        String comando = """
                            INSERT INTO domicilios_cliente (calle, numero, colonia, codigo_postal)
                            VALUES (?,?,?,?)
                         """;
        
        //Try with resources
        try (Connection conn = this.conexionBD.crearConexion(); PreparedStatement ps = conn.prepareStatement(comando, Statement.RETURN_GENERATED_KEYS)) { 
            
            //Asigna cada valor del domicilio ("?") una posición en la consulta
            ps.setString(1, domicilio.getCalle());
            ps.setString(2, domicilio.getNumero());
            ps.setString(3, domicilio.getColonia());
            ps.setString(4, domicilio.getCodigoPostal());
            
            //Excepción si no se registró una fila nueva
            if (ps.executeUpdate() == 0) {
                LOG.log(Level.WARNING, "No se pudo insertar al domicilio: {0}", domicilio);
                throw new PersistenciaException("No se pudo agregar al domicilio");
            }
            
            //Le pone la id generada en la BD al objeto en java
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    domicilio.setId(rs.getInt(1));
                } else {
                    throw new PersistenciaException("Error al obtener el ID generado del nuevo domicilio");
                }
            }
            
            //Regresa el domicilio
            LOG.log(Level.INFO, "Domicilio insertado con éxito. ID: {0}", domicilio.getId());
            return domicilio;
            
        //Excepción si hay un error al conectarse con la BD
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, "Error de SQL al agregar domicilio", ex);
            throw new PersistenciaException("Error al agregar domicilio", ex);
        }
    }
    
    
    /**
     * Ejecuta UPDATE sobre la tabla domicilios_clientes
     * Debe tenerse la ID de la fila en concreto
     * @param domicilio
     * @return
     * @throws PersistenciaException 
     */
    public Domicilio actualizarDomicilio(Domicilio domicilio) throws PersistenciaException {
        
        //Comando para interactuar con la BD
        String comando = """
                            UPDATE domicilios_cliente
                            SET calle = ?, numero = ?, colonia = ?, codigo_postal = ?
                            WHERE id_domicilio = ?
                            """;
        
        //Try with resources
        try (Connection conn = this.conexionBD.crearConexion(); PreparedStatement ps = conn.prepareStatement(comando)) {

            //Asigna cada valor del domicilio ("?") una posición en la consulta
            ps.setString(1, domicilio.getCalle());
            ps.setString(2, domicilio.getNumero());
            ps.setString(3, domicilio.getColonia());
            ps.setString(4, domicilio.getCodigoPostal());
            
            //Asigna el valor de la ID mientras no sea null, de lo contrario java no admite el wrapper con el setInt
            if (domicilio.getId() == null) {
                throw new PersistenciaException("No se puede actualizar domicilio sin ID");
            }
            ps.setInt(5, domicilio.getId());

            //Excepción si no se actualizó ninguna fila
            if (ps.executeUpdate() == 0) {
                throw new PersistenciaException("No se pudo actualizar: el ID proporcionado no existe");
            }
            
            //Regresa el domicilio
            LOG.log(Level.INFO, "Domicilio actualizado con éxito. ID: {0}", domicilio.getId());
            return domicilio;
            
        //Excepción si hay un error al conectarse con la BD
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, "Error de SQL al actualizar domicilio", ex);
            throw new PersistenciaException("Error al actualizar domicilio", ex);
        }
    }
}