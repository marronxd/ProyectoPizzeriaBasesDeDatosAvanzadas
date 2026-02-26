package Negocio.fabrica;
import Negocio.BO.ClienteBO;
import Negocio.BO.DomicilioBO;
import Negocio.BO.IClienteBO;
import Negocio.BO.IDomicilioBO;
import Negocio.BO.IPizzaBO;
import Negocio.BO.ITelefonoBO;
import Negocio.BO.PizzaBO;
import Negocio.BO.TelefonoBO;
import Persistencia.DAO.IClienteDAO;
import Persistencia.DAO.IDomicilioDAO;
import Persistencia.DAO.IPizzaDAO;
import Persistencia.DAO.ITelefonoDAO;
import Persistencia.fabrica.FabricaDAO;

/**
 * Fabrica para desacoplar
 */
public class FabricaBO {
    
    //Para DomicilioDAO
    private static final IDomicilioDAO domicilioDAO = FabricaDAO.obtenerDomicilioDAO();
    public static IDomicilioBO domicilioBO(){
        return new DomicilioBO(domicilioDAO);
    }
    
    
    //Para ClienteDAO
    private static final IClienteDAO clienteDAO = FabricaDAO.obtenerClienteDAO();
    public static IClienteBO clienteBO(){
        return new ClienteBO(clienteDAO);
    }

    //Para TelefonoDAO
    private static final ITelefonoDAO telefonoDAO = FabricaDAO.obtenerTelefonoDAO();
    public static ITelefonoBO telefonoBO(){
        return new TelefonoBO(telefonoDAO);
    }

    //Para PizzaDAO
    private static final IPizzaDAO pizzaDAO = FabricaDAO.obtenerPizzaDAO();
    public static IPizzaBO pizzaBO(){
        return new PizzaBO(pizzaDAO);
    }
}
