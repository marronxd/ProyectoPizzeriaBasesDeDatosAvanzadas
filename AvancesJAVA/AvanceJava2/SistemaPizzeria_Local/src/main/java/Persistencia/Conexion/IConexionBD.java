package Persistencia.Conexion;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Interfaz de la conexión a la base de datos
 */
public interface IConexionBD {
    
    /**
     * Establece la conexión independiente de los métodos DAO
     * @return una conexión
     * @throws SQLException 
     */
    public Connection crearConexion() throws SQLException;
}