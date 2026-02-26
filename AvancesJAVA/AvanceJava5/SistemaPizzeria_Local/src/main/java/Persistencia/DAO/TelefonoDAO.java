package Persistencia.DAO;
import Persistencia.Conexion.IConexionBD;
import Persistencia.Dominio.Telefono;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistencia.excepciones.PersistenciaException;

/**
 * DAO que maneja la lógica para manipular la BD de los teléfonos
 * No se encarga de reglas de negocio, solo de persistencia
 */
public class TelefonoDAO implements ITelefonoDAO{
    
    //Conexión a la BD
    private final IConexionBD conexionBD;
    
    //Logger para registrar sucesos
    private static final Logger LOG = Logger.getLogger(TelefonoDAO.class.getName());
    
    //Constante del nombre de la entidad que maneja el archivo para centralizar LOGs
    private static final String CLASE = "el teléfono";
    
    
    
    /**
     * Constructor que inyecta la conexión de la BD
     * @param conexionBD 
     */
    public TelefonoDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }
    
    
    /**
     * Mapea una fila en memoria a un objeto de la clase Telefono
     * Este método no es parte de la interfaz
     * @param rs
     * @return telefono creado
     * @throws SQLException 
     */
    private Telefono extraerTelefono(ResultSet rs) throws SQLException {
        Telefono telefono = new Telefono();
        telefono.setId(rs.getInt("id_telefono"));
        telefono.setNumero(rs.getString("numero"));
        telefono.setEtiqueta(rs.getString("etiqueta"));
        return telefono; 
    }
    
    
    
    /**
     * Ejecuta SELECT sobre la tabla telefonos_clientes
     * Usa la ID del teléfono para filtrar
     * Guarda los telefonos en una lista DTO para dejar atributos intactos
     * @param idTelefono
     * @return lista de teléfonos del cliente
     * @throws PersistenciaException 
     */
    @Override
    public Telefono consultarTelefono(int idTelefono) throws PersistenciaException {
 
        //Comando para interactuar con la BD
        String comando = """
                            SELECT id_telefono, numero, etiqueta
                            FROM telefonos_clientes
                            WHERE id_telefono = ?
                         """;
        
        //Try with resources
        try (Connection conn = this.conexionBD.crearConexion(); PreparedStatement ps = conn.prepareStatement(comando)) {
            ps.setInt(1, idTelefono);
            try (ResultSet rs = ps.executeQuery()) {
                
                //Si no existe esa ID
                if (!rs.next()) {
                    LOG.log(Level.WARNING, "No se encontró " + CLASE + " relacionado a ID {0}", idTelefono);
                    throw new PersistenciaException("No existe un teléfono de un cliente con ese ID");
                }
               
               //Regresa el teléfono
               return extraerTelefono(rs);
            }

        //Excepción si hay un error al conectarse con la BD
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, "Error de SQL al consultar " + CLASE, ex);
            throw new PersistenciaException("Error al consultar " + CLASE, ex);
        }
    }
    
    
    
    /**
     * Ejecuta SELECT sobre la tabla telefonos_clientes
     * Usa la ID del cliente para filtrar
     * Guarda los telefonos en una lista DTO para dejar atributos intactos
     * @param idCliente
     * @return lista de teléfonos del cliente
     * @throws PersistenciaException 
     */
    @Override
    public ArrayList<Telefono> consultarTelefonos(int idCliente) throws PersistenciaException {
        ArrayList<Telefono> telefonos = new ArrayList<>();
        
        //Comando para interactuar con la BD
        String comando = """
                            SELECT id_telefono, numero, etiqueta
                            FROM telefonos_clientes
                            WHERE id_usuario = ?
                         """;
        
        //Try with resources
        try (Connection conn = this.conexionBD.crearConexion(); PreparedStatement ps = conn.prepareStatement(comando)) {
            ps.setInt(1, idCliente);
            try (ResultSet rs = ps.executeQuery()) {
                
                //Crea y agrega todos los teléfonos coincidentes a la lista
                while (rs.next()) {
                    telefonos.add(extraerTelefono(rs));
                }
                
                //Regresa la lista de teléfonos
                return telefonos;
            }

        //Excepción si hay un error al conectarse con la BD
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, "Error de SQL al consultar telefonos", ex);
            throw new PersistenciaException("Error al consultar telefonos", ex);
        }
    }
    
    
    
    /**
     * Ejecuta INSERT sobre la tabla telefonos_clientes
     * Necesita la ID del cliente para asignárselo
     * @param telefono
     * @param idCliente
     * @return Telefono agregado
     * @throws PersistenciaException 
     */
    @Override
    public Telefono agregarTelefono(Telefono telefono, int idCliente) throws PersistenciaException {
        
        //Comando para interactuar con la BD
        String comando = """
                            INSERT INTO telefonos_clientes (numero, etiqueta, id_cliente)
                            VALUES (?,?,?)
                         """;
        
        //Try with resources
        try (Connection conn = this.conexionBD.crearConexion(); PreparedStatement ps = conn.prepareStatement(comando, Statement.RETURN_GENERATED_KEYS)) { 
            
            //Asigna cada valor del domicilio ("?") una posición en la consulta
            ps.setString(1, telefono.getNumero());
            ps.setString(2, telefono.getEtiqueta());
            ps.setInt(3, idCliente);
            
            //Excepción si no se registró una fila nueva
            if (ps.executeUpdate() == 0) {
                LOG.log(Level.WARNING, "No se pudo insertar " + CLASE + ": {0}", telefono);
                throw new PersistenciaException("No se pudo agregar " + CLASE);
            }
            
            //Le pone la ID generada en la BD al objeto en java
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    telefono.setId(rs.getInt(1));
                } else {
                    throw new PersistenciaException("Error al obtener el ID generado de " + CLASE + " nuevo");
                }
            }
            
            //Regresa el teléfono
            LOG.log(Level.INFO, "Teléfono insertado con éxito. ID: {0}", telefono.getId());
            return telefono;
            
        //Excepción si hay un error al conectarse con la BD
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, "Error de SQL al agregar " + CLASE, ex);
            throw new PersistenciaException("Error al agregar teléfono " + CLASE, ex);
        }
    }

    
   
    /**
     * Ejecuta UPDATE sobre la tabla telefonos_clientes
     * Debe tenerse la ID de la fila en concreto
     * @param telefono
     * 
     * 
     * @return el teléfono actualizado
     * @throws PersistenciaException 
     */
    @Override
    public Telefono actualizarTelefono(Telefono telefono) throws PersistenciaException {
        
        //Comando para interactuar con la BD
        String comando = """
                            UPDATE telefonos_clientes
                            SET numero = ?, etiqueta = ?
                            WHERE id_telefono = ?
                         """;
        
        //Try with resources
        try (Connection conn = this.conexionBD.crearConexion(); PreparedStatement ps = conn.prepareStatement(comando)) {

            //Asigna cada valor del teléfono ("?") una posición en la consulta
            ps.setString(1, telefono.getNumero());
            ps.setString(2, telefono.getEtiqueta());
            
            //Asigna el valor de la ID mientras no sea null, de lo contrario java no admite el wrapper con el setInt
            if (telefono.getId() == null) {
                throw new PersistenciaException("No se puede actualizar + " + CLASE + " sin ID");
            }
            ps.setInt(3, telefono.getId());

            //Excepción si no se actualizó ninguna fila
            if (ps.executeUpdate() == 0) {
                throw new PersistenciaException("No se pudo actualizar " + CLASE + ": el ID proporcionado no existe");
            }
            
            //Regresa el teléfono
            LOG.log(Level.INFO, CLASE + " fue actualizado con éxito. ID: {0}", telefono.getId());
            return telefono;
            
        //Excepción si hay un error al conectarse con la BD
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, "Error de SQL al actualizar " + CLASE, ex);
            throw new PersistenciaException("Error al actualizar " + CLASE, ex);
        }
    }
}