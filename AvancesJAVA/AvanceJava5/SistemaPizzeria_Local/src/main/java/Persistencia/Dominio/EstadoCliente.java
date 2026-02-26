package Persistencia.Dominio;

/**
 * Los estados del cliente dentro del sistema
 */
public enum EstadoCliente {
    ACTIVO("Activo"),
    INACTIVO("Inactivo");

    private final String valorBD;

    EstadoCliente(String valorBD){
        this.valorBD = valorBD;
    }

    public String getValorBD(){
        return valorBD;
    }
}