package Persistencia.fabrica;
import Persistencia.Conexion.ConexionBD;
import Persistencia.Conexion.IConexionBD;
import Persistencia.DAO.ClienteDAO;
import Persistencia.DAO.DomicilioDAO;
import Persistencia.DAO.IClienteDAO;
import Persistencia.DAO.IDomicilioDAO;
import Persistencia.DAO.IPizzaDAO;
import Persistencia.DAO.ITelefonoDAO;
import Persistencia.DAO.PizzaDAO;
import Persistencia.DAO.TelefonoDAO;

/**
 * Fabrica para DAO
 */
public class FabricaDAO {
    
    //Conexión a la BD
    private final static IConexionBD conexion = new ConexionBD();
    
    /**
     * Domicilio DAO
     * @return 
     */
    public static IDomicilioDAO obtenerDomicilioDAO(){
        IDomicilioDAO domicilioDAO = new DomicilioDAO(conexion);
        return domicilioDAO;
    }
    
    /**
     * Cliente DAO
     * @return 
     */
    public static IClienteDAO obtenerClienteDAO(){
        IClienteDAO clienteDAO = new ClienteDAO(conexion);
        return clienteDAO;
    }
    
    /**
     * Telefono DAO
     * @return 
     */
    public static ITelefonoDAO obtenerTelefonoDAO(){
        ITelefonoDAO telefonoDAO = new TelefonoDAO(conexion);
        return telefonoDAO;
    }
    
    /**
     * Pizza DAO
     * @return 
     */
    public static IPizzaDAO obtenerPizzaDAO(){
        IPizzaDAO pizzaDAO = new PizzaDAO(conexion);
        return pizzaDAO;
    } 
}