package Persistencia.DAO;
import Persistencia.Conexion.IConexionBD;
import Persistencia.Dominio.Pizza;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistencia.excepciones.PersistenciaException;

/**
 *
 */
public class PizzaDAO implements IPizzaDAO{
    
    //Conexión a la BD
    private final IConexionBD conexionBD;
    
    //Logger para registrar sucesos
    private static final Logger LOG = Logger.getLogger(DomicilioDAO.class.getName());
    
    //Nombre de variable
    private static final String CLASE = "la pizza";
    
    
    
    /**
     * Constructor que inyecta la conexión de la BD
     * @param conexionBD 
     */
    public PizzaDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }
    
    
    
    /**
     * Extrae la pizza
     * @param rs
     * @return
     * @throws SQLException 
     */
    private Pizza extraerPizza(ResultSet rs) throws SQLException {
        Pizza pizza = new Pizza();
        pizza.setId(rs.getInt("id_pizza"));
        pizza.setNombre(rs.getString("nombre"));
        pizza.setDescripcion(rs.getString("descripcion"));
        pizza.setPrecio(rs.getDouble("precio"));
        pizza.setEstado(rs.getString("estado"));
        return pizza;
    }
    
    
    
    /**
     * Ejecuta SELECT sobre todas las pizzas de catálogo
     * @return
     * @throws PersistenciaException 
     */
    @Override
    public ArrayList<Pizza> consultarPizzas() throws PersistenciaException {
        ArrayList<Pizza> pizzas = new ArrayList<>();
        
        //Comando para interactuar con la BD
        String comando = """
                            SELECT id_pizza, nombre, descripcion, precio, estado
                            FROM pizzas
                         """;
        
        //Try with resources
        try (Connection conn = this.conexionBD.crearConexion(); PreparedStatement ps = conn.prepareStatement(comando)) {
            try (ResultSet rs = ps.executeQuery()) {
                
                //Crea y agrega todos laz pizzas coincidentes a la lista
                while (rs.next()) {
                    pizzas.add(extraerPizza(rs));
                }
               
               //Regresa las pizzas
               return pizzas;
            }
            
        //Excepción si hay un error al conectarse con la BD
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, "Error de SQL al consultar " + CLASE, ex);
            throw new PersistenciaException("Error al consultar " + CLASE, ex);
        }
    }
}