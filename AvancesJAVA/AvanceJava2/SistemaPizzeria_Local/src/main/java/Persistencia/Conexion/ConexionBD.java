package Persistencia.Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 */
public class ConexionBD implements IConexionBD{
    
    //Declara los datos para conectar a la base de datos
    private final String CADENA_CONEXION = "jdbc:mysql://localhost:3306/soporte";
    private final String USUARIO = "root";
    private final String CONTRASENIA = "admin";
    
    /**
     * Establece la conexión independiente de los métodos DAO
     * @return una conexión
     * @throws SQLException 
     */
    public Connection crearConexion() throws SQLException {
        return DriverManager.getConnection(CADENA_CONEXION, USUARIO, CONTRASENIA);
    }
}